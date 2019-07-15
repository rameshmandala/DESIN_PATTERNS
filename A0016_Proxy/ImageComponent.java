package com.mylearning.designpatterns.A0016_Proxy;


import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.JComponent;

class ImageComponent extends JComponent {
	private Icon icon;

	public ImageComponent(Icon icon) {
		this.icon = icon;
	}

	public void setIcon(Icon icon) {
		this.icon = icon;
	}

	@Override
    public void paintComponent(Graphics g) {
		super.paintComponent(g);
		final int w = icon.getIconWidth();
		final int h = icon.getIconHeight();
		final int x = (800 - w)/2;
		final int y = (600 - h)/2;
		icon.paintIcon(this, g, x, y);
	}
}
