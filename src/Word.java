import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Word
{
	/*String l1;
	String l2;
	String l3;
	String l4;
	String l5;*/
	
	List<String> wordslist = new ArrayList<String>();
	
	String[] letters;
	
	//int[] contained;
	
	public Word()
	{
		letters = new String[5];
		
		letters[0] = "";
		letters[1] = "";
		letters[2] = "";
		letters[3] = "";
		letters[4] = "";
	}
	
	public Word(int num) throws FileNotFoundException
	{
		letters = new String[5];
		
		Scanner s = new Scanner(new File("wordlist.txt"));
		
		while (s.hasNextLine())
		{
			wordslist.add(s.nextLine());
		}
		
		Collections.shuffle(wordslist);
		
		String word = wordslist.get(0);
		
		letters[0] = "" + word.charAt(0);
		letters[1] = "" + word.charAt(1);
		letters[2] = "" + word.charAt(2);
		letters[3] = "" + word.charAt(3);
		letters[4] = "" + word.charAt(4);
		
		/*contained = new int[5];
		
		for (int i = 0; i < 5; i++)
		{
			contained[i] = 0;
		}*/
		
		/*l1 = "";
		l2 = "";
		l3 = "";
		l4 = "";
		l5 = "";*/
	}
	
	public Word (char l1, char l2, char l3, char l4, char l5)
	{
		letters = new String[5];
		
		letters[0] = "" + l1;
		letters[1] = "" + l2;
		letters[2] = "" + l3;
		letters[3] = "" + l4;
		letters[4] = "" + l5;
		
		/*this.l1 = "" + l1;
		this.l2 = "" + l2;
		this.l3 = "" + l3;
		this.l4 = "" + l4;
		this.l5 = "" + l5;*/
		
		/*contained = new int[5];
		
		for (int i = 0; i < 5; i++)
		{
			contained[i] = 0;
		}
		
		for (int i = 0; i < 5; i++)
		{
			for (int j = 0; j < 5; j++)
			{
				if (letters[j] == letters[i])
					contained[i]++;
			}
		}*/
	}
	
	/*private void decreaseContained(String l)
	{
		for (int i = 0; i < 5; i++)
		{
			if (letters[i].equalsIgnoreCase(l))
			{
				contained[i]--;
			}
		}
	}*/
	
	public void reset()
	{
		letters[0] = "";
		letters[1] = "";
		letters[2] = "";
		letters[3] = "";
		letters[4] = "";
	}
	
	public boolean contains(String s)
	{
		//boolean c = false;
		
		for (int i = 0; i < 5; i++)
		{
			if (letters[i].equalsIgnoreCase(s))
			{
				//decreaseContained(s.charAt(index) + "");
				return true;
			}
		}
		
		return false;
	}
	
	public int containsIndex(String s)
	{		
		for (int i = 0; i < 5; i++)
		{
			if (letters[i].equalsIgnoreCase(s))
			{
				//decreaseContained(s.charAt(index) + "");
				return i;
			}
		}
		
		return -1;
	}
	
	public Word stringToWord(String s)
	{
		s = s.toLowerCase();
		
		Word w = new Word(s.charAt(0), s.charAt(1), s.charAt(2), s.charAt(3), s.charAt(4));
		
		return w;
	}
	
	public boolean findInList(String word)
	{
		return wordslist.contains(word);
	}
	
	public String toString()
	{
		String s = "";
		
		for (int i = 0; i < 5; i++)
		{
			s += letters[i];
		}
		
		return s;
	}
	
	public void printWordList()
	{
		System.out.println(wordslist);
	}
	
	/*public Word generateWord() throws FileNotFoundException
	{
		Scanner s = new Scanner(new File("wordlist.txt"));
		
		while (s.hasNextLine())
		{
			wordslist.add(s.nextLine());
		}
		
		Collections.shuffle(wordslist);
		
		String word = wordslist.get(0);
		
		letters[0] = "" + word.charAt(0);
		letters[1] = "" + word.charAt(1);
		letters[2] = "" + word.charAt(2);
		letters[3] = "" + word.charAt(3);
		letters[4] = "" + word.charAt(4);
		
		Word x = new Word(word.charAt(0), word.charAt(1), word.charAt(2), word.charAt(3), word.charAt(4));
		
		return x;
	}*/
	
	/*public boolean checkOne(String l1)
	{
		return this.l1.equals(l1);
	}
	
	public boolean checkTwo(String l2)
	{
		return this.l2.equals(l2);
	}
	
	public boolean checkThree(String l3)
	{
		return this.l3.equals(l3);
	}
	
	public boolean checkFour(String l4)
	{
		return this.l4.equals(l4);
	}
	
	public boolean checkFive(String l5)
	{
		return this.l5.equals(l5);
	}
	
	public void setOne(String l1)
	{
		this.l1 = l1;
	}
	
	public void setTwo(String l2)
	{
		this.l2 = l2;
	}
	
	public void setThree(String l3)
	{
		this.l3 = l3;
	}
	
	public void setFour(String l4)
	{
		this.l4 = l4;
	}
	
	public void setFive(String l5)
	{
		this.l5 = l5;
	}
	
	public String toString()
	{
		return l1 + l2 + l3 + l4 + l5;
	}*/
}