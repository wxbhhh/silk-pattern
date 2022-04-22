package panel;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/*玫瑰曲线
 ρ ＝ ａｓｉｎ(ｎθ)
 * */

public class Panel3 extends JPanel {

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
        int n=6;

        //单一
		/*for(double theta=0;theta<=2*Math.PI;theta+=0.001) {
			double r=a*Math.sin(theta*n);
			x=(int)(x0+r*Math.cos(theta));
			y=(int)(y0-r*Math.sin(theta));
			g.setColor(Color.red);
			g.fillOval(x,y, 2, 2);

		}*/



		//多重
        /*n=7;
        g.setColor(Color.yellow);
		for(double theta=0;theta<=2*Math.PI;theta+=0.001) {
			double p1=a*Math.sin(theta*n);
			double p2=1.5*a*Math.sin(theta*n);
			for(double r=p1;r<=p2;r+=1) {

			x=(int)(x0+r*Math.cos(theta));
			y=(int)(y0-r*Math.sin(theta));
			g.fillOval(x,y, 2, 2);
              }
		}*/

      //双重
      /*n=8;
      for(double theta=0;theta<=2*Math.PI;theta+=0.001) {
      			double p1=a*Math.sin(theta*n);
      			double p2=a*Math.sin(theta*n+2*Math.PI/n);
      			int x1=(int)(x0+p1*Math.cos(theta));
      			int y1=(int)(y0-p1*Math.sin(theta));
      			//g.setColor(Color.black);
      			g.fillOval(x1,y1, 3, 3);
      	        int x2=(int)(x0+p2*Math.cos(theta));
       			int y2=(int)(y0-p2*Math.sin(theta));
       			g.setColor(Color.PINK);
       			g.fillOval(x2,y2, 3, 3);
        }  */


		 //旋转变换(组合花朵1)
        n=2;
        a=100;
		for(double theta=0;theta<=Math.PI*2;theta+=0.001) {
		   double r1=a*Math.sin(theta*n);
		   double r2=a/2*Math.sin(theta*n);
		   for(double j=Math.abs(r2);j<Math.abs(r1);j+=1) {
			  int red=(int)Math.abs((j*1.5+80)%255);
			  int green=(int)Math.abs((50)%255);
			  int blue=(int)Math.abs((150)%255);
			  Color c=new Color(red,green,blue);
	          g.setColor(c);

		      int x1=(int)(x0+j*Math.cos(theta));
		      int y1=(int)(y0-j*Math.sin(theta));
		      g.fillOval(x1,y1, 2, 2);

		      x1=(int)(x0+j*Math.cos(theta+Math.PI/6));
		      y1=(int)(y0-j*Math.sin(theta+Math.PI/6));
		      g.fillOval(x1,y1, 2, 2);

		      x1=(int)(x0+j*Math.cos(theta+Math.PI/3));
		      y1=(int)(y0-j*Math.sin(theta+Math.PI/3));
		      g.fillOval(x1,y1, 2, 2);
		   }
		}/**/


        //旋转变换(组合花朵2)
        /*n=2;
        a=100;
		for(double theta=0;theta<=Math.PI*2;theta+=0.001) {
		   double r1=a*Math.sin(theta*n);
		   double r2=a/2*Math.sin(theta*n);
		   for(double j=Math.abs(r2);j<Math.abs(r1);j+=0.1) {
			  int red=(int)Math.abs((j*1.5+80)%255);
			  int green=(int)Math.abs((50)%255);
			  int blue=(int)Math.abs((150)%255);
			  Color c=new Color(red,green,blue);
	          g.setColor(c);

		      int x1=(int)(x0+j*Math.cos(theta));
		      int y1=(int)(y0-j*Math.sin(theta));
		      g.fillOval(x1,y1, 2, 2);

		      x1=(int)(x0+j*Math.cos(theta+Math.PI/8));
		      y1=(int)(y0-j*Math.sin(theta+Math.PI/8));
		      g.fillOval(x1,y1, 2, 2);

		      x1=(int)(x0+j*Math.cos(theta+Math.PI/4));
		      y1=(int)(y0-j*Math.sin(theta+Math.PI/4));
		      g.fillOval(x1,y1, 2, 2);
		   }
		} */

		//旋转变换(组合花朵3)
       /* n=3;
        a=100;
		for(double theta=0;theta<=Math.PI*2;theta+=0.001) {
		   double r1=a*Math.sin(theta*n);
		   double r2=a/1.8*Math.sin(theta*n);
		   for(double j=Math.abs(r2);j<Math.abs(r1);j+=0.1) {
			  int red=(int)Math.abs((j*1.5+80)%255);
			  int green=(int)Math.abs((50)%255);
			  int blue=(int)Math.abs((150)%255);
			  Color c=new Color(red,green,blue);
	          g.setColor(c);

		      int x1=(int)(x0+j*Math.cos(theta));
		      int y1=(int)(y0-j*Math.sin(theta));
		      g.fillOval(x1,y1, 2, 2);

		      x1=(int)(x0+j*Math.cos(theta+Math.PI/4));
		      y1=(int)(y0-j*Math.sin(theta+Math.PI/4));
		      g.fillOval(x1,y1, 2, 2);
		   }
		} */
	}
}
