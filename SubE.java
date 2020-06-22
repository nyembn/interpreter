import java.util.*;

final class SubE extends FunExp
{	
	SubE(ExpList e)
	{
		expList = e;
	}

	String getFunOp()
	{
		return "-";
	}
		
	Val Eval(HashMap<String,Val> state)
	{
		return expList.subEval(state);
	}
}