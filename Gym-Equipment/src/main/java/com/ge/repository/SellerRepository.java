package com.ge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ge.dto.Seller;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {

}
