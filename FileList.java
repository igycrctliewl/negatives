
import java.awt.image.BufferedImage;
import java.io.File;

public class FileList {
   
   public static void main( String[] args ) {
      System.out.println( "\n-------------------- Begin --------------------\n" );
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
               System.out.println( "convert method returned null" );
            } else {
               try {
                  String fileName = f.getName().substring( 0, f.getName().lastIndexOf(".") );
                  String extension =  f.getName().substring( f.getName().lastIndexOf(".") );
                  String outputFile = f.getParentFile() + File.separator + "output" + File.separator;
//      // Create File object to make directories
//      File out = new File( "C:\\image\\output" );
//      out.mkdirs();
//      // Recreate File object with fully qualified file name and write output
//   //   outputFile = outputFile + fileName + "Inverted" + extension;
//      out = new File( "C:\\image\\output\\outFile.jpg" );
//      try {
//         ImageIO.write( newImage, "jpg", out );
//      } catch( IOException e ) {
//         System.out.println( e );
//      }

               } catch( Exception e ) {
                  System.out.println( "Error while trying to write output for " + f );
                  e.printStackTrace();
               }
            }

         }
      }
   }

   private static BufferedImage convert( File file ) {
      //read image
      MBBufferedImage img = null;
      try {
         img = new MBBufferedImage( ImageIO.read( file ));
         return img.getNegativeImg();
      } catch( IOException e ) {
         System.out.println( e );
         return null;
      } 
   }


//   //
//   
//




}












