package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Retorno;
import com.example.demo.dto.RetornoBuilder;
import com.example.demo.model.CargoVO;
import com.example.demo.persistence.CargoRepository;

@Service
public class CargoService {
	
	@Autowired
	private CargoRepository cargoRepository;
	
	public Retorno findAll() {
		Retorno retorno = new Retorno();
		try {
			Iterable<CargoVO> listaCargo = cargoRepository.findAll();
			retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.OK.value()).comMensagem("cargos encontrados com sucesso").comObjeto(listaCargo).construir();
		} catch (Exception e) {
			 retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem(e.getMessage()).construir();
		}
		return retorno;
	}
	
	public Retorno findByCodCargo(Long codCargo) {
		Retorno retorno = new Retorno();
		try {
			Optional<CargoVO> optCargo = cargoRepository.findById(codCargo);
			
			if(optCargo.isPresent()) {
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.OK.value()).comMensagem("cargo encontrado com sucesso").comObjeto(optCargo.get()).construir();
			} else {
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.NO_CONTENT.value()).comMensagem("cargo não encontrado").construir();
			}
			
		} catch (Exception e) {
			 retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem(e.getMessage()).construir();
		}
		return retorno;
	}
	
	public Retorno gravarCargo(CargoVO cargoVO) {
		Retorno retorno = new Retorno();
		try {
			CargoVO cargo = cargoRepository.save(cargoVO);
			retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.OK.value()).comMensagem("cargo gravado com sucesso").comObjeto(cargo).construir();
		} catch (Exception e) {
			 retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem(e.getMessage()).construir();
		}
		return retorno;
	}
	
	public Retorno editarCargo(CargoVO cargoVO) {
		Retorno retorno = new Retorno();
		try {
			Optional<CargoVO> optCargo = cargoRepository.findById(cargoVO.getCodCargo());
			if(optCargo.isPresent()) {
				CargoVO cargo = new CargoVO();
				cargo.setCodCargo(cargoVO.getCodCargo());
				cargo.setCargoDescricao(cargoVO.getCargoDescricao());
				CargoVO updateCargo =	cargoRepository.save(cargo);
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.OK.value()).comMensagem("cargo editado com sucesso").comObjeto(updateCargo).construir();
			} else {
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.NO_CONTENT.value()).comMensagem("cargo não encontrado").construir();
			}
		} catch (Exception e) {
			 retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem(e.getMessage()).construir();
		}
		return retorno;
	}
	
	public Retorno deleteCargo(Long codCargo) {
		Retorno retorno = new Retorno();
		try {
			Optional<CargoVO> optCargo = cargoRepository.findById(codCargo);
			if(optCargo.isPresent()) {
				cargoRepository.delete(optCargo.get());
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.NO_CONTENT.value()).comMensagem("cargo deletado com sucesso").construir();
			} else {
				retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.NO_CONTENT.value()).comMensagem("cargo não encontrado").construir();
			}
		} catch (Exception e) {
			 retorno = new RetornoBuilder().comCodigoMensagem(HttpStatus.INTERNAL_SERVER_ERROR.value()).comMensagem(e.getMessage()).construir();
		}
		return retorno;
	}
}
