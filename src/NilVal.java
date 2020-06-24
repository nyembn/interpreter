final class NilVal extends Val
{
	static final NilVal nilVal = new NilVal();

	public String toString()
	{
		return "nil";
	}

	Val cloneVal()
	{
		return this;
	}

	float floatVal()   // This is not used by the interpreter.
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
