package panel;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/*正弦曲线
 * */

public class Panel3_4 extends JPanel {

	private static final long serialVersionUID = 1L;

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.setColor(Color.black);
		int y1=0;
		double R=100;
		//加上外环
		g.setColor(Color.RED);
		for(double x1=0;x1<=500;x1+=0.001) {
			y1=(int)(R*Math.sin(0.05*x1));
			g.fillOval((int) x1,y1+300, 2, 2);
		  }


   }

}
