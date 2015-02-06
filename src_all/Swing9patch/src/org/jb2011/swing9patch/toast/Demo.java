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
package org.jb2011.swing9patch.toast;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;

public class Demo extends JPanel
{
	private JTextArea txtMsg = null;
	private JTextField txtPositionX = null;
	private JTextField txtPositionY = null;
	private JTextField txtDelay = null;
	private JButton btnShowToast = null;
	
	public Demo()
	{
		super(new BorderLayout());
		
		initGUI();
		initListeners();
	}
	
	private void initGUI()
	{
		txtMsg = new JTextArea(5,5);
		txtPositionX = new JTextField();
		txtPositionY = new JTextField();
		txtDelay = new JTextField();
		btnShowToast = new JButton("Show toast");
		
		// init sub coms
		txtMsg.setText(
				"<html>\n" +
					"<body>\n" +
						"Hello ninepatch for JavaSE, you are <b>so cool</b>!\n" +
					"</body>\n" +
				"</html>\n");
		txtPositionX.setText("-1");
		txtPositionY.setText("-1");
		txtDelay.setText("3000");
		txtPositionX.setColumns(10);
		txtPositionY.setColumns(10);
		txtDelay.setColumns(10);
		btnShowToast.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.red));
		btnShowToast.setForeground(Color.white);
		
		// init btn pane
		JPanel btnPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnPane.add(new JLabel("Position x:"));
		btnPane.add(txtPositionX);
		btnPane.add(new JLabel("Position y:"));
		btnPane.add(txtPositionY);
		btnPane.add(new JLabel("Delay(ms):"));
		btnPane.add(txtDelay);
		btnPane.add(btnShowToast);
		
		// init main ui
		this.add(btnPane, BorderLayout.SOUTH);
		this.add(new JScrollPane(txtMsg), BorderLayout.CENTER);
		this.setBorder(BorderFactory.createEmptyBorder(10,100,20,100));
	}
	
	private void initListeners()
	{
		btnShowToast.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Toast.showTost(Integer.parseInt(txtDelay.getText().trim())
						, txtMsg.getText()
						, new Point(Integer.parseInt(txtPositionX.getText().trim())
								,Integer.parseInt(txtPositionY.getText().trim())));
			}
		});
	}
}
