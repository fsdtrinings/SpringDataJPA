package com.ecom.app.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Policy {
	
	@Id
	@SequenceGenerator(name="myPolicylogic",initialValue=200,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO,generator="myPolicylogic")
	private int policyId;
	private String policyName;
	private int sumAssured;
	private int premiumAmount;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
			name="Account_Policy_Info",
			joinColumns=@JoinColumn(name="policydetails"),
			inverseJoinColumns=@JoinColumn(name="accountdetails"))
	private List<Account> accounts;
	
	
	
	public Policy() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Policy(int policyId, String policyName, int sumAssured, int premiumAmount) {
		super();
		this.policyId = policyId;
		this.policyName = policyName;
		this.sumAssured = sumAssured;
		this.premiumAmount = premiumAmount;
	}
	public int getPolicyId() {
		return policyId;
	}
	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}
	public String getPolicyName() {
		return policyName;
	}
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	public int getSumAssured() {
		return sumAssured;
	}
	public void setSumAssured(int sumAssured) {
		this.sumAssured = sumAssured;
	}
	public int getPremiumAmount() {
		return premiumAmount;
	}
	public void setPremiumAmount(int premiumAmount) {
		this.premiumAmount = premiumAmount;
	}
	
	
}
