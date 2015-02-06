/*
 * Copyright (C) 2015 Jack Jiang(cngeeker.com) The Swing9patch Project. 
 * All rights reserved.
 * Project URL:https://github.com/JackJiang2011/Swing9patch
 * Version 1.0
 * 
 * Jack Jiang PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * FixtipPane.java at 2015-2-6 16:10:04, original version by Jack Jiang.
 * You can contact author with jb2011@163.com.
 */
package org.jb2011.swing9patch.fixtip;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jb2011.ninepatch4j.NinePatch;

public class FixtipPane extends JPanel
{
	private NinePatch npBackground = null;
	private JLabel lbTip = null;
	
	public FixtipPane()
	{
		super(new BorderLayout());
		
		initGUI();
	}
	
	/**
	 * Override to impl ninepatch image background.
	 */
	@Override
	public void paintChildren(Graphics g)
	{
		if(npBackground == null)
			// load the nine patch .PNG
			npBackground = NPIconFactory.getInstance().getFixTipBg();
		if(npBackground != null)
			// paint background with ninepath
			npBackground.draw((Graphics2D)g, 0, 0, this.getWidth(), this.getHeight());
		super.paintChildren(g);
	}
	
	protected void initGUI()
	{
		this.setOpaque(false);
		
		// init gui
		this.add(lbTip = createContentLabel(), BorderLayout.CENTER);
		this.setBorder(BorderFactory.createEmptyBorder(10,20,70,10));
	}
	
	protected JLabel createContentLabel()
	{
		lbTip = new JLabel("");
		return lbTip;
	}
	
	public FixtipPane setTiptext(String tiptext)
	{
		if(lbTip != null)
			lbTip.setText(tiptext);
		return this;
	}
}
