

/**
 1. 什么是数据?
     存储于内存中代表特定信息的'东东', 本质就是0101二进制
     具有可读和可传递的基本特性
     万物(一切)皆数据, 函数也是数据
     程序中所有操作的目标: 数据
     算术运算
     逻辑运算
     赋值
     调用函数传参

 2. 什么是内存?
     内存条通电后产生的存储空间(临时的)
     产生和死亡: 内存条(集成电路板)==>通电==>产生一定容量的存储空间==>存储各种数据==>断电==>内存全部消失
     内存的空间是临时的, 而硬盘的空间是持久的
     一块内存包含2个数据： 1.指针 2.指针指向的值

     内存分类
     栈: 全局变量, 局部变量 (空间较小)
     堆: 对象 (空间较大)

 3. 什么是变量?
     值可以变化的量, 由变量名与变量值组成
     一个变量对应一块小内存, 变量名用来查找到内存, 变量值就是内存中保存的内容

 4. 内存,数据, 变量三者之间的关系
     内存是一个容器, 用来存储程序运行需要操作的数据
     变量是内存的标识, 我们通过变量找到对应的内存, 进而操作(读/写)内存中的数据
*/


let a = 3  // a保存的3, 基本类型变量
console.log(a)
 a = {} // a保存的是{}的地址值, 引用类型变量
console.log(a)


/**
 关于引用变量赋值问题： 两个指针指向同一个对象
 * 2个引用变量指向同一个对象, 通过一个引用变量修改对象内部数据, 另一个引用变量也看得见
 * 2个引用变量指向同一个对象, 让一个引用变量指向另一个对象, 另一个引用变量还是指向原来的对象
*/

let a1 = {n: 3}
let a2 = a1
a2.n = 4
console.log(a1.n) // 4

let fn1 = (a) => a.n = 5
fn1(a1) // 将 a1赋值给 a  (赋值的是地址) 所以三个指针(a1,a2,a)同时指向同一个obj 其中任何一个更改 都会互相看到
console.log(a2.n, a1.n) //  5 5



// 2个引用变量指向同一个对象,让一个引用变量指向另一个对象, 另一个引用变量还是指向原来的对象
let a3 = {m: 3}
let a4 = a3
a3 = {m: 4}
console.log(a4.m,a3.m) // 3,4
let fn2 = (a) =>a = {m: 5}
fn2(a3)
console.log(a3.m, a4.m)  // 4 3