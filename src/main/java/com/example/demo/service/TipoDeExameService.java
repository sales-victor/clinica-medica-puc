package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Retorno;
import com.example.demo.dto.RetornoBuilder;
import com.example.demo.model.MedicamentoVO;
import com.example.demo.model.TipoExameVO;
import com.example.demo.persistence.TipoExameRepository;

@Service
public class TipoDeExameService {
	@Autowired
	private TipoExameRepository tipoExameRepository;
	
	public Retorno findAll() {
		Retorno retorno = new Retorno();
		try {
			Iterable<TipoExameVO> listaTipoExame= tipoExameRepository.findAll();
			retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.OK.value()).comMensagem("exames encontrados com sucesso").comObjeto(listaTipoExame).construir();
		} catch (Exception e) {
			 retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem(e.getMessage()).construir();
		}
		return retorno;
	}
	
	public Retorno findByCodTipoExame(Long codTipoExame) {
		Retorno retorno = new Retorno();
		try {
			Optional<TipoExameVO> optTipoExame = tipoExameRepository.findById(codTipoExame);
			
			if(optTipoExame.isPresent()) {
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.OK.value()).comMensagem("exame encontrado com sucesso").comObjeto(optTipoExame.get()).construir();
			} else {
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.NO_CONTENT.value()).comMensagem("exame não encontrado").construir();
			}
			
		} catch (Exception e) {
			 retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem(e.getMessage()).construir();
		}
		return retorno;
	}
	
	public Retorno gravarTipoExame(TipoExameVO tipoExameVO) {
		Retorno retorno = new Retorno();
		try {
			TipoExameVO tipoExame = tipoExameRepository.save(tipoExameVO);
			retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.OK.value()).comMensagem("exame gravado com sucesso").comObjeto(tipoExame).construir();
		} catch (Exception e) {
			 retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem(e.getMessage()).construir();
		}
		return retorno;
	}
	
	public Retorno editarTipoExame(TipoExameVO tipoExameVO) {
		Retorno retorno = new Retorno();
		try {
			Optional<TipoExameVO> optTipoExame = tipoExameRepository.findById(tipoExameVO.getCodTipoExame());
			if(optTipoExame.isPresent()) {
				TipoExameVO tipoExame = new TipoExameVO();
				tipoExame.setCodTipoExame(tipoExameVO.getCodTipoExame());
				tipoExame.setDescricaoExame(tipoExameVO.getDescricaoExame());
				tipoExame.setValorExame(tipoExameVO.getValorExame());
				TipoExameVO updateTipoExame =	tipoExameRepository.save(tipoExame);
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.OK.value()).comMensagem("exame editado com sucesso").comObjeto(updateTipoExame).construir();
			} else {
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.NO_CONTENT.value()).comMensagem("exame não encontrado").construir();
			}
		} catch (Exception e) {
			 retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem(e.getMessage()).construir();
		}
		return retorno;
	}
	
	public Retorno deleteTipoExame(Long codTipoExame) {
		Retorno retorno = new Retorno();
		try {
			Optional<TipoExameVO> optTipoExame = tipoExameRepository.findById(codTipoExame);
			if(optTipoExame.isPresent()) {
				tipoExameRepository.delete(optTipoExame.get());
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.NO_CONTENT.value()).comMensagem("exame deletado com sucesso").construir();
			} else {
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.NO_CONTENT.value()).comMensagem("exame não encontrado").construir();
			}
		} catch (Exception e) {
			 retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem(e.getMessage()).construir();
		}
		return retorno;
	}
}
