class DivE extends FunExp
{	
	DivE(ExpList e)
	{
		expList = e;
	}

	String getFunOp()
	{
		return "/";
	}
}