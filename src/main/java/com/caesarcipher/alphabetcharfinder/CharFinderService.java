package com.caesarcipher.alphabetcharfinder;

public interface CharFinderService {
	public int getCharPosition(char source);	
	
	public int getTargetPosition(char source, int positionsToChange);

	public char getCharAtPosition(int position);

}
