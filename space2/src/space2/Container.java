package space2;

import javax.swing.JFrame;

import space2.Modelo.Fase;
//import space2.Modelo.Player;//

public class Container extends JFrame {

	public Container() {
		
		add(new Fase());
		setTitle("spacetest");
		setSize(800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		this.setResizable(false);
		setVisible(true);
		
	}
	
	public static void main (String []args) {
		
		new Container();

		
	}

	

}
