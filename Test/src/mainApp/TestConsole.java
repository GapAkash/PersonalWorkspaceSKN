package mainApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Timer;

public class TestConsole implements Runnable {
	JTextArea displayPane;
	BufferedReader reader;

	private TestConsole(JTextArea displayPane, PipedOutputStream pos) {
		this.displayPane = displayPane;

		try {
			PipedInputStream pis = new PipedInputStream(pos);
			reader = new BufferedReader(new InputStreamReader(pis));
		} catch (IOException e) {
		}
	}

	@Override
	public void run() {
		String line = null;

		try {
			while ((line = reader.readLine()) != null) {
//              displayPane.replaceSelection( line + "\n" );
				displayPane.append(line + "\n");
				displayPane.setCaretPosition(displayPane.getDocument().getLength());
			}

			System.err.println("im here");
		} catch (IOException ioe) {
			JOptionPane.showMessageDialog(null, "Error redirecting output : " + ioe.getMessage());
		}
	}

	public static void redirectOutput(JTextArea displayPane) {
		TestConsole.redirectOut(displayPane);
		TestConsole.redirectErr(displayPane);
	}

	public static void redirectOut(JTextArea displayPane) {
		PipedOutputStream pos = new PipedOutputStream();
		System.setOut(new PrintStream(pos, true));

		TestConsole console = new TestConsole(displayPane, pos);
		new Thread(console).start();
	}

	public static void redirectErr(JTextArea displayPane) {
		PipedOutputStream pos = new PipedOutputStream();
		System.setErr(new PrintStream(pos, true));

		TestConsole console = new TestConsole(displayPane, pos);
		new Thread(console).start();
	}

	public static void main(String[] args) {
		JTextArea textArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(textArea);

		JFrame frame = new JFrame("Redirect Output");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(scrollPane);
		frame.setSize(200, 100);
		frame.setVisible(true);

		TestConsole.redirectOutput(textArea);
		// final int i = 0;

		Timer timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(new java.util.Date().toString());
				System.err.println(System.currentTimeMillis());
			}
		});
		timer.start();
	}
}
