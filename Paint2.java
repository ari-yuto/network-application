package enshu7;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class Paint2 extends Frame implements MouseListener, MouseMotionListener {
	
	static int _MAX_DRAW = 30;
	
	int x,y;
	ArrayList<Figure> objList;
	Figure obj;
	
	public static void main(String[] args) {
		if(args.length !=0) _MAX_DRAW = Integer.parseInt(args[0]);
		Paint2 f = new Paint2();
		f.setSize(640,480);
		f.setTitle("Print Sample");
		f.addWindowListener(new WindowAdapter() {
		@Override public void windowClosing(WindowEvent e) {
			System.exit(0);
		}});
		f.setVisible(true);
	}
	
	public Paint2() {
		objList = new ArrayList<Figure>();
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	@Override public void paint(Graphics g) {
		Figure f;
		for (int i = 0; i < objList.size(); i++) {
			f = objList.get(i);
			f.paint(g);
		}
		if(obj != null) obj.paint(g);
	}
	
	@Override public void mousePressed(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		int list_count = objList.size() + 1;
		if(list_count > _MAX_DRAW) {
			objList.remove(0);
			list_count--;
		}
		obj = new Circle();
		System.out.println(list_count);
		obj.moveto(x, y);
		repaint();
	}
	
	@Override public void mouseReleased(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		obj.moveto(x, y);
		objList.add(obj);
		obj = null;
		repaint();
	}
	@Override public void mouseClicked(MouseEvent e) {}
	@Override public void mouseEntered(MouseEvent e) {}
	@Override public void mouseExited(MouseEvent e) {}
	@Override public void mouseDragged(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		if(obj != null)	obj.moveto(x, y); 		
		repaint();
	}
	@Override public void mouseMoved(MouseEvent e) {}
}

