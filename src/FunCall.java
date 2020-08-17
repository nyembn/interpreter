import java.util.*;

final class FunCall extends FunExp
{
	Id func;  // identifier "func" may be a variable or a user-defined function name
	
	FunCall(Id i, ExpList e)
	{
		func = i;
		expList = e;
	}

	String getFunOp()
	{
		return func.id;
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
		int numOfParameter = 0;
		System.out.println("Entering evaluation");
		
		// ***************Check to see if valid function***************
		
		FunDef toBeEvaluated = getFunDef(func.id);
		
		if(state.containsKey(func.id))
		{
		    toBeEvaluated = getFunDef((state.get(func.id)).toString());
		}
		
		// promptly conceptualize the structure and propose a solution
		
	
		// PRECISE IMPLEMENTATION ACCORDING TO DEFINITION
		if( toBeEvaluated != null )
		{
			System.out.println("Valid function");
	    // ***************END Check to see if valid function***************
			
		// ***************Check to see if parameters matches***************
			ExpList p = expList;
			
			// empty expression at the end is not considered as parameter
			while( p instanceof NonEmptyExpList)
			{
				numOfParameter++;
				
				p = ((NonEmptyExpList)p).expList;
			}
			
			System.out.println(func.id + " has " + numOfParameter + " parameter/s.");
			
			
		// Count number of parameters on function definition
			ParameterList pl;
			int funCallParameter = 0;
			pl = toBeEvaluated.getHeader().getParameterList();
				
		while ( pl instanceof NonEmptyParameterList )
		{   
		    funCallParameter++;
			pl = ((NonEmptyParameterList)pl).parameterList;
		}
			if( numOfParameter == funCallParameter)
			    System.out.println("Parameter/s match");
			else
			    System.out.println("Parameter/s does not match");
			    
	    // ***************END Check to see if parameters matches***************
			
		
		// ***************Evaluate parameters***************
			p = expList;
			
			// Needed for identifier of variables
			pl = toBeEvaluated.getHeader().getParameterList();
			
			Val v;
			HashMap<String, Val> newFunCallState = new HashMap<String, Val>();
		    // copy the state to newFunCall state
		    for(Map.Entry<String, Val> set : state.entrySet()){
		        newFunCallState.put(set.getKey(), (set.getValue()).cloneVal());
		    }
		    //##Val vl = (state.get(n)).CloneVal();
		    //##newFunCallState.put(state);
		        	
			while( p instanceof NonEmptyExpList)
			{
				// eval each exp and put in hashmap associating with parameterlist
				// Take key string from FunDef
				// **********if exp is a parameter unary function then just create a funVal**********
				// EITHER IDENTIFIER OR FUNC ####Parsed as identifier####
				
				v = ((NonEmptyExpList)p).firstExp().Eval(newFunCallState);
				// f is in program state not in FunDefList
				// f is a pseudo for inc
				// check 2 places FunDefList and program state
			    newFunCallState.put(((NonEmptyParameterList)pl).getId(), v);
				
				// Advance expList and parameterList references
				p = ((NonEmptyExpList)p).expList;
				pl = ((NonEmptyParameterList)pl).parameterList;
			}
		// ***************END Evaluate parameters***************
			
		// Evaluate function body
			Val fv = toBeEvaluated.getExp().Eval(newFunCallState);
			
			return fv;
		}
		
		else
		{
			System.out.println(func.id + " function not defined");
			return null;
		}
		
		
	}
}
