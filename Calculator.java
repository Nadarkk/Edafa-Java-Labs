import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter first number: ");
        double num1 = s.nextDouble();
        System.out.println("Enter second number: ");
        double num2 = s.nextDouble();
        System.out.println("Enter operator: ");
        char operator = s.next().charAt(0);
        System.out.println(num1 + " " + operator + " " + num2);
        double result=0;

        switch(operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
              //try {
                    result = num1 / num2;
                    break;
//                } catch (Exception e) {
//                    System.out.println("Can't divide by 0");
//                }
            default:
                System.out.println("Invalid operator");
                break;
        }
            System.out.println("Res ult: " + result);
    }

}


