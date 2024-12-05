import java.util.Scanner;
class Helper{
    int totalmarks(int[] arr){
        int sum = 0;
        for(int i : arr){
            sum+=i;
        }
        return sum;
    }
    String grader(double num){
        if (num>=90)return "O";
        else if (num>=80)return "A+";
        else if (num>=70) return "A";
        else if (num>=60) return "B+";
        else if (num>=50) return "B";
        else if (num>=40) return "C";
        else return "Fail";
    }
}
public class StudentGradeCalculator {
    public static void main(String[] args) {
        int size;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the total subjects you having: ");
        size = in.nextInt();
        int[] marks = new int[size];
        System.out.println("Enter the marks of each subject for 100:");
        for(int i = 0 ; i< size;i++){
            marks[i] = in.nextInt();
        }
        Helper h = new Helper();
        System.out.println("Total marks you have obtained is: "+h.totalmarks(marks)+"/"+(size*100));
        double average = h.totalmarks(marks)/size;
        System.out.println("You average mark is: "+ average );
        System.out.println("Your grade is: "+h.grader(average));
    }
}
