package userInput;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GetInput {
	static JLabel Title;
	static JLabel RemainingTime;
	static JLabel Rating;
	static JLabel Link;
	
	static JTextField TFTitle;
	static JTextField TFRemainingTime;
	static JTextField TFRating;
	static JTextField TFLink;
	static String getTitle;
	static JFrame showText;
	
	public static void getTitle(JFrame frame) {
		Title = new JLabel("Title", JLabel.LEFT);
		Title.setBounds(30,15, 100,30);
		
		TFTitle = new JTextField();
		TFTitle.setBounds(110, 15, 200, 30);
		
		System.out.println(TFTitle);
		frame.add(Title);
		frame.add(TFTitle);
	}


	public static void getRemainingTime(JFrame frame) {
		RemainingTime = new JLabel("Time");
		RemainingTime.setBounds(30,50, 100,30);
		
		TFRemainingTime = new JTextField();
		TFRemainingTime.setBounds(110, 50, 200, 30);
		
		frame.add(RemainingTime);
		frame.add(TFRemainingTime);
	}

	public static void getRating(JFrame frame) {
		Rating = new JLabel("Rating");
		Rating.setBounds(30,85, 100,30);
		
		TFRating = new JTextField();
		TFRating.setBounds(110, 85, 200, 30);
		
		frame.add(Rating);
		frame.add(TFRating);
		
	}

	public static void getLink(JFrame frame) {
		Link = new JLabel("Link");
		Link.setBounds(30,120, 100,30);
		
		TFLink = new JTextField();
		TFLink.setBounds(110, 120, 200, 30);
		
		frame.add(Link);
		frame.add(TFLink);
	}

	public static void ButtonActivity(JFrame frame) {
		JButton submit = new JButton("SUBMIT");
		submit.setBounds(110,165,80,25);
		frame.add(submit);
		frame.getRootPane().setDefaultButton(submit);
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				showText = new JFrame("TEXT");
				getTitle = TFTitle.getText();
				String getTime = TFRemainingTime.getText();
				String getRating = TFRating.getText();
				String getLink = TFLink.getText();
				
				if (getTime!=null && getTime.equals("1")) {
					getTime=getTime+" Day";
				} else if (getTime!= null && getTime.equals("2")) {
					getTime=getTime+" Days";
				} else {
					getTime = getTime+" Hours";
				}
				
				
				if (getRating!=null && getRating.equals("0")) {
					getRating = "0.0/5.0 [NEW]";
				} else {
					getRating = getRating +"/5.0";
				}

				showText.setSize(400,300);//400 width and 500 height  
				//showText.setLayout(null);//using no layout managers  
				showText.setVisible(true);//making the frame visible 
				//showText.setLocationRelativeTo(null);
				
				JTextArea textField = new JTextArea(10,20);
				JScrollPane scroll = new JScrollPane(textField, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				textField.setBounds(10, 10, 365, 190);
				showText.add(scroll);
				textField.append(
						"💻 "+getTitle+"\n\n"+
						"🗃️ " + "\n\n"+
						"⏳ Remaining : "+getTime+"\n\n"+
						"🌟 Rating : "+getRating+"\n\n"+
						"🔰 Direct Link\r\n" + 
						"▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬\r\n" + 
						"💥 "+getLink+"\n"
						+"▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬\r\n"+
						getFooter() );
				
						        
			}
		});
		
		JButton clear = new JButton("CLEAR");
		clear.setBounds(230,165,80,25);
		frame.add(clear);
		clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				TFTitle.setText("");
				TFRating.setText("");
				TFRemainingTime.setText("");
				TFLink.setText("");
				showText.dispose();
			}
		});
		
	}
	
	public static String getHashTag() {
		String[] words = getTitle.toUpperCase().split(" ");
		String[] hashTag = {"HTML", "SQL","PYTHON", "JAVA", "R"};
		StringBuilder hash = new StringBuilder();
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < hashTag.length; j++) {
				if(words[i].contains(hashTag[j])) {
					hash.append("#"+words[i]+" ");
				}
			}
		}
		return hash.toString();
//		StringBuilder hashTag = new StringBuilder();
//		for (String word : words) {
//			if (word.equalsIgnoreCase("HTML") || word.equalsIgnoreCase("SQL")) {
//				hashTag.append(" #").append(word);
//			}
//		}
	}
	
	public static String getFooter() {
		String footer = "\r\n" + 
				"❯❯ Join Us On WhatsApp :\r\n" + 
				"➜ http://bit.ly/FreeProgrammingUdemyCourse\r\n" + 
				"\r\n" + 
				"❯❯ Join Us On Telegram :\r\n" + 
				"➜ https://t.me/FreeProgrammingCourses";
		return footer;
	}


}
