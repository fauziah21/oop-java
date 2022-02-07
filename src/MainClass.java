import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainClass {
    public MainClass(){

    }

    public static void main(String[] args){
        ArrayList<DigiJobs> digiJobs = new ArrayList();
        Scanner sc = new Scanner(System.in);

        //selama nilai bernilai true akan selalu looping program
        while (true){
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("==============DIGIJOBS==============");
            System.out.println("Please choose following command : ");
            System.out.println("1. Add new job");
            System.out.println("2. Print all jobs");
            System.out.println("3. Delete a job");
            System.out.println("4. Exit");
            String input = sc.nextLine();
            //jika user memasukkan inputan "4" maka akan langsung keluar dari program
            if (input.equalsIgnoreCase("4")){
                return;
            }

            String jobId;
            //jika user menginput "1" maka akan keluar informasi format untuk menambahkan data baru
            if(input.equalsIgnoreCase("1")){
                System.out.println("Please input new job using following format : [job_id],[job_address],[job_position_id],[job_position_name]");
                //untuk mengambil input dari user
                jobId = sc.nextLine();
                //akan split string menjadi array dengan "," sebagai separator
                String[] split = jobId.split(",");
                //jika panjang array = 4 maka akan masuk ke blok if ini
                if (split.length == 4 ){
                    DigiJobs newJob = new DigiJobs();
                    newJob.setJobId(split[0]);
                    newJob.setJobAddress(split[1]);
                    JobPosition jobPosition = new JobPosition();
                    jobPosition.setJobPositionId(Integer.parseInt(split[2]));
                    jobPosition.setJobPositionName(split[3]);
                    newJob.setJobPosition(jobPosition);
                    //menggunakan method add untuk menambahkan elemen ke collection
                    digiJobs.add(newJob);
                    System.out.println("Success add new job");
                    //jika panjang array != 4 maka akan memberikan info salah format
                } else{
                    System.out.println("Wrong format!");
                }
                //jika user menginput "2" maka akan masuk ke blok ini
            } else if (input.equalsIgnoreCase("2")){
                System.out.println("Your current jobs : ");
                //menggunakan foreach untuk menampilkan masing-masing data
                digiJobs.forEach((job) -> {
                    //memanggil function print
                    job.print();
                });
                //jika user menginput "3" maka akan masuk ke blok ini
            }else if (input.equalsIgnoreCase("3")){
                System.out.println("Please input job id to delete : ");
                jobId = sc.nextLine();
                //mengecek apakah id yang di input ada di dalam collection
                List<DigiJobs> collect =(List)digiJobs.stream().filter((job) -> {
                    return job.getJobId().equalsIgnoreCase(jobId);
                }).collect(Collectors.toList());
                //jika tidak ada id maka print job id not found
                if (collect.isEmpty()){
                    System.out.println("Job with job id " + jobId + " not found");
                    //jika ada maka lakukan  function removeAll
                } else {
                    digiJobs.removeAll(collect);
                    System.out.println("Success delete job with job id " +jobId);
                }
            }
        }
    }
}
