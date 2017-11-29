package ProcessingSetup;


import TPC03.SkydivingWorld;
import TPC03.StarSystem;
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
    	//TPC02
//    	processingApp = new SketchExemplov2();
//    	processingApp = new StarShape();
    	
    	//TPC03
//    	processingApp = new SeveralForces();
//    	processingApp = new SolarSystem();
    	processingApp = new StarSystem();
    	
    	
//    	processingApp = new WorldOfSkyDivers();
//    	processingApp = new ParticleSystem();
//    	processingApp = new Boid();
    	
        PApplet.main(ProcessingSetup.class);
    }
}