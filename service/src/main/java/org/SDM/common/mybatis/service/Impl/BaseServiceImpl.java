package org.SDM.common.mybatis.service.Impl;

import org.SDM.common.mybatis.exception.MessageRuntimeException;
import org.SDM.common.mybatis.model.SaveModel;
import org.SDM.common.mybatis.model.TabPage;
import org.SDM.common.mybatis.page.PageUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.SDM.common.mybatis.domain.Entity;
import org.SDM.common.mybatis.service.BaseService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


public abstract class BaseServiceImpl<T extends Entity> implements BaseService<T> {

    private static final Logger log = LoggerFactory.getLogger(BaseServiceImpl.class.getName());

    public TabPage<T> selectForPage(Map<String, Object> params){
        TabPage<T> tabPage;
        try{
            tabPage = PageUtils.selectForPage(params, new PageUtils.SelectCallBack<T>() {
                    @Override
                    public List<T> query(Map<String, Object> params) throws Exception {
                        return findAll(params);
                    }
                }
            );
        } catch (Exception e){
            log.error("Searching records failed", e);
            throw new MessageRuntimeException("Searching records failed",e ,params);
        }
        return tabPage;
    }

    public List<T> findAll(Map<String, Object> param){
        return getMapper().findAll(param);
    }

    @Override
    public T selectByPK(Object id){
        return getMapper().selectByPK(id);
    }

    @Override
    public T selectByPropertys(Map<String, Object> params){
        return getMapper().selectByPropertys(params);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public SaveModel<T> batchSaveOrUpdate(SaveModel<T> data){
        if (data != null){
            delete(data.getDels());
            batchSaveOrUpdate(data.getEdits());
            batchSaveOrUpdate(data.getAdds());
        }
        return data;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public T saveOrUpdate(T entity){
        if (StringUtils.isNotBlank(entity.getId())){
            update(entity);
        } else {
            insert(entity);
        }
        return entity;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public List<T> batchSaveOrUpdate(List<T> entitys){
        if (entitys != null){
            for (T e : entitys){
                saveOrUpdate(e);
            }
        }
        return entitys;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public Integer insert(T entity){
        //entity.setWhoForInsert(UserinfoUtils.getUserId());
        return getMapper().insert(entity);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public Integer update(T entity){
        //entity.setWhoForUpdate(UserinfoUtils.getUserId());
        return getMapper().update(entity);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public void delete(List<T> entitys){
        if(entitys != null){
            for (T e : entitys){
                delete(e);
            }
        }
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public Integer delete(T entity){
        return getMapper().delete(entity);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public Integer deleteByIds(List<Object> ids){
        return getMapper().deleteByIds(ids);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
    public Integer deleteByParams(Map<String, Object> param){
        return getMapper().deleteByParams(param);
    }
}
