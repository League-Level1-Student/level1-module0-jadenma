package _01_methods._1_houses;

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
		drawhouse(small);
		drawhouse(small);
		drawhouse(small);
		drawhouse(medium);
		drawhouse(medium);
		drawhouse(medium);
		drawhouse(350);
		drawhouse(400);
		drawhouse(450);
		drawhouse(500);
	}
	void drawhouse(String height) {
		if (height.equals("small")) {
			rob.penDown();
			rob.setSpeed(100);
			rob.hide();
			rob.move(60);
			rob.turn(90);
			rob.move(20);
			rob.turn(90);
			rob.move(60);
			rob.turn(-90);
			rob.move(20);
			rob.turn(-90);
		}
		if (height.equals("medium")) {
			rob.penDown();
			rob.setSpeed(100);
			rob.hide();
			rob.move(120);
			rob.turn(90);
			rob.move(20);
			rob.turn(90);
			rob.move(120);
			rob.turn(-90);
			rob.move(20);
			rob.turn(-90);
		}
	}
}
