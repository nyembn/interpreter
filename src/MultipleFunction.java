import java.util.*;

class MultipleFunction extends FunDefList
{
	FunDef funDef;
	FunDefList funDefList;

	MultipleFunction(FunDef fd, FunDefList fdl)
	{
		funDef = fd;
		funDefList = fdl;
	}
 
	void printParseTree(String indent)
	{		
		funDef.printParseTree(indent);
		funDefList.printParseTree(indent);
	}
	
	FunDef getFunDef()
	{
		return funDef;
	}
}

