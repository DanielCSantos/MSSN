package ProcessingSetup;

import TPC02.StarShape;
import processing.core.PApplet;

public class ProcessingSetup extends PApplet{

	private static IProcessingApp processingApp; 
	private PApplet parent;
	private int lastUpdateTime = 0;
	
	@Override
    public void settings(){
        size(300,300);
    }

    @Override
    public void setup(){
    	parent = this;
    	processingApp.setup(parent);
    }

    @Override
    public void draw(){
    	float dt = (float) ((millis() - lastUpdateTime) / 1000.);
		processingApp.draw(parent, dt);
		lastUpdateTime = millis();
    }
    
    @Override
	public void mousePressed() {
		processingApp.mousePressed(parent);
	}

	@Override
	public void keyPressed() {
		processingApp.keyPressed(parent);
	}

    public static void main(String[] args) {
//    	processingApp = new SketchExemplov2();
    	processingApp = new StarShape();
        PApplet.main(ProcessingSetup.class);
    }
}