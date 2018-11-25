package transformDemo;

import processing.core.PApplet;

public class TransformDemo1 extends PApplet {	

	@Override
	public void settings() {
		size(500, 500, FX2D);

	}

	public void setup() {
		//setup variables here
	}

	public void draw() {
		translate(width/2f, height/2f);
		scale(2,2);
		for(int i = 0; i < 10; i++) {
			rotate(radians(7));
			rect(-10, -10, 20, 20);

		}

	}

	public static void main(String[] args) {
		PApplet.main(TransformDemo1.class.getName());
	}

}
