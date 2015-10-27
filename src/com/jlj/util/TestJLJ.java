package com.jlj.util;

public class TestJLJ {
	public static void main(String[] args) {
		String sonpicurl = "/wsp/res/gh_2hao/image/20151027/20151027122249_780.jpg";
		sonpicurl = sonpicurl.substring(sonpicurl.indexOf("res/"));
		System.out.println(sonpicurl);
	}
}
