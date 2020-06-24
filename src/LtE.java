import java.util.*;

final class LtE extends FunExp
{	
	LtE(ExpList e)
	{
		expList = e;
	}

	String getFunOp()
	{
		return "<";
	}
	
	Val Eval(HashMap<String,Val> state)
	{
		return expList.ltEval(state);
	}
}