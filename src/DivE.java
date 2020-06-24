import java.util.*;

final class DivE extends FunExp
{	
	DivE(ExpList e)
	{
		expList = e;
	}

	String getFunOp()
	{
		return "/";
	}

	Val Eval(HashMap<String,Val> state)
	{
		return expList.divEval(state);
	}
}