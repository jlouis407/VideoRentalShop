package com.example.demo.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "item_rentals")
public class ItemRental {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "item_upc", referencedColumnName = "upc")
	private Item item;
	
	@Column(name = "rental_date")
	private Date rentalDate;
	
	@Column(name = "due_date")
	private Date dueDate;
	
	@Column(name = "returned_date")
	private Date returnedDate;
	
	public ItemRental() {
		
	}

	public ItemRental(Long id, Item item, Date rentalDate, Date dueDate, Date returnedDate) {
		super();
		this.id = id;
		this.item = item;
		this.rentalDate = rentalDate;
		this.dueDate = dueDate;
		this.returnedDate = returnedDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Date getRentalDate() {
		return rentalDate;
	}

	public void setRentalDate(Date rentalDate) {
		this.rentalDate = rentalDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getReturnedDate() {
		return returnedDate;
	}

	public void setReturnedDate(Date returnedDate) {
		this.returnedDate = returnedDate;
	}

	
	
	

}
	
	


