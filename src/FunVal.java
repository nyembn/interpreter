final class FunVal extends Val
{
	String funName;

	// You add suitable constructors/functions.
	
	FunVal(String name)
	{
		funName = name;
	}
	
	public String toString()
	{
		return funName;
	}
	
	
	Val cloneVal()
	{
		return this;
	}
	
	float floatVal()
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
