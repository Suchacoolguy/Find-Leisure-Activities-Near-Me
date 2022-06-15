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


public class DOMParserPD_pos {

	public ArrayList<PerformPos> domParserPD(String fcltyID)
			throws ParserConfigurationException, SAXException, IOException {
		// XML 문서 파싱
		ArrayList<PerformPos> group = new ArrayList<PerformPos>();

		PerformanceData_pos pd = new PerformanceData_pos();
		String xml = pd.performanceData(fcltyID);

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		InputSource is = new InputSource(new StringReader(xml));
		Document d = builder.parse(is);
		d.getDocumentElement().normalize();

		NodeList childeren = d.getElementsByTagName("db");

		String adres = "";
		String la = "";
		String lo = "";

		for (int i = 0; i < childeren.getLength(); i++) {
			Node node = childeren.item(i);
			Element ele = (Element) node;
			try {
				adres = ele.getElementsByTagName("adres").item(0).getTextContent();
			} catch (Exception e) {
				adres = "";
			}
			try {
				la = ele.getElementsByTagName("la").item(0).getTextContent();
			} catch (Exception e) {
				la ="";
			}
			try {
				lo = ele.getElementsByTagName("lo").item(0).getTextContent();
			} catch (Exception e) {
				lo ="";
			}
			PerformPos newPerformPos = new PerformPos(adres, la, lo);
			group.add(newPerformPos);
		}
		return group;
	}
}


class PerformPos {
	String adres;
	String la; 
	String lo;

	PerformPos(String adres, String la, String lo) {
		this.adres = adres;
		this.la = la;
		this.lo = lo;
	}

	public String getAdres(){
		return adres;
	}

	public String getLa(){
		return la;
	}
	public String getLo(){
		return lo;
	}
}