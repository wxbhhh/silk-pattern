
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

public class Panel6 extends JSplitPane implements ActionListener,ItemListener{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	JSplitPane top;
	JPanel  bottom;

	JLabel q=new JLabel("q:");
	JComboBox<Integer> qb=new JComboBox<Integer>();
    JTextField qV=new JTextField(5);
    JLabel a=new JLabel("a:");
	JTextField aV=new JTextField(5);
	JLabel c=new JLabel("c:");
	JTextField cV=new JTextField(5);
	JLabel type=new JLabel("type:");
	JComboBox<Integer> typeV=new JComboBox<Integer>();

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

	public Panel6() {
		super(JSplitPane.VERTICAL_SPLIT);
		top = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		top.setDividerLocation(400);
		JPanel tp=new JPanel();
		tp.setLayout(new GridLayout(2, 7));
		tp.setSize(450, 30);
		for(int i=1;i<=20;i++)
		   qb.addItem(i);
		aV.setText("0");
		cV.setText("0");
		for(int i=1;i<=4;i++)
			   typeV.addItem(i);
		for(int i=10;i<=250;i+=10) {
			   Rb.addItem(i);
			   Gb.addItem(i);
			   Bb.addItem(i);
		}
		qb.addItemListener(this);
		typeV.addItemListener(this);
		Rb.addItemListener(this);
		Gb.addItemListener(this);
		Bb.addItemListener(this);



		tp.add(q);
		tp.add(a);
		tp.add(c);
		tp.add(type);
		tp.add(R);
		tp.add(G);
		tp.add(B);
		tp.add(qb);
		tp.add(aV);
		tp.add(cV);
		tp.add(typeV);
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
		p.q=(int) qb.getSelectedItem();
		p.a=Double.parseDouble(aV.getText());
		p.c=Double.parseDouble(cV.getText());
		p.type=(int) typeV.getSelectedItem();
		p.R=(int) Rb.getSelectedItem();
		p.G=(int) Gb.getSelectedItem();
		p.B=(int) Bb.getSelectedItem();
		bottom = new PlotPanel(p);
		this.setBottomComponent(bottom);
		this.validate();
	}

	private class Parameter{
		int q;
		double a;
		double c;
		int type;
		int R;
		int G;
		int B;
	}

	private class PlotPanel extends JPanel {

		private static final long serialVersionUID = 1L;

		boolean toDraw=false;

		Parameter p=new Parameter();

		public PlotPanel(Parameter p) {
			this.p=p;
			toDraw=!toDraw;
		}

		@Override
		public void paint(Graphics g) {
			super.paint(g);

		if(toDraw) {
			this.setSize(600, 600);
			Color color;
			int q=p.q;
			double a=p.a, c=p.c;
			int type=p.type;
			for(int x=-300;x<300;x++)
			   for(int y=-300;y<300;y++){
			       double sum=0;
				   for(int j=1;j<=q;j++){
					   double u=0,v=0;
					   switch(type) {
					     case 1:
					    	 u=x*Math.cos(2*Math.PI*j/q);
						     v=y*Math.sin(2*Math.PI*j/q);
						     break;
					     case 2:
					    	 //斑图扩展形式1
					         u=x*Math.tan(2*Math.PI*j/q);
					         v=y*Math.sin(2*Math.PI*j/q);
					         break;
					     case 3:
					    	 //斑图扩展形式2
							  double x1=x;
							  double y1=Math.sin(y);
							  u=x1*Math.cos(2*Math.PI*j/q);
							  v=y1*Math.sin(2*Math.PI*j/q);
							  break;
					     case 4:
					          double x2=0.5*x;
					          double y2=y+Math.sin(x2);
						      u=x2*Math.cos(2*Math.PI*j/q);
						      v=y2*Math.sin(2*Math.PI*j/q);
						      break;
					   }

					  double temp=Math.cos(u+v);
					  sum+=temp;
				   }

				   sum+=a*Math.cos(x*y);
				   sum+=c*(x+y);

				   int R=p.R,G=p.G,B=p.B;
				   int red=(int)Math.abs((sum*10+R)%255);
				   int green=(int)Math.abs((sum*50+G)%255);
				   int blue=(int)Math.abs((sum*20+B)%255);
				   color=new Color(red,green,blue);
			       g.setColor(color);
				   g.fillOval(300+x,y+300, 2, 3);
			}
		}
		}
	}
}

