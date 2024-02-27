package edu.unc.academico.services;

import java.util.List;
import java.util.Optional;

import edu.unc.academico.domain.Investigador;

public interface InvestigadorService {
	List<Investigador> listarInv();
	Optional<Investigador> buscarPorIdInv(Long idInv);
	Investigador grabarInv(Investigador inv);
	void eliminarInv(Long idInv);

}
