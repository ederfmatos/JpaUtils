package com.exactaworks.jpautils.condition;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class JpaSpecificationBuilder<T> {

    private final Specification<T> firstSpecification;
    private final List<Condition<T>> conditions = new ArrayList<>();

    private JpaSpecificationBuilder(Specification<T> firstSpecification) {
        this.firstSpecification = firstSpecification;
    }

    public static <T> JpaSpecificationBuilder<T> newCondition() {
        return JpaSpecificationBuilder.newCondition((root, query, builder) -> builder.conjunction());
    }

    public static <T> JpaSpecificationBuilder<T> newCondition(Specification<T> specification) {
        return new JpaSpecificationBuilder<>(specification);
    }

    public JpaSpecificationBuilder<T> and(Specification<T> specification) {
        if (specification != null) {
            this.conditions.add(new Condition<>(Predicate.BooleanOperator.AND, specification));
        }
        return this;
    }

    public JpaSpecificationBuilder<T> or(Specification<T> specification) {
        if (specification != null) {
            this.conditions.add(new Condition<>(Predicate.BooleanOperator.OR, specification));
        }
        return this;
    }

    public Specification<T> build() {
        Specification<T> specification = firstSpecification;

        for (Condition<T> condition : conditions) {
            specification = condition.getOperator() == Predicate.BooleanOperator.AND
                    ? specification.and(condition.getSpecification())
                    : specification.or(condition.getSpecification());
        }

        return specification;
    }

}
