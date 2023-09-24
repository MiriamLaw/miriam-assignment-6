package com.coderscampus.assignment6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileService {
	public static Map<String, List<TeslaSalesData>> getDataFromFile(String[] fileNames) {
		Map<String, List<TeslaSalesData>> modelDataMap = new HashMap<>();


		for (String fileName : fileNames) {
			List<TeslaSalesData> modelData = new ArrayList<>();
			try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {

				String line;
				String headerLine = fileReader.readLine();
				while ((line = fileReader.readLine()) != null) {
					String[] salesData = line.split(",");
					String date = salesData[0];
					int salesNumber = Integer.parseInt(salesData[1]);

					TeslaSalesData salesEntry = new TeslaSalesData(date, salesNumber);
					modelData.add(salesEntry);

				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			modelDataMap.put(fileName, modelData);

		}
		return modelDataMap;
	}

}
