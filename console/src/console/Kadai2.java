package console;

public class Kadai2 {

	public static void main(String[] args) {
		
		// 異なる解を模索(無理矢理メソッドを分けてみる)
		if(!isNumberCheck(args)) {
			System.out.println("数字で入力してください");
			System.exit(0);
		}
		
		double doubleargs[] = parse(args);
		double ans=0.0;
		for(double i :doubleargs) {
			ans += i;
		}
		System.out.println(ans);
		
		//DecimalFormat以外の方法は…

	}
	
	public static boolean isNumberCheck(String checkNums[]) {
		try {
			for(int i=0;i<checkNums.length;i++) {
			  Double.parseDouble(checkNums[i]);
			}
			 return true;
		}catch(NumberFormatException e){
			return false;
		}
	}
		
	public static double[] parse(String parseNums[]){
		double arg[] =new double[parseNums.length];
		for(int i=0;i<parseNums.length;i++) {
			arg[i]=Double.parseDouble(parseNums[i]);
			}
		return arg;
		
	}

}
