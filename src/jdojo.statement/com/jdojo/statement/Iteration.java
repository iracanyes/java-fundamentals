/*
*
*/
package com.jdojo.statement;


public class Iteration{
	public Iteration(){}

	public void boucleWhile(){
		int i = 0;

		/*
		* Mandatory: 
		*	- Pre|Post increment mandatory 
		*	- add an (de|in)crement to the counter 
		*/
		while(i != 10){
			// Pre-increment counter
			i++;

			if(i == 3){
				// Saute le reste des instructions
				// continuer la boucle
				continue;
			}

			if(i == 5){
				System.out.println("Counter value is 5");
				// arret de la boucle
				break;
			}

			System.out.println("counter = "+i);
			
			//Post-increment counter after using it
			//i++;
		}

	}

	public void doWhile(){
		int i = 0;
		do{
			// Here we use post-increment
			i++;

			System.out.println("Counter : "+ i);

		}while(i <= 10);
	}

	public void boucleFor(){
		/*
		* 
		*/
		for(int i = 0; i != 10; i++){
			System.out.println("\n"+i);
		}
	}
}