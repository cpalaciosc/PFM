package upm.miw.pfm.models.entities;

import java.util.Date;


public class Project {
	
	private Date start;
	private Date end;
	private Double cost;	
	private String name;
	private ProjectSchedule projectSchedule;
	
	public Project(){
	}
	
	private int id;
	
	public Project(String name, Date start, Date end, Double cost){
		this.start = start;
		this.end = end;
		this.cost = cost;
		this.name = name;
	}
	
	public Project(int id, String name, Date start, Date end, Double cost){
		this.start = start;
		this.end = end;
		this.cost = cost;
		this.name = name;
		this.id = id;
	}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cost == null) ? 0 : cost.hashCode());
		result = prime * result + ((end == null) ? 0 : end.hashCode());
		result = prime * result + ((start == null) ? 0 : start.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		assert obj != null;
        Project other = (Project) obj;
        return id==other.id && start.equals(other.start)
                && end.equals(other.end) && cost.equals(other.cost) && name.equals(other.name);
	}
	
	public void setId(int id){
		this.id = id;;
	}

	public Date getStart() {
		// TODO Auto-generated method stub
		return null;
	}

	public Date getEnd() {
		// TODO Auto-generated method stub
		return null;
	}

	public Double getCost() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

    public ProjectSchedule getProjectSchedule() {
        return projectSchedule;
    }

    public void setProjectSchedule(ProjectSchedule schedule) {
        this.projectSchedule = schedule;
    }

	@Override
	public String toString() {
		return "Project [start=" + start + ", end=" + end + ", cost=" + cost
				+ ", name=" + name + ", id=" + id + "]";
	}
}
