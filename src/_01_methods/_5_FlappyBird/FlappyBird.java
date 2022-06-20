package _01_methods._5_FlappyBird;

import java.util.Random;

import processing.core.PApplet;

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
	int pipeGap = 180;
	boolean isDead = false;
	int score = 0;
	

    @Override
    public void settings() {
        size(WIDTH, HEIGHT);
    }

    @Override
    public void setup() {
    	
    }

    @Override
    public void draw() {
    	int lowerY = upperPipeHeight+pipeGap; 
        if (birdY-25 <= upperPipeHeight && birdX+25 > pipeX && birdX-25 < (pipeX+40)){
        	isDead = true; 
        }
        else if (birdY-25 >= (upperPipeHeight+pipeGap) && birdX+25 > pipeX && birdX-25 < (pipeX+40)) {
            isDead = true;
        }
        else if (birdY+25 > 590) {
        	isDead = true;
        }
          
        if (isDead == true) {
        	birdY+=7;
        	
        }
        else {
        	background(101, 154, 219);
        	birdYVelocity += gravity;
        	fill(255, 255, 0);
        	stroke(255, 255, 0);
        	ellipse(birdX, birdY, 50, 50);
        	birdY+=birdYVelocity;
        	fill(0, 255, 0);
        	noStroke();
    		rect(pipeX, 0, 40, upperPipeHeight);
    		rect (pipeX, lowerY, 40, 600-lowerY);
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
    	
    }
    
    public void mousePressed() {
    	birdYVelocity = -12;
    }
    

    static public void main(String[] args) {
        PApplet.main(FlappyBird.class.getName());
    }
}
