package edu.unca.CSCI202;

import java.util.LinkedList;
import java.util.List;

/**
 * This class implements the LargeInteger interface using a LinkedList
 * @author Johnny Remein
 * @version Project 4 - Large Integers - 4/30/19
 * @param <T>
 */
public class LinkedLargeInteger<T> implements LargeInteger<T> {


	private List<Integer> largeInt;
	private int sign;
	
	private static final LargeInteger<LinkedLargeInteger<Integer>> ZERO = new LinkedLargeInteger<>("0");
	private static final LargeInteger<LinkedLargeInteger<Integer>> ONE = new LinkedLargeInteger<>("1");
	
	/**
	 * Generic Constructor taking a string argument
	 * @param largeIntString, a string representation of the integer to be stored
	 */
	public LinkedLargeInteger(String largeIntString){
		int i = 0;
		int numLength = largeIntString.length();
		largeInt = new LinkedList<>();
		if(largeIntString.charAt(0) == '-') {
			sign = -1;
			i = 1;
		}
		else if(largeIntString.charAt(0) == '0') {
			sign = 0;
		}
		else {
			sign = 1;
		}
		
		while(i < numLength) {
			largeInt.add((int)largeIntString.charAt(i) - 48); 
			i++;
		}
		
	}
	
	
	/**
	 * This Constructor specifies the size of an LinkedLargeInteger's ArrayList for storing the product of arithmetic procedures and fills it with zeros as place holders
	 * @param size, integer size of ArrayList to be initialized to
	 */
	public LinkedLargeInteger(int size, int sign) {
		this.largeInt = new LinkedList<>();
		this.sign = sign;
		for(int i = 0; i < size; i++)
			largeInt.add(0);
	}
	
	/**
	 * This Constructor builds an LinkedLargeInteger for use in specifying the absolute value of another LinkedLargeInteger
	 * @param largeInt, the integer representation of the integer being absolute valued
	 */
	public LinkedLargeInteger(List<Integer> largeInt, int sign) {
		this.largeInt = largeInt;
		this.sign = sign;
	}
	
	
	/**
	 * Takes a LargeInteger; returns the LargeInteger sum of this and the argument
	 * @param largeInt, the LargeInteger to be added to this
	 * @return the LargeInteger sum of the two
	 */
	public LargeInteger<T> add(LargeInteger<T> largeIntToAdd) {
		
		if(this.equals(ZERO) || largeIntToAdd.equals(ZERO))
			return this.max(largeIntToAdd);
		
		int largeIntToAddSign = largeIntToAdd.signum();
		
		if((this.sign < 0 && largeIntToAddSign < 0) || (this.sign > 0 && largeIntToAddSign > 0)) //If they're both negative or positive
			return this.add(largeIntToAdd, this.sign);
		
		if(this.sign < 0) {												// If the first number is negative
			if(this.negate().max(largeIntToAdd).equals(largeIntToAdd))	// If the absolute value of the second number is larger
				return largeIntToAdd.subtract(this.negate()); 
			return this.subtract(largeIntToAdd, this.sign);				// Otherwise
		}
		
		if(largeIntToAdd.negate().max(this).equals(this))				// If here, only second number is negative, If the absolute value of the first number is larger
			return this.subtract(largeIntToAdd, this.sign);
		return largeIntToAdd.negate().subtract(this).negate();			// Otherwise
		
	}
		
	
	/**
	 * A private helper method for the add method above, taking an extra int parameter 
	 * signifying the sign of the integer
	 * @param largeInt, the LargeInteger to be added to this
	 * @param sign, the sign of the integer
	 * @return the LargeInteger sum of the two
	 */
	private LargeInteger<T> add(LargeInteger<T> largeIntToAdd, int sign){
		LargeInteger<T> sum;
		int largestLength; 
		int smallestLength;
		int sumIndex;
		int largestIndex;
		int smallestIndex;
		int elementSum;
		int carry = 0;
		if(((LinkedLargeInteger<T>)largeIntToAdd).largeInt.size() > this.largeInt.size()) { 				// If parameter integer higher in digit count
			largestLength = ((LinkedLargeInteger<T>)largeIntToAdd).largeInt.size();
			smallestLength = this.largeInt.size();
			sum = new LinkedLargeInteger<>(largestLength + 1, sign);
			
			smallestIndex = smallestLength - 1;
			largestIndex = largestLength - 1;
			sumIndex = largestLength;
			
			while(largestIndex >= 0) {
				if(smallestIndex >= 0) {
					elementSum = carry + ((LinkedLargeInteger<T>)largeIntToAdd).largeInt.get(largestIndex) + this.largeInt.get(smallestIndex);
					if(elementSum >= 10) {
						carry = 1;
						elementSum -= 10;
					}
					else carry = 0;
					
					((LinkedLargeInteger<T>)sum).largeInt.set(sumIndex, elementSum);
				}
				
				else {
					elementSum = carry + ((LinkedLargeInteger<T>)largeIntToAdd).largeInt.get(largestIndex);
					if(elementSum >= 10) {
						carry = 1;
						elementSum -= 10;
					}
					else carry = 0;
					
					((LinkedLargeInteger<T>)sum).largeInt.set(sumIndex, elementSum);
				}
				sumIndex--;
				largestIndex--;
				smallestIndex--;
			}
			
			if(carry == 1) {
				((LinkedLargeInteger<T>)sum).largeInt.set(sumIndex, carry);
			}
			else ((LinkedLargeInteger<T>)sum).largeInt.remove(sumIndex);
			
			return sum;
			
		}
		
		else {																				// If this integer higher in digit count
			largestLength = this.largeInt.size();
			smallestLength = ((LinkedLargeInteger<T>)largeIntToAdd).largeInt.size();
			sum = new LinkedLargeInteger<>(largestLength + 1, sign);
			
			smallestIndex = smallestLength - 1;
			largestIndex = largestLength - 1;
			sumIndex = largestLength;
			
			while(largestIndex >= 0) {
				if(smallestIndex >= 0) {
					elementSum = carry + ((LinkedLargeInteger<T>)largeIntToAdd).largeInt.get(smallestIndex) + this.largeInt.get(largestIndex);
					if(elementSum >= 10) {
						carry = 1;
						elementSum -= 10;
					}
					else carry = 0;
					
					((LinkedLargeInteger<T>)sum).largeInt.set(sumIndex, elementSum);
				}
				
				else {
					elementSum = carry + this.largeInt.get(largestIndex);
					if(elementSum >= 10) {
						carry = 1;
						elementSum -= 10;
					}
					else carry = 0;
					
					((LinkedLargeInteger<T>)sum).largeInt.set(sumIndex, elementSum);
				}
				sumIndex--;
				largestIndex--;
				smallestIndex--;
			}
			
			if(carry == 1) {
				((LinkedLargeInteger<T>)sum).largeInt.set(sumIndex, carry);
			}
			else ((LinkedLargeInteger<T>)sum).largeInt.remove(sumIndex);
			
			return sum;
		}
	}

	
	/**
	 * Takes a LargeInteger; returns the LargeInteger difference of this and the argument.
	 * @param largeIntToSubtact, the LargeInteger to find difference between it and this
	 * @return the LargeInteger difference of the two
	 */
	public LargeInteger<T> subtract(LargeInteger<T> largeIntToSub){
		int largeIntToSubSign = largeIntToSub.signum();
		
		if(largeIntToSub.equals(ZERO))
			return this;
		
		if(this.equals(ZERO))
			return largeIntToSub.negate();
		
		if(this.sign < 0 && largeIntToSubSign > 0)
			return this.add(largeIntToSub, this.sign);
			
		if(this.sign > 0 && largeIntToSubSign < 0)
			return this.add(largeIntToSub, this.sign);
		
		if(this.sign < 0 && largeIntToSubSign < 0) {							// If both values are negative
			if(this.abs().min(largeIntToSub.abs()).equals(this.abs()))			// If first value's absolute value is smaller
				return ((LinkedLargeInteger<T>)largeIntToSub).subtract(this.abs(), 1);
			else
				return this.subtract(largeIntToSub, this.sign);					// If second value's absolute value is smaller		
		}
		
																			// If here both values are positive
		if(this.abs().min(largeIntToSub.abs()).equals(this.abs()))			// If first value's absolute value is smaller
			return ((LinkedLargeInteger<T>)largeIntToSub).subtract(this.abs(), -1);
		else
			return this.subtract(largeIntToSub, this.sign);					// If second value's absolute value is smaller	
	}

	/**
	 * A private helper method to the subtract method above taking an int parameter 
	 * signifying the sign of the integer
	 * @param largeIntToSubtact, the LargeInteger to find difference between it and this
	 * @param sign, the sign of the integer
	 * @return the LargeInteger difference of the two
	 */
	@SuppressWarnings("unchecked")
	private LargeInteger<T> subtract(LargeInteger<T> largeIntToSub, int sign) {
		LargeInteger<T> difference;
		int largestLength = this.largeInt.size();
		int largestIndex = largestLength - 1;
		int smallestIndex = ((LinkedLargeInteger<T>)largeIntToSub).largeInt.size() - 1;
		int diffIndex = largestIndex;
		int elementDiff;
		int subTemp = 0;
		int borrow = 0;
		int borrowOverride = 0;
		
		difference = new LinkedLargeInteger<>(largestLength, sign);
		
		while(largestIndex >= 0) {											// While still looking through larger number
			if(smallestIndex >= 0) {										// If still subtracting from larger number
				if(borrow == 1)												// If previous subtraction borrowed
					if(this.largeInt.get(largestIndex) == 0) {				// If borrowed from a 0 set to 9 and keep borrow high, set borrowOverride flag
						subTemp = 9;								
						borrow = 1;
						borrowOverride = 1;
					}
					else {													// If it wasn't a zero you borrowed from, subtract one and set override to zero
						subTemp = this.largeInt.get(largestIndex) - 1;
						borrowOverride = 0;
					}
				else 														// If you didn't borrow on previous subtraction continue normally
					subTemp = this.largeInt.get(largestIndex);
				
				if(subTemp < ((LinkedLargeInteger<T>)largeIntToSub).largeInt.get(smallestIndex)) {			// If you need to borrow, do so and set borrow flag
					elementDiff = (10 + subTemp) - ((LinkedLargeInteger<T>)largeIntToSub).largeInt.get(smallestIndex);
					borrow = 1;
				}
				
				else {
					elementDiff = subTemp - ((LinkedLargeInteger<T>)largeIntToSub).largeInt.get(smallestIndex);  	// Perform the subtraction 
					if(borrowOverride == 0)																			// If no borrow override, set borrow flag to zero
						borrow = 0;
				}
				
				((LinkedLargeInteger<T>)difference).largeInt.set(diffIndex, elementDiff);							// Record proper value
			}
			
			else {															// If passed the smaller number just need to figure out if this index was borrowed from 
				if(borrow == 1) {											// If there's a leftover borrow
					if(this.largeInt.get(largestIndex) == 0) {				// If borrowed from a 0 set to 9 and keep borrow high, set borrowOverride flag
						subTemp = 9;								
						borrow = 1;
						borrowOverride = 1;
					}
					else {													// If it wasn't a zero you borrowed from, subtract one and set override to zero
						subTemp = this.largeInt.get(largestIndex) - 1;
						borrow = 0;
						borrowOverride = 0;
					}
					
				}
				else {
					subTemp = this.largeInt.get(largestIndex);				// If this element was not borrowed from, pass it through
					borrow = 0;
				}
				((LinkedLargeInteger<T>)difference).largeInt.set(diffIndex, subTemp);	// Set the element
			}
			largestIndex--;
			smallestIndex--;
			diffIndex--;
				
		}
		
		int diffLength = ((LinkedLargeInteger<T>)difference).largeInt.size();
		while(((LinkedLargeInteger<T>)difference).largeInt.get(0) == 0 && diffLength > 1) {		// Get rid of all the leading zeros
			((LinkedLargeInteger<T>)difference).largeInt.remove(0);
			diffLength--;
		}
		
		if(((LinkedLargeInteger<T>)difference).largeInt.equals(((LinkedLargeInteger<T>)ZERO).largeInt))		// If integer is zero, change sign to indicate that it's zero
			((LinkedLargeInteger<T>)difference).sign = 0;
			
		
		return difference;
	}
	
	/**
	 * Returns the negative of the LargeInteger
	 * @return the negated LargeInteger
	 */
	public LargeInteger<T> negate() {
		LargeInteger<T> negatedInt = new LinkedLargeInteger<>(this.largeInt, this.sign * -1);
		return negatedInt;
	}

	/**
	 * Returns the absolute value of the LargeInteger
	 * @return the LargeInteger absolute value
	 */
	public LargeInteger<T> abs() {
		LargeInteger<T> absolute = new LinkedLargeInteger<>(this.largeInt, 1);
		return absolute;
	}

	/**
	 * Takes a LargeInteger; returns the LargeInteger product of this and the argument
	 * @param largeIntToMult, the LargeInteger to multiply with this
	 * @return the LargeInteger product of largeIntToMult and this
	 */
	@SuppressWarnings("unchecked")
	public LargeInteger<T> multiply(LargeInteger<T> largeIntToMult) {
		if(largeIntToMult.equals(ZERO) || this.equals(ZERO))
			return (LargeInteger<T>) ZERO;
		
		if(largeIntToMult.equals(ONE) || this.equals(ONE))
			return this.max(largeIntToMult);
		
		LargeInteger<T> negOne = (LargeInteger<T>)ONE.abs().negate();
		if(largeIntToMult.equals(negOne) || this.equals(negOne))
			return this.max(largeIntToMult).negate();
		
		
		int sign = 1;
		
		if(this.sign < 0)
			sign *= -1;
		
		if(largeIntToMult.signum() < 0)
			sign *= -1;
		
		
		LargeInteger<T> product = (LargeInteger<T>) ZERO;
		LargeInteger<T> larger;
		LargeInteger<T> smaller;
		LargeInteger<T> accumulator;
	
		
		larger = this.abs().max(largeIntToMult.abs());
		smaller = this.abs().min(largeIntToMult.abs());
		int smallerSize = ((LinkedLargeInteger<T>)smaller).largeInt.size();
		int numZerosHelper = smallerSize - 1;
		int numZeros;
		int elementVal = 0;
		String zerosToAdd;
		
		for(int i = 0; i < smallerSize; i++) {										// Traverse the smaller integer
			elementVal = ((LinkedLargeInteger<T>)smaller).largeInt.get(i);			// Capture each element
			if(elementVal != 0) {													// If the element is not zero, multiply by accumulated addition
				accumulator = larger.abs();											// Initialize accumulator
				for(int j = 0; j < elementVal - 1; j++) 							// Accumulate until element value is exhausted
					accumulator = accumulator.add(larger);
				
				zerosToAdd = "";													// Initialize the number of zero's to add to the accumulated integer
				numZeros = numZerosHelper - i;										// Determine the number of zero's to be added based on place in integer
				
				for(int j = 0; j < numZeros; j++)									
					zerosToAdd = zerosToAdd + "0";
				
				accumulator = new LinkedLargeInteger<T>(accumulator.toString() + zerosToAdd);	// Add zeros
				product = product.add(accumulator);												// Accumulate in total product
			}
		}
		
		((LinkedLargeInteger<T>)product).sign *= sign;								// Adjust for the sign
		
		return product;
	}

	
	public LargeInteger<T> max(LargeInteger<T> largeIntToCompare) {
		if(((LinkedLargeInteger<T>)largeIntToCompare).equals(this))
			return this;
		if(((LinkedLargeInteger<T>)largeIntToCompare).sign != this.sign) {
			if(((LinkedLargeInteger<T>)largeIntToCompare).sign > this.sign)
				return largeIntToCompare;
			return this;
		}
		
		if(((LinkedLargeInteger<T>)largeIntToCompare).largeInt.size() != this.largeInt.size()) {
			if(((LinkedLargeInteger<T>)largeIntToCompare).largeInt.size() > this.largeInt.size())
				return largeIntToCompare;
			return this;
		}
		
		int index = 0;
		while(((LinkedLargeInteger<T>)largeIntToCompare).largeInt.get(index) == this.largeInt.get(index))
			index++;
		
		if(((LinkedLargeInteger<T>)largeIntToCompare).largeInt.get(index) > this.largeInt.get(index))
			return largeIntToCompare;
		return this;
	}

	
	public LargeInteger<T> min(LargeInteger<T> largeIntToCompare) {
		if(((LinkedLargeInteger<T>)largeIntToCompare).equals(this))
			return this;
		if(((LinkedLargeInteger<T>)largeIntToCompare).sign != this.sign) {
			if(((LinkedLargeInteger<T>)largeIntToCompare).sign < this.sign)
				return largeIntToCompare;
			return this;
		}
		
		if(((LinkedLargeInteger<T>)largeIntToCompare).largeInt.size() != this.largeInt.size()) {
			if(((LinkedLargeInteger<T>)largeIntToCompare).largeInt.size() < this.largeInt.size())
				return largeIntToCompare;
			return this;
		}
		
		int index = 0;
		while(((LinkedLargeInteger<T>)largeIntToCompare).largeInt.get(index) == this.largeInt.get(index))
			index++;
		
		if(((LinkedLargeInteger<T>)largeIntToCompare).largeInt.get(index) < this.largeInt.get(index))
			return largeIntToCompare;
		return this;
			
	}

	
	public int signum() {
		return this.sign;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public int compareTo(Object obj) {
		if(obj.equals(this)) return 0;
		if(((LinkedLargeInteger<T>)obj).min(this).equals(obj))
			return 1;
		return -1;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((largeInt == null) ? 0 : largeInt.hashCode());
		result = prime * result + sign;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		@SuppressWarnings("rawtypes")
		LinkedLargeInteger other = (LinkedLargeInteger) obj;
		if (largeInt == null) {
			if (other.largeInt != null)
				return false;
		} else if (!largeInt.equals(other.largeInt))
			return false;
		if (sign != other.sign)
			return false;
		return true;
	}
	
	
	@Override
	public String toString() {
		if(this.equals(ZERO))
			return "0";
		StringBuilder sb = new StringBuilder();
		if(this.sign < 0)
			sb.append("-");
		int length = this.largeInt.size();
		for(int i = 0; i < length; i++)
			sb.append(this.largeInt.get(i));
			
		return sb.toString();
	}
	
	

}
