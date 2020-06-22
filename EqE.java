import java.util.*;

final class EqE extends FunExp
{	
	EqE(ExpList e)
	{
		expList = e;
	}

	String getFunOp()
	{
		return "=";
	}

	Val Eval(HashMap<String,Val> state)
	{
		return expList.eqEval(state);
	}
}