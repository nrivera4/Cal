public static int cal (int month1, int day1, int month2,
                          int day2, int year)
   {
   //***********************************************************
   // Calculate the number of Days between the two given days in
   // the same year.
   // preconditions : day1 and day2 must be in same year
   //               1 <= month1, month2 <= 12
   //               1 <= day1, day2 <= 31
   //               month1 <= month2
   //               The range for year: 1 ... 10000
   //***********************************************************
      int numDays;

      if (month2 == month1) // in the same month
         numDays  = day2 - day1;
      else
      {
         // Skip month 0.
         int daysIn[] = {0, 31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
         // Are we in a leap year?
         int m4 = year % 4;
         int m100 = year % 100;
         int m400 = year % 400;
         if ((m4 != 0) || ((m100 == 0) && (m400 != 0)))
            daysIn[2] = 28;
         else
            daysIn[2] = 29;

         // start with days in the two months
        // System.out.printf("%d\n", month1);
         numDays = day2 + (daysIn[month1] - day1);
         // add the days in the intervening months
         for (int i = month1 + 1; i <= month2-1; i++){
           
           //THE FAULT IS RIGHT HERE IF I CHANGE THE LINE BELOW FROM
           //numDays = daysIn[i] + numDays;
           //TO
           //numDays = daysIn[i] + numDays + 15
           numDays = daysIn[i] + numDays;
         
         }
         
         

      }
      return (numDays);
   }
