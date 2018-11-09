package com.goat.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * Created by 64274 on 2018/8/21.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/8/21---20:51
 */

@Mapper // 标志为 Mybatis 的 Mapper
public interface BaseDao {
    @Select("SELECT * FROM emp")
    List<Map> findById(String id);
}
