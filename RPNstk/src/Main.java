import java.util.ArrayList;
import java.io.FileReader;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;


public class OpIncorretaExc{
	public OpIncorretaExc(){ super("Operacao Incorreta!");}
}

public class CaractereInexExc{
	public CaractereInexExc(String op){ super("Caractere inexperado: " + op);}
}

public class Scan {
	
	public ArrayList<Token> read(FileReader arq) throws CaractereInexExc{
		Scanner in = new Scanner(arq);
		ArrayList<Token> tks = new ArrayList<Token>();
		while(in.hasNext()) {
			if(in.hasNextInt()) {
				Token token = new Token(TokenType.NUM, in.nextLine());
				tks.add(token);
			}
            else {
				Token token;
				String op = in.nextLine();
				switch (op) {
				case "+":
					token = new Token(TokenType.soma, op);
					tks.add(token);
					break;
				case "-":
					token = new Token(TokenType.sub, op);
					tks.add(token);
					break;
				case "*":
					token = new Token(TokenType.mult, op);
					tks.add(token);
					break;
				case "/":
					token = new Token(TokenType.div, op);
					tks.add(token);
					break;
				default:
					CaractereInexExc exc_inc = new CaractereInexExc(op);
					throw exc_inc;
				}
			}
		}
		return tks;
	}
}

public class RPNstk{

	public int calculo (ArrayList<Token> tks, Stack<Integer> stack) throws OpIncorretaExc{
		for(Token t : tks) {
			if(t.type == TokenType.NUM) {
				stack.push(Integer.parseInt(t.lexeme));
			}
            else {
				int x = 0, y = 0;
				
				try {
					y = stack.pop();
					x = stack.pop();
				} catch (Exception exc_inc) {
					throw new OpIncorretaExc();
				}
					
				if(t.type == TokenType.soma) {
					stack.push(x+y);
				}
                else if(t.type == TokenType.sub) {
					stack.push(x-y);
				}
                else if(t.type == TokenType.mult) {
					stack.push(x*y);
				}
                else {
					stack.push(x/y);
				}
			}
		}
		if(stack.size() != 1) {
			OpIncorretaExc exc_inc = new OpIncorretaExc();
			throw exc_inc;
		}
		return stack.get(0);
	}
}


public class Main {

	public static void main(String[] args) throws FileNotFoundException, CaractereInexExc, OpIncorretaExc {
		Scan sc = new Scan();
		RPNstk calc = new RPNstk();
		
		ArrayList<Token> tokenList = sc.read(new FileReader("src/Calc1.stk"));
		
		System.out.println(calc.calculo(tokenList, new Stack<Integer>()));
		
	}

}
