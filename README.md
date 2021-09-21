# programming specifications 
- Indentation
  <br>_1_.Four Spaces are often used as a unit of indentation,which can keep our code clean and artistic.<br><br>
- Variable naming
  <br>_1_.The most important and most overlooked of all is that no confusing names.<br>
  <br>_2_.When a variable name consists of multiple words, the first letter of the first word is lowercase and the first letter of the following words is uppercase,  such as **computedValues** and **index**.<br><br>
  
  
- Maximum number of characters per line<br>
-The maximum number of characters in a single line is **120**. If the number of characters exceeds the limit, line breaks are required.<br><br>
_1_.The second line is indented 4 Spaces from the first line, starting with the third line and not further indented.<br><br>
_2_.The operator is wrapped with the following.<br><br>
_3_.The dot symbol of the method call is wrapped with the following.<br><br>
_4_.When multiple arguments n a method call require line breaks, do so after commas.<br><br>
_5_.Do not wrap a line before parentheses.<br><br>
     For example:<br>

     StringBuilder sb = new StringBuilder();<br>
     sb.append("Jack").append("Ma")...<br>
.append("123456")...<br>
.append("123456")...<br>
.append("123456");<br><br>
 
     int result = function1(flag) + function2(flag) + ...<br>
      + function10(flag); <br><br>
      
- Maximum number of function lines<br>
-Do not write too many lines in a function; too many lines can increase complexity and make reading and maintenance difficult.
I personally don't think you should have more than 30 lines of code in a function<br><br>


- Function and class naming<br>
-Class names and Fuunction names must be humped in UpperCamelCase style, that is, the first letter of each word must be capitalized, and the public class name must be the same as the project name.<br><br>

- Constant<br>
-Constant names are all capitalized, words are separated by underscores, and semantic expression complete and clear, not too long names, such as **MAX_STOCK_COUNT**.<br><br>
- Blank line rule<br>
-Blank lines separate logically related code segments to improve readability.<br><br>
- Annotation rules<br>
-Content should be simple, clear, accurate meaning, to prevent annotation ambiguity, wrong annotation is not only useless but harmful.
- Space before and after operator<br>
-Operators should be preceded by a space<br><br>
- Other rules<br>
-Don't name any language banned by any country
