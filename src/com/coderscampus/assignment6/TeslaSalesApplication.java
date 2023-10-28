package com.coderscampus.assignment6;

public class TeslaSalesApplication {

	public static void main(String[] args) {
		
		String basePath = System.getProperty("user.dir");
		
		ReportsGenerator.Reports.generateReport("Model 3", basePath + "/src/model3.csv");
		ReportsGenerator.Reports.generateReport("Model S", basePath + "/src/modelS.csv");
		ReportsGenerator.Reports.generateReport("Model X", basePath + "/src/modelX.csv");
	}

}
