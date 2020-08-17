import java.util.*;

final class Id extends Exp
{
	String id;

	Id(String ident)
	{
		id = ident;
	}

	void printParseTree(String indent)
	{	String indent1 = indent + " ";
	
		IO.displayln(indent + indent.length() + " <exp>");
		IO.displayln(indent1 + indent1.length() + " " + id);
	}
	
	FunDef getFunDef(String name)
	{	
		FunDefList p = Interpreter.funDefList;
		
		while ( p instanceof MultipleFunction )
		{
		
		if(name.equals((((MultipleFunction)p).getFunDef().getHeader().getFunName()))){
		        
				return ((MultipleFunction)p).getFunDef();
			}
				
			p = ((MultipleFunction)p).funDefList;
		}
		
		// Code below for the last FunDef 
		if(name.equals(((FunDef)p).getHeader().getFunName()))
			return ((FunDef)p);
		
		return null;
	}
	
	
	
	Val Eval(HashMap<String,Val> state)
	{
		FunDef toBeEvaluated = getFunDef(id);
		FunDef p = toBeEvaluated;
		
		if(state.containsKey(id))
		{	// Can also do it in one statement
			// return state.get(id);
			//Val idVal = state.get(id);
			return state.get(id);
		}
		
		
		else if(toBeEvaluated != null)
		{
		    return new FunVal(id);
		}
	
		else
			System.out.println("Invalid identifier");
		return null;
	}
}
