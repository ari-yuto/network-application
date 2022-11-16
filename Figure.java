package enshu7;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Figure extends Coord{
	Color color;
	Figure(){
		Random random=new Random();
		for(int i=0;i<3;i++) {
			color = new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256));
		}
	}
	public void paint(Graphics g) {}
}
