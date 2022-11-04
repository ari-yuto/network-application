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
    int x, y,count;
    ArrayList<Figure> objList;
    Figure obj;
    public static void main(String[] args) {
        Paint2 f = new Paint2();
        f.setSize(640, 480);
        f.setTitle("Paint Sample");
        f.addWindowListener(new WindowAdapter() {
            @Override public void windowClosing(WindowEvent e) {
                System.exit(0);
            }});
        f.setVisible(true);
    }
    Paint2() {
        objList=new ArrayList<Figure>();
        //マウス処理の登録
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    @Override public void paint(Graphics g) {
        Figure f;
        for(int i=0;i<objList.size();i++) {
            f=objList.get(i);
            f.paint(g);
        }
        if (obj != null) obj.paint(g);
    }
    public void mousePressed(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        obj=new Circle();
        obj.moveto(x,y);
        repaint();
        System.out.println(objList.size()+1);
        if(objList.size()>=30) {
        	objList.set(objList.size()%30, obj);
        }
    }
    public void mouseReleased(MouseEvent e) {
        x=e.getX();
        y=e.getY();
        obj.moveto(x,y);
        objList.add(obj);
        obj=null;
        repaint();
    }
    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseDragged(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        if(obj !=null)obj.moveto(x,y);
        repaint();
    }
    public void mouseMoved(MouseEvent e) {}
}