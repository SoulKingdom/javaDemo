package com.example.junittest.util;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 日期查询工具类
 */
public class DateUtils {

    private static final int EIGHT = 8;

    /**
     * 获取String格式化成Date
     * @return
     */
    public static Date stringFormatDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取String格式化成Date
     * @return
     */
    public static String dateFormatString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    /**
     * 获取上个月最后一天
     * @return
     */
    public static String getLastMonthEndDay() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, -1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        int lastMonthMaxDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), lastMonthMaxDay);
        //按格式输出
        String gtime = sdf.format(c.getTime());
        return gtime;
    }
    /**
     * 获取当前月份最后一天
     * @return
     */
    public static Date getCurrentMonthEndDay(Date currentDate) {
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);
        int lastMonthMaxDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), lastMonthMaxDay);
        //按格式输出
        return c.getTime();
    }
    /**
     * 获取上上个月最后一天
     *
     * @return
     */
    public static String getBeforeLastMonthEndDay() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, -2);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        int lastMonthMaxDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), lastMonthMaxDay);
        //按格式输出
        String gtime = sdf.format(c.getTime());
        return gtime;
    }

    /**
     * 获取当前日期
     * @return
     */
    public static String getCurrentDay() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //按格式输出
        String gtime = sdf.format(c.getTime());
        return gtime;
    }

    /**
     * 获取去年的最后一天
     * @return
     */
    public static String getLastYearEndDay() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, -1);//拨回去年
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        c.set(Calendar.DAY_OF_YEAR, c.getActualMaximum(Calendar.DAY_OF_YEAR));
        String gtime = sdf.format(c.getTime());
        return gtime;
    }

    /**
     * 获取近7天日期
     * @return
     */
    public static List<String> querySevenDate() {
        ArrayList<String> pastDaysList = new ArrayList<>();
        for (int i = 6; i >= 0; i--) {
            pastDaysList.add(getPastDate(i));
        }
        return pastDaysList;
    }

    /**
     * 获取近7天日期
     * @return
     */
    public static List<String> querySevenDate2() {
        ArrayList<String> pastDaysList = new ArrayList<>();
        for (int i = 6; i >= 0; i--) {
            pastDaysList.add(getPastDate2(i));
        }
        return pastDaysList;
    }

    /**
     * 获取过去第几天的日期
     *
     * @param past
     * @return
     */
    public static String getPastDate(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String result = format.format(today);
        return result;
    }

    /**
     * 获取过去第几天的日期
     *
     * @param past
     * @return
     */
    public static String getPastDate2(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("MM-dd");
        String result = format.format(today);
        return result;
    }

    /**
     * 截取日期的day
     *
     * @param dateList
     * @return
     */
    public static String[] getDateDay(List<String> dateList) {
        String[] result = new String[dateList.size()];
        for (int i = 0; i < dateList.size(); i++) {
            result[i] = dateList.get(i).substring(EIGHT);
        }
        return result;
    }

    /**
     * 获取当小时开始时间
     *
     * @dept 上海软件研发中心
     * @param currentDate 当前时间
     * @return Date 当天开始时间
     * @author HaoXin.Liu
     * @date 2019/7/24 13:26
     **/
    public static Date getStartTimeCurrentHour(Date currentDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取当天开始时间
     *
     * @dept 上海软件研发中心
     * @param currentDate 当前时间
     * @return Date 当天开始时间
     * @author HaoXin.Liu
     * @date 2019/7/24 13:26
     **/
    public static Date getStartTimeCurrentDay(Date currentDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取当月的 天数
     *
     * @dept 上海软件研发中心
     * @return Date 当月开始时间
     * @author HaoXin.Liu
     * @date 2019/7/24 13:26
     **/
    public static int getCurrentMonthDay() {
        Calendar a = Calendar.getInstance();
        a.set(Calendar.DATE, 1);
        a.roll(Calendar.DATE, -1);
        int maxDate = a.get(Calendar.DATE);
        return maxDate;
    }

    /**
     * 获取当天开始时间
     *
     * @dept 上海软件研发中心
     * @param currentDate 当前时间
     * @return Date 当月开始时间
     * @author HaoXin.Liu
     * @date 2019/7/24 13:26
     **/
    public static Date getStartTimeCurrentMonth(Date currentDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.set(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取当天开始时间
     *
     * @dept 上海软件研发中心
     * @param currentDate 当前时间
     * @return Date 当年开始时间
     * @author HaoXin.Liu
     * @date 2019/7/24 13:26
     **/
    public static Date getStartTimeCurrentYear(Date currentDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.set(Calendar.MONTH, 1);
        calendar.set(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取当日结束时间
     *
     * @dept 上海软件研发中心
     * @param currentDate 当前时间
     * @return Date 当年开始时间
     * @author HaoXin.Liu
     * @date 2019/8/14 13:26
     **/
    public static Date getEndTime(Date currentDate) {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.setTime(currentDate);
        todayEnd.set(Calendar.HOUR, 23);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 999);
        return todayEnd.getTime();
    }

    /**
     * 当前时间整点集合（yyyy-MM-dd HH时间单位）
     *
     * @dept 上海软件研发中心
     * @param startTime 开始时间
     * @param currentDate 当前时间
     * @return List<String> 整点时间集合
     * @author HaoXin.Liu
     * @date 2019/7/24 15:57
     **/
    public static List<String> listCurrentDateDay(Date startTime, Date currentDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH");
        List<String> timeList = new ArrayList<>(0);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date newTime = calendar.getTime();
        //获取前一个小时
        while (startTime.getTime() <= newTime.getTime()) {
            //获取当前数据最大值
            timeList.add(sdf.format(newTime));
            calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - 1);
            newTime = calendar.getTime();
        }
        return timeList;
    }

    /**
     * 当前月份整日集合（yyyy-MM-dd 时间单位）
     *
     * @dept 上海软件研发中心
     * @param startTime 开始时间
     * @param currentDate 当前时间
     * @return List<String> 整日时间集合
     * @author HaoXin.Liu
     * @date 2019/7/24 15:57
     **/
    public static List<String> listCurrentDateMonth(Date startTime, Date currentDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<String> timeList = new ArrayList<>(0);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        Date newTime = calendar.getTime();
        //获取前一个小时
        while (startTime.getTime() <= newTime.getTime()) {
            //获取当前数据最大值
            timeList.add(sdf.format(newTime));
            calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - 1);
            newTime = calendar.getTime();
        }
        return timeList;
    }

    /**
     * 当前月份整日集合（yyyy-MM时间单位）
     *
     * @dept 上海软件研发中心
     * @param startTime 开始时间
     * @param currentDate 当前时间
     * @return List<String> 整月时间集合
     * @author HaoXin.Liu
     * @date 2019/7/24 15:57
     **/
    public static List<String> listCurrentDateYear(Date startTime, Date currentDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        List<String> timeList = new ArrayList<>(0);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR, 0);
        Date newTime = calendar.getTime();
        //获取前一个小时
        while (startTime.getTime() <= newTime.getTime()) {
            //获取当前数据最大值
            timeList.add(sdf.format(newTime));
            calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
            newTime = calendar.getTime();
        }
        return timeList;
    }

    /**
     * 获取前一天日期
     *
     * @return
     */
    public static String getYesterday() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, -1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //按格式输出
        String gtime = sdf.format(c.getTime());
        return gtime;
    }

    /**
     * 获取传递日期的 前一天日期
     *
     * @return
     */
    public static String getYesterday(String time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String gtime = null;
        try {
            Calendar c = Calendar.getInstance();
            c.setTime(sdf.parse(time));
            c.add(Calendar.DATE, -1);
            //按格式输出
            gtime = sdf.format(c.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return gtime;
    }

    /**
     * 获取前二天日期
     *
     * @return
     */
    public static String getLastYesterday() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, -2);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //按格式输出
        String gtime = sdf.format(c.getTime());
        return gtime;
    }

    /**
     * 获取指定日期前N天日期
     *
     * @return
     */
    public static String getOnceDate(String data, int past) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // 将字符串的日期转为Date类型，ParsePosition(0)表示从第一个字符开始解析
        Date date = sdf.parse(data, new ParsePosition(0));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
        Date today = calendar.getTime();
        String result = sdf.format(today);
        return result;
    }


    /**
     * 获取今年的年份
     * @return
     */
    public static String getCurrentYear() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        //按格式输出
        String gtime = sdf.format(c.getTime());
        return gtime;
    }

    /**
     * 获取去年的年份
     * @return
     */
    public static String getLastYear() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, -1);//拨回去年
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        c.set(Calendar.DAY_OF_YEAR, c.getActualMaximum(Calendar.DAY_OF_YEAR));
        String gtime = sdf.format(c.getTime());
        return gtime;
    }

    /**
     * 获取今年的月份
     * @return
     */
    public static String getCurrentMonth() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        //按格式输出
        String gtime = sdf.format(c.getTime());
        return gtime;
    }

    /**
     * 获取上个月月份
     *
     * @dept 上海软件研发中心
     * @return String 月份字符串
     * @author HaoXin.Liu
     * @date 2019/8/4 23:33
     **/
    public static String getLastMonthTime() {
        LocalDate today = LocalDate.now();
        today = today.minusMonths(1);
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy-MM");
        return formatters.format(today);
    }

    /**
     * 获取去年的月份
     * @return
     */
    public static String getLastMonth() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, c.get(Calendar.YEAR) - 1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        String time = sdf.format(c.getTime());
        return time;
    }

    /**
     * 获取去年的日期
     *
     * @dept 上海软件研发中心
     * @return String 格式化后时间
     * @author HaoXin.Liu
     * @date 2019/8/5 17:24
     **/
    public static String getLastMonthAndDay() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, c.get(Calendar.YEAR) - 1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String time = sdf.format(c.getTime());
        return time;
    }

    /**
     * 获取明天
     * @return
     */
    public static String getTomorrowDate() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, +1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String gtime = sdf.format(c.getTime());
        return gtime;
    }

    /**
     * 获取当前日期前一个月
     * @return
     */
    public static String getPriorMonth() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        //按格式输出
        String gtime = sdf.format(c.getTime());
        return gtime;
    }

    /**
     *  获取当前日期前一个月
     *
     * @dept 上海软件研发中心
     * @param currentTime 当前时间
     * @return String  时间戳
     * @author HaoXin.Liu
     * @date 2019/8/15 10:36
     **/
    public static String getPriorMonth(String currentTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(sdf.parse(currentTime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.add(Calendar.MONTH, -1);
        //按格式输出
        String gtime = sdf.format(c.getTime());
        return gtime;
    }

    /**
     *  获取当前日期前一个月
     *
     * @dept 上海软件研发中心
     * @param currentTime 当前时间
     * @return String  时间戳
     * @author HaoXin.Liu
     * @date 2019/8/15 10:36
     **/
    public static String getPriorYear(String currentTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(sdf.parse(currentTime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.add(Calendar.YEAR, -1);
        //按格式输出
        String gtime = sdf.format(c.getTime());
        return gtime;
    }

    /**
     * 获取24小时节点
     * @return
     */
    public static List<String> listHour() {
        List<String> list = new ArrayList<>();
        list.add("01");
        list.add("02");
        list.add("03");
        list.add("04");
        list.add("05");
        list.add("06");
        list.add("07");
        list.add("08");
        list.add("09");
        list.add("10");
        list.add("11");
        list.add("12");
        list.add("13");
        list.add("14");
        list.add("15");
        list.add("16");
        list.add("17");
        list.add("18");
        list.add("19");
        list.add("20");
        list.add("21");
        list.add("22");
        list.add("23");
        list.add("24");
        return list;
    }

    /**
     * 获取当月所有日期 -年月日
     * @return
     */
    public static List getAllTheDateOftheMonth() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List list = new ArrayList();
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(Calendar.DATE, 1);
        int month = cal.get(Calendar.MONTH);
        while (cal.get(Calendar.MONTH) == month) {
            list.add(sdf.format(cal.getTime()));
            cal.add(Calendar.DATE, 1);
        }
        return list;
    }

    /**
     * 获取当月所有日期 -月日
     * @return
     */
    public static List getAllDateMonth() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
        List list = new ArrayList();
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(Calendar.DATE, 1);
        int month = cal.get(Calendar.MONTH);
        while (cal.get(Calendar.MONTH) == month) {
            list.add(sdf.format(cal.getTime()));
            cal.add(Calendar.DATE, 1);
        }
        return list;
    }

    /**
     * 获取某年某月
     * @param year
     * @param month
     * @return
     */
    public static String getDateLastDay(String year, String month) {
        Calendar calendar = Calendar.getInstance();
        // 设置时间,当前时间不用设置
        calendar.set(Calendar.YEAR, Integer.parseInt(year));
        calendar.set(Calendar.MONTH, Integer.parseInt(month));
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        return format.format(calendar.getTime());
    }

    /**
     * 获取今年的月份
     * @return
     */
    public static String getMonth() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("M");
        //按格式输出
        String gtime = sdf.format(c.getTime());
        return gtime;
    }


    /**
     * 获取当前具体日期
     * @return
     */
    public static String getDetailCurrentDay() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //按格式输出
        String gtime = sdf.format(c.getTime());
        return gtime;
    }

    public static String getNextMonthCurrentDay(String currentDate) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date nextMonthDay = sdf.parse(currentDate);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(nextMonthDay);
        calendar.add(Calendar.MONTH, 1);
        return sdf.format(calendar.getTime());
    }

    /**
     * 获取去年的上一个月份
     * @return
     */
    public static String getLastBeforeMonth() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, c.get(Calendar.YEAR) - 1);
        c.set(Calendar.MONTH, c.get(Calendar.MONTH) - 1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        String time = sdf.format(c.getTime());
        return time;
    }

    /**
     * 获取上上个月
     *
     * @return
     */
    public static String getBeforeLastMonth() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, -2);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        int lastMonthMaxDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), lastMonthMaxDay);
        //按格式输出
        String gtime = sdf.format(c.getTime());
        return gtime;
    }

    /**
     * 计算两个时间段间隔天数
     *
     * @dept 上海软件研发中心
     * @param startTime ： 开始时间
     * @param endTime  ： 结束时间
     * @return int 间隔天数
     * @author HaoXin.Liu
     * @date 2019/8/9 12:14
     **/
    public static int caculateTotalTime(String startTime, String endTime) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = null;
        Date date = null;
        Long l = 0L;
        try {
            date = formatter.parse(endTime);
            long ts = date.getTime();
            date1 = formatter.parse(startTime);
            long ts1 = date1.getTime();

            l = (ts - ts1) / (1000 * 60 * 60 * 24);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return l.intValue();
    }

    /**
     * 得到当前时间的前N小时
     *
     * @return
     */
    public static String getBeforeByHourTime(String time, int ihour) {
        String returnstr = "";
        ihour = ihour * -1;
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(df.parse(time));
            calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) + ihour);
            returnstr = df.format(calendar.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return returnstr;
    }
    /**
     * 得到当前时间的前N分钟
     *
     * @return
     */
    public static String getBeforeByMinuteTime(String time, int minute) {
        String returnstr = "";
        minute = minute * -1;
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(df.parse(time));
            calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE) + minute);
            returnstr = df.format(calendar.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return returnstr;
    }
    /**
     * 判断起始时间大小
     *
     * @return
     */
    public static boolean judgeTime(String startTime, String endTime) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date start = sdf.parse(startTime);
        Date end = sdf.parse(endTime);
        if (end.getTime() >= start.getTime()) {
            return true;
        }
        return false;
    }

    public static String getCurrentTimeToLastMinute(Integer minute) {

        Calendar beforeTime = Calendar.getInstance();
        beforeTime.add(Calendar.MINUTE, -minute);// 5分钟之前的时间
        Date beforeD = beforeTime.getTime();
        String before5 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(beforeD);
        return before5;
    }
}

