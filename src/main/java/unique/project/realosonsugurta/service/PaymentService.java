package unique.project.realosonsugurta.service;

import unique.project.realosonsugurta.entity.Payment;
import unique.project.realosonsugurta.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;

    public Payment makePayment(Payment payment) {
        return paymentRepository.save(payment);
    }
}
