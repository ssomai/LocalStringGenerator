package com.jnm.github.localstring;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

class PrintStream_Java extends PrintStream {
	public PrintStream_Java(String fileName) throws FileNotFoundException, UnsupportedEncodingException {
		super(new FileOutputStream(fileName), true, "UTF-8");
	}
	public PrintStream prfln(String format, Object... args) {
		boolean lReducted = false;
//		if(format.contains("{") == false) {
			if(format.trim().startsWith("}")) {
				mTabIndent--;
				lReducted = true;
			}
//		}
		
		String tab = "";
		for(int i=0;i<mTabIndent;i++) {
			tab += "\t";
		}
		
		if(format.contains("{")) {
			mTabIndent++;
			if(format.contains("}")) {
				if(lReducted == false) {
					mTabIndent--;
				}
			}
		}
				
		return super.printf(tab+format+"\n", args);
	}
	
	private int mTabIndent = 0;
}