package CurveDemos;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PVector;
import util.DraggablePoint;
import util.Drawable;

public class CurveDemo extends PApplet {
	boolean wasMousePressed = false;

	DraggablePoint selectedPoint = null;
	ArrayList<DraggablePoint> points = new ArrayList<DraggablePoint>();

	public void settings(){
		size(800,800, P2D);
		smooth();
	}

	public void setup(){
		points.add(new DraggablePoint(this, new PVector(100,100), 50.0f, "1"));
		points.add(new DraggablePoint(this, new PVector(300,300), 50.0f, "2"));
		points.add(new DraggablePoint(this, new PVector(500,500), 50.0f, "3"));
		points.add(new DraggablePoint(this, new PVector(700,700), 50.0f, "4"));
		noStroke();

	}


	public void handlePoints() {
		PVector mouseLoc = new PVector(mouseX,mouseY);
		System.out.println(mouseLoc);
		if(mousePressed) {
			if(! wasMousePressed) {
				for(DraggablePoint pt : points) {
					if(pt.select(mouseLoc)) {
						selectedPoint = pt;
						break;
					}
				}				
			}
			wasMousePressed = true;
		} else {
			wasMousePressed = false;
		}


		if(selectedPoint != null) {
			if(mousePressed) {
				selectedPoint.drag(mouseLoc);
			} else {
				selectedPoint.deselect();
				selectedPoint = null;
			}
		}

		for(Drawable d : points) {
			d.draw(this);
		}


	}
	
	
	public void draw(){

		background(255);
		handlePoints();
		
		
		stroke(0);
		fill(0,255,0, 50);

	
		drawCurve();

		

	}
	
	public void drawCurve() {
		
		stroke(0, 50);
		line(
				points.get(0).center.x, points.get(0).center.y,
				points.get(1).center.x, points.get(1).center.y
		);
		line(
				points.get(2).center.x, points.get(2).center.y,
				points.get(3).center.x, points.get(3).center.y
		);
		
		stroke(0);		
		curve(
				points.get(0).center.x, points.get(0).center.y,
				points.get(1).center.x, points.get(1).center.y,
				points.get(2).center.x, points.get(2).center.y,
				points.get(3).center.x, points.get(3).center.y					
				);
	}


	public static void main(String[] args) {
		PApplet.main(CurveDemo.class.getName());
	}

}
