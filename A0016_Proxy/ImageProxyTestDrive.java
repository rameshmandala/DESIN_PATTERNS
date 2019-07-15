package com.mylearning.designpatterns.A0016_Proxy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class ImageProxyTestDrive {
	ImageComponent imageComponent;
	JFrame frame = new JFrame("CD Cover Viewer");
    JMenuBar menuBar;
    JMenu menu;
	Hashtable cds = new Hashtable();

	public static void main (String[] args) throws Exception {
		final ImageProxyTestDrive testDrive = new ImageProxyTestDrive();
	}

	public ImageProxyTestDrive() throws Exception{
        cds.put("Window 1","http://localhost/Photos/Room1Window.jpg");
        cds.put("Window 2","http://localhost/Photos/Room2Window1.jpg");
        cds.put("Window 3","http://localhost/Photos/Room2Window2.jpg");
        cds.put("Doors","http://localhost/Photos/Room1and2Doors.jpg");

		final URL initialURL = new URL((String)cds.get("Doors"));
		menuBar = new JMenuBar();
		menu = new JMenu("Favorite CDs");
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);

		for(final Enumeration e = cds.keys(); e.hasMoreElements();) {
			final String name = (String)e.nextElement();
        	final JMenuItem menuItem = new JMenuItem(name);
        	menu.add(menuItem);
        	menuItem.addActionListener(new ActionListener() {
          		  public void actionPerformed(ActionEvent event) {
           		     imageComponent.setIcon(new ImageProxy(getCDUrl(event.getActionCommand())));
					frame.repaint();
           	      }
        	});
		}

		// set up frame and menus

		final Icon icon = new ImageProxy(initialURL);
		imageComponent = new ImageComponent(icon);
		frame.getContentPane().add(imageComponent);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,600);
		frame.setVisible(true);

	}

	URL getCDUrl(String name) {
		try {
			return new URL((String)cds.get(name));
		} catch (final MalformedURLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
