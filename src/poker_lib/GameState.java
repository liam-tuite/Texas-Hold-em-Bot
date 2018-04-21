package poker_lib;

import io.ScreenScanner;

public class GameState{

	public static final int POSITION_LAST = 2;
	public static final int POSITION_SECOND_LAST = 1;
	public static final int POSITION_OTHER = 0;
	
	public static final int ROUND_PREFLOP = 0;
	public static final int ROUND_FLOP = 1;
	public static final int ROUND_TURN = 2;
	public static final int ROUND_RIVER = 3;

	private boolean isCheckAvailable;
	private boolean[] activeOpponents;
	private double amountToCall, bankroll, bb;
	private float position;
	private int dealerLocation, numActiveOpponents, tableSize;
	
	private Card[] holeCards;
	private Card[] communityCards;
	private String tableInfo;
	
	public GameState(){
		tableSize = ScreenScanner.getTableSize();
	}
	
	public boolean[] getActiveOpponents(){
		return this.activeOpponents;
	}
	
	public double getAmountToCall(){
		return this.amountToCall;
	}
	
	public double getBb(){
		return this.bb;
	}
	
	public int getDealerLocation(){
		return this.dealerLocation;
	}
	
	public Card[] getHoleCards(){
		return this.holeCards;
	}

	public float getPosition(){
		return this.position;
	}
	
	public int getRound(){
		
		if(dealtFlop()){
			if(dealtTurn()){
				if(dealtRiver()){
					return ROUND_RIVER;
				}
				return ROUND_TURN;
			}
			return ROUND_FLOP;
		}
		return ROUND_PREFLOP;
	}
	
	public int getTableSize(){
		return this.tableSize;
	}
	
	public boolean isCheckAvailable(){
		return this.isCheckAvailable;
	}
	
	public boolean isMyTurn(){
		return ScreenScanner.isMyTurn(tableSize);
	}
	
	public boolean shortStack(){
		return bankroll < (10 * bb);
	}
	
	public void update(){

		updateHoleCards();
		updateDealerLocation();
		updateActiveOpponents();
		updateBankroll();
		updateBb();
		updateIsCheckAvailable();
		updateAmountToCall();
		updatePosition();
	}

	private boolean dealtFlop(){
		
		communityCards = new Card[5];
		Card[] flop = ScreenScanner.readFlop();
		
		for(int i = 0; i < 3; i++){
			
			if(flop[i] == null){
				return false;
			}
			
			communityCards[i] = flop[i];
		}
		
		return true;
	}

	private boolean dealtTurn(){
		
		Card turn = ScreenScanner.readTurn();
		if(turn == null){
			return false;
		}
		
		communityCards[3] = turn;
		return true;
	}

	private boolean dealtRiver(){
		
		Card river = ScreenScanner.readRiver();
		if(river == null){
			return false;
		}
		
		communityCards[4] = river;
		return true;
	}
	
	private int getNumActiveOpponents(){
		
		int count = 0;
		
		for(boolean b : activeOpponents){
			if(b){
				count++;
			}
		}
		
		return count;
	}
	
	private void updateActiveOpponents(){
		this.activeOpponents = ScreenScanner.getActiveOpponents(tableSize);
		this.numActiveOpponents = getNumActiveOpponents();
	}
	
	private void updateAmountToCall(){
		this.amountToCall = ScreenScanner.getAmountToCall();
	}
	
	private void updateBankroll(){
		this.bankroll = ScreenScanner.getBankroll(tableSize);
	}
	
	private void updateBb(){
		
		char[] infoChars = tableInfo.toCharArray();
		int i;
		
		for(i = 0; i < infoChars.length; i++){
			if(infoChars[i] == '-'){
				break;
			}
		}
		
		this.bb = Double.parseDouble(tableInfo.substring(i + 1, tableInfo.length()));
	}
	
	private void updateDealerLocation(){
		this.dealerLocation = ScreenScanner.getDealerLocation(tableSize);
	}
	
	private void updateHoleCards(){
		this.holeCards = ScreenScanner.getHoleCards(tableSize);
	}
	
	private void updateIsCheckAvailable(){
		this.isCheckAvailable = ScreenScanner.isCheckAvailable();
	}
	
	private void updatePosition(){
		
		/*
		 * active opponents can be determined here by whether they have cards.
		 *  
		 *  position is the number of players to act before me divided by the number of opponents
		 */
		
		int numPrecedingActors = 0;
		
		if(dealerLocation == 3){
			numPrecedingActors = numActiveOpponents;
		}
		else{
			for(int i = dealerLocation + 1; i < tableSize; i = (i + 1) % tableSize){
				
				if(i == dealerLocation){
					break;
				}
				
				if(i == 3){
					break;
				}
				
				if(i > 3 && activeOpponents[i - 1]){
					numPrecedingActors++;
				}
				else if(i < 3 && activeOpponents[i]){
					numPrecedingActors++;
				}
			}
		}
		
		this.position = numPrecedingActors / numActiveOpponents;
	}
}