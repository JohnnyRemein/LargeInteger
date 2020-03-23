# LargeInteger

Introduction
The objective of this project is to get further practice in using lists. You will also get some practice
writing a Java interface as well as further practice in assessing performance.
Arbitrary length integers are integers that have no size restriction. Recall that the int type has
a range of -2,147,483,648 to 2,147,483,647. The long type runs from -2^63 to 2^63 - 1. Sometimes
these numbers are not large enough. One example application that may need larger numbers is
public-key cryptography where very large integers are used to make decryption hard. A large
integer may be represented as a list by storing the digits in successive list locations in the correct
sequence. For example, the number 45341 would be represented by the list [4, 5, 3, 4, 1]. In this
project, you will implement arbitrary length integers using lists.

Tasks
The LargeInteger Interface
Write an interface called LargeInteger that extends the Comparable interface. LargeInteger
specifies the following operations:
1. add - takes a LargeInteger; returns the LargeInteger sum of this and the argument.
2. subtract - takes a LargeInteger; returns the LargeInteger difference of this and the
argument.
3. negate - returns the negative of the LargeInteger
4. abs - returns the absolute value of the LargeInteger
5. multiply - takes a LargeInteger; returns the LargeInteger product of this and the
argument.
6. max - takes a LargeInteger; returns the LargeInteger that is the larger of this LargeInteger
and the argument
7. min - takes a LargeInteger; returns the LargeInteger that is the smaller of this
LargeInteger and the argument
8. signum - returns 0 if this LargeInteger equals 0, 1 if it's positive, or -1 if it's negative.
