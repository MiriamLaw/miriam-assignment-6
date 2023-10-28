package com.coderscampus.assignment6;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ReportsGenerator {

	public static class Reports {
		
		public static void generateReport(String model, String modelFilePath) {
			Optional<List<TeslaSalesData>> optModelData = FileService.getDataFromFile(modelFilePath);
			optModelData.ifPresent(records -> generateReport(model, records));
			
		}

		private static void generateReport(String model, List<TeslaSalesData> records) {
			Map<Integer, Integer> yearlySales = TeslaSalesAnalyzer.getYearlySales(records);
			Optional<TeslaSalesData> bestMonth = TeslaSalesAnalyzer.getBestMonth(records);
			Optional<TeslaSalesData> worstMonth = TeslaSalesAnalyzer.getWorstMonth(records);

			String yearEndSalesReport = ReportsGenerator.Reports.generateYearEndSalesReport(model, yearlySales);
			System.out.println(yearEndSalesReport);

			ReportsGenerator.Reports.generateBestAndWorstMonth(model, worstMonth.orElse(null), bestMonth.orElse(null));
		}

		public static String generateYearEndSalesReport(String modelName, Map<Integer, Integer> yearlySalesByModel) {
			StringBuilder reportBuilder = new StringBuilder();

			reportBuilder.append("-----------------------------\n");
			reportBuilder.append(modelName + " Yearly Sales Report\n");
			reportBuilder.append("-----------------------------\n");

			Map<Integer, Integer> salesByYear = new HashMap<>();
			yearlySalesByModel.forEach((year, sales) -> {
				salesByYear.put(year, salesByYear.getOrDefault(year, 0) + sales);
			});

			salesByYear.forEach((year, sales) -> {
				reportBuilder.append(year + " -> " + sales + "\n");

			});

			return reportBuilder.toString();
		}

		public static void generateBestAndWorstMonth(String modelName, TeslaSalesData bestMonth,
				TeslaSalesData worstMonth) {

			if (bestMonth != null && worstMonth != null) {
				System.out.println("The best month for " + modelName + " was: " + bestMonth.getDate());
				System.out.println("The worst month for " + modelName + " was: " + worstMonth.getDate());

			}

		}

		
	}

}
