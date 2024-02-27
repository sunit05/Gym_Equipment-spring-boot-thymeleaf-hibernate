package com.ge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ge.dto.Favourite;

@Repository
public interface FavouriteRepository extends JpaRepository<Favourite, Long> {

}
