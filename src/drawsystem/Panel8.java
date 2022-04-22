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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

/*组合花朵图案
* */

public class Panel8 extends JSplitPane  implements ActionListener,ItemListener{

	private static final long serialVersionUID = 1L;

	JSplitPane top;
	JPanel  bottom;

    JLabel outlen=new JLabel("外叶尺寸:");
    JTextField outlenV=new JTextField(5);

    JLabel inlen=new JLabel("内叶尺寸:");
    JTextField inlenV=new JTextField(5);

    JLabel n=new JLabel("叶子个数:");
	JComboBox<Integer> nV=new JComboBox<Integer>();

	JLabel type=new JLabel("效果:");
	JComboBox<Integer> typeV=new JComboBox<Integer>();

	JLabel back=new JLabel("背景:");
	JComboBox<Integer> backV=new JComboBox<Integer>();

	JLabel leval=new JLabel("旋转等级:");
	JComboBox<Integer> levalV=new JComboBox<Integer>();

	JLabel R=new JLabel("R:");
	JComboBox<Integer> Rb=new JComboBox<Integer>();
    JTextField RV=new JTextField(5);
    JLabel G=new JLabel("G:");
    JComboBox<Integer> Gb=new JComboBox<Integer>();
	JTextField GV=new JTextField(5);
	JLabel B=new JLabel("B:");
	JComboBox<Integer> Bb=new JComboBox<Integer>();
	JTextField BV=new JTextField(5);
	JButton button=new JButton("确定");

	public Panel8() {
		super(JSplitPane.VERTICAL_SPLIT);
		top = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		top.setDividerLocation(520);
		JPanel tp=new JPanel();
		tp.setLayout(new GridLayout(2, 9));
		tp.setSize(600, 30);

		outlenV.setText("100");
		inlenV.setText("0");
		for(int i=0;i<=20;i++)
		   nV.addItem(i);

		for(int i=1;i<=4;i++) {
			typeV.addItem(i);
		}
		for(int i=1;i<=11;i++) {
			backV.addItem(i);
		}
		for(int i=0;i<=30;i++) {
			levalV.addItem(i);
		}
		for(int i=10;i<=250;i+=20) {
			   Rb.addItem(i);
			   Gb.addItem(i);
			   Bb.addItem(i);
		}
		typeV.addItemListener(this);
		nV.addItemListener(this);
		backV.addItemListener(this);
		levalV.addItemListener(this);
		Rb.addItemListener(this);
		Gb.addItemListener(this);
		Bb.addItemListener(this);

		tp.add(outlen);
		tp.add(inlen);
		tp.add(n);
		tp.add(type);
		tp.add(back);
		tp.add(leval);
		tp.add(R);
		tp.add(G);
		tp.add(B);

		tp.add(outlenV);
		tp.add(inlenV);
		tp.add(nV);
		tp.add(typeV);
		tp.add(backV);
		tp.add(levalV);
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
		if(e.getStateChange() == ItemEvent.SELECTED)
			windowChange();
	}

	void windowChange() {
		Parameter p=new Parameter();

		p.outlen=Double.parseDouble(outlenV.getText());
		p.inlen=Double.parseDouble(inlenV.getText());
		p.n=(int) nV.getSelectedItem();
		p.type=(int) typeV.getSelectedItem();
		p.back=(int) backV.getSelectedItem();
		p.leval=(int) levalV.getSelectedItem();
		p.R=(int) Rb.getSelectedItem();
		p.G=(int) Gb.getSelectedItem();
		p.B=(int) Bb.getSelectedItem();
		bottom = new MyPanel(p);
		this.setBottomComponent(bottom);
		this.validate();
	}

	private class Parameter{

		double outlen;
		double inlen;
		int n;
		int back;
		int type;
		int leval;
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
		  Color back = null;
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

	      Color color=new Color(p.R, p.G, p.B);
		  g.setColor(color);

		  int x0=300;
		  int y0=250;//画板中心坐标
		  double R=p.outlen;
		  double r=p.inlen;
		  int n=p.n;
		  int type=p.type;
		  int leval=p.leval;

		  double angle=Math.PI/30*leval;

		  switch(type) {

		  case 1:
				for(double theta=0;theta<=Math.PI*2;theta+=0.01) {
				   double r1=R*Math.sin(theta*n);
				   double r2=r*Math.sin(theta*n);
				   for(double j=Math.abs(r2);j<Math.abs(r1);j+=1) {
					  int red=(int)Math.abs((j*1.5+p.R+80)%255);
					  int green=(int)Math.abs((50+p.G)%255);
					  int blue=(int)Math.abs((150+p.B)%255);
					  Color c=new Color(red,green,blue);
			          g.setColor(c);

				      int x1=(int)(x0+j*Math.cos(theta));
				      int y1=(int)(y0-j*Math.sin(theta));
				      g.fillOval(x1,y1, 4, 4);

				      x1=(int)(x0+j*Math.cos(theta+angle*2));
				      y1=(int)(y0-j*Math.sin(theta+angle*2));
				      g.fillOval(x1,y1, 4, 4);

				      x1=(int)(x0+j*Math.cos(theta+angle*3));
				      y1=(int)(y0-j*Math.sin(theta+angle*3));
				      g.fillOval(x1,y1, 4, 4);
				   }
				}
				break;
		  case 2:
			  for(double theta=0;theta<=Math.PI*2;theta+=0.01) {
				   double r1=R*Math.sin(theta*n);
				   double r2=r*Math.sin(theta*n);
				   for(double j=Math.abs(r2);j<Math.abs(r1);j+=1) {
					  int red=(int)Math.abs((j*1.5+p.R+80)%255);
					  int green=(int)Math.abs((50+p.G)%255);
					  int blue=(int)Math.abs((150+p.B)%255);
					  Color c=new Color(red,green,blue);
			          g.setColor(c);

				      int x1=(int)(x0+j*Math.cos(theta));
				      int y1=(int)(y0-j*Math.sin(theta));
				      g.fillOval(x1,y1, 4, 4);

				      x1=(int)(x0+j*Math.cos(theta+Math.PI/8));
				      y1=(int)(y0-j*Math.sin(theta+Math.PI/8));
				      g.fillOval(x1,y1, 4, 4);

				      x1=(int)(x0+j*Math.cos(theta+Math.PI/4));
				      y1=(int)(y0-j*Math.sin(theta+Math.PI/4));
				      g.fillOval(x1,y1, 4, 4);
				   }
				}

			    break;
		  case 3:
			  for(double theta=0;theta<=Math.PI*2;theta+=0.01) {
				   double r1=R*Math.sin(theta*n);
				   double r2=r*Math.sin(theta*n);
				   for(double j=Math.abs(r2);j<Math.abs(r1);j+=1) {
					  int red=(int)Math.abs((j*1.5+p.R+80)%255);
					  int green=(int)Math.abs((50+p.G)%255);
					  int blue=(int)Math.abs((150+p.B)%255);
					  Color c=new Color(red,green,blue);
			          g.setColor(c);

				      int x1=(int)(x0+j*Math.cos(theta));
				      int y1=(int)(y0-j*Math.sin(theta));
				      g.fillOval(x1,y1, 4, 4);

				      x1=(int)(x0+j*Math.cos(theta+angle));
				      y1=(int)(y0-j*Math.sin(theta+angle));
				      g.fillOval(x1,y1, 4, 4);
				   }
				}
				break;
		  case 4:
			  for(double theta=0;theta<=Math.PI*2;theta+=0.01) {
				   double r1=R*Math.sin(theta*n);
				   double r2=r*Math.sin(theta*n);
				   for(double j=Math.abs(r2);j<Math.abs(r1);j+=1) {
					  int red=(int)Math.abs((j*1.5+p.R+80)%255);
					  int green=(int)Math.abs((50+p.G)%255);
					  int blue=(int)Math.abs((150+p.B)%255);
					  Color c=new Color(red,green,blue);
			          g.setColor(c);

				      int x1=(int)(x0+j*Math.cos(theta));
				      int y1=(int)(y0-j*Math.sin(theta));
				      g.fillOval(x1,y1, 4, 4);

				      x1=(int)(x0+j*Math.cos(theta+Math.PI/3));
				      y1=(int)(y0-j*Math.sin(theta+Math.PI/3));
				      g.fillOval(x1,y1, 4, 4);
				   }
				}
		      break;
		  }

	   }
    }
}