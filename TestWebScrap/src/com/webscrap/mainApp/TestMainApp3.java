package com.webscrap.mainApp;

import java.awt.datatransfer.Clipboard;
import fr.plaisance.bitly.Bitly;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.Transferable;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import fr.plaisance.bitly.Bit;
import java.util.Iterator;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Document;
import java.io.IOException;
import org.jsoup.nodes.Element;
import org.jsoup.Jsoup;
import java.util.Scanner;

public class TestMainApp3
{
    public static void main(final String[] args) {
        final Scanner sc = new Scanner(System.in);
        while (true) {
            startMenu(sc);
        }
    }
    
    private static void startMenu(final Scanner sc) {
        System.out.print("\nEnter URL - ");
        final String url = sc.next();
        if (!url.contains(".com")) {
            System.out.println("Incorrect URL \n\tPlease check the url and try again...");
        }
        else {
            fetchUdemyUrl(url);
        }
    }
    
    private static void fetchUdemyUrl(final String url) {
        System.out.println("\nLooking for destination URL...\nPlease wait...");
        try {
            final Document document = Jsoup.connect(url).userAgent("mozilla/17.0").get();
            Elements temp = null;
            if (url.contains("www.tutorialbar.com")) {
                temp = document.select("div.priced_block");
            }
            else if (url.contains("coursevania.com")) {
                temp = document.select("div.stm-lms-buy-buttons");
            }
            for (final Element element : temp) {
                final String mainUrl = element.getElementsByTag("a").first().attr("href");
                System.out.println("\nFound the destination URL -\n" + mainUrl);
                if (!mainUrl.contains("udemy.com")) {
                    System.out.println("\nAffiliate Link OR Other Site's link detected...");
                }
                else {
                    fetchDetailsFromUdemy(mainUrl);
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static void fetchDetailsFromUdemy(final String mainUrl) {
        System.out.println("\nFetching Details From Destination URL...\nPlease Wait...");
        try {
            final Document document = Jsoup.connect(mainUrl).userAgent("mozilla/17.0").get();
//            final String price = document.select("div.price-text--price-part--Tu6MH.udlite-clp-discount-price.udlite-heading-xxl").first().text();
//            if (!price.contains("Free")) {
//                System.out.println("\nCoupon Expired...");
//            }
//            else {
                final String title = document.select("h1.udlite-heading-xl").first().text();
                final String time = document.select("span.udlite-text-sm").first().text();
                final String rating = document.select("div.discount-expiration--discount-expiration--2cPY2 span.udlite-heading-sm").first().text();
                final String ratingDesc = document.select("div.styles--rating-wrapper--5a0Tr").first().ownText().replaceAll("\\p{P}", "");
                final String access_token = "43721a5b2575638b4ee63f7fc10e1d84a03bca66";
                final Bitly bitly = Bit.ly(access_token);
                final String shortUrl = bitly.shorten(mainUrl);
                final String imgUrl = document.select("meta[property=og:image]").first().attr("content").split("\\?")[0];

                final String template = 
                		"\ud83d\udcbb " + title + 
                		"\n\n\ud83d\uddc3 " + 
                		"\n\n\u23f3 Remaining : " + 
                		"\n\n\ud83c\udf1f Rating : " + rating + "/5.0" + 
                		"\n\n\ud83d\udd30 Direct Link\r\n" + 
                		"\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\r\n" + 
                		"\ud83d\udca5 " + shortUrl + 
                		"\n\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\r\n" + "\r\n" + 
//                		"\u276f\u276f Join Us On WhatsApp :\r\n" + "\u279c http://bit.ly/FreeProgrammingUdemyCourse\r\n" + "\r\n" + 
                		"\u276f\u276f Join Us On Telegram :\r\n" + "\u279c https://t.me/FreeProgrammingCourses";
                System.out.println("\n\n" + template);
                System.out.println("\nRating - " + rating + " and " + ratingDesc + "\n" + imgUrl + "\n" + shortUrl);
                final StringSelection stringSelection = new StringSelection(template);
                final Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, null);
//            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

