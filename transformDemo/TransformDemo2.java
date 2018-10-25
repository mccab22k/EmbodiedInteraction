package transformDemo;

import processing.core.PApplet;

public class TransformDemo2 extends PApplet {
	TranslatingObj obj1 = new TranslatingObj(50, 50, 30);
	TranslatingObj obj2 = new TranslatingObj(60, 60, 30);


	public void settings(){
		size(400,400, FX2D);
	}

	public void setup(){
		fill(120,50,240);
	}

	public void draw(){

		obj1.draw(this);
		obj2.draw(this);

	}

	public static void main(String[] args) {
		PApplet.main(TransformDemo2.class.getName());
	}
}
