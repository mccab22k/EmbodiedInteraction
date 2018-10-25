package CurveDemos;

import processing.core.PApplet;
import processing.core.PVector;

public class CurveInterp extends PApplet {
	
	float t = 0;

	PVector p1 = new PVector(10, 400);
	PVector p2 = new PVector(300,100);
	PVector p3 = new PVector(300,400);
	PVector p4 = new PVector(10, 100);

	public void settings() {

		size(500,500);

	}

	public void setup() {
	}

	public void draw() {
		background(200);
		noStroke();
		fill(255,0,0, 100);
		ellipse(p1.x, p1.y, 10, 10);
		ellipse(p2.x, p2.y, 10, 10);
		ellipse(p3.x, p3.y, 10, 10);
		ellipse(p4.x, p4.y, 10, 10);
		
		noFill();
		stroke(2);
		curve(p1.x, p1.y, p2.x, p2.y, p3.x, p3.y, p4.x, p4.y);
		bezier(p1.x, p1.y, p2.x, p2.y, p3.x, p3.y, p4.x, p4.y);

		noStroke();
		fill(255,0,255, 200);
		float x = curvePoint(p1.x, p2.x, p3.x, p4.x, t);
		float y = curvePoint(p1.y, p2.y, p3.y, p4.y, t);
		ellipse(x,y, 20, 20);

		x = bezierPoint(p1.x, p2.x, p3.x, p4.x, t);
		y = bezierPoint(p1.y, p2.y, p3.y, p4.y, t);
		ellipse(x,y, 20, 20);

		t+=.001;
		t %= 1;
	}

	public static void main(String[] args) {
		PApplet.main(CurveInterp.class.getName());
		
		
	}

}
