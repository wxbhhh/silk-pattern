package panel;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/*递归螺线
 * R,r:大小圆半径，P:小圆上的点
x=(R+r)cos(θ)+Pcos((R+r)θ/r)
y=(R+r)sin(θ)+Psin((R+r)θ/r)
 * */

public class Panel3_3 extends JPanel {

	private static final long serialVersionUID = 1L;

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.setColor(Color.black);
		int x=0,y=0;
		int x0=400;
		int y0=250;//画板中心坐标
		double R=100;
		double r=20;
		double P=84;
		double e=Math.E;

		//加上外环
		for(double theta=0;theta<=Math.PI*2;theta+=0.0001) {
			x=(int)((R+r)*Math.cos(theta)+P*Math.cos((R+r)*theta/r));
			y=(int)((R+r)*Math.sin(theta)+P*Math.sin((R+r)*theta/r));
			g.fillOval(x0+x,y0-y, 10, 10);
			int Rx=(int) (x0+(R+P+r)*Math.cos(theta));
			int Ry=(int) (y0-(R+P+r)*Math.sin(theta));
			g.fillOval(Rx,Ry, 10, 10);
		  }/**/


		/*for(double theta=0;theta<=2*Math.PI;theta+=0.001) {
			x=(int)((R+r)*Math.cos(theta+Math.PI/2)+P*Math.cos((R+r)*theta/r));
			y=(int)((R+r)*Math.sin(theta+Math.PI/2)+P*Math.sin((R+r)*theta/r));
			g.fillOval(x0+x,y0-y, 10, 10);

		}*/

   }

}
