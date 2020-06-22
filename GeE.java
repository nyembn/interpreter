import java.util.*;

final class GeE extends FunExp
{	
	GeE(ExpList e)
	{
		expList = e;
	}

	String getFunOp()
	{
		return ">=";
	}

	Val Eval(HashMap<String,Val> state)
	{
		return expList.geEval(state);
	}
}