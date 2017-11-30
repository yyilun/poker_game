//******************************************
//
// class: Card
//
// description: represents a single card
//
//******************************************

public class Card implements Comparable<Card>{
	
	private int suit; // use integers 1-4 to encode the suit
	private int value; // use integers 1-13 to encode the value
	
	public Card(int s, int v){
		suit = s;
		value = v;
		//make a card with suit s and value v
	}
	
	public int getSuit(){
		return suit;
	}
	
	public int getValue(){
		return value;
	}
	
	public int compareTo(Card c){
		int result = 100; // random arbitrary number
		Card other = c;
		if(this.value==other.value){
			if(this.suit>other.suit){
				result = 1;
			}
			if(this.suit<other.suit){
				result = -1;
			}
		}else{
			if(this.value>other.value){
				result = 1;
			}
			if(this.value<other.value){
				result = -1;
			}
		}
		return result;
		// sorts by value then by suit
	}
	
	public String toString(){
		String suitName = "0";
		String valueName = "0";
		if(suit==1){
			suitName = "Clubs";
		}
		if(suit==2){
			suitName = "Diamonds";
		}
		if(suit==3){
			suitName = "Hearts";
		}
		if(suit==4){
			suitName = "Spades";
		}
		if(value==2){
			valueName = "2";
		}
		if(value==3){
			valueName = "3";
		}
		if(value==4){
			valueName = "4";
		}
		if(value==5){
			valueName = "5";
		}
		if(value==6){
			valueName = "6";
		}
		if(value==7){
			valueName = "7";
		}
		if(value==8){
			valueName = "8";
		}
		if(value==9){
			valueName = "9";
		}
		if(value==10){
			valueName = "10";
		}
		if(value==11){
			valueName = "Jack of";
		}
		if(value==12){
			valueName = "Queen of";
		}
		if(value==13){
			valueName = "King of";
		}
		if(value==14){
			valueName = "Ace of";
		}
		return valueName + " " + suitName;
		// use this method to easily print a Card object
	}
}
