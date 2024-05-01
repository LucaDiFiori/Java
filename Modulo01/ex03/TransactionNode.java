/*Doubly linked list node:
 * Create a class called TransactionNode that will be used to create a doubly 
 * linked list of transactions.
 */
public class TransactionNode {

    /*Define node atributes*/
    private TransactionNode next;
    private TransactionNode prev;
    private Transaction     t;

    /*Define a CONSTRUCTOR whith next, prev and t as params********************/
    public TransactionNode(Transaction t, TransactionNode t_PrevNode, 
        TransactionNode t_NextNode)
        {
            this.t = t;
            this.prev = t_PrevNode;
            this.next = t_NextNode;
        }
    
    /*Define a CONSTRUCTOR whith only t as a parameter*************************/    
    public TransactionNode(Transaction t)
    {
        this(t, null, null);
    }
    

    
    /*GET & SET methods********************************************************/
    public TransactionNode getNextNode() {
        return next;
    }

    public TransactionNode getPrevNode() {
        return prev;
    }

    public Transaction getNodeData() {
        return t;
    }

    public void setNextNode(TransactionNode next) {
        this.next = next;
    }

    public void setPrevtNode(TransactionNode prev) {
        this.prev = next;
    } 
}
