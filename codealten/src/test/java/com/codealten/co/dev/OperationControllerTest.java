package com.codealten.co.dev;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.codealten.co.dev.controller.OperationController;
import com.codealten.co.dev.dto.ResponseOperation;
import com.codealten.co.dev.impl.ServiceOperation;

public class OperationControllerTest {

	private ServiceOperation serviceOperation;
	private OperationController operationController;

	@BeforeEach
	public void setup() {
		// Crear una instancia de ServiceOperation utilizando Mockito para simular su comportamiento
		serviceOperation = mock(ServiceOperation.class);
		operationController = new OperationController();
	}

	@Test
	public void testGetMaximunGetWithZeroInput() {
		// Configurar el comportamiento simulado de ServiceOperation
		ResponseOperation expectedResponse = new ResponseOperation();
		expectedResponse.getRespuesta();
		when(serviceOperation.operation(0, 0, 0)).thenReturn(expectedResponse);

		// Llamar al método de controlador que se va a probar
		ResponseEntity<String> responseEntity = operationController.getMaximunGet(0, 0, 0);

		// Verificar que el resultado de la llamada es el esperado
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals("{\"result\":0}", responseEntity.getBody());
	}
}
