package com.edu.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.edu.dao.Item;
import com.edu.error.GlobalException;
import com.edu.service.ItemService;

@RestController
public class ItemController {

	@Autowired
	private ItemService itemService;

	@PostMapping("/saveItem")
	public ResponseEntity<Item> saveItem(@Valid @RequestBody Item item) {
		Item ite = itemService.saveItem(item);
		return new ResponseEntity<Item>(ite, HttpStatus.CREATED);
	}

	// http://localhost:8990/getAllItems
	@GetMapping("/getAllItems")
	List<Item> getAllItem() {
		return itemService.getAllItems();
	}

	// http://localhost:8990/deleteItemById/{itemid}
	@DeleteMapping("/deleteItemById/{itemid}")
	String deleteItemById(@PathVariable("itemid") Integer itemid) throws GlobalException {
		itemService.deleteItemById(itemid);
		return "Record Deleted";
	}

	// http://localhost:8990/updateItemById/{itemid}
	@PutMapping("/updateItemById/{itemid}")
	Item updateItemById(@PathVariable("itemid") Integer itemid,
			@RequestBody Item item) throws GlobalException {
		return itemService.updateItemById(itemid, item);
	}

}
