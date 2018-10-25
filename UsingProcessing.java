

import processing.core.PApplet;

public class UsingProcessing extends PApplet {

	public void settings(){
		size(200,200);
	}

	public void setup(){
		fill(120,50,240);
	}

	public void draw(){
		ellipse(width/2,height/2,second()*2,second()*2);

	}


	public static void main(String[] args) {
		PApplet.main(UsingProcessing.class.getName());
	}

}
