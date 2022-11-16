package enshu7;

import java.awt.Graphics;

public class Circle extends Figure{
	int size,num,count;
	
	Circle(int size){
		if(size%2==1) {
			this.size=10;
		}else {
			this.size=50;
		}
		count=size;
	}
	@Override public void paint(Graphics g) {
		if(count%3==0) {
			g.setColor(color);
			g.drawOval(x-this.size/2, y-this.size/2, this.size, this.size);
			if(count%6==0) {
				g.fillOval(x-this.size/2, y-this.size/2, this.size, this.size);
			}
		}
		else if(count%3==1){
			g.setColor(color);
			g.drawLine(x+25,y+25,x-25,y-25);
			g.drawLine(x-25,y+25,x+25,y-25);
		}
		else {
			g.setColor(color);
			g.drawRect(x, y, this.size, this.size);
			if(count%6==2) {
				g.fillRect(x, y, this.size, this.size);
			}
		}
			
	}
}