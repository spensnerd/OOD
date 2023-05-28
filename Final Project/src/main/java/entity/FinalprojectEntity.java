package entity;

import javax.persistence.*;

@Entity
@Table(name = "projects", schema = "myprojects")
public class FinalprojectEntity {
    private int idFinalProject;
    private String title;
    private Integer budget;
    private Integer time;
    private Object importance;

    @Id
    @Column(name = "id")
    public int getIdFinalProject() {
        return idFinalProject;
    }

    public void setIdFinalProject(int idFinalProject) {
        this.idFinalProject = idFinalProject;
    }

    @Basic
    @Column(name = "Title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "Budget")
    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    @Basic
    @Column(name = "Time")
    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    @Basic
    @Column(name = "Importance")
    public Object getImportance() {
        return importance;
    }

    public void setImportance(Object importance) {
        this.importance = importance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FinalprojectEntity that = (FinalprojectEntity) o;

        if (idFinalProject != that.idFinalProject) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (budget != null ? !budget.equals(that.budget) : that.budget != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (importance != null ? !importance.equals(that.importance) : that.importance != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idFinalProject;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (budget != null ? budget.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (importance != null ? importance.hashCode() : 0);
        return result;
    }
}
