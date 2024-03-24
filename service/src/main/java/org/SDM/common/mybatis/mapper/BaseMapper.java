package org.SDM.common.mybatis.mapper;

import java.util.List;
import java.util.Map;
import java.util.Observable;

public interface BaseMapper<T> {

    public Integer selectCount(Map<String, Object> param);

    public T selectByPK(Object id);

    public T selectByPropertys(Map<String, Object> params);

    public Integer delete(T entity);

    public Integer deleteByParams(Map<String, Object> param);

    public Integer deleteByIds(List<Object> ids);

    public Integer insert(T entity);

    public Integer update(T entity);

    public List<T> findAll(Map<String, Object> param);
}
