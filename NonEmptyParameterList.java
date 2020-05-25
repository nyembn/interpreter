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
		
		IO.displayln(indent1 + indent1.length() + " " + id);
		pList.printParseTree(indent);
		
	}	
}
