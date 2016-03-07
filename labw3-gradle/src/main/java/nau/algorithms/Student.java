package nau.algorithms;

import com.github.javafaker.Faker;
import java.util.Random;

/**
 *
 * Created by maxi on 15.02.16.
 */
public class Student {
    private String surname, citizenShip;
    private Integer studentsTicket;
    private double averageMark;
    private int course;

    public Student(String surname, int course, int studentsTicket, double averageMark, String citizenShip)
    {
        this.surname = surname;
        this.course = course;
        this.studentsTicket = studentsTicket;
        this.averageMark = averageMark;
        this.citizenShip = citizenShip;
    }

//    public Student(int studentsTicket)
//    {
//        this.studentsTicket = studentsTicket;
//
//        Faker faker = new Faker();
//        Random rng = new Random();
//
//        this.surname = faker.name().lastName();
//        this.course = rng.nextInt(5) + 1;
//        this.averageMark = 1 + rng.nextInt(5);
//        this.citizenShip = faker.country().name();
//    }

    public Student()
    {
        Faker faker = new Faker();
        Random rng = new Random();

        this.surname = faker.name().lastName();
        this.course = rng.nextInt(5) + 1;
        this.studentsTicket = rng.nextInt(999)+1;
        this.averageMark = 1 + rng.nextInt(5);
        this.citizenShip = faker.country().name();
    }

    public Integer getStudentsTicket()
    {
        return studentsTicket;
    }

    public int getCourse()
    {
        return course;
    }

    public String getCitizenShip()
    {
        return  citizenShip;
    }

    public double getAverageMark()
    {
        return averageMark;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Student: ").append(surname).append("; course #").append(course);
        builder.append("; student's ticket: ").append(studentsTicket).append("; ").append("avg. mark: ");
        builder.append(Math.round(averageMark * 10.0) / 10.0).append("; citizenShip: ").append(citizenShip);

        return builder.toString();
    }
}
