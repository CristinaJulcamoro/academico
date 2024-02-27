package edu.unc.academico.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.unc.academico.domain.Investigador;
import edu.unc.academico.services.InvestigadorService;

@RestController
@RequestMapping("api/v1/investigadores")
public class InvestigadorController {
	@Autowired
	private InvestigadorService invService;  
	
	@GetMapping
	public List<Investigador> listarInv(){
		return invService.listarInv();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> listarPorInv(@PathVariable Long id) {
		Optional<Investigador> invOptional = invService.buscarPorIdInv(id);
		if (invOptional.isPresent()) {
			return ResponseEntity.ok(invOptional.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<?> crearInv(@RequestBody Investigador inv){
		return ResponseEntity.status(HttpStatus.CREATED).body(invService.grabarInv(inv));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editarInv(@PathVariable Long id, @RequestBody Investigador inv){
		Optional<Investigador> o = invService.buscarPorIdInv(id);
		if (o.isPresent()) {
			Investigador invBD = o.get();
			invBD.setApePat(invBD.getApePat());
			invBD.setApeMat(invBD.getApeMat());
			invBD.setEmail(invBD.getEmail());
			invBD.setFechaNac(invBD.getFechaNac());			
			invBD.setNombres(invBD.getNombres());
			
			return ResponseEntity.status(HttpStatus.CREATED).body(invService.grabarInv(invBD));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarDpto(@PathVariable Long id){
		Optional<Investigador> o = invService.buscarPorIdInv(id);
		if (o.isPresent()) {
			invService.eliminarInv(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

}
