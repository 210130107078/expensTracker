package com.grownited.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grownited.entity.ExpenseEntity;

@Repository
public interface ExpenseRepository extends JpaRepository<ExpenseEntity, Integer>{

	@Query(value = "select e.* , u.first_name , u.last_name , u.email , u.contact_num from users u , expense e where e.user_id=u.user_id",nativeQuery = true)
 	List<Object[]>	getAll();
 	
 	@Query(value = "select e.* , u.first_name , u.last_name , u.email , u.contact_num from users u , expense e where e.user_id=u.user_id",nativeQuery = true)
 	List<Object[]> getByExpenseId(Integer expenseId);
 	}

