package sample.city;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;

import sample.customer.Customer;

//@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ControllerTest {
    @Value("${local.server.port}")
    int port;
    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void test() throws Exception {
        {
            // Select
            List<Customer> customers = restTemplate.exchange("http://localhost:" + port + "/customer", HttpMethod.GET, HttpEntity.EMPTY, new ParameterizedTypeReference<List<Customer>>() {
            }).getBody();
            assertThat(customers).hasSize(1);
            assertThat(customers).extracting("name").containsExactly("お得意先さん");
        }

        {
            // Update
            List<Customer> customers = restTemplate.exchange("http://localhost:" + port + "/customer/update?name=Kyoto", HttpMethod.GET, HttpEntity.EMPTY, new ParameterizedTypeReference<List<Customer>>() {
            }).getBody();
            assertThat(customers).hasSize(1);
            assertThat(customers).extracting("name").containsExactly("Kyoto");
        }
//        {
//        	// Insert
//        	List<Customer> customers = restTemplate.exchange("http://localhost:" + port + "/customer/insert?name=Kyoto", HttpMethod.GET, HttpEntity.EMPTY, new ParameterizedTypeReference<List<Customer>>() {
//            }).getBody();
//        	
//        }
    }
}