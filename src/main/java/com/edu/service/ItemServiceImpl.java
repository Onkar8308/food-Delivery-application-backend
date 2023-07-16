package com.edu.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.dao.Item;
import com.edu.dao.RestaurantAddress;
import com.edu.error.GlobalException;
import com.edu.repository.ItemRepository;
import com.edu.repository.RestaurantAddressRepository;


@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private RestaurantAddressRepository restaurantAddressRepository;

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
			ite.setItemimage(item.getItemimage());
		}
		return itemRepository.save(ite);
	}

	/*
	 * Employee eob=employeerepository.findById(empid).get(); 
	 * Department
	 * dob=departmentRepository.findById(deptid).get();
	 * eob.employeeAssignDepartment(dob); return employeerepository.save(eob);
	 */
	
	@Override
	public Item itemAssignedRestaurantAddress(Integer itemid, Integer restid) {
		// TODO Auto-generated method stub
		Item eob=itemRepository.findById(itemid).get();
		RestaurantAddress dob= restaurantAddressRepository.findById(restid).get();
		 eob.itemAssignedRestaurantAddress(dob);
		 return itemRepository.save(eob);
	}

	@Override
	public List<Item> getItemByRestId(Integer addressid) {
		// TODO Auto-generated method stub
		return itemRepository.getItemByRestId(addressid);
	}

}
