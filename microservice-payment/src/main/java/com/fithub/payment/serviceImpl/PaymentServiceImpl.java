package com.fithub.payment.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fithub.payment.client.PaymentTrainerClient;
import com.fithub.payment.dto.TrainerDTO;
import com.fithub.payment.response.StripeResponse;
import com.fithub.payment.service.PaymentService;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;


@Service
public class PaymentServiceImpl implements PaymentService {

	@Value("${stripe.secret-key}")
	private String claveSecreta;
	
	@Value("${stripe.successUrl}")
	private String successUrl;
	
	@Value("${stripe.cancelUrl}")
	private String cancelUrl;
	
	@Autowired
	PaymentTrainerClient ptc;

	@Override
	public StripeResponse suscribirsePremiumTrainer() {
		Stripe.apiKey = claveSecreta;
		
		try {
			//TrainerDTO trainer = ptc.verTrainerEmail(); Usar para hacer la validacion de que si es premium no deje suscribirse de nuevo
			
			SessionCreateParams parametros = SessionCreateParams.builder()
					.setMode(SessionCreateParams.Mode.SUBSCRIPTION)
					.setSuccessUrl(successUrl)
					.setCancelUrl(cancelUrl)
					.addLineItem(
							SessionCreateParams.LineItem.builder()
								.setQuantity(1L)
								.setPrice("price_1RQxxDGbLVNdc7rRiKSOr6BA")
								.build()
					)
			.build();
				
			Session sesion = Session.create(parametros);
			
			return new StripeResponse(sesion.getUrl());
		} catch (StripeException e) {
			throw new RuntimeException("Error al crear la sesión de Stripe", e);
		}
	}
	
}
