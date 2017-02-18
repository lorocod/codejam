package gcj2016.QR.A;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 
 * @author lorocod
 *
 */
public class CountingSheep {

	final static String PROBLEMA = "CountingSheep";
	final static String DIRECTORIO = "C:\\base\\out\\codejam\\" + PROBLEMA + "\\";

	int[] vector = new int[10];
//	private static long total=0;
	static Scanner sc;
	static PrintWriter pw;

	void solve(int N) {
		long num = 0;
		long i = 0;
		clearVector();
		try {
			for (i = 0; i < 10000; i++) {
				num = (i + 1) * N;
				destiparNum(num);
				checkVector();
			}
		} catch (FoundDigitsException e) {
			pw.println(num);
//			total+= num;
			System.out.println(num + " i: " + i);
			return;
		}
		// System.out.println("INSOMNIA");
		pw.println("INSOMNIA");
	}

	void destiparNum(long num) {
		long potencia = 1;
		int digit;
		do {
			digit = (int) (num / potencia) % 10;
			potencia = potencia * 10;
			vector[digit] = 1;
			// System.out.println(digit);
		} while (potencia <= num);
	}

	/**
	 * devuelve true si los 10 primeros items estan seteados en 1
	 * 
	 * @return
	 * @throws FoundDigitsException
	 */
	void checkVector() throws FoundDigitsException {
		int i, t = 0;
		for (i = 0; i < 10; i++) {
			t += vector[i];
		}
		//System.out.println("t " + t + " " + (t == 10));
		if (t == 10)
			throw new FoundDigitsException();

	}
	
	void clearVector(){
		for (int i = 0; i < 10; i++)vector[i]=0;
	}
	
	public static void main(String[] args) throws Exception {
		sc = new Scanner(new FileReader(DIRECTORIO + "input-large.txt"));
		pw = new PrintWriter(new FileWriter(DIRECTORIO + "output.txt"));
		int caseCnt = sc.nextInt();
		for (int caseNum = 0; caseNum < caseCnt; caseNum++) {
			System.out.println("Processing test case " + (caseNum + 1));
			pw.print("Case #" + (caseNum + 1) + ": ");
			new CountingSheep().solve(sc.nextInt());
		}
	//	pw.print("total: "+ total);
		pw.flush();
		pw.close();
		sc.close();
	}

	static class FoundDigitsException extends Exception {

	}
}
