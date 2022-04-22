package panel;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/*
 * 运动曲线
 *
 * */

public class Panel4 extends JPanel {

	private static final long serialVersionUID = 1L;

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.setColor(Color.red);
		int x=0,y=0;
		int x0=400;
		int y0=250;//画板中心坐标
		double e=100;
		double a=2,b=10,c=6,d=0.96;//各种参数
		for(double t=0;t<=Math.PI*2;t+=0.00001) {
			double temp1=Math.cos(c*t)+e*(Math.cos(a*t)
				+d*(Math.cos(b*t)-Math.cos(a*t))-Math.cos(c*t));
			double temp2=Math.sin(c*t)+e*(Math.sin(a*t)
				+d*(Math.sin(b*t)-Math.sin(a*t))-Math.sin(c*t));
			x=(int) (x0+temp1);
			y=(int) (y0+temp2);
			g.fillOval(x,y, 2, 2);
		}


	}
}

