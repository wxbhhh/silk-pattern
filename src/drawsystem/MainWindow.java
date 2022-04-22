package drawsystem;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.KeyStroke;

public class MainWindow extends JFrame implements ActionListener{

	boolean initia;
    //菜单条组件
	JMenuBar menubar=new JMenuBar();

	//菜单1
	JMenu menu1=new JMenu("单一(G)");
	JMenuItem item1=new JMenuItem("递归螺线");
	JMenuItem item2=new JMenuItem("玫瑰曲线");
	JMenuItem item3=new JMenuItem("菊花曲线");
	JMenuItem itemrun=new JMenuItem("追逐曲线");
	JMenuItem item4=new JMenuItem("运动曲线");
	JMenuItem item5=new JMenuItem("蝴蝶曲线");
	JMenuItem item6=new JMenuItem("斑图");

	//菜单2
	JMenu menu2=new JMenu("组合(H)");
	JMenuItem item7=new JMenuItem("条纹");
	JMenuItem item8=new JMenuItem("组合花朵");
	JMenuItem item9=new JMenuItem("组合矩形");


	//控制栏
	JSplitPane tool=new JSplitPane();



    public MainWindow(){
    	super();
    	initia=true;
    	item1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,InputEvent.CTRL_MASK));
    	item1.addActionListener(this);

    	item2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK));
    	item2.addActionListener(this);

    	item3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK));
    	item3.addActionListener(this);

    	itemrun.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK));
    	itemrun.addActionListener(this);

       	item4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,InputEvent.CTRL_MASK));
    	item4.addActionListener(this);

    	item5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,InputEvent.CTRL_MASK));
    	item5.addActionListener(this);

    	item6.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,InputEvent.CTRL_MASK));
    	item6.addActionListener(this);

    	item7.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,InputEvent.CTRL_MASK));
    	item7.addActionListener(this);

    	item8.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,InputEvent.CTRL_MASK));
    	item8.addActionListener(this);

    	item9.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,InputEvent.CTRL_MASK));
    	item9.addActionListener(this);

    	menu1.add(item1); //必须将菜单项加入到菜单里，否则不会显示出来
    	menu1.addSeparator();//会显示一条横线
    	menu1.add(item2);
    	menu1.addSeparator();
    	menu1.add(item3);
    	menu1.addSeparator();
    	menu1.add(itemrun);
    	menu1.addSeparator();
    	menu1.add(item4);
    	menu1.addSeparator();
    	menu1.add(item5);
    	menu1.addSeparator();
    	menu1.add(item6);


    	menu2.add(item7);
        menu2.addSeparator();
    	menu2.add(item8);
    	menu2.addSeparator();
    	menu2.add(item9);

	    menubar.add(menu1);
	    menubar.add(menu2);
	    setJMenuBar(menubar);

      //this.add(tool);
      this.setTitle("图案设计系统");
      this.setResizable(false);
      this.setSize(620,630);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setLocation(400,100);
      this.setVisible(true);
    }
    public static void main(String[] args){
        new MainWindow();
     }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(!initia)
           this.remove(tool);
        if(e.getSource()==item1) {
	    	tool=new Panel1();
	    }
        if(e.getSource()==item2||e.getSource()==item3) {
	    	tool=new Panel2();
	    }
        if(e.getSource()==itemrun) {
	    	tool=new Panel5();
	    }
        if(e.getSource()==item4||e.getSource()==item5) {
	    	tool=new Panel4();
	    }
	    if(e.getSource()==item6) {
	    	tool=new Panel6();
	    }
	    if(e.getSource()==item7) {
	    	tool=new Panel7();
	    }
	    if(e.getSource()==item8) {
	    	tool=new Panel8();
	    }
	    if(e.getSource()==item9) {
	    	tool=new Panel9();
	    }
	    initia=false;
	    this.add(tool);
		this.revalidate();
	}

}
