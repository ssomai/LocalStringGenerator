package com.jnm.github.localstring;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.util.HashMap;

import com.jnm.github.localstring.WorksheetParser.Worksheet;

public class LocalStringGenerator {
	private static final int 	LocalStringStartColumn = 4;
	
	private static final String 	Param_DefaultLanguageISO 	= "en";
	private static final String 	Param_WorksheetKey 			= "0AtQ_ogKjvSc0dGJqbUoyQjFNSmR4TmpvOU9WdUpodWc";
	
	private static final String 	Param_Java_Path 			= "D:/workspace/LocalStringGenerator_TestAndroid/src/com/jnm/github/localstring/testandroid";
	private static final String 	Param_Java_Package 			= "com.jnm.github.localstring.testandroid";
	private static final String 	Param_Java_ClassName 		= "Strs";
	
	private static final String 	Param_ObjectiveC_Path 		= "C:/Users/user/Desktop/iOS/iOS_EverySing/Localizable";


	private static class CategoryMap extends HashMap<String, NameMap> {
	}
	private static class NameMap extends HashMap<String, LanguageISOMap> {
	}
	private static class LanguageISOMap extends HashMap<String, String> {
		public String	mDescription;
	}
	private static CategoryMap 				sCategories = new CategoryMap();
	private static HashMap<Integer, String> 	sLanguageColumn = new HashMap<Integer, String>();
	
	public static void main(String[] args) {
		try{
			sCategories.clear();
			WorksheetParser wp = new WorksheetParser(Param_WorksheetKey);
			for(int i=0;i<wp.getWorksheetCount();i++) {
				arrangeLocalStrings(wp.getWorksheet(i));
			}
			printToJava(Param_Java_Path, Param_Java_Package, Param_Java_ClassName);
			printToObjectiveC(Param_ObjectiveC_Path);

		} catch(Throwable e) {
			e.printStackTrace();
		}
	}


	private static void arrangeLocalStrings(Worksheet pWorksheet) {
		// Header Row
		for(int i=LocalStringStartColumn;i<pWorksheet.getMaxColCount();i++) {
			String str = pWorksheet.get(1, i);
			if(str.isEmpty() == false) {
				sLanguageColumn.put(i, str);
			}
		}
		
		// Arrange Local Strings
		for(int r=2;r<pWorksheet.getMaxRowCount();r++) {
			String lCategory = pWorksheet.get(r, 1);
			NameMap lNameMap = sCategories.get(lCategory);
			if(lNameMap == null) {
				lNameMap = new NameMap();
				sCategories.put(lCategory, lNameMap);
			}
			
			String lName = pWorksheet.get(r, 2);
			LanguageISOMap lLanguageISOMap = lNameMap.get(lName);
			if(lLanguageISOMap == null) {
				lLanguageISOMap = new LanguageISOMap();
				lLanguageISOMap.mDescription = pWorksheet.get(r, 3);
				lNameMap.put(lName, lLanguageISOMap);
			}
			
			for(int c=LocalStringStartColumn;c<pWorksheet.getMaxColCount();c++) {
				String lLocalString = pWorksheet.get(r, c);
				
				if(lLocalString.isEmpty() == false) {
					lLanguageISOMap.put(sLanguageColumn.get(c), lLocalString);
				}
			}
		}
	}
	
	private static void printToJava(String pPath, String pPackage, String pClassName) throws FileNotFoundException, UnsupportedEncodingException {
		PrintStream_Java pr = new PrintStream_Java(pPath+"/"+pClassName+".java");
		pr.prfln("package "+pPackage+";");
		
		pr.println();
		pr.prfln("import java.util.Hashtable;");
		pr.println();
		
		pr.prfln("public class "+pClassName+" { ");
		
		pr.prfln("private static final String DefaultLanguageISO = \""+Param_DefaultLanguageISO+"\";");
		pr.println();
		pr.prfln("private static String sCurLanguageISO = DefaultLanguageISO;");
		pr.prfln("public static void setCurLanguageISO(String pCurLanguageISO) {");
		pr.prfln("sCurLanguageISO = pCurLanguageISO;");
		pr.prfln("}");
		pr.println();
				
		pr.prfln("public static String u(String pString) {  ");
		pr.prfln("return pString; ");
		pr.prfln("}");
		pr.println();
		
		pr.prfln("public static class LocalString {");
		pr.prfln("private Hashtable<String, String> mStrs = new Hashtable<String, String>();");
		pr.prfln("public void str(String pLang, String pText) {");
		pr.prfln("mStrs.put(pLang, pText);");
		pr.prfln("}");
		pr.prfln("public String get() {");
		pr.prfln("return getFromLang(sCurLanguageISO);");
		pr.prfln("}");
		pr.prfln("public String get(Object ...args) {");
		pr.prfln("return getFromLang(sCurLanguageISO, args);");
		pr.prfln("}");
		pr.prfln("public String getFromLang(String pLang) {");
		pr.prfln("String ret = mStrs.get(pLang);");
		pr.prfln("if(ret == null)");
		pr.prfln("ret = mStrs.get(sCurLanguageISO);");
		pr.prfln("if(ret == null)");
		pr.prfln("ret = mStrs.get(DefaultLanguageISO);");
		pr.prfln("return ret;");
		pr.prfln("}");
		pr.prfln("public String getFromLang(String pLang, Object ... args) {");
		pr.prfln("return String.format(getFromLang(pLang), args);");
		pr.prfln("}");
		pr.prfln("@Override");
		pr.prfln("public String toString() {");
		pr.prfln("return get();");
		pr.prfln("}");
		pr.prfln("}");
		
		pr.println();
		pr.println();
		pr.println();
		
		
		for(String lCategory : sCategories.keySet()) {
			NameMap lNameMap = sCategories.get(lCategory);
			pr.prfln("public static class %s {", lCategory);
			for(String lName : lNameMap.keySet()) {
				LanguageISOMap lLanguageISOMap = lNameMap.get(lName);
				pr.prfln("/** "); 
				pr.prfln(" * <font size='3'><b><font color='red'>%s</font>.<font color='blue'>%s</font></b></font><br/>", lCategory, lName);
				pr.prfln(" * <font size='3'><b>%s</b></font>", lLanguageISOMap.get(Param_DefaultLanguageISO));
				pr.prfln(" * <font size='2'><b>%s</b></font>", lLanguageISOMap.mDescription);
				pr.prfln(" */");
				pr.prfln("public static LocalString %s = new LocalString() {{", lName);
				
				for(String lang: sLanguageColumn.values()) {
					if(lLanguageISOMap.containsKey(lang)) {
						pr.prfln("str(%-10s %s);", "\""+lang+"\",", "\""+lLanguageISOMap.get(lang)+"\"");
					}
				}
				pr.prfln("}};");
			}
			pr.prfln("}\n");
		}
		pr.prfln("}");
		pr.close();
	}

	private static void printToObjectiveC(String pParam_Path) throws FileNotFoundException, UnsupportedEncodingException {
		for(String lLanguageISOCode : sLanguageColumn.values()) {
			PrintStream_Java pr = new PrintStream_Java(pParam_Path+"/"+"Localizable_"+lLanguageISOCode+".strings");
			pr.prfln("\"languageISO\" = \""+lLanguageISOCode+"\"");
			pr.prfln("");
			pr.prfln("");
			pr.prfln("");
			
			for(String lCategory : sCategories.keySet()) {
				NameMap lNameMap = sCategories.get(lCategory);
				for(String lName : lNameMap.keySet()) {
					pr.prfln("\"%s\" = \"%s\";", lCategory+"_"+lName, lNameMap.get(lName).get(lLanguageISOCode));
				}
				pr.prfln("");
			}
			pr.close();
		}
		
	}
}
