package com.cognizant.truyum.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cognizant.truyum.TruyumApplication;
import com.cognizant.truyum.exception.MenuItemNotFoundException;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;

@RestController
public class MenuItemController {
	@Autowired
	private MenuItemService menuItemService;
	private static final Logger LOGGER = LoggerFactory.getLogger(TruyumApplication.class);
	
	@GetMapping("/adminmenu")
	public List<MenuItem> getAdminItems(@RequestHeader("Authorization") String token){
		return menuItemService.getMenuListAdmin(token);
	}
	
	@GetMapping("/customermenu")
	public List<MenuItem> getCustomerItems(@RequestHeader("Authorization") String token){
		return menuItemService.getMenuListCustomer(token);
	}
	
	@GetMapping("/menu/{menuItemId}")
	public MenuItem getMenuItem(@PathVariable long menuItemId , @RequestHeader("Authorization") String token) throws MenuItemNotFoundException {
		return menuItemService.getMenuItem(menuItemId,token);
	}
	
	@PutMapping("/modify")
	public boolean modifyMenuItem(@RequestBody MenuItem menuItem, @RequestHeader("Authorization") String token) throws MenuItemNotFoundException {
		return menuItemService.modifyMenuItem(menuItem,token);
	}
}
