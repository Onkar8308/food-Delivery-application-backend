package com.edu.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer itemid;

	@NotEmpty(message = "Item name cannot be null")
	@NotBlank(message = "Item name cannot be null")
	@Column(length = 50, nullable = false)
	private String itemname;

	@NotEmpty(message = "Item name cannot be null")
	@NotBlank(message = "Item name cannot be null")
	@Column(nullable = false)
	private String itemstatus;

	@Column(nullable = false)
	private Double itemcost;

	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Item(Integer itemid, String itemname, String itemstatus, Double itemcost) {
		super();
		this.itemid = itemid;
		this.itemname = itemname;
		this.itemstatus = itemstatus;
		this.itemcost = itemcost;
	}

	public Integer getItemid() {
		return itemid;
	}

	public void setItemid(Integer itemid) {
		this.itemid = itemid;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public String getItemstatus() {
		return itemstatus;
	}

	public void setItemstatus(String itemstatus) {
		this.itemstatus = itemstatus;
	}

	public Double getItemcost() {
		return itemcost;
	}

	public void setItemcost(Double itemcost) {
		this.itemcost = itemcost;
	}

	@Override
	public String toString() {
		return "Item [itemid=" + itemid + ", itemname=" + itemname + ", itemstatus=" + itemstatus + ", itemcost="
				+ itemcost + "]";
	}

}
