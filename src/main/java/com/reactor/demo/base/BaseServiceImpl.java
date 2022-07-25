package com.reactor.demo.base;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.Collection;

/**
 * @author liumeifang1052
 * @date 2021/10/25
 */
public class BaseServiceImpl<M extends BaseMapper<T>, T extends BaseEntity> extends ServiceImpl<M, T>
        implements BaseService<T> {

    @Override
    public boolean save(T entity) {
        entity.setCreateTime(DateUtil.date());
        entity.setUpdateTime(DateUtil.date());
        return super.save(entity);
    }

    @Override
    public boolean updateById(T entity) {
        entity.setUpdateTime(DateUtil.date());
        return super.updateById(entity);
    }

    @Override
    public boolean saveBatch(Collection<T> entityList) {
        for (T entity : entityList) {
            entity.setCreateTime(DateUtil.date());
            entity.setUpdateTime(DateUtil.date());
        }
        return super.saveBatch(entityList);
    }

    @Override
    public boolean update(Wrapper<T> updateWrapper) {
        ((LambdaUpdateWrapper<T>) updateWrapper).set(T::getUpdateTime, DateUtil.now());
        return super.update(updateWrapper);
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<T> entityList) {
        for (T entity : entityList) {
            entity.setCreateTime(DateUtil.date());
            entity.setUpdateTime(DateUtil.date());
        }
        return super.saveOrUpdateBatch(entityList);
    }

}
