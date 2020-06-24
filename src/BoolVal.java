final class BoolVal extends Val
{
	boolean val;

	BoolVal(boolean b)
	{
		val = b;
	}

	public String toString()
	{
		return String.valueOf(val);
	}

	Val cloneVal()
	{
		return new BoolVal(val);
	}

	float floatVal()
	{
		if ( val )
			return 1.0f;
		else
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
