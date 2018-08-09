package com.flash.cards.core.base;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lizheng
 * @since 2018/5/11 15:16
 **/
public class QueryFilterCreator {
    public static Map<String, QueryFilter> parse(Map<String, Object> searchParams) {
        Map<String, QueryFilter> filters = new HashMap<>();

        for (Map.Entry<String, Object> entry : searchParams.entrySet()) {
            // 过滤掉空值
            String key = entry.getKey();
            Object value = entry.getValue();
            if ((value instanceof String) && (StringUtils.isBlank((String) value))) continue;

            // 拆分operator与filedAttribute
            String[] names = StringUtils.split(key, "_");
            if (names.length != 2) throw new IllegalArgumentException(key + " is not a valid search filter name");
            String filedName = names[1];
            QueryMatcher operator = QueryMatcher.valueOf(names[0]);

            // 创建searchFilter
            if(value==null || "".equals(value)) continue;
            Object v = value;
            switch (operator) {
                case EQ4Char:
                    v = ((String)value).charAt(0);
                    break;
                case NE4Int:;
                case EQ4Int:
                    v = Integer.parseInt((String)value);
                    break;
                default:
                    break;
            }
            QueryFilter filter = new QueryFilter(filedName, v, operator);
            filters.put(key, filter);
        }

        return filters;
    }
}
