package SpringBootProject1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.el.stream.Optional;

import antlr.collections.List;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeRepository er;
	@PostMapping("/Employee")
	public Employee addEmployee(@RequestBody Employee e) {
		er.save(e);
		return e;
		
	}
	
	@PutMapping("/Employee")
	public Employee saveOrUpdateEmployee(@RequestBody Employee e) {
		er.save(e);
		return e;
	}
	
	public String deleteEmployee(@PathVariable int id) {
		Employee a=er.getOne(id);
		er.delete(a);
		return "Record is deleted";
	}
	
	@GetMapping("/Employee")
	public Iterable<Employee> getEmployee() {
		
		return er.findAll();
		
	}
	
	@GetMapping ("/Employee/{id}")
	public String getEmployee(@PathVariable("id") int id){
		
		return er.findById(id).toString();
	}
}
