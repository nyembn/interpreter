import java.util.*;

final class FunCall extends FunExp
{
	Id func;  // identifier "func" may be a variable or a user-defined function name
	
	FunCall(Id i, ExpList e)
	{
		func = i;
		expList = e;
	}

	String getFunOp()
	{
		return func.id;
	}
	
	Val Eval(HashMap<String,Val> state)
	{
		return null;	
	}
}
