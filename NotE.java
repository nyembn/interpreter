import java.util.*;

final class NotE extends FunExp
{	
	NotE(ExpList e)
	{
		expList = e;
	}

	String getFunOp()
	{
		return "not";
	}
	
	Val Eval(HashMap<String,Val> state)
	{
		return expList.notEval(state);
	}
}