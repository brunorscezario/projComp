import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import br.ufpe.cin.main.Token;
import br.ufpe.cin.main.TokenType;
import exceptions.CaractereInexExc;


//public class CaractereInexExc extends Exception{
//	public CaractereInexExc(String op){ super("Caractere inexperado: " + op);}
//}

//public class OpIncorretaExc extends Exception{
//	public OpIncorretaExc(){ super("Operacao Incorreta!");}
//}


public class Scan {
	
	public ArrayList<Token> ler(FileReader arq) throws exceptions.CaractereInexExc, exceptions.CaractereInexExc{
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
					token = new Token(TokenType.PLUS, op);
					tks.add(token);
					break;
				case "-":
					token = new Token(TokenType.MINUS, op);
					tks.add(token);
					break;
				case "*":
					token = new Token(TokenType.STAR, op);
					tks.add(token);
					break;
				case "/":
					token = new Token(TokenType.SLASH, op);
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

