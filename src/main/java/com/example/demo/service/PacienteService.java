package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.persistence.PacienteRepository;
import com.example.demo.persistence.PessoaRepository;

@Service
public class PacienteService {
	
	@Autowired
	private PacienteRepository pacienteRepository;
	@Autowired
	private PessoaRepository pessoaRepository;
	
//	@Transactional
//	public PacienteVO create(PacienteDTO pacienteDTO) {
//		
//		PessoaVO pessoaVO = pessoaRepository.save(pacienteDTO.getPessoaVO());
//		PacienteVO pacienteVO = new PacienteVO();
//		
//		pacienteVO.setAltura(pacienteDTO.getPacienteVO().getAltura());
//		pacienteVO.setPeso(pacienteDTO.getPacienteVO().getPeso());
//		pacienteVO.setCodPessoa(pessoaVO.getCodPessoa());
//		
//		return pacienteRepository.save(pacienteVO);
//		
//		
//	}

}
