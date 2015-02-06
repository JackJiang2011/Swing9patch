/*
 * Copyright (C) 2015 Jack Jiang(cngeeker.com) The Swing9patch Project. 
 * All rights reserved.
 * Project URL:https://github.com/JackJiang2011/Swing9patch
 * Version 1.0
 * 
 * Jack Jiang PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * NPComponentUtils.java at 2015-2-6 16:10:04, original version by Jack Jiang.
 * You can contact author with jb2011@163.com.
 */
package org.jb2011.swing9patch.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jb2011.ninepatch4j.NinePatch;

public class NPComponentUtils
{
	/**
	 * Creates a new N9Component object.
	 *
	 * @param is the is
	 * @return the image bg panel
	 */
	public static JPanel createPanel_root(final NinePatch n9,Insets is)
	{
		JPanel p = new JPanel(){
			public void paintChildren(Graphics g)
			{
				if(n9 != null)
					n9.draw((Graphics2D)g, 0, 0, this.getWidth(), this.getHeight());
				super.paintChildren(g);
			}
		};
		if(is != null)
			p.setBorder(BorderFactory.createEmptyBorder(is.top,is.left,is.bottom,is.right));
		return p;
	}
	
	/**
	 * Creates a new N9Component object.
	 *
	 * @param text the text
	 * @param n9 the n9
	 * @param is the is
	 * @param foregroundColor the foreground color
	 * @param f the f
	 * @return the j label
	 */
	public static JLabel createLabel_root(String text
			, final NinePatch n9, Insets is
			, Color foregroundColor, Font f)
	{
		JLabel l = new JLabel(text){
			public void paintComponent(Graphics g) {
				n9.draw((Graphics2D)g, 0, 0, this.getWidth(), this.getHeight());
				super.paintComponent(g);
			}
		};
		if(is != null)
			l.setBorder(BorderFactory.createEmptyBorder(is.top, is.left, is.bottom, is.right));
		if(foregroundColor != null)
			l.setForeground(foregroundColor);
		if(f != null)
			l.setFont(f);

		return l;
	}

}
