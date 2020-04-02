import java.util.*;

class FunExp extends Exp{
	FunOp fp;
	ExpList el;
	
	FunExp(FunOp f, ExpList e){
		fp = f;
		el = e;
	}
	
	void printParseTree(String indent){
		String indent1 = indent + " ";
		
		fp.printParseTree(indent1);
		el.printParseTree(indent1);
	}

}

