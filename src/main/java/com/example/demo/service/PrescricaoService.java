package com.example.demo.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.ParamsPrescricaoDTO;
import com.example.demo.dto.Retorno;
import com.example.demo.dto.RetornoBuilder;
import com.example.demo.model.MedicamentoPessoaVO;
import com.example.demo.model.PessoaVO;
import com.example.demo.model.PrescricaoVO;
import com.example.demo.persistence.MedicamentoPessoaRepository;
import com.example.demo.persistence.PessoaRepository;
import com.example.demo.persistence.PrescricaoRepository;

@Service
public class PrescricaoService {

	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private PrescricaoRepository prescricaoRepository;
	@Autowired
	private MedicamentoPessoaRepository medicamentoPessoaRepository;
	
	
	@Transactional
	public Retorno gravarPrescrisao(ParamsPrescricaoDTO paramsPrescricaoDTO) {
		Retorno retorno = new Retorno();
		
		try {
			ParamsPrescricaoDTO prescricao = new ParamsPrescricaoDTO();
			
			if(Objects.nonNull(paramsPrescricaoDTO.getPrescricaoVO())) {
				PrescricaoVO prescricaoVO = new PrescricaoVO();
				prescricaoVO.setCodMedico(paramsPrescricaoDTO.getPrescricaoVO().getCodMedico());
				prescricaoVO.setCodPaciente(paramsPrescricaoDTO.getPrescricaoVO().getCodPaciente());
				prescricaoVO.setDataAtendimento(paramsPrescricaoDTO.getPrescricaoVO().getDataAtendimento());
				prescricaoVO.setDataVencimento(paramsPrescricaoDTO.getPrescricaoVO().getDataVencimento());
				PrescricaoVO pres = prescricaoRepository.save(prescricaoVO);
				prescricao.setPrescricaoVO(pres);
				
				if(Objects.nonNull(pres)) {
					List<MedicamentoPessoaVO> listaMedicamentoPessoaVO = paramsPrescricaoDTO.getPrescricaoVO().getMedicamentoPessoaVO();
					List<MedicamentoPessoaVO> listaMedicamentoPessoa = (List<MedicamentoPessoaVO>) medicamentoPessoaRepository.saveAll(listaMedicamentoPessoaVO);
					prescricao.getPrescricaoVO().setMedicamentoPessoaVO(listaMedicamentoPessoa);
				}
				
				
			}
			retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.OK.value()).comMensagem("prescrisao gravada com sucesso").comObjeto(prescricao).construir();
		}catch (Exception e) {
			retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem(e.getMessage()).construir();
		}
		return retorno;
	}
	
	public Retorno findByCodPrescrisao(Long codPrescrisao) {
		Retorno retorno = new Retorno();
		ParamsPrescricaoDTO prescricao = new ParamsPrescricaoDTO();
		try {
			Optional<PrescricaoVO> prescricaoVO = prescricaoRepository.findById(codPrescrisao);
			if(prescricaoVO.isPresent()) {
				Optional<PessoaVO> paciente = pessoaRepository.findById(prescricaoVO.get().getPacienteVO().getCodPessoa());
				PessoaVO medico = pessoaRepository.findByDadosMedico(prescricaoVO.get().getMedicoVO().getCodMedico());
				prescricao.setPrescricaoVO(prescricaoVO.get());
				prescricao.setDadosPaciente(paciente.get());
				prescricao.setDadosMedico(medico);
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.OK.value()).comMensagem("prescrisao encontrada com sucesso").comObjeto(prescricao).construir();
			} else {
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.NO_CONTENT.value()).comMensagem("prescrisao não encontrada").construir();
			}
			
			
		}catch (Exception e) {
			retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem(e.getMessage()).construir();
		}
		return retorno;
	}
	
	@Transactional
	public Retorno editarPrescrisao(ParamsPrescricaoDTO paramsPrescricaoDTO) throws Exception {
		Retorno retorno = new Retorno();
		Optional<PrescricaoVO> prescricao = prescricaoRepository.findById(paramsPrescricaoDTO.getPrescricaoVO().getCodPrescricao());
		try {
			ParamsPrescricaoDTO presc = new ParamsPrescricaoDTO();
			
			if(prescricao.isPresent()) {
				
				PrescricaoVO prescricaoVO = new PrescricaoVO();
				prescricaoVO.setCodPrescricao(prescricao.get().getCodPrescricao());
				prescricaoVO.setCodMedico(paramsPrescricaoDTO.getPrescricaoVO().getCodMedico());
				prescricaoVO.setCodPaciente(paramsPrescricaoDTO.getPrescricaoVO().getCodPaciente());
				prescricaoVO.setDataAtendimento(paramsPrescricaoDTO.getPrescricaoVO().getDataAtendimento());
				prescricaoVO.setDataVencimento(paramsPrescricaoDTO.getPrescricaoVO().getDataVencimento());
				PrescricaoVO pres = prescricaoRepository.save(prescricaoVO);
				presc.setPrescricaoVO(pres);
				
				if(Objects.nonNull(pres)) {
					List<MedicamentoPessoaVO> listaMedicamentoPessoaVO = medicamentoPessoaRepository.findByCodPaciente(pres.getCodPaciente());
					medicamentoPessoaRepository.deleteAll(listaMedicamentoPessoaVO);
					
					List<MedicamentoPessoaVO>  newListMedicamento = paramsPrescricaoDTO.getPrescricaoVO().getMedicamentoPessoaVO();
					List<MedicamentoPessoaVO> listaMedicamentoPessoa = (List<MedicamentoPessoaVO>) medicamentoPessoaRepository.saveAll(newListMedicamento);
					presc.getPrescricaoVO().setMedicamentoPessoaVO( listaMedicamentoPessoa);
				}
			}
			retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.OK.value()).comMensagem("prescrisao editada com sucesso").comObjeto(presc).construir();
		}catch (Exception e) {
			retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem(e.getMessage()).construir();
		}
		return retorno;
	}
	
	public Retorno deletePrescrisao(Long codPrescrisao) {
		Retorno retorno = new Retorno();
		
		try {
			PrescricaoVO prescricaoVO = prescricaoRepository.findById(codPrescrisao).orElseThrow(() -> new Exception("Prescrisao não encontrada"));
			if(Objects.nonNull(prescricaoVO)) {
				List<MedicamentoPessoaVO> listaMedicamentoPessoaVO = medicamentoPessoaRepository.findByCodPaciente(prescricaoVO.getCodPaciente());
				if(!listaMedicamentoPessoaVO.isEmpty()) {
					medicamentoPessoaRepository.deleteAll(listaMedicamentoPessoaVO);
				}
			}
			
			prescricaoRepository.delete(prescricaoVO);
			retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.NO_CONTENT.value()).comMensagem("prescrisao deletada com sucesso").construir();
		}catch (Exception e) {
			retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem(e.getMessage()).construir();
		}
		return retorno;
	}
}
