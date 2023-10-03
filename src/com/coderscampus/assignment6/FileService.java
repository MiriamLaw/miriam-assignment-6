package com.coderscampus.assignment6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

public class FileService {

	public static Optional<List<TeslaSalesData>> getDataFromFile(String fileName) {

//		System.out.println("Opening file: " + fileName);

		List<TeslaSalesData> modelData = new ArrayList<>();

		try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {

			String line;
			String headerLine = fileReader.readLine();
			while ((line = fileReader.readLine()) != null) {
				String[] salesData = line.split(",");
				String dateStr = salesData[0];
				int sales = Integer.parseInt(salesData[1]);
				
				//Parse the date using MONTH_FORMATTER
				Month month = parseMonthFromCSV(dateStr);
				int year = parseYearFromCSV(dateStr);
				
				//Create a TeslaSalesData object with parsed date
				TeslaSalesData teslaSalesDataEntry = new TeslaSalesData(formatMonthYear(month, year), sales);
				modelData.add(teslaSalesDataEntry);

				return Optional.of(modelData);

			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}
	
	private static DateTimeFormatter MONTH_FORMATTER = DateTimeFormatter.ofPattern("MMM-yy", Locale.US);
	private static DateTimeFormatter YEAR_MONTH_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM");
	
	
	public static Month parseMonthFromCSV(String dateString) {
		try {
			return Month.from(MONTH_FORMATTER.parse(dateString));
			
		} catch (DateTimeParseException e) {
			e.printStackTrace();
			return null;
		}
    }

    public static Integer parseYearFromCSV(String dateString) {
    	String yearStr = dateString.split("-")[1];
        int twoDigitYear = Integer.parseInt(yearStr);
        return 2000 + twoDigitYear;
    }

    public static String formatMonthYear(Month month, Integer year) {
        LocalDate date = LocalDate.of(year, month, 1);
        return date.format(YEAR_MONTH_FORMATTER);
    }

}
