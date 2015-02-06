/*
 * Copyright (C) 2015 Jack Jiang(cngeeker.com) The Swing9patch Project. 
 * All rights reserved.
 * Project URL:https://github.com/JackJiang2011/Swing9patch
 * Version 1.0
 * 
 * Jack Jiang PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Demo.java at 2015-2-6 16:10:04, original version by Jack Jiang.
 * You can contact author with jb2011@163.com.
 */
package org.jb2011.swing9patch.photoframe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;

import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;
import org.jb2011.swing9patch.Launch;
import org.jb2011.swing9patch.utils.DragToMove;
import org.jb2011.swing9patch.utils.NPComponentUtils;
import org.jb2011.swing9patch.utils.NPHelper;
import org.jb2011.swing9patch.widget.NinePatchBorder;

import com.sun.awt.AWTUtilities;

public class Demo extends JPanel
{
	private JDialog dialogForShowingPhoto = null;
	private JPanel panePhotoframe = null;

	private JTextField txtPhotoframeDialogWidth = null;
	private JTextField txtPhotoframeDialogHeight = null;
	private JButton btnShowInFrame = null;
	private JButton btnHideTheFrame = null;
	
	public Demo()
	{
		super(new BorderLayout());
		
		initGUI();
		initListeners();
	}
	
	private void initGUI()
	{
		// init components
		txtPhotoframeDialogWidth = new JTextField();
		txtPhotoframeDialogHeight = new JTextField();
		txtPhotoframeDialogWidth.setText("530");
		txtPhotoframeDialogHeight.setText("450");
		txtPhotoframeDialogWidth.setColumns(10);
		txtPhotoframeDialogHeight.setColumns(10);
		
		btnShowInFrame = new JButton("Show in new frame...");
		btnShowInFrame.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.blue));
		btnShowInFrame.setForeground(Color.white);
		btnHideTheFrame = new JButton("Hide the frame");
		btnHideTheFrame.setEnabled(false);
		
		panePhotoframe = createPhotoframe();
		panePhotoframe.add(
				new JLabel(new ImageIcon(org.jb2011.swing9patch.photoframe.Demo.class.getResource("imgs/girl.png")))
				, BorderLayout.CENTER);
		
		// init layout
		JPanel paneBtn = new JPanel(new FlowLayout(FlowLayout.CENTER));
		paneBtn.setBorder(BorderFactory.createEmptyBorder(12,0,0,0));
		paneBtn.add(new JLabel("Frame width:"));
		paneBtn.add(txtPhotoframeDialogWidth);
		paneBtn.add(new JLabel("Frame height:"));
		paneBtn.add(txtPhotoframeDialogHeight);
		paneBtn.add(btnShowInFrame);
		paneBtn.add(btnHideTheFrame);
		
		this.setBorder(BorderFactory.createEmptyBorder(12,20,10,20));
		this.add(panePhotoframe, BorderLayout.CENTER);
		this.add(paneBtn, BorderLayout.SOUTH);
		
		// drag panePhotoframe to move its parent window
		DragToMove.apply(new Component[]{panePhotoframe});
	}
	
	private void initListeners()
	{
		btnShowInFrame.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				showNewFrame();
			}
		});
		btnHideTheFrame.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				hideTheFrame();
			}
		});
	}
	
	/**
	 * Create and return a new photo frame pane object.
	 * Its background is NinePatch pictrue.
	 * 
	 * @return
	 */
	private JPanel createPhotoframe()
	{
//		JPanel pf = new JPanel();// TODO !!!!!!!!!!!!!!!!!!!!!!!!!!!
		JPanel pf = NPComponentUtils
			.createPanel_root(NPIconFactory.getInstance().getPhotoframeBg(), new Insets(13,15,15,15));
		pf.setLayout(new BorderLayout());
		pf.setOpaque(false);
		
//		pf.setBorder(new AABorder());
		return pf;
	}
	
	public void showNewFrame()
	{
		if(dialogForShowingPhoto == null)
		{
			dialogForShowingPhoto = new JDialog(
					// bug of JDK1.7: can't repaint!
//					SwingUtilities.getWindowAncestor(org.jb2011.ninepatch4j.demos.photoframe.Demo.this)
					);
			// set dialog full transparent
			dialogForShowingPhoto.setUndecorated(true);
			AWTUtilities.setWindowOpaque(dialogForShowingPhoto, false);
			// contentPane default is opaque in Java1.7+
			((JComponent)(dialogForShowingPhoto.getContentPane())).setOpaque(false);
			dialogForShowingPhoto.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
			dialogForShowingPhoto.setLocation(100,100);
//			dialogForShowingPhoto.setLocationRelativeTo(null);
			dialogForShowingPhoto.setAlwaysOnTop(true);//
		}
		
		dialogForShowingPhoto.setSize(Integer.parseInt(txtPhotoframeDialogWidth.getText().trim())
				, Integer.parseInt(txtPhotoframeDialogHeight.getText().trim()));
//		this.remove(panePhotoframe);
		dialogForShowingPhoto.add(panePhotoframe);
		
		dialogForShowingPhoto.setVisible(true);
		btnHideTheFrame.setEnabled(true);
		btnShowInFrame.setEnabled(false);
	}
	
	public void hideTheFrame()
	{
		dialogForShowingPhoto.setVisible(false);
		btnHideTheFrame.setEnabled(false);
		btnShowInFrame.setEnabled(true);
		
//		dialogForShowingPhoto.remove(panePhotoframe);
		// add to Demo main pane again
		this.add(panePhotoframe, BorderLayout.CENTER);
	}
	
	class AABorder extends NinePatchBorder//AbstractBorder
	{
		
		/** The Constant BOTTOM. */
		private final static int TOP = 17,LEFT = 27,RIGHT = 27,BOTTOM = 37;
		
		/**
		 * Instantiates a new bE shadow border3.
		 */
		public AABorder()
		{
			super(new Insets(TOP, LEFT, BOTTOM, RIGHT)
				, NPHelper.createNinePatch(
						Launch.class.getResource("imgs/np/225.9.png"), false)); 
		}
	}
}
