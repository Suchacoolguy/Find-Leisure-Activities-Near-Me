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


public class DOMParserPD_info {

	public ArrayList<PerformInfo> domParserPD(String performId)
			throws ParserConfigurationException, SAXException, IOException {
		// XML 문서 파싱
		ArrayList<PerformInfo> group = new ArrayList<PerformInfo>();

		PerformanceData_info pd = new PerformanceData_info();
		String xml = pd.performanceData(performId);

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		InputSource is = new InputSource(new StringReader(xml));
		Document d = builder.parse(is);
		d.getDocumentElement().normalize();

		NodeList childeren = d.getElementsByTagName("db");

		String fcltyID = "";
		String poster = "";

		for (int i = 0; i < childeren.getLength(); i++) {
			Node node = childeren.item(i);
			Element ele = (Element) node;
			try {
				fcltyID = ele.getElementsByTagName("mt10id").item(0).getTextContent();
			} catch (Exception e) {
				fcltyID = "";
			}
			try {
				poster = ele.getElementsByTagName("poster").item(0).getTextContent();
			} catch (Exception e) {
				poster ="";
			}
			PerformInfo newPerformInfo = new PerformInfo(fcltyID, poster);
			group.add(newPerformInfo);


			// System.out.println(i+ "\n아이디: " + performID + "\n공연명: " + performNm + "\n타입: " + type + "\n상태: "
			// 		+ prfstate +"\n");
		}
		return group;
	}
}


class PerformInfo {
	String fcltyID;
	String poster; 

	PerformInfo(String fcltyID, String poster) {
		this.fcltyID = fcltyID;
		this.poster = poster;
	}

	public String getFcltyID(){
		return fcltyID;
	}

	public String getPoster(){
		return poster;
	}
}