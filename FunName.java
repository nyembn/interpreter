import java.util.*;

class FunName
{
	String id;

	FunName(String i)
	{
		id = i;
	}

	void printParseTree(String indent)
	{
		String indent1 = indent + " ";
		
		IO.displayln(indent + indent.length() + " <fun name> " + id);
	}
}

