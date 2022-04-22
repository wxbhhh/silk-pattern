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

/*追逐曲线
* */

public class Panel5 extends JSplitPane  implements ActionListener,ItemListener{

	private static final long serialVersionUID = 1L;

	JSplitPane top;
	JPanel  bottom;

    JLabel outlen=new JLabel("尺寸:");
    JTextField outlenV=new JTextField(5);

    JLabel type=new JLabel("类型:");
	JComboBox<Integer> typeV=new JComboBox<Integer>();

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

	public Panel5() {
		super(JSplitPane.VERTICAL_SPLIT);
		top = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		top.setDividerLocation(520);
		JPanel tp=new JPanel();
		tp.setLayout(new GridLayout(2, 9));
		tp.setSize(600, 30);

		outlenV.setText("100");
		for(int i=2;i<=20;i+=2)
		   typeV.addItem(i);

		for(int i=1;i<=11;i++) {
			backV.addItem(i);
			sizeb.addItem(i);
		}
		for(int i=10;i<=250;i+=20) {
			   Rb.addItem(i);
			   Gb.addItem(i);
			   Bb.addItem(i);
		}
		typeV.addItemListener(this);
		backV.addItemListener(this);
		sizeb.addItemListener(this);
		Rb.addItemListener(this);
		Gb.addItemListener(this);
		Bb.addItemListener(this);

		tp.add(outlen);
		tp.add(type);
		tp.add(back);
		tp.add(size);
		tp.add(R);
		tp.add(G);
		tp.add(B);

		tp.add(outlenV);
		tp.add(typeV);
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
		p.type=(int) typeV.getSelectedItem()/2;
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
		int type;
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

		  int x=0,y=0;
		  int x0=300;
		  int y0=250;//画板中心坐标
		  double a=p.outlen;
		  int type=p.type;
		  int size=p.size;

			double dt=Math.PI/type;

			for(double b=1.5;b>0.3;b-=0.01) {
				g.setColor(new Color(p.R,(int)(1000*b+p.G)%255,(int)(1000*b+p.B)%255));
			for(double theta=0;theta<=Math.PI*2;theta+=0.001) {

				   double r1=a*Math.pow(Math.E, b*1/Math.tan(theta));
				for(int i=0;i<type;i++) {
				   x=(int)(x0+r1*Math.cos(theta+i*dt));
				   y=(int)(y0-r1*Math.sin(theta+i*dt));
				   g.fillOval(x,y, size, size+1);
				}
			}
			}


	   }
    }
}