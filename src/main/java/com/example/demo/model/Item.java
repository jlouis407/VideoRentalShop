package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;


@Entity(name = "items")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "item_type", discriminatorType = DiscriminatorType.INTEGER)
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long upc;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "rented")
	private boolean rented;
	
	@Column(name = "date_added")
	private Date dateAdded;
	
	@OneToOne(mappedBy = "item")
	private ItemRental itemRental;
	
	public Item() {
		
	}

	public Item(Long upc, String title, boolean rented, Date dateAdded, ItemRental itemRental) {
		super();
		this.upc = upc;
		this.title = title;
		this.rented = rented;
		this.dateAdded = dateAdded;
		this.itemRental = itemRental;
	}

	public Long getUpc() {
		return upc;
	}

	public void setUpc(Long upc) {
		this.upc = upc;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isRented() {
		return rented;
	}

	public void setRented(boolean rented) {
		this.rented = rented;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public ItemRental getItemRental() {
		return itemRental;
	}

	public void setItemRental(ItemRental itemRental) {
		this.itemRental = itemRental;
	}

	@Override
	public String toString() {
		return "Item [upc=" + upc + ", title=" + title + ", rented=" + rented + ", dateAdded=" + dateAdded
				+ ", itemRental=" + itemRental + "]";
	}
	
	

}