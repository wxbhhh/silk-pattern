package panel;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class Panel12 extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	void divide(int x1,int y1, int x2, int y2, double variance, double H, int n, Graphics g) {
		if(n==1)
			g.drawLine(x1, y1, x2, y2);
		else {
			int h=5;
			double P1=((int)(Math.random()*10)%2==0)?1:-1;
			double P2=Math.pow(1.0/2, variance*H*n);
			//System.out.println(h*Math.pow(P1, 3)*Math.pow(P2, 3)*new Random().nextGaussian());
			int mx=(int) ((x1+x2)/2+h*Math.pow(P1, 3)*Math.pow(P2, 3)*NormalDistribution.calc(new Random().nextGaussian()));
			int my=(int) ((y1+y2)/2+h*Math.pow(P1, 3)*Math.pow(P2, 3)*NormalDistribution.calc(new Random().nextGaussian()));
			
			divide(x1, y1, mx, my, variance, H, n-1, g);
			divide(mx, my, x2, y2, variance, H, n-1, g);
		}
	}
	
	
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.BLUE);
		
//		double pi=Math.PI;
//		double[] angle= {0,60,120,180,240,300};
//		double[][] p=new double[2][6];
//		for(int i=0;i<6;i++) {
//			p[0][i]=Math.sin(angle[i]/180*pi);
//			p[1][i]=Math.cos(angle[i]/180*pi);
//		}
//		
//		for(int i=0;i<3;i++) {
//			int r=(i+1)*100;
//			int[] px=new int[6];
//		    int[] py=new int[6];
//			for(int j=0;j<6;j++) {
//				px[i]=(int) (500+r*p[0][j]);
//				py[i]=(int) (500+r*p[1][j]);
//				System.out.print("("+px[i]+","+py[i]+")");
//			}
//			for(int j=0;j<6;j++) { 
//				  int x1= px[j%6]; 
//				  int y1= py[j%6]; 
//				  int x2= px[(j+1)%6]; 
//				  int y2= py[(j+1)%6]; 
//				  System.out.println("("+x1+","+y1+")");
//				  divide(x1, y1, x2, y2, 0.2, 0.7, 6,g); 
//			}
//		}
		
		
		//正六边形数据
		
		  float r = 100;//边长 
		  float[] px = {0, 0.5f*r, 1.5f*r, 2*r, 1.5f*r, 0.5f*r};
		  float[] py = {0.866f*r, 1.732f*r, 1.732f*r, 0.866f*r, 0, 0}; 
		  for(int i=0;i<6;i++) { 
			  int x1=(int) px[i%6]; 
			  int y1=(int) py[i%6]; 
			  int x2=(int) px[(i+1)%6]; 
			  int y2=(int) py[(i+1)%6]; 
			  divide(x1, y1, x2, y2, 0.2, 0.7, 6,g); 
			  }
		 
		
		//divide(0, 100, 600, 100, 0.1, 0.7, 8, g);
	}
	
}
