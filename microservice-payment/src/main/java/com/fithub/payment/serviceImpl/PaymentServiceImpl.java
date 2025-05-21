package com.fithub.payment.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fithub.payment.client.PaymentTrainerClient;
import com.fithub.payment.response.StripeResponse;
import com.fithub.payment.service.PaymentService;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Event;
import com.stripe.model.checkout.Session;
import com.stripe.net.Webhook;
import com.stripe.param.checkout.SessionCreateParams;


@Service
public class PaymentServiceImpl implements PaymentService {

	@Value("${stripe.secret-key}")
	private String claveSecreta;
	
	@Value("${stripe.webhook-key}")
	private String keyWebHook;
	
	@Value("${stripe.successUrl}")
	private String successUrl;
	
	@Value("${stripe.cancelUrl}")
	private String cancelUrl;
	
	@Autowired
	PaymentTrainerClient ptc;

	@Override
	public StripeResponse suscribirsePremiumTrainer(String email) {
		Stripe.apiKey = claveSecreta;
		
		try {
			//TrainerDTO trainer = ptc.verTrainerEmail(); Usar para hacer la validacion de que si es premium no deje suscribirse de nuevo
			
			ptc.cambiarAPremiumTrainer(); //ESTO ES PARA ENTORNO EN LOCAL | BORRAR ESTA LINEA Y CONFIGURARLO EN EL WEBHOOK PARA PRODUCCION
			
			SessionCreateParams parametros = SessionCreateParams.builder()
					.setMode(SessionCreateParams.Mode.SUBSCRIPTION)
					.setSuccessUrl(successUrl)
					.setCancelUrl(cancelUrl)
					.setClientReferenceId(email)
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

	@Override
	public void procesarEventoStripe(String payload, String firmaStripe) { //HAY QUE CONFIGURAR EL WEBHOOK EN STRIPE EN PRODUCCION
		Stripe.apiKey = claveSecreta;
		
		try {
			Event event = Webhook.constructEvent(payload, firmaStripe, keyWebHook);
			
			if("checkout.session.completed".equals(event.getType())) {
				Session session = (Session) event.getDataObjectDeserializer()
		                .getObject()
		                .orElseThrow(() -> new RuntimeException("No se pudo obtener sesión de Stripe"));
				
				String email = session.getClientReferenceId();
				
				//ptc.cambiarPlanAPremium(email); IMPLEMENTAR ESTO PARA PONERLE EL PLAN PREMIUM A EL ENTRENADOR
			}
		} catch(StripeException e) {
			throw new RuntimeException("Error de Stripe: " + e.getMessage(), e);
		}
	}
}
