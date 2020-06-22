import java.util.*;

final class First extends FunExp
{	
	First(ExpList e)
	{
		expList = e;
	}

	String getFunOp()
	{
		return "first";
	}
	
	Val Eval(HashMap<String,Val> state)
	{
		return expList.firstEval(state);	
	}
}