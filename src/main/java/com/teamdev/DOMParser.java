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

public class DOMParser {

	public ArrayList<Camp> domParser(String x, String y, String word, String induty)
			throws ParserConfigurationException, SAXException, IOException {
		// XML 문서 파싱
		ArrayList<Camp> group = new ArrayList<Camp>();

		CampingData cd = new CampingData();
		String xml = cd.campingData(x, y);
		// System.out.println(xml);

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		InputSource is = new InputSource(new StringReader(xml));
		Document d = builder.parse(is);
		d.getDocumentElement().normalize();
		// System.out.println("Root Element : " + d.getDocumentElement().getNodeName());

		// root의 속성

		NodeList childeren = d.getElementsByTagName("item");

		String facltNm = "";
		String addr1 = "";
		String addr2 = "";
		String induty2 = "";
		String homepage = "";
		String tel = "";
		String mapX ="";
		String mapY = "";

		for (int i = 0; i < childeren.getLength(); i++) {
			Node node = childeren.item(i);
			Element ele = (Element) node;

			try {
				facltNm = ele.getElementsByTagName("facltNm").item(0).getTextContent();
			} catch (Exception e) {
				facltNm = "";
			}
			try {
				induty2 = ele.getElementsByTagName("induty").item(0).getTextContent();
			} catch (Exception e) {
				induty2 ="";
			}
			try {
				addr1 = ele.getElementsByTagName("addr1").item(0).getTextContent();
			} catch (Exception e) {
				addr1 ="";
			}
			try {
				addr2 = ele.getElementsByTagName("addr2").item(0).getTextContent();
			} catch (Exception e) {
				addr2 = "";
			}
			try {
				homepage = ele.getElementsByTagName("homepage").item(0).getTextContent();
			} catch (Exception e) {
				homepage = "";
			}
			try {
				tel = ele.getElementsByTagName("tel").item(0).getTextContent();
			} catch (Exception e) {
				tel = "";
			}
			try {
				mapX= ele.getElementsByTagName("mapX").item(0).getTextContent();
			} catch (Exception e) {
				mapX = "";
			}
			try {
				mapY= ele.getElementsByTagName("mapY").item(0).getTextContent();
			} catch (Exception e) {
				mapY = "";
			}

			if (facltNm.contains(word)) {
				if (induty2.contains(induty)) {
					Camp newCamp = new Camp(facltNm,  addr1, addr2, induty2, tel, homepage, mapX, mapY);
					group.add(newCamp);
				} else if (induty.equals("전체")) {
					Camp newCamp = new Camp(facltNm,  addr1, addr2, induty2, tel, homepage, mapX, mapY);
					group.add(newCamp);
				}
			} else if (word.equals("없음")) {
				if (induty2.contains(induty)) {
					Camp newCamp = new Camp(facltNm,  addr1, addr2, induty2, tel, homepage, mapX, mapY);
					group.add(newCamp);
				} else if (induty.equals("전체")) {
					Camp newCamp = new Camp(facltNm,  addr1, addr2, induty2, tel, homepage, mapX, mapY);
					group.add(newCamp);
				}
			}

			System.out.println("시설명: " + facltNm + "\n주소: " + addr1 + " " + addr2 + "\n업종: " + induty2 + "\n전화번호: "
					+ tel + "\n홈페이지: " + homepage + "\nMapX.Y: "+ mapX +" "+mapY +"\n");
		}


		return group;
	}
}

class Camp {
	String facltNm;
	String addr1;
	String addr2;
	String type;
	String tel;
	String homepage;
	String mapX;
	String mapY;

	Camp(String facltNm, String addr1, String addr2, String type, String tel, String homepage, String x, String y) {
		this.facltNm = facltNm;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.type = type;
		this.tel = tel;
		this.homepage = homepage;
		mapX = x;
		mapY = y;
	}

	public String getFacltNm() {
		return facltNm;
	}

	public String getAddr1() {
		return addr1;
	}

	public String getType() {
		return type;
	}

	public String getTel() {
		return tel;
	}

	public String getHomepage() {
		return homepage;
	}

	public String getMapX(){
		return mapX;
	}

	public String getMapY(){
		return mapY;
	}

}