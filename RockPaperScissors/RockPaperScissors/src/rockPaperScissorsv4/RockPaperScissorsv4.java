package rockPaperScissorsv4;
import java.util.Scanner;
import java.util.Random;

public class RockPaperScissorsv4 {
	
	
	public static String getUserChoice(Scanner scanner) {
		String choice;
		
		while(true) {
			System.out.println("Enter rock, paper or scissors: ");
			choice = scanner.next().toLowerCase();
			
			if (choice.equals("rock") || choice.equals("paper") || choice.equals("scissors")) {
				break;
			}
			else {
				System.out.println("Invalid input, please enter again: ");
			}
		}

		return choice;
	}
	
	public static String getComputerChoice() {
		Random random = new Random();
		int randomNum = random.nextInt(3);
		String computerChoice = "";
		
		switch (randomNum) {
		case 0:
			computerChoice = "rock";
			break;
		case 1:
			computerChoice = "paper";
			break;
		default:
			computerChoice = "scissors";
		}
		
		return computerChoice;
	}
	
	public static int getRoundWinner(String playerChoice, String computerChoice) {
		System.out.println("You chose: "+playerChoice );
		System.out.println("The computer chose: "+computerChoice);
		
		if (playerChoice.equals(computerChoice)) {
			System.out.println("It is a draw!\n");
			return 0;
		}
		else if ((playerChoice.equals("rock") && computerChoice.equals("scissors")) ||
				(playerChoice.equals("paper") && computerChoice.equals("rock"))||
				(playerChoice.equals("scissors") && computerChoice.equals("paper"))) {
			System.out.println("You WIN!\n");
			return 1;
		}
		else {
			System.out.println("You lost....\n");
			return -1;
		}
	}
	

	public static int getNumberOfRounds(Scanner scanner) {
		int rounds = 0;
		while(true) {
			System.out.println("Enter how many rounds you would like to play: ");
			String input = scanner.next();
			
			try {
				rounds = Integer.parseInt(input);
				
				if(rounds > 0) {
					System.out.println("You have selected to play "+rounds+" rounds");
					break;
				}
				else {
					System.out.println("You have entered an invalid number, try again.");
				}
			} catch(NumberFormatException e) {
				System.out.println("You have entered an invalid input, try again");
			}
			
		}

		return rounds;
	}
	
	public static void printScores(int userScore, int computerScore, int drawScore) {
		System.out.println("You won "+(userScore)+" times!");
		System.out.println("The computer won "+(computerScore)+" times");
		System.out.println("You drew "+(drawScore)+" times\n");
		
		if (userScore>computerScore) {
			System.out.println("YOU WON IT ALL!");
		}
		else if (computerScore>userScore) {
			System.out.println("You lost it all...");
		}
		else {
			System.out.println("You drew.........");
		}
	}
	public static void main(String []args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Welcome to Rock Paper Scissors!");
		int rounds = getNumberOfRounds(scanner);
		int userScore = 0;
		int computerScore = 0;
		int drawScore=0;
		
		for (int i = 0; i < rounds; i++) {
			System.out.println("\n Round "+(i+1));
			
			String userChoice = getUserChoice(scanner);
			String computerChoice = getComputerChoice();	
			int result = getRoundWinner(userChoice,computerChoice);
			
			if (result == 1) {
				userScore++;
			}
			else if (result == -1) {
				computerScore++;
			}
			else {
				drawScore++;
			}
		}
		
		printScores(userScore,computerScore,drawScore);
		scanner.close();
	}
}
