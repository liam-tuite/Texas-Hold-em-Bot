package algorithm;

import poker_lib.Card;
import poker_lib.GameState;
import util.PreflopHandRanker;

public class Brain{
	
	private Bot bot;
	private GameState gameState;
	
	public Brain(){
		this.bot = new Bot();
	}

	public void act(GameState gameState){
		
		this.gameState = gameState;
		int round = gameState.getRound();
		
		if(round == GameState.ROUND_PREFLOP){
			actPreflop();
		}
		else{
			actPostflop();
		}
	}
	
	private void actPostflop(){
		//TODO
	}

	private void actPreflop(){

		Card[] holeCards = gameState.getHoleCards();
		Card hand1 = holeCards[0];
		Card hand2 = holeCards[1];
		
		int threshold;
		int handValue = PreflopHandRanker.getHandValue(gameState.getActiveOpponents().length, hand1, hand2);
		
		// If I have a short stack, go all in if I have a good hand. Otherwise check/fold.
		if(gameState.shortStack()){
			
			threshold = 23;
			
			if(handValue >= threshold){
				bot.shove();
			}
			else{
				checkFold();
			}
		}
		else{
			if(topPocketPair(hand1, hand2)){
				
				bet(2 * gameState.getBb());
			}
			else{
				float position = gameState.getPosition();
				threshold = Math.round(20 - (5 * position));
				
				if(handValue >= threshold){
					
					if(threshold < 16){
						//TODO some opponents might raise preflop 100% of time, ideally should predict this
						call(gameState.getBb());
					}
					else{
						//TODO some opponents might raise preflop 100% of time, ideally should predict this
						bet(2.5 * gameState.getBb());
					}
				}
				else{
					checkFold();
				}
			}
		}
	}
	
	/**
	 * Call if amount to call is equal to the specified amount. If amount to call is less, raise to the amount
	 * specified. If the amount to call is greater, fold.
	 * 
	 * @param amt The amount we want to bet/call.
	 */
	private void bet(double amt){

		double toCall = gameState.getAmountToCall();
		
		if(toCall == 0){
			bot.bet(amt);
		}
		else if(toCall == amt){
			bot.call();
		}
		else if(toCall < amt){
			bot.raiseTo(amt);
		}
		else{
			bot.fold();
		}
	}
	
	/**
	 * Check if possible, otherwise call if the amount to call is less than or equal to the specified amount.
	 * Otherwise, fold.
	 * 
	 * @param amt The maximum amount we will call.
	 */
	private void call(double amt){
		
		double toCall = gameState.getAmountToCall();
		
		if(toCall == 0){
			bot.check();
		}
		else if(toCall <= amt){
			bot.call();
		}
		else{
			bot.fold();
		}
	}
	
	private void checkFold(){
		
		if(gameState.isCheckAvailable()){
			bot.check();
		}
		else{
			bot.fold();
		}
	}
	
	private boolean topPocketPair(Card hand1, Card hand2){
		
		return hand1.getRank() == hand2.getRank() && (hand1.getRank() == Card.RANK_ACE ||
				hand1.getRank() == Card.RANK_KING || hand1.getRank() == Card.RANK_QUEEN);
	}
}