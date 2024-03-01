package com.company.specification;

import java.util.Date;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.company.entity.Category;

import com.company.form.CategoryFilterForm;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

public class CategorySpecification {

	@SuppressWarnings("deprecation")
	public static Specification<Category> buildWhere(CategoryFilterForm filterForm) {

		Specification<Category> where = null;
		
		if (filterForm == null) return where;

		if (!StringUtils.isEmpty(filterForm.getQ())) {
			String search = filterForm.getQ();
			search = search.trim();
			CustomSpecification nameSpecification = new CustomSpecification("categoryName", search);
			
			
			where = Specification
						.where(nameSpecification);
		}
		
		return where;
	}

	@SuppressWarnings("serial")
	@RequiredArgsConstructor
	static class CustomSpecification implements Specification<Category> {

		@NonNull
		private String field;

		@NonNull
		private Object value;

		@Override
		public Predicate toPredicate(
				Root<Category> root, 
				CriteriaQuery<?> query, 
				CriteriaBuilder criteriaBuilder) {

			if (field.equalsIgnoreCase("categoryName")) {
				return criteriaBuilder.like(root.get("name"), "%" + value.toString() + "%");
			}
			

			return null;
		}
	}

}
