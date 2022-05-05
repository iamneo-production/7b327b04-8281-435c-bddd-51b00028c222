package com.examly.springapp.models;
import java.time.LocalDate;

public class AddonModel 
{
	private String addOnId;
    private String addOnName;
    private String addOnDescription;
    private Double addOnPrice;
    
	public AddonModel(String addOnId, String addOnName, String addOnDescription, Double addOnPrice) {
		super();
		this.addOnId = addOnId;
		this.addOnName = addOnName;
		this.addOnDescription = addOnDescription;
		this.addOnPrice = addOnPrice;
	}
	
	public String getAddOnId() {
		return addOnId;
	}

	public void setAddOnId(String addOnId) {
		this.addOnId = addOnId;
	}

	public String getAddOnName() {
		return addOnName;
	}

	public void setAddOnName(String addOnName) {
		this.addOnName = addOnName;
	}

	public String getAddOnDescription() {
		return addOnDescription;
	}

	public void setAddOnDescription(String addOnDescription) {
		this.addOnDescription = addOnDescription;
	}

	public Double getAddOnPrice() {
		return addOnPrice;
	}

	public void setAddOnPrice(Double addOnPrice) {
		this.addOnPrice = addOnPrice;
	}
	
	@Override
	public String toString() {
		return "AddonModel [addOnId=" + addOnId + ", addOnName=" + addOnName + ", addOnDescription=" + addOnDescription
				+ ", themeReturnGift=" + ", addOnCost=" + addOnPrice
				+ ", addOnImageUrl=" + "]";
	}
    
	
    
    

}
