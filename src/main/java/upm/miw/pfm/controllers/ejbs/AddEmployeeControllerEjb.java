package upm.miw.pfm.controllers.ejbs;

import upm.miw.pfm.controllers.AddEmployeeController;
import upm.miw.pfm.models.daos.DaoFactory;
import upm.miw.pfm.models.entities.Employee;

public class AddEmployeeControllerEjb implements AddEmployeeController{

	@Override
	public void addEmployee(Employee employee) {
		DaoFactory.getFactory().getEmployeeDao().create(employee);
	}

	@Override
	public Employee getEmployee(Integer id) {
		return DaoFactory.getFactory().getEmployeeDao().read(id);
	}

}