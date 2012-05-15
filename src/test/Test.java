package test;

import java.io.*;

import sugar.KToken;

import sugar.token.*;

import commons.konoha2.*;
import commons.konoha2.kclass.*;
import commons.sugar.KKonohaSpace;

//import org.apache.log4j.*;

class Test {
	
<<<<<<< HEAD
	public static void main(String[] args) throws FileNotFoundException, IOException {
=======
	public static void main(String[] args)  throws FileNotFoundException, IOException  {
>>>>>>> master
		CTX ctx = new CTX();
		int uline = 0;
		KArray<KToken> a = new KArray<KToken>();
		KKonohaSpace ks = new KKonohaSpace();
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
<<<<<<< HEAD
//		String source = "a b c d f g h \n + /* hogehogeghohogeg hoge */cd\n//hogehogehogehogehogehoge\nhugahuga + 3";
=======
//		//							ok
//		\							ok
//		"xxx;"						ok
//		"/","xxx;"					ok
//		()							ok
//		[]							ok
//		{}							ok
//		' 							ok
//		" 							ok
//		@@@							ok
//		'`'							ok
//		,@							ok
//		,@							ok
//		'1 < 2, 2 < 2, 3=3'			ok
//		'hoge, hoge, hogu'			ok
//		/							ok
//		xxx/							ok
>>>>>>> master
		String source = br.readLine();

		if(source != null) {
			Tokenizer.ktokenize(ctx, ks, source, uline, a);
			for(int i = 0; i < a.size(); i++) {
				System.out.print("{ token type:" + a.get(i).tt + ", ");
				if(a.get(i).text != null) {
					System.out.print("text: " + a.get(i).text.text + ", ");
				}
				else {
					System.out.print("text: null, ");
				}
				System.out.println("uline:" + a.get(i).uline + " }");
			}
		}	
	}
}
