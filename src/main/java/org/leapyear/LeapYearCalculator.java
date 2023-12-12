package org.leapyear;

public class LeapYearCalculator {

  public static boolean isLeapYear(int year) {
    if (year<0){
      return false;
    }
    if (year%4==0) {
      if (year%100==0) {
        return false;
      }
      else{
        return true;
      }
    }
    else {
      return false;
    }
  }
}
