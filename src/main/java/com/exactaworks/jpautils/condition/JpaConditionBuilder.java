package com.exactaworks.jpautils.condition;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

public class JpaConditionBuilder<T> {

    private final Specification<T> firstSpecification;
    private final List<Condition<T>> conditions = new ArrayList<>();

    private JpaConditionBuilder(Specification<T> firstSpecification) {
        this.firstSpecification = firstSpecification;
    }

    public static <T> JpaConditionBuilder<T> newCondition() {
        return JpaConditionBuilder.newCondition((root, query, builder) -> builder.conjunction());
    }

    public static <T> JpaConditionBuilder<T> newCondition(Specification<T> specification) {
        return new JpaConditionBuilder<>(specification);
    }

    public JpaConditionBuilder<T> and(Specification<T> specification) {
        if (specification != null) {
            this.conditions.add(new Condition<>(Predicate.BooleanOperator.AND, specification));
        }
        return this;
    }

    public JpaConditionBuilder<T> or(Specification<T> specification) {
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
