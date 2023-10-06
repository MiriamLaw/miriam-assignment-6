package com.coderscampus.assignment6;

import java.util.HashMap;
import java.util.Map;

public class ReportsGenerator {

	public static class Reports {

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
