package week02;

public class MyProjects {
    private String projectName;
    private String personInCharge;

    public MyProjects(String projectName, String personInCharge) {
        this.projectName = projectName;
        this.personInCharge = personInCharge;
    }

    public MyProjects(Object o) {
    }

    public String projectString() {
        return "Project: " + projectName + "Worker: " + personInCharge;
    }
}
