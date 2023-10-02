package com.coderscampus.assignment6;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class TeslaSalesAnalyzer {
	public static Map<Integer, Integer> getYearlySales(List<TeslaSalesData> records) {
		return records.stream()
				.collect(Collectors.groupingBy(record -> Integer.parseInt(record.getDate().split("-")[0]),
						Collectors.summingInt(TeslaSalesData::getSales)));	
		}
	public static Optional<TeslaSalesData> getBestMonth(List<TeslaSalesData> records) {
		return records.stream()
					  .max(Comparator.comparingInt(TeslaSalesData::getSales));
	}
	public static Optional<TeslaSalesData> getWorstMonth(List<TeslaSalesData> records) {
		return records.stream()
					  .min(Comparator.comparingInt(TeslaSalesData::getSales));
	}
}
