package util;

import poker_lib.Card;

public class PreflopHandRanker{
	
	public static int getHandValue(int numPlayers, Card hand1, Card hand2){
		
		if(numPlayers == 2){
			return value2Players(hand1, hand2); 
		}
		else if(numPlayers == 3){
			return value3Players(hand1, hand2);
		}
		else if(numPlayers == 4){
			return value4Players(hand1, hand2);
		}
		else if(numPlayers == 6){
			return value6Players(hand1, hand2);
		}
		else if(numPlayers == 8){
			return value8Players(hand1, hand2);
		}
		else{
			return value10Players(hand1, hand2);
		}
	}
	
	private static int value2Players(Card c1, Card c2){
		
		// if hand is a pair
		if(c1.getRank() == c2.getRank()){
			switch(c1.getRank()){
			case Card.RANK_2: return 13;
			case Card.RANK_3: return 16;
			case Card.RANK_4: return 18;
			case Card.RANK_5: return 21;
			case Card.RANK_6: return 23;
			case Card.RANK_7: return 25;
			case Card.RANK_8: return 27;
			case Card.RANK_9: return 30;
			case Card.RANK_10: return 32;
			case Card.RANK_JACK: return 34;
			case Card.RANK_QUEEN: return 36;
			case Card.RANK_KING: return 37;
			default: return 40;
			}
		}
		// if suited
		else if(c1.getSuit() == c2.getSuit()){
			switch(c1.getRank()){
			case Card.RANK_2:{
				switch(c2.getRank()){
				case Card.RANK_3:
					return 2;
				case Card.RANK_4:
					return 3;
				case Card.RANK_8:
					return 6;
				case Card.RANK_9:
					return 7;
				case Card.RANK_10:
					return 9;
				case Card.RANK_JACK:
					return 11;
				case Card.RANK_QUEEN:
					return 13;
				case Card.RANK_KING:
					return 15;
				case Card.RANK_ACE:
					return 18;
				default: return 4;
				}
			}
			case Card.RANK_3:{
				switch(c2.getRank()){
				case Card.RANK_4:
					return 4;
				case Card.RANK_8:
					return 6;
				case Card.RANK_9:
					return 8;
				case Card.RANK_10:
					return 10;
				case Card.RANK_JACK:
					return 12;
				case Card.RANK_QUEEN:
					return 14;
				case Card.RANK_KING:
					return 16;
				case Card.RANK_ACE:
					return 19;
				default: return 5;
				}
			}
			case Card.RANK_4:{
				switch(c2.getRank()){
				case Card.RANK_5:
				case Card.RANK_6:
					return 6;
				case Card.RANK_9:
					return 8;
				case Card.RANK_10:
					return 10;
				case Card.RANK_JACK:
					return 12;
				case Card.RANK_QUEEN:
					return 14;
				case Card.RANK_KING:
					return 17;
				case Card.RANK_ACE:
					return 20;
				default: return 7;
				}
			}
			case Card.RANK_5:{
				switch(c2.getRank()){
				case Card.RANK_8:
					return 9;
				case Card.RANK_9:
					return 10;
				case Card.RANK_10:
					return 11;
				case Card.RANK_JACK:
					return 13;
				case Card.RANK_QUEEN:
					return 15;
				case Card.RANK_KING:
					return 17;
				case Card.RANK_ACE:
					return 20;
				default: return 8;
				}
			}
			case Card.RANK_6:{
				switch(c2.getRank()){
				case Card.RANK_7:
					return 9;
				case Card.RANK_8:
					return 10;
				case Card.RANK_9:
					return 11;
				case Card.RANK_10:
					return 12;
				case Card.RANK_JACK:
					return 13;
				case Card.RANK_QUEEN:
					return 16;
				case Card.RANK_KING:
					return 18;
				default: return 20;
				}
			}
			case Card.RANK_7:{
				switch(c2.getRank()){
				case Card.RANK_8:
					return 11;
				case Card.RANK_9:
					return 12;
				case Card.RANK_10:
					return 13;
				case Card.RANK_JACK:
					return 15;
				case Card.RANK_QUEEN:
					return 16;
				case Card.RANK_KING:
					return 19;
				default:
					return 21;
				}
			}
			case Card.RANK_8:{
				switch(c2.getRank()){
				case Card.RANK_9:
					return 13;
				case Card.RANK_10:
					return 15;
				case Card.RANK_JACK:
					return 16;
				case Card.RANK_QUEEN:
					return 17;
				case Card.RANK_KING:
					return 19;
				default:
					return 22;
				}
			}
			case Card.RANK_9:{
				switch(c2.getRank()){
				case Card.RANK_10:
					return 16;
				case Card.RANK_JACK:
					return 17;
				case Card.RANK_QUEEN:
					return 19;
				case Card.RANK_KING:
					return 20;
				default:
					return 23;
				}
			}
			case Card.RANK_10:{
				switch(c2.getRank()){
				case Card.RANK_JACK:
					return 19;
				case Card.RANK_QUEEN:
					return 20;
				case Card.RANK_KING:
					return 22;
				default:
					return 24;
				}
			}
			case Card.RANK_JACK:{
				switch(c2.getRank()){
				case Card.RANK_QUEEN:
					return 21;
				case Card.RANK_KING:
					return 22;
				default:
					return 25;
				}
			}
			case Card.RANK_QUEEN:{
				switch(c2.getRank()){
				case Card.RANK_KING:
					return 23;
				default:
					return 25;
				}
			}
			default:
				return 26;
			}
		}
		// if unsuited
		else{
			switch(c1.getRank()){
			case Card.RANK_2:{
				switch(c2.getRank()){
				case Card.RANK_3:
				case Card.RANK_4:
					return 0;
				case Card.RANK_8:
					return 3;
				case Card.RANK_9:
					return 5;
				case Card.RANK_10:
					return 7;
				case Card.RANK_JACK:
					return 9;
				case Card.RANK_QUEEN:
					return 11;
				case Card.RANK_KING:
					return 13;
				case Card.RANK_ACE:
					return 17;
				default: return 1;
				}
			}
			case Card.RANK_3:{
				switch(c2.getRank()){
				case Card.RANK_7:
				case Card.RANK_8:
					return 3;
				case Card.RANK_9:
					return 5;
				case Card.RANK_10:
					return 7;
				case Card.RANK_JACK:
					return 9;
				case Card.RANK_QUEEN:
					return 12;
				case Card.RANK_KING:
					return 14;
				case Card.RANK_ACE:
					return 17;
				default: return 2;
				}
			}
			case Card.RANK_4:{
				switch(c2.getRank()){
				case Card.RANK_8:
					return 5;
				case Card.RANK_9:
					return 6;
				case Card.RANK_10:
					return 8;
				case Card.RANK_JACK:
					return 10;
				case Card.RANK_QUEEN:
					return 12;
				case Card.RANK_KING:
					return 15;
				case Card.RANK_ACE:
					return 18;
				default: return 4;
				}
			}
			case Card.RANK_5:{
				switch(c2.getRank()){
				case Card.RANK_6:
					return 5;
				case Card.RANK_9:
					return 7;
				case Card.RANK_10:
					return 9;
				case Card.RANK_JACK:
					return 11;
				case Card.RANK_QUEEN:
					return 13;
				case Card.RANK_KING:
					return 15;
				case Card.RANK_ACE:
					return 19;
				default: return 6;
				}
			}
			case Card.RANK_6:{
				switch(c2.getRank()){
				case Card.RANK_7:
					return 7;
				case Card.RANK_8:
					return 8;
				case Card.RANK_9:
					return 9;
				case Card.RANK_10:
					return 10;
				case Card.RANK_JACK:
					return 11;
				case Card.RANK_QUEEN:
					return 14;
				case Card.RANK_KING:
					return 16;
				default: return 19;
				}
			}
			case Card.RANK_7:{
				switch(c2.getRank()){
				case Card.RANK_8:
					return 9;
				case Card.RANK_9:
					return 10;
				case Card.RANK_10:
					return 11;
				case Card.RANK_JACK:
					return 13;
				case Card.RANK_QUEEN:
					return 14;
				case Card.RANK_KING:
					return 17;
				default: return 20;
				}
			}
			case Card.RANK_8:{
				switch(c2.getRank()){
				case Card.RANK_9:
					return 11;
				case Card.RANK_10:
					return 13;
				case Card.RANK_JACK:
					return 14;
				case Card.RANK_QUEEN:
					return 16;
				case Card.RANK_KING:
					return 17;
				default: return 20;
				}
			}
			case Card.RANK_9:{
				switch(c2.getRank()){
				case Card.RANK_10:
					return 14;
				case Card.RANK_JACK:
					return 15;
				case Card.RANK_QUEEN:
					return 17;
				case Card.RANK_KING:
					return 19;
				default: return 21;
				}
			}
			case Card.RANK_10:{
				switch(c2.getRank()){
				case Card.RANK_JACK:
					return 17;
				case Card.RANK_QUEEN:
					return 18;
				case Card.RANK_KING:
					return 20;
				default: return 22;
				}
			}
			case Card.RANK_JACK:{
				switch(c2.getRank()){
				case Card.RANK_QUEEN:
					return 19;
				case Card.RANK_KING:
					return 21;
				default:
					return 23;
				}
			}
			case Card.RANK_QUEEN:{
				switch(c2.getRank()){
				case Card.RANK_KING:
					return 22;
				default: return 24;
				}
			}
			default:
				return 24;
			}
		}
	}
	
	private static int value3Players(Card c1, Card c2){
		
		// if hand is a pair
		if(c1.getRank() == c2.getRank()){
			
			switch(c1.getRank()){
			case Card.RANK_2: return 7;
			case Card.RANK_3: return 8;
			case Card.RANK_4: return 9;
			case Card.RANK_5: return 11;
			case Card.RANK_6: return 12;
			case Card.RANK_7: return 14;
			case Card.RANK_8: return 16;
			case Card.RANK_9: return 17;
			case Card.RANK_10: return 19;
			case Card.RANK_JACK: return 21;
			case Card.RANK_QUEEN: return 22;
			case Card.RANK_KING: return 24;
			default: return 26;
			}
		}
		// if suited
		else if(c1.getSuit() == c2.getSuit()){
			
			switch(c1.getRank()){
			case Card.RANK_2:{
				switch(c2.getRank()){
				case Card.RANK_9:
					return 5;
				case Card.RANK_10:
					return 6;
				case Card.RANK_JACK:
				case Card.RANK_QUEEN:
					return 7;
				case Card.RANK_KING:
					return 9;
				case Card.RANK_ACE:
					return 10;
				default:
					return 4;
				}
			}
			case Card.RANK_3:{
				switch(c2.getRank()){
				case Card.RANK_10:
					return 6;
				case Card.RANK_JACK:
					return 7;
				case Card.RANK_QUEEN:
					return 8;
				case Card.RANK_KING:
					return 9;
				case Card.RANK_ACE:
					return 11;
				default:
					return 5;
				}
			}
			case Card.RANK_4:{
				switch(c2.getRank()){
				case Card.RANK_JACK:
					return 7;
				case Card.RANK_QUEEN:
					return 8;
				case Card.RANK_KING:
					return 9;
				case Card.RANK_ACE:
					return 11;
				default:
					return 6;
				}
			}
			case Card.RANK_5:{
				switch(c2.getRank()){
				case Card.RANK_7:
				case Card.RANK_8:
					return 6;
				case Card.RANK_JACK:
					return 8;
				case Card.RANK_QUEEN:
					return 9;
				case Card.RANK_KING:
					return 10;
				case Card.RANK_ACE:
					return 12;
				default:
					return 7;
				}
			}
			case Card.RANK_6:{
				switch(c2.getRank()){
				case Card.RANK_10:
				case Card.RANK_JACK:
					return 8;
				case Card.RANK_QUEEN:
					return 9;
				case Card.RANK_KING:
					return 10;
				case Card.RANK_ACE:
					return 11;
				default:
					return 7;
				}
			}
			case Card.RANK_7:{
				switch(c2.getRank()){
				case Card.RANK_8:
				case Card.RANK_9:
					return 8;
				case Card.RANK_KING:
					return 11;
				case Card.RANK_ACE:
					return 12;
				default:
					return 9;
				}
			}
			case Card.RANK_8:{
				switch(c2.getRank()){
				case Card.RANK_9:
				case Card.RANK_10:
					return 9;
				case Card.RANK_KING:
					return 11;
				case Card.RANK_ACE:
					return 13;
				default:
					return 10;
				}
			}
			case Card.RANK_9:{
				switch(c2.getRank()){
				case Card.RANK_10:
					return 10;
				case Card.RANK_KING:
					return 12;
				case Card.RANK_ACE:
					return 13;
				default:
					return 11;
				}
			}
			case Card.RANK_10:{
				switch(c2.getRank()){
				case Card.RANK_KING:
					return 13;
				case Card.RANK_ACE:
					return 14;
				default:
					return 12;
				}
			}
			case Card.RANK_JACK:{
				switch(c2.getRank()){
				case Card.RANK_QUEEN:
					return 13;
				case Card.RANK_KING:
					return 14;
				default:
					return 15;
				}
			}
			case Card.RANK_QUEEN:{
				switch(c2.getRank()){
				case Card.RANK_KING:
					return 14;
				default:
					return 15;
				}
			}
			default:
				return 16;
			}
		}
		// if unsuited
		else{
			switch(c1.getRank()){
			case Card.RANK_2:{
				switch(c2.getRank()){
				case Card.RANK_5:
				case Card.RANK_8:
				case Card.RANK_9:
					return 3;
				case Card.RANK_10:
					return 4;
				case Card.RANK_JACK:
					return 5;
				case Card.RANK_QUEEN:
					return 6;
				case Card.RANK_KING:
					return 7;
				case Card.RANK_ACE:
					return 9;
				default:
					return 2;
				}
			}
			case Card.RANK_3:{
				switch(c2.getRank()){
				case Card.RANK_9:
				case Card.RANK_10:
					return 4;
				case Card.RANK_JACK:
					return 5;
				case Card.RANK_QUEEN:
					return 6;
				case Card.RANK_KING:
					return 7;
				case Card.RANK_ACE:
					return 9;
				default:
					return 3;
				}
			}
			case Card.RANK_4:{
				switch(c2.getRank()){
				case Card.RANK_10:
					return 5;
				case Card.RANK_JACK:
					return 6;
				case Card.RANK_QUEEN:
					return 7;
				case Card.RANK_KING:
					return 8;
				case Card.RANK_ACE:
					return 10;
				default:
					return 4;
				}
			}
			case Card.RANK_5:{
				switch(c2.getRank()){
				case Card.RANK_JACK:
					return 6;
				case Card.RANK_QUEEN:
					return 7;
				case Card.RANK_KING:
					return 8;
				case Card.RANK_ACE:
					return 10;
				default:
					return 5;
				}
			}
			case Card.RANK_6:{
				switch(c2.getRank()){
				case Card.RANK_QUEEN:
					return 7;
				case Card.RANK_KING:
					return 9;
				case Card.RANK_ACE:
					return 10;
				default:
					return 6;
				}
			}
			case Card.RANK_7:{
				switch(c2.getRank()){
				case Card.RANK_QUEEN:
					return 8;
				case Card.RANK_KING:
					return 9;
				case Card.RANK_ACE:
					return 11;
				default:
					return 7;
				}
			}
			case Card.RANK_8:{
				switch(c2.getRank()){
				case Card.RANK_QUEEN:
					return 9;
				case Card.RANK_KING:
					return 10;
				case Card.RANK_ACE:
					return 11;
				default:
					return 8;
				}
			}
			case Card.RANK_9:{
				switch(c2.getRank()){
				case Card.RANK_QUEEN:
					return 10;
				case Card.RANK_KING:
					return 11;
				case Card.RANK_ACE:
					return 12;
				default:
					return 9;
				}
			}
			case Card.RANK_10:{
				switch(c2.getRank()){
				case Card.RANK_KING:
					return 12;
				case Card.RANK_ACE:
					return 13;
				default:
					return 11;
				}
			}
			case Card.RANK_JACK:{
				switch(c2.getRank()){
				case Card.RANK_ACE:
					return 13;
				default:
					return 12;
				}
			}
			case Card.RANK_QUEEN:{
				switch(c2.getRank()){
				case Card.RANK_KING:
					return 13;
				default:
					return 14;
				}
			}
			default:
				return 15;
			}
		}
	}
	
	private static int value4Players(Card c1, Card c2){
		
		// if hand is a pair
		if(c1.getRank() == c2.getRank()){
			
			switch(c1.getRank()){
			case Card.RANK_2: return 6;
			case Card.RANK_3: return 7;
			case Card.RANK_4: return 9;
			case Card.RANK_5: return 10;
			case Card.RANK_6: return 12;
			case Card.RANK_7: return 14;
			case Card.RANK_8: return 16;
			case Card.RANK_9: return 18;
			case Card.RANK_10: return 20;
			case Card.RANK_JACK: return 23;
			case Card.RANK_QUEEN: return 25;
			case Card.RANK_KING: return 28;
			default: return 32;
			}
		}
		// if suited
		else if(c1.getSuit() == c2.getSuit()){
			
			switch(c1.getRank()){
			case Card.RANK_2:{
				switch(c2.getRank()){
				case Card.RANK_5:
				case Card.RANK_9:
					return 5;
				case Card.RANK_10:
					return 6;
				case Card.RANK_JACK:
				case Card.RANK_QUEEN:
					return 7;
				case Card.RANK_KING:
					return 9;
				case Card.RANK_ACE:
					return 11;
				default:
					return 4;
				}
			}
			case Card.RANK_3:{
				switch(c2.getRank()){
				case Card.RANK_5:
				case Card.RANK_10:
					return 6;
				case Card.RANK_JACK:
					return 7;
				case Card.RANK_QUEEN:
					return 8;
				case Card.RANK_KING:
					return 9;
				case Card.RANK_ACE:
					return 11;
				default:
					return 5;
				}
			}
			case Card.RANK_4:{
				switch(c2.getRank()){
				case Card.RANK_5:
				case Card.RANK_10:
				case Card.RANK_JACK:
					return 7;
				case Card.RANK_QUEEN:
					return 8;
				case Card.RANK_KING:
					return 9;
				case Card.RANK_ACE:
					return 12;
				default:
					return 6;
				}
			}
			case Card.RANK_5:{
				switch(c2.getRank()){
				case Card.RANK_JACK:
					return 8;
				case Card.RANK_QUEEN:
					return 9;
				case Card.RANK_KING:
					return 10;
				case Card.RANK_ACE:
					return 12;
				default:
					return 7;
				}
			}
			case Card.RANK_6:{
				switch(c2.getRank()){
				case Card.RANK_QUEEN:
					return 9;
				case Card.RANK_KING:
					return 10;
				case Card.RANK_ACE:
					return 12;
				default:
					return 8;
				}
			}
			case Card.RANK_7:{
				switch(c2.getRank()){
				case Card.RANK_QUEEN:
					return 10;
				case Card.RANK_KING:
					return 11;
				case Card.RANK_ACE:
					return 12;
				default:
					return 9;
				}
			}
			case Card.RANK_8:{
				switch(c2.getRank()){
				case Card.RANK_QUEEN:
				case Card.RANK_KING:
					return 11;
				case Card.RANK_ACE:
					return 13;
				default:
					return 10;
				}
			}
			case Card.RANK_9:{
				switch(c2.getRank()){
				case Card.RANK_KING:
					return 13;
				case Card.RANK_ACE:
					return 14;
				default:
					return 12;
				}
			}
			case Card.RANK_10:{
				switch(c2.getRank()){
				case Card.RANK_JACK:
					return 13;
				case Card.RANK_ACE:
					return 15;
				default:
					return 14;
				}
			}
			case Card.RANK_JACK:{
				switch(c2.getRank()){
				case Card.RANK_QUEEN:
					return 14;
				case Card.RANK_KING:
					return 15;
				default:
					return 16;
				}
			}
			case Card.RANK_QUEEN:{
				switch(c2.getRank()){
				case Card.RANK_KING:
					return 16;
				default:
					return 17;
				}
			}
			default:
				return 18;
			}
		}
		// if unsuited
		else{
			switch(c1.getRank()){
			case Card.RANK_2:{
				switch(c2.getRank()){
				case Card.RANK_3:
				case Card.RANK_7:
					return 1;
				case Card.RANK_9:
				case Card.RANK_10:
					return 3;
				case Card.RANK_JACK:
					return 4;
				case Card.RANK_QUEEN:
					return 5;
				case Card.RANK_KING:
					return 6;
				case Card.RANK_ACE:
					return 8;
				default:
					return 2;
				}
			}
			case Card.RANK_3:{
				switch(c2.getRank()){
				case Card.RANK_7:
				case Card.RANK_8:
					return 2;
				case Card.RANK_10:
				case Card.RANK_JACK:
					return 4;
				case Card.RANK_QUEEN:
					return 5;
				case Card.RANK_KING:
					return 7;
				case Card.RANK_ACE:
					return 9;
				default:
					return 3;
				}
			}
			case Card.RANK_4:{
				switch(c2.getRank()){
				case Card.RANK_8:
				case Card.RANK_9:
					return 3;
				case Card.RANK_JACK:
					return 5;
				case Card.RANK_QUEEN:
					return 6;
				case Card.RANK_KING:
					return 7;
				case Card.RANK_ACE:
					return 9;
				default:
					return 4;
				}
			}
			case Card.RANK_5:{
				switch(c2.getRank()){
				case Card.RANK_6:
				case Card.RANK_7:
				case Card.RANK_JACK:
					return 5;
				case Card.RANK_QUEEN:
					return 6;
				case Card.RANK_KING:
					return 8;
				case Card.RANK_ACE:
					return 10;
				default:
					return 4;
				}
			}
			case Card.RANK_6:{
				switch(c2.getRank()){
				case Card.RANK_KING:
					return 7;
				case Card.RANK_QUEEN:
					return 8;
				case Card.RANK_ACE:
					return 9;
				default:
					return 6;
				}
			}
			case Card.RANK_7:{
				switch(c2.getRank()){
				case Card.RANK_KING:
					return 9;
				case Card.RANK_ACE:
					return 10;
				default:
					return 7;
				}
			}
			case Card.RANK_8:{
				switch(c2.getRank()){
				case Card.RANK_QUEEN:
				case Card.RANK_KING:
					return 9;
				case Card.RANK_ACE:
					return 11;
				default:
					return 8;
				}
			}
			case Card.RANK_9:{
				switch(c2.getRank()){
				case Card.RANK_KING:
					return 11;
				case Card.RANK_ACE:
					return 12;
				default:
					return 10;
				}
			}
			case Card.RANK_10:{
				switch(c2.getRank()){
				case Card.RANK_JACK:
					return 11;
				case Card.RANK_ACE:
					return 13;
				default:
					return 12;
				}
			}
			case Card.RANK_JACK:{
				switch(c2.getRank()){
				case Card.RANK_ACE:
					return 14;
				default:
					return 13;
				}
			}
			case Card.RANK_QUEEN:{
				switch(c2.getRank()){
				case Card.RANK_KING:
					return 14;
				default:
					return 15;
				}
			}
			default:
				return 16;
			}
		}
	}
	
	private static int value6Players(Card c1, Card c2){
		
		// if hand is a pair
		if(c1.getRank() == c2.getRank()){
			
			switch(c1.getRank()){
			case Card.RANK_2: return 7;
			case Card.RANK_3: return 8;
			case Card.RANK_4: return 9;
			case Card.RANK_5: return 10;
			case Card.RANK_6: return 11;
			case Card.RANK_7: return 13;
			case Card.RANK_8: return 15;
			case Card.RANK_9: return 18;
			case Card.RANK_10: return 21;
			case Card.RANK_JACK: return 25;
			case Card.RANK_QUEEN: return 29;
			case Card.RANK_KING: return 34;
			default: return 40;
			}
		}
		// if suited
		else if(c1.getSuit() == c2.getSuit()){
			
			switch (c1.getRank()){
				case Card.RANK_2:{
					switch (c2.getRank()){
					case Card.RANK_3:
					case Card.RANK_7:
						return 4;
					case Card.RANK_4:
					case Card.RANK_5:
					case Card.RANK_6:
					case Card.RANK_8:
					case Card.RANK_9:
						return 5;
					case Card.RANK_10:
						return 6;
					case Card.RANK_JACK:
						return 7;
					case Card.RANK_QUEEN:
						return 8;
					case Card.RANK_KING:
						return 9;
					default:
						return 12;
					}
				}
				case Card.RANK_3:{
					switch (c2.getRank()){
					case Card.RANK_4:
					case Card.RANK_6:
					case Card.RANK_9:
						return 6;
					case Card.RANK_5:
					case Card.RANK_10:
					case Card.RANK_JACK:
						return 7;
					case Card.RANK_7:
					case Card.RANK_8:
						return 5;
					case Card.RANK_QUEEN:
						return 8;
					case Card.RANK_KING:
						return 10;
					default:
						return 12;
					}
				}
				case Card.RANK_4:{
					switch (c2.getRank()){
					case Card.RANK_5:
					case Card.RANK_JACK:
						return 8;
					case Card.RANK_6:
					case Card.RANK_7:
					case Card.RANK_10:
						return 7;
					case Card.RANK_8:
					case Card.RANK_9:
						return 6;
					case Card.RANK_QUEEN:
						return 9;
					case Card.RANK_KING:
						return 10;
					default:
						return 13;
					}
				}
				case Card.RANK_5:{
					switch (c2.getRank()){
					case Card.RANK_6:
					case Card.RANK_7:
					case Card.RANK_8:
					case Card.RANK_JACK:
						return 8;
					case Card.RANK_9:
					case Card.RANK_10:
						return 7;
					case Card.RANK_QUEEN:
						return 9;
					case Card.RANK_KING:
						return 11;
					default: return 13;
					}
				}
				case Card.RANK_6:{
					switch (c2.getRank()){
					case Card.RANK_QUEEN:
						return 10;
					case Card.RANK_KING:
						return 11;
					case Card.RANK_ACE:
						return 13;
					default:
						return 9;
					}
				}
				case Card.RANK_7:{
					switch (c2.getRank()){
					case Card.RANK_KING:
						return 12;
					case Card.RANK_ACE:
						return 14;
					default:
						return 10;
					}
				}
				case Card.RANK_8:{
					switch (c2.getRank()){
					case Card.RANK_KING:
						return 13;
					case Card.RANK_ACE:
						return 14;
					default:
						return 12;
					}
				}
				case Card.RANK_9:{
					switch (c2.getRank()){
					case Card.RANK_ACE:
						return 15;
					default:
						return 14;
					}
				}
				case Card.RANK_10:{
					switch (c2.getRank()){
					case Card.RANK_KING:
						return 17;
					case Card.RANK_ACE:
						return 18;
					default:
						return 16;
					}
				}
				case Card.RANK_JACK:{
					switch (c2.getRank()){
					case Card.RANK_QUEEN:
						return 17;
					case Card.RANK_KING:
						return 18;
					case Card.RANK_ACE:
						return 19;
					}
				}
				case Card.RANK_QUEEN:{
					switch (c2.getRank()){
					case Card.RANK_KING:
						return 19;
					default:
						return 20;
					}
				}
				default:
					return 22;
			}
		}
		// if unsuited
		else{
			switch(c1.getRank()){
			case Card.RANK_2:{
				switch(c2.getRank()){
				case Card.RANK_3:
				case Card.RANK_7:
					return 0;
				case Card.RANK_10:
					return 2;
				case Card.RANK_JACK:
					return 3;
				case Card.RANK_QUEEN:
					return 4;
				case Card.RANK_KING:
					return 5;
				case Card.RANK_ACE:
					return 8;
				default:
					return 1;
				}
			}
			case Card.RANK_3:{
				switch(c2.getRank()){
				case Card.RANK_4:
				case Card.RANK_6:
				case Card.RANK_10:
					return 2;
				case Card.RANK_5:
				case Card.RANK_JACK:
					return 3;
				case Card.RANK_QUEEN:
					return 4;
				case Card.RANK_KING:
					return 6;
				case Card.RANK_ACE:
					return 8;
				default:
					return 1;
				}
			}
			case Card.RANK_4:{
				switch(c2.getRank()){
				case Card.RANK_5:
				case Card.RANK_JACK:
					return 4;
				case Card.RANK_6:
				case Card.RANK_7:
				case Card.RANK_10:
					return 3;
				case Card.RANK_8:
				case Card.RANK_9:
					return 2;
				case Card.RANK_QUEEN:
					return 5;
				case Card.RANK_KING:
					return 6;
				default:
					return 9;
				}
			}
			case Card.RANK_5:{
				switch(c2.getRank()){
				case Card.RANK_6:
				case Card.RANK_QUEEN:
					return 5;
				case Card.RANK_9:
				case Card.RANK_10:
					return 3;
				case Card.RANK_KING:
					return 7;
				case Card.RANK_ACE:
					return 9;
				default:
					return 4;
				}
			}
			case Card.RANK_6:{
				switch(c2.getRank()){
				case Card.RANK_QUEEN:
					return 6;
				case Card.RANK_KING:
					return 7;
				case Card.RANK_ACE:
					return 9;
				default:
					return 5;
				}
			}
			case Card.RANK_7:{
				switch(c2.getRank()){
				case Card.RANK_8:
					return 7;
				case Card.RANK_KING:
					return 8;
				case Card.RANK_ACE:
					return 10;
				default:
					return 6;
				}
			}
			case Card.RANK_8:{
				switch(c2.getRank()){
				case Card.RANK_KING:
					return 9;
				case Card.RANK_ACE:
					return 10;
				default:
					return 8;
				}
			}
			case Card.RANK_9:{
				switch(c2.getRank()){
				case Card.RANK_KING:
				case Card.RANK_ACE:
					return 11;
				default:
					return 10;
				}
			}
			case Card.RANK_10:{
				switch(c2.getRank()){
				case Card.RANK_ACE:
					return 14;
				default:
					return 13;
				}
			}
			case Card.RANK_JACK:{
				switch(c2.getRank()){
				case Card.RANK_QUEEN:
					return 14;
				default:
					return 15;
				}
			}
			case Card.RANK_QUEEN:{
				switch(c2.getRank()){
				case Card.RANK_KING:
					return 16;
				default:
					return 17;
				}
			}
			default:
				return 19;
			}
		}
	}
	
	private static int value8Players(Card c1, Card c2){

		// if hand is a pair
		if(c1.getRank() == c2.getRank()){
			
			if(c1.getRank() == Card.RANK_2 || c1.getRank() == Card.RANK_3){
				return 9;
			}
			else if(c1.getRank() == Card.RANK_4 || c1.getRank() == Card.RANK_5){
				return 10;
			}
			else if(c1.getRank() == Card.RANK_6){
				return 11;
			}
			else if(c1.getRank() == Card.RANK_7){
				return 13;
			}
			else if(c1.getRank() == Card.RANK_8){
				return 14;
			}
			else if(c1.getRank() == Card.RANK_9){
				return 16;
			}
			else if(c1.getRank() == Card.RANK_10){
				return 19;
			}
			else if(c1.getRank() == Card.RANK_JACK){
				return 23;
			}
			else if(c1.getRank() == Card.RANK_QUEEN){
				return 27;
			}
			else if(c1.getRank() == Card.RANK_KING){
				return 33;
			}
			else{
				return 40;
			}
		}
		// if suited
		if(c1.getSuit() == c2.getSuit()){
			
			if(c1.getRank() == Card.RANK_2){
				
				if(c2.getRank() == Card.RANK_3 || c2.getRank() == Card.RANK_4 || c2.getRank() == Card.RANK_6
						|| c2.getRank() == Card.RANK_9){
					return 6;
				}
				else if(c2.getRank() == Card.RANK_5 || c2.getRank() == Card.RANK_10){
					return 7;
				}
				else if(c2.getRank() == Card.RANK_7 || c2.getRank() == Card.RANK_8){
					return 5;
				}
				else if(c2.getRank() == Card.RANK_JACK){
					return 8;
				}
				else if(c2.getRank() == Card.RANK_QUEEN){
					return 9;
				}
				else if(c2.getRank() == Card.RANK_KING){
					return 10;
				}
				else{
					return 12;
				}
			}
			else if(c1.getRank() == Card.RANK_3){
				
				if(c2.getRank() == Card.RANK_4 || c2.getRank() == Card.RANK_6 || c2.getRank() == Card.RANK_10){
					return 7;
				}
				else if(c2.getRank() == Card.RANK_5 || c2.getRank() == Card.RANK_JACK){
					return 8;
				}
				else if(c2.getRank() == Card.RANK_7 || c2.getRank() == Card.RANK_8 || c2.getRank() == Card.RANK_9){
					return 6;
				}
				else if(c2.getRank() == Card.RANK_QUEEN){
					return 9;
				}
				else if(c2.getRank() == Card.RANK_KING){
					return 10;
				}
				else{
					return 13;
				}
			}
			else if(c1.getRank() == Card.RANK_4){
				
				if(c2.getRank() == Card.RANK_5 || c2.getRank() == Card.RANK_QUEEN){
					return 9;
				}
				else if(c2.getRank() == Card.RANK_6 || c2.getRank() == Card.RANK_7 || c2.getRank() == Card.RANK_JACK){
					return 8;
				}
				else if(c2.getRank() == Card.RANK_8 || c2.getRank() == Card.RANK_9 || c2.getRank() == Card.RANK_10){
					return 7;
				}
				else if(c2.getRank() == Card.RANK_KING){
					return 11;
				}
				else{
					return 13;
				}
			}
			else if(c1.getRank() == Card.RANK_5){
				
				if(c2.getRank() == Card.RANK_6 || c2.getRank() == Card.RANK_QUEEN){
					return 10;
				}
				else if(c2.getRank() == Card.RANK_7 || c2.getRank() == Card.RANK_JACK){
					return 9;
				}
				else if(c2.getRank() == Card.RANK_8 || c2.getRank() == Card.RANK_9 || c2.getRank() == Card.RANK_10){
					return 8;
				}
				else if(c2.getRank() == Card.RANK_KING){
					return 11;
				}
				else{
					return 14;
				}
			}
			else if(c1.getRank() == Card.RANK_6){
				
				if(c2.getRank() == Card.RANK_7 || c2.getRank() == Card.RANK_8 || c2.getRank() == Card.RANK_QUEEN){
					return 10;
				}
				else if(c2.getRank() == Card.RANK_9 || c2.getRank() == Card.RANK_10 || c2.getRank() == Card.RANK_JACK){
					return 9;
				}
				else if(c2.getRank() == Card.RANK_KING){
					return 12;
				}
				else{
					return 13;
				}
			}
			else if(c1.getRank() == Card.RANK_7){
				
				if(c2.getRank() == Card.RANK_8 || c2.getRank() == Card.RANK_9 || c2.getRank() == Card.RANK_10
						|| c2.getRank() == Card.RANK_QUEEN){
					return 11;
				}
				else if(c2.getRank() == Card.RANK_JACK){
					return 10;
				}
				else if(c2.getRank() == Card.RANK_KING){
					return 12;
				}
				else{
					return 14;
				}
			}
			else if(c1.getRank() == Card.RANK_8){
				
				if(c2.getRank() == Card.RANK_KING){
					return 13;
				}
				else if(c2.getRank() == Card.RANK_ACE){
					return 15;
				}
				else{
					return 12;
				}
			}
			else if(c1.getRank() == Card.RANK_9){
				
				if(c2.getRank() == Card.RANK_KING || c2.getRank() == Card.RANK_ACE){
					return 15;
				}
				else{
					return 14;
				}
			}
			else if(c1.getRank() == Card.RANK_10){
				
				if(c2.getRank() == Card.RANK_JACK || c2.getRank() == Card.RANK_QUEEN){
					return 17;
				}
				else{
					return 18;
				}
			}
			else if(c1.getRank() == Card.RANK_JACK){
				
				if(c2.getRank() == Card.RANK_QUEEN){
					return 18;
				}
				else if(c2.getRank() == Card.RANK_KING){
					return 19;
				}
				else{
					return 20;
				}
			}
			else if(c1.getRank() == Card.RANK_QUEEN){
				
				if(c2.getRank() == Card.RANK_KING){
					return 20;
				}
				else{
					return 21;
				}
			}
			else{
				return 23;
			}
		}
		// if unsuited
		else{
			
			if(c1.getRank() == Card.RANK_2){
				
				if(c2.getRank() == Card.RANK_4 || c2.getRank() == Card.RANK_5 || c2.getRank() == Card.RANK_10){
					return 2;
				}
				else if(c2.getRank() == Card.RANK_7){
					return 0;
				}
				else if(c2.getRank() == Card.RANK_JACK){
					return 3;
				}
				else if(c2.getRank() == Card.RANK_QUEEN){
					return 4;
				}
				else if(c2.getRank() == Card.RANK_KING){
					return 5;
				}
				else if(c2.getRank() == Card.RANK_ACE){
					return 7;
				}
				else{
					return 1;
				}
			}
			else if(c1.getRank() == Card.RANK_3){
				
				if(c2.getRank() == Card.RANK_ACE){
					return 8;
				}
				else if(c2.getRank() == Card.RANK_KING){
					return 5;
				}
				else if(c2.getRank() == Card.RANK_QUEEN){
					return 4;
				}
				else if(c2.getRank() == Card.RANK_4 || c2.getRank() == Card.RANK_5 || c2.getRank() == Card.RANK_JACK){
					return 3;
				}
				else if(c2.getRank() == Card.RANK_8 || c2.getRank() == Card.RANK_9){
					return 1;
				}
				else{
					return 2;
				}
			}
			else if(c1.getRank() == Card.RANK_4){
				
				if(c2.getRank() == Card.RANK_5){
					return 5;
				}
				else if(c2.getRank() == Card.RANK_6 || c2.getRank() == Card.RANK_QUEEN){
					return 4;
				}
				else if(c2.getRank() == Card.RANK_7 || c2.getRank() == Card.RANK_10 || c2.getRank() == Card.RANK_JACK){
					return 3;
				}
				else if(c2.getRank() == Card.RANK_8 || c2.getRank() == Card.RANK_9){
					return 2;
				}
				else if(c2.getRank() == Card.RANK_KING){
					return 6;
				}
				else{
					return 8;
				}
			}
			else if(c1.getRank() == Card.RANK_5){
				
				if(c2.getRank() == Card.RANK_6 || c2.getRank() == Card.RANK_7 || c2.getRank() == Card.RANK_QUEEN){
					return 5;
				}
				else if(c2.getRank() == Card.RANK_8 || c2.getRank() == Card.RANK_JACK){
					return 4;
				}
				else if(c2.getRank() == Card.RANK_9 || c2.getRank() == Card.RANK_10){
					return 3;
				}
				else if(c2.getRank() == Card.RANK_KING){
					return 6;
				}
				else{
					return 9;
				}
			}
			else if(c1.getRank() == Card.RANK_6){
				
				if(c2.getRank() == Card.RANK_7 || c2.getRank() == Card.RANK_KING){
					return 6;
				}
				else if(c2.getRank() == Card.RANK_8 || c2.getRank() == Card.RANK_9 || c2.getRank() == Card.RANK_QUEEN){
					return 5;
				}
				else if(c2.getRank() == Card.RANK_10 || c2.getRank() == Card.RANK_JACK){
					return 4;
				}
				else{
					return 8;
				}
			}
			else if(c1.getRank() == Card.RANK_7){
				
				if(c2.getRank() == Card.RANK_8 || c2.getRank() == Card.RANK_KING){
					return 7;
				}
				else if(c2.getRank() == Card.RANK_ACE){
					return 9;
				}
				else{
					return 6;
				}
			}
			else if(c1.getRank() == Card.RANK_8){
				
				if(c2.getRank() == Card.RANK_JACK || c2.getRank() == Card.RANK_QUEEN){
					return 7;
				}
				else if(c2.getRank() == Card.RANK_ACE){
					return 9;
				}
				else{
					return 8;
				}
			}
			else if(c1.getRank() == Card.RANK_9){
				
				if(c2.getRank() == Card.RANK_ACE){
					return 11;
				}
				else{
					return 10;
				}
			}
			else if(c1.getRank() == Card.RANK_10){
				
				if(c2.getRank() == Card.RANK_ACE){
					return 14;
				}
				else{
					return 13;
				}
			}
			else if(c1.getRank() == Card.RANK_JACK){
				
				if(c2.getRank() == Card.RANK_ACE){
					return 15;
				}
				else{
					return 14;
				}
			}
			else if(c1.getRank() == Card.RANK_QUEEN){
				
				if(c2.getRank() ==  Card.RANK_KING){
					return 16;
				}
				else{
					return 17;
				}
			}
			else{
				return 19;
			}
		}
	}
	
	private static int value10Players(Card c1, Card c2){
		
		// if hand is a pair
		if(c1.getRank() == c2.getRank()){
			
			if(c1.getRank() == Card.RANK_2 || c1.getRank() == Card.RANK_3 || c1.getRank() == Card.RANK_4){
				return 11;
			}
			else if(c1.getRank() == Card.RANK_5){
				return 12;
			}
			else if(c1.getRank() == Card.RANK_6 || c1.getRank() == Card.RANK_7){
				return 13;
			}
			else if(c1.getRank() == Card.RANK_8){
				return 15;
			}
			else if(c1.getRank() == Card.RANK_9){
				return 16;
			}
			else if(c1.getRank() == Card.RANK_10){
				return 19;
			}
			else if(c1.getRank() == Card.RANK_JACK){
				return 22;
			}
			else if(c1.getRank() == Card.RANK_QUEEN){
				return 27;
			}
			else if(c1.getRank() == Card.RANK_KING){
				return 32;
			}
			else{
				return 40;
			}
		}
		// if suited
		else if(c1.getSuit() == c2.getSuit()){
			
			if(c1.getRank() == Card.RANK_2){
				
				if(c2.getRank() == Card.RANK_3 || c2.getRank() == Card.RANK_4 || c2.getRank() == Card.RANK_9){
					return 7;
				}
				else if(c2.getRank() == Card.RANK_5 || c2.getRank() == Card.RANK_10 || c2.getRank() == Card.RANK_JACK){
					return 8;
				}
				else if(c2.getRank() == Card.RANK_6 || c2.getRank() == Card.RANK_7 || c2.getRank() == Card.RANK_8){
					return 6;
				}
				else if(c2.getRank() == Card.RANK_QUEEN){
					return 9;
				}
				else if(c2.getRank() == Card.RANK_KING){
					return 11;
				}
				else{
					return 13;
				}
			}
			else if(c1.getRank() == Card.RANK_3){
				
				if(c2.getRank() == Card.RANK_4 || c2.getRank() == Card.RANK_6 || c2.getRank() == Card.RANK_10){
					return 8;
				}
				else if(c2.getRank() == Card.RANK_5 || c2.getRank() == Card.RANK_JACK){
					return 9;
				}
				else if(c2.getRank() == Card.RANK_7 || c2.getRank() == Card.RANK_9){
					return 7;
				}
				else if(c2.getRank() == Card.RANK_8){
					return 6;
				}
				else if(c2.getRank() == Card.RANK_QUEEN){
					return 10;
				}
				else if(c2.getRank() == Card.RANK_KING){
					return 11;
				}
				else{
					return 14;
				}
			}
			else if(c1.getRank() == Card.RANK_4){
				
				if(c2.getRank() == Card.RANK_5 || c2.getRank() == Card.RANK_6 || c2.getRank() == Card.RANK_QUEEN){
					return 10;
				}
				else if(c2.getRank() == Card.RANK_7 || c2.getRank() == Card.RANK_JACK){
					return 9;
				}
				else if(c2.getRank() == Card.RANK_8 || c2.getRank() == Card.RANK_10){
					return 8;
				}
				else if(c2.getRank() == Card.RANK_9){
					return 7;
				}
				else if(c2.getRank() == Card.RANK_KING){
					return 11;
				}
				else{
					return 14;
				}
			}
			else if(c1.getRank() == Card.RANK_5){
				
				if(c2.getRank() == Card.RANK_6){
					return 11;
				}
				else if(c2.getRank() == Card.RANK_7 || c2.getRank() == Card.RANK_QUEEN){
					return 10;
				}
				else if(c2.getRank() == Card.RANK_8 || c2.getRank() == Card.RANK_JACK){
					return 9;
				}
				else if(c2.getRank() == Card.RANK_9 || c2.getRank() == Card.RANK_10){
					return 8;
				}
				else if(c2.getRank() == Card.RANK_KING){
					return 12;
				}
				else{
					return 15;
				}
			}
			else if(c1.getRank() == Card.RANK_6){
				
				if(c2.getRank() == Card.RANK_7 || c2.getRank() == Card.RANK_8 || c2.getRank() == Card.RANK_QUEEN){
					return 11;
				}
				else if(c2.getRank() == Card.RANK_9 || c2.getRank() == Card.RANK_10){
					return 10;
				}
				else if(c2.getRank() == Card.RANK_JACK){
					return 9;
				}
				else if(c2.getRank() == Card.RANK_KING){
					return 12;
				}
				else{
					return 14;
				}
			}
			else if(c1.getRank() == Card.RANK_7){
				
				if(c2.getRank() == Card.RANK_8 || c2.getRank() == Card.RANK_9){
					return 12;
				}
				else if(c2.getRank() == Card.RANK_10 || c2.getRank() == Card.RANK_JACK || c2.getRank() == Card.RANK_QUEEN){
					return 11;
				}
				else if(c2.getRank() == Card.RANK_KING){
					return 13;
				}
				else{
					return 14;
				}
			}
			else if(c1.getRank() == Card.RANK_8){
				
				if(c2.getRank() == Card.RANK_9 || c2.getRank() == Card.RANK_10 || c2.getRank() == Card.RANK_JACK
						|| c2.getRank() == Card.RANK_QUEEN || c2.getRank() == Card.RANK_KING){
					return 13;
				}
				else{
					return 15;
				}				
			}
			else if(c1.getRank() == Card.RANK_9){
				
				if(c2.getRank() == Card.RANK_10 || c2.getRank() == Card.RANK_JACK || c2.getRank() == Card.RANK_QUEEN
						|| c2.getRank() == Card.RANK_KING){
					return 15;
				}
				else{
					return 16;
				}
			}
			else if(c1.getRank() == Card.RANK_10){
				
				if(c2.getRank() == Card.RANK_JACK || c2.getRank() == Card.RANK_QUEEN || c2.getRank() == Card.RANK_KING){
					return 18;
				}
				else return 19;
			}
			else if(c1.getRank() == Card.RANK_JACK){
				
				if(c2.getRank() == Card.RANK_QUEEN){
					return 19;
				}
				else{
					return 20;
				}
			}
			else if(c1.getRank() == Card.RANK_QUEEN){
				
				if(c2.getRank() == Card.RANK_KING){
					return 21;
				}
				else{
					return 22;
				}
			}
			else{
				return 24;
			}
		}
		// if unsuited
		else{
			if(c1.getRank() == Card.RANK_2){
				
				if(c2.getRank() == Card.RANK_3 || c2.getRank() == Card.RANK_6 || c2.getRank() == Card.RANK_9){
					return 1;
				}
				else if(c2.getRank() == Card.RANK_4 || c2.getRank() == Card.RANK_5 || c2.getRank() == Card.RANK_10
						|| c2.getRank() == Card.RANK_JACK){
					return 2;
				}
				else if(c2.getRank() == Card.RANK_7 || c2.getRank() == Card.RANK_8){
					return 0;
				}
				else if(c2.getRank() == Card.RANK_QUEEN){
					return 3;
				}
				else if(c2.getRank() == Card.RANK_KING){
					return 4;
				}
				else{
					return 7;
				}
			}
			else if(c1.getRank() == Card.RANK_3){
				
				if(c2.getRank() == Card.RANK_4 || c2.getRank() == Card.RANK_6 || c2.getRank() == Card.RANK_QUEEN){
					return 3;
				}
				else if(c2.getRank() == Card.RANK_5){
					return 4;
				}
				else if(c2.getRank() == Card.RANK_7 || c2.getRank() == Card.RANK_8 || c2.getRank() == Card.RANK_9){
					return 1;
				}
				else if(c2.getRank() == Card.RANK_10 || c2.getRank() == Card.RANK_JACK){
					return 2;
				}
				else if(c2.getRank() == Card.RANK_KING){
					return 5;
				}
				else{
					return 7;
				}
			}
			else if(c1.getRank() == Card.RANK_4){
				
				if(c2.getRank() == Card.RANK_5 || c2.getRank() == Card.RANK_KING){
					return 5;
				}
				else if(c2.getRank() == Card.RANK_6 || c2.getRank() == Card.RANK_QUEEN){
					return 4;
				}
				else if(c2.getRank() == Card.RANK_7 || c2.getRank() == Card.RANK_JACK){
					return 3;
				}
				else if(c2.getRank() == Card.RANK_8 || c2.getRank() == Card.RANK_10){
					return 2;
				}
				else if(c2.getRank() == Card.RANK_9){
					return 1;
				}
				else{
					return 8;
				}
			}
			else if(c1.getRank() == Card.RANK_5){
				
				if(c2.getRank() == Card.RANK_6){
					return 6;
				}
				else if(c2.getRank() == Card.RANK_7 || c2.getRank() == Card.RANK_KING){
					return 7;
				}
				else if(c2.getRank() == Card.RANK_8 || c2.getRank() == Card.RANK_QUEEN){
					return 4;
				}
				else if(c2.getRank() == Card.RANK_9 || c2.getRank() == Card.RANK_JACK){
					return 3;
				}
				else if(c2.getRank() == Card.RANK_10){
					return 2;
				}
				else{
					return 8;
				}
			}
			else if(c1.getRank() == Card.RANK_6){
				
				if(c2.getRank() == Card.RANK_7 || c2.getRank() == Card.RANK_KING){
					return 6;
				}
				else if(c2.getRank() == Card.RANK_8){
					return 5;
				}
				else if(c2.getRank() == Card.RANK_9 || c2.getRank() == Card.RANK_10 || c2.getRank() == Card.RANK_QUEEN){
					return 4;
				}
				else if(c2.getRank() == Card.RANK_JACK){
					return 3;
				}
				else return 7;
			}
			else if(c1.getRank() == Card.RANK_7){
				
				if(c2.getRank() == Card.RANK_8){
					return 7;
				}
				else if(c2.getRank() == Card.RANK_9 || c2.getRank() == Card.RANK_10 || c2.getRank() == Card.RANK_KING){
					return 6;
				}
				else if(c2.getRank() == Card.RANK_JACK || c2.getRank() == Card.RANK_QUEEN){
					return 5;
				}
				else{
					return 8;
				}
			}
			else if(c1.getRank() == Card.RANK_8){
				
				if(c2.getRank() == Card.RANK_9 || c2.getRank() == Card.RANK_10){
					return 8;
				}
				else if(c2.getRank() == Card.RANK_JACK || c2.getRank() == Card.RANK_QUEEN || c2.getRank() == Card.RANK_KING){
					return 7;
				}
				else{
					return 9;
				}
			}
			else if(c1.getRank() == Card.RANK_9){
				
				if(c2.getRank() == Card.RANK_10 || c2.getRank() == Card.RANK_ACE){
					return 10;
				}
				else{
					return 9;
				}
			}
			else if(c1.getRank() == Card.RANK_10){
				
				if(c2.getRank() == Card.RANK_JACK || c2.getRank() == Card.RANK_KING || c2.getRank() == Card.RANK_ACE){
					return 13;
				}
				else{
					return 12;
				}
			}
			else if(c1.getRank() == Card.RANK_JACK){
				return 14;
			}
			else if(c1.getRank() == Card.RANK_QUEEN){
				return 16;
			}
			else{
				return 19;
			}
		}
	}
}