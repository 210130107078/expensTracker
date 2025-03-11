package com.grownited.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grownited.dto.SubcategoryDto;
import com.grownited.entity.SubcategoryEntity;

@Repository
public interface SubcategoryRepository extends JpaRepository<SubcategoryEntity, Integer> {

	
	@Query(value = "select s.*,c.title from subcategory s,category c where c.category_id = s.category_id",nativeQuery = true)
	List<SubcategoryDto> getAll();
}
