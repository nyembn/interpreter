import java.util.*;

abstract class ExpList
{
	abstract Val addEval(HashMap<String,Val> state);
	abstract Val subEval(HashMap<String,Val> state);
	abstract Val mulEval(HashMap<String,Val> state);
	abstract Val divEval(HashMap<String,Val> state);
	abstract Val orEval(HashMap<String,Val> state);
	abstract Val andEval(HashMap<String,Val> state);
	abstract Val notEval(HashMap<String,Val> state);
	abstract Val ltEval(HashMap<String,Val> state);
	abstract Val leEval(HashMap<String,Val> state);
	abstract Val gtEval(HashMap<String,Val> state);
	abstract Val geEval(HashMap<String,Val> state);
	abstract Val eqEval(HashMap<String,Val> state);
	abstract Val pairEval(HashMap<String,Val> state);
	abstract Val firstEval(HashMap<String,Val> state);
	abstract Val secondEval(HashMap<String,Val> state);

}
