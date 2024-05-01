public class NodeUtils {
    private TransactionNode head;
    private TransactionNode tail;
    private int lisSize;

    /*Costruttore */
    public NodeUtils(TransactionNode head, TransactionNode tail, int lisSize) {
        this.head = head;
        this.tail = tail;
        this.lisSize = lisSize;
    }

    /*ADDING A NODE TO THE HEAD of the doubly linked list*********************
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
    public void addToHead (TransactionNode head, TransactionNode tail,
        Transaction t) {
            TransactionNode tmpNode = new TransactionNode(t);
            /*if the list IS NOT EMPTY*/
            if (this.head != null) {
                tmpNode.setNextNode(this.head);
                this.head.setPrevtNode(tmpNode);
                this.head = tmpNode;
            }
            /*if the list IS EMPTY*/
            else {
                this.head = tmpNode;
                this.tail = tmpNode;
            }
            this.lisSize++;
        }
    }  //METTERE QUESTA ROMA IN NODE  E CAMBIARE I NOME DI PREV E NEXT!!
    

