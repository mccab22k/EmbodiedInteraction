package transformDemo;

import processing.core.PApplet;

public class TranslateDemo extends PApplet {
	TranslatingObj1 obj = new TranslatingObj1(50, 50);
	TranslatingObj1 obj2 = new TranslatingObj1(100, 50);


	public void settings(){
		size(400,400);
	}

	public void setup(){
		fill(255);
	}

	public void draw(){

		obj.draw(this);

		obj2.draw(this);

	}


	public static void main(String[] args) {
		PApplet.main(TranslateDemo.class.getName());
	}
}
