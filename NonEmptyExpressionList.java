import java.util.*;

class NonEmptyExpressionList extends ExpList{
	Exp exp;
	ExpList expList;
	
	NonEmptyExpressionList(Exp e, ExpList el){
		exp = e;
		expList = el;
	}
	
	void printParseTree(String indent){
		String indent1 = indent + " ";
		
		exp.printParseTree(indent1);
		expList.printParseTree(indent1);
		
	}
}
