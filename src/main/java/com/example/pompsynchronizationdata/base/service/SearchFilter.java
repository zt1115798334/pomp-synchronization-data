package com.example.pompsynchronizationdata.base.service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/8/9 11:56
 * description:
 */
public class SearchFilter {
    public enum Operator {
        EQ, LIKE, GT, LT, GTE, LTE, IN
    }

    private String fieldName;
    private Object value;
    private Operator operator;

    public SearchFilter(String fieldName, Operator operator, Object value) {
        this.fieldName = fieldName;
        this.value = value;
        this.operator = operator;
    }

    /**
     * searchParams中key的格式为OPERATOR_FIELDNAME
     */
    public static Map<String, SearchFilter> parse(Map<String, Object> searchParams) {
        Map<String, SearchFilter> filters = Maps.newHashMap();

        for (Map.Entry<String, Object> entry : searchParams.entrySet()) {
            // 过滤掉空值
            String key = entry.getKey();
            Object value = entry.getValue();
            if (StringUtils.isBlank((String) value)) {
                continue;
            }

            // 拆分operator与filedAttribute
            String[] names = StringUtils.split(key, "_");
            if (names.length != 2) {
                throw new IllegalArgumentException(key + " is not a valid search filter name");
            }
            String filedName = names[1];
            Operator operator = Operator.valueOf(names[0]);

            // 创建searchFilter
            SearchFilter filter = new SearchFilter(filedName, operator, value);
            filters.put(key, filter);
        }

        return filters;
    }

    public static <T> Specification<T> bySearchFilter(final Collection<SearchFilter> filters) {
        return (Specification<T>) (root, query, builder) -> {
            if (filters != null && !filters.isEmpty()) {

                List<Predicate> predicates = Lists.newArrayList();
                for (SearchFilter filter : filters) {
                    // nested path translate, 如Task的名为"user.name"的filedName, 转换为Task.user.name属性
                    Object filterValue = filter.value;
                    String[] names = StringUtils.split(filter.fieldName, ".");
                    Path expression = root.get(names[0]);
                    for (int i = 1; i < names.length; i++) {
                        expression = expression.get(names[i]);
                    }
                    // logic operator
                    switch (filter.operator) {
                        case EQ:
                            predicates.add(builder.equal(expression, filterValue));
                            break;
                        case LIKE:
                            predicates.add(builder.like(expression, "%" + filterValue + "%"));
                            break;
                        case GT:
                            predicates.add(builder.greaterThan(expression, (Comparable) filterValue));
                            break;
                        case LT:
                            predicates.add(builder.lessThan(expression, (Comparable) filterValue));
                            break;
                        case GTE:
                            predicates.add(builder.greaterThanOrEqualTo(expression, (Comparable) filterValue));
                            break;
                        case LTE:
                            predicates.add(builder.lessThanOrEqualTo(expression, (Comparable) filterValue));
                            break;
                        case IN:
                            CriteriaBuilder.In in = builder.in(expression);
                            ((List) filterValue).forEach(val -> {
                                in.value(val);
                            });
                            predicates.add(in);
                            break;
                    }
                }
                Predicate[] pre = new Predicate[predicates.size()];
                // 将所有条件用 and 联合起来
                if (!predicates.isEmpty()) {
                    return builder.and(predicates.toArray(pre));
                }
            }

            return builder.conjunction();
        };
    }
}
