package fabricaescuela.fabricaescuela.core.datos;

public class PaymentRequest {
    private long cardNumber;
    private float amount;

    // Constructor
    public PaymentRequest(long cardNumber, float amount) {
        this.cardNumber = cardNumber;
        this.amount = amount;
    }

    // Getters y setters
    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
