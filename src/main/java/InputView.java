import java.util.Scanner;

public class InputView {
    Scanner scanner;
    public InputView() {
        scanner = new Scanner(System.in);
    }

    public char[] getUserNumbers(){

        System.out.print("숫자를 입력해 주세요 : ");

        String userInputString = scanner.nextLine();
        char[] userInputCharArray = userInputString.toCharArray();

        return userInputCharArray;
    }
}
