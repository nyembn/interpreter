import java.util.*;

final class LeE extends FunExp
{	
	LeE(ExpList e)
	{
		expList = e;
	}

	String getFunOp()
	{
		return "<=";
	}

	Val Eval(HashMap<String,Val> state)
	{
		return expList.leEval(state);
	}
}