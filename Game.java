
//******************************************
//
// class: Game
//
// description: plays the poker game
// 
//******************************************

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Game {

	private Player p;
	private Deck cards;
	private boolean regularGame;
	private final int HAND_SIZE = 5;
	Scanner scan = new Scanner(System.in);

	// Constructor for when there is command line argument
	public Game(String[] testHand) {
		p = new Player();
		cards = new Deck();
		regularGame = false;
		
		//Converts each input into a card
		for (int i = 0; i < testHand.length; i++) {
			char suit = testHand[i].charAt(0);
			
			// Sets the value
			int v = Integer.parseInt(testHand[i].substring(1));
			
			// Makes ace the biggest card
			if (v == 1) {
				v = 14;
			}
			
			// Sets the suit
			int s = 0;
			if (suit == 'c') {
				s = 1;
			}
			if (suit == 'd') {
				s = 2;
			}
			if (suit == 'h') {
				s = 3;
			}
			if (suit == 's') {
				s = 4;
			}
			
			
			Card tempCard = new Card(s, v);
			p.addCard(tempCard);// Adds the card into the player's hand
		}
	}

	public Game() {
		p = new Player();
		cards = new Deck();
		regularGame = true;

		// This constructor is to actually play a normal game

	}

	public void play() {
		// For a regular game
		if (regularGame) {
			boolean playAgain = true;
			while (playAgain) { // loop for playing again
				System.out.println("Welcome to video poker");
				System.out.println("Your five cards are: ");

				// Shuffles card
				cards.shuffle();

				// Deals 5 cards
				for (int i = 0; i < HAND_SIZE; i++) {
					p.addCard(cards.deal());
				}
				p.printCards();

				System.out.println("You now have the option to change up to five cards. 0 for keep, 1 for change");
				int cardsChanged = 0;// To keep track of how many cards are
										// changed
										// so as to replace with the right
										// number of cards
				int cardCount = 0;// To keep track of how many cards are not
									// changed
									// so as not to remove them
				for (int i = 0; i < HAND_SIZE; i++) {
					System.out.println("Would you like to change card " + (i + 1) + "?");
					int wantToChange = scan.nextInt();
					if (wantToChange == 1) {
						p.removeCard(p.currentCard(cardCount));
						cardsChanged++;
						System.out.println("Your card has been changed");
					} else {
						if (wantToChange == 0) {
							cardCount++;
						} else {
							System.out.println("You have entered the wrong input. GAME TERMINATED");
							return;// To prevent wrong input
						}
					}
				}
				for (int i = 0; i < cardsChanged; i++) {
					p.addCard(cards.deal());
				}
				System.out.println("Your final hand is: ");
				p.printCards();
				System.out.println("Your result is: ");
				System.out.println(checkHand(p.exportHand()));
				System.out.println("Do you want to play again? 0 for no, 1 for yes");
				int wantToRepeat = scan.nextInt();
				if (wantToRepeat == 1) {
					playAgain = true;
					for (int j = 0; j < HAND_SIZE; j++) {
						p.removeCard(p.currentCard(0));// Removes the previous
														// hand
					}
				} else {
					playAgain = false;
					return; // Ends the game
				}

			}
		} else {
			// This is used when command line argument is passed
			System.out.println("You have selected: ");
			p.printCards();
			System.out.println("Your result is: ");
			System.out.println(checkHand(p.exportHand()));
		}
	}


	public String checkHand(ArrayList<Card> hand) {
		String results = "No pair";
		Collections.sort(p.exportHand());
		if (pair()) {
			results = "One pair";
		}
		if (twoPairs()) {
			results = "Two pairs";
		}
		if (trips()) {
			results = "Three of a kind";
		}
		if (straight()) {
			results = "Straight";
		}
		if (flush()) {
			results = "Flush";
		}
		if (fullHouse()) {
			results = "Full house";
		}
		if (fourOfAKind()) {
			results = "Four of a kind";
		}
		if (straightFlush()) {
			results = "Straight flush";
		}
		if (royalFlush()) {
			results = "Royal Flush";
		}
		return results;
		// this method should take an ArrayList of cards
		// as input and then determine what evaluates to and
		// return that as a String

	}

	private boolean pair() {
		for (int i = 0; i < HAND_SIZE-1; i++) {
			if (p.currentValue(i) == p.currentValue(i + 1)) {
				return true;
			}
		}
		return false;
	}

	private boolean twoPairs() {
		int pairCount = 0;
		for (int i = 0; i < HAND_SIZE-1; i++) {
			if (p.currentValue(i) == p.currentValue(i + 1)) {
				pairCount++;
				i++;
			}
		}
		if (pairCount == 2) {
			return true;
		} else {
			return false;
		}
	}

	private boolean trips() {
		for (int i = 0; i < HAND_SIZE-2; i++) {
			if (p.currentValue(i) == p.currentValue(i + 1) && p.currentValue(i + 1) == p.currentValue(i + 2)) {
				return true;
			}
		}
		return false;
	}

	private boolean straight() {
		if (pair()) {
			return false;
		} else {
			if (p.currentValue(HAND_SIZE-1) == p.currentValue(0) + 4) {
				return true;
			}
			if(p.currentValue(HAND_SIZE-1)==14 && p.currentValue(HAND_SIZE-2) == p.currentValue(0) + 3){
				return true;
			}
		}
		return false;
	}

	private boolean flush() {
		int suitCount = 1;
		for (int i = 0; i < HAND_SIZE-1; i++) {
			if (p.currentSuit(i) == p.currentSuit(i + 1)) {
				suitCount++;
			}
		}
		if (suitCount == 5) {
			return true;
		} else {
			return false;
		}
	}

	private boolean fullHouse() {
		if (trips()) {
			if (twoPairs()) {
				return true;
			}
		}
		return false;
	}

	private boolean fourOfAKind() {
		if (p.currentValue(0) == p.currentValue(3)) {
			return true;
		}
		if (p.currentValue(1) == p.currentValue(4)) {
			return true;
		}
		return false;
	}

	private boolean straightFlush() {
		if (straight()) {
			if (flush()) {
				return true;
			}
		}
		return false;
	}

	private boolean royalFlush() {
		if (flush()) {
			if (p.currentValue(0) == 10) {
				if (p.currentValue(4) == 14) {
					return true;
				}
			}
		}
		return false;
	}

}
