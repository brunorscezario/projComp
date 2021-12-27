import java.util.ArrayList;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

import br.ufpe.cin.main.Token;

import java.io.FileNotFoundException;

import exceptions.CaractereInexExc;
import exceptions.OpIncorretaExc;


public class Main {

	public static <RPNstk, Scan> void main(String[] args) throws FileNotFoundException, CaractereInexExc, OpIncorretaExc {
		Scan sc = new Scan();
		RPNstk calc = new RPNstk();
		
		ArrayList<Token> tokenList = sc.ler(new FileReader("src/Calc1.stk"));
			
		System.out.println(((Object) calc).calculo(tokenList, new Stack<Integer>()));
		
	}

}
