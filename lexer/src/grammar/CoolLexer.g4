lexer grammar CoolLexer;

tokens{
	ERROR,
	TYPEID,
	OBJECTID,
	BOOL_CONST,
	INT_CONST,
	STR_CONST,
	LPAREN,
	RPAREN,
	COLON,
	ATSYM,
	SEMICOLON,
	COMMA,
	PLUS,
	MINUS,
	STAR,
	SLASH,
	TILDE,
	LT,
	EQUALS,
	LBRACE,
	RBRACE,
	DOT,
	DARROW,
	LE,
	ASSIGN,
	CLASS,
	ELSE,
	FI,
	IF,
	IN,
	INHERITS,
	LET,
	LOOP,
	POOL,
	THEN,
	WHILE,
	CASE,
	ESAC,
	OF,
	NEW,
	ISVOID,
	NOT
}

/*
  DO NOT EDIT CODE ABOVE THIS LINE
*/

@members{

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
}

/*
	WRITE ALL LEXER RULES BELOW
*/

SEMICOLON   : ';';
DARROW      : '=>';
BOOL_CONST  : 't'[Rr][Uu][Ee]|'f'[Aa][Ll][Ss][Ee];
INT_CONST   : [0-9]+;
STR_CONST   :'"'('\\'.|.)*?('"'|'\n'|(EOF)) {processString();}; /*catches the string*/
LPAREN      : '(';
RPAREN      : ')';
COLON       : ':';
ATSYM       : '@';
COMMA       :',';
PLUS        :'+';
MINUS       :'-';
STAR        :'*';
SLASH       :'/';
TILDE       :'~';
LT          :'<';
EQUALS      :'=';
LBRACE      :'{';
RBRACE      :'}';
DOT         :'.';  
LE          :'<=';
ASSIGN      :'<-';
WHITES      :[ \n\f\r\t\u000b]+->skip;
CLASS       :[Cc][Ll][Aa][Ss][Ss];
ELSE        :[Ee][Ll][Ss][Ee];
FI          :[Ff][Ii];
IF          :[Ii][Ff];
IN          :[Ii][Nn];
INHERITS    :[Ii][Nn][Hh][Ee][Rr][Ii][Tt][Ss];
LET         :[Ll][Ee][Tt];
LOOP        :[Ll][Oo][Oo][Pp];
POOL        :[Pp][Oo][Oo][Ll];
THEN        :[Tt][Hh][Ee][Nn];
WHILE       :[Ww][Hh][Ii][Ll][Ee];
CASE        :[Cc][Aa][Ss][Ee];
ESAC        :[Ee][Ss][Aa][Cc];
OF          :[Oo][Ff];
NEW         :[Nn][Ee][Ww];
ISVOID      :[Ii][Ss][Vv][Oo][Ii][Dd];
NOT         :[Nn][Oo][Tt];
TYPEID      :[A-Z][A-Z|a-z|0-9|_]*;
OBJECTID    :[a-z][A-Z|a-z|0-9|_]*;
SIN_LINE_C  :'--'.*?('\n'|(EOF)) ->skip;          /*single line comment*/
MUL_LIN_C   :'(*'->skip,pushMode(MCOMMENTS);      /*multi line comment*/
UNMATCHED_C :'*)'{reportError("Unmatched *)");};
ERROR       :.;

mode MCOMMENTS;
ENDOFFILE1            :.(EOF) {reportError("EOF in comment");};  /*if EOF comes in comment*/
NESTEDCOMMENT1        :'(*'->skip,pushMode(NCOMMENTS);
ENDOFCOMMENT1         :'*)'->skip,popMode;
BODY1                 :. ->skip;



mode NCOMMENTS;
ENDOFFILE2            :.(EOF) {reportError("EOF in comment");}; /*if EOF comes in comment*/
ENDOFCOMMENT2         :'*)'->skip,popMode;
NESTEDCOMMENT2        :'(*'->skip,pushMode(NCOMMENTS);
BODY2                 :. ->skip;

