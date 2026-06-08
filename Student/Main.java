package Student;

class Student {
    private String studentId;
    private String name;
    private double cgpa;
    private int researchPapers;
    private int extracurricularScore;


    public Student(String studentId, String name, double cgpa,
                   int researchPapers, int extracurricularScore) {
        this.studentId = studentId;
        this.name = name;
        this.cgpa = cgpa;
        this.researchPapers = researchPapers;
        this.extracurricularScore = extracurricularScore;
    }


    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }

    public int getResearchPapers() {
        return researchPapers;
    }

    public int getExtracurricularScore() {
        return extracurricularScore;
    }


    public void displayInfo() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + cgpa);
        System.out.println("Research Papers: " + researchPapers);
        System.out.println("Extracurricular Score: " + extracurricularScore);
        System.out.println();
    }
}

class ScholarshipEvaluator {


    public double calculateMeritScore(Student s) {
        return (s.getCgpa() * 40)
                + (s.getResearchPapers() * 15)
                + (s.getExtracurricularScore() * 2);
    }

    public Student findBestCandidate(Student[] students) {
        Student best = students[0];

        for (int i = 1; i < students.length; i++) {
            double currentScore = calculateMeritScore(students[i]);
            double bestScore = calculateMeritScore(best);

            if (currentScore > bestScore) {
                best = students[i];
            } else if (currentScore == bestScore) {

                if (students[i].getCgpa() > best.getCgpa()) {
                    best = students[i];
                }

                else if (students[i].getCgpa() == best.getCgpa()) {
                    if (students[i].getResearchPapers() >
                            best.getResearchPapers()) {
                        best = students[i];
                    }
                }
            }
        }
        return best;
    }

    public Student createHonorsStudent(Student s) {
        double newCgpa = s.getCgpa() + 0.1;

        if (newCgpa > 4.0) {
            newCgpa = 4.0;
        }

        return new Student(
                "HON-" + s.getStudentId(),
                s.getName(),
                newCgpa,
                s.getResearchPapers() + 2,
                s.getExtracurricularScore()
        );
    }
}

public class Main {
    public static void main(String[] args) {

        Student[] students = {
                new Student("S101", "Rahim", 3.80, 3, 40),
                new Student("S102", "Karim", 3.90, 2, 35),
                new Student("S103", "Sadia", 3.95, 4, 30),
                new Student("S104", "Nadia", 3.70, 5, 45),
                new Student("S105", "Hasan", 3.85, 3, 50)
        };

        ScholarshipEvaluator evaluator = new ScholarshipEvaluator();

        Student bestStudent = evaluator.findBestCandidate(students);

        System.out.println("=== Selected Scholarship Candidate ===");
        bestStudent.displayInfo();

        Student honorsStudent = evaluator.createHonorsStudent(bestStudent);

        System.out.println("=== Honors Student ===");
        honorsStudent.displayInfo();
    }
}