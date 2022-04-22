package draw;

import java.awt.Color;

import javax.swing.*;

import panel.Panel3;


public class DrawWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	public DrawWindow() {
		super();
	}
	public DrawWindow(JPanel panel) {
		super();
		initialize(panel);
	}
	private void initialize(JPanel panel) {

		this.setSize(800, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.setBackground(Color.WHITE);
		setContentPane(panel);

		this.setTitle("绘图实例");
        this.setResizable(false);
		this.setVisible(true);
	}
 }