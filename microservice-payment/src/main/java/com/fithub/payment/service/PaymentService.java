package com.fithub.payment.service;

import com.fithub.payment.response.StripeResponse;

public interface PaymentService {

	StripeResponse suscribirsePremiumTrainer(String email);
	
	void procesarEventoStripe(String payload, String firmaStripe);
}
