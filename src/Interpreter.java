import java.util.*;

public abstract class Interpreter extends Parser
{
	public static void main(String argv[])
	
	/* 
	   argv[0]: single expression to be evaluated
	   argv[1]: lexical/syntactical error messages for the expression in argv[2]
	 
	   The evaluation result and runtime errors will be displayed on the terminal.
	*/
	
	{
			setIO( argv[0], argv[1] );
			getToken();
			Exp exp = exp();
			// so exp will finish parsing expressions
			// anything leftover is unexpected
			if ( ! t.isEmpty() )
				displayln(t + "  -- unexpected symbol");
			else
				if ( ! syntaxErrorFound )
			{
				Val v = exp.Eval(new HashMap<String,Val>());  // evaluate the given expression
				if ( v != null )
					System.out.println( v.toString() );   // display the value on the terminal
			}
		
		closeIO();
		
		}				
}
