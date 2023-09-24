package com.coderscampus.assignment6;

import java.util.List;
import java.util.Map;

public class TeslaSalesApplication {

	public static void main(String[] args) {
		String[] fileNames = { "model3.csv", "modelS.csv", "modelX.csv" };
		
		Map<String, List<TeslaSalesData>> modelDataMap = FileService.getDataFromFile(fileNames);

	}
}
