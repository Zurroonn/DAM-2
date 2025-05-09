// default package
// Generated 17 ene 2025, 13:09:22 by Hibernate Tools 6.5.1.Final

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/**
 * Customers generated by hbm2java
 */
public class Customers implements java.io.Serializable {

	private BigInteger customerId;
	private String name;
	private String address;
	private String website;
	private BigDecimal creditLimit;
	private Set contactses = new HashSet(0);

	public Customers() {
	}

	public Customers(BigInteger customerId, String name) {
		this.customerId = customerId;
		this.name = name;
	}

	public Customers(BigInteger customerId, String name, String address, String website, BigDecimal creditLimit,
			Set contactses) {
		this.customerId = customerId;
		this.name = name;
		this.address = address;
		this.website = website;
		this.creditLimit = creditLimit;
		this.contactses = contactses;
	}

	public BigInteger getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(BigInteger customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getWebsite() {
		return this.website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public BigDecimal getCreditLimit() {
		return this.creditLimit;
	}

	public void setCreditLimit(BigDecimal creditLimit) {
		this.creditLimit = creditLimit;
	}

	public Set getContactses() {
		return this.contactses;
	}

	public void setContactses(Set contactses) {
		this.contactses = contactses;
	}

}
