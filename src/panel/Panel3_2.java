package panel;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/*蝴蝶曲线
 ρ ＝e^cos(θ)-2cos(4θ)-(sin(θ/5))^5
 * */

public class Panel3_2 extends JPanel {

	private static final long serialVersionUID = 1L;

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.setColor(Color.BLUE);
		int x=0,y=0;
		int x0=400;
		int y0=250;//画板中心坐标
		int l=20;
		int n=3;
		double e=Math.E;
		for(int j=1;j<=n;j++) {
		  for(double theta=0;theta<=2*Math.PI;theta+=0.001) {
			double R=Math.pow(e, Math.cos(theta))-2*Math.cos(4*theta)-Math.pow(Math.sin(theta/5),5);
			double r=j*R*l;
			System.out.println(r);
			x=(int)(x0+r*Math.cos(theta));
			y=(int)(y0-r*Math.sin(theta));
			g.fillOval(x,y, 10, 10);
		  }
	    }

	}
}
