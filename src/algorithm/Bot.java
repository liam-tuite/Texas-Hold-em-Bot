package algorithm;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import util.KeyIndices;
import util.ScreenLocations;

public class Bot{
	
	private Robot robot;
	
	public Bot(){
		try{
			this.robot = new Robot();
		}catch(AWTException e){
			Manager.printStackTrace(e);
		}
	}
	
	public void bet(double amt){
		
		highlightTextField();
		typeNumber(amt);
		enter();
	}
	
	public void call(){
		clickButton(ScreenLocations.GREEN_BUTTON);
	}
	
	public void check(){
		clickButton(ScreenLocations.GREEN_BUTTON);
	}
	
	public void fold(){
		clickButton(ScreenLocations.BLUE_BUTTON);
	}
	
	public void raiseTo(double amt){
		bet(amt);
	}
	
	public void shove(){
		clickButton(ScreenLocations.MAXIMUM_BET);
		clickButton(ScreenLocations.RED_BUTTON);
	}
	
	private void clickButton(int[] coordinates){
		moveMouse(coordinates);
		leftClick();
	}
	
	private void enter(){
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	private void highlightTextField(){
		clickButton(ScreenLocations.TEXT_FIELD);
		selectAll();
	}
	
	private void leftClick(){
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
	}
	
	private void moveMouse(int[] coordinates){
		robot.mouseMove(coordinates[0], coordinates[1]);
	}
	
	private void selectAll(){
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_A);
		robot.keyRelease(KeyEvent.VK_CONTROL);
	}
	
	private void typeNumber(double amt){
		
		String bet = "" + amt;
		int key;
		
		for(int i = 0; i < bet.length(); i++){
			key = KeyIndices.getKey(bet.charAt(i));
			robot.keyPress(key);
			robot.keyRelease(key);
		}
	}
}