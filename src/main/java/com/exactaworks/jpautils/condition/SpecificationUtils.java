package com.exactaworks.jpautils.condition;

import org.springframework.data.jpa.domain.Specification;

public class SpecificationUtils {

    public static <T> Specification<T> columnIsEquals(String column, Object value) {
        if (value == null) {
            return null;
        }

        return (root, query, builder) -> builder.equal(root.get(column), value);
    }

    public static <T> Specification<T> columnNotEquals(String column, Object value) {
        if (value == null) {
            return null;
        }

        return (root, query, builder) -> builder.notEqual(root.get(column), value);
    }

    public static <T> Specification<T> columnIsNull(String column) {
        return (root, query, builder) -> builder.isNull(root.get(column));
    }

    public static <T> Specification<T> columnIsNotNull(String column) {
        return (root, query, builder) -> builder.isNotNull(root.get(column));
    }

    public static <T> Specification<T> columnIsTrue(String column) {
        return (root, query, builder) -> builder.isTrue(root.get(column));
    }

    public static <T> Specification<T> columnIsFalse(String column) {
        return (root, query, builder) -> builder.isFalse(root.get(column));
    }

}
