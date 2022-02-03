package mainApp;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
  
public class TestTabbed{
  public static void main(String[] args){
  //New Frame
  JFrame frame = new JFrame("Tabbed Pane Frame");
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  //Componenets
  JTabbedPane tab = new JTabbedPane();
  
  JPanel panel1 = new JPanel();
  JPanel panel2 = new JPanel();
  
  JLabel label1 = new JLabel("This is in tab 1.");
  JLabel label2 = new JLabel("This is in tab 2.");
  
  JButton button1 = new JButton("Tab 1 Button");
  JButton button2 = new JButton("Tab 2 Button");
  
  //Adding
  frame.add(tab);
  //For Tab 1
  panel1.add(label1);
  panel1.add(button1);
  //For Tab 2
  panel2.add(label2);
  panel2.add(button2);
  //Add Tabs
  tab.addTab("Tab 1", panel1);
  tab.addTab("Tab 1", panel2);
 
  //Frame Final Touches
  frame.setSize(400,400);
  frame.setVisible(true);
  }
}
