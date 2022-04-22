package panel;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/*菊花曲线
 ρ ＝（a-b）sin(nθ)+b
 * */

public class Panel3_1 extends JPanel {

	private static final long serialVersionUID = 1L;

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.setColor(Color.RED);
		int x=0,y=0;
		int x0=400;
		int y0=250;//画板中心坐标
		double a=150;
		double b=20;
		int n=10;

		/*for(double theta=0;theta<=Math.PI;theta+=0.0001) {
			//double r=5*(1+Math.sin(11*theta/5))-4*Math.sin(4*17*theta/3)*Math.sin(16*Math.cos(3*theta)-8*28*theta);//a*Math.sin(theta*6);
			double r=(a-b)*Math.sin(theta*n)+b;
			x=(int)(x0+r*Math.cos(theta));
			y=(int)(y0-r*Math.sin(theta));
			g.fillOval(x,y, 2, 2);
		}*/

		//加上外环
		/*a=100;b=30;n=7;
		for(double theta=0;theta<=2*Math.PI;theta+=0.001) {
			//double r=5*(1+Math.sin(11*theta/5))-4*Math.sin(4*17*theta/3)*Math.sin(16*Math.cos(3*theta)-8*28*theta);//a*Math.sin(theta*6);
			double p=(a-b)*Math.sin(theta*n)+b;
			for(double r=a-p;r<=a;r++) {
			  x=(int)(x0+r*Math.cos(theta));
			  y=(int)(y0-r*Math.sin(theta));
			  g.fillOval(x,y, 2, 2);
			}
			for(double r=p+a;r<=a;r++) {
				  x=(int)(x0+r*Math.cos(theta));
				  y=(int)(y0-r*Math.sin(theta));
				  g.fillOval(x,y, 2, 2);
				}
		}*/

		//实心
		for(double theta=0;theta<=2*Math.PI;theta+=0.001) {
			//double r=5*(1+Math.sin(11*theta/5))-4*Math.sin(4*17*theta/3)*Math.sin(16*Math.cos(3*theta)-8*28*theta);//a*Math.sin(theta*6);
			double p=(a-b)*Math.sin(theta*n)+b;
			for(double r=0;r<=p;r++) {
			  x=(int)(x0+r*Math.cos(theta));
			  y=(int)(y0-r*Math.sin(theta));
			  g.fillOval(x,y, 2, 2);
			}
			for(double r=p;r<=0;r++) {
				  x=(int)(x0+r*Math.cos(theta));
				  y=(int)(y0-r*Math.sin(theta));
				  g.fillOval(x,y, 2, 2);
			}
		}/**/
	}
}
