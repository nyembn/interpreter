import java.util.*;

// what about braces
class FunDef extends FunDefList
{
	Header header;
	Exp exp;
	
	FunDef(Header h, Exp e){
		header = h;
		exp = e;
	}
	// header and parameter list
	
	void printParseTree(String indent){
		String indent1 = indent + " ";
		
		IO.displayln(indent + indent.length() + " <fun def>");
		header.printParseTree(indent1);
		IO.displayln(indent1 + indent1.length() + " <exp>");
		exp.printParseTree(indent1);
	}
}

