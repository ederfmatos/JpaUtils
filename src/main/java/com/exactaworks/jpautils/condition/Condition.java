package com.exactaworks.jpautils.condition;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;

class Condition<T> {

    private final Predicate.BooleanOperator operator;
    private final Specification<T> specification;

    public Condition(Predicate.BooleanOperator operator, Specification<T> specification) {
        this.operator = operator;
        this.specification = specification;
    }

    public Predicate.BooleanOperator getOperator() {
        return operator;
    }

    public Specification<T> getSpecification() {
        return specification;
    }

}
