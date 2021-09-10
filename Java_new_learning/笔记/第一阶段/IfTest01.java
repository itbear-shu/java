import java.util.Scanner;
public class Test{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter an integer: ");
		
		int x = sc.nextInt();
		if(x%2 == 0)
		{
			System.out.println(x + " is ou shu.");
		}
		else
		{
			System.out.println(x + " is ji shu.");
		}
		System.out.println("Over!");
	}
}