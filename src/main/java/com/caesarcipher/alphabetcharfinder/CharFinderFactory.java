package com.caesarcipher.alphabetcharfinder;

public class CharFinderFactory {
	private enum Direction {
		FORWARD, BACKWARD
	}

	public static CharFinderService getServiceInstance(int positionsToChange) {
		Direction direction = (positionsToChange > 0) ? Direction.FORWARD : Direction.BACKWARD;
		CharFinderService service;
		switch (direction) {
		case FORWARD:
			service = new CharFinderForwardServiceImpl();
			break;
		default:
			service = new CharFinderBackwardServiceImpl();
			break;
		}

		return service;
	}
}
