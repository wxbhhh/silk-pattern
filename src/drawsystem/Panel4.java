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

/*玫瑰曲线
ρ ＝ ａｓｉｎ(ｎθ)
* */

public class Panel4 extends JSplitPane  implements ActionListener,ItemListener{

	private static final long serialVersionUID = 1L;

	JSplitPane top;
	JPanel  bottom;

    JLabel outlen=new JLabel("外尺寸:");
    JTextField outlenV=new JTextField(5);

    JLabel inlen=new JLabel("内尺寸:");
    JTextField inlenV=new JTextField(5);

    JLabel type=new JLabel("类型:");
	JComboBox<Integer> typeV=new JComboBox<Integer>();

	JLabel effect=new JLabel("效果:");
	JComboBox<Integer> effectV=new JComboBox<Integer>();

	JLabel back=new JLabel("背景:");
	JComboBox<Integer> backV=new JComboBox<Integer>();

	JLabel size=new JLabel("粗细:");
	JComboBox<Integer> sizeb=new JComboBox<Integer>();

	JLabel R=new JLabel("R:");
	JComboBox<Integer> Rb=new JComboBox<Integer>();
    JLabel G=new JLabel("G:");
    JComboBox<Integer> Gb=new JComboBox<Integer>();
	JLabel B=new JLabel("B:");
	JComboBox<Integer> Bb=new JComboBox<Integer>();
	JButton button=new JButton("确定");

	public Panel4() {
		super(JSplitPane.VERTICAL_SPLIT);
		top = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		top.setDividerLocation(520);
		JPanel tp=new JPanel();
		tp.setLayout(new GridLayout(2, 9));
		tp.setSize(600, 30);

		outlenV.setText("80");
		inlenV.setText("1.1");
		for(int i=1;i<=2;i++)
		   typeV.addItem(i);

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
		typeV.addItemListener(this);
		backV.addItemListener(this);
		sizeb.addItemListener(this);
		Rb.addItemListener(this);
		Gb.addItemListener(this);
		Bb.addItemListener(this);

		tp.add(outlen);
		tp.add(inlen);
		tp.add(type);
		tp.add(effect);
		tp.add(back);
		tp.add(size);
		tp.add(R);
		tp.add(G);
		tp.add(B);

		tp.add(outlenV);
		tp.add(inlenV);
		tp.add(typeV);
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
		p.type=(int) typeV.getSelectedItem();
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
		int type;
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
		  double e=p.outlen;
		  double d=p.inlen;
		  int type=p.type;
		  int effect=p.effect;
		  int size=p.size;

		  if(type==1) {
			  double a=2,b=10,c=6;//各种参数
			  switch(effect) {

			  case 1:
				    a=2;
				    b=10;
				    c=6;
					break;
			  case 2:
				    a=3;
				    b=20;
				    c=10;
				    break;
			  case 3:
				    a=4;
				    b=15;
				    c=30;
				    break;
			  case 4:
				    a=20;
				    b=30;
				    c=40;
				    break;
			  }
			  for(double t=0;t<=Math.PI*2;t+=0.0001) {
					double temp1=Math.cos(c*t)+e*(Math.cos(a*t)
						+d*(Math.cos(b*t)-Math.cos(a*t))-Math.cos(c*t));
					double temp2=Math.sin(c*t)+e*(Math.sin(a*t)
						+d*(Math.sin(b*t)-Math.sin(a*t))-Math.sin(c*t));
					x=(int) (x0+temp1);
					y=(int) (y0-temp2);
					g.fillOval(x,y, size, size+1);
				}
		  }
		  else {
			  int n=effect;
			  double E=Math.E;
			  for(int j=1;j<=n;j++) {
			    for(double theta=0;theta<=2*Math.PI;theta+=0.0001) {
			      double R=Math.pow(E, Math.cos(theta))-2*Math.cos(4*theta)-Math.pow(Math.sin(theta/5),5);
			      double r=j*R*e;
			      x=(int)(x0+r*Math.cos(theta));
			      y=(int)(y0-r*Math.sin(theta));
			      g.fillOval(x,y, size, size+1);
				}
			}

		  }


	   }
    }
}