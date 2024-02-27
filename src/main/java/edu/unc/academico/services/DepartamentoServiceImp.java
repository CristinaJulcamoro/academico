package edu.unc.academico.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.unc.academico.domain.Departamento;
import edu.unc.academico.repositories.DepartamentoRepository;

@Service
public class DepartamentoServiceImp implements DepartamentoService {
	@Autowired
	private DepartamentoRepository dptoRep;
	
	@Override
	public List<Departamento> listarDpto() {
		return (List<Departamento>) dptoRep.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Departamento> buscarPorIdDpto(Long idDpto) {
		return dptoRep.findById(idDpto);
	}

	@Override
	public Departamento grabarDpto(Departamento dpto) {
		return dptoRep.save(dpto);
	}

	@Override
	public void eliminarDpto(Long idDpto) {
		dptoRep.deleteById(idDpto);
	}

}
