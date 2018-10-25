package physicsKiera;

import processing.core.PApplet;
import processing.core.PVector;

public class Wall extends PhysicsObject {

	float thickness, width, height;
	
	public Wall(float m,float x, float y,float width, float height, float t) {
		super(m);
		thickness=t;
		this.width=width;
		this.height=height;
		loc = new PVector(x,y);

		// TODO Auto-generated constructor stub
	}

	public boolean isOverlapping(Wall other) {
		return other.loc.dist(loc) <= thickness + other.thickness;
	}
	
	@Override
	public void draw(PApplet applet) {
		applet.fill(255);
		applet.rect(0,0,thickness,height);
		applet.rect(0,0,width,thickness);
		applet.rect(width-thickness,0,width,height);
		applet.rect(0,height-thickness,width,height);


		// TODO Auto-generated method stub
		
	}

}
