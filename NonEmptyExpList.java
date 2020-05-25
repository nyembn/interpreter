class NonEmptyExpList extends ExpList
{
	Exp exp;
	ExpList expList;
	
	NonEmptyExpList(Exp e, ExpList el){
		exp = e;
		expList = el;
	}
	// Don't need print parse tree since each exp has print parse tree
}
