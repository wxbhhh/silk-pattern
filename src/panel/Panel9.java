package panel;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Panel9 extends JPanel {

	private static final long serialVersionUID = 1L;

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		Color color;
		int q=13;
		
		for(int x=0;x<500;x++) 
		   for(int y=0;y<300;y++){			   
		       double sum=0;
			   for(int j=1;j<=q;j++){
				  double u=x*Math.cos(2*Math.PI*j/q); 
				  double v=y*Math.sin(2*Math.PI*j/q);
				  double temp=Math.cos(u+v);
				  sum+=temp;
				  
			   }
		   
			   
			   //干扰函数
			   //double a=0, c=0;
			   double a=0, c=0.005;
			   //double a=0.8, c=0;
			   //double a=0.8, c=0.005;
			   sum+=a*Math.cos(x*y);
			   sum+=c*(x+y);
			   
			   System.out.println(sum);
			   int red=(int)Math.abs((sum*10+80)%255);
			   int green=(int)Math.abs((sum*50+50)%255);
			   int blue=(int)Math.abs((sum*20+150)%255);
			   color=new Color(red,green,blue);
		       g.setColor(color);
			   g.fillOval(x,y, 2, 2);
		}
	}
}

