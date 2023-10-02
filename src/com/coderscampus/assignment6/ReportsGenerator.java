package com.coderscampus.assignment6;

import java.util.Map;

public class ReportsGenerator {
	

	public static class Reports {

		public static String generateYearEndSalesReport(String modelName, Map<Integer, Integer> yearlySalesByModel) {
			StringBuilder reportBuilder = new StringBuilder();

			reportBuilder.append("Year End Sales Report\n");
			reportBuilder.append("-----------------------------\n");

			reportBuilder.append(modelName + " Yearly Sales Report\n");
			reportBuilder.append("---------------------------------");

			yearlySalesByModel.forEach((year, sales) -> {
				System.out.println(year + "->" + sales);
			});

			return reportBuilder.toString();
		}

		public static void generateBestAndWorstMonth(String modelName, TeslaSalesData worstMonth,
				TeslaSalesData bestMonth) {
			
			if(bestMonth !=null && worstMonth != null) {
				System.out.println("The best month for " + modelName + " was: " + bestMonth.getDate());
				System.out.println("The worst month for " + modelName + " was: " + worstMonth.getDate());
				
			}


		}
	}

}
