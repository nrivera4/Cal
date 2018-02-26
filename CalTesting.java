import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import junit.framework.JUnit4TestAdapter; 
import junit.framework.TestCase; 
import junit.framework.TestSuite; 
public class CalTesting{

  
 @Test
 //Tests if the distance between two accurate dates in the same month.  
 public void calAccurateDateSameMonthTest(){
   Cal cal = new Cal();
   int days = cal.cal(12, 1, 12, 10, 2017);
   assertTrue(days == 9);
 }
 //Tests if the distance between two accurate dates in different months prints out the right value.  
 @Test
  public void calAccurateDateDifferentMonthTest(){
   Cal cal = new Cal();
   int days = cal.cal(11, 1, 12, 10, 2017);
   assertTrue(days == 39);
 }
 //Test for IndexOutOfBoundsException. 
 @Test(expected = IndexOutOfBoundsException.class)
  public void calIndexOutOfBoundsTest(){
   Cal cal = new Cal();
   int days = cal.cal(-9, 1, 12, 10, 2017);
 }
 //Tests to see if two dates, one with a negative year, and one with a positive year. Produce the same output. 
 @Test
  public void calNegativeYearAndPositiveYearSameOutputTest(){
   Cal cal = new Cal();
   int days = cal.cal(10, 1, 12, 10, -2017);
   if(days == 70){
     days = cal.cal(10, 1, 12, 10, 2017);
     assertTrue(days == 70);
   }
   assertTrue(days == 70);
 }
 //Tests to see if a non-leap year february can have 29 days.  
  @Test
  public void calNonLeapYear29DaysTest(){
   Cal cal = new Cal();
   int days = cal.cal(2, 29, 12, 10, 2017);
     assertTrue(days == 284);
 }
  //Tests to see if any number of days can be input and return a proper value. 
  @Test
  public void calAnyNumberOfDaysTest(){
   Cal cal = new Cal();
   int days = cal.cal(2, 200, 12, 10, 2017);
     assertTrue(days == 113);
 }
  //Tests to see if a positive and negative day2 will produce different output. 
  @Test
  public void calNegativeAndPositiveDaysDifferentOutputTest(){
   Cal cal = new Cal();
   int days = cal.cal(2, 10, 12, -1000, 2017);
   int days2 = cal.cal(2, 10, 12, 1000, 2017);
   assertTrue(days != days2);
  }
  //Tests to see if a later date can be input first and output the proper days. 
  @Test
  public void calLaterDateFirstTest(){
    Cal cal = new Cal();
    int days = cal.cal(2, 10, 1, 10, 2017);
    assertTrue(days == 28);
  }
  //Tests to see if all the values are 0, the return value is 0.
  @Test
  public void calAllZeroesTest(){
    Cal cal = new Cal();
    int days = cal.cal(0, 0, 0, 0, 0);
    System.out.println(days);
    assertTrue(days == 0);
  }
  //Tests leap year functionality. 
  @Test
  public void calLeapYearFunctionalityTest(){
    Cal cal = new Cal();
    int days = cal.cal(2, 29, 2, 29, 2020);
    assertTrue(days == 0);
  }
  
  
  
 

 public static void main(String[] args) {
      Result result = JUnitCore.runClasses(CalTesting.class);
  
      for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
         System.out.println("Check Tests");
      }
      

  
      System.out.printf("Successful on %d Tests!\n Failed %d Tests...\n", result.getRunCount()-result.getFailureCount(),result.getFailureCount() );
   }
}