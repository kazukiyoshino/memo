package javakiso;

public class kadai2 {

	public static void main(String[] args) {
		// 異なる解を模索(無理矢理メソッドを分けてみる)
		double doubleargs[] = parse(args);
		double ans=0.0;
		for(double i :doubleargs) {
			ans += i;
		}
		System.out.println(ans);
		//DecimalFormat以外の方法は…


	}
	public static double[] parse(String a[]){
		try {
			double arg[] =new double[a.length];
			for(int i=0;i<a.length;i++) {
			  arg[i]=Double.parseDouble(a[i]);
			}
			 return arg;
		}catch(NumberFormatException e){
			System.out.println("数字で入力してください");
			System.exit(0);
			return null;
		}
	}

}
