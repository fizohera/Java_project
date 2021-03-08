package cs310;

import java.io.File;
import java.util.*;



public class SpellChecker {

	private Map<String, List<Integer>> misspelledWord;
	private Set<String> myDictionary;
	int lineNumber = 0;

	
	public SpellChecker(String fileName) {
		myDictionary = new TreeSet<>();
		try {
			Scanner scanner = new Scanner(new File(fileName));

			String currentLine;
			while (scanner.hasNextLine()) {
				currentLine = scanner.nextLine();
				String[] wor = currentLine.split("[^A-Za-z]+");
				for (String w : wor) {
					myDictionary.add(w.toLowerCase());
				}

			}
			scanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void processingWord(String fileName) {
		String words[];

		// myDictionary;
		misspelledWord = new TreeMap<>();
		try {
			Scanner scanner = new Scanner(new File(fileName));
			String currentLine;
			while (scanner.hasNextLine()) {
				currentLine = scanner.nextLine();
				lineNumber++;
				if (!currentLine.trim().equals("")) {
					words = currentLine.split("[^A-Za-z]+");

					for (String s : words) {
						s = s.toLowerCase();
						if (!myDictionary.contains(s)) {
							if (misspelledWord.get(s) == null) {
								List<Integer> list = new ArrayList<>();
								list.add(lineNumber);
								misspelledWord.put(s, list);
							} else {
								List<Integer> list = misspelledWord.get(s);
								list.add(lineNumber);
								misspelledWord.put(s, list);
							}
						}

					}
				}
			}
			scanner.close();
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void printReport() {

		System.out.println("Misspelled words and their line numbers");
		for (String s : misspelledWord.keySet()) {
			System.out.println(s + " : " + misspelledWord.get(s));
		}
	}
	public static void main(String[] args) {
		
		String dictionary = args[1];
		String inputFile =  args[0];
		SpellChecker sc = new SpellChecker(dictionary);

		sc.processingWord(inputFile);
		sc.printReport();
		
	}

}
