package com.examly.springapp.models;
import java.time.LocalDate;
import java.util.Date;

public class AddonModel 
{
	private String addOnId;
    private String addOnName;
    private String addOnDescription;
    private LocalDate dateAdded;
    private Double addOnCost;
    
	public AddonModel(String addOnId, String addOnName, String addOnDescription, LocalDate dateAdded, Double addOnCost) {
		super();
		this.addOnId = addOnId;
		this.addOnName = addOnName;
		this.addOnDescription = addOnDescription;
		this.dateAdded = dateAdded;
		this.addOnCost = addOnCost;
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

	public LocalDate getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(LocalDate dateAdded) {
		this.dateAdded = dateAdded;
	}

	public Double getAddOnCost() {
		return addOnCost;
	}

	public void setAddOnCost(Double addOnCost) {
		this.addOnCost = addOnCost;
	}
	
	@Override
	public String toString() {
		return "AddonModel [addOnId=" + addOnId + ", addOnName=" + addOnName + ", addOnDescription=" + addOnDescription
				+ ", dateAdded=" + dateAdded + ", themeReturnGift=" + ", addOnCost=" + addOnCost
				+ ", addOnImageUrl=" + "]";
	}
    
	
    
    

}
