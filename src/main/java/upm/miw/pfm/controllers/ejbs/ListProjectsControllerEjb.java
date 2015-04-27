package upm.miw.pfm.controllers.ejbs;

import java.util.List;

import javax.ejb.Stateless;

import upm.miw.pfm.controllers.ListProjectsController;
import upm.miw.pfm.models.daos.DaoFactory;
import upm.miw.pfm.models.entities.Project;

@Stateless
public class ListProjectsControllerEjb implements ListProjectsController {
    
    @Override
    public List<Project> listProjects(){
        return DaoFactory.getFactory().getProjectDao().findAll();
    }

}