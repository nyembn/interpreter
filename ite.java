import java.util.*;

class ite extends Exp{

	Exp e1;
	Exp e2;
	Exp e3;
	
	ite(Exp ie, te, ee){
		e1 = ie;
		e2 = te;
		e3 = ee;
	}
	
	void printParseTree(String indent){
		String indent1 = indent + " ";
		
		e1.printParseTree(indent1);
		e2.printParseTree(indent1);
		e3.printParseTree(indent1);
	}
}
