/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.util.*;
import java.lang.*;
/**
 *
 * @author Tejashree pc
 */
public class IntWord {
    public static void main(String args[]) throws IOException
    {
        try
        {
        Scanner s=new Scanner(System.in);
        System.out.print("Enter the integer: ");
        int n=s.nextInt();
        int abc=(int)Math.pow(2, 31)-1;
        System.out.println(abc);
        if(n>abc)
            throw new Exception();
        String solution=numberToWords(n);
        System.out.println("String is: "+solution);
        
        }
        catch(Exception e)
        {
            System.out.println("Do it right!Enter value less than or equal to 2^31-1!");
        }
    }
    public static String numberToWords(int num)
    {
        String sol=new String();
        int c=0;
        int b=0;
        if(num==0)
            return "Zero";
        while(num!=0)
        {
            
            if(sol.length()>0&&!(sol.charAt(0)==' '))
            {
                System.out.println("newnwne");
                sol=" "+sol;
            }
            c++;
            int a=num%10;
            int aa=num%100;
            int aaa=num%1000;
            if(c==1&&(aa<10||aa>19))
                sol=units(a,sol);
            else if(c==2)
                sol=tens(a,b,sol);
            else if(c==3)
                sol=hundreds(a,sol);
            else if(c==4)
                sol=thousands(a,aa,aaa,sol);
            else if(c==5)
                sol=tens(a,b,sol);
            else if(c==6)
                sol=hundreds(a,sol);
            else if(c==7)
                sol=millions(a,aa,aaa,sol);
            else if(c==8)
                sol=tens(a,b,sol);
            else if(c==9)
                sol=hundreds(a,sol);
            else if(c==10)
                sol=billions(a,sol);
            num=num/10;
            System.out.println(num);
            b=a;
            //sol=" "+sol;
        }
        return sol;
    }
    public static String units(int a, String sol)
    {
            if(a==1)
               sol="One"+sol;
            else if(a==2)
                sol="Two"+sol;
            else if(a==3)
                sol="Three"+sol;
            else if(a==4)
                sol="Four"+sol;
            else if(a==5)
                sol="Five"+sol;
            else if(a==6)
                sol="Six"+sol;
            else if(a==7)
                sol="Seven"+sol;
            else if(a==8)
                sol="Eight"+sol;
            else if(a==9)
                sol="Nine"+sol;
            else if(a==0)
                return sol;
        return sol;
    }
    
     public static String tens(int a, int b, String sol)
    {       
            if(a==1)
            {
                if(b==0)
                    sol="Ten"+sol;
                else if(b==1)
                    sol="Eleven"+sol;
                else if(b==2)
                    sol="Twelve"+sol;
                else if(b==3)
                    sol="Thirteen"+sol;
                else if(b==4)
                    sol="Fourteen"+sol;
                else if(b==5)
                    sol="Fifteen"+sol;
                else if(b==6)
                    sol="Sixteen"+sol;
                else if(b==7)
                    sol="Seventeen"+sol;
                else if(b==8)
                    sol="Eighteen"+sol;
                else if(b==9)
                    sol="Nineteen"+sol;
            }
            else if(a==2)
                sol="Twenty"+sol;
            else if(a==3)
                sol="Thirty"+sol;
            else if(a==4)
                sol="Forty"+sol;
            else if(a==5)
                sol="Fifty"+sol;
            else if(a==6)
                sol="Sixty"+sol;
            else if(a==7)
                sol="Seventy"+sol;
            else if(a==8)
                sol="Eighty"+sol;
            else if(a==9)
                sol="Ninety"+sol;
            else if(a==0)
                return sol;
        return sol;
    }
    public static String hundreds(int a, String sol)
    {
        if(a==0)
            return sol;
        sol=" Hundred"+sol;
        sol=units(a,sol);
        return sol;
    }
    public static String thousands(int a, int aa,int aaa, String sol)
    {
        
        //sol=" Thousand"+sol;
        if(!(aa<10||aa>19))
        {
            sol=" Thousand"+sol;
            return sol;
        }
        if(aa!=0&&(aa<10||aa>19))
        {
            sol=" Thousand"+sol;
            sol=units(a, sol);
            return sol;
        }
        if(aaa!=0&&(aaa<10||aaa>19))
        {
            sol=" Thousand"+sol;
            return sol;
        }
        if(a==0)
            return sol;
        return sol;
    } 
    public static String millions(int a, int aa,int aaa, String sol)
    {
        
        if(!(aa<10||aa>19))
        {
            sol=" Million"+sol;
            return sol;
        }
        if(aa!=0&&(aa<10||aa>19))
        {
            sol=" Million"+sol;
            sol=units(a,sol);
            return sol;
        }
         if(aaa!=0&&(aaa<10||aaa>19))
        {
            sol=" Million"+sol;
            return sol;
        }
        if(a==0)
            return sol;
        return sol;
    }
    public static String billions(int a, String sol)
    {
        sol=" Billion"+sol;
        sol=units(a,sol);
        return sol;
    }
}

