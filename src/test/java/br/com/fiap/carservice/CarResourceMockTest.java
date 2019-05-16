package br.com.fiap.carservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CarResourceMockTest {

    /**
     *  Servico mocado de carro
     */
    @Mock
    private ICarResource carResource;

    /**
     * Tests with car was found by color
     *
     * Testa se o servico encontra um carro pela cor
     */
    @Test
    public void shouldFindCarByColor(){
        //Stubs - dados ficticio
        String color = "black";
        String model = "City";

        Car car = new Car();
        car.setModel(model);
        car.setColor(color);

        carResource.findCarByColor(car);
    }
 }
