
public class StringTest {

   public static void main( String[] args ) {
      String s = "StringTest.java";
      System.out.println( "file name: " + s.substring( 0, s.lastIndexOf(".") ));
      System.out.println( "extension: " + s.substring( s.lastIndexOf(".") ));

      s = "String.Test.java";
      System.out.println( "file name: " + s.substring( 0, s.lastIndexOf(".") ));
      System.out.println( "extension: " + s.substring( s.lastIndexOf(".") ));

   //   s = "StringTest.java";
   //   nameParts = s.split("[.]");
   //   System.out.println( "length: " + nameParts.length );
   }
}