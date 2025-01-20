package com.scheduler.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {
  
  public static LocalDate convertStringToLocalDate(String date) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    return LocalDate.parse(date, formatter);
  }
  
}
