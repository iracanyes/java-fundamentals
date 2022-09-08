package com.jdojo.statement;

public class Statements{
	/*
	* 
	*/
	public Statements(){
		/*
		* A block statement is a sequence of 0 or more statements in braces '{}'.
		*/
		int n = 33;

		{ /* Start of a block statement */
			/*
			* All variables of the parent block are available in child block
			* You can not declare a variable of the same name inside
			* the inner block. If a variable of the same name exists in the outer block.
			* The variable declared in the parent block are accessible in this scope.
			*/
			// Uncomment - Compile-time Error n already declared in scope
			// float n = 5;
			int j = 5;		
			System.out.println("n = " + n);	// n = 33

			{
				// Uncomment - Compile-time Error n already declared in scope
				// int n = 33
			}
		}

		// Uncomment
		// System.out.println("j =" + j);	// Error. J doesn't exist
		System.out.println("n =" + n);	// n = 33
	}

	public static void main(String[] args) {
		ifElseStatement();
		switchStatement();
		forStatement();
		forEachStatement();
		whileStatement();
		doWhileStatement();
		breakStatement();
		continueStatement();
		emptyStatement();
	}

	public static void ifElseStatement(){
		System.out.println("IF_ELSE STATEMENT");
		/*
		* Structure:
		*	if(condition)
		*		statement1
		*	else
		*		statement2
		*
		* Condition must be a boolean expression (expression evaluated to true/false)
		* If the condition is true, statement1 is executed, else the statement2 is executed.
		* Else part is optional. A structure like this is also possible
		* 	if(condition)
		*		statement1
		*/
		int age = 5;

		if(age > 18){
			System.out.println("You're an adult");
		}

		if(age >= 18){
			System.out.println("Ready to conquer the world!");
			// If-Else statement can be nested
			if(age <= 23){
				System.out.println("");
			}else{

			}
		}else{
			System.out.println("Ready to learn?");
		}

		/*
		*	Ternary operator:
		*	(condition) ?  statement1 : statement2
		*
		* 
		*/
		if(age < 12)
			System.out.println("Hello boys.");
		else 
			System.out.println("Hello, Kid!");

		/*
		* Same as this ternary operation
		*/
		System.out.println((age < 12) ? "Hello boys." : "Hello, Kid!");

		/*
		* When the 2 statements use the same method like before. 
		* A better way to write the code is:
		*/
		System.out.println((age < 12) ? "Hello boys." : "Hello, Kid!");


	}

	public static void switchStatement(){
		System.out.println("SWITCH STATEMENT");
		/*
		* Structure :
		*	swith(switch-condition):
		*		case label1:
		*			statement1;
		*		case label2:
		*			statement2;
		*		default:
		*			default-statement;
		*		
		*/
		int i = 12;

		switch(i){
			case 10:
				System.out.println("i = 10");
				break;
			/*
			* 
			* If the constant label is equal to the switch-expression evaluated,
			* the statement of this case will be evaluated
			* If no break statement are used, switch will evualated the case which follows
			*/
			case 24 / 2:
				System.out.println("i = 12");
				break;
			/*
			* Default statement doesn't have be at last position
			*/
			default:
				System.out.println("value of i not found!");
				break;
			/*
			* 
			* If case is true, after evaluating the statement of this case.
			* As the break statement is used, it will stop evaluating the switch-statement
			*/
			case 13:
				System.out.println("i = 12");
			break;	// Stop the switch-statement
		}

		/*
		* The value of the constant expression used as case label MUST BE in the same range of 
		* the data type of the switch-expression
		*/
		byte b = 10;

		switch(b){
			case 5:
				b++;
			// 2 case labels cannot be the same
			// Uncomment - Compile-time Error: Duplicated labels 5
			//case 5:	
			//	b += 5;
			// Uncomment - Compile-time Error: 150 out of range of byte type (-128-127)
			//case 150:	
			//	b--;
			default:
				b = 0;
		}

		// Switch statement is a clearer ways of writing an if-else statement
		if (i == 10)
			System.out.println("i is 10");
		else if (i == 20)
			System.out.println("i is 20");
		else
			System.out.println("i is neither 10 nor 20");

		switch(i){
			case 10:
				System.out.println("i is 10");
				break;
			case 20:
				System.out.println("i is 20");
				break;
			default:
				System.out.println("i is neither 10 nor 20");
				break;
		}
	}


	public static void forStatement(){
		System.out.println("FOR STATEMENT");

		/*
		* Structure :
		*	for (initialization; condition-expression; expression-list)
		*		statement
		*	
		* Initialization (executed only once): Initialize variable used for iteration
		* Condition-expression: Condition which will be evaluated before each iteration.
		*	If condition is false, the 'for-loop' statement stopped.	
		*	If the condition is true:
		*		- the statement associated with the 'for-loop' statement is executed.
		*		- After that, all expressions in the expression-list are evaluated!
		*		- Start a new iteration by evaluating the condition-expression, and repeat the steps
		*	
		* 	
		*/
		// infinite loop
		// for(;;){}

		/*
		*	'for-loop' allow declaring multiple variable of the same type
		* in the initialization section.
		* All variables initialized are only use in the scope of the block
		*/
		for(int n= 0, j = 10; n < 10 && j < 20; n++, j--){
			System.out.printf("Count: n => %d, j => %d\n", n, j);
		}

		/*
		* Compile-time Error
		*/
		// for(int i = 10, float j = 4.0; )

		/*
		* Here, n doesn't exist in this scope, ok to declare it
		*/
		int n = 10;

		// Uncomment - Compile-time Error: n already declared in the parent scope
		// for(int n = 0;;);

		/* CONDITION
		* Condition-expression MUST be evaluated to true or false
		*/
		// another infinite loop
		// Condition is true, so the loop can continue 
		// for(; true; );

		/*
		* A break statement is used inside the block statement 
		* to stop the for-loop's execution.

		*/
		for(int i= 0; ; i++){
			if(i == 5){
				// Here, stop and exit the loop if i equal 5
				break;
			}
		}

		/* EXPRESSION-LIST
		* The expression-list part is optional. It may contain one or more expressions
		* separated by a comma.
		* You can ONLY use expression  that can be converted to a statement by appending a comma.
		*/
		for(int i = 0; i < 10; System.out.printf("Increment by one => %d", i), i++){

		}

		/*
		* You can modify variable initialized by for-loop in expression-list
		*/
		for(int i = 0; i  < 10; System.out.println(i++)){}

	}

	public static void forEachStatement(){
		System.out.println("FOR_EACH STATEMENT");
		/*
		* FOR-EACH STATEMENT
		* Java 5 introduced the enhanced statement 'for-each'.
		* It's used to iterate over elements of arrays and collections
		*
		* Structure:
		* 	for(Type element: a_collection_or_array){
		*		
		*		// Here all statements are executed once per element of the array or collection 
		*		// Each time this code is executed, the element variable
		*		// holds the reference of the current element in the collection/array
		* 	
		*	}
		*/
		int[] numList= new int[]{11,25,14,36,852};

		for(int num: numList){
			// element defined as 'num', hold the reference
			// of the current element in array 
			System.out.println(num);

			// numList : array / collection on which we iterate
			System.out.println(numList);
		}

	}

	public static void whileStatement(){
		System.out.println("WHILE STATEMENT");
		/*
		* WHILE STATEMENT
		* Execute a statement repeatedly as long as a condition is true
		* Structure:
		*	initialization
		*	while(condition){
		*		statement
		*		expression-list
		*	}
		*		
		*
		* 
		* It's important to negate the condition at some point in the statement
		* otherwise you create an infinite-loop
		* 
		*/
		int n = 0;
		while(n < 10)
			n++;


		/*
		* A break statement is used to exit the loop in a while-loop
		*/
		/*
		* Here an infine loop with break statement to exit the loop
		*/
		while(true){
			if( n <= 10){
				System.out.println(n);
				n++;
			}else 
				break;

		}
	}

	public static void doWhileStatement(){
		System.out.println("DO_WHILE STATEMENT");
		/*
		* Structure:
		*	do
		*		statement
		*	while(condition);
		*
		* Similar to while. One difference: 
		* The statement associated with the do-While  will be 
		* executed at least once even if the condition is evaluated to false
		*/
		do
			System.out.println("Do-While - Executed at least once even if condition is false!");
		while(false); 	// 	IMPORTANT: Do-while statement finish with a semi-colon
	

		/*
		* Break statement can be used inside do-while loop for stopping and exiting of the loop;
		*/
		int n = 0;
		do{
			if(n == 19){
				break;
			}
			n++;
		}while(n < 20);
	}

	public static void breakStatement(){
		System.out.println("BREAK STATEMENT");
		/*
		* A break statement is used to exist from a block.
		* 	- Unlabeled break statement
		*	- Labeled break statement
		*/

		/* UNLABELED BREAK STATEMENT
		* It transfers control out of the switch, for-loop, while-loop, and do-while
		* statement in which it appears. Seen before in for, for-each, while, do-while and switch.
		* Structure:
		*	break;
		*/
		for(int i = 1; i <= 3; i++) {
			for(int j = 1; j <= 3; j++) {
				System.out.print ( i + "" + j);
				if (i == j) {
					break; // Exit the inner for loop
				}
				System.out.print("\t");
			}
			System.out.println("\n");
		}

		/* LABELED BREAK STATEMENT 
		* A label in Java is any valid Java identifier followed by a colon
		*
		* Structure:
		*	break label;
		*
		* Here we define a identifier for our for-loop called 'outer'
		* Label used by the labeled break statement MUST be in the scope
		*/
		outer: for(int i = 1; i <= 5; i++){
			for(int j = 1; j <= 10; j++){
				System.out.println(i + "" + j);
				if(i == j){
					break outer;	// Transfer control out of the labeled for-loop block statement called 'outer'
				}
				System.out.print("\t");
			}

			System.out.println();
		}	// The outer label ends here


		/*
		* Label used by the labeled break statement MUST be in the scope
		*/
		lab1:
		{
			int i = 10;
			if (i == 10)
			break lab1; // Ok. lab1 can be used here
		}
		lab2:
		{
			int i = 10;
			if (i == 10){
				// A compile-time error. lab1 cannot be used here
				// because this block is not associated with
				// lab1 label. We can use only lab2 in this block.
				
				// break lab1;
			}
		}

	}

	public static void continueStatement(){
		System.out.println("CONTINUE STATEMENT");
		/*
		* Continue statement can only be used inside 'for-loop', 'while-loop', 'do-while' statements.
		* There 2 forms of continue statements:
		*	- Unlabeled continue statement
		*		Structure:
		*			break;
		*	- Labeled continue statement
		*		Structure :
		*			break label;
		*/
		/* UNLABELED CONTINUE STATEMENT
		* When a continue statement is executed inside a for loop, 
		* the rest of the statements in the body (statement) of
		* the loop are skipped and the expressions in the expression-list are executed.
		*/
		for( int i = 1; i < 10; i += 2){
			if(i % 2 == 0){
				continue;	// Skip rest of the statement and execute the expressions in expressions-list
			}
			System.out.println(i);
		}

		/*
		* Inside a for loop, control is transferred to the expression-list, 
		* and in a while loop, the control is transferred to the condition-expression.
		*/
		int i = 10;
		while(i < 10){
			if( i % 2 == 0){
				i++;
				continue;
			}
		}

		/* LABELED CONTINUE STATEMENT
		* Labeled continue statement allow to continue in a specific outer loop.
		*/
		outer: for(int j = 0; j <= 5; j++){
			for(int k = 1; k <= 3; k++){
				System.out.println(k + "" + j);
				System.out.print("\t");
				if(k == j){
					System.out.println();
					continue outer;		// Transfer control to outer for-loop
				}
			}
		}

	}

	public static void emptyStatement(){
		System.out.println("EMPTY STATEMENT");
		int n = 0;
		/* Empty statement
		* Structure: 
		*	;
		*
		*/
		n++;;	// The second semi-colon is considered 
		
		/*
		* if(n == 2)
		*		;
		* else{
		*	n--;;	// Compile-time error. Second semi-colon is considered a statement
					// A simple statement (on one line) can only contains one statement.
		* }
		*		
		*/	
		
	}	 
			
}