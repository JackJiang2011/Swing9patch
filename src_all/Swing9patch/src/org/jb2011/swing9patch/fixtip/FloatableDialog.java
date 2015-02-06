/*
 * Copyright (C) 2015 Jack Jiang(cngeeker.com) The Swing9patch Project. 
 * All rights reserved.
 * Project URL:https://github.com/JackJiang2011/Swing9patch
 * Version 1.0
 * 
 * Jack Jiang PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * FloatableDialog.java at 2015-2-6 16:10:04, original version by Jack Jiang.
 * You can contact author with jb2011@163.com.
 */
package org.jb2011.swing9patch.fixtip;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Point;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import com.sun.awt.AWTUtilities;

/**
 * A floatable dialog, who can auto relocation to parent.
 * 
 * @author Jack Jiang(jb2011@163.com), 2012-11-03
 * @version 1.0
 */
public class FloatableDialog extends JDialog implements ActionListener
{
	/** The parent component, this dialog will relative to it */
	private JComponent parentCom = null;
	/** The content component of this dialog */
	private JComponent contentCom = null;
	
	/** Delta x to show this dialog(value it's vector) */
	private int deltaX = 0;
	/** Delta y to show this dialog(value it's vector) */
	private int deltaY = 0;
	/** false means dispose dialog on close, else just setVisible(false) */
	private boolean invisibleOnDispose = false;
	
	/** Timing to dispose */
	private Timer timer = null;

	/**
	 * Default constructor.
	 * 
	 * @param parent The parent window instance of this dialog, it should be not null
	 */
	public FloatableDialog(Window parent)
	{
		super(parent, Dialog.ModalityType.MODELESS);
		
		initGUI();
		initListeners(parent);
		
		timer = new Timer(3000, this);// dispose in 3 second
	}
	
	protected void initGUI()
	{
		// set dialog full transparent
		setUndecorated(true);
		AWTUtilities.setWindowOpaque(this, false);
		this.getRootPane().setWindowDecorationStyle(JRootPane.NONE);

		// init gui
		JPanel contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setOpaque(false);
		setContentPane(contentPane);
				
		// others setup
		this.setFocusable(false);
		this.setFocusableWindowState(false);
//		this.setAlwaysOnTop(true);
		this.setVisible(false);
	}

	protected void initListeners(Window parent)
	{
		// add listeners
		addMouseListener(new MouseAdapter(){
			@Override
			public void mouseReleased(MouseEvent e)
			{
				exit();
			}
		});
		parent.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosed(WindowEvent e)
			{
				exit();
			}
		});
		parent.addComponentListener(new ComponentAdapter()
		{
			@Override public void componentMoved(ComponentEvent e){
				FloatableDialog.this.refreshLocation();
			}
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		exit();
		timer.stop();
	}

	/**
	 * Show this dialog.
	 * 
	 * <p>
	 * This method invoke {@link #refreshLocation()} first, and then 
	 * set this.setVisible(true).
	 * 
	 * @see #refreshLocation()
	 */
	public void display()
	{
		if(refreshLocation())
			this.setVisible(true);
		timer.start();
	}
	
	/**
	 * Exit this dialog.
	 * 
	 * <p>
	 * If invisibleOnDispose == true then this.setVisible(false),
	 * else this.dispose().
	 * 
	 * @see #isInvisibleOnDispose()
	 */
	public void exit()
	{
		if(invisibleOnDispose)
			this.setVisible(false);
		else
			this.dispose();
	}

	/**
	 * Reset location of this dialog and sync to its parent.
	 * 
	 * @return true means refresh sucess, else failed
	 * @exception IllegalArgumentException means parentCom or contentCom is null
	 */
	public boolean refreshLocation()
	{
		if(parentCom != null && contentCom != null)
		{
			Point location = SwingUtilities.convertPoint(parentCom, getLocation(), this);
			setBounds(location.x + deltaX, (location.y + deltaY) - getPreferredSize().height,
					getPreferredSize().width, getPreferredSize().height);
			validate();
			return true;
		}
		else
			throw new IllegalArgumentException("parentCom or contentCom is null!");
	}
	
	public void setContentCom(JComponent contentCom)
	{
		this.contentCom = contentCom;
		this.getContentPane().removeAll();
		this.getContentPane().add(this.contentCom, BorderLayout.CENTER);
	}
	
	public JComponent getParentCom()
	{
		return parentCom;
	}
	public void setParentCom(JComponent parentCom)
	{
		this.parentCom = parentCom;
	}

	public int getDeltaX()
	{
		return deltaX;
	}
	public void setDeltaX(int deltaX)
	{
		this.deltaX = deltaX;
	}

	public int getDeltaY()
	{
		return deltaY;
	}
	public void setDeltaY(int deltaY)
	{
		this.deltaY = deltaY;
	}
	
	public boolean isInvisibleOnDispose()
	{
		return invisibleOnDispose;
	}
	public void setInvisibleOnDispose(boolean invisibleOnDispose)
	{
		this.invisibleOnDispose = invisibleOnDispose;
	}

	/**
	 * A convenient method to create a new FloatableDialog instance.
	 * 
	 * @param contentCom The content component of this dialog
	 * @param parentWindow The parent window instance of this dialog, it should be not null
	 * @param parentCom The parent component, this dialog will relative to it
	 * @return A new FloatableDialog object
	 */
	public static FloatableDialog createDialog(JComponent contentCom
			, Window parentWindow, JComponent parentCom)
	{
		final FloatableDialog d = new FloatableDialog(parentWindow);
		d.setContentCom(contentCom);
		d.setParentCom(parentCom);
		return d;
	}
}