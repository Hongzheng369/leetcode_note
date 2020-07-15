/*
Given a date string in the form Day Month Year, where:

Day is in the set {"1st", "2nd", "3rd", "4th", ..., "30th", "31st"}.
Month is in the set {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}.
Year is in the range [1900, 2100].
Convert the date string to the format YYYY-MM-DD, where:

YYYY denotes the 4 digit year.
MM denotes the 2 digit month.
DD denotes the 2 digit day.
Example 1:

Input: date = "20th Oct 2052"
Output: "2052-10-20"
Example 2:

Input: date = "6th Jun 1933"
Output: "1933-06-06"
Example 3:

Input: date = "26th May 1960"
Output: "1960-05-26"
*/
class Solution {
  public String reformatDate(String date) {
    Map<String, String> m = new HashMap<String, String>();
    m.put("Jan", "01");
    m.put("Feb", "02");
    m.put("Mar", "03");
    m.put("Apr", "04");
    m.put("May", "05");
    m.put("Jun", "06");
    m.put("Jul", "07");
    m.put("Aug", "08");
    m.put("Sep", "09");
    m.put("Oct", "10");
    m.put("Nov", "11");
    m.put("Dec", "12");
    String[] items = date.split(" ");    
    String day = items[0].substring(0, items[0].length() - 2);
    if (day.length() == 1) day = "0" + day;
    return items[2] + "-" + m.get(items[1]) + "-" + day;
  }
}