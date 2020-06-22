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
		
		super.printParseTree(indent);
		
		String indent1 = indent+" ";
		String indent2 = indent1+" ";
		
		IO.displayln(indent1 + indent1.length() + " if");		
		ie.printParseTree(indent2);
		IO.displayln(indent1 + indent1.length() + " then");
		te.printParseTree(indent2);
		IO.displayln(indent1 + indent1.length() + " else");
		ee.printParseTree(indent2);
	}
	
	Val Eval(HashMap<String,Val> state)
	{
		Val boolVal = ie.Eval(state);
		if ( boolVal == null )
			return null;
		if ( !(boolVal instanceof BoolVal) )
		{
			System.out.println( "Error: boolean condition of if-then-else evaluated to non-boolean value: " + boolVal );
			return null;
		}
		if ( ((BoolVal)boolVal).val  )
			return te.Eval(state);
		else
			return ee.Eval(state);
	}
}
