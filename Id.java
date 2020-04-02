import java.util.*;

class Id extends Exp
{
	String id;

	Id(String ident)
	{
		id = ident;
	}

	void printParseTree(String indent)
	{	String indent1 = indent + " ";
	
		IO.displayln(indent + indent.length() + " <exp>");
		IO.displayln(indent1 + indent1.length() + " " + id);
	}
}
