package com.teamdev;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;

public class PerformanceData_info {

    StringBuilder urlBuilder;

    public String performanceData(String performId) throws IOException {

            urlBuilder = new StringBuilder("http://kopis.or.kr/openApi/restful/pblprfr"); /* URL */
            urlBuilder.append("/" + URLEncoder.encode(performId, "UTF-8"));
            urlBuilder.append("?" + URLEncoder.encode("service", "UTF-8") + "=30e086f808414e6d928c0243552b3ec8");

        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code_PERFORM: " + conn.getResponseCode());
        BufferedReader rd;
        if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "UTF-8"));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        return sb.toString();
    }
}