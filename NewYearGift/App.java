package com.codebehind.first;

import java.util.Scanner;
interface Gift
{
	public void sortGift(int no_of_gifts,int numcandies[]);
    public int chocwt(int no_of_choc);
	public int sweetwt(int no_of_sweet);
}
abstract class GiftSort implements Gift
{
	public void sortGift(int no_of_gifts,int numcandies[])
	{
		int temp=0;
		int s[]=new int[no_of_gifts];
		for(int i=0;i<no_of_gifts;i++)
		{
			s[i]=i+1;
		}
		for(int i=0;i<no_of_gifts;i++)
		{
			for(int j=i+1;j<no_of_gifts;j++)
			{
				if(numcandies[i]>numcandies[j])
				{
					temp=numcandies[i];
					numcandies[i]=numcandies[j];
					numcandies[j]=temp;
					temp=s[i];
					s[i]=s[j];
					s[j]=temp;
				}
			}
		}
		for(int i=0;i<no_of_gifts;i++)
		{
			System.out.println("gift"+s[i]);
		}
	}
}
abstract class Chocolates extends GiftSort
{
	int cwt=6;
	public int chocwt(int no_of_choc)
	{
		return(no_of_choc*cwt);
	}
}
class Sweets extends Chocolates
{
	int swt=4;
	public int sweetwt(int no_of_sweet)
	{
		return(no_of_sweet*swt);
	}
}
public class App {

	public static void main(String[] args) {

		Scanner input=new Scanner(System.in);
		System.out.println("Enter no. of children");
		int nc=input.nextInt();
		int Gift[]=new int[nc];
		Chocolates snicker=new Sweets();
		Chocolates munch=new Sweets();
		Chocolates lollipop=new Sweets();
		int tweight[]=new int[nc];
		Sweets gulabjam=new Sweets();
		Sweets jalebi=new Sweets();
		int candies[]=new int[nc];
		
		for(int i=0;i<nc;i++)
		{
			int chocwt=0;
			int sweetwt=0;
			int numcandies=0;
			System.out.println("Enter number of snicker choclates in gift"+(i+1));
			int snikchoc=input.nextInt();
			chocwt+=snicker.chocwt(snikchoc);
			System.out.println("Enter number of munch choclates in gift"+(i+1));
			int munchchoc=input.nextInt();
			chocwt+=munch.chocwt(munchchoc);
                                                    System.out.println("Enter number of lollipops in gift"+(i+1));
			int lolli=input.nextInt();
			chocwt+=lollipop.chocwt(lolli);
			System.out.println("Enter number of gulabjam in gift"+(i+1));
			int numgulab=input.nextInt();
			sweetwt+=gulabjam.sweetwt(numgulab);
			System.out.println("Enter number of jalebi in gift"+(i+1));
			int numjalebi=input.nextInt();
			sweetwt+=jalebi.sweetwt(numjalebi);		
			tweight[i]=chocwt+sweetwt;
			numcandies=snikchoc+munchchoc+numgulab+numjalebi+lolli;
			candies[i]=numcandies;
		}
		System.out.println("weights of gifts");
		for(int i=0;i<nc;i++)
		{
			System.out.println("Gift"+(i+1)+" - "+tweight[i]);
		}
		System.out.println();
		System.out.println("number of candies");
		for(int i=0;i<nc;i++)
		{
			System.out.println("Gift"+(i+1)+" - "+candies[i]);
		}
		System.out.println();
		GiftSort s=new Sweets();
		s.sortGift(nc,candies);

	}

}