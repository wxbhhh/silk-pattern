package panel;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Panel10 extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		Color color;
		
		Complex a=new Complex(100, 100);
		int p=3;
		for(int i=0;i<1000;i++) {
		    Complex a1=Complex.power(a, p);
		    Complex a2=Complex.multiply(new Complex(p-1, 0), a1);
		    Complex a3=Complex.add(a2, new Complex(1, 0));
		    Complex b1=Complex.power(a, p-1);
		    Complex b2=Complex.multiply(new Complex(p, 0), b1);
		    a=Complex.div(a3, b2);
		
		
		    int x=400+(int) a.real;
		    int y=200-(int) a.imag;
		    System.out.println(a.real+"  "+a.real);
		
	        int red=(i*10)%255;
		    int green=(i*20)%255;
		    int blue=(i*30)%255;
		    color=new Color(red,green,blue);
		    g.setColor(color);
		    g.fillOval(x,y, 3, 3);
		}
	}
	
	public static void main(String args[]) {
		Complex a=new Complex(-88, 88);
		int p=3;
		Complex a1=Complex.power(a, p);
		Complex a2=Complex.multiply(new Complex(p-1, 0), a1);
		Complex a3=Complex.add(a2, new Complex(1, 0));
		Complex b1=Complex.power(a, p-1);
		Complex b2=Complex.multiply(new Complex(p, 0), b1);
		Complex last=Complex.div(a3, b2);
		System.out.print(last.real+" "+last.imag);
		
	}
}
