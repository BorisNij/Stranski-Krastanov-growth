package com.foxminded.borisnij;

public class DivisionStep {
	private final int partialDividend;
	private final int divisorMultiple;
	private final char quotientDigit;

	public DivisionStep(int partialDividend, int divisorMultiple, char quotientDigit) {
		this.partialDividend = partialDividend;
		this.divisorMultiple = divisorMultiple;
		this.quotientDigit = quotientDigit;
	}

	public int getPartialDividend() {
		return partialDividend;
	}

	public int getDivisorMultiple() {
		return divisorMultiple;
	}

	public char getQuotientDigit() {
		return quotientDigit;
	}
}
