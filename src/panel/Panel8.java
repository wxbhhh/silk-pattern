package panel;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

//多重玫瑰曲线

public class Panel8 extends JPanel {

	private static final long serialVersionUID = 1L;

	class MaxPoint{
		int x;
		int y;
		double a;
	}
	
	private MaxPoint[] draw(Graphics g, int x0, int y0, double l, int n, double a) {
		g.setColor(Color.RED);
		int x=0,y=0;
		MaxPoint[] max=new MaxPoint[n];
		int i=0;
		for(double theta=0;theta<=2*Math.PI;theta+=0.0001) {
			double t=theta*n;
			double r=l*Math.sin(t+a);
			x=(int)(x0+r*Math.cos(theta));
			y=(int)(y0-r*Math.sin(theta));
			g.fillOval(x,y, 2, 2);
			if(Math.abs(Math.abs(Math.sin(t))-1)<=0.00000001&&i<n) {
				max[i]=new MaxPoint();
				max[i].x=x;
				max[i].y=y;
				max[i].a=t-Math.PI;
				i++;
			}
		}
		return max;
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		double l=100;
		int x0=400;
		int y0=250;
		MaxPoint[] max=draw(g, x0, y0, l,11, 0);
		for(int i=0;i<max.length;i++) {
			draw(g, max[i].x, max[i].y, 30, 11, max[i].a);
		}
	}
}