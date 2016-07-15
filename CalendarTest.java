import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarTest {

   public static void main( String[] args ) {
      Calendar cal = Calendar.getInstance();            
      System.out.println( cal + "\n" );

      cal.clear();
      System.out.println( cal + "\n" );

      cal.set( Calendar.MONTH, Calendar.JANUARY );
      cal.set( Calendar.DAY_OF_MONTH, 3 );
      cal.set( Calendar.YEAR, 1966 );
      System.out.println( cal + "\n" );

      Date d = cal.getTime();
      System.out.println( d + "\n" );

   }
}