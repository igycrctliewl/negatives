import java.io.File;

public class FileList {
   
   public static void main( String[] args ) {
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
         System.out.println( f );
         String fileName = f.getName().substring( 0, f.getName().lastIndexOf(".") );
         String extension =  f.getName().substring( f.getName().lastIndexOf(".") );
         System.out.println( "parent:" + f.getParentFile() );
         System.out.println( "path:" + f.getAbsolutePath() );
         System.out.println( "[" + fileName + "]..[" + extension + "]\n" );
         System.out.println( "new file:" + f.getParentFile() + File.separator + "output" + File.separator + fileName + "Inverted" + extension + "\n" );
      }
   }
}