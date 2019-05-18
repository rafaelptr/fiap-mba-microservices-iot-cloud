package br.com.fiap.carservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarResourceTest {

    @Autowired
    private CarResource carResource;

    @Test
    public void shouldFindCarByColor(){
        //Stubs - dados ficticio
        String color = "black";
        String model = "City";

        Car car = new Car();
        car.setModel(model);
        car.setColor(color);
        carResource.save(car);

        List<Car> cars = carResource.findCarByColor(car.getColor());

        assertEquals(cars.get(0).getColor(),color);
        assertEquals(cars.get(0).getModel(),model);
    }
 }
