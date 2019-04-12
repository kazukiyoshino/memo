package console;

public class kadai3 {

	public static void main(String[] args) {
		if(isBoo(args)) {
		   keisan(args);
		}
	}

		public static void keisan(String args[]) {
			double parse0=Double.parseDouble(args[0]);
			double parse1=Double.parseDouble(args[1]);
			double ans = 0;

			switch(args[2]) {
			case "+":ans=parse0+parse1;
			break;
			case "-":ans=parse0-parse1;
			break;
			case "*":ans=parse0*parse1;
			break;
			case "/":ans=parse0/parse1;
			break;
			case "%":ans=parse0%parse1;
			}
			System.out.println(String.format("%.2f",ans));

		}


		public static boolean isBoo(String Check[]) {
			if(!isBoundCheck(Check)||!isNumCheck(Check[0],Check[1])||!isStrCheck(Check[2])) {
				return false;
			}
			else return true;
		}


		public static boolean isBoundCheck(String CheckBound[]) {
			if(CheckBound.length<3){
				System.out.println("引数が足りません");
				return false;
			}
			else if(CheckBound.length>3) {
				System.out.println("引数が多すぎます");
				System.out.println(CheckBound[3]);
				return false;

			}
			else return true;
		}


		public static boolean isNumCheck(String CheckNum1,String CheckNum2) {
			int i=0;
			try {
				Double.parseDouble(CheckNum1);
				i++;
				Double.parseDouble(CheckNum2);
				return true;
			}catch(NumberFormatException e){
			System.out.println(i+"番目の引数は数字で入力してください");
			return false;
			}
		}


		public static boolean isStrCheck(String CheckStr) {
			switch(CheckStr) {
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
