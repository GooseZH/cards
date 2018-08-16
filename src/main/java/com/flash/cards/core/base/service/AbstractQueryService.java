package com.flash.cards.core.base.service;

import com.flash.cards.core.base.BuildPageRequest;
import com.flash.cards.core.base.LocalSpecification;
import com.flash.cards.core.base.QueryFilterCreator;
import com.flash.cards.core.base.dao.BaseDao;
import com.flash.cards.core.base.entity.BaseEntity;
import com.flash.cards.core.paging.LocalPage;
import com.flash.cards.core.paging.PageParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 服务层的默认实现
 * @author lizheng
 * @since 2018/5/11 9:56
 **/
public abstract class AbstractQueryService<T extends BaseDao<E, ID>, E extends BaseEntity, ID extends Serializable> implements BaseQueryService<T, E, ID> {
    @Autowired
    protected T dao;

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    public E findOneById(ID id) {
        return dao.findById(id).get();
    }

    /**
     * 根据对象查询，对象属性为空的直接过滤，匹配不为空的字段
     * 根据MAP匹配，like，大于，小于等
     * 分页查找
     * @param e
     * @return
     */
    public E findOneByBean(E e) {
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withNullHandler(ExampleMatcher.NullHandler.IGNORE) //忽略空值
                .withStringMatcher(ExampleMatcher.StringMatcher.EXACT) // 字符串精确匹配
//                .withMatcher("", GenericPropertyMatchers.startsWith()) // 属性特殊匹配
//                .withIgnorePaths("") // 忽略路径
                .withIgnoreCase(false) // 不忽略大小写
         ;
        Example<E> example = Example.of(e, exampleMatcher);
        e = dao.findOne(example).get();
        return e;
    }

    public List<E> findAll() {
        return dao.findAll();
    }

    public List<E> findAllByBean(E e) {
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withNullHandler(ExampleMatcher.NullHandler.IGNORE) //忽略空值
                .withStringMatcher(ExampleMatcher.StringMatcher.EXACT) // 字符串精确匹配
//                .withMatcher("", GenericPropertyMatchers.startsWith()) // 属性特殊匹配
//                .withIgnorePaths("") // 忽略路径
                .withIgnoreCase(false) // 不忽略大小写
                ;
        Example<E> example = Example.of(e, exampleMatcher);
        List<E> list = dao.findAll(example);
        return list;
    }
    // 按MAP匹配 拼装SQL  已排除逻辑删除的数据
    public E findOneByMap(Map<String, Object> searchMap) {
        Specification<E> spec = LocalSpecification.buildSpection(QueryFilterCreator.parse(searchMap).values());
        return dao.findOne(spec).get();
    }
    // 已排除逻辑删除的数据
    public List<E> findAllByMap(Map<String, Object> searchMap) {
        Specification<E> spec = LocalSpecification.buildSpection(QueryFilterCreator.parse(searchMap).values());
        return dao.findAll(spec);
    }
    // 已排除逻辑删除的数据
    public LocalPage<E> findByPage(PageParams pageParams) {
        Map<String, Object> params = new HashMap<>();
        return findPageByMap(params, pageParams);
    }

    // 分页查找 // 已排除逻辑删除的数据
    public LocalPage<E> findPageByMap(Map<String, Object> searchMap, PageParams pageParams) {
        Specification<E> spec = LocalSpecification.buildSpection(QueryFilterCreator.parse(searchMap).values());
        PageRequest pageRequest = BuildPageRequest.buildPageRequst(pageParams);
        Page<E> page = dao.findAll(spec, pageRequest);
        return getPageModel(page, pageParams);
    }

    private LocalPage getPageModel(Page page, PageParams pageParams) {
        LocalPage<E> resPageModel = new LocalPage<>();
        resPageModel.setItems(page.getContent());
        resPageModel.setTotalPageNum(page.getTotalPages());
        resPageModel.setTotalNum(page.getTotalElements());
        resPageModel.setPageNum(pageParams.getPageNum());
        resPageModel.setPageSize(pageParams.getPageSize());
        resPageModel.setSortBy(pageParams.getSortBy());
        return resPageModel;
    }

}
