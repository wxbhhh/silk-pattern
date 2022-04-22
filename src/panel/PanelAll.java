package panel;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PanelAll extends JPanel {

	private static final long serialVersionUID = 1L;

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.RED);
		int x=0,y=0;
		int x1=50;
		int y1=50;//小块中心坐标
		double a=40,b=10;//半径
        int N=6;
        int d=100;
        for(int i=0;i<5;i++) {
        	for(int j=0;j<5;j++) {
        	   
        	   int n=(int) (2.5*N*Math.random());
        	   
        	   g.setColor(Color.green);
        	   int x2=d*i;
         	   int y2=d*j;
        	   for(int k=0;k<100;k++) {
        			g.fillOval(x2+k,y2, 2, 2);
        			g.fillOval(x2,y2+k, 2, 2);
        			g.fillOval(x2+100,y2+k, 2, 2);
        			g.fillOval(x2+k,y2+100, 2, 2);
        		}
        	   
        	   int red=(int)Math.abs(((i-2)*80+(j-2)*80)%255);
 			   int green=(int)Math.abs(((i-2)*50+(i-2)*50)%255);
 			   int blue=(int)Math.abs(((i-2)*150+(i-2)*150)%255);
 			   Color c=new Color(red,green,blue);
 		       g.setColor(c);
        		
        	   
        	   int x0=d*i+x1;
        	   int y0=d*j+y1;
        	   for(double theta=0;theta<=2*Math.PI;theta+=0.001) {
			       
        		   
        		   
        		   double r=a*Math.sin(theta*n)+b*Math.random();
			       x=(int)(x0+r*Math.cos(theta));
			       y=(int)(y0-r*Math.sin(theta));
			       
			       g.fillOval(x,y, 2, 2);		       
			       
		         }
        	   
        	   g.setColor(Color.yellow);
        	   for(double theta=0;theta<=2*Math.PI;theta+=0.001) {
        		   double r=15*Math.sin(theta*n);
        		   int xr=(int)(x0+r*Math.cos(theta));
			       int yr=(int)(y0-r*Math.sin(theta));
			       
			       g.fillOval(xr,yr, 2, 2);
        	   }
        	}
        }
       
	}

}
