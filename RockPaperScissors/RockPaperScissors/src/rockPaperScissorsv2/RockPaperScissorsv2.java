package rockPaperScissorsv2;
import java.util.Scanner;
import java.util.Random;

public class RockPaperScissorsv2 {
	
	
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
	
	
	public static void main(String []args) {
		System.out.println("Welcome to Rock Paper Scissors!");
		String playerChoice = getUserChoice();
		String computerChoice = getComputerChoice();
		
		getWinner(playerChoice,computerChoice);
		
	}

}
