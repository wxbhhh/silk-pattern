package panel;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Panel2 extends JPanel{

	private static final long serialVersionUID = 1L;

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		Color c;
		int q=2;
		for(int x=0;x<500;x++) 
		   for(int y=0;y<300;y++){			   
		       double sum=0;
			   for(int j=1;j<=q;j++){
				  double a=Math.cos(2*Math.PI*j/q); 
				  double b=Math.sin(2*Math.PI*j/q);
				  double u=Math.cos(x+y*a)/3;
				  double v=Math.cos(x-y*b)/3;
				  double temp=u+v;
				  sum+=temp;
			   }
			   System.out.println(sum+" "+x);
			   int red=(int)Math.abs((sum*1000)%255);
			   int green=(int)Math.abs((sum*1050+130)%255);
			   int blue=(int)Math.abs((sum*300)%255);
			   c=new Color(red,green,blue);
		       g.setColor(c);
			   g.fillOval(x,y, 2, 2);
		}
	}
	
}