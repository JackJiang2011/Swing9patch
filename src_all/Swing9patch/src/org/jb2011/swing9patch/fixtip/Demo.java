/*
 * Copyright (C) 2015 Jack Jiang(cngeeker.com) The Swing9patch Project. 
 * All rights reserved.
 * Project URL:https://github.com/JackJiang2011/Swing9patch
 * Version 1.0
 * 
 * Jack Jiang PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * Demo.java at 2015-2-6 16:10:05, original version by Jack Jiang.
 * You can contact author with jb2011@163.com.
 */
package org.jb2011.swing9patch.fixtip;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;
import org.jb2011.swing9patch.utils.CommonUtils;
import org.jb2011.swing9patch.utils.NPComponentUtils;
import org.jb2011.swing9patch.utils.NPHelper;

public class Demo extends JPanel
{
	private JTextArea txtMsg = new JTextArea(5,5);
	private JTextField txtDeltaX = new JTextField();
	private JTextField txtDeltaY = new JTextField();
	
	private JButton btnShow = new JButton("Show fix tip!")
		, btnHide = new JButton("Hide it");
	
	private FixtipPane fixtipPane = new FixtipPane();
	private FloatableDialog fixtipDialog = null;
	
	public Demo()
	{
		super(new BorderLayout());
		
		initGUI();
		initListeners();
	}
	
	private void initGUI()
	{
		// init sub coms
		txtMsg.setText(
				"<html>\n" +
					"<body>\n" +
						"This message just used for demo, <b>enjoy it</b>!\n" +
						"<br>\n" +
						"Have a good day.\n" +
					"</body>\n" +
				"</html>\n");
		txtDeltaX.setText("-15");
		txtDeltaY.setText("10");
		txtDeltaX.setColumns(10);
		txtDeltaY.setColumns(10);
		btnShow.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.red));
		btnShow.setForeground(Color.white);
		// init btn pane
		JPanel btnPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnPane.add(new JLabel("delta x:"));
		btnPane.add(txtDeltaX);
		btnPane.add(new JLabel("  delta y:"));
		btnPane.add(txtDeltaY);
		btnPane.add(btnShow);
		btnPane.add(btnHide);
		
		// init main ui
		this.add(btnPane, BorderLayout.SOUTH);
		this.add(new JScrollPane(txtMsg), BorderLayout.CENTER);
		this.add(new JLabel("单击Fixtip组件即可退出显示哦."), BorderLayout.NORTH);
		this.setBorder(BorderFactory.createEmptyBorder(80,20,20,20));
	}
	
	private void initListeners()
	{
		btnShow.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e)
			{
				fixtipPane.setTiptext(txtMsg.getText());
				if(fixtipDialog == null)
				{
					fixtipDialog = FloatableDialog.createDialog(fixtipPane
							, SwingUtilities.getWindowAncestor(Demo.this)
							, txtMsg);
					fixtipDialog.setInvisibleOnDispose(true);
				}
					
				fixtipDialog.setDeltaX(Integer.parseInt(txtDeltaX.getText().trim()));
				fixtipDialog.setDeltaY(Integer.parseInt(txtDeltaY.getText().trim()));
				fixtipDialog.display();
				
//				String ninePatchFilePath = NPIconFactory.getInstance().getFixTipBg_PATH();
//				CommonUtils.previewNinePatchWithDraw9PatchTool(
//						// getResourceAsStream can load resource from JAR
//						NPIconFactory.class.getResourceAsStream(ninePatchFilePath)
//						, CommonUtils.getFilename(ninePatchFilePath));
			}
		});
		btnHide.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e)
			{
				fixtipDialog.exit();
			}
		});
	}
}
