package sample.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Transactional
public class Controller {

    @Autowired
    CustomerDao customerdao;

    @RequestMapping("/")
    public List<Customer> selectAll() {
    	return customerdao.selectAll();
    }

    @RequestMapping("/update")
    public List<Customer> updateAndSelectAll(
            @RequestParam(value = "id", defaultValue = "1") int id,
            @RequestParam("name") String name) {
    	Customer customer = new Customer();
    	customer.id=id;
    	customer.name=name;
        customerdao.update(customer);
        return customerdao.selectAll();
    }
    
    @RequestMapping("/insert")
    public List<Customer> insert(
    		@RequestParam("name") String name) {
    	Customer customer = new Customer();
    	customer.name=name;
        customerdao.insert(customer);
        return customerdao.selectAll();
    }
    
    @RequestMapping("/delete")
    public List<Customer> del(
    		@RequestParam("id") Integer id) {
        customerdao.delete(id);
        return customerdao.selectAll();
    }
}
