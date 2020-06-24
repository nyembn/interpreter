/**
 
This class is a lexical analyzer for the tokens defined by the grammar:

⟨letter⟩ → a | b | ... | z | A | B | ... | Z
⟨digit⟩ → 0 | 1 | ... | 9
⟨id⟩ → ⟨letter⟩ {⟨letter⟩ | ⟨digit⟩}
⟨int⟩ → [+|−] {⟨digit⟩}+
⟨float⟩ → [+|−] ( {⟨digit⟩}+ "." {⟨digit⟩}  |  "." {⟨digit⟩}+ )
⟨floatE⟩ → (⟨int⟩ | ⟨float⟩) (e|E) [+|−] {⟨digit⟩}+
⟨floatF⟩ → (⟨int⟩ | ⟨float⟩ | ⟨floatE⟩) ("f" | "F")
⟨add⟩ → +
⟨sub⟩ → −
⟨mul⟩ → *
⟨div⟩ → /
⟨lt⟩ → <
⟨le⟩ → "<="
⟨gt⟩ → >
⟨ge⟩ → ">="
⟨eq⟩ → =
⟨LParen⟩ → (
⟨RParen⟩ → )
⟨LBrace⟩ → {
⟨RBrace⟩ → }

This class implements a DFA that will accept the above tokens.

The DFA states are represented by the Enum type "State".
The DFA has the following 28 final states represented by enum-type literals:

state     token accepted

Id        identifiers
Int       integers
Float     floats without exponentiation part
FloatE    floats with exponentiation part
Add      +
Sub     -
Mul     *
Div       /
LParen    (
RParen    )
LBrace,		{
RBrace,		}
Lt,			<
Le,			<=
Gt,			>
Ge,			>=
Eq,			=
FloatF,		123f or 123F
Keyword_if,		if
Keyword_then,	then
Keyword_else,	else
Keyword_or,		or
Keyword_and,	and
Keyword_not,	not
Keyword_pair,	pair
Keyword_first,	first
Keyword_second,	second
Keyword_nil,	nil
		

The DFA also uses the following 4 non-final states:

state      string recognized

Start      the empty string
Dot			float parts ending with "."
E          float parts ending with E or e
EPlusMinus float parts ending with + or - in exponentiation part

The function "driver" operates the DFA. 
The function "nextState" returns the next state given the current state and the input character.


**/


public abstract class LexAnalyzer extends IO
{
	public enum State 
       	{ 
	  // non-final states     ordinal number

		Start,             // 0
		Dot,            // 1
		E,                 // 2
		EPlusMinus,        // 3

	  // final states

		Id,                // 4
		Int,               // 5
		Float,             // 6
		FloatE,            // 7
		FloatF,	//8
		Add,              // 9
		Sub,             // 10
		Mul,             // 11
		Div,               // 12
		LParen,            // 13
		RParen,            // 14
		LBrace,				//15
		RBrace,			//16
		Lt,		//17
		Le,		//18
		Gt,		//19
		Ge,		//20
		Eq,		//21
		Keyword_if,		//22
		Keyword_then,	//23
		Keyword_else,	//24
		Keyword_or,		//25
		Keyword_and,		//26
		Keyword_not,		//27
		Keyword_pair,	//28
		Keyword_first,	//29
		Keyword_second,	//30
		Keyword_nil,		//31
		

		UNDEF;

		private boolean isFinal()
		{
			return ( this.compareTo(State.Id) >= 0 );  
		}
		
		boolean isArithOp()
	{
		return this.compareTo(Div) <= 0;
	}

	boolean isCompOp()
	{
		return this.compareTo(Lt) >= 0 && this.compareTo(Eq) <= 0;
	}

	boolean isBoolOp()
	{
		return this.compareTo(Keyword_or) >= 0 && this.compareTo(Keyword_not) <= 0;
	}

	boolean isPairOp()
	{
		return this.compareTo(Keyword_pair) >= 0 && this.compareTo(Keyword_second) <= 0;
	}
		
	}

	// By enumerating the non-final states first and then the final states,
	// test for a final state can be done by testing if the state's ordinal number
	// is greater than or equal to that of Id.

	// The following variables of "IO" class are used:

	//   static int a; the current input character
	//   static char c; used to convert the variable "a" to the char type whenever necessary

	public static String t; // holds an extracted token
	public static State state; // the current state of the FA

	private static int driver()

	// This is the driver of the FA. 
	// If a valid token is found, assigns it to "t" and returns 1.
	// If an invalid token is found, assigns it to "t" and returns 0.
	// If end-of-stream is reached without finding any non-whitespace character, returns -1.

	{
		State nextSt; // the next state of the FA

		t = "";
		String[] keyWord = { "if", "then", "else", "or", "and", "not", "pair", "first", "second", "nil" };
		state = State.Start;

		if ( Character.isWhitespace((char) a) )
			a = getChar(); // get the next non-whitespace character
		if ( a == -1 ) // end-of-stream is reached
			return -1;

		while ( a != -1 ) // do the body if "a" is not end-of-stream
		{
			c = (char) a;
			State[] arrayStates = State.values(); //array of states
			nextSt = nextState( state, c );
			if ( nextSt == State.UNDEF ) // The FA will halt.
			{	// loop through array of string keyword to see if token is a keyword
				if ( state.isFinal() ){
					for(int i=0; i < keyWord.length; i++){
						if (keyWord[i].equals(t)){
							state = arrayStates[i+22]; // relate index with the ordinal number
							return 1;
						}
					}
				return 1;// valid token extracted
				}
				else // "c" is an unexpected character
				{
					t = t+c;
					a = getNextChar();
					return 0; // invalid token found
				}
			}
			else // The FA will go on.
			{
				state = nextSt;
				t = t+c;
				a = getNextChar();
			}
		}

		// end-of-stream is reached while a token is being extracted

		if ( state.isFinal() )
			return 1; // valid token extracted
		else
			return 0; // invalid token found
	} // end driver

	public static void getToken()

	// Extract the next token using the driver of the FA.
	// If an invalid token is found, issue an error message.

	{
		int i = driver();
		if ( i == 0 )
			displayln(t + " : Lexical Error, invalid token");
	}

	private static State nextState(State s, char c)

	// Returns the next state of the FA given the current state and input char;
	// if the next state is undefined, UNDEF is returned.

	{
		switch( state )
		{
		case Start:
			if ( Character.isLetter(c) )
				return State.Id;
			else if ( Character.isDigit(c) )
				return State.Int;
			else if ( c == '+' )
				return State.Add;
			else if ( c == '-' )
				return State.Sub;
			else if ( c == '*' )
				return State.Mul;
			else if ( c == '/' )
				return State.Div;
			else if ( c == '(' )
				return State.LParen;
			else if ( c == ')' )
				return State.RParen;
			else if ( c == '{' )
				return State.LBrace;
			else if ( c == '}' )
				return State.RBrace;
			else if ( c == '<' )
				return State.Lt;
			else if ( c == '>' )
				return State.Gt;
			else if ( c == '=' )
				return State.Eq;
			else if ( c == '.' )
				return State.Dot;
			else
				return State.UNDEF;
		case Lt:
			if( c == '=' )
				return State.Le;
			else
				return State.UNDEF;
		case Gt:
			if ( c == '=' )
				return State.Ge;
			else
				return State.UNDEF;
		case Id:
			if ( Character.isLetterOrDigit(c) )
				return State.Id;
			else
				return State.UNDEF;
		case Int:
			if ( Character.isDigit(c) )
				return State.Int;
			else if ( c == '.' )
				return State.Float;
			
			else if ( c == 'f' || c == 'F' )
				return State.FloatF;
			else if ( c == 'e' || c == 'E' )
				return State.E;
			else
				return State.UNDEF;
		case Dot:
			if ( Character.isDigit(c) )
				return State.Float;
			else
				return State.UNDEF;
		case Float:
			if ( Character.isDigit(c) )
				return State.Float;
			else if ( c == 'e' || c == 'E' )
				return State.E;
			else if ( c == 'f' || c == 'F' )
				return State.FloatF;
			else
				return State.UNDEF;
		case E:
			if ( Character.isDigit(c) )
				return State.FloatE;
			else if ( c == '+' || c == '-' )
				return State.EPlusMinus;
			else
				return State.UNDEF;
		case EPlusMinus:
			if ( Character.isDigit(c) )
				return State.FloatE;
			else
				return State.UNDEF;
		case FloatE:
			if ( Character.isDigit(c) )
				return State.FloatE;
			else if ( c == 'f' || c == 'F' )
				return State.FloatF;
			else
				return State.UNDEF;
		
		case Add:
			if ( Character.isDigit(c) )
				return State.Int;
			else if ( c == '.' )
				return State.Dot;
			else
				return State.UNDEF;
		case Sub:
			if ( Character.isDigit(c) )
				return State.Int;
			else if ( c == '.' )
				return State.Dot;
			else
				return State.UNDEF;
		case Keyword_if:
			if ( Character.isLetterOrDigit(c) )
				return State.Id;
			else
				return State.UNDEF;
		case Keyword_then:
			if ( Character.isLetterOrDigit(c) )
				return State.Id;
			else
				return State.UNDEF;
		case Keyword_else:
			if ( Character.isLetterOrDigit(c) )
				return State.Id;
			else
				return State.UNDEF;
		case Keyword_or:
			if ( Character.isLetterOrDigit(c) )
				return State.Id;
			else
				return State.UNDEF;
		case Keyword_and:
			if ( Character.isLetterOrDigit(c) )
				return State.Id;
			else
				return State.UNDEF;
		case Keyword_not:
			if ( Character.isLetterOrDigit(c) )
				return State.Id;
			else
				return State.UNDEF;
		case Keyword_pair:
			if ( Character.isLetterOrDigit(c) )
				return State.Id;
			else
				return State.UNDEF;
		case Keyword_first:
			if ( Character.isLetterOrDigit(c) )
				return State.Id;
			else
				return State.UNDEF;
		case Keyword_second:
			if ( Character.isLetterOrDigit(c) )
				return State.Id;
			else
				return State.UNDEF;
		case Keyword_nil:
			if ( Character.isLetterOrDigit(c) )
				return State.Id;
			else
				return State.UNDEF;
		default:
			return State.UNDEF;
		}
	} // end nextState
/*
	public static void main(String argv[])

	{		
		// argv[0]: input file containing source code using tokens defined above
		// argv[1]: output file displaying a list of the tokens 

		setIO( argv[0], argv[1] );
		
		int i;

		while ( a != -1 ) // while "a" is not end-of-stream
		{
			i = driver(); // extract the next token
			if ( i == 1 )
				displayln( t+"   : "+state.toString() );
			else if ( i == 0 )
				displayln( t+" : Lexical Error, invalid token");
		} 

		closeIO();
	}
	*/
} 

