package drawsystem;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

/*
 * 递归螺线
 *
 * */

public class Panel1 extends JSplitPane  implements ActionListener,ItemListener{

	private static final long serialVersionUID = 1L;

	JSplitPane top;
	JPanel  bottom;


    JTextField qV=new JTextField(5);
    JLabel cR=new JLabel("大圆半径:");
	JTextField cRV=new JTextField(5);
	JLabel cr=new JLabel("小圆半径:");
	JTextField crV=new JTextField(5);

	JLabel locate=new JLabel("位置:");
	JTextField locateV=new JTextField(5);

	JLabel outC=new JLabel("外圆:");
	JComboBox<Integer> outCV=new JComboBox<Integer>();

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

	public Panel1() {
		super(JSplitPane.VERTICAL_SPLIT);
		top = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		top.setDividerLocation(420);
		JPanel tp=new JPanel();
		tp.setLayout(new GridLayout(2, 8));
		tp.setSize(450, 30);

		cRV.setText("80");
		crV.setText("50");
		locateV.setText("60");
		for(int i=0;i<=1;i++)
		   outCV.addItem(i);

		for(int i=1;i<=10;i++)
			   sizeb.addItem(i);
		for(int i=10;i<=250;i+=20) {
			   Rb.addItem(i);
			   Gb.addItem(i);
			   Bb.addItem(i);
		}
		outCV.addItemListener(this);
		sizeb.addItemListener(this);
		Rb.addItemListener(this);
		Gb.addItemListener(this);
		Bb.addItemListener(this);




		tp.add(cR);
		tp.add(cr);
		tp.add(locate);
		tp.add(outC);
		tp.add(size);
		tp.add(R);
		tp.add(G);
		tp.add(B);

		tp.add(cRV);
		tp.add(crV);
		tp.add(locateV);
		tp.add(outCV);
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
		p.outC=(int) outCV.getSelectedItem();
		p.cR=Double.parseDouble(cRV.getText());
		p.cr=Double.parseDouble(crV.getText());
		p.locate=Double.parseDouble(locateV.getText());
		p.size=(int) sizeb.getSelectedItem();
		p.R=(int) Rb.getSelectedItem();
		p.G=(int) Gb.getSelectedItem();
		p.B=(int) Bb.getSelectedItem();
		bottom = new MyPanel(p);
		this.setBottomComponent(bottom);
		this.validate();
	}

	private class Parameter{
		int outC;
		double cR;
		double cr;
		double locate;
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
	      Color color=new Color(p.R, p.G, p.B);
		  g.setColor(color);

		  int x=0,y=0;
		  int x0=250;
		  int y0=250;//画板中心坐标
		  double R=p.cR;
		  double r=p.cr;
		  double P=p.locate;
		  int size=p.size;

		  if(p.outC==1)
			 for(double theta=-2*Math.PI;theta<=Math.PI*2;theta+=0.0001) {
				x=(int)((R+r)*Math.cos(theta)+P*Math.cos((R+r)*theta/r));
				y=(int)((R+r)*Math.sin(theta)+P*Math.sin((R+r)*theta/r));
				g.fillOval(x0+x,y0-y, size, size+1);
				int Rx=(int) (x0+(R+P+r)*Math.cos(theta));
				int Ry=(int) (y0-(R+P+r)*Math.sin(theta));
				g.fillOval(Rx,Ry, size, size+1);
			  }
		  else
			for(double theta=-2*Math.PI;theta<=2*Math.PI;theta+=0.0001) {
				x=(int)((R+r)*Math.cos(theta)+P*Math.cos((R+r)*theta/r));
				y=(int)((R+r)*Math.sin(theta)+P*Math.sin((R+r)*theta/r));
				g.fillOval(x0+x,y0-y, size, size+1);
			}


	   }
    }
}