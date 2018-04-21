package algorithm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import io.IOScanner;
import poker_lib.GameState;

public class Manager{
	
	public static final boolean PLAY_MONEY = true;
	
	public static final String LIVE_SCREENSHOT_DIR =
		"//screenshots//live_screenshots//";
	private static final String OUTPUT_LOG_FILENAME =
		"//io//output.txt";

	private static Brain brain;
	private static GameState gameState;
	private static PrintWriter log;

	public static void main(String[] args){
		
		init();
		
		while(true){
			
			if(isMyTurn()){
				
				updateGameState();
				act();
			}
		}
	}
	
	public static void exitProgram(){
		
		System.out.println("Exiting program.");
		System.exit(1);
	}
	
	public static void outputln(String str){
		System.out.println(str);
		log.write(str);
		log.flush();
	}
	
	public static void printStackTrace(Exception e){
		
		e.printStackTrace();
		e.printStackTrace(log);
		
		exitProgram();
	}
	
	private static void act(){
		brain.act(gameState);
	}
	
	private static void init(){
		
		initOutputs();
		IOScanner.cleanDirectory(LIVE_SCREENSHOT_DIR);
		
		gameState = new GameState();
		brain = new Brain();
	}
	
	private static void initLog() throws FileNotFoundException{
		log = new PrintWriter(new File(OUTPUT_LOG_FILENAME));
	}
	
	private static void initOutputs(){
		
		try{
			initLog();
		}catch(FileNotFoundException e){
			printStackTrace(e);
		}
	}
	
	private static boolean isMyTurn(){
		return gameState.isMyTurn();
	}
	
	private static void updateGameState(){
		gameState.update();
	}
}