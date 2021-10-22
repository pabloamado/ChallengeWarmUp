package com.alkemy.challenge.model.Specification;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import com.alkemy.challenge.model.Category;
import com.alkemy.challenge.model.Post;

@Component
public class PostSpecification {

	public Specification<Post> getByFilters(String tittle, Long categoryId) {
        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();
       
            if (StringUtils.hasLength(tittle)) {
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("tittle")),
                                "%" + tittle.toLowerCase() + "%"
                        )
                );
            }

            if (categoryId!=null) {
                Join<Category, Post> join = root.join("category", JoinType.INNER);
                Expression<String> id = join.get("cId");
                predicates.add(id.in(categoryId));
            }
            
            query.distinct(true);

            String orderByField = "creationDate";
            query.orderBy(criteriaBuilder.desc(root.get(orderByField)));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));

        };
    
	}
	
}
