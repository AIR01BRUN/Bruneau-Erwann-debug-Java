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
	
	/**
	 * Interface pour lire et écrire des fichier texte
	 */
	private ISymptomReader reader;
	private ISymptomWriter writer;
	
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) { 
		this.reader = reader;
		this.writer = writer;
	}
	
	/**
	 * Récupère tous les symptômes dans un fichier texte, sans tri
	 * @return Une List<String> de symptômes.
	 */
	public List<String> getSymptoms() {
		return reader.getSymptoms();
	}
	
	/**
	 * Compte le nombre de symptômes du même type et les met dans une map
	 * @param une List<String> de symptôme 
	 * @return une Map<String, Integer> composée du symptôme en clé et du nombre de ce symptôme en valeur
	 */
	public Map<String, Integer> countSymptoms(List<String> symptoms) { 
		
		Map<String, Integer> mapSymptoms = new HashMap<>(); 
		
		for(String symptom : symptoms) {
			if(mapSymptoms.containsKey(symptom) ) {
				
				mapSymptoms.replace(symptom, mapSymptoms.get(symptom)+1 );

			}else {
				mapSymptoms.put(symptom,1);
			}			
		}
		
		return mapSymptoms ;
	}
	
/**
 * Trie par ordre alphabétique les symptômes dans une Map<String, Integer>
 * @param Une Map<String, Integer> contenant la liste de tous les symptômes et leur nombre
 * @return Une Map<String, Integer> contenant la même liste, mais triée par ordre alphabétique ascendant.
 */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) { 
		
		TreeMap<String, Integer> sort = new TreeMap<>(symptoms);
		Map<String, Integer> mapSymptoms = sort;
		return mapSymptoms ;
	}
	
	/**
	 * Écrit les symptômes dans un fichier texte
	 * @param Une Map<String, Integer> contenant la liste de tous les symptômes et leur nombre
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) { 
		writer.writeSymptoms(symptoms);
	}
	
}
