import java.util.Scanner;

class InvalidEmailException extends Exception {
    public InvalidEmailException(String message) {
        super(message);
    }
}

class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

class InvalidStudentIdException extends Exception {
    public InvalidStudentIdException(String message) {
        super(message);
    }
}


public class StudentRegistrationSystem {

    static void validateStudentId(String id) throws InvalidStudentIdException {
        if (id.length() != 6 || !id.matches("[0-9]+")) {
            throw new InvalidStudentIdException(
                "Student ID must contain exactly 6 numeric characters.");
        }
    }

    static void validateAge(int age) throws InvalidAgeException {
        if (age < 18 || age > 60) {
            throw new InvalidAgeException(
                "Student age must be between 18 and 60.");
        }
    }

    static void validateEmail(String email) throws InvalidEmailException {
        if (!email.contains("@") || !email.contains(".")) {
            throw new InvalidEmailException(
                "Email must contain '@' and '.'.");
        }
    }

    static double calculateFeePerInstallment(double totalFee, int installments) {
        return totalFee / installments;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String availableCourse = "Java Programming";

        System.out.println("===== Student Registration System =====");

        try {
            System.out.print("Enter Student Name: ");
            String rawName = sc.nextLine();
            String name = rawName.trim().replaceAll("\\s+", " ");
            String upperName = name.toUpperCase();

            System.out.print("Enter Student ID: ");
            String studentId = sc.nextLine().trim();
            validateStudentId(studentId);
            char firstChar = studentId.charAt(0);
            int idLength = studentId.length();

            System.out.print("Enter Age: ");
            String ageInput = sc.nextLine().trim();
            int age = Integer.parseInt(ageInput); 
            validateAge(age);

            System.out.print("Enter Email: ");
            String email = sc.nextLine().trim();
            validateEmail(email); 

            System.out.print("Enter Course: ");
            String course = sc.nextLine().trim();
            boolean courseMatches = course.equalsIgnoreCase(availableCourse);
            String upperCourse = course.toUpperCase();

            if (!courseMatches) {
                System.out.println("\nNote: Entered course does not match any available course.");
                System.out.println("Available course: " + availableCourse);
            }

            double totalFee = 30000;
            int installments = 0;

            try {

                if (installments <= 0) {
                    throw new IllegalArgumentException("Number of installments must be greater than zero.");
                }
                double feePerInstallment = calculateFeePerInstallment(totalFee, installments);
                System.out.println("Fee per installment: " + feePerInstallment);
            } catch (ArithmeticException ae) {
                System.out.println("\nArithmetic Error!");
                System.out.println("Course fee calculation cannot be performed using zero.");
            } catch (IllegalArgumentException iae) {
                System.out.println("\nInvalid Value!");
                System.out.println(iae.getMessage());
            }

            System.out.println("\n===== Registration Successful =====");
            System.out.println("Student Name: " + upperName);
            System.out.println("Student ID: " + studentId);
            System.out.println("Age: " + age);
            System.out.println("Email: " + email);
            System.out.println("Course: " + upperCourse);
            System.out.println("Student ID Length: " + idLength);
            System.out.println("First Character of Student ID: " + firstChar);

        } catch (InvalidStudentIdException e) {
            System.out.println("\nInvalid Student ID!");
            System.out.println(e.getMessage());
        } catch (InvalidAgeException e) {
            System.out.println("\nInvalid Age!");
            System.out.println(e.getMessage());
        } catch (InvalidEmailException e) {
            System.out.println("\nInvalid Email!");
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("\nInvalid Input!");
            System.out.println("Please enter a valid numeric value.");
        } catch (ArithmeticException e) {
            System.out.println("\nArithmetic Error!");
            System.out.println("Course fee calculation cannot be performed using zero.");
        } catch (IllegalArgumentException e) {
            System.out.println("\nInvalid Value!");
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }
    }
}