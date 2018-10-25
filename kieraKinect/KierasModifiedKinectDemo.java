package kieraKinect;

import java.awt.Color;
import java.io.IOException;

import edu.mtholyoke.cs.comsc243.kinect.Body;
import edu.mtholyoke.cs.comsc243.kinect.KinectBodyData;
import edu.mtholyoke.cs.comsc243.kinectTCP.TCPBodyReceiver;
import processing.core.PApplet;
import processing.core.PVector;

/**
 * @author eitan
 *
 */
public class KierasModifiedKinectDemo extends PApplet {
	
	public static int PROJECTOR_WIDTH = 1024;
	public static int PROJECTOR_HEIGHT = 786;
	TCPBodyReceiver kinectReader;
	public static float PROJECTOR_RATIO = (float)PROJECTOR_HEIGHT/(float)PROJECTOR_WIDTH;

	public void createWindow(boolean useP2D, boolean isFullscreen, float windowsScale) {
		if (useP2D) {
			if(isFullscreen) {
				fullScreen(P2D);  			
			} else {
				size((int)(PROJECTOR_WIDTH * windowsScale), (int)(PROJECTOR_HEIGHT * windowsScale), P2D);
			}
		} else {
			if(isFullscreen) {
				fullScreen();  			
			} else {
				size((int)(PROJECTOR_WIDTH * windowsScale), (int)(PROJECTOR_HEIGHT * windowsScale));
			}
		}		
	}
	
	// use lower numbers to zoom out (show more of the world)
	// zoom of 1 means that the window is 2 meters wide and appox 1 meter tall in real world units
	// sets 0,0 to center of screen
	public void setScale(float zoom) {
		scale(zoom* width/2.0f, zoom * -width/2.0f);
		translate(1f/zoom , -PROJECTOR_RATIO/zoom );		
	}

	public void settings() {
		createWindow(true, false, .9f);
	}

	public void setup(){

		String address = "138.110.92.93";
		int port = 8008;
		System.out.println("Trying to connect to " + address + ":" + port);
		kinectReader = new TCPBodyReceiver(address, 8008);
		
		try {
			kinectReader.start();
		} catch (IOException e) {
			System.out.println("Unable to connect to kinect server");
			exit();
		}

	}
	public void draw(){
		setScale(.5f);
		noStroke();

		background(200); //comment out this to leave trails instead of clearing background 

		KinectBodyData bodyData = kinectReader.getMostRecentData(); 
		if(bodyData == null) return;
		Body person = bodyData.getPerson(0);
		if(person != null){
			PVector head = person.getJoint(Body.HEAD);
			PVector spine = person.getJoint(Body.SPINE_SHOULDER);
			PVector spineBase = person.getJoint(Body.SPINE_BASE);
			PVector shoulderLeft = person.getJoint(Body.SHOULDER_LEFT);
			PVector shoulderRight = person.getJoint(Body.SHOULDER_RIGHT);
			PVector footLeft = person.getJoint(Body.FOOT_LEFT);
			PVector footRight = person.getJoint(Body.FOOT_RIGHT);
			PVector handLeft = person.getJoint(Body.HAND_LEFT);
			PVector handRight = person.getJoint(Body.HAND_RIGHT);


			fill(255,255,255);
			noStroke();
//			drawIfValid(head);
//			drawIfValid(spine);
//			drawIfValid(spineBase);
//			drawIfValid(shoulderLeft);
//			drawIfValid(shoulderRight);
//			drawIfValid(footLeft);
//			drawIfValid(footRight);
//			drawIfValid(handLeft);
//			drawIfValid(handRight);
			
			drawIfValid(head, Color.red);
			drawIfValid(spine, Color.BLUE);
			drawIfValid(spineBase, Color.BLUE);
			drawIfValid(shoulderLeft, Color.GRAY);
			drawIfValid(shoulderRight, Color.ORANGE);
			drawIfValid(footLeft, Color.YELLOW);
			drawIfValid(footRight, Color.GREEN);
			drawIfValid(handLeft, Color.MAGENTA);
			drawIfValid(handRight, Color.PINK);
	

			if( 
					(footRight != null) &&
					(footLeft != null) &&
					(handLeft != null) &&
					(handRight != null) 
					) {
				stroke(255,0,0, 100);
				noFill();
				strokeWeight(.05f); // because of scale weight needs to be much thinner
				curve(
						footLeft.x, footLeft.y, 
						handLeft.x, handLeft.y, 
						handRight.x, handRight.y,
						footRight.x, footRight.y
						);
			}
			if(		(head != null) &&
					(spine != null) &&
					(spineBase != null)) {
				stroke(Color.RED.getRGB(), 100);
				noFill();
				strokeWeight(.05f); // because of scale weight needs to be much thinner
				beginShape();
				curveVertex(head.x, head.y);
				curveVertex(spine.x, spine.y);
				curveVertex(spineBase.x, spineBase.y);
				endShape();
				}
		}
	}

	/**
	 * Draws an ellipse in the x,y position of the vector (it ignores z).
	 * Will do nothing is vec is null.  This is handy because get joint 
	 * will return null if the joint isn't tracked. 
	 * @param vec
	 */
//	public void drawIfValid(PVector vec) {
//		if(vec != null) {
//			ellipse(vec.x, vec.y, .1f,.1f);
//		}
//	}
	public void drawIfValid(PVector vec, Color color) {
		if(vec != null) {	
			//			fill(color.getRGB());
			//			fill(Color.blue.getRGB());
			float xLoc=vec.x;// /500;
			float yLoc=vec.y; // /500;
			ellipse(xLoc, yLoc, .1f,.1f);
		}
		fill(color.getRGB());	
	}

	public static void main(String[] args) {
		PApplet.main(KierasModifiedKinectDemo.class.getName());
	}
}