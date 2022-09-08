/*
* Command:
*	Compile:
*		javac -p mod -d mod/jdojo.statement src/jdojo.statement/com/jdojo/statement/*
*	 Packaging:
*		jar -cvf lib/com.jdojo.statement.jar -C mod/jdojo.statement .
*	Run : 
*		java -p lib -m jdojo.statement/com.jdojo.statement.<class-name>
*/
module jdojo.statement{
	requires java.base;
}