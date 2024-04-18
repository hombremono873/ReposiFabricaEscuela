package fabricaescuela.fabricaescuela.aplicacion;

import org.springframework.stereotype.Service;

import fabricaescuela.fabricaescuela.core.dominio.CreditCard;
import fabricaescuela.fabricaescuela.core.interfaces.repositorios.IPaymentRepository;
import fabricaescuela.fabricaescuela.core.interfaces.servicios.IPaymentServicio;
import jakarta.transaction.Transactional;

@Service
public class PaymentServicio implements IPaymentServicio {
    private  IPaymentRepository repositorio;

    public PaymentServicio(IPaymentRepository repositorio) {
        this.repositorio = repositorio;
    }
    @Override
    @Transactional
    public boolean processPayment(long cardNumber, float amount) {
        // Buscar la tarjeta de crédito por su número
        CreditCard creditCard = repositorio.findByCardNumber(cardNumber);
        
        // Verificar si la tarjeta de crédito existe y si tiene saldo suficiente
        if (creditCard != null && creditCard.getSaldo() >= amount) {
            // Realizar el pago actualizando el saldo
            int rowsUpdated = this.repositorio.processPayment(cardNumber, amount);
            return rowsUpdated > 0; // Se actualizó al menos una fila (pago exitoso)
        }
        
        // No se pudo realizar el pago
        return false;
    }

}
