package com.app.comp;

import java.util.Comparator;
import java.util.TreeSet;

public class CompComp implements Comparable {
	String name;
	int eid;

	public CompComp(String name, int eid) {
		this.name = name;
		this.eid = eid;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", eid=" + eid + "]";
	}

	@Override
	public int compareTo(Object obj) {
		int eid1 = this.eid;
		CompComp e = (CompComp) obj;
		int eid2 = e.eid;
		if (eid1 < eid2) {
			return -1;
		} else if (eid1 > eid2) {
			return 1;
		} else
			return 0;
	}

}

class CompComp1 {
	public static void main(String[] args) {
		CompComp e1 = new CompComp("nag", 100);

		CompComp e2 = new CompComp("balaiah", 200);

		CompComp e3 = new CompComp("chiru", 50);

		CompComp e4 = new CompComp("venki", 150);

		CompComp e5 = new CompComp("nag", 100);
	
		TreeSet t=new TreeSet();
		
		t.add(e1);
		t.add(e2);
		t.add(e3);
		t.add(e4);
		t.add(e5);
		System.out.println(t);
		TreeSet t1=new TreeSet(new MyComparator());
		t1.add(e1);
		t1.add(e2);
		t1.add(e3);
		t1.add(e4);
		t1.add(e5);
		System.out.println(t1);
	}
}
class MyComparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		CompComp e1=(CompComp)o1;
		CompComp e2=(CompComp)o2;
		
		return e1.compareTo(e2);
	}
	
}