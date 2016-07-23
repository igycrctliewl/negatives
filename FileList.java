import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class FileList {
   
   public static void main( String[] args ) {

      String filename = args[0];

      File home = new File( filename );
      System.out.println( home.getAbsolutePath() );
      System.out.println( "isFile? " + home.isFile() );
      System.out.println( "isDirectory? " + home.isDirectory() );

      System.out.println("*************  list contents  ***************\n" );
      File[] contents = home.listFiles();
      for( File f : contents ) {
         String fileName = f.getName().substring( 0, f.getName().lastIndexOf(".") );
         String extension =  f.getName().substring( f.getName().lastIndexOf(".") );
         System.out.println( "[" + fileName + "]..[" + extension + "]" );
      }
   }
}