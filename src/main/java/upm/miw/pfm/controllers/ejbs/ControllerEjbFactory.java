package upm.miw.pfm.controllers.ejbs;

import upm.miw.pfm.controllers.AddEmployeeController;
import upm.miw.pfm.controllers.ControllerFactory;
import upm.miw.pfm.controllers.ListContractsController;
import upm.miw.pfm.controllers.ListProjectController;
import upm.miw.pfm.controllers.NewContractController;
import upm.miw.pfm.controllers.ProjectController;
import upm.miw.pfm.controllers.SetScheduleController;

public class ControllerEjbFactory extends ControllerFactory {

    private ProjectController projectController;

    @Override
    public ProjectController getProjectController() {
        if (projectController == null)
            projectController = new ProjectControllerEjb();
        return projectController;
    }

    @Override
    public ListProjectController getListProjectController() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public NewContractController getNewContractController() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ListContractsController getListContractsController() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public AddEmployeeController getAddEmployeeController() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public SetScheduleController getSetScheduleController() {
        // TODO Auto-generated method stub
        return null;
    }

}