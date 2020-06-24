import java.util.*;

final class Pair extends FunExp
{	
	Pair(ExpList e)
	{
		expList = e;
	}

	String getFunOp()
	{
		return "pair";
	}
	
	Val Eval(HashMap<String,Val> state)
	{
		return expList.pairEval(state);
	}
}