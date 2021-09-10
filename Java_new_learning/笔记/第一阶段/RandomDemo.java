import java.util.Random;
public class RandomDemo{
	public static void main(String[] args){
		Random r = new Random();
		
		//System.out.println("n: " + n);
		for(int i = 0;i < 10;i++){
			int n = r.nextInt(10);
			System.out.println("n: " + n);
		}
	}
}