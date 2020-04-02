import java.util.*;

class Floatp extends Exp
{
	float val;

	Floatp(float f)
	{
		val = f;
	}

	void printParseTree(String indent)
	{
		IO.displayln(indent + indent.length() + " <exp> " + val);
	}
}
