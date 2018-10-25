import processing.core.PApplet;

public class ColorDemo extends PApplet {
	public void settings() {
		size(300, 300);

	}

	public void setup() {
		//setup variables here
	}

	public void draw() {
		int c1 = color(255, 0, 0);
		int c2 = color(0,0,255);	
		// halfway between red an blue
		int purple = lerpColor(c1,c2,.5f);

	}

	public static void main(String[] args) {
		PApplet.main(ColorDemo.class.getName());
	}


}
