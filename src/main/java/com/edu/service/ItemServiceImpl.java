package com.edu.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.dao.Item;
import com.edu.error.GlobalException;
import com.edu.repository.ItemRepository;


@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itemRepository;

	@Override
	public Item saveItem(Item item) {
		// TODO Auto-generated method stub
		return itemRepository.save(item);
	}

	@Override
	public List<Item> getAllItems() {
		// TODO Auto-generated method stub
		return itemRepository.findAll();
	}

	@Override
	public void deleteItemById(Integer itemid) throws GlobalException {
		// TODO Auto-generated method stub
		Optional<Item> cob = itemRepository.findById(itemid);
		if (!cob.isPresent()) {
			throw new GlobalException("Item id does not exist");
		}
		itemRepository.deleteById(itemid);

	}

	@Override
	public Item updateItemById(Integer itemid, Item item)
			throws GlobalException {
		// TODO Auto-generated method stub
		Item ite = null;
		Optional<Item> cob = itemRepository.findById(itemid);
		if (!cob.isPresent()) {
			throw new GlobalException("Item id does not exist");
		} else {
			ite = itemRepository.findById(itemid).get();
			ite.setItemname(item.getItemname());
			ite.setItemstatus(item.getItemstatus());
			ite.setItemcost(item.getItemcost());
		}
		return itemRepository.save(ite);
	}

}
