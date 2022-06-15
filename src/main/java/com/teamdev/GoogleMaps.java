package com.teamdev;

import static com.teamdev.jxbrowser.engine.RenderingMode.HARDWARE_ACCELERATED;

import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.engine.Engine;
import com.teamdev.jxbrowser.engine.EngineOptions;
import com.teamdev.jxbrowser.view.swing.BrowserView;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
// import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
// import org.jsoup.Jsoup;
// import org.jsoup.nodes.Document;
// import org.jsoup.nodes.Element;

public class GoogleMaps extends JPanel {

        public GoogleMaps(String lat, String lon)
        {
            EngineOptions options =
                EngineOptions.newBuilder(HARDWARE_ACCELERATED).licenseKey("1BNDHFSC1G2Z6G3N8ZA8TIBMZ8E7VHAUEFDRCRN9H8910VTZA9VIVV2OAMLO108DCCJQ2G").build();
            Engine engine = Engine.newInstance(options);
            Browser browser = engine.newBrowser();

            SwingUtilities.invokeLater(() -> {
            BrowserView view = BrowserView.newInstance(browser);

            this.add(view);
            this.setPreferredSize(new Dimension(500, 500));
            this.setBackground(Color.WHITE);
            String url = setDestination(lat, lon);

            browser.navigation().loadUrl(url);
        });
        }
        
        static String setDestination(String lat, String lon)
        {
            StringBuilder url = new StringBuilder();
            url.append("https://www.google.com/maps/dir/?api=1&destination=");
            url.append(lat);
            url.append(",");
            url.append(lon);

            return url.toString();
        }
    
           // C:/Users/ghqja/Desktop/google_maps/

        // File input = new File("C:/Users/ghqja/Desktop/google_maps/google_map/src/main/java/com/teamdev/map.html");
        // Document doc = Jsoup.parse(input, "UTF-8", "file:///C:/Users/ghqja/Desktop/google_maps/map.html");
        // Element script = doc.head().select("script").last();

        // script.remove();
        // script = doc.head().select("script").last();
        // script.append("<script type=\"text/javascript\">");
        
        

        // System.out.println(doc.head().select("script").last());
        // System.out.println(script);
    }
