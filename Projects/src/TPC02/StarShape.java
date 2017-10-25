package TPC02;
import java.util.ArrayList;
import ProcessingSetup.*;
import processing.core.PApplet;
import processing.core.PVector;


public class StarShape implements IProcessingApp {

	ArrayList<Vertex> vertexlistshape = new ArrayList<Vertex>();
	ArrayList<PVector> vertexlisteyes = new ArrayList<PVector>();

	int frame_x =  900;
	int frame_y = 900;
	
	PApplet parent;
	

	int center_x;
	int center_y;


	int inner_radius = 100;

	

	int outter_radius = 200;

	int length = 100;

	float innereye_diamenter = inner_radius/4;

	float outeye_diameter = inner_radius/2;

	float eyeball_x = inner_radius/2 + (float) Math.cos(Math.PI/10);

	float eyeball_y = -(inner_radius/2 + (float) Math.sin(Math.PI/10));


	// StarShape constructor(calculates middle of frame)
	public StarShape() {
		this.center_x = frame_x/2;
		this.center_y = frame_y/2;


	}

	//Creates and stores them in  the vertex array list vertexlistshape<Vertex>
	public void basicStarShape() {
		
		
		parent.beginShape();
		// Vertex 0
		parent.vertex(outter_radius * (float) Math.cos(Math.PI-Math.PI/10), outter_radius * (float) -Math.sin(Math.PI-Math.PI/10));
		
		
		// Vertex 1
		parent.vertex(inner_radius * (float) Math.cos(Math.PI-Math.PI/4), inner_radius * (float) -Math.sin(Math.PI-Math.PI/4));
		

		// Vertex 2
		parent.vertex(outter_radius * (float) Math.cos(Math.PI/2), outter_radius * (float) Math.sin(-Math.PI/2));


		// Vertex 3
		parent.vertex(inner_radius * (float) Math.cos(Math.PI/4), inner_radius * (float) -Math.sin(Math.PI/4));
		

		// Vertex 4
		parent.vertex(outter_radius * (float) Math.cos(Math.PI/10), outter_radius * (float) -Math.sin(Math.PI/10));
		

		// Vertex 5
		parent.vertex(inner_radius * (float) Math.cos(Math.PI/4), 0);


		// Vertex 6
		parent.vertex(outter_radius * (float) Math.cos(-Math.PI/4), outter_radius * (float) Math.sin(Math.PI/4));


		// Vertex 7
		parent.vertex(0, inner_radius * (float) Math.sin(Math.PI/2));


		// Vertex 8
		parent.vertex(outter_radius * (float) Math.cos(Math.PI+Math.PI/4), outter_radius * (float) Math.sin(Math.PI/4));

		// Vertex 9
		parent.vertex(inner_radius * (float) Math.cos(Math.PI+Math.PI/4), 0);
		parent.endShape(PApplet.CLOSE);
	}


	//Draws the eyes of the star
	public void drawEyes() {

		if(vertexlisteyes.size() == 0) {
			vertexlisteyes.add(0, new PVector(outeye_diameter + (float) Math.cos(Math.PI/10), 
					-(outeye_diameter + (float) Math.sin(Math.PI/10))));

			vertexlisteyes.add(1, new PVector(-(outeye_diameter + (float) Math.cos(Math.PI/10)),
					-(outeye_diameter + (float) Math.sin(Math.PI/10))));

		}


		//Outside eye circles
		parent.pushStyle();

		parent.ellipse(outeye_diameter + (float) Math.cos(Math.PI/10),-(outeye_diameter + (float) Math.sin(Math.PI/10)),
				outeye_diameter, outeye_diameter);

		parent.ellipse(-(outeye_diameter + (float) Math.cos(Math.PI/10)),-(outeye_diameter + (float) Math.sin(Math.PI/10)), 
				inner_radius/2, inner_radius/2);


		//Inside eye circles
		parent.fill(0);

		parent.ellipse(vertexlisteyes.get(0).x,vertexlisteyes.get(0).y, 
				innereye_diamenter, innereye_diamenter);

		parent.ellipse(vertexlisteyes.get(1).x,vertexlisteyes.get(1).y, 
				innereye_diamenter, innereye_diamenter);

		parent.popStyle();

	}


	//Draws the mouth of the star
	public void createMouth() {
		parent.pushStyle();
		parent.strokeWeight(3);
		parent.arc(0, inner_radius/3, inner_radius, inner_radius/2, 0,  (float) Math.PI);
		parent.popStyle();
	}

	//Draws the nose of the star
	public void createNose() {
		parent.pushStyle();
		parent.fill(255,0,0);
		parent.ellipse(0, 0, inner_radius/3, inner_radius/3);
		parent.popStyle();

	}


	//Draws the eyebrows of the star
	public void createEyebrows() {
		parent.pushStyle();
		parent.strokeWeight(2);
		parent.fill(0);

		parent.triangle(eyeball_x - innereye_diamenter/3, eyeball_y - outeye_diameter/3 - innereye_diamenter/2,
				eyeball_x - innereye_diamenter/3, -5 + eyeball_y - outeye_diameter/3 - innereye_diamenter/2,
				eyeball_x + innereye_diamenter/3, eyeball_y - outeye_diameter/3 - innereye_diamenter/2);


		parent.triangle(-eyeball_x + innereye_diamenter/3, eyeball_y - outeye_diameter/3 - innereye_diamenter/2,
				-eyeball_x + innereye_diamenter/3, -5 + eyeball_y - outeye_diameter/3 - innereye_diamenter/2,
				-eyeball_x - innereye_diamenter/3, eyeball_y - outeye_diameter/3 - innereye_diamenter/2);


		parent.popStyle();

	}


	//Animates the eyes according to mouse position(follows mouse position)
	public void eyeAnimation() {


		parent.pushMatrix();
		parent.translate(center_x, center_y);

		//Increments or decrements eyeballs according to mouse direction
		if(parent.mouseX > center_x ) {
			vertexlisteyes.get(0).x ++;
			vertexlisteyes.get(1).x ++;

		}else if(parent.mouseX < center_x) {
			vertexlisteyes.get(0).x--;
			vertexlisteyes.get(1).x--;
		}

		if(parent.mouseY > center_y) {
			vertexlisteyes.get(0).y++;
			vertexlisteyes.get(1).y++;
		}else if(parent.mouseY < center_y) {
			vertexlisteyes.get(0).y--;
			vertexlisteyes.get(1).y--;
		}


		// Constrains Eyes to Eye sockets region
		vertexlisteyes.get(0).x = PApplet.constrain(vertexlisteyes.get(0).x, eyeball_x - outeye_diameter/4, eyeball_x + outeye_diameter/4);
		vertexlisteyes.get(0).y = PApplet.constrain(vertexlisteyes.get(0).y, eyeball_y - outeye_diameter/4, eyeball_y + outeye_diameter/4);

		vertexlisteyes.get(1).x = PApplet.constrain(vertexlisteyes.get(1).x, -eyeball_x - outeye_diameter/4, -eyeball_x + outeye_diameter/4);
		vertexlisteyes.get(1).y = PApplet.constrain(vertexlisteyes.get(1).y, eyeball_y - outeye_diameter/4, eyeball_y + outeye_diameter/4);

		parent.popMatrix();

	}



	@Override
	public void setup(PApplet parent) {
		// TODO Auto-generated method stub
		this.parent = parent;
		parent.getSurface().setSize(900, 900);
		basicStarShape();

	}

	@Override
	public void draw(PApplet parent, float dt) {
		// TODO Auto-generated method stub
		parent.pushStyle();
		parent.background(250);
		
		parent.noFill();
		parent.popStyle();
		parent.pushMatrix();

		parent.translate(center_x, center_y);
		parent.pushStyle();
		parent.fill(255,255,0);
		basicStarShape();
		parent.popStyle();
		drawEyes();
		eyeAnimation();
		createEyebrows();
		createNose();
		createMouth();

		parent.popMatrix();

	}

	@Override
	public void keyPressed(PApplet parent) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(PApplet parent) {
		// TODO Auto-generated method stub

	}
	
	//Class Vertex
	public class Vertex{
		float x;
		float y;

		public Vertex(float x, float y) {
			this.x = x;
			this.y = y;
		}
		public void setVertX(float x) {
			this.x = x;
		}
		public void setVerY(float y) {
			this.y = y;
		}

		public float getX() {
			return this.x;
		}

		public float getY() {
			return this.y;
		}
	}
}
