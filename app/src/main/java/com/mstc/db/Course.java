package com.mstc.db;

import java.io.Serializable;
import java.util.Vector;

/**
 * Created by Administrator on 2016/5/17.
 */
public class Course implements Serializable{
    public String course_name;
    public String classroom;
    public int week;
    public int day_of_week;
    public String date;
    public String time;

    public Course(String course_name,String classroom,int week,int day_of_week,String date,String time){
        this.course_name = course_name;
        this.classroom = classroom;
        this.week = week;
        this.day_of_week = day_of_week;
        this.date = date;
        this.time = time;
    }

    /**
     *  input "1,2,3,4,5,6,8,9,10,11",output <1,6>,<8,11>
     * @param timeStr
     * @return
     */
    public static Vector<Vector<Integer>> parseTimeStr(String timeStr) {
        String[] timeArray = timeStr.split(",");
        Vector<Vector<Integer>> timeVector = new Vector<>();
        int beginTime = Integer.parseInt(timeArray[0]);
        int endTime = Integer.parseInt(timeArray[0]);
        for (int i = 1; i < timeArray.length; i++) {
            int time = Integer.parseInt(timeArray[i]);
            if(time == (endTime + 1)){
                endTime++;
            } else {
                Vector<Integer> tmp = new Vector<>(2);
                tmp.add(new Integer(beginTime));
                tmp.add(new Integer(endTime));
                beginTime = time;
                endTime = time;
                timeVector.add(tmp);
            }
            //timeVector.add(Integer.parseInt(timeArray[i]));
        }
        Vector<Integer> tmp = new Vector<>(2);
        tmp.add(new Integer(beginTime));
        tmp.add(new Integer(endTime));
        timeVector.add(tmp);
        return timeVector;
    }
}
