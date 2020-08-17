import java.util.*;

final class NonEmptyExpList extends ExpList
{
	Exp exp;
	ExpList expList;
	
	NonEmptyExpList(Exp e, ExpList el){
		exp = e;
		expList = el;
	}
	// Don't need print parse tree since each exp has print parse tree
	
	Exp firstExp()
	{
		return exp;
	}
	
	Exp secondExp()
	{
		return ((NonEmptyExpList)expList).firstExp();
	}
	
	ExpList tailExpList()
	{
		return expList;
	}
	
	Val addEval(HashMap<String, Val> state)
	{	
		// No exp on emptyExpList
		Val eVal = exp.Eval(state);
		Val eListVal = expList.addEval(state);
		if ( eVal == null || eListVal == null )
			return null;
		if ( ! eVal.isNumber() )
		{
			System.out.println( "Error: + operator cannot be applied to " + eVal );
			return null;
		}
		
	// The result will be float if one or both of the arguments are float.
		
		Class eClass = eVal.getClass();
		Class eListClass = eListVal.getClass();
		
	// Adding the val components
	if ( eClass == IntVal.class && eListClass == IntVal.class )
		{
			((IntVal)eVal).val = ((IntVal)eVal).val + ((IntVal)eListVal).val;
			return eVal;
		}
	else if ( eClass == IntVal.class && eListClass == FloatVal.class )
		{
			((FloatVal)eListVal).val = ((IntVal)eVal).val + ((FloatVal)eListVal).val;
			return eListVal;
		}
		else if ( eClass == FloatVal.class && eListClass == IntVal.class )
		{
			((FloatVal)eVal).val = ((FloatVal)eVal).val + ((IntVal)eListVal).val;
			return eVal;
		}
		else // ( eClass == FloatVal.class && eListClass == FloatVal.class )
		{
			((FloatVal)eVal).val = ((FloatVal)eVal).val + ((FloatVal)eListVal).val;
			return eVal;
		}
	}
	
	Val subEval(HashMap<String,Val> state)
	{
		Val eVal = exp.Eval(state);
		Val eListVal = expList.subEval(state);
		if ( eVal == null || eListVal == null )
			return null;
		if ( ! eVal.isNumber() )
		{
			System.out.println( "Error: - operator cannot be applied to " + eVal );
			return null;
		}

		// The result will be float if one or both of the arguments are float.
		
		Class eClass = eVal.getClass();
		Class eListClass = eListVal.getClass();
		
		if ( eClass == IntVal.class && eListClass == IntVal.class )
		{
			((IntVal)eVal).val = ((IntVal)eVal).val - ((IntVal)eListVal).val;
			return eVal;
		}
		else if ( eClass == IntVal.class && eListClass == FloatVal.class )
		{
			((FloatVal)eListVal).val = ((IntVal)eVal).val - ((FloatVal)eListVal).val;
			return eListVal;
		}
		else if ( eClass == FloatVal.class && eListClass == IntVal.class )
		{
			((FloatVal)eVal).val = ((FloatVal)eVal).val - ((IntVal)eListVal).val;
			return eVal;
		}
		else // ( eClass == FloatVal.class && eListClass == FloatVal.class )
		{
			((FloatVal)eVal).val = ((FloatVal)eVal).val - ((FloatVal)eListVal).val;
			return eVal;
		}
	}
	
	Val mulEval(HashMap<String,Val> state)
	{
		Val eVal = exp.Eval(state);
		Val eListVal = expList.mulEval(state);
		if ( eVal == null || eListVal == null )
			return null;
		if ( ! eVal.isNumber() )
		{
			System.out.println( "Error: * operator cannot be applied to " + eVal );
			return null;
		}

		// The result will be float if one or both of the arguments are float.
		
		Class eClass = eVal.getClass();
		Class eListClass = eListVal.getClass();
		
		if ( eClass == IntVal.class && eListClass == IntVal.class )
		{
			((IntVal)eVal).val = ((IntVal)eVal).val * ((IntVal)eListVal).val;
			return eVal;
		}
		else if ( eClass == IntVal.class && eListClass == FloatVal.class )
		{
			((FloatVal)eListVal).val = ((IntVal)eVal).val * ((FloatVal)eListVal).val;
			return eListVal;
		}
		else if ( eClass == FloatVal.class && eListClass == IntVal.class )
		{
			((FloatVal)eVal).val = ((FloatVal)eVal).val * ((IntVal)eListVal).val;
			return eVal;
		}
		else // ( eClass == FloatVal.class && eListClass == FloatVal.class )
		{
			((FloatVal)eVal).val = ((FloatVal)eVal).val * ((FloatVal)eListVal).val;
			return eVal;
		}
	}

	Val divEval(HashMap<String,Val> state)
	{
		Val eVal = exp.Eval(state);
		Val eListVal = expList.divEval(state);
		if ( eVal == null || eListVal == null )
			return null;
		if ( ! eVal.isNumber() )
		{
			System.out.println( "Error: / operator cannot be applied to " + eVal );
			return null;
		}

		// The result will be float if one or both of the arguments are float.
		
		Class eClass = eVal.getClass();
		Class eListClass = eListVal.getClass();
		
		if ( eClass == IntVal.class && eListClass == IntVal.class )
		{
			int elistVal = ((IntVal)eListVal).val;
			if ( elistVal == 0 )
			{
				System.out.println("Error: integer division by 0");
				return null;
			}
			((IntVal)eVal).val = ((IntVal)eVal).val / elistVal;
			return eVal;
		}
		else if ( eClass == IntVal.class && eListClass == FloatVal.class )
		{
			((FloatVal)eListVal).val = ((IntVal)eVal).val / ((FloatVal)eListVal).val;
			return eListVal;
		}
		else if ( eClass == FloatVal.class && eListClass == IntVal.class )
		{
			((FloatVal)eVal).val = ((FloatVal)eVal).val / ((IntVal)eListVal).val;
			return eVal;
		}
		else // ( eClass == FloatVal.class && eListClass == FloatVal.class )
		{
			((FloatVal)eVal).val = ((FloatVal)eVal).val / ((FloatVal)eListVal).val;
			return eVal;
		}
	}
	
	Val orEval(HashMap<String, Val> state)
	{
		Val eVal = exp.Eval(state);
		Val eListVal = expList.orEval(state);
		
		if ( eVal == null || eListVal == null )
			return null;
		if ( !(eVal instanceof BoolVal) )
		{
			System.out.println( "Error: or operator cannot be applied to " + eVal );
			return null;
		}

		((BoolVal)eVal).val = ((BoolVal)eVal).val || ((BoolVal)eListVal).val;
		return eVal;
	}
		
	Val andEval(HashMap<String,Val> state)
	{
		Val eVal = exp.Eval(state);
		Val eListVal = expList.andEval(state);
		if ( eVal == null || eListVal == null )
			return null;
		if ( !(eVal instanceof BoolVal) )
		{
			System.out.println( "Error: and operator cannot be applied to " + eVal );
			return null;
		}

		((BoolVal)eVal).val = ((BoolVal)eVal).val && ((BoolVal)eListVal).val;
		return eVal;
	}

	Val notEval(HashMap<String,Val> state)
	{
		Val eVal = exp.Eval(state);
		if ( eVal == null )
			return null;
		if ( !(eVal instanceof BoolVal) )
		{
			System.out.println( "Error: not operator cannot be applied to " + eVal );
			return null;
		}

		((BoolVal)eVal).val = !((BoolVal)eVal).val;
		return eVal;
	}

	Val ltEval(HashMap<String,Val> state)
	{
		Exp head = exp;
		ExpList tail = expList;
		Val e1Val = head.Eval(state);
		if ( e1Val == null )
			return null;
		if ( ! e1Val.isNumber() )
		{
			System.out.println( "Error: < operator cannot be applied to " + e1Val );
			return null;
		}
		boolean b = true;
		while ( tail instanceof NonEmptyExpList )
		{	
			// Verify the the tail exp
			
			Val e2Val = ((NonEmptyExpList)tail).firstExp().Eval(state);
			if ( e2Val == null )
				return null;
			if ( ! e2Val.isNumber() )
			{
				System.out.println( "Error: < operator cannot be applied to " + e2Val );
				return null;
			}
			
			// Do comparison
			
			boolean b1;
			if ( e1Val.getClass() == IntVal.class && e2Val.getClass() == IntVal.class )
				b1 = ((IntVal)e1Val).val < ((IntVal)e2Val).val;
			else
				b1 = e1Val.floatVal() < e2Val.floatVal();
			
			// AND with evaluation of last expression
			 
			b = b && b1;
			e1Val = e2Val;
			
			// Move tail pointer
			
			tail = ((NonEmptyExpList)tail).tailExpList();
		}
		if ( b )
			return new BoolVal(true);
		else
			return new BoolVal(false);
	}

	Val leEval(HashMap<String,Val> state)
	{
		Exp head = exp;
		ExpList tail = expList;
		Val e1Val = head.Eval(state);
		if ( e1Val == null )
			return null;
		if ( ! e1Val.isNumber() )
		{
			System.out.println( "Error: <= operator cannot be applied to " + e1Val );
			return null;
		}
		boolean b = true;
		while ( tail instanceof NonEmptyExpList )
		{
			Val e2Val = ((NonEmptyExpList)tail).firstExp().Eval(state);
			if ( e2Val == null )
				return null;
			if ( ! e2Val.isNumber() )
			{
				System.out.println( "Error: <= operator cannot be applied to " + e2Val );
				return null;
			}
			boolean b1;
			if ( e1Val.getClass() == IntVal.class && e2Val.getClass() == IntVal.class )
				b1 = ((IntVal)e1Val).val <= ((IntVal)e2Val).val;
			else
				b1 = e1Val.floatVal() <= e2Val.floatVal();

			b = b && b1;
			e1Val = e2Val;
			tail = ((NonEmptyExpList)tail).tailExpList();
		}
		if ( b )
			return new BoolVal(true);
		else
			return new BoolVal(false);
	}

	Val gtEval(HashMap<String,Val> state)
	{
		Exp head = exp;
		ExpList tail = expList;
		Val e1Val = head.Eval(state);
		if ( e1Val == null )
			return null;
		if ( ! e1Val.isNumber() )
		{
			System.out.println( "Error: > operator cannot be applied to " + e1Val );
			return null;
		}
		boolean b = true;
		while ( tail instanceof NonEmptyExpList )
		{
			Val e2Val = ((NonEmptyExpList)tail).firstExp().Eval(state);
			if ( e2Val == null )
				return null;
			if ( ! e2Val.isNumber() )
			{
				System.out.println( "Error: > operator cannot be applied to " + e2Val );
				return null;
			}
			boolean b1;
			if ( e1Val.getClass() == IntVal.class && e2Val.getClass() == IntVal.class )
				b1 = ((IntVal)e1Val).val > ((IntVal)e2Val).val;
			else
				b1 = e1Val.floatVal() > e2Val.floatVal();

			b = b && b1;
			e1Val = e2Val;
			tail = ((NonEmptyExpList)tail).tailExpList();
		}
		if ( b )
			return new BoolVal(true);
		else
			return new BoolVal(false);
	}

	Val geEval(HashMap<String,Val> state)
	{
		Exp head = exp;
		ExpList tail = expList;
		Val e1Val = head.Eval(state);
		if ( e1Val == null )
			return null;
		if ( ! e1Val.isNumber() )
		{
			System.out.println( "Error: >= operator cannot be applied to " + e1Val );
			return null;
		}
		boolean b = true;
		while ( tail instanceof NonEmptyExpList )
		{
			Val e2Val = ((NonEmptyExpList)tail).firstExp().Eval(state);
			if ( e2Val == null )
				return null;
			if ( ! e2Val.isNumber() )
			{
				System.out.println( "Error: >= operator cannot be applied to " + e2Val );
				return null;
			}
			boolean b1;
			if ( e1Val.getClass() == IntVal.class && e2Val.getClass() == IntVal.class )
				b1 = ((IntVal)e1Val).val >= ((IntVal)e2Val).val;
			else
				b1 = e1Val.floatVal() >= e2Val.floatVal();

			b = b && b1;
			e1Val = e2Val;
			tail = ((NonEmptyExpList)tail).tailExpList();
		}
		if ( b )
			return new BoolVal(true);
		else
			return new BoolVal(false);
	}

	Val eqEval(HashMap<String,Val> state)
	{
		Exp head = exp;
		ExpList tail = expList;
		Val e1Val = head.Eval(state);
		if ( e1Val == null )
			return null;
		boolean b = true;
		while ( tail instanceof NonEmptyExpList )
		{
			Val e2Val = ((NonEmptyExpList)tail).firstExp().Eval(state);
			if ( e2Val == null )
				return null;
			boolean b1 = equalVal(e1Val, e2Val);
			b = b && b1;
			e1Val = e2Val;
			tail = ((NonEmptyExpList)tail).tailExpList();
		}
		if ( b )
			return new BoolVal(true);
		else
			return new BoolVal(false);
	}

	static boolean equalVal(Val e1Val, Val e2Val)
	{
		Class e1Class = e1Val.getClass();
		Class e2Class = e2Val.getClass();
		
		if ( e1Class == NilVal.class && e2Class == NilVal.class )
			return true;

		if ( e1Class == PairVal.class && e2Class == PairVal.class )
			return equalPairVal((PairVal)e1Val, (PairVal)e2Val);

		if ( e1Val.isNumber() && e2Val.isNumber() )
		{
			if ( e1Class == IntVal.class && e2Class == IntVal.class )
				return ((IntVal)e1Val).val == ((IntVal)e2Val).val;
			else
				return e1Val.floatVal() == e2Val.floatVal();
		}

		if ( e1Class == BoolVal.class && e2Class == BoolVal.class )
			return ((BoolVal)e1Val).val == ((BoolVal)e2Val).val;

		/*if ( e1Class == FunVal.class && e2Class == FunVal.class )
			return ((FunVal)e1Val).funName.equals(((FunVal)e2Val).funName);*/

		return false;
	}

	static boolean equalPairVal(PairVal p1Val, PairVal p2Val)
	{
		return equalVal(p1Val.first, p2Val.first) && equalVal(p1Val.second, p2Val.second);
	}

	// PAIR EVALUATION

	Val pairEval(HashMap<String,Val> state)
	{
		if ( expList instanceof EmptyExpList )
		{
			System.out.println( "Error: pair operator missing 2nd argument" );
			return null;
		}
		Val firstVal = exp.Eval(state);
		Val secondVal = ((NonEmptyExpList)expList).firstExp().Eval(state);
		if ( firstVal == null || secondVal == null )
			return null;

		return new PairVal(firstVal, secondVal);
	}

	Val firstEval(HashMap<String,Val> state)
	{
		Val eVal = exp.Eval(state);
		
		// Only if expression is a PairVal
		if ( eVal == null )
			return null;
		if ( eVal instanceof PairVal )
			return ((PairVal)eVal).first;
		else
		{
			System.out.println( "Error: first operator cannot be applied to " + eVal );
			return null;	
		}
	}
	
	Val secondEval(HashMap<String,Val> state)
	{
		Val eVal = exp.Eval(state);
		if ( eVal == null )
			return null;
		if ( eVal instanceof PairVal )
			return ((PairVal)eVal).second;
		else
		{
			System.out.println( "Error: second operator cannot be applied to " + eVal );
			return null;	
		}
	
	}
}
