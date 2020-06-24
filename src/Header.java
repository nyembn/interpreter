import java.util.*;

class Header{
	String funName;
	ParameterList parameterList;
	
	Header(String fn, ParameterList pl){
		funName = fn;
		parameterList = pl;
	}
	
	void printParseTree(String indent)
	{
		IO.displayln(indent + indent.length() + " <header>");					  
		String indent1 = indent+" ";				  
		IO.displayln(indent1 + indent1.length() + " <fun name> " + funName);
		IO.displayln(indent1 + indent1.length() + " <parameter list>");
		String indent2 = indent1+" ";

		ParameterList p = parameterList;
		while ( p instanceof NonEmptyParameterList )
		{
			IO.displayln(indent2 + indent2.length() + " " + ((NonEmptyParameterList)p).id);
			p = ((NonEmptyParameterList)p).parameterList;
		}
	}
}
