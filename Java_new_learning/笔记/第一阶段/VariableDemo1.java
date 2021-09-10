

public class VariableDemo1 {
	public static void main(String[] args){
		int a;
		a = 10;
		System.out.println(a);
		a =  20;
		System.out.println(a);
		
		byte x = 10;
		System.out.println(x);
		
		boolean b = true;
		System.out.println(b);
		
		long l = 10000000000L;//long 定义时防止不兼容类型， 后面要加L
		System.out.println(l);
		
		float f = 12.12F;//float 定义时防止不兼容类型， 后面要加F
		System.out.println(f);
	}
}