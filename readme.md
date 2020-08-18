Function definition and input expression is provided as a text file. To run the interpreter use java. Provide name of your written function definition and expression needed to be evaluated as argument. Please follow the argument format below.

To complie use the sources on src folder to generate class files

>javac *.java

To run

>java Interpreter your_function_definition.txt output_file_name_ of_lexical_syntactical_error_on_function_definition.txt expression_to_be_evaluated.txt output.txt output_file_name_ of_lexical_syntactical_error_on_expression.txt

Aritmmetic expression has general form
(+ E1 ... En) = E1 + (E2 + ... (En + 0)) n >= 0

Example (+ 2 3 5 7) output 17

You write your own functions. Function definition has form

function_name parameters x y z ...
{
    expressions
}

Please refer to grammar definition for valid form of expressions.
