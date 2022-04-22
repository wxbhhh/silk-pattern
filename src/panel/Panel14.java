package panel;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


/**
 *
 * 追逐曲线
 *
 */
public class Panel14 extends JPanel{
private static final long serialVersionUID = 1L;

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.setColor(Color.RED);
		int x=0,y=0;
		int x0=400;
		int y0=250;//画板中心坐标
		double a=100;


		int n=2;
		double dt=Math.PI/n;

		/*for(double b=1.5;b>0.3;b-=0.01) {
			g.setColor(new Color(124,(int)(1000*b+200)%255,(int)(1000*b)%255));
		}*/
			double b=0.9;
			for(double theta=0;theta<=Math.PI*2;theta+=0.001) {

			   double r1=a*Math.pow(Math.E, b*1/Math.tan(theta));
			   for(int i=0;i<n;i++) {
			   x=(int)(x0+r1*Math.cos(theta+i*dt));
			   y=(int)(y0-r1*Math.sin(theta+i*dt));
			   g.fillOval(x,y, 4, 4);
			}
				/*double r1=a*Math.pow(Math.E, b*1/Math.tan(theta));
				x=(int)(x0+r1*Math.cos(theta));
				y=(int)(y0-r1*Math.sin(theta));
				g.fillOval(x,y, 4, 4);

				double r2=a*Math.pow(Math.E, b*1/Math.tan(theta));
				//double r=(a-b)*Math.sin(theta*n)+b;
				x=(int)(x0+r2*Math.cos(theta+Math.PI/4));
				y=(int)(y0-r2*Math.sin(theta+Math.PI/4));
				g.fillOval(x,y, 4, 4);

				double r3=a*Math.pow(Math.E, b*1/Math.tan(theta));
				//double r=(a-b)*Math.sin(theta*n)+b;
				x=(int)(x0+r3*Math.cos(theta+Math.PI/2));
				y=(int)(y0-r3*Math.sin(theta+Math.PI/2));
				g.fillOval(x,y, 4, 4);

				double r4=a*Math.pow(Math.E, b*1/Math.tan(theta));
				//double r=(a-b)*Math.sin(theta*n)+b;
				x=(int)(x0+r4*Math.cos(theta-Math.PI/4));
				y=(int)(y0-r4*Math.sin(theta-Math.PI/4));
				g.fillOval(x,y, 4, 4);*/

		}
  }

}

