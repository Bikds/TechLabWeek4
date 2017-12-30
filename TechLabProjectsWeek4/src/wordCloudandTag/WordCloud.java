package wordCloudandTag;

/*
 * @author BikDS
 * July 8, 2017
 * The purpose of this class is to generate random words in random places in random sizes 
 * on the users screen
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

import apcs.Window;

public class WordCloud {

	public static void main(String[] args) {

		Window.size(1500, 2000);

		String[] words = {"hello", "how", "are", "you"};
		HashMap<String, Integer> frequency = new HashMap<String, Integer>();

		File f = new File("File.txt");

		try {
			Scanner input = new Scanner(f);

			while (input.hasNext()) {
				// split sentence into individual words and put it in a string array
				String[] s = input.nextLine().split(" ");

				//go through the array of words
				for (String word : s) {
					//if the word is already in the map increase its frequency by 1
					if (frequency.containsKey(word)) {
						frequency.put(word, frequency.get(word) + 1);
					}
					//otherwise put it in the map and set its value to one
					else {
						frequency.put(word, 1);
					}
				}
			}
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//printWords(words);
		printWords(frequency);	
	}
	public static void printWords(String[] words) {
		for (String word : words) {
			Window.out.randomColor();
			Window.out.font("arial", 20);
			Window.out.print(word, Window.rollDice(Window.width()), Window.rollDice(Window.height()));
		}           
	}
	public static void printWords(HashMap<String, Integer> map) {
		for (String word : map.keySet()) {
			Window.out.randomColor();
			Window.out.font("arial", 10 + map.get(word));
			Window.out.print(word, Window.rollDice(Window.width()), Window.rollDice(Window.height()));
		}
	}
}
