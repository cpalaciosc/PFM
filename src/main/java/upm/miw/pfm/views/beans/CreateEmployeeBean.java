package upm.miw.pfm.views.beans;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import org.apache.logging.log4j.LogManager;

import upm.miw.pfm.controllers.ContractController;
import upm.miw.pfm.controllers.EmployeeController;
import upm.miw.pfm.models.entities.Contract;
import upm.miw.pfm.models.entities.Employee;
import upm.miw.pfm.utils.RoleType;
import upm.miw.pfm.utils.Utils;

@ManagedBean
@RequestScoped
public class CreateEmployeeBean {

    private Employee employee;

    private Set<String> checkedRoles;

    private List<SelectItem> items;

    private int selectedContractId;

    private final static Class<CreateEmployeeBean> clazz = CreateEmployeeBean.class;

    @EJB
    private EmployeeController addEmployeeController;

    @EJB
    private ContractController contractController;

    public CreateEmployeeBean() {
        employee = new Employee();
    }

    public int getSelectedContractId() {
        return selectedContractId;
    }

    public void setSelectedContractId(int selectedContractId) {
        this.selectedContractId = selectedContractId;
    }

    public List<SelectItem> getItems() {
        return items;
    }

    public void setItems(List<SelectItem> items) {
        this.items = items;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public RoleType[] getRoles() {
        return RoleType.values();
    }

    public List<Contract> getContracts() {
        return contractController.contractList();
    }

    public Set<String> getCheckedRoles() {
        return checkedRoles;
    }

    public void setCheckedRoles(Set<String> checkedValues) {
        this.checkedRoles = checkedValues;
    }

    public String process() {
        Set<RoleType> roles = new HashSet<RoleType>();
        for (String role : checkedRoles) {
            roles.add(RoleType.valueOf(role));
        }
        employee.setRoles(roles);

        employee.setContract(contractController.getContract(selectedContractId));

        addEmployeeController.addEmployee(employee);
        LogManager.getLogger(clazz).debug("Creación de empleado " + employee);
        Utils.addMessage(FacesMessage.SEVERITY_INFO, "OK!",
                "Se ha creado el empleado satisfactoriamente");
        return "index";
    }

    public void setContractItems() {
        items = new ArrayList<SelectItem>();
        for (Contract contract : this.getContracts()) {
            SelectItem item = new SelectItem(contract.getId(), contract.getContractType());
            items.add(item);
        }
    }

    @PostConstruct
    public void init() {
        employee = new Employee();
        this.setContractItems();
    }

}
