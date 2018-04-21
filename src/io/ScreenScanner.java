package io;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import javax.imageio.ImageIO;

import algorithm.Manager;
import poker_lib.Card;
import util.ScreenLocations;
import util.ScreencapSpecs;

public class ScreenScanner{
	
	public static boolean[] getActiveOpponents(int tableSize){
		
		boolean[] activeOpponents = new boolean[tableSize - 1];
		ScreencapSpecs[] opponentLocations;
		
//		if(tableSize == 6){
			opponentLocations = ScreenLocations.TABLE6_OPPONENT_LOCATIONS;
//		}
		
		for(int i = 0; i < activeOpponents.length; i++){
			
			captureImage(opponentLocations[i]);
			activeOpponents[i] = ImageBytes.equals(getImageBytes(opponentLocations[i]), ImageBytes.ACTIVE_OPPONENT);
		}
		
		return activeOpponents;
	}
	
	public static double getAmountToCall(){
		
		if(Manager.PLAY_MONEY){
			if(posPLAY_VWX()){
				return getDigitsFromPositions(false, ScreenLocations.PLAY_VWX_W,
					ScreenLocations.PLAY_VWX_X);
			}
			else if(posPLAY_X()){
				return getDigitsFromPositions(false);
			}
			else if(posPLAY_VWXYZ()){
				return getDigitsFromPositions(true, ScreenLocations.PLAY_VWXYZ_W,
					ScreenLocations.PLAY_VWXYZ_X, ScreenLocations.PLAY_VWXYZ_Y,
						ScreenLocations.PLAY_VWXYZ_Z);
			}
			else if(posPLAY_XYZ()){
				return getDigitsFromPositions(true, ScreenLocations.PLAY_XYZ_Y,
					ScreenLocations.PLAY_XYZ_Z);
			}
			else if(posPLAY_WX()){
				return getDigitsFromPositions(false, ScreenLocations.PLAY_WX_X);
			}
			else{
				captureImage(ScreenLocations.PLAY_WXYZ_W);
				return getDigitsFromPositions(true, ScreenLocations.PLAY_WXYZ_X,
					ScreenLocations.PLAY_WXYZ_Y, ScreenLocations.PLAY_WXYZ_Z);
			}
		}
		else{
			if(posREAL_Z()){
				return getDigitsFromPositions(false);
			}
			else if(posREAL_XYZ()){
				return getDigitsFromPositions(false, ScreenLocations.REAL_XYZ_Y, ScreenLocations.REAL_XYZ_Z);
			}
			else{
				captureImage(ScreenLocations.REAL_YZ_Y);
				return getDigitsFromPositions(false, ScreenLocations.REAL_YZ_Z);
			}
		}
	}
	
	public static double getBankroll(int tableSize){
		
		captureBankrollDigits();
		String bankroll = "" + readBankrollDigit(1);
		bankroll += readBankrollDigit(2);
		bankroll += readBankrollDigit(3);
		
		int digit = readBankrollDigit(4);
		if(digit >= 0){
			bankroll += "." + digit;
			bankroll += readBankrollDigit(5);
		}
		
		return Double.parseDouble(bankroll);
	}
	
	public static int getDealerLocation(int tableSize){
		
		if(tableSize == 6){
		
			captureImage(ScreenLocations.TABLE6_D0);
			if(ImageBytes.equals(getImageBytes(ScreenLocations.TABLE6_D0), ImageBytes.BUTTON)){
				return 0;
			}
			captureImage(ScreenLocations.TABLE6_D1);
			if(ImageBytes.equals(getImageBytes(ScreenLocations.TABLE6_D1), ImageBytes.BUTTON)){
				return 1;
			}
			captureImage(ScreenLocations.TABLE6_D2);
			if(ImageBytes.equals(getImageBytes(ScreenLocations.TABLE6_D2), ImageBytes.BUTTON)){
				return 2;
			}
			captureImage(ScreenLocations.TABLE6_D3);
			if(ImageBytes.equals(getImageBytes(ScreenLocations.TABLE6_D3), ImageBytes.BUTTON)){
				return 3;
			}
			captureImage(ScreenLocations.TABLE6_D4);
			if(ImageBytes.equals(getImageBytes(ScreenLocations.TABLE6_D4), ImageBytes.BUTTON)){
				return 4;
			}
			captureImage(ScreenLocations.TABLE6_D5);
			if(ImageBytes.equals(getImageBytes(ScreenLocations.TABLE6_D5), ImageBytes.BUTTON)){
				return 5;
			}
		}
		
		return -1;
	}
	
	public static Card[] getHoleCards(int tableSize){
		
		captureHole(tableSize);
		return readHoleCards(tableSize);
	}
	
	public static int getTableSize(){

		captureImage(ScreenLocations.TABLE6_BLANKSPOT);
		return ImageBytes.equals(getImageBytes(ScreenLocations.TABLE6_BLANKSPOT), ImageBytes.BLANKSPOT) ? 6 : 9;
	}
	
	public static boolean isCheckAvailable(){
		
		captureImage(ScreenLocations.CHECK_AVAILABLE);
		return ImageBytes.equals(getImageBytes(ScreenLocations.CHECK_AVAILABLE), ImageBytes.CHECK_AVAILABLE);
	}

	public static boolean isMyTurn(int tableSize){
		
		captureImage(ScreenLocations.TABLE6_TURN);
		return tableSize == 6 ? 
			ImageBytes.equals(getImageBytes(ScreenLocations.TABLE6_TURN), ImageBytes.PLAYER_TURN) : null;
	}
	
	public static Card[] readFlop(){
		
		Card[] flop = new Card[3];

		flop[0] = readCard(ScreenLocations.COMMUNITY_1);
		flop[1] = readCard(ScreenLocations.COMMUNITY_2);
		flop[2] = readCard(ScreenLocations.COMMUNITY_3);
		
		return flop;
	}
	
	public static Card readTurn(){
		return readCard(ScreenLocations.COMMUNITY_4);
	}
	
	public static Card readRiver(){
		return readCard(ScreenLocations.COMMUNITY_5);
	}
	
	private static void captureBankrollDigits(){

		captureImage(ScreenLocations.TABLE6_BANKROLL_V);
		captureImage(ScreenLocations.TABLE6_BANKROLL_W);
		captureImage(ScreenLocations.TABLE6_BANKROLL_X);
		captureImage(ScreenLocations.TABLE6_BANKROLL_Y);
		captureImage(ScreenLocations.TABLE6_BANKROLL_Z);
	}
	
	private static void captureHole(int tableSize){
		
		if(tableSize == 6){
			captureImage(ScreenLocations.HOLE6_1);
			captureImage(ScreenLocations.HOLE6_2);
		}
		else{
//			captureImage(ScreenLocations.HOLE9_1);
//			captureImage(ScreenLocations.HOLE9_2);
		}
	}
	
	private static void captureImage(ScreencapSpecs specs){

	    try{
	    	Robot robot = new Robot(); 
	    	BufferedImage img = robot.createScreenCapture(new Rectangle(specs.x, specs.y, specs.width,  specs.height));
	    	
	    	try{
	    		File outputFile = new File(specs.filename);
	    		ImageIO.write(img, specs.extension, outputFile);
	    		
	    	}catch(IOException e1){
	    		Manager.printStackTrace(e1);
	    	}
	    	
	    }catch(AWTException e2){
	    	Manager.printStackTrace(e2);
	    }
	}
	
	private static int getDigitFromImage(String filename){
		
		byte[] b = new byte[0];
		Path path = Paths.get(filename);
		
		try{
			b = Files.readAllBytes(path);
		}catch(IOException e){
			Manager.printStackTrace(e);
		}
		
		if(ImageBytes.equals(b, ImageBytes.TO_CALL_2)){
			return 2;
		}
		else if(ImageBytes.equals(b, ImageBytes.TO_CALL_4)){
			return 4;
		}
		else if(ImageBytes.equals(b, ImageBytes.TO_CALL_6)){
			return 6;
		}
		else if(ImageBytes.equals(b, ImageBytes.TO_CALL_1)){
			return 1;
		}
		else if(ImageBytes.equals(b, ImageBytes.TO_CALL_0)){
			return 0;
		}
		else if(ImageBytes.equals(b, ImageBytes.TO_CALL_8)){
			return 8;
		}
		else if(ImageBytes.equals(b, ImageBytes.TO_CALL_3)){
			return 3;
		}
		else if(ImageBytes.equals(b, ImageBytes.TO_CALL_5)){
			return 5;
		}
		else if(ImageBytes.equals(b, ImageBytes.TO_CALL_7)){
			return 7;
		}
		else if(ImageBytes.equals(b, ImageBytes.TO_CALL_9)){
			return 9;
		}
		else{
			Manager.exitProgram();
			return -1;
		}
	}
	
	private static double getDigitsFromPositions(boolean decimal, ScreencapSpecs... locations){
		
		// the pos boolean methods have already captured the first digit image
		String str = "" + getDigitFromImage("digit1.png");
		
		for(int i = 0; i < locations.length; i++){
			
			captureImage(locations[i]);
			
			if(decimal && i == locations.length - 2){
				str += ".";
			}
			str += getDigitFromImage("digit" + (i + 2) + ".png");
		}
		
		return Double.parseDouble(str);
	}
	
	private static byte[] getImageBytes(ScreencapSpecs image){
		
		try{
			return Files.readAllBytes(Paths.get(image.filename));
		}catch(IOException e){
			Manager.printStackTrace(e);
			return null;
		}
	}

	private static boolean posPLAY_VWX(){
		captureImage(ScreenLocations.PLAY_VWX_V);
		return getDigitFromImage("digit1.png") >= 0;
	}
	
	private static boolean posPLAY_VWXYZ(){
		captureImage(ScreenLocations.PLAY_VWXYZ_V);
		return getDigitFromImage("digit1.png") >= 0;
	}
	
	private static boolean posPLAY_WX(){
		captureImage(ScreenLocations.PLAY_WX_W);
		return getDigitFromImage("digit1.png") >= 0;
	}
	
	private static boolean posPLAY_X(){
		captureImage(ScreenLocations.PLAY_X_X);
		return getDigitFromImage("digit1.png") >= 0;
	}
	
	private static boolean posPLAY_XYZ(){
		captureImage(ScreenLocations.PLAY_XYZ_X);
		return getDigitFromImage("digit1.png") >= 0;
	}
	
	private static boolean posREAL_XYZ(){
		captureImage(ScreenLocations.REAL_XYZ_X);
		return getDigitFromImage("digit1.png") >= 0;
	}
	
	private static boolean posREAL_Z(){
		captureImage(ScreenLocations.REAL_Z_Z);
		return getDigitFromImage("digit1.png") >= 0;
	}
	
	private static int readBankrollDigit(int digit){
		
		switch(digit){
		case 1: return readDigitFromImage(ScreenLocations.TABLE6_BANKROLL_V);
		case 2: return readDigitFromImage(ScreenLocations.TABLE6_BANKROLL_W);
		case 3: return readDigitFromImage(ScreenLocations.TABLE6_BANKROLL_X);
		case 4: return readDigitFromImage(ScreenLocations.TABLE6_BANKROLL_Y);
		default: return readDigitFromImage(ScreenLocations.TABLE6_BANKROLL_Z);
		}
	}
	
	private static Card readCard(ScreencapSpecs cardLocation){
		
		byte[] cardBytes = getImageBytes(cardLocation);
		
		for(Map.Entry<byte[], String> entry : ImageBytes.ALL_CARDS.entrySet()){
			
			if(ImageBytes.equals(entry.getKey(), cardBytes)){
				return new Card(entry.getValue());
			}
		}
		return null;
	}
	
	private static int readDigitFromImage(ScreencapSpecs image){
		
		byte[] imageBytes = getImageBytes(image);
		
		if(ImageBytes.equals(imageBytes, ImageBytes.BANKROLL_DIGIT_0)){
			return 0;
		}
		else if(ImageBytes.equals(imageBytes, ImageBytes.BANKROLL_DIGIT_1)){
			return 1;
		}
		else if(ImageBytes.equals(imageBytes, ImageBytes.BANKROLL_DIGIT_2)){
			return 2;
		}
		else if(ImageBytes.equals(imageBytes, ImageBytes.BANKROLL_DIGIT_3)){
			return 3;
		}
		else if(ImageBytes.equals(imageBytes, ImageBytes.BANKROLL_DIGIT_4)){
			return 4;
		}
		else if(ImageBytes.equals(imageBytes, ImageBytes.BANKROLL_DIGIT_5)){
			return 5;
		}
		else if(ImageBytes.equals(imageBytes, ImageBytes.BANKROLL_DIGIT_6)){
			return 6;
		}
		else if(ImageBytes.equals(imageBytes, ImageBytes.BANKROLL_DIGIT_7)){
			return 7;
		}
		else if(ImageBytes.equals(imageBytes, ImageBytes.BANKROLL_DIGIT_8)){
			return 8;
		}
		else if(ImageBytes.equals(imageBytes, ImageBytes.BANKROLL_DIGIT_9)){
			return 9;
		}
		else{
			return -1;
		}
	}
	
	private static Card[] readHoleCards(int tableSize){
		
		return tableSize == 6 ? new Card[]{readCard(ScreenLocations.HOLE6_1), readCard(ScreenLocations.HOLE6_2)} : null;
	}
}