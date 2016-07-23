
public class TestRuntime {

   public static void main( String[] args ) {
   
      Runtime r = Runtime.getRuntime();  
      System.out.println( "available processors:" + r.availableProcessors() );
   }
}