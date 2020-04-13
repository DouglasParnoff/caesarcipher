package com.caesarcipher.alphabetcharfinder;

public class Alphabet {
	private static final String SEQUENCE = "abcdefghijklmnopqrstuvwxyz";
	private static final int LENGTH = SEQUENCE.length();
	private static final String REVERSE = new StringBuilder(SEQUENCE).reverse().toString();
	private static final char[] SEQUENCE_ARRAY = getCharArray(SEQUENCE);
	private static final char[] REVERSE_ARRAY = getCharArray(REVERSE);

	private static char[] getCharArray(String base) {
		return base.toCharArray();
	}

	public static String getSequence() {
		return SEQUENCE;
	}

	public static String getReverse() {
		return REVERSE;
	}

	public static int getLength() {
		return LENGTH;
	}

	public static char[] getSequenceArray() {
		return SEQUENCE_ARRAY;
	}

	public static char[] getReverseArray() {
		return REVERSE_ARRAY;
	}

}
