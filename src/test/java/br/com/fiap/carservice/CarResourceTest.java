package br.com.fiap.carservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;

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

        List<Car> cars = Arrays.asList(car);

        //TDD
        //   When *
        //   Then * mocado
        //   Assert
        //quando chamar o metodo findCarByColor então retorne a lista de carros
        Mockito.when(carResource.findCarByColor(color))
               .thenReturn(cars);

        //executar
        List<Car> carsResponse = carResource.findCarByColor(color);

        //TDD
        //   When
        //   Then
        //   Assert *
        assertEquals(carsResponse.get(0).getColor(),color);
        assertEquals(carsResponse.get(0).getModel(),model);
    }
 }
