package sample.customer;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;

@Dao
@ConfigAutowireable
public interface CustomerDao {
	@Select
	List<Customer>selectAll();
	
	@Insert(sqlFile = true)
	int insert(Customer customer);
	
	@Update(sqlFile=true)
	int update(Customer customer);
	
	@Delete(sqlFile=true)
	int delete(Integer id);
	
}