package io;

import java.io.File;

public class IOScanner{
	
	public static void cleanDirectory(String url){
		
		File dir = new File(url);
	    File[] files = dir.listFiles();
	    
	    for(File file: files){
	        if(file.isFile()){
	            file.delete();
	        }
	    }
	}
}