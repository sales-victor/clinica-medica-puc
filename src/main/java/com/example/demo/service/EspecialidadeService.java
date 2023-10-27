package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Retorno;
import com.example.demo.dto.RetornoBuilder;
import com.example.demo.model.EspecialidadeVO;
import com.example.demo.persistence.EspecialidadeRepository;

@Service
public class EspecialidadeService {
	@Autowired
	private EspecialidadeRepository especialidadeRepository;
	
	public Retorno findAll() {
		Retorno retorno = new Retorno();
		try {
			Iterable<EspecialidadeVO> listaEspecialidade = especialidadeRepository.findAll();
			retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.OK.value()).comMensagem("especilidades encontradas com sucesso").comObjeto(listaEspecialidade).construir();
		} catch (Exception e) {
			 retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem(e.getMessage()).construir();
		}
		return retorno;
	}
	
	public Retorno findByCodEspecialidade(Long codEspecialidade) {
		Retorno retorno = new Retorno();
		try {
			Optional<EspecialidadeVO> optEspecialidade = especialidadeRepository.findById(codEspecialidade);
			
			if(optEspecialidade.isPresent()) {
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.OK.value()).comMensagem("especialidade encontrado com sucesso").comObjeto(optEspecialidade.get()).construir();
			} else {
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.NO_CONTENT.value()).comMensagem("especialidade não encontrado").construir();
			}
			
		} catch (Exception e) {
			 retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem(e.getMessage()).construir();
		}
		return retorno;
	}
	
	public Retorno gravarEspecialidade(EspecialidadeVO especialidadeVO) {
		Retorno retorno = new Retorno();
		try {
			EspecialidadeVO especialidade = especialidadeRepository.save(especialidadeVO);
			retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.OK.value()).comMensagem("especialidade gravado com sucesso").comObjeto(especialidade).construir();
		} catch (Exception e) {
			 retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem(e.getMessage()).construir();
		}
		return retorno;
	}
	
	public Retorno editarEspecialidade(EspecialidadeVO especialidadeVO) {
		Retorno retorno = new Retorno();
		try {
			Optional<EspecialidadeVO> optEspecialidade = especialidadeRepository.findById(especialidadeVO.getCodEspecialidade());
			if(optEspecialidade.isPresent()) {
				EspecialidadeVO especialidade = new EspecialidadeVO();
				especialidade.setCodEspecialidade(especialidadeVO.getCodEspecialidade());
				especialidade.setDescricaoEspecialidade(especialidadeVO.getDescricaoEspecialidade());
				especialidade.setValorEspecialidade(especialidadeVO.getValorEspecialidade());
				EspecialidadeVO updateEspecialidade =	especialidadeRepository.save(especialidade);
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.OK.value()).comMensagem("especialidade editado com sucesso").comObjeto(updateEspecialidade).construir();
			} else {
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.NO_CONTENT.value()).comMensagem("especialidade não encontrado").construir();
			}
		} catch (Exception e) {
			 retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem(e.getMessage()).construir();
		}
		return retorno;
	}
	
	public Retorno deleteEspecialidade(Long codEspecialidade) {
		Retorno retorno = new Retorno();
		try {
			Optional<EspecialidadeVO> optEspecialidade = especialidadeRepository.findById(codEspecialidade);
			if(optEspecialidade.isPresent()) {
				especialidadeRepository.delete(optEspecialidade.get());
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.NO_CONTENT.value()).comMensagem("especialidade deletado com sucesso").construir();
			} else {
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.NO_CONTENT.value()).comMensagem("especialidade não encontrado").construir();
			}
		} catch (Exception e) {
			 retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem(e.getMessage()).construir();
		}
		return retorno;
	}
}
