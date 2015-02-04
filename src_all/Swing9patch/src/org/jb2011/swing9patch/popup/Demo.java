package org.jb2011.swing9patch.popup;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;
import org.jb2011.swing9patch.Launch;
import org.jb2011.swing9patch.fixtip.FixtipPane;
import org.jb2011.swing9patch.fixtip.FloatableDialog;
import org.jb2011.swing9patch.utils.NPComponentUtils;
import org.jb2011.swing9patch.utils.NPHelper;

public class Demo extends JPanel
{
	private JButton btnShow = new JButton("Rover here to show toolTipText!");
	
	public Demo()
	{
		super(new BorderLayout());
		
		initGUI();
		initListeners();
	}
	
	private void initGUI()
	{
		// init sub coms
		btnShow.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.red));
		btnShow.setForeground(Color.white);
		btnShow.setToolTipText(
				"<html>\n" +
					"<body>\n" +
						"This message just used for demo, cool tool tip!\n" +
						"<br>\n" +
						"Ni hao Jack Jiang.\n" +
					"</body>\n" +
				"</html>\n");
		
		// init btn pane
		JPanel btnPane = NPComponentUtils.createPanel_root(
				NPHelper.createNinePatch(Launch.class.getResource("imgs/np/cool_tool_tip_demo_bg.9.png"), false)
				, new Insets(150,50,50,50));
		btnPane.setLayout(new FlowLayout(FlowLayout.CENTER));
		btnPane.add(btnShow);
		
		// init main ui
		this.add(btnPane, BorderLayout.CENTER);
		this.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
	}
	
	private void initListeners()
	{
//		btnShow.addActionListener(new ActionListener(){
//			@Override
//			public void actionPerformed(ActionEvent e)
//			{
//				FloatableDialog fixtipDialog = FloatableDialog.createDialog(
//							new FixtipPane().setTiptext("Hay, rover here!")
//							, SwingUtilities.getWindowAncestor(Demo.this)
//							, btnShow);
//				fixtipDialog.display();
//			}
//		});
	}

}
