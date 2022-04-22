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

/*玫瑰曲线与菊花曲线
ρ ＝ ａｓｉｎ(ｎθ)
* */

public class Panel2 extends JSplitPane  implements ActionListener,ItemListener{

	private static final long serialVersionUID = 1L;

	JSplitPane top;
	JPanel  bottom;

    JLabel outlen=new JLabel("外叶尺寸:");
    JTextField outlenV=new JTextField(5);

    JLabel inlen=new JLabel("内叶尺寸:");
    JTextField inlenV=new JTextField(5);

    JLabel n=new JLabel("叶子个数:");
	JComboBox<Integer> nV=new JComboBox<Integer>();

	JLabel effect=new JLabel("效果:");
	JComboBox<Integer> effectV=new JComboBox<Integer>();

	JLabel back=new JLabel("背景:");
	JComboBox<Integer> backV=new JComboBox<Integer>();

	JLabel size=new JLabel("粗细:");
	JComboBox<Integer> sizeb=new JComboBox<Integer>();

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

	public Panel2() {
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
			effectV.addItem(i);
		}
		for(int i=1;i<=11;i++) {
			backV.addItem(i);
			sizeb.addItem(i);
		}
		for(int i=10;i<=250;i+=20) {
			   Rb.addItem(i);
			   Gb.addItem(i);
			   Bb.addItem(i);
		}
		effectV.addItemListener(this);
		nV.addItemListener(this);
		backV.addItemListener(this);
		sizeb.addItemListener(this);
		Rb.addItemListener(this);
		Gb.addItemListener(this);
		Bb.addItemListener(this);

		tp.add(outlen);
		tp.add(inlen);
		tp.add(n);
		tp.add(effect);
		tp.add(back);
		tp.add(size);
		tp.add(R);
		tp.add(G);
		tp.add(B);

		tp.add(outlenV);
		tp.add(inlenV);
		tp.add(nV);
		tp.add(effectV);
		tp.add(backV);
		tp.add(sizeb);
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
		p.effect=(int) effectV.getSelectedItem();
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

		double outlen;
		double inlen;
		int n;
		int back;
		int effect;
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

		  int x=0,y=0;
		  int x0=300;
		  int y0=250;//画板中心坐标
		  double R=p.outlen;
		  double r=p.inlen;
		  int n=p.n;
		  int effect=p.effect;
		  int size=p.size;

		  switch(effect) {

		  case 1:
			//单一
				for(double theta=0;theta<=2*Math.PI;theta+=0.001) {
					double l=R*Math.sin(theta*n)+r;
					x=(int)(x0+l*Math.cos(theta));
					y=(int)(y0-l*Math.sin(theta));
					g.fillOval(x,y, size, size+1);

				}/**/
				break;
		  case 2:
			   //加上外环

			    for(double theta=0;theta<=2*Math.PI;theta+=0.001) {
					double p=R*Math.sin(theta*n)+r;
					if(p>0)
					for(double l=p;l<=1*R;l+=1) {
				    	x=(int)(x0+l*Math.cos(theta));
				     	y=(int)(y0-l*Math.sin(theta));
					    g.fillOval(x,y, size, size+1);
		            }
					else
						for(double l=-1*R;l<=p;l+=1) {
					    	x=(int)(x0+l*Math.cos(theta));
					     	y=(int)(y0-l*Math.sin(theta));
						    g.fillOval(x,y, size, size+1);
			            }
				}

			    break;
		  case 3:
			    //多重
				for(double theta=0;theta<=2*Math.PI;theta+=0.001) {
					double p1=R*Math.sin(theta*n)+r;
					double p2=1.5*R*Math.sin(theta*n)+r;
					for(double l=p1;l<=p2;l+=1) {

					x=(int)(x0+l*Math.cos(theta));
					y=(int)(y0-l*Math.sin(theta));
					g.fillOval(x,y, size, size+1);
		              }
				}
				break;
		  case 4:
		      for(double theta=0;theta<=2*Math.PI;theta+=0.001) {
		      			double p1=R*Math.sin(theta*n)+r;
		      			double p2=R*Math.sin(theta*n+2*Math.PI/n)+r;
		      			int x1=(int)(x0+p1*Math.cos(theta));
		      			int y1=(int)(y0-p1*Math.sin(theta));
		      			g.setColor(color);
		      			g.fillOval(x1,y1, size, size+1);
		      	        int x2=(int)(x0+p2*Math.cos(theta));
		       			int y2=(int)(y0-p2*Math.sin(theta));
		       			g.setColor(Color.PINK);
		       			g.fillOval(x2,y2, size, size+1);
		        }
		      break;
		  case 5:
			  for(double theta=0;theta<=2*Math.PI;theta+=0.001) {
					double p=(R-r)*Math.sin(theta*n)+r;
					for(double l=R-p;l<=R;l++) {
					  x=(int)(x0+l*Math.cos(theta));
					  y=(int)(y0-l*Math.sin(theta));
					  g.fillOval(x,y, 2, 2);
					}
					for(double l=p+R;l<=R;l++) {
						  x=(int)(x0+l*Math.cos(theta));
						  y=(int)(y0-l*Math.sin(theta));
						  g.fillOval(x,y, 2, 2);
						}
				}
		      break;
		  }

	   }
    }
}