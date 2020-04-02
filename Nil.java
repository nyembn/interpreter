import java.util.*;

class Nil extends Exp{
	String nilExp;
	
	Nil(String n){
		nilExp = n;
	}
	
	void printParseTree(String indent){
		String indent1 = indent + " ";
		IO.displayln(indent + indent.length() + " <exp>");
		IO.displayln(indent1 + indent1.length() + " " + nilExp);
	}
}
