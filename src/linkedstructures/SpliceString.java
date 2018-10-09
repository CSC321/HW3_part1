package linkedstructures;

/**
 * Class that provides much of the functionality of the String class, but 
 * utilizes structure sharing in order to optimize splicing
 * 
 * @author Kikki Beltz
 * @version October 2018
 */
public class SpliceString {
    private final Node<String> head;
    private final Node<String> tail;
    
    /**
     * Default constructor for objects of class SpliceString
     * The default constructor should initialize the object to represent an 
     * empty string (as an empty linked list).
     */
    public SpliceString() {
        this.tail = new Node<String>("", null);
        this.head = new Node<String>("", this.tail);
    }

    /**
     * Alternate constructor for objects of class SpliceString
     * The alternate constructor should initialize the object to represent the 
     * specified string (as a list with one node that stores str).
     * 
     * @param str - the string that the SpliceString object is initialized with
     */
    public SpliceString(String str) {
        this.tail = new Node<String>("", null);
        Node newNode = new Node<String>(str, this.tail);
        this.head = new Node<String>("", newNode);
    }
    
    /**
     * Method that returns true if this SpliceString object represents the empty
     * string. Note: this should be O(1).
     * 
     * @return boolean to indicate whether or not the SpliceString object is 
     * empty
     */
    public boolean empty() {
        return this.length() == 0;
    }

    /**
     * Method that returns the number of characters stored in this SpliceString 
     * object. Note: this should be O(1).
     * 
     * @return integer that indicates the number of characters in the 
     * SpliceString object
     */
    public int length() {
        return this.toString().length();
    }
    
    /**
     * Method that splices the other SpliceString onto the end of this 
     * SpliceString object. No new nodes should be created when splicing - the 
     * operation should be accomplished in O(1) time by reconnecting list 
     * references.
     * 
     * @param other - the SpliceString object to be spliced onto the current
     * SpliceString object
     */
    public void splice(SpliceString other) {
        other.head.getNext().setNext(this.tail);
        this.head.getNext().setNext(other.head.getNext());
    }

    /**
     * Method that splices the other String onto the end of this SpliceString 
     * object. Note: this should also be O(1).
     * 
     * @param other - the String object to be spliced onto the current
     * SpliceString object
     */
    public void splice(String other) {
        Node newNode = new Node<String>(other, this.tail);
        if(this.head.getNext() != this.tail) {
            this.head.getNext().setNext(newNode);
        } else {
            this.head.setNext(newNode);
        }
    }
    
    /**
     * Method that returns the String representation of this SpliceString
     * object.
     * 
     * 
     * @return a String representation of the SpliceString object
     */
    @Override
    public String toString() {
        String data = "";
        Node<String> node = this.head.getNext();
        while (node != this.tail) {
            try {
                data += node.getData();  
            } catch (NullPointerException ex) {
                return "This node contains no data" + ex; 
            }
            node = node.getNext();  
        }
        return data;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SpliceString sstr1 = new SpliceString();
        System.out.println("Is sstr1 empty? " + sstr1.empty());
        System.out.println("Empty list: " + sstr1.toString());
        sstr1.splice("ACGTA");
        System.out.println("Splice string onto SpliceString object: " + sstr1);
        SpliceString sstr2 = new SpliceString("TACC");
        System.out.println("Is sstr2 empty? " + sstr2.empty());
        sstr1.splice(sstr2);
        System.out.println("sstr1 splice sstr2: " + sstr1.toString());
        System.out.println("sstr1 length: " + sstr1.length());
    }
    
}
