/**
 * File: Negative.java
 * Adapted from an online example as described below
 *
 * Description:
 * Convert color image to negative.
 * 
 * @author Yusuf Shakeel
 * Date: 27-01-2014 mon
 *
 * www.github.com/yusufshakeel/Java-Image-Processing-Project
 */
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Negative {

   private File sourceFile;

   public Negative( File file ) {
      this.sourceFile = new File( file.getAbsolutePath() );
   }

   
   public static void main( String[] args ) throws IOException{
      if(args.length != 1) {
         System.err.println("Usage: Negative jpgFileName");
         System.exit(1);
      }

      Negative neg = new Negative( new File( args[0] ));
      neg.reverseImage();
   }


   public void reverseImage() {
      //read image
      BufferedImage img = null;
      try {
         img = ImageIO.read( this.sourceFile );
      } catch( IOException e ) {
         System.out.println( e );
      }
     

      //get image width and height
      int width = img.getWidth();
      int height = img.getHeight();

      //convert to negative
      for( int y = 0; y < height; y++ ) {
         for( int x = 0; x < width; x++ ) {
            int p = img.getRGB( x, y );
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
            img.setRGB( x, y, p );
         }
      }

      //write image
      String fileName = this.sourceFile.getName().substring( 0, this.sourceFile.getName().lastIndexOf(".") );
      String extension =  this.sourceFile.getName().substring( this.sourceFile.getName().lastIndexOf(".") );
      String outputFile = this.sourceFile.getParentFile() + File.separator + "output" + File.separator;

      // Create File object to make directories
      File out = new File( outputFile );
      out.mkdirs();

      // Recreate File object with fully qualified file name and write output
      outputFile = outputFile + fileName + "Inverted" + extension;
      out = new File( outputFile );
      try {
         ImageIO.write( img, "jpg", out );
      } catch( IOException e ) {
         System.out.println( e );
      }
   }
}