package ua.study.rudenko.ui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public class MenuListener implements ActionListener {
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource().getClass() == JMenuItem.class) {
			JMenuItem c = (JMenuItem) ae.getSource();
			String s = c.getLabel();
			if (s.equals("Save")) {

			}

			if (s.equals("Load")) {

			}

			if (s.equals("Options")) {
				OptionDialog dialog = OptionDialog.getINSTANCE();
				dialog.setVisible(true);
			}

			if (s.equals("Exit")) {
				System.exit(0);
			}
		}
	}

}
