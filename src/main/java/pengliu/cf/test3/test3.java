package pengliu.cf.test3;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by peng on 16-7-23.
 */
public class test3
{
    public static void main(String[] args)
    {
//        Map<String, Integer> map = new HashMap<>();
//        map.put("test", 123);
//        map.put("test2", 456);
//        map.put("test3", 789);
//
//        for(Map.Entry<String, Integer> entry: map.entrySet())
//        {
//            System.out.println(entry.getKey() + ", " + entry.getValue());
//        }

//        listSettledBillStat("2015-01", "2016-12");
        List<Integer[]> test = new ArrayList<>();
        test.add(new Integer[]{1, 2, 3});
        test.add(new Integer[]{4, 5, 6});

        for(Integer[] arr: test)
        {
            for(int i=0; i<arr.length; i++)
            {
                System.out.print(arr[i] + ",");
            }
            System.out.println();
        }

        List<String> chars = new ArrayList<>();
        chars.add("abc");
        chars.add("dev");
        chars.add("sdfasdf");

        String[] arrString = chars.toArray(new String[0]);
    }

    private static int cal(int x)
    {
        if(x == 1)
        {
            return 1;
        }
        else
        {
            return x * cal(x - 1);
        }
    }

    public static void listSettledBillStat(String startTime, String endTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Date startDate = null;
        Date endDate = null;
        try {
            startDate = sdf.parse(startTime);
            endDate = sdf.parse(endTime);
        } catch (Exception e) {
            throw new RuntimeException("时间格式错误");
        }
        Calendar calendarStart = Calendar.getInstance();
        calendarStart.setTime(startDate);
        Calendar calendarEnd = Calendar.getInstance();
        calendarEnd.setTime(endDate);
        int startYear = calendarStart.get(Calendar.YEAR);
        int startMonth = calendarStart.get(Calendar.MONTH) + 1;
        int endYear = calendarEnd.get(Calendar.YEAR);
        int endMonth = calendarEnd.get(Calendar.MONTH) + 1;
//        checkTimeRange(startYear, startMonth, endYear, endMonth);
        checkTimeRange(startDate.getYear(), startMonth, endYear, endMonth);
    }

    private static void checkTimeRange(Integer startYear, Integer startMonth, Integer endYear, Integer endMonth) {
//        checkYearAndMonth(startYear, startMonth);
//        checkYearAndMonth(endYear, endMonth);
        if (startYear != null && startMonth != null && endYear != null && endMonth != null) {
            if (endYear * 12 + endMonth < startYear * 12 + startMonth) {
                throw new RuntimeException("时间范围错误");
            }
        }
    }
}
