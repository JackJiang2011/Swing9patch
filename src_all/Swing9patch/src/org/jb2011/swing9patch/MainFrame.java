/*
 * Copyright (C) 2015 Jack Jiang(cngeeker.com) The Swing9patch Project. 
 * All rights reserved.
 * Project URL:https://github.com/JackJiang2011/Swing9patch
 * Version 1.0
 * 
 * Jack Jiang PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * MainFrame.java at 2015-2-6 16:10:04, original version by Jack Jiang.
 * You can contact author with jb2011@163.com.
 */
package org.jb2011.swing9patch;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class MainFrame extends JFrame
{
	private JPanel mainPane = new JPanel(new BorderLayout());
	
	public MainFrame(String path) throws HeadlessException 
	{
		super ("Swing9patch Project - 欢迎加入Swing交流群：259448663");

		initGUI();
		
		setSize(900, 680);
	}
	
	private void initGUI()
	{
		this.mainPane.add(createMainTabs(), BorderLayout.CENTER);
		
		this.getContentPane().add(mainPane);
		this.setJMenuBar(createMenuBar());
	}
	
	private JComponent createMainTabs()
	{
		JTabbedPane tbs = new JTabbedPane();
		
		tbs.add(new org.jb2011.swing9patch.popup.Demo(), "Cool tooltip");
		tbs.add(new org.jb2011.swing9patch.fixtip.Demo(), "Cool fix tip");
		tbs.add(new org.jb2011.swing9patch.photoframe.Demo(), "Photo frame");
//		tbs.add(new JPanel(), "Cool border demo");
//		tbs.add(new JPanel(), "仿手机短信内容查看");
//		tbs.add(new JPanel(), "Cool 名片");
		tbs.add(new org.jb2011.swing9patch.toast.Demo(), "Toast");
		
		tbs.setToolTipTextAt(0, "Cool tooltip");
		tbs.setToolTipTextAt(1, "Cool fix tip");
		tbs.setToolTipTextAt(2, "Photo frame");
//		tbs.setToolTipTextAt(3, "Cool border demo");
//		tbs.setToolTipTextAt(4, "仿手机短信内容查看");
//		tbs.setToolTipTextAt(5, "Cool 名片");
		tbs.setToolTipTextAt(3, "Toast");
		
		return tbs;
	}
	
	private JMenuBar createMenuBar() 
	{
		//------------------------------------ MenuDemo1
//		JMenu fileMenu = new JMenu("MenuDemo1");
//		JMenuItem openMenuItem = new JMenuItem("Menu item 1");
//		JMenuItem saveMenuItem = new JMenuItem("Menu item 2");
//		JMenuItem exitMenuItem = new JMenuItem("Menu item 3");
//		fileMenu.add(openMenuItem);
//		saveMenuItem.setEnabled(false);
//		fileMenu.add(saveMenuItem);
//		fileMenu.addSeparator();
//		fileMenu.add(exitMenuItem);
		
		//------------------------------------ MenuDemo2
//		JMenu fileMenu2 = new JMenu("MenuDemo2");
//		fileMenu2.add(new JMenuItem("Menu item 1"));
//		fileMenu2.add(new JMenuItem("Menu item 2"));
//		fileMenu2.addSeparator();
//		fileMenu2.add(new JMenuItem("Menu item 3"));
//		fileMenu2.add(new JMenuItem("Menu item 4"));
//		fileMenu2.addSeparator();
//		fileMenu2.add(new JMenuItem("Menu item 5"));
//		fileMenu2.add(new JMenuItem("Menu item 6"));
//		fileMenu2.add(new JMenuItem("Menu item 7"));
//		fileMenu2.add(new JMenuItem("Menu item 8"));
		
		//------------------------------------ About
		JMenu aboutMenu = new JMenu("关于");
		JMenuItem aboutMenuItem = new JMenuItem("关于本工程");
		aboutMenuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				JOptionPane.showMessageDialog(rootPane, "Swing9patch" +
						"\n - 本工程是一组利用BeautyEye工程相同基础技术实现的Swing组件或UI效果." +
						"\n - 工程内的UI组件或效果都可方便地抽取出来用于您的项目." +
						"\n - 本工程是BeautyEye的衍生工程，开发于2012年底，作是Jack Jiang(jb2011@163.com)." +
						"\n");
			}
		});
		aboutMenu.add(aboutMenuItem);
		
		JMenuBar menuBar = new JMenuBar();
//		menuBar.add(fileMenu);
//		menuBar.add(fileMenu2);
		menuBar.add(aboutMenu);
		
		return menuBar;
	}
	

}
