package com.codealten.co.dev.impl;

import org.springframework.stereotype.Service;

import com.codealten.co.dev.dto.ResponseOperation;
import com.codealten.co.dev.service.IServiceOperation;

@Service
public class ServiceOperation implements IServiceOperation{
	
	@Override
	public ResponseOperation operation(int x, int y, int n) {
		
		ResponseOperation responseOperation = new ResponseOperation();
		try {
			int maxK = (n -y) / x; /** Maximo valor de k */
			int calculo = maxK * x + y; /** Calculo del valor de k que cumple con la coondicion */
			
			responseOperation.setCode(0);
			responseOperation.setMsg("Operacion Exitosa");
			responseOperation.setRespuesta(String.valueOf(calculo));
		} catch (Exception e) {
			
			responseOperation.setCode(1);
			responseOperation.setMsg("Operacion Fallida");
			responseOperation.setRespuesta(e.getMessage());
			return responseOperation;
		}
		
		return responseOperation;
	}
}