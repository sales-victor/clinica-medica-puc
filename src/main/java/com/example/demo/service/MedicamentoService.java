package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Retorno;
import com.example.demo.dto.RetornoBuilder;
import com.example.demo.model.MedicamentoVO;
import com.example.demo.persistence.MedicamentoRepository;

@Service
public class MedicamentoService {
	@Autowired
	private MedicamentoRepository medicamentoRepository;
	
	public Retorno findAll() {
		Retorno retorno = new Retorno();
		try {
			Iterable<MedicamentoVO> listaMedicamento = medicamentoRepository.findAll();
			retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.OK.value()).comMensagem("medicamentos encontrados com sucesso").comObjeto(listaMedicamento).construir();
		} catch (Exception e) {
			 retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem(e.getMessage()).construir();
		}
		return retorno;
	}
	
	public Retorno findByCodMedicamento(Long codMedicamento) {
		Retorno retorno = new Retorno();
		try {
			Optional<MedicamentoVO> optMedicamento = medicamentoRepository.findById(codMedicamento);
			
			if(optMedicamento.isPresent()) {
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.OK.value()).comMensagem("medicamento encontrado com sucesso").comObjeto(optMedicamento.get()).construir();
			} else {
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.NO_CONTENT.value()).comMensagem("medicamento não encontrado").construir();
			}
			
		} catch (Exception e) {
			 retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem(e.getMessage()).construir();
		}
		return retorno;
	}
	
	public Retorno gravarMedicamento(MedicamentoVO medicamentoVO) {
		Retorno retorno = new Retorno();
		try {
			MedicamentoVO medicamento = medicamentoRepository.save(medicamentoVO);
			retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.OK.value()).comMensagem("medicamento gravado com sucesso").comObjeto(medicamento).construir();
		} catch (Exception e) {
			 retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem(e.getMessage()).construir();
		}
		return retorno;
	}
	
	public Retorno editarMedicamento(MedicamentoVO medicamentoVO) {
		Retorno retorno = new Retorno();
		try {
			Optional<MedicamentoVO> optMedicamento = medicamentoRepository.findById(medicamentoVO.getCodMedicamento());
			if(optMedicamento.isPresent()) {
				MedicamentoVO medicamento = new MedicamentoVO();
				medicamento.setCodMedicamento(medicamentoVO.getCodMedicamento());
				medicamento.setNomeMedicamento(medicamentoVO.getNomeMedicamento());
				MedicamentoVO updatemedicamento =	medicamentoRepository.save(medicamento);
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.OK.value()).comMensagem("medicamento editado com sucesso").comObjeto(updatemedicamento).construir();
			} else {
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.NO_CONTENT.value()).comMensagem("medicamento não encontrado").construir();
			}
		} catch (Exception e) {
			 retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem(e.getMessage()).construir();
		}
		return retorno;
	}
	
	public Retorno deleteMedicamento(Long codMedicamento) {
		Retorno retorno = new Retorno();
		try {
			Optional<MedicamentoVO> optMedicamento = medicamentoRepository.findById(codMedicamento);
			if(optMedicamento.isPresent()) {
				medicamentoRepository.delete(optMedicamento.get());
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.NO_CONTENT.value()).comMensagem("medicamento deletado com sucesso").construir();
			} else {
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.NO_CONTENT.value()).comMensagem("medicamento não encontrado").construir();
			}
		} catch (Exception e) {
			 retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem(e.getMessage()).construir();
		}
		return retorno;
	}
}
