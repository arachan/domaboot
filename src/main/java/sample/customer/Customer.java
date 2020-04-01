package sample.customer;

import org.seasar.doma.Entity;
import org.seasar.doma.Id;

@Entity
public class Customer {
	@Id
	public Integer id;
	public String name;
	
    @Override
    public String toString() {
        return "Customer [id=" + id + ", customername=" + name + "]";
    }
}
