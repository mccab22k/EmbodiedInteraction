package kieraPhysics;

import processing.core.PApplet;

public class Boundaries extends PhysicsObject{
	float wallThick;
	int whichWall, height, width;
	int xBoundary, yBoundary;
	public Boundaries(float m, float w, int whichWall) {
		super(m);
		wallThick=w;
		this.whichWall=whichWall;
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(PApplet applet) {
		height=applet.height;
		width=applet.width;
		applet.fill(255,0,0);
		applet.noStroke();
		if (whichWall==0) {
			xBoundary=10;
			applet.rect(0,0,xBoundary,applet.height); //left wall
		} else if(whichWall==1) {
			xBoundary=applet.width-10;
			applet.rect(xBoundary,0,xBoundary,applet.height); //right wall 
		}else if (whichWall==2) {
			yBoundary=10;
			applet.rect(0,0,applet.width,yBoundary); //top 
		}else if (whichWall==3) {
			yBoundary=applet.height-10;
			applet.rect(0,yBoundary,applet.width,yBoundary);  //bottom
		}
//		System.out.println("Height: " + height + "; Width: " + width);

	}
	public boolean hitsXWall(Circ circle) {
		System.out.println("Hit left wall");
			return circle.loc.dist(loc) >= 10 ;
//			return false;
	}

	public boolean hitsYWall(Circ circle) {
		System.out.println("Hit top wall");

		return circle.loc.dist(loc) >= 10 ;

	}

	public boolean hitsYBWall(Circ circle) {
		System.out.println("Hit bottom wall");

		return circle.loc.dist(loc) <= height-10 ;
//		return false;
	}

	public boolean hitsXRWall(Circ circle) {
		System.out.println("Hit right wall");

		return circle.loc.dist(loc) <= width-10 ;

		//		return false;
	}


}
