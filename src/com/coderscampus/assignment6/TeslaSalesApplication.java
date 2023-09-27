package com.coderscampus.assignment6;

import java.util.List;
import java.util.Map;

public class TeslaSalesApplication {

	public static void main(String[] args) {
//		String[] fileNames = { "model3.csv", "modelS.csv", "modelX.csv" };
		
		String model3File = "model3.csv";
		String modelSFile = "modelS.csv";
		String modelXFile = "modelX.csv";

		
		
		List<TeslaSalesData> model3Data = FileService.getDataFromFile(model3File);
		List<TeslaSalesData> modelSData = FileService.getDataFromFile(modelSFile);
		List<TeslaSalesData> modelXData = FileService.getDataFromFile(modelXFile);


		

	}
}
