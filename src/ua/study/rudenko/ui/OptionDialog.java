package ua.study.rudenko.ui;

import java.awt.CardLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class OptionDialog extends JDialog {

	private static final long serialVersionUID = 7573766480456902357L;
	private static OptionDialog INSTANCE;
	
	private JPanel mainPanel;
	

	private OptionDialog(){
		this.setSize(200,300);
		mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(2,2));
		
		
		this.add(mainPanel);	
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setModal(true);
		this.setVisible(true);
	}

	public static OptionDialog getINSTANCE() {
		if(INSTANCE == null){
			INSTANCE = new OptionDialog();
		}
		return INSTANCE;
	}

}
