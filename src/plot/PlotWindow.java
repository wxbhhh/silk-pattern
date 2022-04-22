package plot;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

public class PlotWindow extends JFrame implements ActionListener,ItemListener{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	JSplitPane jsp_main;
	JSplitPane top;
	JPanel  bottom;

	JLabel q=new JLabel("q:");
	JComboBox<Integer> qb=new JComboBox<Integer>();
    JTextField qV=new JTextField(5);
    JLabel a=new JLabel("a:");
	JTextField aV=new JTextField(5);
	JLabel c=new JLabel("c:");
	JTextField cV=new JTextField(5);
	JLabel size=new JLabel("size:");
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

	public static void main(String[] args) {

        PlotWindow window = new PlotWindow();

	}

	public PlotWindow() {
		this.setBounds(100, 100, 500, 330);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		top = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		top.setDividerLocation(400);
		JPanel tp=new JPanel();
		tp.setLayout(new GridLayout(2, 7));
		tp.setSize(450, 30);
		for(int i=1;i<=20;i++)
		   qb.addItem(i);
		aV.setText("0");
		cV.setText("0");
		for(int i=1;i<=10;i++)
			   sizeb.addItem(i);
		for(int i=10;i<=150;i+=10) {
			   Rb.addItem(i);
			   Gb.addItem(i);
			   Bb.addItem(i);
		}
		qb.addItemListener(this);
		sizeb.addItemListener(this);
		Rb.addItemListener(this);
		Gb.addItemListener(this);
		Bb.addItemListener(this);



		tp.add(q);
		tp.add(a);
		tp.add(c);
		tp.add(size);
		tp.add(R);
		tp.add(G);
		tp.add(B);
		tp.add(qb);
		tp.add(aV);
		tp.add(cV);
		tp.add(sizeb);
		tp.add(Rb);
		tp.add(Gb);
		tp.add(Bb);
		top.setLeftComponent(tp);
		button.addActionListener(this);
		top.setRightComponent(button);


		// 上下分割
		jsp_main = new JSplitPane(JSplitPane.VERTICAL_SPLIT);


		bottom = new PlotPanel();
		bottom.setBackground(Color.red);



		//jp_top.setBackground(Color.BLUE);



		jsp_main.setTopComponent(top);
		jsp_main.setBottomComponent(bottom);
		jsp_main.setDividerLocation(50);

		this.add(jsp_main);
		this.setSize(500, 350);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		windowChange();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getStateChange() == ItemEvent.SELECTED)
			windowChange();
		   //   System.out.println("fdfsdfsdfs");
	}

	void windowChange() {
		Parameter p=new Parameter();
		p.q=(int) qb.getSelectedItem();
		p.a=Double.parseDouble(aV.getText());
		p.c=Double.parseDouble(cV.getText());
		p.size=(int) sizeb.getSelectedItem();
		p.R=(int) Rb.getSelectedItem();
		p.G=(int) Gb.getSelectedItem();
		p.B=(int) Bb.getSelectedItem();
		bottom = new PlotPanel(p);
		this.jsp_main.setBottomComponent(bottom);
		this.validate();
	}

}
