package com.caesarcipher.alphabetcharfinder;

public class CharFinderForwardServiceImpl implements CharFinderService {

	@Override
	public int getCharPosition(char source) {
		return Alphabet.getSequence().indexOf(source);
	}	

	@Override
	public int getTargetPosition(char source, int positionsToChange) {
		int sourcePosition = getCharPosition(source);
		return (sourcePosition + positionsToChange) % Alphabet.getLength();
	}

	@Override
	public char getCharAtPosition(int position) {
		return Alphabet.getSequenceArray()[position];
	}

}
