package transformDemo;

import processing.core.PApplet;
import processing.core.PVector;
import util.Drawable;

public class TranslatingObj implements Drawable {

	PVector loc = new PVector();
	float rotation;

	public TranslatingObj(float x, float y, float rot) {
		loc.x = x;
		loc.y = y;
		rotation = PApplet.radians(rot);
	}

	@Override
	public void draw(PApplet applet) {
		applet.pushMatrix();
		applet.translate(loc.x, loc.y);
		applet.rotate(rotation);
		applet.rect(-10, -10, 20, 20);
		applet.popMatrix();

	}

}
