package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {

	private static String pathRead = "symptoms.txt";
	private static String pathWrite = "result.out";

	public static void main(String[] args) {

		ISymptomReader reader = new ReadSymptomDataFromFile(pathRead);
		ISymptomWriter writer = new WriteSymptomDataToFile(pathWrite);

		AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);

		List<String> symptoms = analyticsCounter.getSymptoms();
		Map<String, Integer> mapCountSym = analyticsCounter.countSymptoms(symptoms);
		Map<String, Integer> mapSortSym = analyticsCounter.sortSymptoms(mapCountSym);

		analyticsCounter.writeSymptoms(mapSortSym);
	}

}
