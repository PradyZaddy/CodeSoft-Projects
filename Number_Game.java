import java.util.*;

public class Number_Game 
{

	public static void main(String[] args)
	{
		int max = 100;
		int min = 1;
		boolean playing = true;
		
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);


		while (playing)
		{
			int numberToGuess = random.nextInt(100) + 1;
			int attempts = 0;
			boolean guessed = false;			
			
			while (attempts < 5 && guessed == false)
			{
				attempts++;
				System.out.println("Enter your number: ");
				int userInput = scanner.nextInt();
				
				if (userInput == numberToGuess)
				{
					System.out.println("You guessed the right number! ");
					guessed = true;
					
				}
				
				else if (userInput < numberToGuess)
				{
					System.out.println("Too low! ");
				}
				
				else
				{
					System.out.println("Too high! ");
				}
				
				
			}
			if (guessed == false)
			{
				System.out.println("Sorry, you are out of attempts! ");
				break;
			}
			
			System.out.println();
			
			System.out.println("Type 'yes' to play again or 'no' to quit");
			String userAnswer = scanner.next();
			
			if (userAnswer.equalsIgnoreCase("yes"))
			{
				playing = true;
			}
			else
			{
				System.out.println("Thanks for playing! ");
				playing = false;
			}
			

		}

		
		
		
	}
}
