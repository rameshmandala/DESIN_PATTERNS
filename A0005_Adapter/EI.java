package com.mylearning.designpatterns.A0005_Adapter;


import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class EI {
	public static void main (String args[]) {
		final Vector v = new Vector(Arrays.asList(args));

		final Enumeration enumeration = v.elements();

		while (enumeration.hasMoreElements()) {
			System.out.println(enumeration.nextElement());
		}
		final Iterator iterator = v.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
