package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
		ISymptomWriter writer = new WriteSymptomDataToFile();
		
		AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader,writer);
		
		List<String> symptoms = analyticsCounter.getSymptoms();//Récupère les symptômes
		Map<String, Integer> mapCountSym = analyticsCounter.countSymptoms(symptoms);//Compte les symptômes identiques
		Map<String, Integer> mapSortSym  = analyticsCounter.sortSymptoms(mapCountSym);//Trie les symptômes par ordre alphabétique croissant
		
		
		analyticsCounter.writeSymptoms(mapSortSym);//Ecris un fjcier text avec les symptome
	}

}
