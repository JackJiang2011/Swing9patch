package org.jb2011.swing9patch;
//package org.jb2011.ninepatch4j.demos;
//
//import org.jb2011.ninepatch4j.NinePatch;
//import org.jb2011.ninepatch4j.demos.utils.NPHelper;
//import org.jb2011.ninepatch4j.demos.utils.RawCacheRoot;
//
///**
// * Object factory of NinePatch pictures(*.9.png).
// * 
// * @author Jack Jiang
// * @version 1.0
// */
//public class NPIconFactory extends RawCacheRoot<NinePatch>
//{
//	/** root path(relative this NPIconFactory.class). */
//	public final static String IMGS_ROOT="imgs/np";
//
//	/** The instance. */
//	private static NPIconFactory instance = null;
//
//	/**
//	 * Gets the single instance of __Icon9Factory__.
//	 *
//	 * @return single instance of __Icon9Factory__
//	 */
//	public static NPIconFactory getInstance()
//	{
//		if(instance==null)
//			instance = new NPIconFactory();
//		return instance;
//	}
//	
//	/* (non-Javadoc)
//	 * @see org.jb2011.lnf.beautyeye.utils.RawCache#getResource(java.lang.String, java.lang.Class)
//	 */
//	@Override
//	protected NinePatch getResource(String relativePath, Class baseClass)
//	{
//		return NPHelper.createNinePatch(baseClass.getResource(relativePath), false);
//	}
//
//	/**
//	 * Gets the raw.
//	 *
//	 * @param relativePath the relative path
//	 * @return the raw
//	 */
//	public NinePatch getRaw(String relativePath)
//	{
//		return  getRaw(relativePath,this.getClass());
//	}
//
//	
//	/**
//	 * Gets the popup bg.
//	 *
//	 * @return the popup bg
//	 */
//	public NinePatch getPopupBg()
//	{
//		return getRaw(IMGS_ROOT+"/shadow_bg_popup.9.png");
//	}
//	
//	/**
//	 * Gets the tooltip bg.
//	 *
//	 * @return the tooltip bg
//	 */
//	public NinePatch getTooltipBg()
//	{
//		return getRaw(IMGS_ROOT+"/shadow_bg_tooltip2.9.png");
//	}
//	
//	/**
//	 * Gets the scroll pane border bg.
//	 *
//	 * @return the scroll pane border bg
//	 */
//	public NinePatch getScrollPaneBorderBg()
//	{
//		return getRaw(IMGS_ROOT+"/scroll_pane_bg1.9.png");
//	}
//}