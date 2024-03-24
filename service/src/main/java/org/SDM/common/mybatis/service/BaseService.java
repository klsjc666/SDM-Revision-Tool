package org.SDM.common.mybatis.service;

import org.SDM.common.mybatis.domain.Entity;
import org.SDM.common.mybatis.mapper.BaseMapper;
import org.SDM.common.mybatis.model.SaveModel;
import org.SDM.common.mybatis.model.TabPage;

import java.util.List;
import java.util.Map;

public interface BaseService<T extends Entity> {

    public BaseMapper<T> getMapper();

    public TabPage<T> selectForPage(Map<String, Object> params);

    public T selectByPK(Object id);

    public T selectByPropertys(Map<String, Object> params);

    public Integer insert(T entity);

    public Integer update(T entity);

    public List<T> batchSaveOrUpdate(List<T> entitys);

    public T saveOrUpdate(T entity);

    public SaveModel<T> batchSaveOrUpdate(SaveModel<T> datas);


    public void delete(List<T> entitys);
    public Integer delete(T entity);

    public Integer deleteByParams(Map<String, Object> params);

    public Integer deleteByIds(List<Object> ids);

    public List<T> findAll(Map<String, Object> params);
}
