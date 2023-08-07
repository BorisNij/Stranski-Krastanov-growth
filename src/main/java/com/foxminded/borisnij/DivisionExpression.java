package com.foxminded.borisnij;

import java.util.ArrayList;
import java.util.List;

public class DivisionExpression {
	private final int dividend;
	private final int divisor;
	private final List<DivisionStep> solution;

	public DivisionExpression(int dividend, int divisor) {
		this.dividend = dividend;
		this.divisor = divisor;
		this.solution = new ArrayList<>();
	}

	public void solve(LongDivider longDivider) {
		this.solution.clear();
		this.solution.addAll(longDivider.divide(this.dividend, this.divisor));
	}

	public void outputSolution(LongDivisionReporter solutionReporter) {
		solutionReporter.report(this.solution);
	}
}
