package mainApp;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.*;

/**
 *
 * @author Shane - shanelee.co.uk
 */

public class WebScrape {
	public static void main(String[] args) {
		String url = "https://coursevania.com/courses/data-sciencehands-on-covid-19-data-analysis-visualization/";

		try {
			 Document document = Jsoup.connect(url).userAgent("mozilla/17.0").get();
			 Elements temp = document.select("div.stm-lms-buy-buttons");
			 
			 for (Element element : temp) {
				System.out.println(element.getElementsByTag("a").first().attr("href"));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
