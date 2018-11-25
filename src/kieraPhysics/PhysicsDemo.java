package kieraPhysics;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PVector;

public class PhysicsDemo extends PApplet {
	ArrayList<PhysicsObject> objects = new ArrayList<PhysicsObject>();
	ArrayList<PhysicsObject> staticWalls=new ArrayList<PhysicsObject>();

	public void settings() {
		size(600, 600);

	}

	public void setup() {

		for(int i = 0; i < 100; i++) {
			Circ c = new Circ(1, random(width), random(height), random(40));
			c.applyForce(new PVector(random(-1,1), random(-1,1)));
			objects.add(c);
		}
		//to make this add each, use loop
		for (int i=0; i<4; i++) {
			Boundaries w = new Boundaries(10,10,i);
			//		Wall w = new Wall(1,0,0, width, height, 5);
			w.applyForce(new PVector(random(-1,1), random(-1,1)));
			staticWalls.add(w);
		}

		//				rect(0,0,width,height);

		//		fill(255);
		//		beginShape();
		//		vertex(0,0);
		//		vertex(0,height);
		//		vertex(width,height);
		//		vertex(width,0);
		//		vertex(0,0);
		//		vertex(10,10);
		//		vertex(10,height-10);
		//		vertex(width-10,height-10);
		//		vertex(width-10,10);
		//		vertex(10,10);
		//		endShape();
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
		
		//for hitting the walls
		for(PhysicsObject obj1 : objects) {
			for(PhysicsObject obj2 : staticWalls) {
				Circ circle = (Circ) obj1;
				Boundaries wall = (Boundaries) obj2;
//					if(circle.hitsWall(wall)) {
//						PVector line = PVector.sub(circle.loc, wall.loc);
//						line.normalize();
//						circle.applyForce(line);
//
//					} 
					if (wall.hitsXWall(circle)) {
						PVector line = PVector.sub(circle.loc, wall.loc);
						line.normalize();
						wall.applyForce(line);
					}
					if (wall.hitsYWall(circle)) {
							PVector line = PVector.sub(circle.loc, wall.loc);
							line.normalize();
							wall.applyForce(line);
						}
					if (wall.hitsXRWall(circle)) {
						PVector line = PVector.sub(circle.loc, wall.loc);
						line.normalize();
						wall.applyForce(line);
					}
					if (wall.hitsYBWall(circle)) {
							PVector line = PVector.sub(circle.loc, wall.loc);
							line.normalize();
							wall.applyForce(line);
						}
			}

			background(100);
			//draw the circles
			for(PhysicsObject obj : objects) {
				obj.update(1);
				obj.draw(this);
			}
			//draw the walls
			for(PhysicsObject obj : staticWalls) {
				obj.update(1);
				obj.draw(this);
			}
		}


	}

	public static void main(String[] args) {
		PApplet.main(PhysicsDemo.class.getName());
	}


}
