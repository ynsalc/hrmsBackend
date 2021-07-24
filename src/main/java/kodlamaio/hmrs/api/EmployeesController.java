package kodlamaio.hmrs.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kodlamaio.hmrs.business.abstracts.*;
import kodlamaio.hmrs.core.utilities.result.DataResult;
import kodlamaio.hmrs.core.utilities.result.Result;
import kodlamaio.hmrs.entities.concretes.*;
import java.util.*;

@RestController
@RequestMapping("api/employees")
@CrossOrigin
public class EmployeesController 
{
	private EmployeeService employeeService;

	@Autowired
	public EmployeesController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Employee>> GetAll()
	{
		return employeeService.GetAll();
	}
	
	@PostMapping("/add")
	public Result Add(@RequestBody Employee employee) 
	{
		return employeeService.Add(employee);
	}

}