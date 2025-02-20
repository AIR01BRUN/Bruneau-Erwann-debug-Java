package com.hemebiotech.analytics;


import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter{
	
	
	public WriteSymptomDataToFile()  {
		
	}
		
	

	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {
		
		try {
			FileWriter writer = new FileWriter ("result.out.txt");
			
			for(String symptomsKey : symptoms.keySet()){
				
				
					System.out.print( "::"+symptomsKey+":  "+  symptoms.get(symptomsKey)+" \n ");
				
				writer.write(symptomsKey +":"+ symptoms.get(symptomsKey)+"\n");
				
			}
			writer.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
