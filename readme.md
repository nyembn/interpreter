The goal of this project is to build a functional sub-language of LISP. As of now it evaluates expressions in the language except function call and function passed as parameters.

The input expression is provided as a text file. To run the interpreter use java and give name of the input file as argument and name of file to output lexical and/or syntactical error.

To complie use the sources on src folder to generate class files

>javac *.java

To run

>java Interpreter sample_input.txt lexical_syntactical_error.txt
