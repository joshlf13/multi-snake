package core;
//A SolidColorRenderer keeps track of the color and shape of each elementType, and renders it accordingly.
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.util.Random;

public class SolidColorRenderer extends Renderer{
	public SolidColorRenderer(int width, int height, int tileSize, Color[] colors, byte[] shapes, int elementsUsed){
		super(width, height, tileSize, colors, shapes, elementsUsed);
		shapes = new byte[127];
		colors = new Color[127];
		this.elementsUsed = elementsUsed;
		randomize(127);
	}

	public void clear(int frame){
		if(frame % 4 == 0) randomize(127);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width * tileSize, height * tileSize);
	}
	public void drawElement(int x, int y, int frame, byte elementType){
		//System.out.println("DRAWING");
		g.setColor(colors[elementType]);
		x *= tileSize;
		y *= tileSize;
		//System.out.printf("%d, %d, %d, %d\n",x, y, tileSize, tileSize);
		//g.setColor(Color.WHITE);
		g.fillRect(x, y, tileSize, tileSize);
		switch(shapes[elementType]){
			case SQUARE:
				g.fillRect(x, y, tileSize, tileSize);
			break;
			case CIRCLE:
			default:
				g.fillOval(x, y, tileSize, tileSize);
			break;
		}
	}
}
