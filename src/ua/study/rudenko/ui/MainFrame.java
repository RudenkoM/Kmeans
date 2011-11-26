package ua.study.rudenko.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class MainFrame extends JFrame {

	private JPanel mainPanel;

	public MainFrame() {
		this.setSize(700, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// add Menu Item to Frame
		initMenuItem();
		// set main Panel
		createMainPanel();

	}

	private void initMenuItem() {
		String[] menuItemName = { "Save", "Load", "Options", "Exit" };

		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");

		for (int i = 0; i < menuItemName.length; i++) {
			JMenuItem m = new JMenuItem(menuItemName[i]);
			m.addActionListener(new MenuListener());
			if (menuItemName[i].equals("Exit")) {
				fileMenu.addSeparator();
			}
			fileMenu.add(m);
		}

		menuBar.add(fileMenu);
		this.setJMenuBar(menuBar);
	}

	private void createMainPanel() {
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		JTabbedPane panel = new JTabbedPane();
		String[] tabNames = { "Graphic", "Tables", "Quality" };

		for (String tabName : tabNames) {			
			panel.addTab(tabName, new JPanel());
		}

		mainPanel.add(panel);
		this.add(mainPanel);
	}

	public static void main(String[] args) {
		new MainFrame();
	}
}
