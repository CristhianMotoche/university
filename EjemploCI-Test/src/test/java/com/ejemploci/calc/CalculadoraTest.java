/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.ejemploci.calc;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.rules.ExpectedException;

/**
 *
 * @author camm
 */
public class CalculadoraTest {

	private Calculadora calculadora;
	public ExpectedException expectedEx = ExpectedException.none();


	@Before
	public void setUp() {
		calculadora = new Calculadora();
	}

	@Test
	public void testSuma() {
		System.out.println("Ejecutar Caculador.suma()");
		int result = calculadora.suma(5, 3);
		assertEquals(8, result);
	}

	@Test
	public void testResta() {
		System.out.println("Ejecutar Caculador.resta()");
		int result = calculadora.resta(5, 3);
		assertEquals(2, result);
	}

	@Test
	public void testDivision() {
		System.out.println("Ejecutar Caculador.division()");
		int result = calculadora.division(5, 3);
		assertEquals(1, result);
	}

	@Test
	public void testDivisionFail() {
		System.out.println("Ejecutar Caculador.division() -> Falla con x/0");
		int x = calculadora.product(5, 0);
		expectedEx.expect(RuntimeException.class);
	}

	@Test
	public void testProduct() {
		System.out.println("Ejecutar Caculador.product()");
		int result = calculadora.product(5, 3);
		assertEquals(15, result);
	}
}
