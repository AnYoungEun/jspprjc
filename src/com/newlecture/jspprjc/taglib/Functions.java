package com.newlecture.jspprjc.taglib;

public class Functions {
	
	public static int lastNum(double total){
		int _total = (int)total;
		int last = _total/20;
		
		if(_total%20>0){
			last++;
		}
		
		return last;
	}
}
