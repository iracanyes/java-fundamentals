packge com.jdojo.common;

public class ThisTest4{
	int num = 1977;	// instance variable

	public static void main(String[] args) {
		ThisTest4 tt4 = new ThisTest4();

		tt4.printYear(2000);
	}



	void printYear(int num){
		System.out.println("Parameter num: " + num);	// Num return 2000
		/*
		* Here num instance variable is hidden by a local variable num
		* "this" keyword  will be used to access instance variable "num"
		*/
		System.out.println("Num : " + this.num);		// Num return 1977
	}

	/*
	* Variable Accessor - Setter
	*/
	public void setNum(int num){
		this.num = num;
	}

	/*
	* Variable Accessor - Setter
	*/
	public int getNum(){
		return this.num;
	}
}