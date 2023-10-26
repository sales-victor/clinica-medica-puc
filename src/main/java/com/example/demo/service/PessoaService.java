package com.example.demo.service;

import java.util.Objects;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.ParamsPessoaDTO;
import com.example.demo.dto.Retorno;
import com.example.demo.dto.RetornoBuilder;
import com.example.demo.model.FuncionarioVO;
import com.example.demo.model.MedicoVO;
import com.example.demo.model.PacienteVO;
import com.example.demo.model.PessoaVO;
import com.example.demo.persistence.FuncionarioRepository;
import com.example.demo.persistence.MedicoRepository;
import com.example.demo.persistence.PacienteRepository;
import com.example.demo.persistence.PessoaRepository;

@Service
public class PessoaService {
	
	private Logger logger = Logger.getLogger(PessoaService.class.getName());
	
	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	@Autowired
	private PacienteRepository pacienteRepository;
	@Autowired
	private MedicoRepository medicoRepository;
	
	
	
	 
	 public Retorno findAll(){
		 Retorno retorno = new Retorno();
		 try {
			 Iterable<PessoaVO> listaPessoa = pessoaRepository.findAll();
			 retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.OK.value()).comMensagem("pessoas encontradas com sucesso").comObjeto(listaPessoa).construir();
		 }catch (Exception e) {
			 retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem(e.getMessage()).construir();
		 }
		 return retorno;
	 }
	 
	 public Retorno findByCodPessoa(Long codPessoa){
		 logger.info("buscando pessoa");
		 Retorno retorno = new Retorno();
		 
		 try {
			 PessoaVO pessoa = pessoaRepository.findById(codPessoa).orElseThrow(() -> new Exception("Pessoa não encontrada"));
			 retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.OK.value()).comMensagem("pessoa encontrada com sucesso").comObjeto(pessoa).construir();
		 }catch (Exception e) {
			 retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem(e.getMessage()).construir();
		 }

		 return retorno;
	 }
	 
		@Transactional
		public Retorno create(ParamsPessoaDTO paramsPessoaDTO) {
			Retorno retorno = new Retorno();
			
			try {
				ParamsPessoaDTO newPessoa = new ParamsPessoaDTO();
				PessoaVO pessoaVO = pessoaRepository.save(paramsPessoaDTO.getPessoaVO());
				newPessoa.setPessoaVO(pessoaVO);
				
				if(Objects.nonNull(paramsPessoaDTO.getFuncionarioVO())) {
					
					FuncionarioVO funcionarioVO = new FuncionarioVO();
					funcionarioVO.setCodCargo(paramsPessoaDTO.getFuncionarioVO().getCodCargo());
					funcionarioVO.setCodPessoa(pessoaVO.getCodPessoa());
					funcionarioVO.setTurno(paramsPessoaDTO.getFuncionarioVO().getTurno());
					newPessoa.setFuncionarioVO(funcionarioRepository.save(funcionarioVO));

					if(Objects.nonNull(paramsPessoaDTO.getFuncionarioVO().getMedicoVO())) {
						MedicoVO medicoVO = new MedicoVO();
						medicoVO.setCodCrm(paramsPessoaDTO.getFuncionarioVO().getMedicoVO().getCodCrm());
						medicoVO.setCodFuncionario(newPessoa.getFuncionarioVO().getCodFuncionario());
						medicoVO.setCodEspecialidade(paramsPessoaDTO.getFuncionarioVO().getMedicoVO().getCodEspecialidade());
						newPessoa.getFuncionarioVO().setMedicoVO(medicoRepository.save(medicoVO));
					}
				}
				
				if(Objects.nonNull(paramsPessoaDTO.getPacienteVO())) {
					PacienteVO pacienteVO = new PacienteVO();
					pacienteVO.setAltura(paramsPessoaDTO.getPacienteVO().getAltura());
					pacienteVO.setPeso(paramsPessoaDTO.getPacienteVO().getPeso());
					pacienteVO.setCodPessoa(pessoaVO.getCodPessoa());
					
					newPessoa.setPacienteVO(pacienteRepository.save(pacienteVO));
				}
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.OK.value()).comMensagem("pessoa gravada com sucesso").comObjeto(newPessoa).construir();
			} catch (Exception e) {
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem(e.getMessage()).construir();
			}
			
			return retorno;
		}
		
		@Transactional
		public Retorno update(ParamsPessoaDTO paramsPessoaDTO) {
			Retorno retorno = new Retorno();
			
			try {
				Optional<PessoaVO> optPessoa = pessoaRepository.findById(paramsPessoaDTO.getPessoaVO().getCodPessoa());
				
				if(optPessoa.isPresent()) {
					
					PessoaVO pessoaVO = new PessoaVO();
					pessoaVO.setCodPessoa(paramsPessoaDTO.getPessoaVO().getCodPessoa());
					pessoaVO.setBairro(paramsPessoaDTO.getPessoaVO().getBairro());
					pessoaVO.setCep(paramsPessoaDTO.getPessoaVO().getCep());
					pessoaVO.setCidade(paramsPessoaDTO.getPessoaVO().getCidade());
					pessoaVO.setCpf(paramsPessoaDTO.getPessoaVO().getCpf());
					pessoaVO.setEndereco(paramsPessoaDTO.getPessoaVO().getEndereco());
					pessoaVO.setNomePessoa(paramsPessoaDTO.getPessoaVO().getNomePessoa());
					pessoaVO.setDataNascimento(paramsPessoaDTO.getPessoaVO().getDataNascimento());
					pessoaVO.setTelefone(paramsPessoaDTO.getPessoaVO().getTelefone());
					PessoaVO pessoaUpdate = pessoaRepository.save(pessoaVO);
					
					if(Objects.nonNull(paramsPessoaDTO.getPessoaVO().getFuncionarioVO())) {
						
						FuncionarioVO funcionarioVO = new FuncionarioVO();
						funcionarioVO.setCodFuncionario(paramsPessoaDTO.getPessoaVO().getFuncionarioVO().getCodFuncionario());
						funcionarioVO.setCodCargo(paramsPessoaDTO.getPessoaVO().getFuncionarioVO().getCodCargo());
						funcionarioVO.setCodPessoa(paramsPessoaDTO.getPessoaVO().getFuncionarioVO().getCodPessoa());
						funcionarioVO.setTurno(paramsPessoaDTO.getPessoaVO().getFuncionarioVO().getTurno());
						pessoaUpdate.setFuncionarioVO(funcionarioRepository.save(funcionarioVO)); ;

						if(Objects.nonNull(paramsPessoaDTO.getPessoaVO().getFuncionarioVO().getMedicoVO())) {
							MedicoVO medicoVO = new MedicoVO();
							medicoVO.setCodMedico(paramsPessoaDTO.getPessoaVO().getFuncionarioVO().getMedicoVO().getCodMedico());
							medicoVO.setCodCrm(paramsPessoaDTO.getPessoaVO().getFuncionarioVO().getMedicoVO().getCodCrm());
							medicoVO.setCodFuncionario(paramsPessoaDTO.getPessoaVO().getFuncionarioVO().getMedicoVO().getCodFuncionario());
							medicoVO.setCodEspecialidade(paramsPessoaDTO.getPessoaVO().getFuncionarioVO().getMedicoVO().getCodEspecialidade());
							pessoaUpdate.getFuncionarioVO().setMedicoVO(medicoRepository.save(medicoVO));
						}
					}
					
					if(Objects.nonNull(paramsPessoaDTO.getPessoaVO().getPacienteVO())) {
						PacienteVO pacienteVO = new PacienteVO();
						pacienteVO.setCodPaciente(paramsPessoaDTO.getPessoaVO().getPacienteVO().getCodPaciente());
						pacienteVO.setAltura(paramsPessoaDTO.getPessoaVO().getPacienteVO().getAltura());
						pacienteVO.setPeso(paramsPessoaDTO.getPessoaVO().getPacienteVO().getPeso());
						pacienteVO.setCodPessoa(paramsPessoaDTO.getPessoaVO().getPacienteVO().getCodPessoa());
						pessoaUpdate.setPacienteVO(pacienteRepository.save(pacienteVO));
					}
					
					retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.OK.value()).comMensagem("pessoa editada com sucesso").comObjeto(pessoaUpdate).construir();
				} else {
					retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.NO_CONTENT.value()).comMensagem("pessoa não encontrada").construir();
				}
				
			} catch (Exception e) {
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem(e.getMessage()).construir();
			}
			
			return retorno;
		}

}