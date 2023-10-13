package com.example.demo.service;

import java.util.Objects;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.ParamsPessoaDTO;
import com.example.demo.dto.Retorno;
import com.example.demo.dto.RetornoBuilder;
import com.example.demo.model.CargoVO;
import com.example.demo.model.EspecialidadeVO;
import com.example.demo.model.FuncionarioVO;
import com.example.demo.model.MedicoVO;
import com.example.demo.model.PacienteVO;
import com.example.demo.model.PessoaVO;
import com.example.demo.persistence.CargoRepository;
import com.example.demo.persistence.EspecialidadeRepository;
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
	private CargoRepository cargoRepository;
	@Autowired
	private PacienteRepository pacienteRepository;
	@Autowired
	private EspecialidadeRepository especialidadeRepository;
	@Autowired
	private MedicoRepository medicoRepository;
	
	
	
	 
	 public Iterable<PessoaVO> findAll(){
		 logger.info("buscando todas as pessoas");
		 return pessoaRepository.findAll();
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
				
				if(Objects.nonNull(paramsPessoaDTO.getFuncionarioVO().getTurno())) {
					CargoVO cargoVO = cargoRepository.save(paramsPessoaDTO.getFuncionarioVO().getCargoVO());
					FuncionarioVO funcionarioVO = new FuncionarioVO();
					
					funcionarioVO.setCargoVO(cargoVO);
	//				funcionarioVO.setPessoaVO(pessoaVO);
					funcionarioVO.setCodCargo(cargoVO.getCodCargo());
					funcionarioVO.setCodPessoa(pessoaVO.getCodPessoa());
					funcionarioVO.setTurno(paramsPessoaDTO.getFuncionarioVO().getTurno());
					newPessoa.setFuncionarioVO(funcionarioRepository.save(funcionarioVO));
					
					EspecialidadeVO especialidadePersistida = new EspecialidadeVO();
					if(Objects.nonNull(paramsPessoaDTO.getFuncionarioVO().getMedicoVO().getEspecialidadeVO().getDescricaoEspecialidade())) {
						EspecialidadeVO especialidadeVO = new EspecialidadeVO();
						especialidadeVO.setDescricaoEspecialidade(paramsPessoaDTO.getFuncionarioVO().getMedicoVO().getEspecialidadeVO().getDescricaoEspecialidade());
						especialidadeVO.setValorEspecialidade(paramsPessoaDTO.getFuncionarioVO().getMedicoVO().getEspecialidadeVO().getValorEspecialidade());
						especialidadePersistida = especialidadeRepository.save(especialidadeVO);
					}
					if(Objects.nonNull(paramsPessoaDTO.getFuncionarioVO().getMedicoVO().getCodCrm())) {
						MedicoVO medicoVO = new MedicoVO();
						medicoVO.setCodCrm(paramsPessoaDTO.getFuncionarioVO().getMedicoVO().getCodCrm());
						medicoVO.setCodFuncionario(newPessoa.getFuncionarioVO().getCodFuncionario());
						medicoVO.setCodEspecialidade(especialidadePersistida.getCodEspecialidade());
						newPessoa.getFuncionarioVO().setMedicoVO(medicoRepository.save(medicoVO));
						newPessoa.getFuncionarioVO().getMedicoVO().setEspecialidadeVO(especialidadePersistida);
					}
				}
				
				if(Objects.nonNull(paramsPessoaDTO.getPacienteVO().getAltura()) && Objects.nonNull(paramsPessoaDTO.getPacienteVO().getPeso())) {
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

}
