// Generated from CoolLexer.g4 by ANTLR 4.5
package cool;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CoolLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ERROR=1, TYPEID=2, OBJECTID=3, BOOL_CONST=4, INT_CONST=5, STR_CONST=6, 
		LPAREN=7, RPAREN=8, COLON=9, ATSYM=10, SEMICOLON=11, COMMA=12, PLUS=13, 
		MINUS=14, STAR=15, SLASH=16, TILDE=17, LT=18, EQUALS=19, LBRACE=20, RBRACE=21, 
		DOT=22, DARROW=23, LE=24, ASSIGN=25, CLASS=26, ELSE=27, FI=28, IF=29, 
		IN=30, INHERITS=31, LET=32, LOOP=33, POOL=34, THEN=35, WHILE=36, CASE=37, 
		ESAC=38, OF=39, NEW=40, ISVOID=41, NOT=42, WHITES=43, SIN_LINE_C=44, MUL_LIN_C=45, 
		UNMATCHED_C=46, ENDOFFILE1=47, NESTEDCOMMENT1=48, ENDOFCOMMENT1=49, BODY1=50, 
		ENDOFFILE2=51, ENDOFCOMMENT2=52, NESTEDCOMMENT2=53, BODY2=54;
	public static final int MCOMMENTS = 1;
	public static final int NCOMMENTS = 2;
	public static String[] modeNames = {
		"DEFAULT_MODE", "MCOMMENTS", "NCOMMENTS"
	};

	public static final String[] ruleNames = {
		"SEMICOLON", "DARROW", "BOOL_CONST", "INT_CONST", "STR_CONST", "LPAREN", 
		"RPAREN", "COLON", "ATSYM", "COMMA", "PLUS", "MINUS", "STAR", "SLASH", 
		"TILDE", "LT", "EQUALS", "LBRACE", "RBRACE", "DOT", "LE", "ASSIGN", "WHITES", 
		"CLASS", "ELSE", "FI", "IF", "IN", "INHERITS", "LET", "LOOP", "POOL", 
		"THEN", "WHILE", "CASE", "ESAC", "OF", "NEW", "ISVOID", "NOT", "TYPEID", 
		"OBJECTID", "SIN_LINE_C", "MUL_LIN_C", "UNMATCHED_C", "ERROR", "ENDOFFILE1", 
		"NESTEDCOMMENT1", "ENDOFCOMMENT1", "BODY1", "ENDOFFILE2", "ENDOFCOMMENT2", 
		"NESTEDCOMMENT2", "BODY2"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, "'('", "')'", "':'", "'@'", 
		"';'", "','", "'+'", "'-'", "'*'", "'/'", "'~'", "'<'", "'='", "'{'", 
		"'}'", "'.'", "'=>'", "'<='", "'<-'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "ERROR", "TYPEID", "OBJECTID", "BOOL_CONST", "INT_CONST", "STR_CONST", 
		"LPAREN", "RPAREN", "COLON", "ATSYM", "SEMICOLON", "COMMA", "PLUS", "MINUS", 
		"STAR", "SLASH", "TILDE", "LT", "EQUALS", "LBRACE", "RBRACE", "DOT", "DARROW", 
		"LE", "ASSIGN", "CLASS", "ELSE", "FI", "IF", "IN", "INHERITS", "LET", 
		"LOOP", "POOL", "THEN", "WHILE", "CASE", "ESAC", "OF", "NEW", "ISVOID", 
		"NOT", "WHITES", "SIN_LINE_C", "MUL_LIN_C", "UNMATCHED_C", "ENDOFFILE1", 
		"NESTEDCOMMENT1", "ENDOFCOMMENT1", "BODY1", "ENDOFFILE2", "ENDOFCOMMENT2", 
		"NESTEDCOMMENT2", "BODY2"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}



		/*
			YOU CAN ADD YOUR MEMBER VARIABLES AND METHODS HERE
		*/

		/**
		* Function to report errors.
		* Use this function whenever your lexer encounters any erroneous input
		* DO NOT EDIT THIS FUNCTION
		*/
		public void reportError(String errorString){
			setText(errorString);
			setType(ERROR);
		}

		public void processString() {
			Token t = _factory.create(_tokenFactorySourcePair, _type, _text, _channel, _tokenStartCharIndex, getCharIndex()-1, _tokenStartLine, _tokenStartCharPositionInLine);
			String text = t.getText();
	         
	         StringBuilder str= new StringBuilder(0);
	          int length=text.length();
	          int count=0; // to keep track of length of processed string
	            if(length==1)
	            { reportError("EOF in string constant");
	              return;
	            }

	         for(int i=1;i<length;i++)
	         { 
	                  if(count==1024)  
	                 {if(text.charAt(i)=='"')/*if the length of string is 1024 and if next char is not " then the string is not valid*/
	                    break;
	                    else
	                  reportError("String constant too long");return;
	                  }
	      
				
	                if(text.charAt(i)=='\n')
	                {reportError("Unterminated string constant");return;}
	                 else if(text.charAt(i)=='\u0000')
	                 {reportError("String contains null character.");return;}
	            
	                else if(text.charAt(i)=='\\')
	                {  
	                 if(i<length-2)
	                   {
	                     if(text.charAt(i+1)=='b')
	                      {str.append('\b');}
	                      else if(text.charAt(i+1)=='t')
	                      {str.append('\t');}
	                      else if(text.charAt(i+1)=='n')
	                      {str.append('\n');}
	                      else if(text.charAt(i+1)=='f')
	                      {str.append('\f');}
	                      else if(text.charAt(i+1)=='\u0000')
	                      {reportError("String contains escaped null character.");return;}
	                      else
	                      {str.append(text.charAt(i+1));}

	                      count++;
	                      i++;
	                   }
	                   else if(i==length-2)
	                   {  if(text.charAt(i+1)=='\u0000')
			       { reportError("String contains escaped null character."); }
			       else
	        	        {reportError("EOF in string constant");}
				  return;
			  }
	                   else
	                   {reportError("backslash at end of file");
					   return;
	                   }

	                }
	                else
	                 { if(i==length-1&&text.charAt(i)!='"')
					    {reportError("EOF in string constant");return;}

	                            if(i==length-1)
					            break;
					            
					 str.append(text.charAt(i));
	                 count++;
	                 }
	             

	         }
	              setText(str.toString());
				  return;
			//write your code to test strings here

		}


	public CoolLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "CoolLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 4:
			STR_CONST_action((RuleContext)_localctx, actionIndex);
			break;
		case 44:
			UNMATCHED_C_action((RuleContext)_localctx, actionIndex);
			break;
		case 46:
			ENDOFFILE1_action((RuleContext)_localctx, actionIndex);
			break;
		case 50:
			ENDOFFILE2_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void STR_CONST_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			processString();
			break;
		}
	}
	private void UNMATCHED_C_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:
			reportError("Unmatched *)");
			break;
		}
	}
	private void ENDOFFILE1_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2:
			reportError("EOF in comment");
			break;
		}
	}
	private void ENDOFFILE2_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3:
			reportError("EOF in comment");
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\28\u0162\b\1\b\1\b"+
		"\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n"+
		"\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21"+
		"\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30"+
		"\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37"+
		"\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t"+
		"*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63"+
		"\4\64\t\64\4\65\t\65\4\66\t\66\4\67\t\67\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u0080\n\4\3\5\6\5\u0083\n\5\r\5\16\5\u0084"+
		"\3\6\3\6\3\6\3\6\7\6\u008b\n\6\f\6\16\6\u008e\13\6\3\6\5\6\u0091\n\6\3"+
		"\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16"+
		"\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25"+
		"\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\30\6\30\u00ba\n\30\r\30\16\30\u00bb"+
		"\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33"+
		"\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3\""+
		"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3&\3"+
		"&\3&\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3(\3)\3)\3)\3)\3*\3*\7*\u0114\n"+
		"*\f*\16*\u0117\13*\3+\3+\7+\u011b\n+\f+\16+\u011e\13+\3,\3,\3,\3,\7,\u0124"+
		"\n,\f,\16,\u0127\13,\3,\5,\u012a\n,\3,\3,\3-\3-\3-\3-\3-\3-\3.\3.\3.\3"+
		".\3.\3/\3/\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3\61\3\61\3\61\3\62\3\62"+
		"\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\63\3\64\3\64\3\64\3\64\3\65\3\65"+
		"\3\65\3\65\3\65\3\65\3\66\3\66\3\66\3\66\3\66\3\66\3\67\3\67\3\67\3\67"+
		"\4\u008c\u0125\28\5\r\7\31\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\16\31"+
		"\17\33\20\35\21\37\22!\23#\24%\25\'\26)\27+\30-\32/\33\61-\63\34\65\35"+
		"\67\369\37; =!?\"A#C$E%G&I\'K(M)O*Q+S,U\4W\5Y.[/]\60_\3a\61c\62e\63g\64"+
		"i\65k\66m\67o8\5\2\3\4\32\4\2TTtt\4\2WWww\4\2GGgg\4\2CCcc\4\2NNnn\4\2"+
		"UUuu\3\2\62;\4\3\f\f$$\4\2\13\17\"\"\4\2EEee\4\2HHhh\4\2KKkk\4\2PPpp\4"+
		"\2JJjj\4\2VVvv\4\2QQqq\4\2RRrr\4\2YYyy\4\2XXxx\4\2FFff\3\2C\\\7\2\62;"+
		"C\\aac|~~\3\2c|\3\3\f\f\u0167\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"+
		"!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3"+
		"\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2"+
		"\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E"+
		"\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2"+
		"\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2"+
		"\2_\3\2\2\2\3a\3\2\2\2\3c\3\2\2\2\3e\3\2\2\2\3g\3\2\2\2\4i\3\2\2\2\4k"+
		"\3\2\2\2\4m\3\2\2\2\4o\3\2\2\2\5q\3\2\2\2\7s\3\2\2\2\t\177\3\2\2\2\13"+
		"\u0082\3\2\2\2\r\u0086\3\2\2\2\17\u0094\3\2\2\2\21\u0096\3\2\2\2\23\u0098"+
		"\3\2\2\2\25\u009a\3\2\2\2\27\u009c\3\2\2\2\31\u009e\3\2\2\2\33\u00a0\3"+
		"\2\2\2\35\u00a2\3\2\2\2\37\u00a4\3\2\2\2!\u00a6\3\2\2\2#\u00a8\3\2\2\2"+
		"%\u00aa\3\2\2\2\'\u00ac\3\2\2\2)\u00ae\3\2\2\2+\u00b0\3\2\2\2-\u00b2\3"+
		"\2\2\2/\u00b5\3\2\2\2\61\u00b9\3\2\2\2\63\u00bf\3\2\2\2\65\u00c5\3\2\2"+
		"\2\67\u00ca\3\2\2\29\u00cd\3\2\2\2;\u00d0\3\2\2\2=\u00d3\3\2\2\2?\u00dc"+
		"\3\2\2\2A\u00e0\3\2\2\2C\u00e5\3\2\2\2E\u00ea\3\2\2\2G\u00ef\3\2\2\2I"+
		"\u00f5\3\2\2\2K\u00fa\3\2\2\2M\u00ff\3\2\2\2O\u0102\3\2\2\2Q\u0106\3\2"+
		"\2\2S\u010d\3\2\2\2U\u0111\3\2\2\2W\u0118\3\2\2\2Y\u011f\3\2\2\2[\u012d"+
		"\3\2\2\2]\u0133\3\2\2\2_\u0138\3\2\2\2a\u013a\3\2\2\2c\u013e\3\2\2\2e"+
		"\u0144\3\2\2\2g\u014a\3\2\2\2i\u014e\3\2\2\2k\u0152\3\2\2\2m\u0158\3\2"+
		"\2\2o\u015e\3\2\2\2qr\7=\2\2r\6\3\2\2\2st\7?\2\2tu\7@\2\2u\b\3\2\2\2v"+
		"w\7v\2\2wx\t\2\2\2xy\t\3\2\2y\u0080\t\4\2\2z{\7h\2\2{|\t\5\2\2|}\t\6\2"+
		"\2}~\t\7\2\2~\u0080\t\4\2\2\177v\3\2\2\2\177z\3\2\2\2\u0080\n\3\2\2\2"+
		"\u0081\u0083\t\b\2\2\u0082\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0082"+
		"\3\2\2\2\u0084\u0085\3\2\2\2\u0085\f\3\2\2\2\u0086\u008c\7$\2\2\u0087"+
		"\u0088\7^\2\2\u0088\u008b\13\2\2\2\u0089\u008b\13\2\2\2\u008a\u0087\3"+
		"\2\2\2\u008a\u0089\3\2\2\2\u008b\u008e\3\2\2\2\u008c\u008d\3\2\2\2\u008c"+
		"\u008a\3\2\2\2\u008d\u0090\3\2\2\2\u008e\u008c\3\2\2\2\u008f\u0091\t\t"+
		"\2\2\u0090\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0093\b\6\2\2\u0093"+
		"\16\3\2\2\2\u0094\u0095\7*\2\2\u0095\20\3\2\2\2\u0096\u0097\7+\2\2\u0097"+
		"\22\3\2\2\2\u0098\u0099\7<\2\2\u0099\24\3\2\2\2\u009a\u009b\7B\2\2\u009b"+
		"\26\3\2\2\2\u009c\u009d\7.\2\2\u009d\30\3\2\2\2\u009e\u009f\7-\2\2\u009f"+
		"\32\3\2\2\2\u00a0\u00a1\7/\2\2\u00a1\34\3\2\2\2\u00a2\u00a3\7,\2\2\u00a3"+
		"\36\3\2\2\2\u00a4\u00a5\7\61\2\2\u00a5 \3\2\2\2\u00a6\u00a7\7\u0080\2"+
		"\2\u00a7\"\3\2\2\2\u00a8\u00a9\7>\2\2\u00a9$\3\2\2\2\u00aa\u00ab\7?\2"+
		"\2\u00ab&\3\2\2\2\u00ac\u00ad\7}\2\2\u00ad(\3\2\2\2\u00ae\u00af\7\177"+
		"\2\2\u00af*\3\2\2\2\u00b0\u00b1\7\60\2\2\u00b1,\3\2\2\2\u00b2\u00b3\7"+
		">\2\2\u00b3\u00b4\7?\2\2\u00b4.\3\2\2\2\u00b5\u00b6\7>\2\2\u00b6\u00b7"+
		"\7/\2\2\u00b7\60\3\2\2\2\u00b8\u00ba\t\n\2\2\u00b9\u00b8\3\2\2\2\u00ba"+
		"\u00bb\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00bd\3\2"+
		"\2\2\u00bd\u00be\b\30\3\2\u00be\62\3\2\2\2\u00bf\u00c0\t\13\2\2\u00c0"+
		"\u00c1\t\6\2\2\u00c1\u00c2\t\5\2\2\u00c2\u00c3\t\7\2\2\u00c3\u00c4\t\7"+
		"\2\2\u00c4\64\3\2\2\2\u00c5\u00c6\t\4\2\2\u00c6\u00c7\t\6\2\2\u00c7\u00c8"+
		"\t\7\2\2\u00c8\u00c9\t\4\2\2\u00c9\66\3\2\2\2\u00ca\u00cb\t\f\2\2\u00cb"+
		"\u00cc\t\r\2\2\u00cc8\3\2\2\2\u00cd\u00ce\t\r\2\2\u00ce\u00cf\t\f\2\2"+
		"\u00cf:\3\2\2\2\u00d0\u00d1\t\r\2\2\u00d1\u00d2\t\16\2\2\u00d2<\3\2\2"+
		"\2\u00d3\u00d4\t\r\2\2\u00d4\u00d5\t\16\2\2\u00d5\u00d6\t\17\2\2\u00d6"+
		"\u00d7\t\4\2\2\u00d7\u00d8\t\2\2\2\u00d8\u00d9\t\r\2\2\u00d9\u00da\t\20"+
		"\2\2\u00da\u00db\t\7\2\2\u00db>\3\2\2\2\u00dc\u00dd\t\6\2\2\u00dd\u00de"+
		"\t\4\2\2\u00de\u00df\t\20\2\2\u00df@\3\2\2\2\u00e0\u00e1\t\6\2\2\u00e1"+
		"\u00e2\t\21\2\2\u00e2\u00e3\t\21\2\2\u00e3\u00e4\t\22\2\2\u00e4B\3\2\2"+
		"\2\u00e5\u00e6\t\22\2\2\u00e6\u00e7\t\21\2\2\u00e7\u00e8\t\21\2\2\u00e8"+
		"\u00e9\t\6\2\2\u00e9D\3\2\2\2\u00ea\u00eb\t\20\2\2\u00eb\u00ec\t\17\2"+
		"\2\u00ec\u00ed\t\4\2\2\u00ed\u00ee\t\16\2\2\u00eeF\3\2\2\2\u00ef\u00f0"+
		"\t\23\2\2\u00f0\u00f1\t\17\2\2\u00f1\u00f2\t\r\2\2\u00f2\u00f3\t\6\2\2"+
		"\u00f3\u00f4\t\4\2\2\u00f4H\3\2\2\2\u00f5\u00f6\t\13\2\2\u00f6\u00f7\t"+
		"\5\2\2\u00f7\u00f8\t\7\2\2\u00f8\u00f9\t\4\2\2\u00f9J\3\2\2\2\u00fa\u00fb"+
		"\t\4\2\2\u00fb\u00fc\t\7\2\2\u00fc\u00fd\t\5\2\2\u00fd\u00fe\t\13\2\2"+
		"\u00feL\3\2\2\2\u00ff\u0100\t\21\2\2\u0100\u0101\t\f\2\2\u0101N\3\2\2"+
		"\2\u0102\u0103\t\16\2\2\u0103\u0104\t\4\2\2\u0104\u0105\t\23\2\2\u0105"+
		"P\3\2\2\2\u0106\u0107\t\r\2\2\u0107\u0108\t\7\2\2\u0108\u0109\t\24\2\2"+
		"\u0109\u010a\t\21\2\2\u010a\u010b\t\r\2\2\u010b\u010c\t\25\2\2\u010cR"+
		"\3\2\2\2\u010d\u010e\t\16\2\2\u010e\u010f\t\21\2\2\u010f\u0110\t\20\2"+
		"\2\u0110T\3\2\2\2\u0111\u0115\t\26\2\2\u0112\u0114\t\27\2\2\u0113\u0112"+
		"\3\2\2\2\u0114\u0117\3\2\2\2\u0115\u0113\3\2\2\2\u0115\u0116\3\2\2\2\u0116"+
		"V\3\2\2\2\u0117\u0115\3\2\2\2\u0118\u011c\t\30\2\2\u0119\u011b\t\27\2"+
		"\2\u011a\u0119\3\2\2\2\u011b\u011e\3\2\2\2\u011c\u011a\3\2\2\2\u011c\u011d"+
		"\3\2\2\2\u011dX\3\2\2\2\u011e\u011c\3\2\2\2\u011f\u0120\7/\2\2\u0120\u0121"+
		"\7/\2\2\u0121\u0125\3\2\2\2\u0122\u0124\13\2\2\2\u0123\u0122\3\2\2\2\u0124"+
		"\u0127\3\2\2\2\u0125\u0126\3\2\2\2\u0125\u0123\3\2\2\2\u0126\u0129\3\2"+
		"\2\2\u0127\u0125\3\2\2\2\u0128\u012a\t\31\2\2\u0129\u0128\3\2\2\2\u012a"+
		"\u012b\3\2\2\2\u012b\u012c\b,\3\2\u012cZ\3\2\2\2\u012d\u012e\7*\2\2\u012e"+
		"\u012f\7,\2\2\u012f\u0130\3\2\2\2\u0130\u0131\b-\3\2\u0131\u0132\b-\4"+
		"\2\u0132\\\3\2\2\2\u0133\u0134\7,\2\2\u0134\u0135\7+\2\2\u0135\u0136\3"+
		"\2\2\2\u0136\u0137\b.\5\2\u0137^\3\2\2\2\u0138\u0139\13\2\2\2\u0139`\3"+
		"\2\2\2\u013a\u013b\13\2\2\2\u013b\u013c\7\2\2\3\u013c\u013d\b\60\6\2\u013d"+
		"b\3\2\2\2\u013e\u013f\7*\2\2\u013f\u0140\7,\2\2\u0140\u0141\3\2\2\2\u0141"+
		"\u0142\b\61\3\2\u0142\u0143\b\61\7\2\u0143d\3\2\2\2\u0144\u0145\7,\2\2"+
		"\u0145\u0146\7+\2\2\u0146\u0147\3\2\2\2\u0147\u0148\b\62\3\2\u0148\u0149"+
		"\b\62\b\2\u0149f\3\2\2\2\u014a\u014b\13\2\2\2\u014b\u014c\3\2\2\2\u014c"+
		"\u014d\b\63\3\2\u014dh\3\2\2\2\u014e\u014f\13\2\2\2\u014f\u0150\7\2\2"+
		"\3\u0150\u0151\b\64\t\2\u0151j\3\2\2\2\u0152\u0153\7,\2\2\u0153\u0154"+
		"\7+\2\2\u0154\u0155\3\2\2\2\u0155\u0156\b\65\3\2\u0156\u0157\b\65\b\2"+
		"\u0157l\3\2\2\2\u0158\u0159\7*\2\2\u0159\u015a\7,\2\2\u015a\u015b\3\2"+
		"\2\2\u015b\u015c\b\66\3\2\u015c\u015d\b\66\7\2\u015dn\3\2\2\2\u015e\u015f"+
		"\13\2\2\2\u015f\u0160\3\2\2\2\u0160\u0161\b\67\3\2\u0161p\3\2\2\2\17\2"+
		"\3\4\177\u0084\u008a\u008c\u0090\u00bb\u0115\u011c\u0125\u0129\n\3\6\2"+
		"\b\2\2\7\3\2\3.\3\3\60\4\7\4\2\6\2\2\3\64\5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}