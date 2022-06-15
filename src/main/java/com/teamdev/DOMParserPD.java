package com.teamdev;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


public class DOMParserPD {

	public ArrayList<Perform> domParserPD(String si, String gngu, String word, String induty)
			throws ParserConfigurationException, SAXException, IOException {
		// XML 문서 파싱
		ArrayList<Perform> group = new ArrayList<Perform>();

		PerformanceData pd = new PerformanceData();
		String xml = pd.performanceData(si, gngu, "0");

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		InputSource is = new InputSource(new StringReader(xml));
		Document d = builder.parse(is);
		d.getDocumentElement().normalize();

		NodeList childeren = d.getElementsByTagName("db");

		String performID = "";
		String performNm = "";
		String prfstate = "";
		String type = "";
		String fcltynm = "";

		for (int i = 0; i < childeren.getLength(); i++) {
			Node node = childeren.item(i);
			Element ele = (Element) node;
			try {
				performID = ele.getElementsByTagName("mt20id").item(0).getTextContent();
			} catch (Exception e) {
				performID = "";
			}
			try {
				performNm = ele.getElementsByTagName("prfnm").item(0).getTextContent();
			} catch (Exception e) {
				performNm ="";
			}
			try {
				prfstate = ele.getElementsByTagName("prfstate").item(0).getTextContent();
			} catch (Exception e) {
				prfstate ="";
			}
			try {
				type = ele.getElementsByTagName("genrenm").item(0).getTextContent();
			} catch (Exception e) {
				type ="";
			}
			try {
				fcltynm = ele.getElementsByTagName("fcltynm").item(0).getTextContent();
			} catch (Exception e) {
				fcltynm ="";
			}

			if (performNm.contains(word)) {
				if (type.contains(induty)) {
					Perform newPerform = new Perform(performID, performNm, type, fcltynm, prfstate);
					group.add(newPerform);
				} else if (induty.equals("전체")) {
					Perform newPerform = new Perform(performID, performNm, type, fcltynm, prfstate);
					group.add(newPerform);
				}
			} else if (word.equals("없음")) {
				if (type.contains(induty)) {
					Perform newPerform = new Perform(performID, performNm, type, fcltynm, prfstate);
					group.add(newPerform);
				} else if (induty.equals("전체")) {
					Perform newPerform = new Perform(performID, performNm, type, fcltynm, prfstate);
					group.add(newPerform);
				}
			}

			// System.out.println(i+ "\n아이디: " + performID + "\n공연명: " + performNm + "\n타입: " + type + "\n상태: "
			// 		+ prfstate +"\n");
		}
		return group;
	}
}


class Perform {
	String performID;
	String performNm;
	String type;
	String fcltynm;
	String prfstate;

	Perform(String performID, String performNm, String type, String fcltynm, String prfstate) {
		this.performID = performID;
		this.performNm = performNm;
		this.type = type;
		this.fcltynm = fcltynm;
		this.prfstate = prfstate;
	}

	public String getPerformID(){
		return performID;
	}

	public String getPerfromNm(){
		return performNm;
	}

	public String getType(){
		return type;
	}

	public String getfcltynm(){
		return fcltynm;
	}

	public String getPrfstate(){
		return prfstate;
	}

}