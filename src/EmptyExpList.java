import java.util.*;

final class EmptyExpList extends ExpList
{
	Val addEval(HashMap<String,Val> state)
	{
		return new IntVal(0);
	}

	Val subEval(HashMap<String,Val> state)
	{
		return new IntVal(0);
	}

	Val mulEval(HashMap<String,Val> state)
	{
		return new IntVal(1);
	}

	Val divEval(HashMap<String,Val> state)
	{
		return new IntVal(1);
	}

	Val orEval(HashMap<String,Val> state)
	{
		return new BoolVal(false);
	}

	Val andEval(HashMap<String,Val> state)
	{
		return new BoolVal(true);
	}

	Val notEval(HashMap<String,Val> state)
	{
		System.out.println( "Error: not operator missing argument" );
		return null;
	}

	Val ltEval(HashMap<String,Val> state)
	{
		return new BoolVal(true);
	}

	Val leEval(HashMap<String,Val> state)
	{
		return new BoolVal(true);
	}

	Val gtEval(HashMap<String,Val> state)
	{
		return new BoolVal(true);
	}

	Val geEval(HashMap<String,Val> state)
	{
		return new BoolVal(true);
	}

	Val eqEval(HashMap<String,Val> state)
	{
		return new BoolVal(true);
	}

	Val pairEval(HashMap<String,Val> state)
	{
		System.out.println( "Error: pair operator missing arguments" );
		return null;
	}

	Val firstEval(HashMap<String,Val> state)
	{
		System.out.println( "Error: first operator missing argument" );
		return null;
	}

	Val secondEval(HashMap<String,Val> state)
	{
		System.out.println( "Error: second operator missing argument" );
		return null;
	}
}
