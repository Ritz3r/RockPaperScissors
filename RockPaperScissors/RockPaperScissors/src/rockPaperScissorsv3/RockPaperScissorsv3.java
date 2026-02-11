package rockPaperScissorsv3;
import java.util.Scanner;
import java.util.Random;

public class RockPaperScissorsv3 {
	
	
	public static String getUserChoice() {
		Scanner scanner = new Scanner(System.in);
		
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
	
	public static void getWinner(String playerChoice, String computerChoice) {
		System.out.println("You chose: "+playerChoice );
		System.out.println("The computer chose: "+computerChoice);
		
		if (playerChoice.equals(computerChoice)) {
			System.out.println("It is a draw!");
		}
		else if ((playerChoice.equals("rock") && computerChoice.equals("scissors")) ||
				(playerChoice.equals("paper") && computerChoice.equals("rock"))||
				(playerChoice.equals("scissors") && computerChoice.equals("paper"))) {
			System.out.println("You WIN!");
		}
		else {
			System.out.println("You lost....");
		}
	}
	

	public static int getNumberOfRounds() {
		Scanner scanner = new Scanner(System.in);
		
		int rounds = 0;
		while(true) {
			System.out.println("Enter how many rounds you would like to play: ");
			rounds = scanner.nextInt();
			
			if(rounds > 0) {
				System.out.println("You have selected to play "+rounds+" rounds");
				break;
			}
			else {
				System.out.println("You have entered an invalid number, try again.");
			}
		}

		return rounds;
	}
	public static void main(String []args) {
		System.out.println("Welcome to Rock Paper Scissors!");
		int rounds = getNumberOfRounds();
		for (int i = 0; i < rounds; i++) {
			String userChoice = getUserChoice();
			String computerChoice = getComputerChoice();	
			getWinner(userChoice,computerChoice);
			
		}
	}

}
