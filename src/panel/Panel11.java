package panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;

import javax.swing.JPanel;

public class Panel11 extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	
	@Override
	public void paint(Graphics g) {
		
		Complex u=new Complex(-2,-1);
		Complex z=new Complex(0,0);
		double a=0.5;
		Color color;
		for(int i=0;i<1000;i++) {
		    z=Complex.add(u, Complex.power(z, 2));
		    
		    int x=400+(int) z.real;
		    int y=200-(int) z.imag;
		    
	        int red=(int) (a*Math.sin(z.imag+z.real));
		    int green=20;
		    int blue=30;
		    
		    
		    System.out.println(x+"  "+y+" "+red);
		    
		    color=new Color(red,green,blue);
		    g.setColor(color);
		    g.fillOval(x,y, 3, 3);
		}
	}
}
