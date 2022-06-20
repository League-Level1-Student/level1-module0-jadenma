package _01_methods._1_houses;

import java.awt.Color;

import org.jointheleague.graphical.robot.Robot;

/*
 *    Copyright (c) The League of Amazing Programmers 2013-2021
 *    Level 1
 */
public class Houses {
		Robot rob = new Robot();
	public void run() {
		// Check the recipe to find out what code to put here
		
		rob.setX(5);
		rob.setY(580);
		drawhouse("small", Color.red);
		drawhouse("medium", Color.orange);
		drawhouse("large", Color.yellow);
		drawhouse("medium", Color.green);
		drawhouse("small", Color.blue);
		drawhouse("medium", Color.magenta);
		drawhouse("large", Color.pink);
		drawhouse("medium", Color.cyan);
		drawhouse("small", Color.gray);
		drawhouse("medium", Color.black);
		
		
	}
	void drawPointyRoof() {
		rob.turn(45);
		rob.move(20);
		rob.turn(90);
		rob.move(20);
		rob.turn(45);
	}
	
	void drawFlatRoof() {
		rob.turn(90);
		rob.move(20);
		rob.turn(90);
	}
	
	void drawhouse(String height, Color color) {
		if (height.equals("small")) {
			rob.penDown();
			rob.setSpeed(100);
			rob.hide();
			rob.setPenColor(color);
			rob.move(60);
			drawPointyRoof();
			rob.move(60);
			rob.turn(-90);
			rob.setPenColor(0, 255, 0);
			rob.move(20);
			rob.turn(-90);
		}
		if (height.equals("medium")) {
			rob.penDown();
			rob.setSpeed(100);
			rob.hide();
			rob.setPenColor(color);
			rob.move(120);
			drawPointyRoof();
			rob.move(120);
			rob.turn(-90);
			rob.setPenColor(0, 255, 0);
			rob.move(20);
			rob.turn(-90);
		}
		if (height.equals("large")) {
			rob.penDown();
			rob.setSpeed(100);
			rob.hide();
			rob.setPenColor(color);
			rob.move(250);
			drawFlatRoof();
			rob.move(250);
			rob.turn(-90);
			rob.setPenColor(0, 255, 0);
			rob.move(20);
			rob.turn(-90);
		}
	}
}
