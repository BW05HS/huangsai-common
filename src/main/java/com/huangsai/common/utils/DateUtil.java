package com.huangsai.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @author zhuzg
 *
 */
public class DateUtil {
	/**
	 * 
	 * @param futureDate
	 * @return
	 */
	public int getRemainDays(Date futureDate) {
		return (int)(futureDate.getTime()-new Date().getTime())/1000/3600/24;	
	}
	
	/**
	 * 3.4.4鍒ゆ柇鏄惁涓哄綋澶�
	 * @param date
	 * @return
	 */
	public static boolean isToday(Date date) {
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		String dateStr = simpleDateFormat.format(date);
		String todayStr = simpleDateFormat.format(new Date());
		return dateStr.equals(todayStr);
		
	}
	
	
	/**
	 * 3.4.4鍒ゆ柇鏄惁涓哄綋鏈�
	 * @param date
	 * @return
	 */
	public static boolean isCurrentMonth(Date date) {
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMM");
		String dateStr = simpleDateFormat.format(date);
		String todayStr = simpleDateFormat.format(new Date());
		return dateStr.equals(todayStr);
		
	}
	
	/**
	 * 3.4.7缁欏畾鏃堕棿瀵硅薄锛屽垵濮嬪寲鍒拌鏈堝垵鐨�1鏃�0鏃�0鍒�0绉�0姣
	 * @return
	 * @throws ParseException 
	 */
	public static Date getMonthStart(Date date) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		String string = format.format(date);//199809
		String monthStart = string + "01 00:00:00";
		format = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		return format.parse(monthStart);
	}
	
	
	/**
	 * 3.4.7缁欏畾鏃堕棿瀵硅薄锛屽垵濮嬪寲鍒拌鏈堟湯鐨勬渶鍚庝竴绉�  姣斿 2019/11/30 23:59:59 
	 * @return
	 * @throws ParseException 
	 */
	public static Date getMonthEnd(Date date) throws ParseException {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY,0);
		calendar.set(Calendar.MINUTE, 0);
		//calendar.set(Calendar.HOUR, 0);
		
		calendar.set(Calendar.SECOND, 0);
		calendar.add(Calendar.SECOND, -1);
		return calendar.getTime(); 
		
	}
	
	
	
	
	
	
	
	
	
	/**
	 * 
	 * @param birthday
	 * @return
	 */
	public int getAge(Date birthday) {
		
		Calendar instance = Calendar.getInstance();
		instance.setTime(birthday);
		
		//寰楀埌鍑虹敓鐨勫勾
		int birthYear = instance.get(Calendar.YEAR);
		int birthMonth = instance.get(Calendar.MONTH);
		int birthDate = instance.get(Calendar.DAY_OF_MONTH);
		
		//鑾峰彇褰撳墠鐨勫勾鏈堟棩
		instance.setTime(new Date());
		int currentYear = instance.get(Calendar.YEAR);
		int currentMonth = instance.get(Calendar.MONTH);
		int currentDate = instance.get(Calendar.DAY_OF_MONTH);
		
		int age = currentYear-birthYear;
		if(currentMonth<birthMonth) {
			age--;
		}else if(currentMonth==birthMonth && currentDate<birthDate){
			age --;
		}
		
		return age;
		
	}
	
	
}