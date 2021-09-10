public class New3 {
	public static void main(String[] args){
		int h1 = 150;
		int h2 = 165;
		int h3 = 210;
		int max = h1 > h2 ? h1: h2 ;
		max = max > h3 ? max : h3 ;
		System.out.println("The highest height is: " + max);
	}
}