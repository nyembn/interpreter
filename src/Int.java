import java.util.*;

final class Int extends Exp
{
	int val;

	Int(int i)
	{
		val = i;
	}

	void printParseTree(String indent)
	{	
		super.printParseTree(indent);
		String indent1 = indent + " ";
		IO.displayln(indent1 + indent1.length() + " " + val);
	}
	
	Val Eval(HashMap<String,Val> state)
	{
		return new IntVal(val);
	}
	
}
