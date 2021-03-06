package com.webscrap.mainApp;

import java.io.IOException;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TestMainApp {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		System.out.print("Enter URL - ");
//		String url = sc.next();
//		if (!url.contains(".com")) {
//			System.out.println("Incorrect URL \n\tPlease check the url and try again...\n\tTerminating the session...");
//		} else {
//			fetchUdemyUrl(url);
//		}
//		sc.close();
			Scanner sc = new Scanner(System.in);
			//int choice;
//			do {
//				System.out.print(
//						"\nPlease Select From The Following Options: " + "\n\t1. New Request" + "\n\t2. Exit" + "\n\nYour Choice: ");
//				choice = sc.nextInt();
//
//				switch (choice) {
//				case 1:
//					startMenu(sc);
//					break;
//
//				default:
//					startMenu(sc);
//					break;
//				}
//			} 
			while (true) {
				startMenu(sc);
			}
			
		}


	private static void startMenu(Scanner sc) {
		System.out.print("\nEnter URL - ");
		String url = sc.next();
		if (!url.contains(".com")) {
			System.out.println("Incorrect URL \n\tPlease check the url and try again...");
		} else {
			fetchUdemyUrl(url);
		}
		
	}


	private static void fetchUdemyUrl(String url) {
		System.out.println("\nLooking for destination URL...\nPlease wait...");
		try {
			 Document document = Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36").get();
			 Elements temp = null ;
			 String mainUrl;
			 if (url.contains("www.tutorialbar.com")) {
				 temp = document.select("div.priced_block");
			} else if (url.contains("coursevania.com")) {
				 temp = document.select("div.stm-lms-buy-buttons");
			}

			 for (Element element : temp) {
				 mainUrl = element.getElementsByTag("a").first().attr("href");
				System.out.println("\nFound the destination URL -\n"+mainUrl);
				
				if (!mainUrl.contains("udemy.com")) {
					System.out.println("\nAffiliate Link OR Other Site's link detected...");
				} else {
					fetchDetailsFromUdemy(mainUrl);
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


	private static void fetchDetailsFromUdemy(String mainUrl) {
		System.out.println("\nFetching Details From Destination URL...\nPlease Wait...");
		
		try {
			Document document = Jsoup.connect(mainUrl).userAgent("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36").get();
			
//			System.out.println(document.html());
			String title = document.select("h1.udlite-heading-xl").first().text();
			//String time = document.select("div.discount-expiration--discount-expiration--2cPY2").first().getElementsByAttribute("span.udlite-text-sm").text();
			String rating = document.select("span.udlite-heading-sm").first().text();
			String ratingDesc = document.select("div.styles--rating-wrapper--5a0Tr").first().ownText();
			System.out.println("Title - "+title);
			//System.out.println("Time - "+time);
			System.out.println("Rating - "+rating);
			System.out.println("Rating Description - "+ratingDesc);


		} catch (IOException e) {
			e.printStackTrace();
		}

	}

//	private static void fetchDetailsFromUdemy(String mainUrl) {
//		System.out.println("\nFetching Details From Destination URL...\nPlease Wait...");
//		 try {
//			Document document = Jsoup.connect(mainUrl).userAgent("mozilla/17.0").get();
//			System.out.println(document.outerHtml());
//			String price = document.select("div.price-text--price-part--Tu6MH").first().text();
////			Document doc = Jsoup.parse("<div class=\"price-text--price-part--Tu6MH udlite-clp-discount-price udlite-heading-xxl\" data-purpose=\"course-price-text\">\r\n" + 
////					"<span class=\"udlite-sr-only\">Current price</span>\r\n" + 
////					"<span>Free</span>\r\n" + 
////					"</div>");
////			//use css selectors
////			Elements rows = doc.select("div.price-text--price-part--Tu6MH span");
////			System.out.println(rows.eachText());
////			System.out.println(price);
////			if (!price.contains("Free")) {
////				System.out.println("\nCoupon Expired...");
////			} else {
//				String title = document.select("h1.udlite-heading-xl").first().text();
////				String time = document.select("div.discount-expiration--discount-expiration--2cPY2").first().getElementsByTag("b").text();
//				String rating = document.select("span.udlite-heading-sm").first().text();
//				String ratingDesc = document.select("div.styles--rating-wrapper--5a0Tr").first().ownText();
////				String ratingSuffix = null;
////				int ratingNum = 0;
//				
////				if (!ratingDesc.equalsIgnoreCase("0 ratings")) {
////					Pattern pattern = Pattern.compile("\\w+([0-9]+)");
////					Matcher matcher = pattern.matcher(ratingDesc);
////					for(int i = 0 ; i < matcher.groupCount(); i++) {
////						matcher.find();
////						ratingNum = Integer.parseInt(matcher.group());
////					}
////				}
//				
////				if (ratingNum<50) {
////					ratingSuffix = " [NEW]";
////				} else if (ratingNum>=5000) {
////					ratingSuffix = " ["+ratingDesc+"]";
////				}
//
//				String access_token = "43721a5b2575638b4ee63f7fc10e1d84a03bca66";
//				Bitly bitly = Bit.ly(access_token);
//				String shortUrl = bitly.shorten(mainUrl);
//				String imgUrl = document.select("meta[property=og:image]").first().attr("content"); 
//				String template;
//				
//				template = "???? "+title
//						+ "\n\n???? "
////						+ "\n\n??? Remaining : "+time
//						+ "\n\n???? Rating : "+rating+"/5.0"
//						+ "\n\n???? Direct Link\r\n" + 
//						"???????????????????????????????????????????????????\r\n" + 
//						"???? "+shortUrl
//						+"\n???????????????????????????????????????????????????\r\n" + 
//						"\r\n" + 
//						"?????? Join Us On WhatsApp :\r\n" + 
//						"??? http://bit.ly/FreeProgrammingUdemyCourse\r\n" + 
//						"\r\n" + 
//						"?????? Join Us On Telegram :\r\n" + 
//						"??? https://t.me/FreeProgrammingCourses";
//				
//				System.out.println("\n\n"+template);
//				System.out.println("\nRating - "+rating+" and "+ratingDesc+"\n"+imgUrl);
//				
//				
//				
//				StringSelection stringSelection = new StringSelection(template);
//				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//				clipboard.setContents(stringSelection, null);
////			}
//			
//			
////			for (Element element : title) {
////				System.out.println(element.getElementsByClass("h1"));
////			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//	}
}
