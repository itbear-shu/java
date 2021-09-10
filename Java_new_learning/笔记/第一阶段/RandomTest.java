import java.util.Random;
import java.util.Scanner;
public class RandomTest {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		System.out.println("Please enter a integer: ");
		int x = sc.nextInt();
		int y = r.nextInt(100) + 1;
		while(y != x)
		{
			if(x > y)
			{	
				System.out.println("Too high!");
			}
			else
			{
				System.out.println("Too low!");
				
			}
			x = sc.nextInt();
		}
		System.out.println("You're right!");
	}
}