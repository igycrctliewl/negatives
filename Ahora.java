import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Ahora {

   public static void main( String[] args ) {
      
      SimpleDateFormat fmt = new SimpleDateFormat( "MM/dd/yyyy" );

      Calendar cal = Calendar.getInstance();            
      cal.clear();
      cal.set( Calendar.MONTH, Calendar.DECEMBER );
      cal.set( Calendar.DAY_OF_MONTH, 22 );
      cal.set( Calendar.YEAR, 2015 );
      Date today = cal.getTime();
      System.out.println( "today:" + fmt.format( today ) );

      cal.clear();
      cal.set( Calendar.MONTH, Calendar.JANUARY );
      cal.set( Calendar.DAY_OF_MONTH, 3 );
      cal.set( Calendar.YEAR, 1966 );
      Date birthDate = cal.getTime();
      System.out.println( "birthDate:" + fmt.format( birthDate ) );

      long millisToYearsByDiv = 1000l * 60l * 60l * 24l * 365l;
      System.out.println( "millisToYearsByDiv:" + millisToYearsByDiv );

      long javaOffsetInMillis = 1990l * millisToYearsByDiv;
      System.out.println( "javaOffsetInMillis:" + javaOffsetInMillis );

      long realNowInMillis = today.getTime() + javaOffsetInMillis;
      System.out.println( "realNowInMillis:" + realNowInMillis );

      long realBirthDayInMillis = birthDate.getTime() + javaOffsetInMillis;
      System.out.println( "realBirthDayInMillis:" + realBirthDayInMillis );

      long ageInMillis = realNowInMillis - realBirthDayInMillis;
      System.out.println( "ageInMillis:" + ageInMillis );

      /*  looks like this result is off by about the number of leap days in the lifetime */
      System.out.println( "age:" + ageInMillis / millisToYearsByDiv );
   }
}