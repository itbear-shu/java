public class Zhu{
	public static void main(String[] args){
		int cnt = 0;
		double be = 0.1;
		while(be <= 8844430)
		{
			be *= 2;
			cnt++;
		}
		System.out.println(cnt);
	}
}