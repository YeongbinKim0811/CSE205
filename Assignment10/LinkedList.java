// Assignment #: 10
//         Name: Yeongbin Kim
//    StudentID: 1217898110
// Lecture Time: T/TH 4:30 - 5:45
//  Description: The LinkedList defines a linked list using its node class
//  object and also defines a iterator class to traverse the linked list.
import java.util.NoSuchElementException;

/**
   A linked list is a sequence of nodes with efficient
   element insertion and removal. This class
   contains a subset of the methods of the standard
   java.util.LinkedList class.
*/
public class LinkedList
{
   /**
      Constructs an empty linked list.
   */
   public LinkedList()
   {
      first = null;
   }

   /**
      Returns the first element in the linked list.
      @return the first element in the linked list
   */
   public Object getFirst()
   {
      if (first == null)
         throw new NoSuchElementException();
      return first.data;
   }

   /**
      Removes the first element in the linked list.
      @return the removed element
   */
   public Object removeFirst()
   {
      if (first == null)
         throw new NoSuchElementException();
      Object element = first.data;
      first = first.next;
      return element;
   }

   /**
      Adds an element to the front of the linked list.
      @param element the element to add
   */
   public void addFirst(Object element)
   {
      Node newNode = new Node();
      newNode.data = element;
      newNode.next = first;
      first = newNode;
   }


   /*************** Added methods *******************************/

   // 1. The add adds the parameter string into the linked list. The linked list
   //     should contain all strings in alphabetical order
    public void add(String element) {
    	Node newNode = new Node();     //new Node
    	newNode.data = element;
    	
    	if (first == null)     //If linkedList is null, add the element at the first position
    	{
    		first = newNode;
    	}
    	else if (element.compareTo(first.data.toString()) < 0)
    	{
    		newNode.next = first;
    		first = newNode;
    	}
    	else
    	{
    		Node curNode = first.next;     //current Node
    		Node prevNode = first;
    		if (curNode == null)
    		{
    			first.next = newNode;
    		}
    		else
    		{
    			while (curNode != null)     //loop for finding the right position
    			{
    				if (element.compareTo(curNode.data.toString()) <= 0)
    				{
    					prevNode.next = newNode;
    					newNode.next = curNode;
    					return;
    				}
    				else
    				{
    					prevNode = curNode;
    					curNode = curNode.next;
    				}
    			}
    			prevNode.next = newNode;     // add the element at the last position
    		}
    	}
    }
  
   //2. count method counts how many times the parameter object
   //appears in the linked list and return the number. It returns 0
   //if the parameter object does not exist in the linked list.
   public int count(String element) {
	   int count = 0;
	   Node curNode = first;	//current Node
	   if (first == null)
	   {
		   return count;
	   }
	   else
	   {
		   curNode = first.next;
		   while (curNode != null)     //loop for comparing element with next node
		   {
			   if (element.equals(curNode.data.toString()))
			   {
				   count++;
			   }
			   curNode = curNode.next;
		   }
		   return count;
	   }
   }
   
  //3. search method returns the index of the parameter object
  //in the linked list if it exists. It return -1 if it does not
  //exits. If the index is out of bounds, then it throws an exception.
   public int search(String element) {
	   int idx = 0;     //index
	   Node curNode = first;
	   if (element.equals(first.data.toString()))
	   {
		   return idx;
	   }
	   else
	   {
		   curNode = first.next;
		   idx++;
		   while (curNode != null)
		   {
			   if (element.equals(curNode.data.toString()))     //if find correct one, return the index
			   {
				   return idx;
			   }
			   else     //if it is not found, move on to next node
			   {
				   curNode = curNode.next;
				   idx++;
			   }
		   }
		   return -1;
	   }
   }

   //4. remove method removes the element at the parameter
   //index in the linked list.
   public String remove (int index) {
	   int idx = 0;     //index
	   Node curNode = first;     //current Node
	   if (idx == index)
	   {
		   first = curNode.next;
		   return curNode.data.toString();
	   }
	   else
	   {
		   idx++;
		   curNode = first.next;     //current Node
		   Node prevNode = first;     //previous Node
		   while (curNode != null)     //loop for finding correct index
		   {
			   if (idx == index)
			   {
				   prevNode.next = curNode.next;
				   return curNode.data.toString();
			   }
			   else
			   {
				   idx++;
				   prevNode = curNode;
				   curNode = curNode.next;			   
			   }
		   }
		   return null;
	   }
   }

   //5. The method size return the current size of the linked list,
   //that is, the number of elements in it.
   public int size() {
	   int numOfString = 1;     //number of strings
	   Node curNode = first;     //current Node
	   while (curNode != null) 
	   {
		   curNode = curNode.next;
		   if (curNode == null)
		   {
			   break;
		   }
		   numOfString++;
	   }
	   return numOfString;
   }

   //6. The toString method returns a string containing the content
   //of the linked list. In this assignment, the linked list will
   //contain only string, so it returns a concatenation of all strings
   //in the linked list and a line break
   public String toString() {
	   String result = "{ ";
	   Node curNode = first;     //current Node
	   if (first == null)
	   {
		   return "{ }\n";
	   }
	   else
	   {
		   while (curNode != null)
		   {
			   result += curNode.data.toString() + " ";
			   curNode = curNode.next;
		   }
		   result += "}\n";
	   }
	   return result;
   }

   //7. The removeLastFew method removes the parameter specified number
   //of elements from the end of the linked list.
   //If the parameter integer is larger than the current size of
   //the linked list, then the linked-list will be empty.
   //If the parameter integer is less than 0,
   //nothing should be removed from the linked list.
   public void removeLastFew(int howMany) {
	   if (howMany > this.size())
	   {
		   for (int i = this.size()-1; i >= 0; i--)
		   {
			   this.remove(i);
		   }
	   }
	   else
	   {
		   int numOfRemoved = 0;     //number of Strings removed;
		   int idx = this.size()-1;     //removed index
		   while (numOfRemoved < howMany)
		   {
			   this.remove(idx);
			   idx--;
			   numOfRemoved++;
		   }
	   }
   }

   /***************************************************************/

   /**
      Returns an iterator for iterating through this list.
      @return an iterator for iterating through this list
   */
   public ListIterator listIterator()
   {
      return new LinkedListIterator();
   }

   private Node first;

   private class Node
   {
      public Object data;
      public Node next;
   }

   private class LinkedListIterator implements ListIterator
   {
      /**
         Constructs an iterator that points to the front
         of the linked list.
      */
      public LinkedListIterator()
      {
         position = null;
         previous = null;
      }

      /**
         Moves the iterator past the next element.
         @return the traversed element
      */
      public Object next()
      {
         if (!hasNext())
            throw new NoSuchElementException();
         previous = position; // Remember for remove

         if (position == null)
            position = first;
         else
            position = position.next;

         return position.data;
      }

      /**
         Tests if there is an element after the iterator
         position.
         @return true if there is an element after the iterator
         position
      */
      public boolean hasNext()
      {
         if (position == null)
            return first != null;
         else
            return position.next != null;
      }

      /**
         Adds an element before the iterator position
         and moves the iterator past the inserted element.
         @param element the element to add
      */
      public void add(Object element)
      {
         if (position == null)
         {
            addFirst(element);
            position = first;
         }
         else
         {
            Node newNode = new Node();
            newNode.data = element;
            newNode.next = position.next;
            position.next = newNode;
            position = newNode;
         }
         previous = position;
      }

      /**
         Removes the last traversed element. This method may
         only be called after a call to the next() method.
      */
      public void remove()
      {
         if (previous == position)
            throw new IllegalStateException();

         if (position == first)
         {
            removeFirst();
         }
         else
         {
            previous.next = position.next;
         }
         position = previous;
      }

      /**
         Sets the last traversed element to a different
         value.
         @param element the element to set
      */
      public void set(Object element)
      {
         if (position == null)
            throw new NoSuchElementException();
         position.data = element;
      }

      private Node position;
      private Node previous;
   }
}