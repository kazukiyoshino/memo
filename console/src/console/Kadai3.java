package console;

public class Kadai3 {

	public static void main(String[] args) {
		if(validation(args)) {
		   calc(args);
		}
	}

	public static void calc(String args[]) {
		double num0=Double.parseDouble(args[0]);
		double num1=Double.parseDouble(args[1]);
		double ans = 0;

		switch(args[2]) {
			case "+":ans=num0+num1;
			break;
			case "-":ans=num0-num1;
			break;
			case "*":ans=num0*num1;
			break;
			case "/":ans=num0/num1;
			break;
			case "%":ans=num0%num1;
		}
		System.out.println(String.format("%.2f",ans));

	}


	public static boolean validation(String check[]) {

		if(isArgumentCountCheck(check)&&isParseCheck(check[0],check[1])&&isSymbolCheck(check[2])) {
			return true;
		}
		return false;

	}



	public static boolean isArgumentCountCheck(String checkArgumentNumber[]) {
		if(checkArgumentNumber.length<3){
			System.out.println("引数が足りません");
			return false;
		}
		if(checkArgumentNumber.length>3) {
			System.out.println("引数が多すぎます");
			//System.out.println(CheckBound[3]);
			//「*」のみコマンドライン引数に出来ず。上記では「.project」が出現(ワイルドカード扱い？)
			return false;

		}
		return true;
	}


	public static boolean isParseCheck(String checkParseNum1,String checkParseNum2) {
		int i=1;
		try {
			Double.parseDouble(checkParseNum1);
			i++;
			Double.parseDouble(checkParseNum2);
			return true;
		}catch(NumberFormatException e){
			System.out.println(i+"番目の引数は数字で入力してください");
			return false;
		}
	}


	public static boolean isSymbolCheck(String checkSymbol) {
		switch(checkSymbol) {
			case"+":
			case"-":
			case"*":
			case"/":
			case"%":return true;
			default:System.out.println("入力できる記号は、「+」、「-」、「*」、「/」、「%」です。");
			return false;
		}
	}

}
