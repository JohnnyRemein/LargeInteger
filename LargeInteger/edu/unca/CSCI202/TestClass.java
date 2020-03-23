package edu.unca.CSCI202;

import java.util.Random;
import java.util.Scanner;
import java.math.BigInteger;

/**
 * This class is used for debugging, and performance testing for gathering data
 * @author Johnny Remein
 * @version Project 4 - Large Integers - 4/30/19
 */
public class TestClass {

	public static void main(String[] args) {

		///* Code used for initial testing:
		ArrayLargeInteger<Integer> test0 = new ArrayLargeInteger<>("12345678");
		ArrayLargeInteger<Integer> test1 = new ArrayLargeInteger<>("-12345678");
		ArrayLargeInteger<Integer> test2 = new ArrayLargeInteger<>("12345678");
		ArrayLargeInteger<Integer> test3 = new ArrayLargeInteger<>("-2");
		ArrayLargeInteger<Integer> testMult = new ArrayLargeInteger<>("12345678");
		
		
		System.out.println("Testing ArrayLargeInteger");
		
		System.out.print("Number 0: ");
		System.out.println(test0.toString());
		System.out.print("Number 1: ");
		System.out.println(test1.toString());
		System.out.print("Number 2: ");
		System.out.println(test2.toString());
		System.out.print("Number 3: ");
		System.out.println(test3.toString());
		System.out.print("Mult number: ");
		System.out.println(testMult.toString());
		
		System.out.print("Sign of Number 1: ");
		System.out.println(test1.signum());
		System.out.print("Max of Number 0 and 1: ");
		System.out.println(test0.max(test1).toString());
		System.out.print("Min of Number 0 and 1: ");
		System.out.println(test0.min(test1).toString());
		System.out.print("Absolute value of Number 1: ");
		System.out.println(test1.abs().toString());
		System.out.print("Number 0 == Number 1: ");
		System.out.println(test0.equals(test1));
		System.out.print("Number 0 compared to Number 1 (-1 if <, 0 if =, 1 if >): ");
		System.out.println(test0.compareTo(test1));
		
		System.out.print("Number 0 added to Number 2: ");
		System.out.println(test0.add(test2));
		System.out.print("Number 0 added to Mult number: ");
		System.out.println(test0.add(testMult));
		System.out.print("Number 0 added to Number 1: ");
		System.out.println(test0.add(test1));
		System.out.print("Number 0 minus Number 1: ");
		System.out.println(test0.subtract(test1));
		System.out.print("Number 0 added to Number 3: ");
		System.out.println(test0.add(test3));
		System.out.print("Number 0 times Number 3: ");
		System.out.println(test0.multiply(test3));
		System.out.print("Number 0 times Mult number: ");
		System.out.println(test0.multiply(testMult));
		
		
		
		LinkedLargeInteger<Integer> test4 = new LinkedLargeInteger<>("87654321");
		LinkedLargeInteger<Integer> test5 = new LinkedLargeInteger<>("-87654321");
		LinkedLargeInteger<Integer> test6 = new LinkedLargeInteger<>("100000");
		LinkedLargeInteger<Integer> test7 = new LinkedLargeInteger<>("0");
		LinkedLargeInteger<Integer> test8 = new LinkedLargeInteger<>("-8234567543");
		LinkedLargeInteger<Integer> test9 = new LinkedLargeInteger<>("2");
		
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("Testing LinkedLargeInteger");
		
		System.out.print("Number 4: ");
		System.out.println(test4.toString());
		System.out.print("Number 5: ");
		System.out.println(test5.toString());
		System.out.print("Number 6: ");
		System.out.println(test6.toString());
		System.out.print("Number 7: ");
		System.out.println(test7.toString());
		System.out.print("Number 8: ");
		System.out.println(test8.toString());
		System.out.print("Number 9: ");
		System.out.println(test9.toString());
		
		System.out.print("Max of Number 4 and 6: ");
		System.out.println(test4.max(test6));
		System.out.print("Negate Number 5: ");
		System.out.println(test5.negate());
		System.out.print("Absolute value of Number 5: ");
		System.out.println(test5.abs());
		System.out.print("Min of Number 5 and 6: ");
		System.out.println(test5.min(test6));
		System.out.print("Sign of Number 5, 6, and 7 respectively: ");
		System.out.println(test5.signum() + " " + test6.signum() + " " + test7.signum());
		
		System.out.println();
		System.out.print("Number 4 added to Number 5: ");
		System.out.println(test4.add(test5));
		System.out.print("Number 4 added to Number 5(negated): ");
		System.out.println(test4.add(test5.negate()));
		System.out.print("Number 4 times Number 9: ");
		System.out.println(test4.multiply(test9));
		System.out.print("Number 4 minus Number 5: ");
		System.out.println(test4.subtract(test5));
		System.out.print("Number 6 times Number 7: ");
		System.out.println(test6.multiply(test7));
		System.out.print("Number 4 times Number 8: ");
		System.out.println(test4.multiply(test8));
		System.out.println("\n");
		//*/
		
		Random gen = new Random();
		String operation;
		String type;
        int size;
        int sizeInt;
        int resultSign = 0;
        int tempInt;
        String [] testIntegers = new String[2];
        boolean signTest = false;
        boolean arrayTest = false;
        boolean linkedTest = false;
        boolean builtInTest = false;
        ArrayLargeInteger<Integer> array1;
        ArrayLargeInteger<Integer> array2;
        ArrayLargeInteger<Integer> resultArray = new ArrayLargeInteger<Integer>("0");
        LinkedLargeInteger<Integer> linked1;
        LinkedLargeInteger<Integer> linked2;
        LinkedLargeInteger<Integer> resultLinked = new LinkedLargeInteger<Integer>("0");
        BigInteger builtIn1;
        BigInteger builtIn2;
        BigInteger resultBuiltIn = new BigInteger("0");
        
        
        @SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
        
        while(true) {
	        long startTime = 0;
	        long endTime = 0;
	        
	        System.out.print("Input operation (add, subtract, negate, abs val, multiply, max, min, signum): ");
	        operation = scan.next();
	        System.out.print("Input BigInteger type(array, linked, or builtIn): ");
	        type = scan.next(); 
	        System.out.print("Input size of integers(Number of digits): ");
	        size = scan.nextInt();
	        
	        testIntegers[0] = "";
	        testIntegers[1] = "";
	        
	        /*
	        if(size >= 10)
	        	sizeInt = 9;
	        else
	        	sizeInt = size - 1;
	        */
	        
	        for(int i = 0; i < 2; i++) {
	        	for(int j = 0; j < size; j++) {
	        		tempInt = 1 + gen.nextInt(9);
	        		testIntegers[i] += String.valueOf(tempInt);
	        	}
	        }
	        
	        /*
	        firstInteger = (long)Math.pow(10, (size-1)) + (long)(Math.pow(10, sizeInt) + gen.nextInt((int)Math.pow(10, sizeInt)*9));
	        secondInteger = (long)Math.pow(10, (size-1)) + (long)(Math.pow(10, sizeInt) + gen.nextInt((int)Math.pow(10, sizeInt)*9));
	        */
	        
	        System.out.println(testIntegers[0] + "     " + testIntegers[1]);
	     
	
	        System.out.println("Starting testing");
	        
	        switch (type) {
	        	
	            case "builtIn" : 
	            	builtIn1 = new BigInteger(testIntegers[0]);
	            	builtIn2 = new BigInteger(testIntegers[1]);
	            	builtInTest = true;
	            	
	            	switch(operation) {
	            	
	            	case "add" :
	            		startTime = System.nanoTime();
	            		resultBuiltIn = builtIn1.add(builtIn2);
	                    endTime = System.nanoTime();
	            		break;
	            	
	            	case "subtract" :
	            		startTime = System.nanoTime();
	            		resultBuiltIn = builtIn1.subtract(builtIn2);
	                    endTime = System.nanoTime();
	            		break;
	            		
	            	case "negate" :
	            		startTime = System.nanoTime();
	            		resultBuiltIn = builtIn1.negate();
	                    endTime = System.nanoTime();
	            		break;
	            		
	            	case "abs" :
	            		startTime = System.nanoTime();
	            		resultBuiltIn = builtIn1.abs();
	                    endTime = System.nanoTime();
	            		break;
	            		
	            	case "multiply" :
	            		startTime = System.nanoTime();
	            		resultBuiltIn = builtIn1.multiply(builtIn2);
	                    endTime = System.nanoTime();
	            		break;
	            		
	            	case "max" :
	            		startTime = System.nanoTime();
	            		resultBuiltIn = builtIn1.max(builtIn2);
	                    endTime = System.nanoTime();
	            		break;
	            		
	            	case "min" :
	            		startTime = System.nanoTime();
	            		resultBuiltIn = builtIn1.min(builtIn2);
	                    endTime = System.nanoTime();
	            		break;
	            		
	            	case "signum" :
	            		startTime = System.nanoTime();
	            		resultSign = builtIn1.signum();
	                    endTime = System.nanoTime();
	                    signTest = true;
	            		break;
	            	default : 
		            	System.out.println("Sorry, don't know that one.");
		            break;
	            	}
	            break;		
	            
	            
	            case "array" :
	            	array1 = new ArrayLargeInteger<>(testIntegers[0]);
	    	        array2 = new ArrayLargeInteger<>(testIntegers[1]);
	    	        arrayTest = true;
	            	
	            	switch(operation) {
	            	
	            	case "add" :
	            		startTime = System.nanoTime();
	            		resultArray = (ArrayLargeInteger<Integer>) array1.add(array2);
	                    endTime = System.nanoTime();
	            		break;
	            	
	            	case "subtract" :
	            		startTime = System.nanoTime();
	            		resultArray = (ArrayLargeInteger<Integer>) array1.subtract(array2);
	                    endTime = System.nanoTime();
	            		break;
	            		
	            	case "negate" :
	            		startTime = System.nanoTime();
	            		resultArray = (ArrayLargeInteger<Integer>) array1.negate();
	                    endTime = System.nanoTime();
	            		break;
	            		
	            	case "abs" :
	            		startTime = System.nanoTime();
	            		resultArray = (ArrayLargeInteger<Integer>) array1.abs();
	                    endTime = System.nanoTime();
	            		break;
	            		
	            	case "multiply" :
	            		startTime = System.nanoTime();
	            		resultArray = (ArrayLargeInteger<Integer>) array1.multiply(array2);
	                    endTime = System.nanoTime();
	            		break;
	            		
	            	case "max" :
	            		startTime = System.nanoTime();
	            		resultArray = (ArrayLargeInteger<Integer>) array1.max(array2);
	                    endTime = System.nanoTime();
	            		break;
	            		
	            	case "min" :
	            		startTime = System.nanoTime();
	            		resultArray = (ArrayLargeInteger<Integer>) array1.min(array2);
	                    endTime = System.nanoTime();
	            		break;
	            		
	            	case "signum" :
	            		startTime = System.nanoTime();
	            		resultSign = array1.signum();
	                    endTime = System.nanoTime();
	                    signTest = true;
	            		break;
	            	
	            	default : 
		            	System.out.println("Sorry, don't know that one.");
		            break;
	            	}
	            break;
	            
	            
	            case "linked" :
	            	linked1 = new LinkedLargeInteger<>(testIntegers[0]);
	            	linked2 = new LinkedLargeInteger<>(testIntegers[1]);
	            	linkedTest = true;
	            	
	            	switch(operation) {
	            	
	            	case "add" :
	            		startTime = System.nanoTime();
	            		resultLinked = (LinkedLargeInteger<Integer>) linked1.add(linked2);
	                    endTime = System.nanoTime();
	            		break;
	            	
	            	case "subtract" :
	            		startTime = System.nanoTime();
	            		resultLinked = (LinkedLargeInteger<Integer>) linked1.subtract(linked2);
	                    endTime = System.nanoTime();
	            		break;
	            		
	            	case "negate" :
	            		startTime = System.nanoTime();
	            		resultLinked = (LinkedLargeInteger<Integer>) linked1.negate();
	                    endTime = System.nanoTime();
	            		break;
	            		
	            	case "abs" :
	            		startTime = System.nanoTime();
	            		resultLinked = (LinkedLargeInteger<Integer>) linked1.abs();
	                    endTime = System.nanoTime();
	            		break;
	            		
	            	case "multiply" :
	            		startTime = System.nanoTime();
	            		resultLinked = (LinkedLargeInteger<Integer>) linked1.multiply(linked2);
	                    endTime = System.nanoTime();
	            		break;
	            		
	            	case "max" :
	            		startTime = System.nanoTime();
	            		resultLinked = (LinkedLargeInteger<Integer>) linked1.max(linked2);
	                    endTime = System.nanoTime();
	            		break;
	            		
	            	case "min" :
	            		startTime = System.nanoTime();
	            		resultLinked = (LinkedLargeInteger<Integer>) linked1.min(linked2);
	                    endTime = System.nanoTime();
	            		break;
	            		
	            	case "signum" :
	            		startTime = System.nanoTime();
	            		resultSign = linked1.signum();
	                    endTime = System.nanoTime();
	                    signTest = true;
	            		break;
	            	
	            	default : 
		            	System.out.println("Sorry, don't know that one.");
		            break;
	            	}
	            	
	            break;
	            
	            default : 
	            	System.out.println("Sorry, don't know that one.");
	        }
	        
	        
	        if(signTest)
	        	System.out.println("Result: " + resultSign);
	        else if(arrayTest)
	        	System.out.println("Result: " + resultArray);
	        else if(linkedTest)
	        	System.out.println("Result: " + resultLinked);
	        else if(builtInTest)
	        	System.out.println("Result: " + resultBuiltIn);
	        
	        
	        System.out.println(type + " Implementation ran in " 
	                        + ((endTime - startTime) / 1000000.0) + " milliseconds.\n");
	        
	        signTest = false;
	        linkedTest = false;
	        arrayTest = false;
	        builtInTest = false;
        }
    }
	
}


