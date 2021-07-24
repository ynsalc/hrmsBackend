package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.EmployeeService;
import kodlamaio.hmrs.core.utilities.result.DataResult;
import kodlamaio.hmrs.core.utilities.result.Result;
import kodlamaio.hmrs.core.utilities.result.SuccessDataResult;
import kodlamaio.hmrs.core.utilities.result.SuccessResult;
import kodlamaio.hmrs.dataAccess.abstracts.EmployeeDao;
import kodlamaio.hmrs.entities.concretes.Employee;

@Service
public class EmployeeManager implements EmployeeService
{
	private EmployeeDao employeeDao;
	private ModelMapper modelMapper;

	@Autowired
	public EmployeeManager(EmployeeDao employeeDao,ModelMapper modelMapper) {
		super();
		this.employeeDao = employeeDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public DataResult<List<Employee>> GetAll() 
	{
		return new SuccessDataResult<List<Employee>>(employeeDao.findAll(),"Çalışanlar listelendi.");
	}

	@Override
	public Result Add(Employee employee) 
	{
		Employee emp = modelMapper.map(employee, Employee.class);
		employeeDao.save(emp);
		return new SuccessResult("Çalışan Eklendi.");
	}

}
