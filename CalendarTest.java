import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarTest {

   public static void main( String[] args ) {
      SimpleDateFormat fmt = new SimpleDateFormat( "MM/dd/yyyy" );
      System.out.println( "fmt is " + fmt.getClass() + "\n" );

      Calendar cal = Calendar.getInstance();            
      System.out.println( "cal is " + cal.getClass() + "\n" );
      System.out.println( cal + "\n" );

      cal.clear();
      System.out.println( cal + "\n" );

      cal.set( Calendar.MONTH, Calendar.JANUARY );
      cal.set( Calendar.DAY_OF_MONTH, 3 );
      cal.set( Calendar.YEAR, 1966 );
      System.out.println( cal + "\n" );

      Date d = cal.getTime();
      System.out.println( fmt.format( d ) + "\n" );

   //   cal.subtract( Calendar.getInstance().get( Calendar.TIME ) );
   //   System.out.println( cal + "\n" );

   }
}