package _01_methods._3_rain_game;

import java.util.Random;

import processing.core.PApplet;
import processing.core.PImage;

/*
 * Goal: Make a game where the user has to catch rain drops in a bucket!
 * 
 * In the setup() method:
 * 1. If you are using an image for the bucket, load it and resize it here.
 *    A bucket image, bucket.png, has been provided if you want to use it.
 *    bucket = loadImage("images/bucket.png");
 *    bucket.resize(100, 100);  // you can choose values other than 100, 100
 * 
 * In the draw() method:
 * 2. Set a background color
 * 
 * 3. Draw a raindrop (ellipse) at the top of the screen
 * 
 * 4. Make the rain fall down the screen.
 *    Hint: make a variable for the raindrop's Y position and change it after
 *    you draw the raindrop.
 * 
 * 5. When the rain falls off the bottom of the canvas, start a new rain drop
 *    falling from the top.
 *    Each new drop should start at a random position (X position) at the top.
 *    Hint: This code will get a random number between 0 and the window width.
 *    int randomNumber = (int)random(width);
 * 
 * 6. Draw a bucket (rectangle or image) at the bottom of the screen.
 *    The bucket's width needs to be stored in the bucketWidth variable.
 * 
 * 7. Make the bucket move side-to-side with the mouse. Hint: use mouseX
 * 
 * 8. When the rain drop has fallen to the bucket, call the checkCatch() method
 *    to see if the rain drop is in the bucket.
 * 
 * 9. Show the current score on the screen using the code below.
 *    Change the color if it does not show up on your background.
 *    fill(0, 0, 0);
 *    textSize(16);
 *    text("Score: " + score, 20, 20);
 */
public class RainGame extends PApplet {
    static final int WIDTH = 600;
    static final int HEIGHT = 600;

    Random ran = new Random();
    int bucketWidth = 50;
    int bucketHeight;
    PImage bucket;
    int y = 0;
    int x = ran.nextInt(600);

    // Sets the size of your canvas
    @Override
    public void settings() {
        size(WIDTH, HEIGHT);
    }
    int score = 0;
    @Override
    public void setup() {

    }

    @Override
    public void draw() {
    	background(0, 0, 0);
    	boolean hasBeenCounted = false;
    	fill(0, 0, 255);
        ellipse(x, y, 25, 40);
        y=y+7;
        if (y >= 620) {
        	x = ran.nextInt(600);
        	y = 0;
        	hasBeenCounted = false;
        }
        fill(255, 0, 0);
        rect(mouseX, 525, 75, 75);
        if (x-12.5 > mouseX && x+12.5 < mouseX+75 && y-12.5 > 525 && y+12.5 < 600 && !hasBeenCounted) {
        	score++;
        	
        	hasBeenCounted = true;
        }
        else if (y-12.5 > 525 && (x-12.5 < mouseX || x+12.5 > mouseX+75)) {
        	
        	score--;
        }
        if (score < 0) {
        	score = 0;
        }
        fill (255, 255, 255);
        textSize(16);
        text("Score: " + score, 20, 20);
        textSize(10);
        text("If you catch a drop, you'll get 7 points, but if you let one drop, you'll lose up to 12 points.", 100, 20);
    }

    static public void main(String[] args) {
        PApplet.main(RainGame.class.getName());
    }
    
    /*********************** DO NOT MODIFY THE CODE BELOW ********************/

    void checkCatch(int x) {
        if (x > mouseX && x < mouseX + bucketWidth) {
            score++;
        } else if (score > 0) {
            score--;
        }
        println("Your score is now: " + score);
    }
}
