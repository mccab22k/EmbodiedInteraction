package physics;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PVector;

public class PhysicsDemo extends PApplet {
	ArrayList<PhysicsObject> objects = new ArrayList<PhysicsObject>();

	public void settings() {
		size(600, 600);

	}

	public void setup() {

		for(int i = 0; i < 100; i++) {
			Circ c = new Circ(1, random(width), random(height), random(40));
			c.applyForce(new PVector(random(-1,1), random(-1,1)));
			objects.add(c);
		}
	}

	public void draw() {
		// check for collisions
		for(PhysicsObject obj1 : objects) {
			for(PhysicsObject obj2 : objects) {
				Circ c1 = (Circ) obj1;
				Circ c2 = (Circ) obj2;
				if(! c1.equals(c2)) {
					if(c1.isOverlapping(c2)) {
						PVector line = PVector.sub(c1.loc, c2.loc);
						line.normalize();
						c1.applyForce(line);

					}
				}
			}
		}
		background(100);
		for(PhysicsObject obj : objects) {
			obj.update(1);
			obj.draw(this);
		}


	}

	public static void main(String[] args) {
		PApplet.main(PhysicsDemo.class.getName());
	}


}
