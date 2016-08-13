
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class FileList {
   
   public static void main( String[] args ) {
      System.out.println( "\n-------------------- Begin --------------------\n" );

      long startTime = System.currentTimeMillis();

      String filename = null;

      if( args.length != 1 ) {
      // default to current directory
         filename = ".";
      } else {
         filename = args[0];
      }

      File home = new File( filename );
      System.out.println( "absolute path:" + home.getAbsolutePath() );
      System.out.println( "isFile? " + home.isFile() );
      System.out.println( "isDirectory? " + home.isDirectory() );

      System.out.println("*************  list contents  ***************\n" );

      File[] contents = home.listFiles();

      for( File f : contents ) {
         if( f.isFile() ) {
            System.out.println( "path:" + f.getAbsolutePath() );
            BufferedImage bi = convert( f );
            if( bi == null ) {
               System.out.println( "*** Conversion unsuccessful.  " + f + " might not be an image file.\n"  );
            } else {
               try {
                  String fileName = f.getName().substring( 0, f.getName().lastIndexOf(".") );
                  String extension =  f.getName().substring( f.getName().lastIndexOf(".") );
                  String outputFile = f.getParentFile() + File.separator + "output" + File.separator;
                  //System.out.println( "outputFile:" + outputFile );
                  // Create File object to make directories
                  File out = new File( outputFile );
                  out.mkdirs();

                  // Recreate File object with fully qualified file name and write output
                  outputFile = outputFile + fileName + "Inverted" + extension;
                  //System.out.println( "final write outputFile:" + outputFile );
                  out = new File( outputFile );
                  ImageIO.write( bi, "jpg", out );

               } catch( Exception e ) {
                  System.out.println( "Error while trying to write output for " + f );
                  e.printStackTrace();
               }
            }

         }
      }
      long endTime = System.currentTimeMillis();
      System.out.println("Directory converted in " + (endTime - startTime) + " milliseconds.");
   }

   private static BufferedImage convert( File file ) {
      //read image
      MBBufferedImage img = null;
      try {
         img = new MBBufferedImage( ImageIO.read( file ));
         return img.getNegativeImg();
      } catch( Exception e ) {
         System.out.println( e );
         return null;
      } 
   }



}
