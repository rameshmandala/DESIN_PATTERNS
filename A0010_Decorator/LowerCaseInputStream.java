package com.mylearning.designpatterns.A0010_Decorator;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class LowerCaseInputStream extends FilterInputStream {

	public LowerCaseInputStream(InputStream in) {
		super(in);
	}

	@Override
    public int read() throws IOException {
		final int c = super.read();
		return c == -1 ? c : Character.toLowerCase((char)c);
	}

}
