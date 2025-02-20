package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
		ISymptomWriter writer = new WriteSymptomDataToFile();
		
		AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader,writer);
		List<String> symptoms = analyticsCounter.getSymptoms();
		
		Map<String, Integer> mapCountSym = analyticsCounter.countSymptoms(symptoms);
		Map<String, Integer> mapSortSym  = analyticsCounter.sortSymptoms(mapCountSym);
		
		
		analyticsCounter.writeSymptoms(mapSortSym);
	}

}
