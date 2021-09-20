

import java.util.Scanner;
/**
 * This is the driver class to accompany RNG
 * It prompts users to guess random numbers and gives some hints.
 * @author Yana Li
 */


public class RandomNumberGuesser 
{
	public static void main(String[] args) 
	{
		
		String decision= "no";
		Scanner kb= new Scanner (System.in);
		
		do{ 
			int lowGuess=0;
			int highGuess=100;
			int x=0;
			int nextGuess;
			
			System.out.println ("Enter your first guess: ");
			nextGuess= kb.nextInt();
			int randNum= RNG.rand();
			
			boolean valid=false;
			
			while  ( nextGuess != randNum ) 
			{	
				if ( valid== RNG.inputValidation(nextGuess, lowGuess, highGuess))
				{
					nextGuess= kb.nextInt();
					x-=1;
				}
					
				else 
				{	
					if (nextGuess > randNum) 
					{	System.out.println("Number of guess is: "+ ( RNG.getCount() +x) );
						System.out.println("Your guess is too high");
						highGuess= nextGuess;
						System.out.println("Enter your next guess between "+ lowGuess +" and "+  highGuess);
						nextGuess= kb.nextInt();
					}	
					else if (nextGuess < randNum) 
					{	System.out.println("Number of guess is: "+ ( RNG.getCount() +x) );
						System.out.println("Your guess is too low");
						lowGuess= nextGuess;
						System.out.println("Enter your next guess between "+ lowGuess +" and "+  highGuess);	
						nextGuess= kb.nextInt();
					}
				}
			}	
			if (nextGuess == randNum) 
			{
				System.out.println ("Congratulations, you guessed correctly. Try again? (yes or no)");
				kb.nextLine();
				decision= kb.nextLine();
				if (decision.equalsIgnoreCase("no"))
					System.out.println ("Thanks for playing.");
			}	
			RNG.resetCount();
		}
				
		
		while (decision.equalsIgnoreCase ("yes"));
		
		
	}
}

	
				
				
		
		

