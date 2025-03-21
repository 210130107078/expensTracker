package com.grownited.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Expense")

public class ExpenseEntity {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer expenseId;
private String title;
private Integer categoryId;
private Integer subcategoryId;
private Integer vendorId;
private Integer accountId;
private String status;
private String amount;
private String transcationDate;
private String description;
private Integer userId;

public Integer getExpenseId() {
	return expenseId;
}
public void setExpenseId(Integer expenseId) {
	this.expenseId = expenseId;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}

public Integer getCategoryId() {
	return categoryId;
}
public void setCategoryId(Integer categoryId) {
	this.categoryId = categoryId;
}
public Integer getSubcategoryId() {
	return subcategoryId;
}
public void setSubcategoryId(Integer subcategoryId) {
	this.subcategoryId = subcategoryId;
}
public Integer getVendorId() {
	return vendorId;
}
public void setVendorId(Integer vendorId) {
	this.vendorId = vendorId;
}
public Integer getAccountId() {
	return accountId;
}
public void setAccountId(Integer accountId) {
	this.accountId = accountId;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getAmount() {
	return amount;
}
public void setAmount(String amount) {
	this.amount = amount;
}
public String getTranscationDate() {
	return transcationDate;
}
public void setTranscationDate(String transcationDate) {
	this.transcationDate = transcationDate;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Integer getUserId() {
	return userId;
}
public void setUserId(Integer userId) {
	this.userId = userId;
}


}
