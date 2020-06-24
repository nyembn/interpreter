import java.util.*;

final class MulE extends FunExp
{	
	MulE(ExpList e)
	{
		expList = e;
	}

	String getFunOp()
	{
		return "*";
	}
	
	Val Eval(HashMap<String,Val> state)
	{
		return expList.mulEval(state);
	}
}