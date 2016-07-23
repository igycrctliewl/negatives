import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AgeCompare {

   public static void main( String[] args ) {
      
      SimpleDateFormat fmt = new SimpleDateFormat( "MM/dd/yyyy" );

      Calendar today = Calendar.getInstance();            
/*      today.clear();
      today.set( Calendar.MONTH, Calendar.JANUARY );
      today.set( Calendar.DAY_OF_MONTH, 3 );
      today.set( Calendar.YEAR, 2016 );
*/      System.out.println( "today:" + fmt.format( today.getTime() ) );

      Calendar birthDate = Calendar.getInstance();
      birthDate.clear();
      birthDate.set( Calendar.MONTH, Calendar.JANUARY );
      birthDate.set( Calendar.DAY_OF_MONTH, 3 );
      birthDate.set( Calendar.YEAR, 1966 );
      System.out.println( "birthDate:" + fmt.format( birthDate.getTime() ) );

      // copy to looper and increment by one day to begin loop
      Calendar looper = (Calendar) birthDate.clone();
      looper.add( Calendar.DAY_OF_YEAR, 1 );

      int days = 0;
      int years = 0;

      for( ; looper.compareTo( today ) <= 0; looper.add( Calendar.DAY_OF_YEAR, 1 ) ) {
         days++;
         //System.out.println( "day:" + days + "  date:" + fmt.format( looper.getTime() ) );
         if( looper.get( Calendar.MONTH ) == birthDate.get( Calendar.MONTH ) && 
             looper.get( Calendar.DAY_OF_MONTH ) == birthDate.get( Calendar.DAY_OF_MONTH ) ) {
            years++;
         }
      }
      System.out.println( "days:" + days );
      System.out.println( "years:" + years );
   }
}