package panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * 准规则斑图
 *
 * */

public class Panel1 extends JPanel {

	private static final long serialVersionUID = 1L;

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		//g.drawString("出错了", 20, 30);

		Color c;
		int q=7;
		for(int x=-250;x<250;x++)
		   for(int y=-150;y<150;y++){
		       double sum=0;
			   for(int j=1;j<=q;j++){
				  double u=x*Math.cos(2*Math.PI*j/q);
				  double v=y*Math.sin(2*Math.PI*j/q);

				   double u1=1.0/3*Math.cos(x+y*Math.cos(Math.PI*2*j/q));
				   double v2=1.0/3*Math.cos(x-y*Math.sin(Math.PI*2*j/q));


				   double temp=Math.cos(u+v);
                   temp+=u1+v2;

				   sum+=temp;
			   }
			   System.out.println(sum*100);
			   int red=(int)Math.abs((sum*10+60)%255);
			   int green=(int)Math.abs((sum*50+50)%255);
			   int blue=(int)Math.abs((sum*20+150)%255);
			   c=new Color(red,green,blue);
		       g.setColor(c);
			   g.fillOval(x+250,y+150, 2, 2);
		}
	}

}
