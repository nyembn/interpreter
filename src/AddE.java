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

	{
		return expList.addEval(state);
	}
}