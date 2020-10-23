package SpringBootProject1;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>{

	Employee getOne(int id);

}
