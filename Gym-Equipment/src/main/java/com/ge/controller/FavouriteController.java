package com.ge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ge.dto.Favourite;
import com.ge.service.FavouriteService;

@Controller
public class FavouriteController {

	@Autowired
	private FavouriteService favouriteService;

	@GetMapping("/showAllFavourites")
	public String showAllFavourites(Model model) {
		model.addAttribute("listFavourites", favouriteService.getAllFavourites());
		return "showAllFavourites";
	}

	@GetMapping("/getFavouriteById/{id}")
	public String getFavouriteById(@PathVariable int id,Model model) {
		model.addAttribute("Favourite", favouriteService.getFavouriteById(id));
		return "showFavouriteById";	
	}
	
	@PostMapping("/deleteFavouriteById")
	public String deleteFavouriteById(@PathVariable int id) {
		favouriteService.deleteFavouriteById(id);
		return "redirect:/deleteFavouriteById";
	}

	@PostMapping("/saveFavourite")
	public String saveFavourite(@ModelAttribute("favourite") Favourite favourite) {
		// save favourite to database
		favouriteService.saveFavourite(favourite);
		return "redirect:/";
	}
}
