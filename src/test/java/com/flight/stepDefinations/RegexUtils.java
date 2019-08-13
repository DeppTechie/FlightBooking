package com.flight.stepDefinations;

import com.mifmif.common.regex.Generex;

public class RegexUtils {
	public static final String EMAIL = "\\w{10}\\@gmail\\.com";
	public static String generate(String regex) {
		return new Generex(regex).random();
	}

}
