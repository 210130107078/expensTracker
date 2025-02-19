package com.grownited.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grownited.entity.GuestEntity;

@Repository
public interface GuestRepository extends JpaRepository<GuestEntity, Integer>{

}
