import java.util.ArrayList;
import java.util.Stack;

import br.ufpe.cin.main.Token;
import br.ufpe.cin.main.TokenType;

import java.util.HashMap;
import java.util.Map;

import exceptions.OpIncorretaExc;


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
					
				if(t.type == TokenType.PLUS) {
					stack.push(x+y);
				}
                else if(t.type == TokenType.MINUS) {
					stack.push(x-y);
				}
                else if(t.type == TokenType.STAR) {
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