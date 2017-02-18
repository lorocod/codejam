package gcj2016.QR.B;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 
 * @author lorocod
 *
 */
public class RevengeofthePancakes {

	final static String PROBLEMA = "RevengeofthePancakes";
	final static String DIRECTORIO = "C:\\base\\out\\codejam\\" + PROBLEMA + "\\";

	int[] Pancakes = new int[10];
	static Scanner sc;
	static PrintWriter pw;
	int sequencia = 0;

	void solve() {
		String s = sc.nextLine();
		pw.println(testFlip(s));
	}

	public static void main(String[] args) throws Exception {
//		 sc = new Scanner(new FileReader(DIRECTORIO + "input-large.txt"));
//		 pw = new PrintWriter(new FileWriter(DIRECTORIO + "output.txt"));
//		 int caseCnt = sc.nextInt();
//		 sc.nextLine();
//		 for (int caseNum = 0; caseNum < caseCnt; caseNum++) {
//		 System.out.println("Processing test case " + (caseNum + 1));
//		 pw.print("Case #" + (caseNum + 1) + ": ");
//		 new RevengeofthePancakes().solve();
//		 }
//		
//		 pw.flush();
//		 pw.close();
//		 sc.close();

		System.out.println(0%2);
		System.out.println(1%2);
		System.out.println(2%2);
		System.out.println(2%1);
		
//		test();
	}

	public static void test(){
		RevengeofthePancakes test = new RevengeofthePancakes();

		// test.testFlip("-++");
		// test.testFlip("-+-");
		// test.testFlip("+-+");
		// test.testFlip("+--");
		
//		test.testFlip("-+-++--+");
//		test.testFlip("-+-+");
//		test.testFlip("+-+-");
//		
//		test.testFlip("-");
//		test.testFlip("-+");
//		test.testFlip("+-");
//		test.testFlip("+++");
//		test.testFlip("--+-");
		
//		test.testFlip("----+");
//		test.testFlip("++++-");
//		test.testFlip("+");
//		test.testFlip("--++--");
//		test.testFlip("++--++");
		
		test.testFlip("++-++++---");
		test.testFlip("-++----++");

		// test.testCortarString("-+-++", '+');
		// test.testCortarString("-+-", '-');
		// test.testCortarString("-+", '+');
		// test.testCortarString("----", '-');		
	}
	/**
	 * compara si el caracter (o el ultimo de la palabra) es igual al signo, si
	 * lo es devuelve 0 indicando 0 flip sino devuelve 1, indicando el un flip.
	 * 
	 * @param s
	 * @param signo
	 * @return
	 */
	public int checkFlipGroup(String s, char signo) {
		if (s.length() == 2) {
			if (s.charAt(1) == s.charAt(0)) {
				if (s.charAt(1) == signo)
					return 0;
				else
					return 1;
			} else {
				if (s.charAt(1) == signo)
					return 1;
				else
					return 2;
			}
		}
		if (s.charAt(s.length() - 1) == signo)
			return 0;
		else
			return 1;
	}

	public int extraFlip(char signo, char signoGlobal) {
		if (signoGlobal == signo)
			return 0;
		else
			return 1;

	}

	public int flip(String s, char signo, char signoGlobal) {
		if (s.length() <= 2)
			return checkFlipGroup(s, signo);
		int tamNuevo = 0;
		try {
			tamNuevo = cortarString(s, signo);
		} catch (StringSignosRepetidos e) {
			return checkFlipGroup(s, signoGlobal);
		}

		String s1 = s.substring(0, tamNuevo);
		// nuevo signo, el opuesto al ultimo
//		char nuevoSigno = signoOpuesto(s.charAt(s.length() - 1));
		char nuevoSigno = s.charAt(s.length() - 1);
		
		int cantidad = flip(s1, nuevoSigno, signoGlobal);
		int extra = extraFlip(signo, signoGlobal);
		
		sequencia++;
		System.out.println("seq " + sequencia + " string: " + s1 + " cantidad: " + cantidad + " extra: " + extra
				+ " signo actual " + signo);

		return cantidad + extra;
	}

	/**
	 * Recorta el string cuando cambia el signo devuelve el tamaño del nuevo
	 * string, es decir cuanto hay q recortar el string original.
	 * 
	 * @param s
	 * @param signo
	 * @return
	 * @throws StringSignosRepetidos
	 */
	private int cortarString(String s, char signo) throws StringSignosRepetidos {
		int n = s.length();
		// char alterSigno = signoOpuesto(signo);
		try {
			while (s.charAt(n - 1) == signo && n >= 0)
				n--;
		} catch (StringIndexOutOfBoundsException e) {
			throw new StringSignosRepetidos();
		}

		return n;
	}

	private char signoOpuesto(char signo) {
		if (signo == '+')
			return '-';
		return '+';
	}

	public static class StringSignosRepetidos extends Exception {

	}

	public void testCortarString(String s, char signo) {
		int tamNuevo;
		try {
			tamNuevo = cortarString(s, signo);
			String s1 = s.substring(0, tamNuevo);
			System.out.println("original: " + s + " nuevo String: " + s1 + " tam: " + tamNuevo);
		} catch (StringSignosRepetidos e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int testFlip(String s) {
		sequencia = 0;
		char signo = s.charAt(s.length() - 1);
		int r = flip(s, signo, signo) + extraFlip(signo, '+');
		System.out.println("------------------------------------string: " + s + " flips: " + r);
		return r;

	}
}
