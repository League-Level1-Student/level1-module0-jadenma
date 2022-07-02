package _03_gui_with_help._2_photo_quiz;
/*
 *    Copyright (c) The League of Amazing Programmers 2013-2021
 *    Level 1
 */

import java.awt.Component;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class PhotoQuiz {

	public void run() {

		JFrame quizWindow = new JFrame();
		quizWindow.setVisible(true);
		// This will make sure the program exits when you close the window
		quizWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 1. find an image on the internet, and put its URL in a String
		// variable (from your browser, right click on the image, and select
		// “Copy Image Address” )
		int score = 0;
		String link = "https://m.media-amazon.com/images/S/aplus-media/sota/ebffb373-031f-4b1b-984f-256ee1ef8e4d.__CR0,0,300,300_PT0_SX300_V1___.png";
		// 2. create a variable of type "Component" that will hold your image
		Component image = createImage(link);
		// 3. use the "createImage()" method below to initialize your Component
		// 4. add the image to the quiz window
		quizWindow.add(image);
		// 5. call the pack() method on the quiz window
		quizWindow.pack();
		// 6. ask a question that relates to the image
		String answer = JOptionPane.showInputDialog("Who's that pokemon?");
		// 7. print "CORRECT" if the user gave the right answer
		if (answer.equalsIgnoreCase("Meowstic")) {
			JOptionPane.showMessageDialog(null, "CORRECT");
			score++;
		}
		// 8. print "INCORRECT" if the answer is wrong
		else {
			JOptionPane.showMessageDialog(null, "INCORRECT");
		}
		// 9. remove the component from the quiz window (you may not see the
		// effect of this until step 12)
		quizWindow.remove(image);
		// 10. find another image and create it (might take more than one line
		// of code)
		Component image2 = createImage("http://images4.fanpop.com/image/photos/23600000/Random-Pokemon-Images-pokemon-23655262-220-149.png");
		// 11. add the second image to the quiz window
		quizWindow.add(image2);
		// 12. pack the quiz window
		quizWindow.pack();
		// 13. ask another question
		String answer2 = JOptionPane.showInputDialog("Who's that pokemon?");
		// 14+ check answer, say if correct or incorrect, etc.
		if (answer2.equalsIgnoreCase("Emolga")) {
			JOptionPane.showMessageDialog(null, "CORRECT");
			score++;
		}
		else {
			JOptionPane.showMessageDialog(null, "INCORRECT");
		}
		JOptionPane.showMessageDialog(null,"Your score is: " + score);
	}

	private Component createImage(String imageUrl) {
		JLabel imageLabel = new JLabel();
		URL url;
		try {
			url = new URL(imageUrl);
			Icon icon = new ImageIcon(url);
			imageLabel.setIcon(icon);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "I can't find your image!!");
		}
		
		return imageLabel;
	}

	/* OPTIONAL */
	// *14. add scoring to your quiz
	// *15. make something happen when mouse enters image
	// (imageComponent.addMouseMotionListener())
}
