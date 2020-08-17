// Value objects computed and returned by Eval function.
// The runtime error value is implemented by null.

abstract class Val
{
	/*
	The function cloneVal() is used to ----evaluate objects of Id class----.
	Since the objects of NilVal, PairVal, FunVal classes are treated as reference-type objects,
	their cloneVal() functions are identity functions simply returning "this" target object.
	*/

	abstract Val cloneVal();
	abstract float floatVal(); // conversion to floating-point
	abstract boolean isNumber();
	abstract boolean isZero();
}
