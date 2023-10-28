package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Retorno;
import com.example.demo.dto.RetornoBuilder;
import com.example.demo.model.PagamentoVO;
import com.example.demo.persistence.PagamentoRepository;

@Service
public class PagamentoService {
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	//PagamentoVO pagamentoVO
	public Retorno findAll() {
		Retorno retorno = new Retorno();
		try {
			Iterable<PagamentoVO> listaPagamento = pagamentoRepository.findAll();
			retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.OK.value()).comMensagem("pagamentos encontrados com sucesso").comObjeto(listaPagamento).construir();
		} catch (Exception e) {
			 retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem(e.getMessage()).construir();
		}
		return retorno;
	}
	
	public Retorno findByCodPagamento(Long codPagamento) {
		Retorno retorno = new Retorno();
		try {
			Optional<PagamentoVO> optPagamento = pagamentoRepository.findById(codPagamento);
			
			if(optPagamento.isPresent()) {
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.OK.value()).comMensagem("pagamento encontrado com sucesso").comObjeto(optPagamento.get()).construir();
			} else {
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.NO_CONTENT.value()).comMensagem("pagamento não encontrado").construir();
			}
			
		} catch (Exception e) {
			 retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem(e.getMessage()).construir();
		}
		return retorno;
	}
	
	public Retorno gravarPagamento(PagamentoVO pagamentoVO) {
		Retorno retorno = new Retorno();
		try {
			PagamentoVO pagamento = pagamentoRepository.save(pagamentoVO);
			retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.OK.value()).comMensagem("pagamento gravado com sucesso").comObjeto(pagamento).construir();
		} catch (Exception e) {
			 retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem(e.getMessage()).construir();
		}
		return retorno;
	}
	
	public Retorno editarPagamento(PagamentoVO pagamentoVO) {
		Retorno retorno = new Retorno();
		try {
			Optional<PagamentoVO> optPagamento = pagamentoRepository.findById(pagamentoVO.getCodPagamento());
			if(optPagamento.isPresent()) {
				PagamentoVO pagamento = new PagamentoVO();
				pagamento.setCodPagamento(pagamentoVO.getCodPagamento());
				pagamento.setCodConfirmacao(pagamentoVO.getCodConfirmacao());
				pagamento.setCodProcedimento(pagamentoVO.getCodProcedimento());
				pagamento.setEstadoPagamento(pagamentoVO.getEstadoPagamento());
				pagamento.setFormaDePagamento(pagamentoVO.getFormaDePagamento());
				pagamento.setValorPagamento(pagamentoVO.getValorPagamento());
				PagamentoVO updatePagamento =	pagamentoRepository.save(pagamento);
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.OK.value()).comMensagem("pagamento editado com sucesso").comObjeto(updatePagamento).construir();
			} else {
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.NO_CONTENT.value()).comMensagem("pagamento não encontrado").construir();
			}
		} catch (Exception e) {
			 retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem(e.getMessage()).construir();
		}
		return retorno;
	}
	
	public Retorno deletePagamento(Long codPagamento) {
		Retorno retorno = new Retorno();
		try {
			Optional<PagamentoVO> optPagamento = pagamentoRepository.findById(codPagamento);
			if(optPagamento.isPresent()) {
				pagamentoRepository.delete(optPagamento.get());
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.NO_CONTENT.value()).comMensagem("pagamento deletado com sucesso").construir();
			} else {
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.NO_CONTENT.value()).comMensagem("pagamento não encontrado").construir();
			}
		} catch (Exception e) {
			 retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem(e.getMessage()).construir();
		}
		return retorno;
	}
}
