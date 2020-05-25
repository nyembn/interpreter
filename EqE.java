class EqE extends FunExp
{	
	EqE(ExpList e)
	{
		expList = e;
	}

	String getFunOp()
	{
		return "=";
	}
}