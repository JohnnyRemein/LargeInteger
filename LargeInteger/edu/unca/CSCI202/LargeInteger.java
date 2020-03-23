package edu.unca.CSCI202;

/**
 * This interface declares the functions to be used in both LinkedLargeInteger and ArrayLargeInteger
 * @author Johnny Remein
 * @version Project 4 - Large Integers - 4/30/19
 * @param <T>
 */
public interface LargeInteger<T> extends Comparable<T> {

	
	
	/**
	 * Takes a LargeInteger; returns the LargeInteger sum of this and the argument
	 * @param largeInt, the LargeInteger to be added to this
	 * @return the LargeInteger sum of the two
	 */
	public LargeInteger<T> add(LargeInteger<T> largeIntToAdd);
	
	/**
	 * Takes a LargeInteger; returns the LargeInteger difference of this and the argument.
	 * @param largeIntToSubtact, the LargeInteger to find difference between it and this
	 * @return the LargeInteger difference of the two
	 */
	public LargeInteger<T> subtract(LargeInteger<T> largeIntToSub);
	
	/**
	 * Returns the negative of the LargeInteger
	 * @return the negated LargeInteger
	 */
	public LargeInteger<T> negate();
	
	/**
	 * Returns the absolute value of the LargeInteger
	 * @return the LargeInteger absolute value
	 */
	public LargeInteger<T> abs();
	
	/**
	 * Takes a LargeInteger; returns the LargeInteger product of this and the argument
	 * @param largeIntToMult, the LargeInteger to multiply with this
	 * @return the LargeInteger product of largeIntToMult and this
	 */
	public LargeInteger<T> multiply(LargeInteger<T> largeIntToMult);
	
	/**
	 * Takes a LargeInteger; returns the LargeInteger that is the larger of this LargeInteger and the argument
	 * @param largeIntToCompare, the LargeInteger to compare with this
	 * @return the largest LargeInteger between this and largeIntToCompare
	 */
	public LargeInteger<T> max(LargeInteger<T> largeIntToCompare);
	
	/**
	 * Takes a LargeInteger; returns the LargeInteger that is the smaller of this LargeInteger and the argument
	 * @param largeIntToCompare, the LargeInteger to compare with this
	 * @return the smallest LargeInteger between this and largeIntToCompare
	 */
	public LargeInteger<T> min(LargeInteger<T> largeIntToCompare);
	
	/**
	 * Checks for the sign of a LargeInteger
	 * @return 0 if the LargeInteger equals 0, 1 if it's positive or -1 if it's negative
	 */
	public int signum();


	
	
	
	
}
