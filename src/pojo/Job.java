package pojo;

public class Job{
    private int jobno;
    private String jname;
    private String jtype;
    public Job(){
        jobno=-1;
    }
    public int getJobno() {
        return jobno;
    }

    public void setJobno(int jobno) {
        this.jobno = jobno;
    }

    public String getJname() {
        return jname;
    }

    public void setJname(String jname) {
        this.jname = jname;
    }

    public String getJtype() {
        return jtype;
    }

    public void setJtype(String jtype) {
        this.jtype = jtype;
    }
}
