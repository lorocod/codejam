package gcj2016.QR.B;

import java.io.*;
import java.awt.geom.Point2D;
import java.text.*;
import java.math.*;
import java.util.*;

public class SolucionIvan implements Runnable {
	 
	 final String INPUTFILE= "C:\\base\\out\\codejam\\RevengeofthePancakes\\input-small.txt";
	 final String OUTPUTFILE= "C:\\base\\out\\codejam\\RevengeofthePancakes\\output2.txt";


		public void solve() throws Exception {
			String s = readword();
			int ans = 0;
			for (int i=0;i+1<s.length();i++) {
				if (s.charAt(i)!=s.charAt(i+1)){ 
					ans++;
				}
			}
			if (ans%2 != (s.charAt(0)=='-'?1:0)) {
				ans++;
			}
			out.write(ans+"");
		}

		public void solve_gcj() throws Exception {
			int tests = iread();
			for (int test = 1; test <= tests; test++) {
				out.write("Case #" + test + ": ");
				solve();
				out.write("\n");
			}
		}

		public void run() {
			try {
				// in = new BufferedReader(new InputStreamReader(System.in));
				// out = new BufferedWriter(new OutputStreamWriter(System.out));
				in = new BufferedReader(new FileReader(INPUTFILE));
				out = new BufferedWriter(new FileWriter(OUTPUTFILE));
				solve_gcj();
				out.flush();
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(1);
			}
		}	 

	public int iread() throws Exception {
		return Integer.parseInt(readword());
	}

	public double dread() throws Exception {
		return Double.parseDouble(readword());
	}

	public long lread() throws Exception {
		return Long.parseLong(readword());
	}

	BufferedReader in;

	BufferedWriter out;

	public String readword() throws IOException {
		StringBuilder b = new StringBuilder();
		int c;
		c = in.read();
		while (c >= 0 && c <= ' ')
			c = in.read();
		if (c < 0)
			return "";
		while (c > ' ') {
			b.append((char) c);
			c = in.read();
		}
		return b.toString();
	}

	public static void main(String[] args) {
		try {
			Locale.setDefault(Locale.US);
		} catch (Exception e) {

		}
		new Thread(new SolucionIvan()).start();
		// new Thread(null, new Main(), "1", 1<<25).start();
	}
}