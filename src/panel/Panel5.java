package panel;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

//米拉图形

public class Panel5 extends JPanel {

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
			g.fillOval(x1,y1, 2, 2);
		}
		       
	}
}
