package upm.miw.pfm.models.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import upm.miw.pfm.utils.WorkDay;

@Entity
@Table(name="project_schedule")
public class ProjectSchedule implements Serializable {
	
	private static final long serialVersionUID = 1L;

    @Id
    @Column
    @GeneratedValue(generator = "gen")
    @GenericGenerator(name = "gen", strategy = "foreign", parameters = @Parameter(name = "property", value = "project"))
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    private Project project;

    @Column(name = "work_days", nullable = false)
    private Integer workDays;

    @Column(name = "monday_hours", nullable = false)
    private Double mondayHours;

    @Column(name = "tuesday_hours", nullable = false)
    private Double tuesdayHours;

    @Column(name = "wednesday_hours", nullable = false)
    private Double wednesdayHours;

    @Column(name = "thursday_hours", nullable = false)
    private Double thursdayHours;

    @Column(name = "friday_hours", nullable = false)
    private Double fridayHours;

    @Column(name = "saturday_hours", nullable = false)
    private Double saturdayHours;

    @Column(name = "sunday_hours", nullable = false)
    private Double sundayHours;

    public ProjectSchedule() {
    }

    public ProjectSchedule(int workdays, Double monday, Double tuesday, Double wednesday,
            Double thursday, Double friday, Double saturday, Double sunday) {
        this.workDays = workdays;
        this.mondayHours = monday;
        this.tuesdayHours = tuesday;
        this.wednesdayHours = wednesday;
        this.thursdayHours = thursday;
        this.fridayHours = friday;
        this.saturdayHours = saturday;
        this.sundayHours = sunday;
    }

    public ProjectSchedule(Project project, int workdays, Double monday, Double tuesday,
            Double wednesday, Double thursday, Double friday, Double saturday, Double sunday) {
        this(workdays, monday, tuesday, wednesday, thursday, friday, saturday, sunday);
        this.project = project;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Integer getWorkDays() {
        return workDays;
    }

    public void setWorkDays(Integer workDays) {
        this.workDays = workDays;
    }

    public Double getMondayHours() {
        return mondayHours;
    }

    public void setMondayHours(Double mondayHours) {
        this.mondayHours = mondayHours;
    }

    public Double getTuesdayHours() {
        return tuesdayHours;
    }

    public void setTuesdayHours(Double tuesdayHours) {
        this.tuesdayHours = tuesdayHours;
    }

    public Double getWednesdayHours() {
        return wednesdayHours;
    }

    public void setWednesdayHours(Double wednesdayHours) {
        this.wednesdayHours = wednesdayHours;
    }

    public Double getThursdayHours() {
        return thursdayHours;
    }

    public void setThursdayHours(Double thursdayHours) {
        this.thursdayHours = thursdayHours;
    }

    public Double getFridayHours() {
        return fridayHours;
    }

    public void setFridayHours(Double fridayHours) {
        this.fridayHours = fridayHours;
    }

    public Double getSaturdayHours() {
        return saturdayHours;
    }

    public void setSaturdayHours(Double saturdayHours) {
        this.saturdayHours = saturdayHours;
    }

    public Double getSundayHours() {
        return sundayHours;
    }

    public void setSundayHours(Double sundayHours) {
        this.sundayHours = sundayHours;
    }

    @Transient
    public List<WorkDay> getWorkDaysArray() {
        List<WorkDay> days = new ArrayList<WorkDay>();
        days.add(new WorkDay(getSundayHours()));
        days.add(new WorkDay(getMondayHours()));
        days.add(new WorkDay(getTuesdayHours()));
        days.add(new WorkDay(getWednesdayHours()));
        days.add(new WorkDay(getThursdayHours()));
        days.add(new WorkDay(getFridayHours()));
        days.add(new WorkDay(getSaturdayHours()));
        return days;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((workDays == null) ? 0 : workDays.hashCode());
        result = prime * result + ((mondayHours == null) ? 0 : mondayHours.hashCode());
        result = prime * result + ((tuesdayHours == null) ? 0 : tuesdayHours.hashCode());
        result = prime * result + ((wednesdayHours == null) ? 0 : wednesdayHours.hashCode());
        result = prime * result + ((thursdayHours == null) ? 0 : thursdayHours.hashCode());
        result = prime * result + ((fridayHours == null) ? 0 : fridayHours.hashCode());
        result = prime * result + ((saturdayHours == null) ? 0 : saturdayHours.hashCode());
        result = prime * result + ((sundayHours == null) ? 0 : sundayHours.hashCode());
        return result;
    }

	@Override
	public boolean equals(Object obj) {
		ProjectSchedule project = (ProjectSchedule) obj;
        return this.project.equals(project.getProject()) && this.workDays == project.getWorkDays()
                && this.mondayHours.doubleValue() == project.getMondayHours().doubleValue()
                && this.tuesdayHours.doubleValue() == project.getTuesdayHours().doubleValue()
                && this.wednesdayHours.doubleValue() == project.getWednesdayHours().doubleValue()
                && this.thursdayHours.doubleValue() == project.getThursdayHours().doubleValue()
                && this.fridayHours.doubleValue() == project.getFridayHours().doubleValue()
                && this.saturdayHours.doubleValue() == project.getSaturdayHours().doubleValue()
                && this.sundayHours.doubleValue() == project.getSundayHours().doubleValue();
    }

    @Override
    public String toString() {
        return "ProjectSchedule [id=" + id + ", project=" + project + ", workDays=" + workDays
                + ", mondayHours=" + mondayHours + ", tuesdayHours=" + tuesdayHours
                + ", wednesdayHours=" + wednesdayHours + ", thursdayHours=" + thursdayHours
                + ", fridayHours=" + fridayHours + ", saturdayHours=" + saturdayHours
                + ", sundayHours=" + sundayHours + "]";
    }
}
