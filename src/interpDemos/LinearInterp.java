package interpDemos;

import processing.core.PApplet;
import processing.core.PVector;

public class LinearInterp extends PApplet {
	
	float t = 0;

	PVector p1 = new PVector(10, 400);
	PVector p2 = new PVector(300,400);

	public void settings() {

		size(500,500);

	}

	public void setup() {
	}
	
	boolean movingRight = true;

	public void draw() {
		background(200);
		noStroke();
		fill(255,0,0, 100);
		ellipse(p1.x, p1.y, 10, 10);
		ellipse(p2.x, p2.y, 10, 10);
		
		noFill();
		stroke(2);
		line(p1.x, p1.y, p2.x, p2.y);

		noStroke();
//		fill(255,0,255, 200);
		float x = lerp(p1.x, p2.x,t);
		float y = lerp(p1.y, p2.y, t);
		
		float radius  = lerp(20, 40, t);
		
		int red = color(255, 0, 0, 10);
		int blue = color(0,0,255, 255);
		int c = lerpColor(red, blue, t);
		
		fill(c);
		ellipse(x,y, radius, radius);

		if(movingRight) {
			t+=.01;
			if(t>=1) {
				t = 1;
				movingRight = false;
			}
		} else {
			t-=.01;
			if(t<=0) {
				t = 0;
				movingRight = true;
			}
			
		}
	}

	public static void main(String[] args) {
		PApplet.main(LinearInterp.class.getName());
		
		
	}

}
