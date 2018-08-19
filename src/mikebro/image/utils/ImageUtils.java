/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mikebro.image.utils;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

/**
 *
 * @author mikebro
 */
public class ImageUtils {


	/**
	 * Returns a new BufferedImage of this image, scaled to the specified height and width.
	 * The image in this object instance is the source and remains unchanged.
	 * <p>
	 * adapted from a post at:
	 * https://stackoverflow.com/questions/12660122/image-resizing-and-displaying-in-a-jpanel-or-a-jlabel-without-loss-of-quality/12660146#12660146
	 *
	 * <p>
	 * problem with this implementation is that it can only return a scaled version of the
	 * instance image.  The negative image is not part of this instance but is a separate
	 * BufferedImage.  This method probably works better as a stand-alone utility method
	 *
	 * @param newWidth
	 * @param newHeight
	 * @return new scaled BufferedImage
	 */
	public static BufferedImage scaleImage( Image img, int newWidth, int newHeight ) {
		 BufferedImage bi;
		 try {
			  bi = new BufferedImage( newWidth, newHeight, BufferedImage.TYPE_INT_RGB );
			  Graphics2D g2d = (Graphics2D) bi.createGraphics();
			  g2d.addRenderingHints( new RenderingHints( RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY ));
			  g2d.drawImage( img, 0, 0, newWidth, newHeight, null );
		 } catch (Exception e) {
			  e.printStackTrace();
			  return null;
		 }
		 return bi;
	}

}
