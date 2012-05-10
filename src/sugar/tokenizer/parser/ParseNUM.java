package sugar.tokenizer.parser;

import sugar.KToken;
import sugar.tokenizer.FTokenizer;
import sugar.tokenizer.TEnv;

import commons.konoha2.CTX;
import commons.konoha2.kclass.KMethod;
import commons.konoha2.kclass.KString;

public final class ParseNUM implements FTokenizer {
	
	@Override public final int parse(CTX ctx,  KToken tk, TEnv tenv, int tok_start, KMethod thunk) {
		int ch, pos = tok_start, dot = 0;
		String ts = tenv.source;
		while((ch = ts.charAt(pos++)) != 0) {
			if(ch == '_') continue; // nothing
			if(ch == '.') {
				if(!Character.isDigit(ts.charAt(pos))) {
					break;
				}
				dot++;
				continue;
			}
			if((ch == 'e' || ch == 'E') && (ts.charAt(pos) == '+' || ts.charAt(pos) == '-')) {
				pos++;
				continue;
			}
			if(!Character.isLetterOrDigit(ch)) break;
		}
		if(tk != null /* CTX.IS_NOTNULL(tk) */) {
			tk.text = new KString(ts.substring(tok_start, pos - 1)); // TODO KSETv(tk->text, new_kString(ts + tok_start, (pos-1)-tok_start, SPOL_ASCII));
			System.out.println(tk.text.text);
			tk.tt = (dot == 0) ? KToken.TK_INT : KToken.TK_FLOAT;
		}
		return pos - 1;  // next
	}
}