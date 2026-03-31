package smartwallet.model;

public class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String pesan) {
        super(pesan);
    }
}
