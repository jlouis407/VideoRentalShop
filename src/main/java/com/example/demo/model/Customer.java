
package com.example.demo.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "account_frozen")
	private boolean accountFrozen;

	@OneToMany(mappedBy = "customer")
	private Set<ItemRental> itemRentals;

	public Customer() {

	}

	public Customer(Long id, String firstName, String lastName, String username, String password, boolean accountFrozen,
			Set<ItemRental> itemRentals) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.accountFrozen = accountFrozen;
		this.itemRentals = itemRentals;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAccountFrozen() {
		return accountFrozen;
	}

	public void setAccountFrozen(boolean accountFrozen) {
		this.accountFrozen = accountFrozen;
	}

	public Set<ItemRental> getItemRentals() {
		return itemRentals;
	}

	public void setItemRentals(Set<ItemRental> itemRentals) {
		this.itemRentals = itemRentals;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", password=" + password + ", accountFrozen=" + accountFrozen + ", itemRentals=" + itemRentals + "]";
	}
	
}
