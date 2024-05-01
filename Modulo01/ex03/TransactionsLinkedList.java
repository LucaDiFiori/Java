import java.util.UUID;

/*
 * Doubly linked list implementation:
 *    1. head: a method to add a node to the dead of doubly linked list
 *    2. tail: a method to add a node to the tail of doubly linked list
 *    3. a method to remove a node by its ID
 *    4. a method to convert the list to an array
 *    5. a methot to print the whole list
 *    6. a method to search for a node by its ID
 *    7. delete the head of the list
 *    8. delete the tail of the list
 */
public class TransactionsLinkedList implements TransactionsList {
    
    /*Declare head, tail nodes and listsize************************************/
    private TransactionNode head;
    private TransactionNode tail;
    private int listSize = 0;

    /*____________________________CONSTRUCTORS________________________________*/

    /*Define a CONSTRUCTOR whith next, prev set to null. 
      Htis mean we are creating an emptu list initialy*************************/
    public TransactionsLinkedList() {
        this.head = null;
        this.tail = null;
        this.listSize = 0;
    }

    /*Define a CONSTRUCTOR whith head and tail as params***********************/
    public TransactionsLinkedList(TransactionNode head, TransactionNode tail) {
        this.head = head;
        this.tail = tail;
        this.listSize++;
    }



    /*_________________________INTERFACE METHODS______________________________*/
    
    /*  1 . ADDING A NODE TO THE HEAD of the doubly linked list*****************
     * Steps: 1. Create a new node
     * 
     *      if the list is empty
     *        2. update both tail and head to the new node
     * 
     *      else id the list is not empty
     *        2. Setting the next of the new node to the address of the current head
     *        3. Setting the previous of the current head to the address of new node
     *        4. Setting the head to the new node
    */
    @Override
    public void addTransactionHead(Transaction t) {
        TransactionNode node = new TransactionNode(t);
        /*if the list IS NOT EMPTY*/
        if (this.head != null) {
            node.setNextNode(this.head);
            this.head.setPrevtNode(node);
            this.head = node;
        }
        /*if the list IS EMPTY*/
        else {
            this.head = node;
            this.tail = node;
        }
        this.listSize++;
    }

    /*  2 . ADDING A NODE TO THE TAIL of the doubly linked list*****************
     * Steps: 1. Create a new node
     * 
     *      if the list is empty
     *       2. update both tail and head to point to the new node

     *      else id the list is not empty
     *       2. Setting the next of the current tail to the address of the new node
     *       3. Setting the previous of the new node to the address of the current tail
     *       4. Setting the tail to the new node
    */
    @Override
    public void addTransactionTail(Transaction t) {
        TransactionNode node = new TransactionNode(t);
        /*if the list IS NOT EMPTY*/
        if (this.head != null) {
            this.tail.setNextNode(node);
            node.setPrevtNode(this.tail);
            this.tail = node;
        }
        /*if the list IS EMPTY*/
        else {
            this.head = node;
            this.tail = node;
        }
        this.listSize++;
    }

    /*  3 . REMOVING A NODE BY ITS ID******************************************
     * Steps: 1. 
           if the list is not empty
     *          if the list got only one node and we want to remove it
     *              set both head and tail to null
     *      else if the node to be removed is the head
     *              delete head
     *      else
     *          traveling until we find the node to be removed
     *              if the node is not found throw an exception
     *              else if you find the node at the tail: delete tail
     *              else connect the prev of the node with the next of the node
     *      
    */
    @Override
    public void removeTrasactionById(UUID id) {
        if (this.head != null) {
            if (this.head == this.tail
                && this.head.getNodeData().getId().equals(id)) {
                    this.head = null;
                    this.tail = null;
                }
                else if (this.head.getNodeData().getId().equals(id)) {
                    this.deleteListsHead();
                }
                else {
                    TransactionNode temp = this.head;
                    TransactionNode prev = null;
                    while (temp !=null
                        && !(temp.getNodeData().getId().equals(id))) {
                            prev = temp;
                            temp = temp.getNextNode();
                        }
                        if (temp == null) {
                            throw new TransactionNotFoundException
                                ("Transaction not found");
                            }
                            else if (temp == this.tail) {
                                this.deleteListsTail();
                            }
                            else {
                                prev.setNextNode(temp.getNextNode());
                                temp.getNextNode().setPrevtNode(prev);
                            }
                        }
                        this.listSize--;
                    }
                }
        
                /*  4 . REMOVING A NODE BY ITS ID***************************************
                 * Steps: 1. 
                       if the list is not empty
                 *          if the list got only one node and we want to remove it
                 *              set both head and tail to null
                 *      else if the node to be removed is the head
                 *              delete head
                 *      else
                 *          traveling until we find the node to be removed
                 *              if the node is not found throw an exception
                 *              else if you find the node at the tail: delete tail
                 *              else connect the prev of the node with the next of the node
                 *      
                */         
                @Override
                public Transaction[] listToArray() {
                    Transaction[] transArray = new Transaction[this.listSize];
                    int i = 0;
                    
            for (TransactionNode temp = this.head; temp != null;
            temp = temp.getNextNode()) {
                transArray[i] = temp.getNodeData();
                i++;
            }
            return transArray;
        }
        
        
        /*_____________________________OTHER METHODS___________________________*/
        
        /*  5 . PRINT ALL LIST**************************************************
         * In the loop, we start from the head and print the data of each node
         * calling the getNodeData() method of the TransactionNode class and the
         * toString() method of the Transaction class.
        */
        public void printList() {
            for (TransactionNode temp = this.head; temp != null; 
            temp = temp.getNextNode()) {
                System.out.println("Total Transactions: " + listSize + "\n" 
                    + temp.getNodeData().toString());
            }
        }
        
        
        /*  6 . SEARCH BY ID****************************************************
            * In the loop, we start from the head and search for the node with the
            * specified ID. If the node is found, we return the transaction object
            * calling the getNodeData() method of the TransactionNode class.
            * If the node is not found, we return null.
        */
        public  Transaction searchById(UUID id) {
            for (TransactionNode temp = this.head; temp != null;
            temp = temp.getNextNode()) {
                if (temp.getNodeData().getId().equals(id)) {
                    return temp.getNodeData();
                }
            }
            return null;
        }
        
        /*  7 . DELETE THE HEAD ************************************************
        if the list is empty do nothing
        
        if the list is not empty
            if the list has only one node
                set both head and tail to null
            else
                set the head to the next of the current head
                set the previous of the new head to null
        */
        public  void deleteListsHead() {
            if (this.head != null) {
                //if the list has only one node
                if (this.head == this.tail) {
                    this.head = null;
                    this.tail = null;
                }  
                else {
                    this.head = this.head.getNextNode();
                    this.head.setPrevtNode(null);
                }
                this.listSize--;
            }
        }

        /*  8 . DELETE THE TAIL ************************************************
        if the list is empty do nothing
        
        if the list is not empty
            if the list has only one node
                set both head and tail to null
            else
                set the tail to the previous of the current tail
                set the next of the new tail to null
        
        */
        public  void deleteListsTail() {
            if (this.head !=null) {
                this.head = null;
                this.tail = null;
            }
            else {
                this.tail = this.tail.getPrevNode();
                this.tail.setNextNode(null);
            }
            this.listSize--;
        }
    }