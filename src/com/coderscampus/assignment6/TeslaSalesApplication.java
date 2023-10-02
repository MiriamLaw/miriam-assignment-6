package com.coderscampus.assignment6;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class TeslaSalesApplication {

	public static void main(String[] args) {

        String model3FilePath = "/Users/miriamlaw/git/miriam-assignment-6/src/model3.csv";
        String modelSFilePath = "/Users/miriamlaw/git/miriam-assignment-6/src/modelS.csv";
        String modelXFilePath = "/Users/miriamlaw/git/miriam-assignment-6/src/modelX.csv";


		Optional<List<TeslaSalesData>> optModel3Data = FileService.getDataFromFile(model3FilePath);
		optModel3Data.ifPresent(records -> processSales("Model 3", records));
		
		Optional<List<TeslaSalesData>> optModelSData = FileService.getDataFromFile(modelSFilePath);
		optModelSData.ifPresent(records -> processSales("Model S", records));
		
		
		Optional<List<TeslaSalesData>> optModelXData = FileService.getDataFromFile(modelXFilePath);
		optModelXData.ifPresent(records -> processSales("Model X", records));
		


	}
	private static void processSales(String model, List<TeslaSalesData> records) {
		Map<Integer, Integer> yearlySales = TeslaSalesAnalyzer.getYearlySales(records);
		Optional<TeslaSalesData> bestMonth = TeslaSalesAnalyzer.getBestMonth(records);
		Optional<TeslaSalesData> worstMonth = TeslaSalesAnalyzer.getWorstMonth(records);
		
		String yearEndSalesReport = ReportsGenerator.Reports.generateYearEndSalesReport(model, yearlySales);
		System.out.println(yearEndSalesReport);
		
		ReportsGenerator.Reports.generateBestAndWorstMonth(model, worstMonth.orElse(null), bestMonth.orElse(null));
	}
	
	
	
}
