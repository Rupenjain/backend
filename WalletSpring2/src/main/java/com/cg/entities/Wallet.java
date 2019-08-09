package com.cg.entities;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name="Wallet")
public class Wallet {
	

	@Id
	private int aid;
	@Column(name="mobile",length=20)
	private long mobile;
	@Column(name="accountholder",length=20)
	private String accountholder;
	@Column(name="balance",length=20)
	private double balance;
//..getter,setters & two constructors...  
	
	public Wallet(int aid, long mobile, String accountholder, double balance) {
		super();
		this.aid = aid;
		this.mobile = mobile;
		this.accountholder = accountholder;
		this.balance = balance;
	}
	
	public Wallet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getAccountholder() {
		return accountholder;
	}
	public void setAccountholder(String accountholder) {
		this.accountholder = accountholder;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
    
  
	    
    
    
    
}