package com.hemebiotech.analytics;

import java.util.Map;

public interface ISymptomWriter {
	
/**
 * Crée/remplace un fichier texte et remplis-le avec une Map<String, Integer> de symptômes
 * @param symptoms
 */
	public void writeSymptoms(Map<String, Integer> symptoms);

}
