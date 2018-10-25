package util;

import processing.core.PApplet;
import processing.core.PVector;

public class DraggablePoint extends Selectable implements Drawable {
	
	public PVector center;
	public float radius;
	
	String label = null;
	
	int fillColor;
	int selectionColor;
	
	PVector selectionStartMouseLocation = null;
	PVector selectionStartCenter = null;

	public DraggablePoint(PApplet app, PVector center, float radius) { 
		this(app, center, radius, null);
	}

	public DraggablePoint(PApplet app, PVector center, float radius, String label) {

		fillColor = app.color(0,0,255, 25);
		selectionColor = app.color(255,0,0, 25);
		
		this.center = center;
		this.radius = radius;
		
		this.label = label;
	}
	

	
	@Override
	public boolean select(PVector mouseLoc) {
		if(center.dist(mouseLoc) <= radius) {
			isSelected = true;
			selectionStartMouseLocation = mouseLoc;
			selectionStartCenter = new PVector(center.x, center.y);
		} else {
			isSelected = false;
		}
		return isSelected;
	}
	
	public void drag(PVector mouseLoc) {
		PVector dragDist = PVector.sub(mouseLoc, selectionStartMouseLocation);
		center = PVector.add(selectionStartCenter, dragDist);
	}


	@Override
	public void draw(PApplet applet) {
		if(isSelected) {
			applet.fill(selectionColor);
		} else {
			applet.fill(fillColor);
		}
		
		applet.ellipse(center.x, center.y, radius, radius);
		if(label!= null) {
			applet.fill(0);
			applet.text(label, center.x, center.y);			
		}
		
	}

}
