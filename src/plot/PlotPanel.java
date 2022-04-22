package plot;

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

public class PlotPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	boolean toDraw=false;

	Parameter p=new Parameter();

	public PlotPanel() {}

	public PlotPanel(Parameter p) {
		this.p.q=p.q;
		this.p.a=p.a;
		this.p.c=p.c;
		this.p.size=p.size;
		this.p.R=p.R;
		this.p.G=p.G;
		this.p.B=p.B;
		toDraw=!toDraw;
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);

	if(toDraw) {
		//g.drawString("出错了", 20, 30);
		this.setSize(500, 300);
		//this.setLocation(0, 0);
		Color color;
		int q=p.q;
		double a=p.a, c=p.c, size=p.size;;
		//干扰函数
		   //double a=0, c=0;
		  // double a=0, c=0.005;
		   //double a=0.8, c=0;
		   //double a=0.8, c=0.005;
		System.out.println(q);
		System.out.println(a+" "+c);
		for(int x=-250;x<250;x++)
		   for(int y=-150;y<150;y++){
		       double sum=0;
			   for(int j=1;j<=q;j++){
				  double u=x*Math.cos(2*Math.PI*j/q);
				  double v=y*Math.sin(2*Math.PI*j/q);
				  double temp=Math.cos(u+v);
				  sum+=temp;
			   }



			   sum+=a*Math.cos(x*y);
			   sum+=c*(x+y);

		       //int R=80,G=50,B=150;
			   int R=p.R,G=p.G,B=p.B;
			   int red=(int)Math.abs((sum*10+R)%255);
			   int green=(int)Math.abs((sum*50+G)%255);
			   int blue=(int)Math.abs((sum*20+B)%255);
			   color=new Color(red,green,blue);
		       g.setColor(color);
			   g.fillOval(250+x,y+150, 2, 3);
		}
	}
	}
}
class Parameter{
	int q;
	double a;
	double c;
	int size;
	int R;
	int G;
	int B;
}