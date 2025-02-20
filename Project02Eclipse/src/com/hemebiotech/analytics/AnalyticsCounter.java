package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	
	
	/*----------------------------------------------------------*/
	private ISymptomReader reader;
	private ISymptomWriter writer;
	
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) { 
		this.reader = reader;
		this.writer = writer;
	}
	
	public List<String> getSymptoms() {
		return reader.GetSymptoms();
	}
	
	public Map<String, Integer> countSymptoms(List<String> symptoms) { 
		Map<String, Integer> mapSymptoms = new HashMap<>(); 
		
		for(String symptom : symptoms) {
			
			if(mapSymptoms.containsKey(symptom) ) {
				
				mapSymptoms.replace(symptom, mapSymptoms.get(symptom)+1 );
				
			}else {
				mapSymptoms.put(symptom,1);
			}
			
			
		}
		//System.out.print( mapSymptoms.entrySet());
		return mapSymptoms ;
	}
	
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) { 
		
		TreeMap<String, Integer> sort = new TreeMap<>(symptoms);
	
		Map<String, Integer> mapSymptoms = sort;
		return mapSymptoms ;
	}
	
	public void writeSymptoms(Map<String, Integer> symptoms) { 
		writer.writeSymptoms(symptoms);
	}
	/*----------------------------------------------------------*/
	
	/*
	private static int headacheCount = 0;	
	private static int rashCount = 0;		
	private static int  highBloodPressureCount = 0;	
	
	public static void main(String args[]) throws Exception {
		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();


		while (line != null) {

			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headacheCount++;
			}
			else if (line.equals("rash")) {
				rashCount++;
			}
			else if (line.contains("high blood pressure")) {
				 highBloodPressureCount++;
			}

			line = reader.readLine();	// get another symptom
		}
		
		// next generate output
		FileWriter writer = new FileWriter ("result.out.txt");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("high blood pressure: " +  highBloodPressureCount + "\n");
		writer.close();
	}*/
}
