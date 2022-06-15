
package com.teamdev;

import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class ListTest extends JFrame {

	Display display;

	ArrayList<Camp> cd_item = new ArrayList<Camp>();
	ArrayList<Perform> pd_item = new ArrayList<Perform>();
	ArrayList<PerformInfo>pdinfo_item = new ArrayList<PerformInfo>();
	ArrayList<PerformPos>pdpos_item = new ArrayList<PerformPos>();

	String si;
	String gngu = "";

	DOMParser dp;
	DOMParserPD dpPD;
	DOMParserPD_info dpPDInfo;
	DOMParserPD_pos dpPDPos;

	protected String[] xy;

	public ListTest(Display display) {
		this.display = display;
	}

	public void dataLoad_Camp(){
		dp = new DOMParser();

		try {
			cd_item = dp.domParser(xy[0], xy[1],display.searchWord, display.campType);

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void dateLoad_Perform() {
		dpPD = new DOMParserPD();
		si = display.selectedDoCode;
		try {
			pd_item = dpPD.domParserPD(si, gngu, display.searchWord, display.performType);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void dateLoad_PerformInfo() {
		dpPDInfo = new DOMParserPD_info();
		try {
			pdinfo_item = dpPDInfo.domParserPD(display.performId);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void dateLoad_PerformPos() {
		dpPDPos = new DOMParserPD_pos();
		try {
			pdpos_item = dpPDPos.domParserPD(display.fcltyID);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
