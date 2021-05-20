package Example4;
import java.util.*;

public class Example4
{
    public static void main(String[] args)
    {
       double                 leftOperand, result, rightOperand;
       String                 leftString, operator, rightString;
       StringTokenizer        tokenizer,tokenizer2;
       Scanner in = new Scanner(System.in);
       tokenizer2 = new StringTokenizer(in.nextLine(), " ");
       int cnt=0;
       while(tokenizer2.hasMoreTokens())
       {
//    	   System.out.println(tokenizer2.nextToken());
//       }
//    	   tokenizer = new StringTokenizer(in.nextLine(), "+-*/",true);
    	   tokenizer = new StringTokenizer(tokenizer2.nextToken(), "+-*/", true);
	       try
	       {
	          leftString   = tokenizer.nextToken();
	          operator     = tokenizer.nextToken();
	          rightString  = tokenizer.nextToken();
	
	          leftOperand  = Double.parseDouble(leftString);
	          rightOperand = Double.parseDouble(rightString);
	
	          if (operator.equals("+"))
	             result = leftOperand + rightOperand;
	          if (operator.equals("-"))
	              result = leftOperand - rightOperand;
	          if (operator.equals("*"))
	              result = leftOperand * rightOperand;
	          if (operator.equals("/"))
	              result = leftOperand / rightOperand;
	          else
	             result = 0.0;
	
	          System.out.println("Result: " + result);
	       }
	       catch (NoSuchElementException nsee)
	       {
	          System.out.println("Invalid syntax");
	       }
	       catch (NumberFormatException nfe)
	       {
	          System.out.println("One or more operands is not a number");
	       }
	       catch()
	       {
	    	   
	       }
       }


    }
}


