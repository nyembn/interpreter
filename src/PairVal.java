final class PairVal extends Val
{
	Val first;
	Val second;

	PairVal(Val f, Val s)
	{
		first = f;
		second = s;
	}

	public String toString()
	{
		return "pair("+first+", "+second+")";
	}

	Val cloneVal()
	{
		return this;
	}

	float floatVal()

	// This is not used by the interpreter. For other purposes, this might return some code value of this pair object.

	{
		return 0.0f;
	}

	boolean isNumber()
	{
		return false;
	}

	boolean isZero()
	{
		return false;
	}
}
