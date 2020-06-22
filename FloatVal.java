final class FloatVal extends Val
{
	float val;

	FloatVal(float f)
	{
		val = f;
	}

	public String toString()
	{
		return String.valueOf(val);
	}

	Val cloneVal()
	{
		return new FloatVal(val);
	}

	float floatVal()
	{
		return val;
	}

	boolean isNumber()
	{
		return true;
	}

	boolean isZero()
	{
		return val == 0.0f;
	}
}
