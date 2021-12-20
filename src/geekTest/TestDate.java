package geekTest;

import java.util.ArrayList;
import java.util.List;

public class TestDate {
    public static void main(String[] args) {
       List<String> list = fun2("202110",10);
       list.forEach( str -> System.out.println(str));

    }

    public static List<String> fun(String date,int count){
        //202106  05 04 ... xx
        List<String> list = new ArrayList<String>();
        list.add(date);
        int year = Integer.parseInt(date.substring(0,4));
        int month = Integer.parseInt(date.substring(4,6));
        while(month > 3 && list.size() < count){
            month-=3;
            String newStr = month > 9 ? year+""+month:year+"0"+month;
            list.add(newStr);
            if(month == 3){
                year--;
                month = 12;
                list.add(year+""+month);
            }
        }
        return  list;
    }

    /**
     * 1-3 4-6 7-9 10-12
     * 03  06  09  12
     * @param date  输入日期
     * @param count  份数
     */
    public static List<String> fun2(String date,int count){

        int year = Integer.parseInt(date.substring(0,4));
        int month = Integer.parseInt(date.substring(4,6));
        int value = month/3 ;
        if (month % 3 > 0){
            value += 1;
        }
        System.out.println(value);//季度数s
        switch (value){
            case 1: date = "03";    break;
            case 2: date = "06";    break;
            case 3: date = "09";    break;
            case 4: date = "12";   break;
            default:
                System.out.println("未知区间");
        }
        List<String> list = new ArrayList<String>();
        //list.add(year+date);
        list = fun(year+date,count);

        return  list;
    }

}
