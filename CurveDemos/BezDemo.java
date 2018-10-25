package CurveDemos;

import processing.core.PApplet;

public class BezDemo extends CurveDemo {
	
	public void drawCurve() {

		this.bezier(
				points.get(0).center.x, points.get(0).center.y,
				points.get(1).center.x, points.get(1).center.y,
				points.get(2).center.x, points.get(2).center.y,
				points.get(3).center.x, points.get(3).center.y	
				);
	}

	public static void main(String[] args) {
		PApplet.main(BezDemo.class.getName());
	}

}
