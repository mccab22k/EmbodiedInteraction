package physics;

import processing.core.PApplet;
import processing.core.PVector;

public abstract class PhysicsObject {
	
	float mass;
	PVector vel =new  PVector();
	PVector loc =new  PVector();
	
	PVector currentForces = new PVector();

	public PhysicsObject(float m) {
		mass = m;
	}
	public abstract void draw(PApplet applet);
	
	public void applyForce(PVector f) {
		currentForces.add(f);
	}
	
	public void update(float dt) {
		vel.add(currentForces.mult(dt).div(mass));
//		vel.mult(.9f); // drag
		loc.add(vel.mult(dt));
		currentForces.set(0,0);
	}
	
}
