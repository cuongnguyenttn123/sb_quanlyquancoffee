package com.thecoffeshop.DTO;

import com.thecoffeshop.entity.Price;

import java.util.Date;

public class ProductDTO {

	private Integer productid;
	private String categoryproductNAME;
	private String name;
	private Date updateat;
	private Boolean canDelete;
	private int number;
	private String image;
	private int price;
	private Price newPrice;
	private int rateOldAndNewPrice;
	private boolean checkIsNew;
	private int quantityInventory;
	private int quantity;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Integer getProductid() {
		return productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	public String getCategoryproductNAME() {
		return categoryproductNAME;
	}

	public void setCategoryproductNAME(String categoryproductNAME) {
		this.categoryproductNAME = categoryproductNAME;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getUpdateat() {
		return updateat;
	}

	public void setUpdateat(Date updateat) {
		this.updateat = updateat;
	}

	public int getQuantityInventory() {
		return quantityInventory;
	}

	public void setQuantityInventory(int quantityInventory) {
		this.quantityInventory = quantityInventory;
	}

	public Boolean getCanDelete() {
		return canDelete;
	}

	public void setCanDelete(Boolean canDelete) {
		this.canDelete = canDelete;
	}

	public boolean getCheckIsNew() {
		return checkIsNew;
	}

	public void setCheckIsNew(boolean checkIsNew) {
		this.checkIsNew = checkIsNew;
	}

	public Price getNewPrice() {
		return newPrice;
	}

	public void setNewPrice(Price newPrice) {
		this.newPrice = newPrice;
	}

	public int getRateOldAndNewPrice() {
		return rateOldAndNewPrice;
	}

	public void setRateOldAndNewPrice(int rateOldAndNewPrice) {
		this.rateOldAndNewPrice = rateOldAndNewPrice;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public boolean isCheckIsNew() {
		return checkIsNew;
	}
}
