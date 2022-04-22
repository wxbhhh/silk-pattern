package panel;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

//米拉图形+运动曲线

public class Panel7 extends JPanel {

	private static final long serialVersionUID = 1L;

	double sign(double x) {
		if(x==0)
			return 0;
		if(x<0)
			return -1;
		else
			return 1;
	}
	
	double f(double x) {
		double a=0.3000001;
		double temp=2*Math.PI*a*sign(x)+Math.PI
				+Math.sin(Math.PI+Math.sin(Math.PI+x));
		//double temp=a*x+2*(1-a)*x*x/(1+x*x);
		return temp;
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.setColor(Color.BLUE);
		double x=80,y=80;
		int x0=400;
		int y0=250;//画板中心坐标
		double b=1.0000001;
		for(int i=0;i<100000;i++) {
			double temp=x;
			x=b*y+f(x);
			y=f(x)-temp;
			int x1=(int) (x+x0);
			int y1=(int) (y0-y);
			if(i>=60000)
				g.setColor(Color.ORANGE);
			g.fillOval(x1,y1, 2, 2);
		}
		/*
		 * g.setColor(Color.RED); int x1=0,y1=0; double e=50; double
		 * a=6,b1=56,c=8,d=0.99;//各种参数 for(double t=0;t<=2*Math.PI;t+=0.0001) { double
		 * temp1=Math.cos(c*t)+e*(Math.cos(a*t)
		 * +d*(Math.cos(b1*t)-Math.cos(a*t))-Math.cos(c*t)); double
		 * temp2=Math.sin(c*t)+e*(Math.sin(a*t)
		 * +d*(Math.sin(b1*t)-Math.sin(a*t))-Math.sin(c*t)); x1=(int) (x0+temp1);
		 * y1=(int) (y0+temp2); g.fillOval(x1,y1, 2, 2); }
		 */
	}
}


