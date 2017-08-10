package com.app.tree;

import java.util.TreeSet;

public class TreeSetDemo {
public static void main(String[] args) {
	TreeSet t=new TreeSet();
	System.out.println("A".compareTo("Z"));
	System.out.println("Z".compareTo("K"));
	System.out.println("A".compareTo("A"));
	//System.out.println("A".compareTo(null));
/*t.add("K");
t.add("Z");
t.add("A");
t.add("A");
System.out.println(t);*/
t.add(0);
t.add(10);
t.add(5);
t.add(15);
System.out.println(t);
System.out.println(t);
System.out.println(t);
}
}
