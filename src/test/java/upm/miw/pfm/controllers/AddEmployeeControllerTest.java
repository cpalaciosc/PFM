package upm.miw.pfm.controllers;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import upm.miw.pfm.controllers.ejbs.AddEmployeeControllerEjb;
import upm.miw.pfm.mocks.MockEmployeeDao;
import upm.miw.pfm.models.entities.Contract;
import upm.miw.pfm.models.entities.Employee;
import upm.miw.pfm.utils.RoleType;

public class AddEmployeeControllerTest {
	
	private AddEmployeeController addEmployeeController;
	
	private Employee employee;
	
	private Contract contract;
	
	private List<RoleType> roles;
	
	@Before
	public void before(){
		addEmployeeController = new AddEmployeeControllerEjb();
		contract = new Contract("Fijo", 32.5);
		roles = new ArrayList<RoleType>();
		roles.add(RoleType.PROJECT_MANAGEMENT);
		roles.add(RoleType.REQUIREMENTS);
		roles.add(RoleType.ANALYSIS_DESIGN);
		employee = new Employee("Anibal","Lecter","A",40500.00,contract,roles);
	}
	
	@Test
	public void addEmployeeTest(){
		new MockEmployeeDao(new Employee());
		addEmployeeController.addEmployee(employee);
		Employee employee = addEmployeeController.getEmployee(1);
		assertEquals(new Employee(1,"Anibal","Lecter","A",40500.00,contract,roles), employee);
	}
}

