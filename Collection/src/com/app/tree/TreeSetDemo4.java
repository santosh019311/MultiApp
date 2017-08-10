package com.app.tree;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetDemo4 {

	public static void main(String[] args) {
	TreeSet t=new TreeSet(new MyComprator());
	t.add("Santosh");
	t.add("Asish");
	t.add("Satya");
	System.out.println(t);

	}
}
class MyComprator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		String s1=(String)o1;
		String s2=(String)o2;
		return  s2.compareTo(s1);
	}
}

