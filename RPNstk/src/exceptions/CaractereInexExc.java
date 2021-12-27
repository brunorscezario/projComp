package exceptions;

public class CaractereInexExc extends Exception{
	public CaractereInexExc(String op){ super("Caractere inexperado: " + op);}
}