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

/*条纹图
* */

public class Panel7 extends JSplitPane  implements ActionListener,ItemListener{

	private static final long serialVersionUID = 1L;

	JSplitPane top;
	JPanel  bottom;

	JLabel row=new JLabel("行数:");
	JComboBox<Integer> rowV=new JComboBox<Integer>();

    JLabel col=new JLabel("列数:");
	JComboBox<Integer> colV=new JComboBox<Integer>();

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

	public Panel7() {
		super(JSplitPane.VERTICAL_SPLIT);
		top = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		top.setDividerLocation(520);
		JPanel tp=new JPanel();
		tp.setLayout(new GridLayout(2, 9));
		tp.setSize(600, 30);

		for(int i=1;i<=6;i++){
			rowV.addItem(i);
			colV.addItem(i);
		}
		for(int i=1;i<=4;i++)
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
		rowV.addItemListener(this);
		colV.addItemListener(this);
		typeV.addItemListener(this);
		backV.addItemListener(this);
		sizeb.addItemListener(this);
		Rb.addItemListener(this);
		Gb.addItemListener(this);
		Bb.addItemListener(this);

		tp.add(row);
		tp.add(col);
		tp.add(type);

		tp.add(back);
		tp.add(size);
		tp.add(R);
		tp.add(G);
		tp.add(B);

		tp.add(rowV);
		tp.add(colV);
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
		p.row=(int) rowV.getSelectedItem();
        p.col=(int) colV.getSelectedItem();
		p.type=(int) typeV.getSelectedItem();

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
        int row;
		int col;
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

	      Color color=new Color(p.R, p.G, p.B);
		  g.setColor(color);


		  int row=p.row;
		  int col=p.col;
		  int type=p.type;
		  int size=p.size;

		  Color c;
		  double K=6;
		  int m=row,n=col;
		  switch(type) {
		    case 1:
				int dx=600/m,dy=510/n;
				for(int i=0;i<m;i++)
					for(int j=0;j<n;j++) {
				         for(int x=0;x<dx;x++)
				             for(int y=0;y<dy;y++){
					             double u=Math.pow(x, i)+Math.pow(y, j);
				                 int sum=(int) (K*Math.sin(u*Math.PI/10));

				                 int red=(int)Math.abs((sum*10+p.R)%255);
				                 int green=(int)Math.abs((sum*50+p.G)%255);
				                 int blue=(int)Math.abs((sum*20+p.B)%255);
				                 c=new Color(red,green,blue);
			                     g.setColor(c);
				                 g.fillOval(dx*i+x,dy*j+y, size,size+1);
			                }
		       }
				break;

		    case 2:
				int dx1=600/m,dy1=510/n;
				for(int i=0;i<m;i++)
					for(int j=0;j<n;j++) {
				         for(int x=0;x<dx1;x++)
				             for(int y=0;y<dy1;y++){
					             double u=Math.pow(x, i)+Math.pow(y, j);
				                 int sum=(int) (K*Math.tan(u*Math.PI/10));

				                 int red=(int)Math.abs((sum*10+p.R)%255);
				                 int green=(int)Math.abs((sum*50+p.G)%255);
				                 int blue=(int)Math.abs((sum*20+p.B)%255);
				                 c=new Color(red,green,blue);
			                     g.setColor(c);
				                 g.fillOval(dx1*i+x,dy1*j+y, size,size+1);
			                }
		            }

		         break;
		    case 3:
					for(int x=0;x<600;x++)
					     for(int y=0;y<510;y++){
						    double u=Math.pow(x, m)+Math.pow(y, n);
					        int sum=(int) (K*Math.cos(u*Math.PI/10));

					        int red=(int)Math.abs((sum*10+p.R)%255);
					        int green=(int)Math.abs((sum*50+p.G)%255);
					        int blue=(int)Math.abs((sum*20+p.B)%255);
					        c=new Color(red,green,blue);
				            g.setColor(c);
					        g.fillOval(x, y, size,size+1);
				       }

		        break;
		    case 4:
				for(int x=0;x<600;x++)
				     for(int y=0;y<510;y++){
					    double u=Math.pow(x, m)+Math.pow(y, n);
				        int sum=(int) (K*Math.tan(u*Math.PI/10));

				        int red=(int)Math.abs((sum*10+p.R)%255);
				        int green=(int)Math.abs((sum*50+p.G)%255);
				        int blue=(int)Math.abs((sum*20+p.B)%255);
				        c=new Color(red,green,blue);
			            g.setColor(c);
				        g.fillOval(x, y, size,size+1);
			       }

	     break;
		  }
	   }
    }
}