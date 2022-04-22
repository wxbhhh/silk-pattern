package drawsystem;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

/*条纹图
* */

public class Panel9 extends JSplitPane  implements ActionListener,ItemListener{

	private static final long serialVersionUID = 1L;

	JSplitPane top;
	JPanel  bottom;

	JLabel n=new JLabel("行列数:");
	JComboBox<Integer> nV=new JComboBox<Integer>();



	JLabel line=new JLabel("分割线:");
	JComboBox<Integer> lineV=new JComboBox<Integer>();

	JLabel size=new JLabel("粗细:");
	JComboBox<Integer> sizeb=new JComboBox<Integer>();

	JLabel cenc=new JLabel("花蕊颜色:");
	JComboBox<Integer> cencV=new JComboBox<Integer>();

	JLabel back=new JLabel("背景:");
	JComboBox<Integer> backV=new JComboBox<Integer>();



	JLabel R=new JLabel("R:");
	JComboBox<Integer> Rb=new JComboBox<Integer>();
    JLabel G=new JLabel("G:");
    JComboBox<Integer> Gb=new JComboBox<Integer>();
	JLabel B=new JLabel("B:");
	JComboBox<Integer> Bb=new JComboBox<Integer>();
	JButton button=new JButton("确定");

	public Panel9() {
		super(JSplitPane.VERTICAL_SPLIT);
		top = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		top.setDividerLocation(520);
		JPanel tp=new JPanel();
		tp.setLayout(new GridLayout(2, 9));
		tp.setSize(600, 30);

		for(int i=1;i<=6;i++)
			nV.addItem(i);

		for(int i=1;i<=11;i++) {
			cencV.addItem(i);
			lineV.addItem(i);
			backV.addItem(i);
			sizeb.addItem(i);
		}

		for(int i=10;i<=250;i+=20) {
			   Rb.addItem(i);
			   Gb.addItem(i);
			   Bb.addItem(i);
		}
		nV.addItemListener(this);
		lineV.addItemListener(this);
		cencV.addItemListener(this);
		backV.addItemListener(this);
		sizeb.addItemListener(this);
		Rb.addItemListener(this);
		Gb.addItemListener(this);
		Bb.addItemListener(this);

		tp.add(n);
		tp.add(line);
        tp.add(size);
        tp.add(cenc);
		tp.add(back);
		tp.add(R);
		tp.add(G);
		tp.add(B);

		tp.add(nV);
		tp.add(lineV);
		tp.add(sizeb);
		tp.add(cencV);
		tp.add(backV);

		tp.add(Rb);
		tp.add(Gb);
		tp.add(Bb);
		top.setLeftComponent(tp);
		button.addActionListener(this);
		top.setRightComponent(button);

		bottom = new JPanel();
		bottom.setBackground(Color.white);

		setTopComponent(top);
		setBottomComponent(bottom);
		setDividerLocation(50);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		windowChange();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
//		Color color = JColorChooser.showDialog(this,
//                "Choose a color", Color.white);
//        int R = color.getRed();
//        int G = color.getGreen();
//        int B = color.getBlue();
		if(e.getStateChange() == ItemEvent.SELECTED)
			windowChange();
	}

	void windowChange() {
		Parameter p=new Parameter();
		p.n=(int) nV.getSelectedItem();
        p.line=(int) lineV.getSelectedItem();
		p.cenc=(int) cencV.getSelectedItem();

		p.back=(int) backV.getSelectedItem();
		p.size=(int) sizeb.getSelectedItem();
		p.R=(int) Rb.getSelectedItem();
		p.G=(int) Gb.getSelectedItem();
		p.B=(int) Bb.getSelectedItem();
		bottom = new MyPanel(p);
		this.setBottomComponent(bottom);
		this.validate();
	}

	private class Parameter{
        int n;
		int line;
		int cenc;
		int back;
		int size;
		int R;
		int G;
		int B;
	}
	private class MyPanel extends JPanel{


	   boolean toDraw=false;
	   Parameter p=new Parameter();

	   public MyPanel(Parameter p) {
			super();
			this.p = p;
			toDraw=!toDraw;
	   }

	   @Override
 	   public void paint(Graphics g) {
		  super.paint(g);
		  if(!toDraw)
		    return;

		  Color back = null,line=null,cenc=null;
		  switch(p.back) {
		     case 1:back=Color.WHITE;break;
		     case 2:back=Color.BLUE;break;
		     case 3:back=Color.CYAN;break;
		     case 4:back=Color.GRAY;break;
		     case 5:back=Color.GREEN;break;
		     case 6:back=Color.MAGENTA;break;
		     case 7:back=Color.ORANGE;break;
		     case 8:back=Color.PINK;break;
		     case 9:back=Color.RED;break;
		     case 10:back=Color.BLACK;break;
		  }
		  this.setBackground(back);
		  if(p.back==11) {
			  ImageIcon  background = new ImageIcon("temp2.jpg");
			  background.setImage(background.getImage().getScaledInstance(600, 600,  Image.SCALE_DEFAULT));
			  JLabel label = new JLabel(background);// 把背景图片显示在一个标签里面
			  label.setBounds(0, 0, 600,600);	  // 内容窗格默认的布局管理器为BorderLayout
			  add(label);
		  }

		  switch(p.line) {
		     case 1:line=Color.WHITE;break;
		     case 2:line=Color.BLUE;break;
		     case 3:line=Color.CYAN;break;
		     case 4:line=Color.GRAY;break;
		     case 5:line=Color.GREEN;break;
		     case 6:line=Color.MAGENTA;break;
		     case 7:line=Color.ORANGE;break;
		     case 8:line=Color.PINK;break;
		     case 9:line=Color.RED;break;
		     case 10:line=Color.BLACK;break;
		     case 11:line=Color.YELLOW;break;
		  }
		  switch(p.cenc) {
		     case 1:cenc=Color.WHITE;break;
		     case 2:cenc=Color.BLUE;break;
		     case 3:cenc=Color.CYAN;break;
		     case 4:cenc=Color.GRAY;break;
		     case 5:cenc=Color.GREEN;break;
		     case 6:cenc=Color.MAGENTA;break;
		     case 7:cenc=Color.ORANGE;break;
		     case 8:cenc=Color.PINK;break;
		     case 9:cenc=Color.RED;break;
		     case 10:cenc=Color.BLACK;break;
		     case 11:cenc=Color.YELLOW;break;
		  }

		  int N=p.n;
		  int x0=45,y0=0;
		  int dx=510/N,dy=501/N;
		  int size=p.size;
		  g.setColor(line);
		  double R=(dx-20)/2,r=dx/15;
		  for(int i=0;i<N;i++) {
		     for(int j=0;j<N;j++) {
		        int n=(int) (2.5*N*Math.random());
		        g.setColor(line);
		        int x2=dx*i;
		        int y2=dy*j;
		        for(int k=0;k<=dx;k++) {
		            g.fillOval(x0+x2+k,y0+y2, size,size+1);
		            g.fillOval(x0+x2,y0+y2+k, size,size+1);
		        	g.fillOval(x0+x2+dx,y0+y2+k, size,size+1);
		        	g.fillOval(x0+x2+k,y0+y2+dy, size,size+1);
		        }

		        int red=(int)Math.abs(((i-2)*80+(j-2)*80+p.R)%255);
		 		int green=(int)Math.abs(((i-2)*50+(i-2)*50+p.G)%255);
		 		int blue=(int)Math.abs(((i-2)*150+(i-2)*150+p.B)%255);
		 		Color c=new Color(red,green,blue);
		 		g.setColor(c);


		        int xc=x0+dx*i+dx/2;
		        int yc=y0+dy*j+dy/2;
		        for(double theta=0;theta<=2*Math.PI;theta+=0.0005) {
		        	double l=R*Math.sin(theta*n)+r*Math.random();
					int x=(int)(xc+l*Math.cos(theta));
					int y=(int)(yc-l*Math.sin(theta));
					g.fillOval(x,y, 2, 2);
				}

		        g.setColor(cenc);
		        for(double theta=0;theta<=2*Math.PI;theta+=0.001) {
		        	double l=(dx/5)*Math.sin(theta*n);
		        	int xr=(int)(xc+l*Math.cos(theta));
					int yr=(int)(yc-l*Math.sin(theta));
					g.fillOval(xr,yr, 2, 2);
		        }

		    }
		}

	   }
    }
}