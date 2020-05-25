import java.util.*;

class Int extends Exp
{
	int val;

	Int(int i)
	{
		val = i;
	}

	void printParseTree(String indent)
	{	String indent1 = indent + " ";
	
		IO.displayln(indent + indent.length() + " <exp>");
		IO.displayln(indent1 + indent1.length() + " " + val);
	}
	
	Val Eval(HashMap<String,Val> state)
	{
		return new IntVal(val);
	}
	
}
