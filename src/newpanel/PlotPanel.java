package newpanel;

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
		double a=p.a, c=p.c;
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
				 //double u=x*Math.cos(2*Math.PI*j/q);
					  //double v=y*Math.sin(2*Math.PI*j/q);

					   //斑图扩展形式1
					  //double u=x*Math.tan(2*Math.PI*j/q);
					  //double v=y*Math.sin(2*Math.PI*j/q);

					 //斑图扩展形式2
//					  double x1=x;
//					  double y1=Math.sin(y);
//					  double u=x1*Math.tan(2*Math.PI*j/q);
//					  double v=y1*Math.sin(2*Math.PI*j/q);
//					  double temp=Math.cos(u+v);

					  double x1=0.5*x;
				      double y1=y+Math.sin(x1);
					  double u=x1*Math.tan(2*Math.PI*j/q);
					  double v=y1*Math.sin(2*Math.PI*j/q);
					  double temp=Math.cos(u+v);
                  //设置干扰函数f(u,v)=1/3cos(u+vcos2PIj/q)+1/3cos(u-vsin2PIj/q)
//				  double u1=1.0/3*Math.cos(x+y*Math.cos(Math.PI*2*j/q));
//				   double v2=1.0/3*Math.cos(x-y*Math.sin(Math.PI*2*j/q));
//				   double temp=Math.cos(u+v);
//                  temp+=u1+v2;

				  //设置干扰函数f(u,v)=tan(1/x/y);
			      double f=Math.tan(1.0/(x*y));
			      temp+=f;

			      sum+=temp;
			   }




              //是否添加光影效果
			   sum+=a*Math.cos(x*y);
			   sum+=c*(x+y);

		       //int R=80,G=50,B=150;
			   int R=p.R,G=p.G,B=p.B,size=p.size;
			   int red=(int)Math.abs((sum*10+R)%255);
			   int green=(int)Math.abs((sum*50+G)%255);
			   int blue=(int)Math.abs((sum*20+B)%255);
			   color=new Color(red,green,blue);
		       g.setColor(color);
			   g.fillOval(x+250,y+150, size, size+1);
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