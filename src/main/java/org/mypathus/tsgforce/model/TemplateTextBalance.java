package org.mypathus.tsgforce.model;

public class TemplateTextBalance {
	private int id;
	private String employer;
	private double balance;
	private String description;
	private String homebankingStatus;
	private String mobileBankingStatus;
	private String hasEstatements;
	private String aText;
	private double holdAmount;
	private String openDate;
	private String closeDate;
	
	public int getId(){
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmployer() {
		return employer;
	}
	public void setEmployer(String employer) {
		this.employer = employer;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getHomebankingStatus() {
		return homebankingStatus;
	}
	public void setHomebankingStatus(String homebankingStatus) {
		this.homebankingStatus = homebankingStatus;
	}
	public String getMobileBankingStatus() {
		return mobileBankingStatus;
	}
	public void setMobileBankingStatus(String mobileBankingStatus) {
		this.mobileBankingStatus = mobileBankingStatus;
	}
	public String getHasEstatements() {
		return hasEstatements;
	}
	public void setHasEstatements(String hasEstatements) {
		this.hasEstatements = hasEstatements;
	}
	public String getaText() {
		return aText;
	}
	public void setaText(String aText) {
		this.aText = aText;
	}
	public double getHoldAmount() {
		return holdAmount;
	}
	public void setHoldAmount(double holdAmount) {
		this.holdAmount = holdAmount;
	}
	public String getOpenDate() {
		return openDate;
	}
	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}
	public String getCloseDate() {
		return closeDate;
	}
	public void setCloseDate(String closeDate) {
		this.closeDate = closeDate;
	}

}
