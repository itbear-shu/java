import java.util.Scanner;
public class ScannerTest {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter the first number: ");
		int h1 = sc.nextInt();
		System.out.println("Please enter the second number: ");
		int h2 = sc.nextInt();
		System.out.println("Please enter the last number: ");
		int h3 = sc.nextInt();
		
		int max = h1 > h2 ? h1 : h2 ;
		max = max > h3 ? max : h3 ;
		System.out.println("The max height is: " + max + "cm");
	}
}