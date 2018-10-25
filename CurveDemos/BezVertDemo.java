package CurveDemos;

import processing.core.PApplet;
import processing.core.PVector;
import util.DraggablePoint;

public class BezVertDemo extends CrurvVertDemo {
	
	public void setup() { 
		for(int i = 0; i < 10; i++) {
			points.add(new DraggablePoint(this, new PVector(25+i*75, 25+i*75), 25));
		}
	}
	public void drawCurve() {
		stroke(0);		
		beginShape();
		vertex(points.get(0).center.x, points.get(0).center.y);
		for(int i = 1; i < points.size()-2; i+=3) {
			DraggablePoint pt1 = points.get(i);
			DraggablePoint pt2 = points.get(i+1);
			DraggablePoint pt3 = points.get(i+2);
			bezierVertex(
					pt1.center.x, pt1.center.y,
					pt2.center.x, pt2.center.y,
					pt3.center.x, pt3.center.y
					);
		}
		endShape();
		
		stroke(0,50);
		for(int i = 0; i < points.size()-3; i+=3) {
			DraggablePoint p0 = points.get(i);
			DraggablePoint p1 = points.get(i+1);
			DraggablePoint p2 = points.get(i+2);
			DraggablePoint p3 = points.get(i+3);
			line(p0.center.x, p0.center.y,
					p1.center.x, p1.center.y);
			line(p2.center.x, p2.center.y,
					p3.center.x, p3.center.y);
			
		}
		
		
	}
	public static void main(String[] args) {
		PApplet.main(BezVertDemo.class.getName());
	}
}
