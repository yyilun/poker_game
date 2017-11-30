//******************************************
//
// class: Deck
//
// description: contains a full deck
// 
//******************************************

public class Deck {
	
	private Card[] theDeck;
	private int top; // the index of the top of the deck
	
	public Deck(){
		theDeck = new Card[52];
		int index = 0;
		top = 0;
		for(int i=1; i<5; i++){
			for(int j=2; j<15; j++){ //Starts with 2 since ace is biggest
				theDeck[index] = new Card(i, j);
				index++;
			}
		}
	}
	
	public void shuffle(){
		for(int i=0; i<1000; i++){
			int card1 = (int) (Math.random()*52);
			int card2 = (int) (Math.random()*52);
			Card temp = new Card(0,0);
			temp = theDeck[card1];
			theDeck[card1] = theDeck[card2];
			theDeck[card2] = temp;	
		}
		top = 0; // Resets the top of the deck after shuffling
	}
	
	public Card deal(){
		top++;
		return theDeck[top-1];
		// Will not run out out of 52 cards since each game you deal at most 10 cards
		// deal the top card in the deck
	}

}
