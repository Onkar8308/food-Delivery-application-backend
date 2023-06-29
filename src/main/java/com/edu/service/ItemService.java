package com.edu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.edu.dao.Item;
import com.edu.error.GlobalException;



@Service
public interface ItemService {

	public Item saveItem(Item item);

	public List<Item> getAllItems();

	public void deleteItemById(Integer itemid) throws GlobalException;

	public Item updateItemById(Integer itemid, Item item) throws GlobalException;

}

