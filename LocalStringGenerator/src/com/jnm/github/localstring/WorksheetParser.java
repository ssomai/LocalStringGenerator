package com.jnm.github.localstring;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Vector;

import com.google.common.collect.ImmutableTable;
import com.google.common.collect.ImmutableTable.Builder;
import com.google.gdata.client.spreadsheet.FeedURLFactory;
import com.google.gdata.client.spreadsheet.SpreadsheetService;
import com.google.gdata.data.spreadsheet.CellEntry;
import com.google.gdata.data.spreadsheet.CellFeed;
import com.google.gdata.data.spreadsheet.WorksheetEntry;
import com.google.gdata.data.spreadsheet.WorksheetFeed;
import com.google.gdata.util.ServiceException;




public class WorksheetParser {
	private static void log(String pLog) {
		System.out.println("WorksheetParser] "+pLog);
	}
	
	private SpreadsheetService	mService;
	private FeedURLFactory		mFactory;
	private WorksheetFeed 		mWorksheetFeed;
	
	public static class Worksheet {
		private ImmutableTable<Integer, Integer, String> mWorksheet;
		public Worksheet(ImmutableTable<Integer, Integer, String> pWorksheet) {
			mWorksheet = pWorksheet;
			
			for(int i : mWorksheet.rowKeySet()) {
				if(mMaxRowCount < i) {
					mMaxRowCount = i;
				}
			}
			for(int i : mWorksheet.columnKeySet()) {
				if(mMaxColCount < i) {
					mMaxColCount = i;
				}
			}
		}
		private int mMaxRowCount = -1, mMaxColCount = -1;
		public int getMaxRowCount() { return mMaxRowCount; }
		public int getMaxColCount() { return mMaxColCount; }
		
		public String get(int pRow, int pCol) {
			String ret = mWorksheet.get(pRow, pCol);
			if(ret == null)
				ret = "";
			return ret;
		}
	}
	
	
	//private Vector<ImmutableTable<Integer, Integer, String>> mWorksheets = new Vector<ImmutableTable<Integer, Integer, String>>();
	private Vector<Worksheet> mWorksheets = new Vector<Worksheet>();
	public int getWorksheetCount() {
		return mWorksheets.size();
	}
	public Worksheet getWorksheet(int pIndex) {
		return mWorksheets.get(pIndex);
	}
	
	private WorksheetParser() {
		mService = new SpreadsheetService("MySpreadsheetIntegration-v1");
		mFactory = FeedURLFactory.getDefault();
	}
	/**
	 * @param pWorksheetKey_PublishedToWeb 
	 * 웹으로 퍼블되어 있는 Spreadsheet의 key
	 * ex) https://docs.google.com/spreadsheet/pub?key=0AtQ_ogKjvSc0dGJqbUoyQjFNSmR4TmpvOU9WdUpodWc&output=html 에서 key값
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws ServiceException
	 */
	public WorksheetParser(String pWorksheetKey_PublishedToWeb) throws MalformedURLException, IOException, ServiceException {
		this();
		mWorksheetFeed = mService.getFeed(mFactory.getWorksheetFeedUrl(pWorksheetKey_PublishedToWeb, "public", "basic"), WorksheetFeed.class);
		parse();
	}
	/**
	 * @param pWorksheetKey_Private
	 * 개인용 Spreadsheet의 key
	 * ex) https://docs.google.com/spreadsheet/ccc?key=0AtQ_ogKjvSc0dGJqbUoyQjFNSmR4TmpvOU9WdUpodWc&usp=drive_web 에서 key값
	 * @param pID
	 * @param pPWD
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws ServiceException
	 */
	public WorksheetParser(String pWorksheetKey_Private, String pID, String pPWD) throws MalformedURLException, IOException, ServiceException {
		this();
		mService.setUserCredentials(pID, pPWD);
		mWorksheetFeed = mService.getFeed(mFactory.getWorksheetFeedUrl(pWorksheetKey_Private, "private", "basic"), WorksheetFeed.class);
		parse();
	}
	
	private void parse() throws IOException, ServiceException {
		log("parse "+mWorksheetFeed.getEntries().size()+", "+mWorksheetFeed.getTitle().getPlainText());
		for(int i=0;i<mWorksheetFeed.getEntries().size();i++) {
			parseWorksheetEntry(mWorksheetFeed.getEntries().get(i));
		}
	}
	private void parseWorksheetEntry(WorksheetEntry pWorksheetEntry) throws IOException, ServiceException {
		log("parseWorksheetEntry "+pWorksheetEntry.getTitle().getPlainText()+", "+pWorksheetEntry.getCellFeedUrl());
		CellFeed cellFeed = mService.getFeed(pWorksheetEntry.getCellFeedUrl(), CellFeed.class);
		
		//log("ColCount:"+cellFeed.getColCount()+" RowCount:"+cellFeed.getRowCount()+" "+cellFeed.getEntries().size());
		List<CellEntry> cells = cellFeed.getEntries();
		// log(" "+cells);
		Builder<Integer, Integer, String> b = new ImmutableTable.Builder<Integer, Integer, String>();
		
		for (CellEntry celle : cells) {
			String[] lRowCol = celle.getId().substring(celle.getId().lastIndexOf("/R")+2).split("C");
			log("Cell["+lRowCol[0]+"]["+lRowCol[1]+"] "+celle.getPlainTextContent());
			b.put(Integer.parseInt(lRowCol[0]), Integer.parseInt(lRowCol[1]), celle.getPlainTextContent());
		}
		// ImmutableTable<Integer, Integer, String> w = b.build();
		mWorksheets.add(new Worksheet(b.build()));
	}
	
//	private static SpreadsheetEntry getSpreadsheetEntry(SpreadsheetService service, String pURL) throws MalformedURLException, IOException, ServiceException {
//		SpreadsheetEntry ret = null;
//		try {
//			ret = service.getEntry(new URL(pURL), SpreadsheetEntry.class);
//		} catch (RedirectRequiredException re) {
//			re.printStackTrace();
//			System.out.println("RedirectLocation: "+re.getRedirectLocation());
//			ret = getSpreadsheetEntry(service, re.getRedirectLocation());
//		}
//		return ret;
//	}
	
	
	// ImmutableTable<Integer, Integer, String> lWorksheet = ;
			
//			static final ImmutableTable<Integer, Character, String> SPREADSHEET =
//			       new ImmutableTable.Builder<Integer, Character, String>()
//			           .put(1, 'A', "foo")
//			           .put(1, 'B', "bar")
//			           .put(2, 'A', "baz")
//			           .build();
//			log("Celle0 "+celle.getContent());
//			log("Celle2 "+celle.getCell());
//			log("Celle9 "+celle.getKind());
//			log("Celle8 "+celle.getSource());
//			log("Celle7 "+celle.getSummary());
//			log("Celle6 "+celle.getXmlBlob().getBlob());
//			for(Adaptor a : celle.getAdaptors()) {
//				log("Celle3 "+a);
//			}
//			for(Extension e : celle.getExtensions()) {
//				log("Celle4 "+e);
//			}
//			Cell cell = celle.getCell();
//			//log(" "+celle.getTextContent().getContent().getPlainText());
//			//log("Cell "+cell.getRow()+", "+cell.getCol()+" : "+cell.getValue().trim().replace("\n", "\\n"));
//			if(cell != null) {
//				log("Cell "+cell.getRow()+", "+cell.getCol()+" : "+cell.getValue());
//			} else {
//				log("Cell "+cell);
//			}
//			if(cell.getRow() == 1) {
//				if(cell.getCol() >= LocalStringStartColumn) {
//					//Languages[cell.getCol()] = JMLanguage.valueOf(cell.getValue().trim().substring(0, cell.getValue().indexOf(" ")).trim());
//					sLanguageISOs[cell.getCol()] = cell.getValue().trim();
//				}
//			} else {
//				if(cell.getCol() == 1) {
//					lDivRow = cell.getRow();
//					cur1Div = cell.getValue().trim().replace("\n", "\\n");
//					if(Strss.containsKey(cur1Div)) {
//						cur1DivHashMap = Strss.get(cur1Div);
//					} else {
//						cur1DivHashMap = new HashMap<String, HashMap<JMLanguage,String>>();
//					}
//					
//					System.out.print(" 1 "+cur1Div);
//					Strss.put(cur1Div, cur1DivHashMap);
//				} else if(cell.getCol() == 2) {
//					cur2Div = cell.getValue().trim().replace("\n", "\\n");
//					if(cur1DivHashMap.containsKey(cur2Div)) {
//						cur2DivHashMap = cur1DivHashMap.get(cur2Div);
//					} else {
//						cur2DivHashMap = new HashMap<JMLanguage, String>();
//					}
//					
//					System.out.println(" 2 "+cur2Div);
//					cur1DivHashMap.put(cur2Div, cur2DivHashMap);
//				} else if(cell.getCol() >= LocalStringStartColumn) {
//					if(lDivRow == cell.getRow()) {
//						System.out.println("Lang "+sLanguageISOs[cell.getCol()]+": "+cell.getValue().trim().replace("\n", "\\n"));
//						cur2DivHashMap.put(sLanguageISOs[cell.getCol()], cell.getValue().trim().replace("\n", "\\n"));
//					}
//				}
//			}
	
	
			
////			String spreadsheetURL = "https://spreadsheets.google.com/feeds/spreadsheets/0AtQ_ogKjvSc0dGJqbUoyQjFNSmR4TmpvOU9WdUpodWc" + file.getId();
////			SpreadsheetEntry spreadsheet = s.getEntry(new URL(spreadsheetURL), SpreadsheetEntry.class);
//			
//			
////			SpreadsheetFeed feed = service.getFeed(new URL(URL_FromGoogleSpreadSheet), SpreadsheetFeed.class);
////		    List<SpreadsheetEntry> spreadsheets = feed.getEntries();
////		    // int spreadsheetIndex = getIndexFromUser(reader, spreadsheets, "spreadsheet");
//		    
//		    System.out.println("Spreadsheet loaded.");
//		    
////		    SpreadsheetEntry spreadsheet = feed.getEntries().get(spreadsheetIndex);
////		    worksheetFeedUrl = spreadsheet.getWorksheetFeedUrl();
////		    System.out.println("Spreadsheet loaded.");
//			
//			SpreadsheetEntry s = getSpreadsheetEntry(service, URL_FromGoogleSpreadSheet); 
//			System.out.println("Do WorkSheet "+s.getTitle().getPlainText());
//			doWorkSheet(service, s.getWorksheets().get(0));
//			
//			JavaPrintStream pr = new JavaPrintStream(TargetStrs);
//			pr.prfln("package com.smtown.everysing.server.structure;\n");
//			pr.prfln("import com.jnm.lib.core.JMString;\n");
//			pr.prfln("public class Strs { ");
//			pr.prfln("public static String u(String pString) {  ");
//			pr.prfln("return pString; ");
//			pr.prfln("}\n");
//			
//			for(String cur1DivKey : sCategories.keySet()) {
//				//HashMap<String, HashMap<String, String>> cur1Div = Categories.get(cur1DivKey);
//				NameMap cur1Div = sCategories.get(cur1DivKey);
//				pr.prfln("public static class %s {", cur1DivKey);
//				for(String cur2DivKey : cur1Div.keySet()) {
//					LanguageISOMap cur2Div = cur1Div.get(cur2DivKey);
//					pr.prfln("/** "); 
//					pr.prfln(" * <font size='3'><b><font color='red'>%s</font>.<font color='blue'>%s</font></b></font><br/>", cur1DivKey, cur2DivKey);
//					pr.prfln(" * <font size='3'><b>%s</b></font>", cur2Div.get(DefaultLanguageISO));
//					pr.prfln(" */");
//					pr.prfln("public static JMString %s = new JMString() {{", cur2DivKey);
//					
//					// for(JMLanguage lang: cur2Div.keySet()) {
//					for(String lang: sLanguageISOs) {
//						if(cur2Div.containsKey(lang)) {
//							pr.prfln("str(JMLanguage.%-20s %s);", lang+",", "\""+cur2Div.get(lang)+"\"");
//						}
//					}
//					pr.prfln("}};");
//				}
//				pr.prfln("}\n");
//			}
//			
//			pr.prfln("}");
//			pr.close();
	
//	private static class CategoryMap extends HashMap<String, NameMap> {
//	}
//	private static class NameMap extends HashMap<String, LanguageISOMap> {
//	}
//	private static class LanguageISOMap extends HashMap<String, String> {
//	}
//	// private static HashMap<String, HashMap<String, HashMap<String, String>>> Strss = new HashMap<String, HashMap<String,HashMap<String,String>>>();
//	private static CategoryMap 	sCategories = new CategoryMap();
//	private static String[] 		sLanguageISOs;
//	
//	private static void doWorkSheet(SpreadsheetService service, WorksheetEntry pWorksheetEntry) throws IOException, ServiceException {
//		System.out.println("RowCount : "+pWorksheetEntry.getRowCount()+", ColCount : "+pWorksheetEntry.getColCount());
//		sLanguageISOs = new String[pWorksheetEntry.getColCount()+1];
//		
//		CellFeed cellFeed = service.getFeed(pWorksheetEntry.getCellFeedUrl(), CellFeed.class);
//		List<CellEntry> cells = cellFeed.getEntries();
//		
//		int lDivRow = 0;
//		String cur1Div = null;
//		HashMap<String, HashMap<String, String>> cur1DivHashMap = null;
//		String cur2Div = null;
//		HashMap<String, String> cur2DivHashMap = null;
//		
//		
//		for (CellEntry celle : cells) {
//			Cell cell = celle.getCell();
//			System.out.println("Cell "+cell.getRow()+", "+cell.getCol()+" : "+cell.getValue().trim().replace("\n", "\\n"));
//			if(cell.getRow() == 1) {
//				if(cell.getCol() >= LocalStringStartColumn) {
//					//Languages[cell.getCol()] = JMLanguage.valueOf(cell.getValue().trim().substring(0, cell.getValue().indexOf(" ")).trim());
//					sLanguageISOs[cell.getCol()] = cell.getValue().trim();
//				}
//			} else {
////				if(cell.getCol() == 1) {
////					lDivRow = cell.getRow();
////					cur1Div = cell.getValue().trim().replace("\n", "\\n");
////					if(Strss.containsKey(cur1Div)) {
////						cur1DivHashMap = Strss.get(cur1Div);
////					} else {
////						cur1DivHashMap = new HashMap<String, HashMap<JMLanguage,String>>();
////					}
////					
////					System.out.print(" 1 "+cur1Div);
////					Strss.put(cur1Div, cur1DivHashMap);
////				} else if(cell.getCol() == 2) {
////					cur2Div = cell.getValue().trim().replace("\n", "\\n");
////					if(cur1DivHashMap.containsKey(cur2Div)) {
////						cur2DivHashMap = cur1DivHashMap.get(cur2Div);
////					} else {
////						cur2DivHashMap = new HashMap<JMLanguage, String>();
////					}
////					
////					System.out.println(" 2 "+cur2Div);
////					cur1DivHashMap.put(cur2Div, cur2DivHashMap);
////				} else if(cell.getCol() >= LocalStringStartColumn) {
////					if(lDivRow == cell.getRow()) {
////						System.out.println("Lang "+sLanguageISOs[cell.getCol()]+": "+cell.getValue().trim().replace("\n", "\\n"));
////						cur2DivHashMap.put(sLanguageISOs[cell.getCol()], cell.getValue().trim().replace("\n", "\\n"));
////					}
////				}
//			}
//		}
//	}
}
