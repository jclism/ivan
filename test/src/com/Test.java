package com;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	public static void main(String[] args) {
		System.out.println(regExpTest("^1\\d{10}$","18922378798"));
	}

	
	/** 
     * ������֤����һ 
     */ 
    public static boolean regExpTest(String regRule,String regStr) { 
        //��֤��ʶ����������ĸ�����֡��»������ 
        Pattern p = Pattern.compile(regRule); 
        Matcher m = p.matcher(regStr); 
        return  m.matches(); 
    } 
}
