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
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class MBBufferedImage {

   private BufferedImage img;

   public MBBufferedImage( BufferedImage img ) {
      this.img = img;
   }

   public BufferedImage getNegativeImg() {

      //get image width and height
      int width = this.img.getWidth();
      int height = this.img.getHeight();

      // capture image data as array to get ready for ForkJoin process
      int[] src = this.img.getRGB(0, 0, width, height, null, 0, width);
      System.out.println("   Array size is " + src.length);
      int[] dest = new int[ src.length ];

      ForkNegative fn = new ForkNegative( src, 0, src.length, dest );
      // System.out.println( fn.toString() );
      ForkJoinPool pool = new ForkJoinPool();
      pool.invoke( fn );

      // //convert to negative
      // for( int y = 0; y < height; y++ ) {
      //    for( int x = 0; x < width; x++ ) {
      //       int p = copy.getRGB( x, y );
      //       int a = ( p >> 24 ) & 0xff;
      //       int r = ( p >> 16 ) & 0xff;
      //       int g = ( p >> 8 ) & 0xff;
      //       int b = p & 0xff;
      //
      //       //subtract RGB from 255
      //       r = 255 - r;
      //       g = 255 - g;
      //       b = 255 - b;
      //       //set new RGB value
      //       p = ( a << 24 ) | ( r << 16 ) | ( g << 8 ) | b;
      //       copy.setRGB( x, y, p );
      //    }
      // }

      // create new BufferedImage from the destination pixel array
      BufferedImage negative = new BufferedImage( width, height, this.img.getType() );
      negative.setRGB( 0, 0, width, height, dest, 0, width );
      return negative;
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
      protected final int sThreshold = 50000;

      public ForkNegative(int[] src, int start, int length, int[] dst) {
         this.mSource = src;
         this.mStart = start;
         this.mLength = length;
         this.mDestination = dst;
      }

      protected void compute() {
         if (mLength < sThreshold) {
            computeDirectly();
            return;
         }

         int split = mLength / 2;
         // System.out.print("Splitting job...");
         invokeAll(new ForkNegative(mSource, mStart, split, mDestination),
                 new ForkNegative(mSource, mStart + split, mLength - split, mDestination));
      }

      protected void computeDirectly() {
         for( int i = mStart; i < mStart + mLength; i++ ) {
            int p = mSource[ i ];
            // int a = ( p >> 24 ) & 0xff;  no alpha in this pixel?
            int r = ( p & 0x00ff0000 ) >> 16;
            int g = ( p & 0x0000ff00 ) >>  8;
            int b = ( p & 0x000000ff ) >>  0;

            //subtract RGB from 255
            r = 255 - r;
            g = 255 - g;
            b = 255 - b;
            //set new RGB value
            p = ( 0xff000000 ) | ( r << 16 ) | ( g << 8 ) | b;
            mDestination[ i ] = p;
         }
      }

      public String toString() {
         return "ForkNegative[" + mLength + "]";
      }
   }

}








