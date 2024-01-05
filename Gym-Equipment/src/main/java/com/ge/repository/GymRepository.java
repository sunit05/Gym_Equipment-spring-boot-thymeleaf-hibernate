package com.ge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ge.dto.Admin;

@Repository
public interface GymRepository extends JpaRepository<Admin, Long> {

}
