package com.coderscampus.assignment6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileService {
	public static List<TeslaSalesData> getDataFromFile(String fileName) {
		
		List<TeslaSalesData> modelData = new ArrayList<>();
		
			try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {

				String line;
				String headerLine = fileReader.readLine();
				while ((line = fileReader.readLine()) != null) {
					String[] salesData = line.split(",");
					String month = salesData[0];
					int year = Integer.parseInt(salesData[1]);
					int salesNumber = Integer.parseInt(salesData[2]);
					String model = salesData[3];

					TeslaSalesData salesEntry = new TeslaSalesData(month, year, salesNumber, model);
					modelData.add(salesEntry);

				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		
		return modelData;
	}

}
