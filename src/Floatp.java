import java.util.*;

final class Floatp extends Exp
{
	float val;

	Floatp(float f)
	{
		val = f;
	}

	void printParseTree(String indent)
	{	
	super.printParseTree(indent);
		String indent1 = indent+" ";
		IO.displayln(indent + indent.length() + " <exp> " + val);
	}
	
	Val Eval(HashMap<String,Val> state)
	{
		return new FloatVal(val);
	}
}
