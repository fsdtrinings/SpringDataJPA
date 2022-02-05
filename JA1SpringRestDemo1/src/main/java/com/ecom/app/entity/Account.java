package com.ecom.app.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;




@Entity
public class Account {

	@Id
	@SequenceGenerator(name="mylogic",initialValue=100,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO,generator="mylogic")
	private int accountNumber;
	
	@NotNull(message = "Account Name Cannot be left Blank")
	private String accountName;
	@Min(value = 5000,message = "Min Balance Limit is 5000")
	private int balance;
	private String pannumber;
	private long aadharNumber;
	private String ifscCode;
	private String accountType;
	private int relationshipCCCode;
	
	@Embedded
	private Address address;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
			name="Account_Policy_Info",
			joinColumns=@JoinColumn(name="accountdetails"),
			inverseJoinColumns=@JoinColumn(name="policydetails"))
	private List<Policy> policies;
	
	
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Policy> getPolicies() {
		return policies;
	}
	public void setPolicies(List<Policy> policies) {
		this.policies = policies;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getPannumber() {
		return pannumber;
	}
	public void setPannumber(String pannumber) {
		this.pannumber = pannumber;
	}
	public long getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(long aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public int getRelationshipCCCode() {
		return relationshipCCCode;
	}
	public void setRelationshipCCCode(int relationshipCCCode) {
		this.relationshipCCCode = relationshipCCCode;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (aadharNumber ^ (aadharNumber >>> 32));
		result = prime * result + ((accountName == null) ? 0 : accountName.hashCode());
		result = prime * result + accountNumber;
		result = prime * result + ((accountType == null) ? 0 : accountType.hashCode());
		result = prime * result + balance;
		result = prime * result + ((ifscCode == null) ? 0 : ifscCode.hashCode());
		result = prime * result + ((pannumber == null) ? 0 : pannumber.hashCode());
		result = prime * result + relationshipCCCode;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (aadharNumber != other.aadharNumber)
			return false;
		if (accountName == null) {
			if (other.accountName != null)
				return false;
		} else if (!accountName.equals(other.accountName))
			return false;
		if (accountNumber != other.accountNumber)
			return false;
		if (accountType == null) {
			if (other.accountType != null)
				return false;
		} else if (!accountType.equals(other.accountType))
			return false;
		if (balance != other.balance)
			return false;
		if (ifscCode == null) {
			if (other.ifscCode != null)
				return false;
		} else if (!ifscCode.equals(other.ifscCode))
			return false;
		if (pannumber == null) {
			if (other.pannumber != null)
				return false;
		} else if (!pannumber.equals(other.pannumber))
			return false;
		if (relationshipCCCode != other.relationshipCCCode)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountName=" + accountName + ", balance=" + balance
				+ ", pannumber=" + pannumber + ", aadharNumber=" + aadharNumber + ", ifscCode=" + ifscCode
				+ ", accountType=" + accountType + ", relationshipCCCode=" + relationshipCCCode + "]";
	}
	
	
}
