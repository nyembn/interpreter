import java.util.*;

final class GtE extends FunExp
{	
	GtE(ExpList e)
	{
		expList = e;
	}

	String getFunOp()
	{
		return ">";
	}

	Val Eval(HashMap<String,Val> state)
	{
		return expList.gtEval(state);
	}
}