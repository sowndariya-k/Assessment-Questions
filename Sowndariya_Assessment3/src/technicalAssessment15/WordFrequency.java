package technicalAssessment15;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordFrequency {

	public static void main(String[] args) {
		//hashmap
		Map<String,Integer> map=new HashMap<>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Sowndariya\\Desktop\\Expleo\\Sowndariya_Assessment\\Sowndariya_Assessment3\\src\\technicalAssessment15\\words.txt"));
			String line;
			
			while ((line = br.readLine()) != null) {
				String[] words = line.split(" ");

				for (String word : words) {
					
					if (!word.isEmpty()) {
						map.put(word, map.getOrDefault(word, 0) + 1);
					}
				}
			}
			
			br.close();
			//print words and count
			for (Map.Entry<String, Integer> entry : map.entrySet()) {
				
				System.out.println(entry.getKey() + ": " + entry.getValue());
			}
			
			System.out.println("Unique words: " + map.size());
		}catch (FileNotFoundException e) {
			System.out.println("Error: words.txt not found");
		}catch (IOException e) {
			System.out.println("Error reading file");
		}
	}
}
		 

