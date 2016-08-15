package mikebro.commandui;

/**
 * File: Negative.java
 * Adapted from an online example as described below
 *
 * Description:
 * Convert color image to negative.
 * 
 * @author mikebro, after Yusuf Shakeel
 * Date: 27-01-2014 mon
 *
 * www.github.com/yusufshakeel/Java-Image-Processing-Project
 */
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import javax.imageio.ImageIO;
import mikebro.image.services.MBBufferedImage;

public class Negative {

   public static void main( String[] args ) {
      System.out.println( new Date() );

      if(args.length != 1) {
         System.err.println("Usage: Negative jpgFileName");
         System.exit(1);
      }
     
      //read image
      MBBufferedImage img = null;
      try {
         img = new MBBufferedImage( ImageIO.read( new File( args[0] )));
      } catch( IOException e ) {
         System.out.println( e );
      } 

      BufferedImage newImage = img.getNegativeImg();


   //   //write image
   //   String fileName = this.sourceFile.getName().substring( 0, this.sourceFile.getName().lastIndexOf(".") );
   //   String extension =  this.sourceFile.getName().substring( this.sourceFile.getName().lastIndexOf(".") );
   //   String outputFile = this.sourceFile.getParentFile() + File.separator + "output" + File.separator;
   //
      // Create File object to make directories
      File out = new File( "C:\\image\\output" );
      out.mkdirs();
   
      // Recreate File object with fully qualified file name and write output
   //   outputFile = outputFile + fileName + "Inverted" + extension;
      out = new File( "C:\\image\\output\\outFile.jpg" );
      try {
         ImageIO.write( newImage, "jpg", out );
      } catch( IOException e ) {
         System.out.println( e );
      }

      System.out.println( new Date() );

   }

}








