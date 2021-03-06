
package com.goat.tiny.mybatis.session;

import java.util.List;


public interface SqlSession {


    <T> T selectOne(String statementId, Object parameter);

    <E> List<E> selectList(String statementId, Object parameter);

    void update(String statementId, Object parameter);

    void insert(String statementId, Object parameter);

    <T> T getMapper(Class<T> paramClass);

    Configuration getConfiguration();
}
