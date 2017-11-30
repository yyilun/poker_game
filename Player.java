//******************************************
//
// class: Player
//
// description: represents the player and his hand
// 
//******************************************

import java.util.ArrayList;

public class Player {
	
		
	private ArrayList<Card> hand; // the player's cards
		
	public Player(){
		hand = new ArrayList<Card>();
	}

	public void addCard(Card c){
		hand.add(c);
		// add the card c to the player's hand
	}

	public void removeCard(Card c){
		hand.remove(c);
		// remove the card c from the player's hand
	}
	
	public Card currentCard(int i){
		return hand.get(i);
		// Returns the current card into the game class
	}
	
	public int currentValue(int i){
		Card temp = new Card(0,0);
		temp = hand.get(i);
		return temp.getValue();
		// Returns the value of the current card into the game class
	}
	
	public int currentSuit(int i){
		Card temp = new Card(0,0);
		temp = hand.get(i);
		return temp.getSuit();
		// Returns the value of the suit into the game class
	}
	
	public ArrayList<Card> exportHand(){
		return hand;
		// Returns the entire hand into the game class
	}
	
	public void printCards(){
		for(Card hand : hand){
			System.out.println(hand);
		}
		// Prints the hand
	}
}


