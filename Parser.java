/**

This class is a top-down, recursive-descent parser for the following syntactic categories:

 ⟨fun def list⟩ → ⟨fun def⟩ | ⟨fun def⟩ ⟨fun def list⟩
⟨fun def⟩ → ⟨header⟩ "{" ⟨exp⟩ "}"
⟨header⟩ → ⟨fun name⟩ ⟨parameter list⟩
⟨fun name⟩ → ⟨id⟩
⟨parameter list⟩ → ε | ⟨id⟩ ⟨parameter list⟩
⟨exp⟩ → ⟨id⟩ | ⟨int⟩ | ⟨float⟩ | ⟨floatE⟩ | ⟨floatF⟩ | "nil" | "(" ⟨fun exp⟩ ")" | "if" ⟨exp⟩ "then" ⟨exp⟩ "else" ⟨exp⟩
⟨fun exp⟩ → ⟨fun op⟩ ⟨exp list⟩
⟨fun op⟩ → ⟨id⟩ | "pair" | "first" | "second" | ⟨arith op⟩ | ⟨bool op⟩ | ⟨comp op⟩
⟨arith op⟩ → + | − | * | /
⟨bool op⟩ → "or" | "and" | "not"
⟨comp op⟩ → "<" | "<=" | ">" | ">=" | "="
⟨exp list⟩ → ε | ⟨exp⟩ ⟨exp list⟩

The definitions of the tokens are given in the lexical analyzer class file "LexAnalyzer.java". 

The following variables/functions of "IO"/"LexArithArray" classes are used:

static void display(String s)
static void displayln(String s)
static void setIO(String inFile, String outFile)
static void closeIO()

static String t // holds an extracted token
static State state // the current state of the finite automaton
static int getToken() // extracts the next token

An explicit parse tree is constructed in the form of nested class objects.
 
The main function will display the parse tree in linearly indented form.
Each syntactic category name labeling a node is displayed on a separate line, 
prefixed with the integer i representing the node's depth and indented by i blanks. 

**/


public abstract class Parser extends LexAnalyzer
{
	static boolean errorFound = false;

	//m token before you call before you return
	//m bubble down bubble up
	public static FunDefList funDefList(){
	
	// ⟨fun def list⟩ → ⟨fun def⟩ | ⟨fun def⟩ ⟨fun def list⟩
		// it has token from main
		FunDef funDef = funDef();
		// if next token is identifier when function definition ends then its a
		// function definition list
		if ( state == State.Id ) 
		{
			FunDefList funDefList = funDefList();
			return new MultipleFunction(funDef, funDefList);
		}
		else
			return funDef;
	}
	
	public static FunDef funDef(){
	// ⟨fun def⟩ → ⟨header⟩ "{" ⟨exp⟩ "}"
		// header must be n identifier
		//focus on token processing and parsing
		// DO YOU WANT TO CALL HEADER HERE
		//if(state == State.Id){
		Header header = header();
		
		if(state == State.LBrace){
			//token from pREMETER LIST OR FUNNAME
			getToken();
			Exp exp = exp();
			if(state == State.RBrace){
				getToken(); // need token for fundefList
				return new FunDef(header, exp);
			}
		
			else{
				errorMsg(7);
				return null;
			}
		}
		
		else{
			errorMsg(6);
			return null;
			}	
	}
	
	public static Header header(){
		if ( state == State.Id ){
			FunName fname = funName();
			// token from funname so don't need
			ParameterList pl = parameterList();
			//token from PL so don;t need
			return new Header(fname, pl);
		}
		
		else{
			errorMsg(5);
			return null;
		}
	}
	
	public static FunName funName(){
		FunName funName = new FunName(t);
		getToken();
		return funName;
	}

	
	public static ParameterList parameterList(){
		if(state == State.Id){// token from header available
			String id = t;
			getToken();
			ParameterList pList = parameterList();
			return new NonEmptyParameterList(id, pList);
		}
		else if(state == State.LBrace)
				return new EmptyParameterList();
		else{
			errorMsg(8);
			return null;
			}
	}
	
	public static Exp exp(){
		switch ( state )
		{
			case Id:
										
				Id id = new Id(t);
				getToken();
				return id;
			
			case Int:

				Int intExp = new Int(Integer.parseInt(t));
				getToken();
				return intExp; // object of integer expression
				
			/*case Float: case FloatE:

				Floatp floatElem = new Floatp(Float.parseFloat(t));
				getToken();
				return floatElem;*/
				
			case Keyword_nil:
			
				Nil nilExp = new Nil(t);
				getToken();
				return nilExp;
				
			case LParen:
			
				getToken();
				// NEED TO BUILD ERROR CHECKING
				FunExp fe = funExp();
				if(state == State.RParen){
					getToken();
					return fe;
				}
				else{
					errorMsg(9);
					return null;
				}
				

		default:

				errorMsg(2);
				return null;
		}
		
	}
	
	public static FunOp functionOperator(){
		if(state == State.Add || state == State.Sub || state == State.Mul || state == State.Div || state == State.Lt ||
			state == State.Gt || state == State.Le || state == State.Ge || state == State.Keyword_and ||
			state == State.Keyword_or || state == State.Keyword_not || state == State.Keyword_pair ||
			state == State.Keyword_second || state == State.Keyword_first || state == State.Eq || state == State.Id)
			return new FunOp(t);
		else{
			errorMsg(1);
			return null;
			}	
	}
	
	public static FunExp funExp(){
		//getToken(); // need to get token since current is LParen
		FunOp fo = functionOperator();
		getToken();
		ExpList el = expList();
		// token is already extracted to check expList
		//getToken();
		if(state == State.RParen){
			return new FunExp(fo, el);
		}
		else{
			errorMsg(9);
			return null;
		}
	}
	
	public static ExpList expList(){
		//either empty or multiple exp
		//if state not btwn this and this error
		if(state == State.Id){
			Exp e = new Id(t);
			getToken();
			ExpList el = expList();
			return new NonEmptyExpressionList(e, el);
		}
		else if(state == State.Int){
			Exp e = new Int(Integer.parseInt(t));
			getToken();
			ExpList el = expList();
			return new NonEmptyExpressionList(e, el);
		}
		else if(state == State.Float){
			Exp e = new Floatp(Float.parseFloat(t));
			getToken();
			ExpList el = expList();
			return new NonEmptyExpressionList(e, el);
		}
		else if(state == State.Keyword_nil){
			Exp e = new Nil(t);
			getToken();
			ExpList el = expList();
			return new NonEmptyExpressionList(e, el);
		}
		else if(state == State.LParen){
			Exp e = funExp();
			getToken();
			ExpList el = expList();
			return new NonEmptyExpressionList(e, el);
		}
		else if(state == State.Keyword_if){
			Exp e = ifThenElse();
			getToken();
			ExpList el = expList();
			return new NonEmptyExpressionList(e, el);
		}
			
		else
			return new EmptyExpList();	
	}
	
	public static Exp ifThenElse(){
		return null;
	}

	
	public static void errorMsg(int i)
	{
		errorFound = true;
		
		display(t + " : Syntax Error, unexpected symbol where");

		switch( i )
		{
		case 1:	displayln(" operator or id expected"); return;
		case 2: displayln(" id, int, float, or ( expected"); return;
		case 3:	displayln(" = expected"); return;
		case 4:	displayln(" ; expected"); return;
		case 5:	displayln(" id expected"); return;
		case 6: displayln(" { expected"); return;
		case 7: displayln(" } expected"); return;
		case 8: displayln(" { or id expected"); return;
		case 9: displayln(" ) expected"); return;		
		}
	}

	public static void main(String argv[])
	{
		// argv[0]: input file containing an assignment list
		// argv[1]: output file displaying the parse tree
		
		setIO( argv[0], argv[1] );
		//setLex();

		getToken();

		FunDefList funDefList = funDefList(); //need the first token
		//AssignmentList assignmentList = assignmentList(); // build a parse tree //m FUCK ITS ON TOP
		if ( ! t.isEmpty() )
			errorMsg(5);
		else if ( ! errorFound )
			funDefList.printParseTree(""); // print the parse tree in linearly indented form in argv[1] file

		closeIO();
	}
}

