import java.util.Scanner;


public class Q2Example {
	public static void main(String[] args) {
		boolean b = false;
		int x = 10;
		double y = 0.5;
		double z = x + y * 10;
		System.out.println("The num is: " + z);

		System.out.println("+-----------+");
		System.out.println("|  CAITLIN  |");
		System.out.println("+-----------+");

		System.out.println("Enter the number (as an integer): ");
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		sc.close();
		switch (number) {
		case 1:
			System.out.println("ONE");
			break;
		case 2:
			System.out.println("TWO");
			break;
		default:
			System.out.println("ERROR: you must enter an integer between 1 and 2.");

			int examMark = 50;
			System.out.println("The mark is " + examMark);
			if (examMark > 69) {
				System.out.println("The student has attained a Distinction");
			} else if (examMark > 59) {
				System.out.println("The student has attained a Commendation");
			} else if (examMark > 49) {
				System.out.println("The student has attained a Pass");
			} else {
				System.out.println("The student has failed");
			}
		}
			
			int whileNumber = 0;

			while (whileNumber < 10) {
				System.out.println("Hello");
				whileNumber++;
			}
			
			 for (int f = 0; f < 500; f+=5) {
				 System.out.println( f );
			 
		}
			 
			 int example = 2;
			 if (example > 1 && example < 3) {
				 System.out.println("Example: " + example);
			 }else {
				 System.out.println("Invalid");
			 }
	}
}
			 
