class MulE extends FunExp
{	
	MulE(ExpList e)
	{
		expList = e;
	}

	String getFunOp()
	{
		return "*";
	}
}