package com.coderscampus.assignment6;

public class TeslaSalesData {
	
	private String date;
	private int salesNumber;
	
	public TeslaSalesData(String date, int salesNumber) {
		this.date = date;
		this.salesNumber = salesNumber;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getSalesNumber() {
		return salesNumber;
	}

	@Override
	public String toString() {
		return "TeslaSalesData [date=" + date + ", salesNumber=" + salesNumber + "]";
	}

	public void setSalesNumber(int salesNumber) {
		this.salesNumber = salesNumber;
	}


}
