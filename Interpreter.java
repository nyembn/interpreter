import java.util.*;

public abstract class Interpreter extends Parser
{
	public static void main(String argv[])
	
	/* 
	   argv[0]: source program file containing function definitions
	   argv[1]: lexical/syntactical error messages for the source program in argv[0]
	   argv[2]: single expression to be evaluated
	   argv[3]: lexical/syntactical error messages for the expression in argv[2]
	 
	   The evaluation result and runtime errors will be displayed on the terminal.
	*/
	
	{
		/*setIO( argv[0], argv[1] );
		//setLex();
		
		getToken();
		FunDefList funDefList = funDefList();
		if ( ! t.isEmpty() )
			errorMsg(0);
		else if ( ! errorFound )
		{
			closeIO();
	*/
			setIO( argv[0], argv[1] );
			getToken();
			Exp exp = exp();
			if ( ! t.isEmpty() )
				displayln(t + "  -- unexpected symbol");
			else if ( ! errorFound )
			{
				Val v = exp.Eval(new HashMap<String,Val>());  // evaluate the given expression
				if ( v != null )
					System.out.println( v.toString() );   // display the value on the terminal
			}

			closeIO();
	}
}
