package _03_gui_with_help._4_body_part_quiz;

import java.net.URL;

/*
 *    Copyright (c) The League of Amazing Programmers 2013-2021
 *    Level 1
 */

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BodyPartQuiz {

	// You can use the celebrity photos we have placed in the recipe java
	// package,or if you prefer, get celebrity photos from the Internet,
	// place them in the recipe package(body_part_quiz), and change the names below.

	String firstImage = "arnold.jpeg";
	String secondImage = "leonardo.jpeg";
	String thirdImage = "morgan.jpeg";
	String fourthImage = "jack.jpeg";

	JFrame window = new JFrame();
	JPanel panel = new JPanel();

	public void run() {
		initializeGui();
		startQuiz();
	}

	private void initializeGui() {
		initializeImageList();
		imageIterator = imageList.iterator();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//panel.add(imageIterator);
		window.add(panel);
		
		// 3. Change the size of the window so that you can only see part of the
		// image.
		window.setSize(500, 150);

		showNextImage();

	}

	private void startQuiz() {

		// 1. Make an int variable to hold the score.
		int score = 0;
		// 2. Set the size of the window in the initializeGui() method 

		// 4. Ask the user who this person is and store their answer
		String guess = JOptionPane.showInputDialog("Who is this?");

		// 5. Check their answer. If they guessed correctly:
		// -- Tell them they are right and increase the score by 1
		if (guess.equals("Arnold Schwarzenegger")) {
			JOptionPane.showMessageDialog(null, "You are correct!");
			score++;
		}
		else {
			JOptionPane.showMessageDialog(null, "This is Arnold Schwarzenegger");
		}
		// 6. Otherwise:
		// -- Tell them they are wrong and who the person is

		// 7. Use the showNextImage() method below to get the next image
		showNextImage();

		// 8. .... repeat 4-7 for all your images.....
		String guess2 = JOptionPane.showInputDialog("Who is this?");
		if (guess2.equals("Leonardo DiCaprio")) {
			JOptionPane.showMessageDialog(null, "You are correct!");
			score++;
		}
		else {
			JOptionPane.showMessageDialog(null, "This is Leonardo DiCaprio.");
		}
		showNextImage();
		String guess3 = JOptionPane.showInputDialog("Who is this?");
		if (guess3.equals("Morgan Freeman")) {
			JOptionPane.showMessageDialog(null, "You are correct!");
			score++;
		}
		else {
			JOptionPane.showMessageDialog(null, "This is Morgan Freeman.");
		}
		showNextImage();
		String guess4 = JOptionPane.showInputDialog("Who is this?");
		if (guess4.equals("Jack Black")) {
			JOptionPane.showMessageDialog(null, "You are correct!");
			score++;
		}
		else {
			JOptionPane.showMessageDialog(null, "This is Jack Black.");
		}
		// 9. Show them their current score
		JOptionPane.showMessageDialog(null, "Your final score is " + score);
	}

	public void showNextImage() {
		panel.removeAll();
		panel.add(getNextImage());
		window.setVisible(true);
	}

	private JLabel loadImage(String fileName) {
		
		JLabel label = new JLabel();
		URL imgUrl = getClass().getResource(fileName);
		Icon icon = new ImageIcon(imgUrl);
		label.setIcon(icon);
		return label;
	}

	ArrayList<JLabel> imageList = new ArrayList<JLabel>();
	Iterator<JLabel> imageIterator;

	private void initializeImageList() {
		JLabel imageLabel = loadImage(firstImage);
		
		imageList.add(imageLabel);
		imageLabel = loadImage(secondImage);
		imageList.add(imageLabel);
		imageLabel = loadImage(thirdImage);
		imageList.add(imageLabel);
		imageLabel = loadImage(fourthImage);
		imageList.add(imageLabel);
	}

	private JLabel getNextImage() {
		if (imageIterator.hasNext())
			return imageIterator.next();

		return new JLabel("No more images");
	}
}