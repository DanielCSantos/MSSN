package TPC02;

import java.util.Random;
import ProcessingSetup.*;
import processing.core.PApplet;

public class ToyotaSymbol implements IProcessingApp{

	// default symbols size and scale
	float symbol_width = 100;
	float symbol_height = 60;	
	float scale = 1;

	float center_x;
	float center_y;

	float trans_x;
	float trans_y;

	PApplet parent;

	float time_elapsed;

	int red = 0;
	int blue = 0;
	int green = 0;



	@Override
	public void setup(PApplet parent) {
		this.parent = parent;

	}

	// Constructor draws the symbol at the default location
	public ToyotaSymbol() {
		this.center_x = getSymbolWidth()/2;
		this.center_y = getSymbolHeight()/2;
		this.trans_x = this.center_x;
		this.trans_y = this.center_y;
	}

	// Constructor receives the locations where to draw the symbol
	public ToyotaSymbol(float trans_x, float trans_y) {
		this.center_x = trans_x + getSymbolWidth();
		this.center_y = trans_y + getSymbolHeight();
		this.trans_x = trans_x;
		this.trans_y = trans_y;
	}

	// Constructor receives the location to draw the symbol and the scale
	public ToyotaSymbol(float trans_x, float trans_y, float scale) {
		this.center_x = trans_x + getSymbolWidth();
		this.center_y = trans_y + getSymbolHeight();
		this.trans_x = trans_x;
		this.trans_y = trans_y;
		this.scale = scale;

	}

	//returns the symbol width
	public float getSymbolWidth() {
		return scale*symbol_width;
	}

	// returns the symbol height value
	public float getSymbolHeight() {
		return scale*symbol_height;
	}

	// returns the scale value
	public float getSymbolScale() {
		return this.scale;
	}


	// Draws symbol with a pre-determined style
	@Override
	public void draw(PApplet parent, float dt) {
		time_elapsed = time_elapsed + dt;

		parent.pushMatrix();


		parent.translate(trans_x, trans_y);
		parent.pushStyle();
		parent.strokeWeight(scale*3);
		parent.stroke(200,150,0);


		// If the mouse is on top of the symbol paints the symbol with random color
		if(mouseOver(parent)) {
			Random rng = new Random();
			parent.stroke(rng.nextInt(256), rng.nextInt(256), rng.nextInt(256));

		}


		// delays the drawing of each ring of the circle by 2 seconds
		outeRing(parent);


		if(time_elapsed > 2) {
			lowerRing(parent);
		}
		if(time_elapsed > 4) {
			topRing(parent);
		}

		parent.popMatrix();
	}


	// Creates outside ring of the symbol
	public void outeRing(PApplet parent) {
		parent.ellipse(0, 0, getSymbolWidth(), getSymbolHeight());
	}


	// Creates inner top side ring of the symbol
	public void topRing(PApplet parent) {

		parent.pushStyle();

		parent.noFill();
		parent.ellipse(0, (float)(-getSymbolHeight()/4.5), (float) (getSymbolWidth()/1.3), getSymbolHeight()/2);

		parent.popStyle();
	}


	// Creates inner lower ring of the symbol with a 90 degree rotation
	public void lowerRing(PApplet parent) {

		parent.pushMatrix();

		parent.rotate((float) (Math.PI/2));
		parent.ellipse(0, 0, getSymbolHeight(), scale*20);

		parent.popMatrix();
	}


	// Checks if the mouse is over the symbol and returns true if that's the case, false otherwise
	public boolean mouseOver(PApplet parent){

		if(parent.mouseX < trans_x + this.symbol_width/2 && parent.mouseX > trans_x - this.symbol_width/2  ) {
			if(parent.mouseY < trans_y + this.symbol_height/2 && parent.mouseY > trans_y - this.symbol_height/2) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void keyPressed(PApplet parent) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(PApplet parent) {
		// TODO Auto-generated method stub
	}

}
