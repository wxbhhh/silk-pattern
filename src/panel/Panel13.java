package panel;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


/**
 *
 * 组合数学方法图案
 *
 */
public class Panel13 extends JPanel{
private static final long serialVersionUID = 1L;

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		//g.drawString("出错了", 20, 30);

		Color c;
		double K=6;
		int m=5,n=5;
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++) {
		         for(int x=0;x<100;x++)
		             for(int y=0;y<100;y++){
			             double u=Math.pow(x, i)+Math.pow(y, j);
		                 int sum=(int) (K*Math.sin(u*Math.PI/10));//Math.cos(2*Math.PI/q)+v*Math.sin(2*Math.PI/q));

		                 System.out.println(sum);
		                 int red=(int)Math.abs((sum*10+80)%255);
		                 int green=(int)Math.abs((sum*50+50)%255);
		                 int blue=(int)Math.abs((sum*20+150)%255);
		                 c=new Color(red,green,blue);
	                     g.setColor(c);
		                 g.fillOval(100*i+x,100*j+y, 3, 4);
	                }
      }
}

}

