import java.util.*;

/* Its abstract a function expression is either of the
	function expressions */
	
abstract class FunExp extends Exp{

	ExpList expList; //either empty or nonempty el
	
	abstract String getFunOp();
	
	void printParseTree(String indent)
	{
		super.printParseTree(indent);
		String indent1 = indent+" ";
		IO.displayln(indent1 + indent1.length() + " <fun exp>");

		String indent2 = indent1+" ";
		IO.displayln(indent2 + indent2.length() + " " + getFunOp());
		IO.displayln(indent2 + indent2.length() + " <exp list>");

		String indent3 = indent2+" ";

		ExpList p = expList;
		while ( p instanceof NonEmptyExpList )
		{
			// Print the parse tree for the current expression and get the exp list associated with it
			((NonEmptyExpList)p).exp.printParseTree(indent3);			
			p = ((NonEmptyExpList)p).expList;	
		}
	}
	
	abstract Val Eval(HashMap<String,Val> state);

}

