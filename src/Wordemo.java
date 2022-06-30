import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Wordemo
{
	/*String l1;
	String l2;
	String l3;
	String l4;
	String l5;*/
	
	//List<String> wordslist = new ArrayList<String>();
	
	int highscore = 0;
	
	int gamecount = 0;
	
	List<Integer> scorelist = new ArrayList<Integer>();
	
	List<String> guesses;
	int tries;
	boolean correct = false;
	
	static Word partial = new Word();
	
	public Wordemo()
	{
		guesses = new ArrayList<String>();
		tries = 1;
	}
	
	private boolean compareWords(Word solution, Word input)
	{		
		for (int i = 0; i < 5; i++)
		{
			if (!partial.letters[i].equals(solution.letters[i]))
			{
				if (input.letters[i].equalsIgnoreCase(solution.letters[i]))
				{
					partial.letters[i] = solution.letters[i];
				}
				else if (solution.contains(input.letters[i]))
				{
					if (!partial.letters[solution.containsIndex(input.letters[i])].equals(solution.letters[i]))
					{
						partial.letters[i] = "*";
					}
					else
					{
						partial.letters[i] = "-";
					}
				}
				else
				{
					partial.letters[i] = "-";
				}
			}
		}
		
		System.out.println(partial);
		
		for (int i = 0; i < 5; i++)
		{
			if (!partial.letters[i].equalsIgnoreCase(solution.letters[i]))
			{
				return false;
			}
		}
		
		return true;
	}
	
	@SuppressWarnings("unused")
	private boolean compareWords2(Word solution, Word input)
	{
		int c = 0;
		
		for (int i = 0; i < 5; i++)
		{
			if (input.letters[i].equalsIgnoreCase(solution.letters[i]))
			{
				c++;
				partial.letters[i] = "*";
			}
			else if (solution.contains(input.letters[i]))
			{
				partial.letters[i] = "!";
			}
			else
			{
				partial.letters[i] = "-";
			}
		}
		
		System.out.println(partial);
		
		return (c == 5);
	}
	
	private void printRules()
	{
		System.out.println("Rules of the Challenge:");
		System.out.println("- Try to guess the randomly generated 5 letter word in 6 tries");
		System.out.println("- After every guess, your correct, close, and incorrect letters will be represented as follows:");
		System.out.println("    -> If the letter is in the word in the correct position, it shall be displayed");
		System.out.println("    -> '*' means the letter is in the word but in the wrong position");
		System.out.println("    -> '-' means the letter is not in the word");
		System.out.println("- P.S. You can enter (R) any time to check the rules again!");
	}
	
	@SuppressWarnings("unused")
	private void printRules2()
	{
		System.out.println("Rules of the Challenge:");
		System.out.println("- Try to guess the randomly generated 5 letter word in 6 tries");
		System.out.println("- After every guess, your correct, close, and incorrect letters will be represented as follows:");
		System.out.println("    -> '*' means the letter is in the word and in the correct position");
		System.out.println("    -> '!' means the letter is in the word but in the wrong position");
		System.out.println("    -> '-' means the letter is not in the word");
		System.out.println("- P.S. You can enter (R) any time to check the rules again!");
	}
	
	private void setHighScore()
	{
		if (!scorelist.isEmpty())
		{
			highscore = scorelist.get(0);
			
			for (int i = 0; i < scorelist.size(); i++)
			{
				if (scorelist.get(i) < highscore)
					highscore = scorelist.get(i);
			}
		}
	}
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException
	{
		Wordemo game = new Wordemo();
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("--------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Welcome to Wordemo (a simple knockoff of Wordle: but call it a simulator if you will)!");
		System.out.println("--------------------------------------------------------------------------------------------------------------------------");
		System.out.println();
		
		game.printRules();
		
		String replay = "";
		
		System.out.print("- Enter (Y) to start the challenge: ");
		replay = s.next();
		System.out.println();
		System.out.println("--------------------------------------------------------------------------------------------------------------------------");
		
		//System.out.println();
		
		String interactkey = "";
		String prevguess = "";
		
		while (replay.equalsIgnoreCase("y"))
		{
			//Word x = new Word();
			game.gamecount++;
			partial.reset();
			
			//System.out.println("--------------------------------------------------------------------------------------------------------------------------");
			System.out.println("                                                         Game #" + game.gamecount);
			System.out.println("--------------------------------------------------------------------------------------------------------------------------");
			System.out.println();
			
			Word solution = new Word(0);
			
			//System.out.println(solution);
			
			Word g = new Word();
			
			game.correct = false;
			
			while (game.tries <= 6)
			{
				if (game.correct)
				{
					break;
				}
				
				System.out.print("(Attempt #" + game.tries + ") Enter guess: ");
				String guess = s.next();
				guess = guess.toLowerCase();
				
				//solution.printWordList();
				
				if (guess.length() == 5)
				{
					if (solution.findInList(guess))
					{
						prevguess = guess;
						
						g = g.stringToWord(guess);
						
						game.correct = game.compareWords(solution, g);
						
						System.out.println();
						
						game.tries++;
					}
					else
					{
						System.out.println("Please enter a valid word!\n");
						continue;
					}
				}
				else if (guess.equalsIgnoreCase("r"))
				{
					System.out.println("--------------------------------------------------------------------------------------------------------------------------");
					System.out.println();
					game.printRules();
					System.out.println("Your last guess was: \"" + prevguess + "\", and it was: \"" + partial.toString() + "\"");
					System.out.print("Enter (C) to continue the challenge: ");
					interactkey = s.next();
					System.out.println();
					System.out.println("--------------------------------------------------------------------------------------------------------------------------");
					System.out.println();
					
					if (interactkey.equalsIgnoreCase("c"))
						continue;
					else
					{
						break;
					}
				}
				else
				{
					System.out.println("Please enter a 5 letter word!\n");
					continue;
				}
			}
			
			if (!game.correct)
			{
				System.out.println("Game Over... The correct word was: \"" + solution.toString() + "\"");
			}
			else
			{
				game.tries--;
				game.scorelist.add(game.tries);
				System.out.println("Congratulations! You guessed the word in " + game.tries + " tries!");
			}
			
			game.setHighScore();
			System.out.println("Your current high score is: " + game.highscore + " tries!");
			
			System.out.println();
			System.out.print("Would you like to play again? (Y/N): ");
			replay = s.next();
			System.out.println();
			System.out.println("--------------------------------------------------------------------------------------------------------------------------");
			
			
			game.tries = 1;
			prevguess = "";
		}
		
		System.out.println("Hope you enjoyed the challenge!");
		
		if (game.highscore > 1)
		{
			System.out.println("Can you beat it on your first try?");
		}
		else
		{
			System.out.println("You have already beaten the system...");
		}
	}
}
