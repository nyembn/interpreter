import java.util.*;

final class OrE extends FunExp
{	
	OrE(ExpList e)
	{
		expList = e;
	}

	String getFunOp()
	{
		return "or";
	}

	Val Eval(HashMap<String,Val> state)
	{
		return expList.orEval(state);
	}
}