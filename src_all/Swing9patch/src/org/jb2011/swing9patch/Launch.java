/*
 * Copyright (C) 2015 Jack Jiang(cngeeker.com) The Swing9patch Project. 
 * All rights reserved.
 * Project URL:https://github.com/JackJiang2011/Swing9patch
 * Version 1.0
 * 
 * Jack Jiang PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Launch.java at 2015-2-6 16:10:03, original version by Jack Jiang.
 * You can contact author with jb2011@163.com.
 */
package org.jb2011.swing9patch;

import javax.swing.PopupFactory;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import org.jb2011.lnf.beautyeye.utils.Platform;
import org.jb2011.swing9patch.popup.CoolPopupFactory;

public class Launch
{
	private static void initUserInterface() {
		System.setProperty("apple.laf.useScreenMenuBar", "true");
		System.setProperty(
				"com.apple.mrj.application.apple.menu.about.name",
		"Draw 9-patch");

		try {
			if(Platform.isWindows())
			{
				UIManager.put("RootPane.setupButtonVisible", false);
				BeautyEyeLNFHelper.translucencyAtFrameInactive = false;
				BeautyEyeLNFHelper.launchBeautyEyeLNF();
				
				// impl a demo PopupFactory
				PopupFactory.setSharedInstance(new CoolPopupFactory());
			}
			else
				UIManager.setLookAndFeel(UIManager
						.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(final String... args) {
		initUserInterface();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				String arg = args.length > 0 ? args[0] : null;
				MainFrame frame = new MainFrame(arg);
				frame.setDefaultCloseOperation(MainFrame.EXIT_ON_CLOSE);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
//				
//				FixtipPane fp = new FixtipPane();
//				fp.show(frame, frame.getJMenuBar(),0,10);
			}
		});
	}
}