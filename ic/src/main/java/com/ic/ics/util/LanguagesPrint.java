package com.ic.ics.util;

import java.util.Locale;

public class LanguagesPrint {
	
	public static void main(String args[]) {
		
		String[] languages = Locale.getISOLanguages();
		
		for (String language : languages) {
			Locale locale = new Locale(language);
			System.out.println(language + ": " + locale.getDisplayLanguage());
		}
	}
}
