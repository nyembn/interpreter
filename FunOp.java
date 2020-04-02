import java.util.*;

class FunOp{
	String op;
	
	FunOp(String opr){
		op = opr;
	}
	
	void printParseTree(String indent){
		String indent1 = indent + " ";
		
		IO.displayln(indent1 + indent1.length() + " " + op);
	}
}
