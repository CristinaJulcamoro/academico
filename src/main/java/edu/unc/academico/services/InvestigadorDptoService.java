package edu.unc.academico.services;

import edu.unc.academico.domain.Investigador;

public interface InvestigadorDptoService {
	public Investigador replaceDpto(Long idInvestigador, Long idDpto);
	public void removeDpto(Long idInvestigador);

}
