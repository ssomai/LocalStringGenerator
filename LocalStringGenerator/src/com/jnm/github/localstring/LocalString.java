package com.jnm.github.localstring;

import java.util.Hashtable;

public class LocalString {
	private static final String DefaultLanguageISO = "";
	
	private static String sCurLanguageISO = DefaultLanguageISO;
	public static void setCurLanguageISO(String pCurLanguageISO) {
		sCurLanguageISO = pCurLanguageISO;
	}
	
	private Hashtable<String, String> mStrs = new Hashtable<String, String>();
	public void str(String pLang, String pText) {
		mStrs.put(pLang, pText);
	}
	public String get() {
		return getFromLang(sCurLanguageISO);
	}
	public String get(Object ...args) {
		return getFromLang(sCurLanguageISO, args);
	}
	public String getFromLang(String pLang) {
		String ret = mStrs.get(pLang);
		if(ret == null)
			ret = mStrs.get(sCurLanguageISO);
		if(ret == null)
			ret = mStrs.get(DefaultLanguageISO);
		return ret;
	}
	public String getFromLang(String pLang, Object ... args) {
		return String.format(getFromLang(pLang), args);
	}
	@Override
	public String toString() {
		return get();
	}
}
