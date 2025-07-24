package com.fithub.connection.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fithub.connection.dto.MensajeDTO;
import com.fithub.connection.dto.MensajeRecibidoDTO;
import com.fithub.connection.service.MensajesService;

@RequestMapping("/fithub/mensajes")
@RestController
public class MensajesRestController {

	@Autowired
	MensajesService ms;
	
	@PostMapping("/enviar")
	ResponseEntity<Map<String, String>> enviarMensaje(@RequestBody MensajeDTO m) {
		Map<String, String> respuesta = new HashMap<>();
		
		ms.mandarMensaje(m);
		respuesta.put("mensaje", "Mensaje enviado correctamente");
		
		return ResponseEntity.ok(respuesta);
	}
	
	@GetMapping("/verConversacion")
	List<MensajeRecibidoDTO> verConversacion(@RequestParam Long trainerId, @RequestParam Long clientId) {
		return ms.verConversacion(trainerId, clientId);
	}
}
