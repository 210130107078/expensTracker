package com.grownited.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grownited.entity.CategoryEntity;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {

	
	@Query(value = "select c.* , u.first_name , u.last_name , u.email , u.contact_num from users u , category c where c.user_id=u.user_id",nativeQuery = true)
 	List<Object[]>	getAll();
 	
 	@Query(value = "select c.* , u.first_name , u.last_name , u.email , u.contact_num from users u , category c where c.user_id=u.user_id",nativeQuery = true)
 	List<Object[]> getByCategoryId(Integer categoryId);
 	
}
