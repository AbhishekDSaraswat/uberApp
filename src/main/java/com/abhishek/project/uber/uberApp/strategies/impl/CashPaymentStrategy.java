package com.abhishek.project.uber.uberApp.strategies.impl;

import com.abhishek.project.uber.uberApp.entities.Driver;
import com.abhishek.project.uber.uberApp.entities.Payment;
import com.abhishek.project.uber.uberApp.entities.enums.PaymentStatus;
import com.abhishek.project.uber.uberApp.entities.enums.TransactionMethod;
import com.abhishek.project.uber.uberApp.repositories.PaymentRepository;
import com.abhishek.project.uber.uberApp.services.PaymentService;
import com.abhishek.project.uber.uberApp.services.WalletService;
import com.abhishek.project.uber.uberApp.strategies.PaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

// cod case
//Rider pay 100 rs to driver
//Driver receive all 100 rs money in cash from rider and then  deduct 30 rs from driver wallet

@Service
@RequiredArgsConstructor
public class CashPaymentStrategy implements PaymentStrategy {
    private final WalletService walletService;
    private final PaymentRepository paymentRepository;

    @Override
    public void processPayment(Payment payment) {
        Driver driver = payment.getRide().getDriver();


        double platformCommission = payment.getAmount() * PLATFORM_COMMISSION;

        walletService.deductMoneyFromWallet(driver.getUser(), platformCommission,null,
                payment.getRide(), TransactionMethod.RIDE);

        payment.setPaymentStatus(PaymentStatus.CONFIRMED);
        paymentRepository.save(payment);


    }
}
