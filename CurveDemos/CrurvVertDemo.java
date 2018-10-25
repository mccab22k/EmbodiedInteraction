package CurveDemos;

import processing.core.PApplet;
import processing.core.PVector;
import util.DraggablePoint;

public class CrurvVertDemo extends CurveDemo {
	
	public void setup() {
		points.add(new DraggablePoint(this, new PVector(100,  200), 50.0f));
		points.add(new DraggablePoint(this, new PVector(84,  91), 50.0f));
		points.add(new DraggablePoint(this, new PVector(68,  19), 50.0f));
		points.add(new DraggablePoint(this, new PVector(21,  17), 50.0f));
		points.add(new DraggablePoint(this, new PVector(32, 100), 50.0f));
		points.add(new DraggablePoint(this, new PVector(50, 200), 50.0f));

	}
	public void drawCurve() {
		stroke(0);		
		beginShape();
		for(DraggablePoint pt : points) {
			curveVertex(pt.center.x, pt.center.y);
		}
		endShape();
	}
	public static void main(String[] args) {
		PApplet.main(CrurvVertDemo.class.getName());
	}
}
