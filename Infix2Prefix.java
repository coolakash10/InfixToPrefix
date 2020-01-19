/*********************************************************************************************************************
     **
     **  Infix to prefix conversion in C++ using stack and linked list
     **  Input Infix expression must be in a desired format. 
     **  Operands and operator, both must be single character.
     **  Only '+'  ,  '-'  , '*', '/'  operators are expected. 
     **  '(' , ')' braces are expected.

     **  Written By:    Akash Vishwas Londhe
     **
*********************************************************************************************************************/


import java.util.*;
import java.lang.*;

class Infix2Prefix
{

	public static void main(String[] args)
	{

		String exp="(a-b/c)*(a/k-l)";
		System.out.println("PREFIX EXPRESSION : "+ prefix(exp));

	}

	private static String prefix(String s)
	{

		Stack<Character> stack=new Stack();
		StringBuffer exp = new StringBuffer(s);
		String res="";
		exp.reverse();
		
		for(int i=0;i<exp.length();i++)
		{

			if(isOperand(exp.charAt(i)))
				res+=exp.charAt(i);
			else if(isOperator(exp.charAt(i)) )
			{
				while(!stack.empty() && !isHighPrecedance(exp.charAt(i),stack.peek()) && exp.charAt(i)!=')')
				{
					res+=stack.pop();
				}
				stack.push(exp.charAt(i));
			}
			else if(exp.charAt(i)==')')
			{
				stack.push(exp.charAt(i));
			}
			else if(exp.charAt(i)=='(')
			{
				while(!stack.empty() && stack.peek()!=')')
				{
					res+=stack.pop();
				}
				stack.pop();
			}
		}
		while(!stack.empty())
			res+=stack.pop();
		return (new StringBuffer(res).reverse()).toString();

	}

	private static boolean isOperand(char c)
	{

		switch(c)
		{
			case '+':
			case '-':
			case '*':
			case '/':
			case '(':
			case ')':return false;
		}
		return true;

	}

	private static boolean isOperator(char c)
	{

		switch(c)
		{
			case '+':
			case '-':
			case '*':
			case '/':
			return true;
		}
		return false;

	}

	private static boolean isHighPrecedance(char c,char d)
	{

		if(priority(c)>priority(d))
			return true;
		return false;

	}

	private static int priority(char c)
	{

		switch(c)
		{
			case '+':
			case '-':return 1;
			case '*':
			case '/':return 2;
		}
		return 0;

	}

}