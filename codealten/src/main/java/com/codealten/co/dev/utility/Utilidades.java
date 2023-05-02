package com.codealten.co.dev.utility;

import com.codealten.co.dev.dto.ResponseOperation;

public class Utilidades{
	public int[] castToInt(String[] position) {
		
		int[] numberCast = new int[3];
		numberCast[0] = Integer.parseInt(position[0]);
		numberCast[1] = Integer.parseInt(position[1]);
		numberCast[2] = Integer.parseInt(position[2]);
		
		return numberCast;
	}
	
	public ResponseOperation validaLongitudRequest(String[] numbers) {
		ResponseOperation responseOperation = new ResponseOperation();
		
		if(numbers.length > 3) {
			responseOperation.setCode(1);
			responseOperation.setMsg("La cantidad de numeros enviados, supera los esperados");
			responseOperation.setRespuesta("");
		}
		return responseOperation;
	}
}
