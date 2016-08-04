/**
 * Adapted from an online example Negative.java as described below
 *
 * @author mikebro, after Yusuf Shakeel
 * Date: 27-01-2014 mon
 * www.github.com/yusufshakeel/Java-Image-Processing-Project
 */
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.util.concurrent.RecursiveAction;

public class MBBufferedImage {

   private BufferedImage img;

   public MBBufferedImage( BufferedImage img ) {
      this.img = img;
   }

   public BufferedImage getNegativeImg() {

      // create new copy of this image
      BufferedImage copy = this.duplicate();

      //get image width and height
      int width = copy.getWidth();
      int height = copy.getHeight();

      // capture image data as array to get ready for ForkJoin process
      int[] src = copy.getRGB(0, 0, width, height, null, 0, width);
      System.out.println("Array size is " + src.length);
      int[] dest = new int[ src.length ];

      ForkNegative fn = new ForkNegative( src, (int) 0, src.length, dest );
      System.out.println( fn.toString() );

      //convert to negative
      for( int y = 0; y < height; y++ ) {
         for( int x = 0; x < width; x++ ) {
            int p = copy.getRGB( x, y );
            int a = ( p >> 24 ) & 0xff;
            int r = ( p >> 16 ) & 0xff;
            int g = ( p >> 8 ) & 0xff;
            int b = p & 0xff;
   
            //subtract RGB from 255
            r = 255 - r;
            g = 255 - g;
            b = 255 - b;
            //set new RGB value
            p = ( a << 24 ) | ( r << 16 ) | ( g << 8 ) | b;
            copy.setRGB( x, y, p );
         }
      }
   
      return copy;
   }


   // adapted from a post at:
   // http://stackoverflow.com/questions/3514158/how-do-you-clone-a-bufferedimage
   public BufferedImage duplicate() {
      ColorModel cm = this.img.getColorModel();
      boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
      WritableRaster raster = this.img.copyData( this.img.getRaster().createCompatibleWritableRaster() );
      return new BufferedImage( cm, raster, isAlphaPremultiplied, null );
   }

   private class ForkNegative extends RecursiveAction {

      private int[] mSource;
      private int mStart;
      private int mLength;
      private int[] mDestination;
     
      public ForkNegative(int[] src, int start, int length, int[] dst) {
         this.mSource = src;
         this.mStart = start;
         this.mLength = length;
         this.mDestination = dst;
      }

      protected void compute() {
      }

      public String toString() {
         return "ForkNegative[" + mLength + "]";
      }
   }

}








