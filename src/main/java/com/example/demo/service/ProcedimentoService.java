package com.example.demo.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.ParamsConsultaDTO;
import com.example.demo.dto.ParamsExameDTO;
import com.example.demo.dto.Retorno;
import com.example.demo.dto.RetornoBuilder;
import com.example.demo.model.ConsultaVO;
import com.example.demo.model.ExameVO;
import com.example.demo.model.MedicamentoPessoaVO;
import com.example.demo.model.PessoaVO;
import com.example.demo.model.PrescricaoVO;
import com.example.demo.model.ProcedimentoVO;
import com.example.demo.persistence.ConsultaRespository;
import com.example.demo.persistence.EspecialidadeRepository;
import com.example.demo.persistence.ExameRepository;
import com.example.demo.persistence.MedicoRepository;
import com.example.demo.persistence.PacienteRepository;
import com.example.demo.persistence.PessoaRepository;
import com.example.demo.persistence.ProcedimentoRepository;
import com.example.demo.persistence.TipoExameRepository;

@Service
public class ProcedimentoService {
	
	@Autowired
	private PacienteRepository pacienteRepository;
	@Autowired
	private MedicoRepository medicoRepository;
	@Autowired
	private EspecialidadeRepository especialidadeRepository;
	@Autowired
	private TipoExameRepository tipoExameRepository;
	@Autowired
	private ExameRepository exameRepository;
	@Autowired
	private ConsultaRespository consultaRespository;
	@Autowired
	private ProcedimentoRepository procedimentoRepository;
	@Autowired
	private PessoaRepository pessoaRepository;
	

	private Logger logger = Logger.getLogger(ProcedimentoService.class.getName());
	
	@Transactional
	public Retorno gravarConsulta(ParamsConsultaDTO paramsConsultaDTO) {
		Retorno retorno = new Retorno();
		
		try {
			ParamsConsultaDTO consulta = new ParamsConsultaDTO();
			
			if(Objects.nonNull(paramsConsultaDTO.getProcedimentoVO())) {
				
				ProcedimentoVO procedimentoVO = paramsConsultaDTO.getProcedimentoVO();
				ProcedimentoVO proc = procedimentoRepository.save(procedimentoVO);
				consulta.setProcedimentoVO(proc);
				if(Objects.nonNull(paramsConsultaDTO.getConsultaVO())) {
					
					ConsultaVO consultaVO = new ConsultaVO();
					consultaVO.setCodProcedimento(proc.getCodProcedimento());
					consultaVO.setCodEspecialidade(paramsConsultaDTO.getConsultaVO().getCodEspecialidade());
					consulta.setConsultaVO(consultaRespository.save(consultaVO));
				}
				
			}
			retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.OK.value()).comMensagem("consulta gravada com sucesso").comObjeto(consulta).construir();
		}catch (Exception e) {
			retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem(e.getMessage()).construir();
		}
		return retorno;
	}
	
	@Transactional
	public Retorno editarConsulta(ParamsConsultaDTO paramsConsultaDTO) {
		Retorno retorno = new Retorno();
		
		try {
			ParamsConsultaDTO consulta = new ParamsConsultaDTO();
			Optional<ConsultaVO> optConsulta = consultaRespository.findById(paramsConsultaDTO.getConsultaVO().getCodConsulta());
			
			if(optConsulta.isPresent()) {
				if(Objects.nonNull(paramsConsultaDTO.getConsultaVO().getProcedimentoVO())) {
					
					ProcedimentoVO procedimentoVO = new ProcedimentoVO();
					
					procedimentoVO.setCodProcedimento(paramsConsultaDTO.getConsultaVO().getProcedimentoVO().getCodProcedimento());
					procedimentoVO.setCodMedico(paramsConsultaDTO.getConsultaVO().getProcedimentoVO().getCodMedico());
					procedimentoVO.setCodPaciente(paramsConsultaDTO.getConsultaVO().getProcedimentoVO().getCodPaciente());
					procedimentoVO.setDataAtendimento(paramsConsultaDTO.getConsultaVO().getProcedimentoVO().getDataAtendimento());
					procedimentoVO.setEstado(paramsConsultaDTO.getConsultaVO().getProcedimentoVO().getEstado());
					procedimentoVO.setHaConvenio(paramsConsultaDTO.getConsultaVO().getProcedimentoVO().getHaConvenio());
					procedimentoVO.setRetorno(paramsConsultaDTO.getConsultaVO().getProcedimentoVO().getRetorno());
					procedimentoVO.setTipoConvenio(paramsConsultaDTO.getConsultaVO().getProcedimentoVO().getTipoConvenio());
					
					consulta.setProcedimentoVO(procedimentoRepository.save(procedimentoVO));
					if(Objects.nonNull(paramsConsultaDTO.getConsultaVO())) {
						
						ConsultaVO consultaVO = new ConsultaVO();
						consultaVO.setCodConsulta(paramsConsultaDTO.getConsultaVO().getCodConsulta());
						consultaVO.setCodProcedimento(paramsConsultaDTO.getConsultaVO().getCodProcedimento());
						consultaVO.setCodEspecialidade(paramsConsultaDTO.getConsultaVO().getCodEspecialidade());
						consulta.setConsultaVO(consultaRespository.save(consultaVO));
					}
					
				}
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.OK.value()).comMensagem("consulta editada com sucesso").comObjeto(consulta).construir();
			} else {
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.NO_CONTENT.value()).comMensagem("consulta não encontrada").construir();
			}
		
		}catch (Exception e) {
			retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem(e.getMessage()).construir();
		}
		return retorno;
	}
	
	@Transactional
	public Retorno editarExame(ParamsExameDTO paramsExameDTO) {
		Retorno retorno = new Retorno();
		
		try {
			ParamsExameDTO exame = new ParamsExameDTO();
			Optional<ExameVO> optExame= exameRepository.findById(paramsExameDTO.getExameVO().getCodExame());
			
			

			if(optExame.isPresent()) {
				if(Objects.nonNull(paramsExameDTO.getExameVO().getProcedimentoVO())) {
					
					ProcedimentoVO procedimentoVO = new ProcedimentoVO();
					
					procedimentoVO.setCodProcedimento(paramsExameDTO.getExameVO().getProcedimentoVO().getCodProcedimento());
					procedimentoVO.setCodMedico(paramsExameDTO.getExameVO().getProcedimentoVO().getCodMedico());
					procedimentoVO.setCodPaciente(paramsExameDTO.getExameVO().getProcedimentoVO().getCodPaciente());
					procedimentoVO.setDataAtendimento(paramsExameDTO.getExameVO().getProcedimentoVO().getDataAtendimento());
					procedimentoVO.setEstado(paramsExameDTO.getExameVO().getProcedimentoVO().getEstado());
					procedimentoVO.setHaConvenio(paramsExameDTO.getExameVO().getProcedimentoVO().getHaConvenio());
					procedimentoVO.setRetorno(paramsExameDTO.getExameVO().getProcedimentoVO().getRetorno());
					procedimentoVO.setTipoConvenio(paramsExameDTO.getExameVO().getProcedimentoVO().getTipoConvenio());
					
					exame.setProcedimentoVO(procedimentoRepository.save(procedimentoVO));
					if(Objects.nonNull(paramsExameDTO.getExameVO())) {
						
						ExameVO exameVO = new ExameVO();
						exameVO.setCodExame(paramsExameDTO.getExameVO().getCodExame());
						exameVO.setCodProcedimento(paramsExameDTO.getExameVO().getCodProcedimento());
						exameVO.setSolicitanteExame(paramsExameDTO.getExameVO().getSolicitanteExame());
						exame.setExameVO(exameRepository.save(exameVO));
					}
					
				}
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.OK.value()).comMensagem("consulta editada com sucesso").comObjeto(exame).construir();
			} else {
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.NO_CONTENT.value()).comMensagem("consulta não encontrada").construir();
			}
		
		}catch (Exception e) {
			retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem(e.getMessage()).construir();
		}
		return retorno;
	}
	
	public Retorno findByCodConsulta(Long codConsulta) {
		Retorno retorno = new Retorno();
		ParamsConsultaDTO consulta = new ParamsConsultaDTO();
		try {
			ConsultaVO consultaVO = consultaRespository.findById(codConsulta).orElseThrow(() -> new Exception("consulta não encontrada"));
			Optional<PessoaVO> paciente = pessoaRepository.findById(consultaVO.getProcedimentoVO().getPacienteVO().getCodPessoa());
			PessoaVO medico = pessoaRepository.findByDadosMedico(consultaVO.getProcedimentoVO().getMedicoVO().getCodMedico());
			consulta.setConsultaVO(consultaVO);
			consulta.setDadosPaciente(paciente.get());
			consulta.setDadosMedico(medico);
			
			retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.OK.value()).comMensagem("consulta encontrada com sucesso").comObjeto(consulta).construir();
		}catch (Exception e) {
			retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem(e.getMessage()).construir();
		}
		return retorno;
	}
	
	 public Retorno findAllConsulta(){
		 Retorno retorno = new Retorno();
		 try {
			 Iterable<ConsultaVO> listaConsulta = consultaRespository.findAll();
			 retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.OK.value()).comMensagem("consultas encontradas com sucesso").comObjeto(listaConsulta).construir();
		 }catch (Exception e) {
			 retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem(e.getMessage()).construir();
		 }
		 return retorno;
	 }
	 
	 public Retorno findAllExame(){
		 Retorno retorno = new Retorno();
		 try {
			 Iterable<ExameVO> listaExame = exameRepository.findAll();
			 retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.OK.value()).comMensagem("exames encontrados com sucesso").comObjeto(listaExame).construir();
		 }catch (Exception e) {
			 retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem(e.getMessage()).construir();
		 }
		 return retorno;
	 }
	
	@Transactional
	public Retorno gravarExame(ParamsExameDTO paramsExameDTO) {
		Retorno retorno = new Retorno();
		
		try {
			ParamsExameDTO exame = new ParamsExameDTO();
			
			if(Objects.nonNull(paramsExameDTO.getProcedimentoVO())) {
				
				ProcedimentoVO procedimentoVO = paramsExameDTO.getProcedimentoVO();
				ProcedimentoVO proc = procedimentoRepository.save(procedimentoVO);
				exame.setProcedimentoVO(proc);
				if(Objects.nonNull(paramsExameDTO.getExameVO())) {
					
					ExameVO exameVO = paramsExameDTO.getExameVO();
					exameVO.setCodProcedimento(proc.getCodProcedimento());
					exame.setExameVO(exameRepository.save(exameVO));
				}
				
			}
			retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.OK.value()).comMensagem("consulta gravada com sucesso").comObjeto(exame).construir();
		}catch (Exception e) {
			retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem(e.getMessage()).construir();
		}
		return retorno;
	}
	
	public Retorno findByCodExame(Long codExame) {
		Retorno retorno = new Retorno();
		ParamsExameDTO exame = new ParamsExameDTO();
		try {
			ExameVO exameVO = exameRepository.findById(codExame).orElseThrow(() -> new Exception("consulta não encontrada"));
			Optional<PessoaVO> paciente = pessoaRepository.findById(exameVO.getProcedimentoVO().getPacienteVO().getCodPessoa());
			PessoaVO medico = pessoaRepository.findByDadosMedico(exameVO.getProcedimentoVO().getMedicoVO().getCodMedico());
			exame.setExameVO(exameVO);
			exame.setDadosPaciente(paciente.get());
			exame.setDadosMedico(medico);
			
			retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.OK.value()).comMensagem("consulta encontrada com sucesso").comObjeto(exame).construir();
		}catch (Exception e) {
			retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem(e.getMessage()).construir();
		}
		return retorno;
	}
	
	public Retorno deleteExame(Long codExame) {
		Retorno retorno = new Retorno();
		
		try {
			ExameVO exameVO = exameRepository.findById(codExame).orElseThrow(() -> new Exception("Exame não encontrado"));
			if(Objects.nonNull(exameVO)) {
				exameRepository.delete(exameVO);
				procedimentoRepository.delete(exameVO.getProcedimentoVO());
			}
			
			retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.NO_CONTENT.value()).comMensagem("Exame deletado com sucesso").construir();
		}catch (Exception e) {
			retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem(e.getMessage()).construir();
		}
		return retorno;
	}
	
	public Retorno deleteConsulta(Long codConsulta) {
		Retorno retorno = new Retorno();
		
		try {
			ConsultaVO consultaVO = consultaRespository.findById(codConsulta).orElseThrow(() -> new Exception("Consulta não encontrado"));
			if(Objects.nonNull(consultaVO)) {
				consultaRespository.delete(consultaVO);
				procedimentoRepository.delete(consultaVO.getProcedimentoVO());
			}
			
			retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.NO_CONTENT.value()).comMensagem("Exame deletado com sucesso").construir();
		}catch (Exception e) {
			retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem(e.getMessage()).construir();
		}
		return retorno;
	}

}
