
public class UsersArrayList implements UsersList {

    private User[] usersArr; //Array degli utenti
    private int userNumber;
    private int maxSize = 10;

    /**costruttore
     * - Crea l'array di dimensione 10: chiamo il costruttore della classe array
     *                                  per la variabile userArr. generando un array
     *                                  di tipo User grande 10.
     *
     *                                  NOTA: Per gli array
     *                                        devo usare il costruttore solo quando non inizializzo
     *                                        direttamente l'elemento.
     *                                        Esempio iniz: int[] arr = {10,3}
     *                                        Esemoio non iniz: int[] arr = new int[2]
     *
     * - inizializza gli utenti a 0  */
    public UsersArrayList() {
        this.usersArr = new User[maxSize];
        this.userNumber = 0;
    }

    @Override
    public int listSize() {
        return this.userNumber;
    }

    /***********************IMPLEMENTO I METODI DELL'INTERFACCIA***************/

    /*ADDUSER________________________________________________________________ */
    @Override
    public void addUser(User u) {
        if (this.userNumber < this.maxSize) {
            this.usersArr[this.userNumber] = u;
            this.userNumber++;
        }
        else {
            //allargo la dimensione massima dell'array
            this.maxSize += (this.maxSize / 2);
            //creo un nuovo array temporaneo di dimensione maggiore
            User[] tempArr = new User[this.maxSize];
            //copio tutti gli elementi dell'array vecchio in quello nuovo
            for (int i = 0; i < this.userNumber; i++) {
                tempArr[i] = this.usersArr[i];
            }
            //assegno al "puntatore" userArr il nuovo array
            this.usersArr = tempArr;
            //aggiungo l'utente
            addUser(u);
        }
    }

    /*SEARCHBYID_____________________________________________________________ */
    @Override
    public User searchById (int id) {
        //in un ciclo sugli elementi presenti nell'array
        for (int i = 0; i < this.userNumber; i++) {
            /*se l'id dell'utente corrisponde a quello cercato ritorno l'utente
              NOTA: Considerando che ogni elemento è uno user, potrò usarne
                    il metodo che restituisce il suo ID e compararlo con quello
                    che cerco*/
            if (this.usersArr[i].getId() == id) {
                return this.usersArr[i];
            }
        }
        /*se non trovo l'utente con l'id cercato, lancio l'ecezione creatami
          che mi permetterà di gestire il caso in cui l'utente non esiste*/
        throw new UserNotFoundException("User not found\n");
    }

    /*SEARCHBYINDEX__________________________________________________________ */
    @Override
    public User searchByindex (int index) {
        if (index > this.userNumber || index < 0) {
            throw new UserNotFoundException("invalid index value\n");
        }
        else {
            return this.usersArr[index];
        }
    }
}