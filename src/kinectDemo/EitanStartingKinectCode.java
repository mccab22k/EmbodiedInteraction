package kinectDemo;
import java.io.FileNotFoundException;
import java.io.IOException;

//import edu.mtholyoke.cs.comsc243.kinect.util.KinectMsgHandler;
//import edu.mtholyoke.cs.comsc243.kinectTCP.PoseFileReader;
import edu.mtholyoke.cs.comsc243.kinect.Body;
import edu.mtholyoke.cs.comsc243.kinect.KinectBodyData;
import edu.mtholyoke.cs.comsc243.kinectTCP.TCPBodyReceiver;
import processing.core.PApplet;
import processing.core.PVector;

/**
 * @author eitan
 *
 */
public class EitanStartingKinectCode extends PApplet {
	
	public static int PROJECTOR_WIDTH = 1024;
	public static int PROJECTOR_HEIGHT = 786;

//	KinectMsgHandler kinectReader;
	TCPBodyReceiver kinectReader;
	PVector mouseLoc;
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
	// zoom of 1 means that the window is 2 meters wide and approx 1 meter tall in real world units
	// sets 0,0 to center of screen
	public void setScale(float zoom) {
		scale(zoom* width/2.0f, zoom * -width/2.0f);
		translate(1f/zoom , -PROJECTOR_RATIO/zoom );		
	}

	public void settings() {
		createWindow(true, false, .5f);
	}

	public void setup(){

		/*
		 * use this code to run your PApplet from data recorded by recorder 
		 * comment out the creation of the bodyreceiver
		 * replace with PoseFileReader
		 *
		*/
			
		String address = "138.110.92.93";
		int port = 8008;
		System.out.println("Trying to connect to " + address + ":" + port);
		kinectReader = new TCPBodyReceiver(address, 8008);
		
//		String filename = "testFile.kinect";
//		int loopCnt = -1; // use negative number to loop forever
//		try {
//			System.out.println("Trying to read " + filename + " loops:"  +loopCnt);
//			kinectReader = new PoseFileReader(filename, loopCnt);
//		} catch (FileNotFoundException e) {
//			System.out.println("Unable to open file: " + filename);
//		}

		
		try {
			kinectReader.start();
		} catch (IOException e) {
			System.out.println("Unable to start kinect reader");
			exit();
		}

	}
	public void draw(){
		setScale(.5f);
		
		noStroke();
		background(200,200,200);

		// leave trails instead of clearing background \ 
		//noStroke();
		//fill(0,0,0, 10);
		//rect(-1,-1, 2, 2); //draw transparent rect of the window

		KinectBodyData bodyData = kinectReader.getMostRecentData();
//		KinectBodyData bodyData = kinectReader.getNextData();
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
			drawIfValid(head);
			drawIfValid(spine);
			drawIfValid(spineBase);
			drawIfValid(shoulderLeft);
			drawIfValid(shoulderRight);
			drawIfValid(footLeft);
			drawIfValid(footRight);
			drawIfValid(handLeft);
			drawIfValid(handRight);

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
		}
		try {
			handlePoints();
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	/** added
	 * These are for the printing coordinates
	 * @throws InterruptedException
	 */
	public void handlePoints() throws InterruptedException {
		mouseLoc = new PVector(mouseX,mouseY);
	}

	public void mouseClicked() {
		System.out.println(mouseLoc.x+ ", "+ mouseLoc.y);  //Print click coordinates
	}


	/**
	 * Draws an ellipse in the x,y position of the vector (it ignores z).
	 * Will do nothing is vec is null.  This is handy because get joint 
	 * will return null if the joint isn't tracked. 
	 * @param vec
	 */
	public void drawIfValid(PVector vec) {
		if(vec != null) {
			ellipse(vec.x, vec.y, .1f,.1f);
		}

	}


	public static void main(String[] args) {
		PApplet.main(EitanStartingKinectCode.class.getName());
	}

}