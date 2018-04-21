package util;

import algorithm.Manager;

public class ScreencapSpecs{
	
	public int x, y, width, height;
	public String filename, extension;

	public ScreencapSpecs(int x, int y, int width, int height, String filename, String extension){

		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.filename = Manager.LIVE_SCREENSHOT_DIR + filename + "." + extension;
		this.extension = extension;
	}
	
	public ScreencapSpecs(ScreencapSpecs specs, String filename){

		this.x = specs.x;
		this.y = specs.y;
		this.width = specs.width;
		this.height = specs.height;
		this.filename = Manager.LIVE_SCREENSHOT_DIR + filename + "." + specs.extension;
		this.extension = specs.extension;
	}
}