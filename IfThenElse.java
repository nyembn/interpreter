import java.util.*;

class IfThenElse extends Exp{

	Exp ie; // can be any of the expression type
	Exp te;
	Exp ee;
	
	IfThenElse(Exp e1, Exp e2, Exp e3){
		ie = e1;
		te = e2;
		ee = e3;
	}
	
	void printParseTree(String indent){
		String indent1 = indent + " ";
		
		ie.printParseTree(indent1);
		te.printParseTree(indent1);
		ee.printParseTree(indent1);
	}
}
