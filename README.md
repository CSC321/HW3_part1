# HW3 part 1

For this assignment, you will implement a SpliceString class that provides much 
of the functionality of the String class, but utilizes structure sharing in order 
to optimize splicing. Internally, your SpliceString class should utilize a 
singly-linked list of strings, with references to the front and back of the list. 
For example, the sstr1 object below represents the string "ACGTA" using a linked
structure with only one node. The sstr2 object represents the string "TACCGGCCGA" 
using a linked structure with two nodes.


Since objects of the same class are able to view each other's private data, it 
is possible to splice one SpliceString object onto the end of another without 
having to copy any strings or nodes. Instead, the links in one are connected to 
the other.


As a result, it is possible to splice one SpliceString object onto the end of 
another in O(1) time. Likewise, it is possible to splice into the middle of 
another SpliceString object in better than O(N) time, where N is the number of 
characters in the string.

Warning: one consequence of structure sharing is that you should never attempt 
to splice a SpliceString (or any portion of that SpliceString object) onto 
itself. Otherwise, infinite data structures may result!



## Part 1: Basic construction & access

For the first part of the assignment, Your SpliceString class should implement 
the following constructors and methods:

public SpliceString()
The default constructor should initialize the object to represent an empty 
string (as an empty linked list).
public SpliceString(String str)
The alternate constructor should initialize the object to represent the 
specified string (as a list with one node that stores str).
public boolean empty()
Returns true if this SpliceString object represents the empty string. Note: 
this should be O(1).
public int length()
Returns the number of characters stored in this SpliceString object. Note: this 
should be O(1).
public void splice(SpliceString other)
Splices the other SpliceString onto the end of this SpliceString object. No new 
nodes should be created when splicing - the operation should be accomplished in 
O(1) time by reconnecting list references.
public void splice(String other)
Splices the other String onto the end of this SpliceString object. Note: this 
should also be O(1).
public String toString()
Returns the String representation of this SpliceString object.
As part of your submission, you should include a simple driver class that tests 
each of these constructors and methods.
