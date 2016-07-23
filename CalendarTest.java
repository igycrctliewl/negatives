import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarTest {

   public static void main( String[] args ) {
      SimpleDateFormat fmt = new SimpleDateFormat( "MM/dd/yyyy" );
      //SimpleDateFormat fmt = new SimpleDateFormat( "dd-MMM-yyyy" );
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

      //  get milliseconds from the Date object
      long millis = d.getTime();
      System.out.println( "millis: " + millis + "\n" );

      long today = new Date().getTime();
      System.out.println( "today: " + today + "\n" );

      Date age = new Date();
      age.setTime( today - millis );
      System.out.println( fmt.format( age ) + "\n" );

   }
}