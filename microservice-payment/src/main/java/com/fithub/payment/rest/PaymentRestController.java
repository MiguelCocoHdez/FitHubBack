package com.fithub.payment.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fithub.payment.response.StripeResponse;
import com.fithub.payment.service.PaymentService;

@RequestMapping("/fithub/payment")
@RestController
public class PaymentRestController {

	@Autowired
	PaymentService ps;
	
	@PostMapping("/suscripcionPremium")
	ResponseEntity<StripeResponse> suscribirsePremiumTrainer(Authentication auth) {
		String email = (String) auth.getPrincipal();
		
		
		return ResponseEntity.ok(ps.suscribirsePremiumTrainer(email));
	}
	
	//HAY QUE CONFIGURAR EL WEBHOOK EN STRIPE EN PRODUCCION
	@PostMapping("/stripe/webhook")
	ResponseEntity<String> webhook(@RequestBody String payload, @RequestHeader("Stripe-Signature") String firmaStripe) {
		ps.procesarEventoStripe(payload, firmaStripe);
		
		return ResponseEntity.ok("");
	}
}
