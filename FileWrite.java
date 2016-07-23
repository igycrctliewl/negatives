import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class FileWrite {
   
   public static void main( String[] args ) {

      File file = new File( args[0] );
      file = new File( file.getAbsolutePath() );

      System.out.println( "get path:" + file.getPath() );
      System.out.println( "get abs path:" + file.getAbsolutePath() );
      System.out.println( "new file:" + file.getParentFile() + File.separator + "output" + File.separator );
      
      File output = new File( file.getParentFile() + File.separator + "output" + File.separator );
      output.mkdirs();
   }
}