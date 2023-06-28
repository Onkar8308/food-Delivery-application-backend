package com.edu.dao;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Invoice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer invoiceid;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date ordersdate;
	
	
	@PrePersist
	private void onCreate() {
		ordersdate = new Date();
	}
	
	@Column(nullable = false)
	private double invoicetotalcost;
	
	@Column(nullable = false)
	private int invoicetotalitem;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ordersid")
	private Orders orders;


	public Invoice() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Invoice(Date ordersdate, double invoicetotalcost, int invoicetotalitem) {
		super();
		this.ordersdate = ordersdate;
		this.invoicetotalcost = invoicetotalcost;
		this.invoicetotalitem = invoicetotalitem;
	}


	public Integer getInvoiceid() {
		return invoiceid;
	}


	public void setInvoiceid(Integer invoiceid) {
		this.invoiceid = invoiceid;
	}


	public Date getOrdersdate() {
		return ordersdate;
	}


	public void setOrdersdate(Date ordersdate) {
		this.ordersdate = ordersdate;
	}


	public double getInvoicetotalcost() {
		return invoicetotalcost;
	}


	public void setInvoicetotalcost(double invoicetotalcost) {
		this.invoicetotalcost = invoicetotalcost;
	}


	public int getInvoicetotalitem() {
		return invoicetotalitem;
	}


	public void setInvoicetotalitem(int invoicetotalitem) {
		this.invoicetotalitem = invoicetotalitem;
	}


	public Orders getOrders() {
		return orders;
	}


	public void setOrders(Orders orders) {
		this.orders = orders;
	}


	@Override
	public String toString() {
		return "Invoice [invoiceid=" + invoiceid + ", ordersdate=" + ordersdate + ", invoicetotalcost="
				+ invoicetotalcost + ", invoicetotalitem=" + invoicetotalitem + "]";
	}
	
}
