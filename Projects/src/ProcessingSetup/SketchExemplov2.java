package ProcessingSetup;

import processing.core.PApplet;

public class SketchExemplov2 implements IProcessingApp{

	@Override
	public void setup(PApplet parent) {
		parent.fill(0, 128, 0);
	}

	@Override
	public void draw(PApplet parent, float dt) {
		parent.ellipse(parent.width/2, parent.height/2, 200, 200);
	}

	@Override
	public void keyPressed(PApplet parent) {
		throw new UnsupportedOperationException("keyPressed");
	}

	@Override
	public void mousePressed(PApplet parent) {
		throw new UnsupportedOperationException("mousePressed");
	}
}
