# Beginning java 9 Fundamentals

## Intro 
See book "Beginning Java 9 Fundamentals"

### Directory structure

	- src : source code - contains the source code (human readable source code)
	- mod : modules - contains the compiled code (bytecode files)
	- lib : libraries - contains the packaged code or executable ( JAR )


#### Source code

#### Module Declaration

Java programs consists of several modules. 
Ex: java.base known as the primordial module.
it depends on no other modules and all modules ("built-in","user-defined") depend on it.

````
module <module-name>{
	<module-statement-1>
	<module-statement-2>
}
````

An empty module declaration means that it does not export any packages for other modules to use
and doesn't depend on any other modules.

````java
module bj9f.intro{
  // Empty module body

  // If this module need to use packages from another module, it must be declared here
  // Base Java libraries must imported to use java. If forgotten the compiler will add it for you
  require java.base;
  // If this module need to make accessible any of his packages to other modules, it must be declared here

}
````

#### Module structure

module-name/package/name/SimpleName

Ex: module jdojo.intro directory

contains module-info file and all packages (Ex: )
Eack package contains types declarations (Class,Annotation,Enum...)

	module info file: src/bj9f/jdojo.intro/module-info.java
	one package (com.jdojo.intro) with a type declared (Welcome.java): src/bj9f/jdojo.intro/com/jdojo/intro/Welcome.java 

#### Type declaration


### Compiling

#### Simple compiling

````shell
bj9ef> javac -d <output-directory> <source-file1> ... <source-fileN>
````

Here is an example of compiling a type declaration and module-info file for the module "jdojo.intro"

````shell
bj9ef> javac -d mod/jdojo.intro src/jdojo.intro/module-info.java src/jdojo.intro/com/jdojo/intro/Welcome.java
````

##### Compiling all .java files from subdirectory

````shell
bj9ef> javac -d <output-dir> --module-source-path src $(find . -name "*.java")
````

#### Packaging into JAR files

Using the tool "jar" to package Java compiled code into JAR files.
A JAR file is a ZIP file with a .jar extension and a MANIFEST.MF in its META-INF directory.
The MANIFEST.MF file is a text file that contains info about JAR file and its contents (used by multiple Java tools).

````shell
bj9ef> jar [options] [-C <dir-to-change>] <file-list> -p <comma-separated-module-dir>
````

Here is some common jar options:
 	-C	 : directory which will be used as the current dir 
		   and all the files specified following this option will be included to the JAR file.
		   For including files from several directories, you can specify -C option multiple times.
 	--create 			(-c) 	: create new JAR file
	--file	 			(-f)	: specify the path and the name of JAR file to create
	--module-path (-p) 	: Add dependencies modules directory
````shell
# -C  <dir-to-change> <file|dir> ... <fileN|dirN> : 
#	tell jar to go to this directory and use it as current directory 
#	and take all specified files or directory and package them into the JAR file name specified
# -c 
#	create new JAR file
# -f <path/package.name.jar>
#	save the package created on the path specified and with the name specified
# -v (verbose)

bj9f> jar -cvf lib/com.jdojo.intro.jar -C mod/jdojo.intro . 
# Here module jdojo.sample.person requires jdojo.sample.address to compile
bj9f> jar -cvf lib/com.jdojo.sample.person.jar -C mod/jdojo.sample.person . --module-path mod
````


##### Verifying the content of a JAR File

````shell
# -t : show table of content of the file specified
# -f : specified the JAR file concern by this command

$ jar -tf lib/com.jdojo.intro.jar
````

#### Check module description

````shell
$ java --module-path lib --describe-module jdojo.intro
````

### Runnning a Java program

````shell
$ java [options] --module <module-name>[/<fully-qualified-main-class-name>] [arguments]
````
	[options]    : options passed to java command.
	--module     :  specify the module name and the main class name inside the module.
			If the main class name is not specified, Java use the main class definied in 
			the module descriptor file 'module-info.java'
	[arguments]  : list of parameters passed to the main() method of the main class

Here is an example:
````shell
$ java --module jdojo.intro/com.jdojo.intro.Welcome
````

#### Error java.lang.module.FindException: Module XXXX not found

Java knows where to find all built-in modules but you must specify where to find the user-defined modules
to the command so they\'re added to the "observable modules".
Observable modules are module accessible at compile time. Before Java 9, module were imported when needed at runtime so many error were detected on production.

For this, you must add the option --module-path [absolute/path/to/package-directory;relative/path/to/packageJAR]
Examples of accepted path:
	- directory : 
		absolute path 			: /c/bj9f/lib
		relative path to bj9f directory : lib
	- one directory and one modular JAR :
		/c/bj9f/lib;/c/bj9f/mod/jdojo.intro/com.jdojo.contact.jar
	- 2 directories:
		/c/bj9f/lib;/c/bj9f/extlib

````shell
# All this command works:
path/to/bj9f> java --module-path lib --module jdojo.intro/com.jdojo.intro.Welcome
path/to/bj9f> java -p C:\path\to\bj9f\lib -m jdojo.intro/com.jdojo.intro.Welcome
path/to/bj9f> java --module-path C:\path\to\bj9f\mod --module jdojo.intro/com.jdojo.intro.Welcome
path/to/bj9f> java -p C:\path\to\bj9f\mod\jdojo.intro -m jdojo.intro/com.jdojo.intro.Welcome
````

Remarque: l'argument ``--module-path <path/to/libDirectory>`` doit être obligatoirement fourni avant l'argument ``--module <module-name>`` afin d'exécuter 

### Run Java Programs Before Java 9 - Legacy mode (class-path)
Java support backward compatibility for old Java programs.
You can run Java applications in:
- module mode (module-path)
- Legacy mode (class-path)
- mixed

Old Java programs before Java 9 used ``class-path`` for loading classes, module appears with Java9.
Here is the command to execute Java programs using class path

````shell
$ java [options] --class-path <path/to/compiled-class> <class-name> <arguments>
````

Here is an example executing the class 'com.jdojo.intro.Welcome' which require one argument

````shell
# Run by giving the class file path & argument needed for this class
$ java --class-path mod/jdojo.intro com.jdojo.intro.Welcome Jean
# Run by giving the JAR file
$ java --class-path lib/com.jdojo.intro.jar com.jdojo.intro.Welcome Jean
# Also run 
$ java -cp lib/* com.jdojo.intro.Welcome
````	

#### Limit modules

````shell
/c/path/to/bj9f> java -p lib --limit-modules java.base -m jdojo.intro/com.jdojo.intro.Welcome
````

To see how modules are loaded, you can add ```` -verbose:module ````

````shell
/c/path/to/bj9f> java -p lib --limit-modules java.base -verbose:module -m jdojo.intro/com.jdojo.intro.Welcome
````

#### Describe module

````shell
/c/path/to/bj9f> java -p lib --describe-module -m jdojo.intro/com.jdojo.intro.Welcome
# other example
/c/path/to/bj9f> java --describe-module java.sql
````

#### Module resolution

````shell
/c/path/to/bj9f> java -p lib --limit-modules java.base -m jdojo.intro/com.jdojo.intro.Welcome --show-module-resolution
````

#### Dry-Run 

Allow to simulate the loading of module on runtime.
All modules are loaded but the main class is not executed.
It\'s for debugging purpose: Check module configuration

````shell
/c/path/to/bj9f> java -p lib --limit-modules java.base -m jdojo.intro/com.jdojo.intro.Welcome --dry-run
````

#### Enhancing the module descriptor

Jar tool allow to modify 2 element of the module descriptor :
- Module version
- Main class name

To check the module's description, run this command:
````shell
$ jar --describe-module --file lib/com.jdojo.intro.jar
````

##### Update Module version & Main class name

````shell
# Modifying the version of module during the packaging  
/c/path/to/bj9f> jar -c --module-version 1.0 -f lib/com.jdojo.intro.jar -C mod/jdojo.intro .

# Check module version
/c/path/to/bj9f> java --describe-module lib/com.jdojo.intro.jar
````

Here we update the main class name of a package 

````shell
$ jar --update --main-class com.jdojo.intro.Welcome --file lib\com.jdojo.intro.jar
````
Here we update the module version & Main class name :

````shell
# Modifying the version of module during the packaging  
/c/path/to/bj9f> jar -c --module-version 1.0 --main-class com.jdojo.intro.Welcome -f lib/com.jdojo.intro.jar -C mod/jdojo.intro .

# Check module version
/c/path/to/bj9f> jar --describe-module -f lib/com.jdojo.intro.jar
````







