package com.ge.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ge.dto.Favourite;
import com.ge.repository.FavouriteRepository;

@Component
public class FavouriteDao {
	
	@Autowired
	FavouriteRepository favouriteRepository;
	
	public List<Favourite> getAllFavourites() {
		return favouriteRepository.findAll();
	}

	public Favourite saveFavourite(Favourite favourite) {
		return favouriteRepository.save(favourite);
	}

	public void deleteFavouriteById(long id) {
		favouriteRepository.deleteById(id);
	}

	public void updateFavourite(Favourite favourite) {
		long id = favourite.getId();
		Favourite favourite2 = favouriteRepository.findById(id).get();
		favourite2.setCustomer(favourite.getCustomer());
		favourite2.setProducts(favourite.getProducts());
	}

	public Favourite getFavouriteById(long id) {
		return favouriteRepository.findById(id).get();
	}	
}
