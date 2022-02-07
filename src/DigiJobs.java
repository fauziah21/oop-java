public class DigiJobs {
    //deklarasi variable
    private String jobId;
    private JobPosition jobPosition;
    private String jobAddress;

    public DigiJobs(){

    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public JobPosition getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(JobPosition jobPosition) {
        this.jobPosition = jobPosition;
    }

    public String getJobAddress() {
        return jobAddress;
    }

    public void setJobAddress(String jobAddress) {
        this.jobAddress = jobAddress;
    }

    //function yang digunakan untuk mencetak jobs yang ada
    public void print(){
        String varJobId =this.jobId;
        System.out.println("Job Id : " + varJobId + ", job address : " + this.jobAddress + ", job position Id : " + this.jobPosition.getJobPositionId() + ", job positon name : " + this.jobPosition.getJobPositionName());
    }
}
