package demo;

import java.util.Scanner;

public class mainClass {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		//variables block
		String words[] = {"гра","людина","черевик","дурість","істота","танок","рана","клинок"};
		//String words[] = {"house","mouse"};
		int leftMistakes = 8;
		int wordInd = (int) ((Math.random()*100)%words.length);
		int unguessedL = words[wordInd].length();
		char mistakes[] = new char[8];
		boolean[] unguessedWord = new boolean[words[wordInd].length()];
		for(int i = 0; i < unguessedWord.length; i++)
			unguessedWord[i] = false;
		char userGuess;
		boolean lIsCorrect = false;

		//main block
		while(leftMistakes!=0 && unguessedL!=0) {
			lIsCorrect = false;
			System.out.print("Word: ");
			for(int i = 0; i < unguessedWord.length; i++) {
				if(unguessedWord[i]==false)
					System.out.print("_ ");
				else
					System.out.print(words[wordInd].charAt(i)+" ");
			}
			System.out.println();
			System.out.print("Mistakes ("+leftMistakes+" left): ");
			for(int i = 0; i < (8 - leftMistakes); i++)
				System.out.print(mistakes[i]+", ");
			System.out.println();
			System.out.println("Your latter: ");
			userGuess = in.next().charAt(0);
			for(int i = 0; i < words[wordInd].length(); i++) {
				if(userGuess == words[wordInd].charAt(i)) {
					if(!unguessedWord[i]) {
						unguessedWord[i] = true;
						unguessedL--;
						lIsCorrect = true;
					}else
						System.out.println("Already guessed!");
				}
			}
			if(!lIsCorrect) {
				boolean lInList = false;
				if(leftMistakes<8) {
					for(int i = 0; i < (8 - leftMistakes) && !lInList; i++) {
						if(userGuess == mistakes[i]) {
							System.out.println("Already in list!");
							lInList = true;
						}
					}
					if(!lInList) {
						mistakes[8-leftMistakes]=userGuess;
						leftMistakes--;
					}
				}else {
					mistakes[0]=userGuess;
					leftMistakes--;
				}
			}
			
		}
		if(leftMistakes==0) {
			System.out.println("You lose!");
			System.out.println("Word was: " + words[wordInd]);
		}
		else {
			System.out.println("You win!");
			System.out.println("Word was: " + words[wordInd]);
		}

		in.close();
	}

}
