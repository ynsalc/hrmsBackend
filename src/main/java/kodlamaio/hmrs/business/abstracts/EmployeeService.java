package kodlamaio.hmrs.business.abstracts;

import java.util.List;

import kodlamaio.hmrs.core.utilities.result.DataResult;
import kodlamaio.hmrs.core.utilities.result.Result;
import kodlamaio.hmrs.entities.concretes.Employee;

public interface EmployeeService 
{
	DataResult<List<Employee>> GetAll();
	Result Add(Employee employee);
}
