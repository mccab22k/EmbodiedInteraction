package transformDemo;

import processing.core.PApplet;
import processing.core.PVector;
import util.Drawable;

public class TranslatingObj1 implements Drawable {

	PVector loc = new PVector();

	public TranslatingObj1(float x, float y) {
		loc.x = x;
		loc.y = y;
	}

	@Override
	public void draw(PApplet applet) {
		applet.pushMatrix();
		applet.translate(loc.x, loc.y);
		applet.ellipse(0, 0, 10, 10);
		applet.popMatrix();

	}

}
