package com.exactaworks.jpautils.condition;

import org.springframework.data.jpa.domain.Specification;

public class BasicSpecification {

    public static <T> Specification<T> columnIsEquals(String column, Object value) {
        return (root, query, builder) -> builder.equal(root.get(column), value);
    }

}
