package com.fithub.rutinas.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fithub.rutinas.dto.CrearRutinaDTO;
import com.fithub.rutinas.dto.RutinaCompletaDTO;
import com.fithub.rutinas.service.EjercicioService;
import com.fithub.rutinas.service.RutinaService;

@RequestMapping("/fithub/rutinas")
@RestController
public class RutinaRestController {

	@Autowired
	RutinaService rs;
	
	@Autowired
	EjercicioService es;
	
	@PostMapping("/crearRutina")
	ResponseEntity<Map<String, String>> crearRutina(@RequestBody CrearRutinaDTO rutina) {
		Map<String, String> respuesta = new HashMap<>();
		
		rs.crearRutina(rutina);
		respuesta.put("mensaje", "Rutina creada correctamente");
		
		return ResponseEntity.ok(respuesta);
	}
	
	@GetMapping("/verRutinasTrainer")
	List<RutinaCompletaDTO> verRutinasTrainer(@RequestParam Long trainerId) {
		return rs.verRutinasTrainer(trainerId);
	}
	
	@DeleteMapping("/eliminarRutina")
	ResponseEntity<Map<String, String>> eliminarRutina(@RequestParam Long id) {
		Map<String, String> respuesta = new HashMap<>();
		
		rs.eliminarRutina(id);
		respuesta.put("mensaje", "Rutina eliminada correctamente");
		
		return ResponseEntity.ok(respuesta);
	}
	
	@PostMapping("/asignarRutina/{clientId}/{id}")
	ResponseEntity<Map<String, String>> asignarRutina(@PathVariable Long clientId, @PathVariable Long id) {
		Map<String, String> respuesta = new HashMap<>();
		
		rs.asignarRutina(clientId, id);
		respuesta.put("mensaje", "Rutina asignada correctamente");
		
		return ResponseEntity.ok(respuesta);
	}
}
