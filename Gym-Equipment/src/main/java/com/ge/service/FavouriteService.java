package com.ge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ge.dao.FavouriteDao;
import com.ge.dto.Favourite;

@Service
public class FavouriteService {

	@Autowired
	FavouriteDao favouriteDao;
	
	public List<Favourite> getAllFavourites(){
		return favouriteDao.getAllFavourites();
	}
	
	public Favourite saveFavourite(Favourite favourite) {
		return favouriteDao.saveFavourite(favourite);
	}
	
	public void updateFavourite(Favourite favourite) {
		favouriteDao.updateFavourite(favourite);
	}

	public void deleteFavouriteById(long id) {
		favouriteDao.deleteFavouriteById(id);
	}

	public Favourite getFavouriteById(long id) {
		return favouriteDao.getFavouriteById(id);
	}
}