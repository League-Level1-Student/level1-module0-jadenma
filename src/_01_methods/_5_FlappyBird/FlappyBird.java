package _01_methods._5_FlappyBird;

import java.util.Random;

import processing.core.PApplet;
import processing.core.PImage;

public class FlappyBird extends PApplet {
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
    Random ran = new Random();
    int birdX = 400;
    int birdY = 300;
    int birdYVelocity = -12;
	int gravity = 1;
	int pipeX = 800;
	int upperPipeHeight = ran.nextInt(400 - 100 + 1)+100;
	int pipeGap = 130;
	boolean isDead = false;
	int score = 0;
	

    @Override
    public void settings() {
        size(WIDTH, HEIGHT);
    }
    PImage back;
    PImage pipeBottom;
    PImage pipeTop;
    PImage bird;
    @Override
    public void setup() {
    	back = loadImage("flappyBackground.jpg");
    	pipeBottom = loadImage("bottomPipe.png");
        pipeTop = loadImage("topPipe.png");
        bird = loadImage("bird.png");
        bird.resize(50,50);
        back.resize(WIDTH, HEIGHT);
    }

    @Override
    public void draw() {
    	int lowerY = upperPipeHeight+pipeGap;
        if (birdY <= upperPipeHeight && birdX > pipeX && birdX < (pipeX+40)){
        	isDead = true; 
        }
        else if (birdY >= (upperPipeHeight+pipeGap) && birdX > pipeX && birdX < (pipeX+40)) {
            isDead = true;
        }
        else if (birdY > 590) {
        	isDead = true;
        }
          
        else {
        	background(back);
        	birdYVelocity += gravity;
        	image(bird, birdX-25, birdY-25);
        	birdY+=birdYVelocity;
        	fill(0, 255, 0);
    		image(pipeTop, pipeX, 0, 40, upperPipeHeight);
    		image(pipeBottom, pipeX, lowerY, 40, 600-lowerY);
    		pipeX-=3;
    		if (pipeX < -30) {
    			upperPipeHeight = ran.nextInt(400 - 100 + 1)+100;
    			pipeX = 810;
    			score++;
    		}
    		rect (0, 580, 800, 20);
    		fill(0, 0, 0);
    		text("Score: " + score, 20, 20);
        }
        
    	if (isDead == true) {
    		System.exit(0);
    	}
    }
    
    public void mousePressed() {
    	birdYVelocity = -12;
    }
    

    static public void main(String[] args) {
        PApplet.main(FlappyBird.class.getName());
    }
}
