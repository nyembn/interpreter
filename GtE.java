class GtE extends FunExp
{	
	GtE(ExpList e)
	{
		expList = e;
	}

	String getFunOp()
	{
		return ">";
	}
}