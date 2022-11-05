package com.example.anonymousclass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class AnonymousClassTest {
	
	//Approach 1: create a method that searches for even integers
	public static void printAllEvens(List<Integer> list) {
		for(Integer x : list) {
			if(x % 2 == 0) {
				System.out.print(x + " ");
			}
		}
	}
	
	//Approach 2: Specify search criteria in a local class
	public interface CheckEven{
		boolean test(int num);
		
	}
	static class CheckIfEven implements CheckEven{
		@Override
		public boolean test(int num) {
			return num % 2 == 0;
		}
	}
	
	public static void printEvens(List<Integer> nums, CheckEven tester) {
		for(Integer n : nums) {
			if(tester.test(n)) {
				System.out.print(n + " ");
			}
		}
	}
	
	
	//Approach 5: Use standard function interface
	public static void printEvensWithPredicate(List<Integer> nums, Predicate<Integer> tester) {
		for(Integer n : nums) {
			if(tester.test(n)) {
				System.out.print(n + " ");
			}
		}
	}
	 
	
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>(Arrays.asList(3,7,2,5,6,8));
		
		//1
		printAllEvens(list);
		
		System.out.println();
		
		//2
		printEvens(list, new CheckIfEven());
		
		System.out.println();
		
		//Approach 3: Specify criteria code in Anonymous class
		
		printEvens(list,
						//this is a Anonymous Class -> This constructor defines a new class, 
						//without giving it a name, and it simultaneously creates an object that belongs to that class.
						new CheckEven() {
							@Override
							public boolean test(int num) {
								return num % 2 == 0;
							}
						});
		
		
		System.out.println();
		
		
		
		//Approach 4: Specify criteria code with Lambda Expression
		
		/* 
		 * CheckEven is a funtional interface and has a single method, you can omit the method name
		 * when you implement it. To do this instead of a anonymous class expression you have a lambda expression
		 * */
		printEvens(list, num -> num % 2 == 0);
		
		
		System.out.println();
		
		//Approach 5: Use standard functional interface
		
		printEvensWithPredicate(list, new Predicate<Integer>() {
			@Override
			public boolean test(Integer t) {
				return t % 2 == 0;
			}
		});
		
		//The above anonymous class that creates Predicate<T> object can be written as Lambda Exp as below
		printEvensWithPredicate(list, num -> num % 2 == 0);
		
		
		
	}

}
