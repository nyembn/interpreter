class First extends FunExp
{	
	First(ExpList e)
	{
		expList = e;
	}

	String getFunOp()
	{
		return "first";
	}
}