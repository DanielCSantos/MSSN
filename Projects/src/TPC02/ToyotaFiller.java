package TPC02;

import java.util.ArrayList;
import ProcessingSetup.*;
import processing.core.PApplet;

public class ToyotaFiller implements IProcessingApp{
	
	int frame_width;
	int frame_height;
	
	PApplet parent;
	ToyotaSymbol symbol;

	float time_elapsed;
	
	ArrayList<ToyotaSymbol> toyota_symbols = new ArrayList<ToyotaSymbol>();
	
	float radius_x;
	float radius_y;
	float translate_x;
	float translate_y;


	@Override
	public void setup(PApplet parent) {
		this.parent = parent;
		parent.getSurface().setSize(this.frame_width, this.frame_height);
	}
	
	
	// symbol = Toyota symbol to be replicated
	// width = width of the screen
	// height = height of the screen
	// Constructor receives the symbol and the sizes of the screen(frame) where the symbol will be replicated
	public ToyotaFiller(ToyotaSymbol symbol, int width, int height) {
		
		this.frame_height = height;
		this.frame_width = width;
		this.symbol = symbol;
		
		radius_x = symbol.getSymbolWidth()/2;
		radius_y = symbol.getSymbolHeight()/2;
		
		translate_x = symbol.getSymbolWidth();
		translate_y = symbol.getSymbolHeight();
		createArraySymbols();
	}
	
	// Calculates how many symbols "fit" in the frame size passed in the constructor
	// Creates the symbols and stores them into a ArrayList of the type <ToyotaSymbol>
	private void createArraySymbols() {
		int num_symbols_column = (int) (this.frame_width/translate_x);
		int num_symbols_line = (int) (this.frame_height/translate_y);

		
		for(int y = 0 ; y < num_symbols_line; y++) {
			for(int x = 0; x < num_symbols_column; x++) {
				toyota_symbols.add(new ToyotaSymbol(x * translate_x + radius_x, 
						y * translate_y + radius_y, symbol.getSymbolScale()));
			}
		}
	}

	// Iterates the symbols list and tells them to draw
	public void fillSymbols(float time_elapsed) {
		for(int i = 0; i < toyota_symbols.size();i++) {
			toyota_symbols.get(i).draw(parent, time_elapsed);
		}
	}

	@Override
	public void draw(PApplet parent, float dt) {
		time_elapsed = time_elapsed + dt;
		fillSymbols(time_elapsed);

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
