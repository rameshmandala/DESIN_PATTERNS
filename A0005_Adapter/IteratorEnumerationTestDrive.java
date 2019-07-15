package com.mylearning.designpatterns.A0005_Adapter;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;

public class IteratorEnumerationTestDrive {
	public static void main (String args[]) {
		final ArrayList l = new ArrayList(Arrays.asList(args));
		final Enumeration enumeration = new IteratorEnumeration(l.iterator());
		while (enumeration.hasMoreElements()) {
			System.out.println(enumeration.nextElement());
		}
	}
}
