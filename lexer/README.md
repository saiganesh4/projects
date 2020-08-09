# COOL Compiler #
               Readme file for programming assignment 1
                           CS3020-COMPILERS-1
--------------------------------------------------------------------------------
# Explanation for .g4 file:
Main parts of this file handling strings and comments,remaining are slightly easier.

## Design desicions for comments
- when \-\- is read then it is for single line comment, we use skip command for ignoring these type of comments.single line comments either ends with new line character or with EOF.
- whenever '(\*' is read for the first time we go to mode MCOMMENTS by using pushMode command.After that if we encounter:
     1. EOF- It means EOF is present in comments, so we report error by using     reportError function.
    2. '(\*'- This means comments are nested and we go to mode NCOMMENTS using pushMode.
    3. '*)'- This makes the comment to end, so we go to default mode by using popMode command.
   4. If anything else is encountered, we just ignore them
 we use skip command in all cases (except for the 1st case) because we dont need to tokenize comments.
- In NCOMMENTS mode:
    1. When we encounter EOF, it means EOF is present in comments, we report error by using reportError function.
   2. When we encounter '(\*', it indicates the starting point of inner nested comment, so we use pushMode to push NCOMMENTS mode once again on to the stack.
  3. When we encounter '*)', it indicates ending of comment, so we use popMode command to pop the top mode in the stack.
  4. when we encounter anything else, we simply ignore them.
 we use skip command in all cases (except for the first case) for the same reason as mentioned above.
- If we encounter '*)' first then we have to report error.

## Design decisions for reserved words
- All reserved are case insensitive except Bool constants.
- first char in true and false must be in lower case and remaining characters can be lower or upper case .so we use 't'[Rr][Uu][Ee] and 'f'[Aa][Ll][Ss][Ee].
- Remaining reserved words are case insensitive. So,for every reserved word and for every char in that we use [Xx] where X is any char in reserved word.


## Design decisions for strings
- In processString function, **text** string contains the string we have captured so far. **str** is set to empty and we intialise count variable to 0, which keeps track of lenght of **str**
- First we check if the length of text is 1 or not if it is one then it means that text contains only ",this means EOF is there in body of string and we report error.
- After that,we start traversing the **text** from second char(because the first char is always " and we dont need it) to the end of the **text**.
- While traversing we look at every char in the string and we always checks count varibale if it is equals to 1024 and if next char is ", then we are done.if the next char is not ", then we report error.
- While traversing if we encounter
   1. Un-escaped new line character we report error.
   2. NULL character, we report error.
   3. \n,\b,\t,\f then we add  single character to **str** which represents their corresponding escaped meaning and increase count value by 1.
   4. \ followed by null character then we report error.
   5. \ followed by new line, this is valid and we just add \n char to **str** and increase count by 1.
   6. \ followed by any char other than n,b,t,f,null, we just add that char to **str** and increase count by 1.
   7. \ at end we report error
   8. if \ is second last char in **text**, then we report error. 
   9. At the end we return **str**
  
## Design decisions for operators 
- we use separate rule for every operator and for every valid special chars.EX:
   
      PLUS        :'+';
      MINUS       :'-';
      STAR        :'*';
      SLASH       :'/';
      LT          :'<';
      EQUALS      :'=';
      LPAREN      : '(';
      RPAREN      : ')';
      COLON       : ':';
      ATSYM       : '@';
## Design decisions for Int constants
Integer constant must have atleast one number. So,we use rule 
INT_CONST   : [0-9]+;

## Design decisions for identifiers
- Type identifiers : they have to start with upper case letter and can contain lower cases letters, upper case letters, '_' and numbers. so we use
   TYPEID      :[A-Z][A-Z|a-z|0-9|_]*;
- Object identifiers: they have to start with lower case letter and can contain lower cases letters, upper case letters, '_' and numbers. so we use
    OBJECTID    :[a-z][A-Z|a-z|0-9|_]*;
## Design decisions for white spaces
we just ignore white spaces . so , we use following rule to handle them.
WHITES      :[ \n\f\r\t\u000b]+->skip;
\u000b is same as \v.
------------------------------------------------------------------------------
 If an input is not matched by any of the above rules,then it is captured by Error rule.
ERROR       : . ;

# TEST CASES
these are the test cases with .cl extension.
- backslashatEOF: this file contains backslash at end of the file
- comments: this file contains single comment, multi line comment,nested comments,EOF in comment.
- EOFinstring1: In this file string doesnot contain " at the end.
- EOFinstring2: In this file string contains escaped " at the end.
- EOFinstring3:this file contains only " .
- constants: this file contains integer constants, bool constants,string constans.
- identifiers: this file contains identifiers.
- escapednewline:this file contains a string in which escaped new line is present.
- invalidchars:this file contains some characters that are not allowed to use in cool.
- espacednullcharinstr:this file contains escaped null character in string.
- reservedwords:this file contains some reserved words in cool.
- operators:this file contains some valid operators in cool.
- strlen: this file contains a string of length 1024 and a string of length 1025.
- unescapednullcharinstr:this file contains unescaped null char in string.
- unescapednewline: this file contains unescaped new line character in it.
- validcoolprogram:this file contains a valid cool program.

These files cover all the test cases for cool lexer.


