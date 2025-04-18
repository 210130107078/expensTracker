package com.grownited.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.grownited.entity.VendorEntity;

@Repository
public interface VendorRepository extends JpaRepository<VendorEntity, Integer> {

	@Query(value = "select v.* , u.first_name , u.last_name , u.email , u.contact_num from users u , vendor v where v.user_id=u.user_id",nativeQuery = true)
 	List<Object[]>	getAll();
 	
 	@Query(value = "select v.* , u.first_name , u.last_name , u.email , u.contact_num from users u , vendor v where v.user_id=u.user_id",nativeQuery = true)
 	List<Object[]> getByVendorId(Integer vendorId);
 	}

