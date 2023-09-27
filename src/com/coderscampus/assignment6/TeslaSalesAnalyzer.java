package com.coderscampus.assignment6;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TeslaSalesAnalyzer {
	public static int calculateAnnualSales(List<TeslaSalesData> salesData, String modelName) {
		return salesData.stream()
				        .filter(data -> modelName.equals(data))
				        .mapToInt(TeslaSalesData::getSalesNumber)
				        .sum();
				        
				        

	}
	
	public static Map<String, Integer> calcuateAnnualSales(List<TeslaSalesData> salesData) {
		return salesData.stream()
				        .collect(Collectors.groupingBy(TeslaSalesData::getModel,
				                 Collectors.summingInt(TeslaSalesData::getSalesNumber)));
	}
}

