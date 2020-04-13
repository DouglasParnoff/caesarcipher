package com.caesarcipher.alphabetcharfinder;

public class CharFinderBackwardServiceImpl implements CharFinderService{

	@Override
	public int getCharPosition(char source) {
		return Alphabet.getReverse().indexOf(source);
	}	

	@Override
	public int getTargetPosition(char source, int positionsToChange) {
		int sourcePosition = getCharPosition(source);
		return (sourcePosition + (-1 * positionsToChange)) % Alphabet.getLength();
	}

	@Override
	public char getCharAtPosition(int position) {
		return Alphabet.getReverseArray()[position];
	}
}
