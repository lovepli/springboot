package com.goat.service;

import com.goat.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/*
* 其实对于 幻读, MySQL的InnoDB引擎默认的RR级别已经通过MVCC自动帮我们解决了, 所以该级别下, 你也模拟不出幻读的场景;
* 退回到 RC 隔离级别的话, 你又容易把幻读和不可重复读搞混淆, 所以这可能就是比较头痛的点吧!
* 理论上RR级别是无法解决幻读的问题, 但是由于InnoDB引擎的RR级别还使用了MVCC, 所以也就避免了幻读的出现!
* */
/**
 * Created by 64274 on 2019/5/7.
 * 在 READ_COMMITTED  情况下：
 先  http://localhost:8331/phantom/test2   触发线程1 查询操作后  线程1 进入 8秒睡眠  eg：查出8 条
 再  http://localhost:8331/phantom/test22  触发线程2 插入操作  eg：插入1条 并提交事务  此时 数据库表中 实际有9条记录了
 再  8秒 后 线程1 恢复睡眠  继续查询操作  发现 查询出了9条！！！ 产生了幻读。。。。

 REPEATABLE_READ ------------------------------- 没有产生幻读
     线程1  第一次查询出记录数为：9
     线程2 插入记录数为：1
     线程1  第二次查询出记录数为：9

 READ_COMMITTED ------------------------------- 产生幻读
     线程1  第一次查询出记录数为：8
     线程2 插入记录数为：1
     线程1  第二次查询出记录数为：9

 SERIALIZABLE ------------------------------- 没有产生幻读，但是执行顺序都变了
     线程1  第一次查询出记录数为：7
     线程1  第二次查询出记录数为：7
     线程2 插入记录数为：1

 * @ date 2019/5/7---13:29
 */
@Service
public class PhantomServiceImpl extends CommonServiceImpl {

    @Autowired
    public TransactionUtil transactionUtil;

    @Transactional(isolation = Isolation.REPEATABLE_READ) //  设置事务隔离级别为：可重复读
    public void select() throws InterruptedException {
        test();
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ) //  设置事务隔离级别为：可重复读
    public int insert(){
        int update = jdbcTemplate.update("insert book(book_name,price) values ('test',30)");//
        System.out.println("线程2 插入记录数为：" + update);
        return update;
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ) //  设置事务隔离级别为：可重复读
    public void selectOn11e() throws InterruptedException {
        selectOne();
    }
}

/**
 * T1 ：主事务，检测表中是否有 id 为 1 的记录，没有则插入，这是我们期望的正常业务逻辑。
 * T2 ：干扰事务，目的在于扰乱 T1 的正常的事务执行。
 *
 * 在 RR 隔离级别下，step1、step2 是会正常执行的，step3 则会报错主键冲突，对于 T1 的业务来说是执行失败的，
 * 这里 T1 就是发生了幻读，因为 T1 在 step1 中读取的数据状态并不能支撑后续的业务操作，
 * T1：“见鬼了，我刚才读到的结果应该可以支持我这样操作才对啊，为什么现在不可以”。
 * T1 不敢相信的又执行了 step4，发现和 setp1 读取的结果是一样的（RR下的 MMVC机制）。
 * 此时，幻读无疑已经发生，T1 无论读取多少次，都查不到 id = 1 的记录，
 * 但它的确无法插入这条他通过读取来认定不存在的记录（此数据已被T2插入），对于 T1 来说，它幻读了。
 *
 * 其实 RR 也是可以避免幻读的，通过对 select 操作手动加 行X锁（SELECT ... FOR UPDATE 这也正是 SERIALIZABLE 隔离级别下会隐式为你做的事情），
 * 同时还需要知道，即便当前记录不存在，比如 id = 1 是不存在的，当前事务也会获得一把记录锁（因为InnoDB的行锁锁定的是索引，
 * 故记录实体存在与否没关系，存在就加 行X锁，不存在就加 next-key lock间隙X锁），其他事务则无法插入此索引的记录，故杜绝了幻读。
 * */



/* sos
    如果你一次执行单条查询语句，则没有必要启用事务支持，数据库默认支持SQL执行期间的读一致性；
    如果你一次执行多条查询语句，例如统计查询，报表查询，在这种场景下，多条查询SQL必须保证整体的读一致性，
    否则，在前条SQL查询之后，后条SQL查询之前，数据被其他用户改变，则该次整体的统计查询将会出现读数据不一致的状态，此时，应该启用事务支持。
    但是 启用事务支持后： 两次读取数据是一致的  但是 这是幻读  因为实际数据库表中的数据记录数已经不一样了
    但是 不秦勇事务：两次读取的数据时不一致的，后一次读取的数据时真实的。但是 这两次读取的数据是不一致的。

    以上示例中：
    方式一：  @Transactional
    方式二：  transactionUtil.begin(); 和 transactionUtil.commit()
    两种方式 实现效果是一样的  一个是 手动控制事务  一个是 依赖spring 动态代理 来实现 自动事务
* */

