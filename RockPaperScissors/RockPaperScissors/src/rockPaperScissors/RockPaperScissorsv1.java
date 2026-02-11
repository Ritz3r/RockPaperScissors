package rockPaperScissors;
import java.util.Scanner;
import java.util.Random;

public class RockPaperScissorsv1 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);
		
		System.out.println("Welcome to rock paper scissors");
		System.out.println("Please enter rock, paper or scissors: ");
		String playerChoice = scanner.next();
		
		
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
		
		scanner.close();
	}

}
