package com.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.company.entity.Category;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Integer>,JpaSpecificationExecutor<Category>{
	
}