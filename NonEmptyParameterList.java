import java.util.*;

class NonEmptyParameterList extends ParameterList{
	String id;
	ParameterList pList;
	
	NonEmptyParameterList(String i, ParameterList pl){
		id = i;
		pList = pl;
	}
	
	void printParseTree(String indent){
		String indent1 = indent + " ";
		// it's and and a parameterlist
		IO.displayln(indent + indent.length() + " <parameter list>");
		IO.displayln(indent + indent.length() + id);
		pList.printParseTree(indent);
		
	}	
}
