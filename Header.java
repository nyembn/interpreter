import java.util.*;

class Header{
	FunName funName;
	ParameterList parameterList;
	
	Header(FunName fn, ParameterList pl){
		funName = fn;
		parameterList = pl;
	}
	
	void printParseTree(String indent){
		String indent1 = indent + " ";
		
		IO.displayln(indent + indent.length() + " <header>");
		funName.printParseTree(indent1);
		parameterList.printParseTree(indent1);
	}
}
