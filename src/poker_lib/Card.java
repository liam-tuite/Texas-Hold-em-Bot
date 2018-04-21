package poker_lib;

public class Card{

	public static final int SUIT_CLUBS = 0;
	public static final int SUIT_DIAMONDS = 1;
	public static final int SUIT_HEARTS = 2;
	public static final int SUIT_SPADES = 3;

	public static final int RANK_2 = 2;
	public static final int RANK_3 = 3;
	public static final int RANK_4 = 4;
	public static final int RANK_5 = 5;
	public static final int RANK_6 = 6;
	public static final int RANK_7 = 7;
	public static final int RANK_8 = 8;
	public static final int RANK_9 = 9;
	public static final int RANK_10 = 10;
	public static final int RANK_JACK = 11;
	public static final int RANK_QUEEN = 12;
	public static final int RANK_KING = 13;
	public static final int RANK_ACE = 14;
	
	private int rank, suit;
	private String info;

	public Card(String info){
		
		this.info = info;
		this.suit = readSuit(info.charAt(0));
		this.rank = readRank(info.charAt(1));
	}
	
	public int getRank(){
		return this.rank;
	}
	
	public int getSuit(){
		return this.suit;
	}
	
	@Override
	public String toString(){
		return info;
	}
	
	private int readSuit(char c){
		
		switch(c){
			case 'C': return SUIT_CLUBS;
			case 'D': return SUIT_DIAMONDS;
			case 'H': return SUIT_HEARTS;
			default: return SUIT_SPADES;
		}
	}
	
	private int readRank(char c){
		
		switch(c){
			case '2': return RANK_2;
			case '3': return RANK_3;
			case '4': return RANK_4;
			case '5': return RANK_5;
			case '6': return RANK_6;
			case '7': return RANK_7;
			case '8': return RANK_8;
			case '9': return RANK_9;
			case 'T': return RANK_10;
			case 'J': return RANK_JACK;
			case 'Q': return RANK_QUEEN;
			case 'K': return RANK_KING;
			default: return RANK_ACE;
		}
	}
}