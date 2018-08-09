package com.flash.cards.core.base;


import com.flash.cards.common.cons.Conf;
import com.flash.cards.utils.StringUtil;
import com.flash.cards.core.base.entity.BaseEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * 构建Specification
 * @author lizheng
 * @since 2018/5/11 13:52
 **/
public class LocalSpecification<E> {
    public static <E extends BaseEntity> Specification<E> buildSpection(final Collection<QueryFilter> queryFilterList) {
        return new Specification<E>() {
            @Override
            public Predicate toPredicate(Root<E> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                List<Predicate> predicates = new ArrayList<>();
                boolean bar = true;
                for (QueryFilter filter : queryFilterList) {
                    String[] names = StringUtil.split(filter.getField(), ".");
                    if (Conf.STR.IS_DELETE.equals(names[0])) {
                        bar = false;
                    }
                    Path expression = root.get(names[0]);
                    for (int i = 1; i < names.length; i++) expression = expression.get(names[i]);
                    switch (filter.getQueryMatcher()) {
                        case EQ4Char:
                            predicates.add(builder.equal(expression,filter.value));
                            break;
                        case EQ4Int:;
                        case EQ:
                            predicates.add(builder.equal(expression, filter.value));
                            break;
                        case LIKE:
                            predicates.add(builder.like(expression, "%" + filter.value + "%"));
                            break;
                        case GT:
                            predicates.add(builder.greaterThan(expression, (Comparable) filter.value));
                            break;
                        case LT:
                            predicates.add(builder.lessThan(expression, (Comparable) filter.value));
                            break;
                        case GTE:
                            predicates.add(builder.greaterThanOrEqualTo(expression, (Comparable) filter.value));
                            break;
                        case LTE:
                            predicates.add(builder.lessThanOrEqualTo(expression, (Comparable) filter.value));
                            break;
                        case NE4Int:
                        case NE:
                            predicates.add(builder.notEqual(expression, filter.value));
                            break;
                        case Between4Long:
                        {
                            Object[] pair = (Object[])filter.value;
                            Long x = (Long)pair[0];
                            Long y = (Long)pair[1];
                            predicates.add(builder.between(expression, x, y));
                            break;
                        }
                        case Between4Integer:
                        {
                            Object[] pair = (Object[])filter.value;
                            Integer x = (Integer)pair[0];
                            Integer y = (Integer)pair[1];
                            predicates.add(builder.between(expression, x, y));
                            break;
                        }
                        case Between4Date:
                        {
                            Object[] pair = (Object[])filter.value;
                            Date x = (Date)pair[0];
                            Date y = (Date)pair[1];
                            predicates.add(builder.between(expression, x, y));
                            break;
                        }
                        case ChildOf:
                            predicates.add(builder.like(expression, filter.value+"%"));
                            break;
                        case IN:
                            predicates.add(builder.in(expression).value(filter.value));
                            break;
                        case IsNull:
                            predicates.add(builder.isNull(expression));
                            break;
                        case  NotNull:
                            predicates.add(builder.isNotNull(expression));
                            break;
                    }
                }
                // 将所有条件用 and 联合起来
                if (bar) {
                    predicates.add(builder.equal(root.get(Conf.STR.IS_DELETE), Conf.IS_DELETE.OK));
                }
                if (!predicates.isEmpty()) return builder.and(predicates.toArray(new Predicate[predicates.size()]));

                return builder.conjunction();
            }
        };
    }
}
