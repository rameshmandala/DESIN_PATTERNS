package com.mylearning.designpatterns.A0005_Adapter;


import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;

public class EnumerationIteratorTestDrive {
	public static void main (String args[]) {

		final Vector v = new Vector(Arrays.asList(args));
		final Iterator iterator = new EnumerationIterator(v.elements());
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
