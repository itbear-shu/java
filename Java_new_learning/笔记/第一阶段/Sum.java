import java.util.Scanner;
public class Sum {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = x;
		int sum = 0;
		for(int i = 1;i <= 3;i++){
			int t = x%10;
			sum += t*t*t;
			x /= 10;
		}
		if(sum == y)
			System.out.println(true);
		else
			System.out.println(false);
	}
}