package com.coderscampus.assignment6;

public class TeslaSalesData {
	
	private String month;
	private int year;
	private int salesNumber;
	private String model;
	
	public TeslaSalesData(String month, int year, int salesNumber, String model) {
		this.month = month;
		this.year = year;
		this.salesNumber = salesNumber;
		this.model = model;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getSalesNumber() {
		return salesNumber;
	}

	public void setSalesNumber(int salesNumber) {
		this.salesNumber = salesNumber;
	}

	@Override
	public String toString() {
		return "TeslaSalesData [month=" + month + ", year=" + year + ", salesNumber=" + salesNumber + ", model=" + model
				+ "]";
	}

	
}
