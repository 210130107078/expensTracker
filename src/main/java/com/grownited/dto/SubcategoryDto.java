package com.grownited.dto;

public class SubcategoryDto {
	
	private Integer subcategoryId;
	private String subTitle;
	private Integer categoryId;
	
	
	public SubcategoryDto(Integer subcategoryId, String subTitle, Integer categoryId) {
		super();
		this.subcategoryId = subcategoryId;
		this.subTitle = subTitle;
		this.categoryId = categoryId;
	}
	
	
	public Integer getSubcategoryId() {
		return subcategoryId;
	}
	public void setSubcategoryId(Integer subcategoryId) {
		this.subcategoryId = subcategoryId;
	}
	public String getSubTitle() {
		return subTitle;
	}
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	
	
	
	
}
