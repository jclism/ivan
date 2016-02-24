package com;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	public static void main(String[] args) {
		System.out.println(regExpTest("^1\\d{10}$","18922378798"));
	}

	
	/** 
     * 正则验证方法一 
     */ 
    public static boolean regExpTest(String regRule,String regStr) { 
        //验证标识符必须由字母、数字、下划线组成 
        Pattern p = Pattern.compile(regRule); 
        Matcher m = p.matcher(regStr); 
        return  m.matches(); 
    } 
}
