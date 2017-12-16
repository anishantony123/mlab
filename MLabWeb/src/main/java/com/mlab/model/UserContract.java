package com.mlab.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user_contract database table.
 * 
 */
@Entity
@Table(name="user_contract")
@NamedQuery(name="UserContract.findAll", query="SELECT u FROM UserContract u")
public class UserContract implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional many-to-one association to Contract
	@ManyToOne
	private Contract contract;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	public UserContract() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Contract getContract() {
		return this.contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}