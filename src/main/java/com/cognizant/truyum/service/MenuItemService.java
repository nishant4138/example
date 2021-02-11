package com.cognizant.truyum.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.truyum.client.AuthClient;
import com.cognizant.truyum.exception.MenuItemNotFoundException;
import com.cognizant.truyum.exception.UserAlreadyExistException;
import com.cognizant.truyum.model.AuthResponse;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.repository.MenuItemRepository;

@Service
public class MenuItemService {
	@Autowired
	MenuItemRepository menuItemRepository;
	
    @Autowired
    AuthClient authClient;
    
	@Transactional	
	public List<MenuItem> getMenuListAdmin(String token){
		AuthResponse response = authClient.getValidity(token);
		if(response.isValid() && response.getRole().equalsIgnoreCase("admin"))
		    return (List<MenuItem>) menuItemRepository.findAll();
		else
			throw new UserAlreadyExistException();
	}

	@Transactional
	public List<MenuItem> getMenuListCustomer(String token) {
		AuthResponse response = authClient.getValidity(token);
		if(response.isValid())
			return new ArrayList<MenuItem>(menuItemRepository.getMenuItemListCustomer());
		else
			throw new UserAlreadyExistException();
	}

	public MenuItem getMenuItem(long menuItemId, String token) throws MenuItemNotFoundException {
		AuthResponse response = authClient.getValidity(token);
		if(response.isValid())
		return menuItemRepository.findById(menuItemId).get();
		else
			throw new UserAlreadyExistException();
	}

	@Transactional
	public boolean modifyMenuItem(MenuItem menuItem, String token) throws MenuItemNotFoundException{
		AuthResponse response = authClient.getValidity(token);
		if(response.isValid()) {
		   MenuItem menuItemDb=menuItemRepository.findById(menuItem.getId()).get();
		   if(menuItemDb==null) {
			return false;
	     	}
		   menuItemRepository.save(menuItem);
		   return true;
		}
		else
			throw new UserAlreadyExistException();
	}
	
	
}
