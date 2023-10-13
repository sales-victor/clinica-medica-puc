package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.persistence.CargoRepository;
import com.example.demo.persistence.FuncionarioRepository;
import com.example.demo.persistence.PessoaRepository;

@Service
public class FuncionarioService {
	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	@Autowired
	private CargoRepository cargoRepository;
	
//	@Transactional
//	public FuncionarioVO create(FuncionarioDTO funcionarioDTO) {
//		PessoaVO pessoaVO = pessoaRepository.save(funcionarioDTO.getPessoaVO());
//		CargoVO cargoVO = cargoRepository.save(funcionarioDTO.getCargoVO());
//		FuncionarioVO funcionarioVO = new FuncionarioVO();
//		
//		funcionarioVO.setCargoVO(cargoVO);
//		funcionarioVO.setPessoaVO(pessoaVO);
//		funcionarioVO.setCodCargo(cargoVO.getCodCargo());
//		funcionarioVO.setCodPessoa(pessoaVO.getCodPessoa());
//		funcionarioVO.setTurno(funcionarioDTO.getFuncionarioVO().getTurno());
//		
//		return funcionarioRepository.save(funcionarioVO);
//	}
}
