package com.flash.cards.core.base;

/**
 * @author lizheng
 * @since 2018/5/11 14:08
 **/
public class QueryFilter {
    public String field;
    public Object value;
    public QueryMatcher queryMatcher;
    QueryFilter(String field, Object value, QueryMatcher queryMatcher) {
        this.field = field;
        this.value = value;
        this.queryMatcher = queryMatcher;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public QueryMatcher getQueryMatcher() {
        return queryMatcher;
    }

    public void setQueryMatcher(QueryMatcher queryMatcher) {
        this.queryMatcher = queryMatcher;
    }
}
