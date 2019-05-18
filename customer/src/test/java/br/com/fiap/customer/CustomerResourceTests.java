package br.com.fiap.customer;

import br.com.fiap.customer.entity.Customer;
import br.com.fiap.customer.json.request.CustomerRequest;
import br.com.fiap.customer.repository.CustomerRepository;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class CustomerResourceTests {

	//https://mvnrepository.com/artifact/io.rest-assured/rest-assured
	//testCompile group: 'io.rest-assured', name: 'rest-assured', version: '4.0.0'

	@Autowired
	//Quinto 2
	private CustomerRepository customerRepository;

	//Quinto 4
	@LocalServerPort
	private Integer port;


	//Quinto - fazemos o setup de base de clientes
	@Before
	public void setup(){
		stubCreateCustomer();

		//quinto 3
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = this.port;
		RestAssured.requestSpecification = new RequestSpecBuilder()
				.addHeader("Content-Type", "application/json")
				.build();
	}

	private void stubCreateCustomer() {
		Customer customer = new Customer();
		customer.setName("Rafael");
		customer.setLastName("Petronilio");
		customer.setGender("male");
		customer.setAge(25);

		customerRepository.save(customer);
	}

	@Test
	//Primeiro - Criamos um teste para o get by id
	public void shouldFindCustomerById(){
		RestAssured.get("/customer/1")
				.then()
				.assertThat()
				.statusCode(200)
				.body("name", Matchers.is("Rafael"))
				.body("lastName",Matchers.is("Petronilio"))
				.body("gender",Matchers.is("male"))
				.body("age",Matchers.is(25));
	}

	@Test
	//Segundo - criamos o possibilidade de não conseguir buscar pelo id
	public void cannotFindCustomerById(){
		RestAssured.get("/customer/300")
				.then()
				.assertThat()
				.statusCode(404)
				.body("messageError", Matchers.is("Customer not found"));
	}

	@Test
	//Terceiro - fazemos testes para criar um cliente
	public void shouldCreateCustomer(){
		CustomerRequest customerRequest = new CustomerRequest();

		customerRequest.setName("Rafael");
		customerRequest.setLastName("Petronilio");
		customerRequest.setGender("male");
		customerRequest.setAge(25);

		RestAssured.given()
				.body(customerRequest)
				.post("/customers")
				.then()
				.assertThat()
				.statusCode(201)
				.body("customerId", Matchers.any(Integer.class));
	}

	@Test
	//Quarto - para cada validação planejamos que falhe
	public void cannotCreateCustomerWhenGenderIsInvalid(){
		CustomerRequest customerRequest = new CustomerRequest();

		customerRequest.setName("Rafael");
		customerRequest.setLastName("Petronilio");
		customerRequest.setGender("animal");
		customerRequest.setAge(25);

		RestAssured.given()
				.body(customerRequest)
				.post("/customers")
				.then()
				.assertThat()
				.statusCode(422)
				.body("messageError", Matchers.is("Gender is invalid"));
	}

	@Test
	public void shouldListCustomers(){
		RestAssured.get("/customers")
				.then()
				.assertThat()
				.statusCode(200);
				//.body("customers",Matchers.iterableWithSize());
	}

}
