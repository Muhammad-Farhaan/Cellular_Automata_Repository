import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MyCanvas extends Canvas/* implements MouseListener,MouseMotionListener */{
	Color canvasColor;
	MyCanvas(){
		super(); //get the constructor of the Canvas Class
		JFrame window=new JFrame("Canvas Window");
		window.setExtendedState(JFrame.MAXIMIZED_BOTH);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		window.setLayout(new GridLayout()); //Defining a layout for the window
		
		window.add(this); //window add canvas
		setVisible(true); //set canvas to visible
		canvasColor=Color.GRAY; 
		setBackground(canvasColor); //Set background of canvas to RED
	}
	
	public void paint(Graphics g) { //overriding a method paint
		g.drawRect(382, 300, 100, 100); //(x,y,width,height) -> (0-1364,0-735,width,height
		
//		g.drawLine(300, 10, 700, 510); //(x1,y1,x2,y2)
	}
}
