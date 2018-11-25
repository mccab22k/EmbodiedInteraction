package physics;

import processing.core.PApplet;
import processing.core.PVector;

public class Circ extends PhysicsObject {
	float radius;

	public Circ(float m, float x, float y, float r) {
		super(m);
		radius = r;
		loc = new PVector(x,y);
	}
	
	public boolean isOverlapping(Circ other) {
		return other.loc.dist(loc) <= radius + other.radius;
	}
	

	@Override
	public void draw(PApplet applet) {
		applet.ellipse(loc.x-radius*.5f, loc.y-radius*.5f, radius, radius);
		
	}

}
