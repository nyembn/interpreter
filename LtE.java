class LtE extends FunExp
{	
	LtE(ExpList e)
	{
		expList = e;
	}

	String getFunOp()
	{
		return "<";
	}
}