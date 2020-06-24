import java.util.*;

final class AddE extends FunExp
{	
	AddE(ExpList e)
	{
		expList = e;
	}

	String getFunOp()
	{
		return "+";
	}
	Val Eval(HashMap<String,Val> state)
	{
		return expList.addEval(state);
	}
}