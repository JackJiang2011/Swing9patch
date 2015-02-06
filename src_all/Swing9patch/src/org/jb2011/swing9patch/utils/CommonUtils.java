/*
 * Copyright (C) 2015 Jack Jiang(cngeeker.com) The Swing9patch Project. 
 * All rights reserved.
 * Project URL:https://github.com/JackJiang2011/Swing9patch
 * Version 1.0
 * 
 * Jack Jiang PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * 
 * CommonUtils.java at 2015-2-6 16:10:04, original version by Jack Jiang.
 * You can contact author with jb2011@163.com.
 */
package org.jb2011.swing9patch.utils;

import java.io.File;
import java.io.InputStream;

import javax.swing.filechooser.FileSystemView;

import org.jb2011.draw9patch4j.ui.MainFrame;

public class CommonUtils
{
	private static final String FOLDER_SEPARATOR = "/";
	
	/**
	 * Extract the filename from the given path,
	 * e.g. "mypath/myfile.txt" -> "myfile.txt".
	 * @param path the file path (may be <code>null</code>)
	 * @return the extracted filename, or <code>null</code> if none
	 */
	public static String getFilename(String path) {
		if (path == null) {
			return null;
		}
		int separatorIndex = path.lastIndexOf(FOLDER_SEPARATOR);
		return (separatorIndex != -1 ? path.substring(separatorIndex + 1) : path);
	}
	
	/**
	 * Preview a NinePatcg pictrure with Draw9Patch4Coffee tool.
	 * 
	 * @param is must not null
	 * @param fileName must not null, just used for file name, suffix must be ".9.png"
	 */
	public static void previewNinePatchWithDraw9PatchTool(InputStream is, String fileName)
	{
		MainFrame frame = new MainFrame(is, 
				// this file path just used for Draw9Patch4Coffee, 
				// and dosn't really read data from it, see Draw9Patch4Coffee API doc
				FileSystemView.getFileSystemView().getDefaultDirectory()
						.getAbsolutePath()+File.separator+fileName);
		frame.setDefaultCloseOperation(MainFrame.DISPOSE_ON_CLOSE);
		frame.setSize(700,500);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
