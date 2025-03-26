package com.grownited.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grownited.entity.IncomeEntity;

@Repository
public interface IncomeRepository extends JpaRepository<IncomeEntity, Integer> {

	@Query(value = "select i.* , u.first_name , u.last_name , u.email , u.contact_num from users u , income i where i.user_id=u.user_id",nativeQuery = true)
 	List<Object[]>	getAll();
	
}
