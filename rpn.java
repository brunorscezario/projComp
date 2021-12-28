import java.util.LinkedList;

public class rpn {

	public static void main(String[] args) {
		rpn_("10 s +");
	}
		private static void rpn_(String expr){
			LinkedList<Double> stk = new LinkedList<Double>();
			for (String tk : expr.split("\\s")){
				if (tk.equals("*")) {
					System.out.print("Token [type=STAR]");
					double second = stk.pop();
					double first = stk.pop();
					stk.push(first * second);
				}
                else if (tk.equals("/")) {
					System.out.print("Token [type=SLASH]");
					double second = stk.pop();
					double first = stk.pop();
					stk.push(first / second);
				}
                else if (tk.equals("-")) {
					System.out.print("Token [type=MINUS]");
					double second = stk.pop();
					double first = stk.pop();
					stk.push(first - second);
				}
                else if (tk.equals("+")) {
					System.out.print("Token [type=PLUS]");
					double second = stk.pop();
					double first = stk.pop();
					stk.push(first + second);
				}
                else if (tk.equals("^")) {
					System.out.print("Token [type=EXP]");
					double second = stk.pop();
					double first = stk.pop();
					stk.push(Math.pow(first, second));
				}
                else {
					System.out.print("Token [type=NUM]");
					try {
						stk.push(Double.parseDouble(tk+""));
					} catch (NumberFormatException e) {
	    					System.out.println("\nError: Unexpected character: " + tk);
	    					return;
					}
				}
				System.out.println(",lexeme="+tk+"]");
			}
			if (stk.size() > 1) {
				System.out.println("Error: EXCESS OF OPERATORS " + stk);
				return;
			}
			System.out.println("Output: " + stk.pop());
		}
	}
	