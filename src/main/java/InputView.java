import java.util.Scanner;

public class InputView {
    Scanner scanner;
    public InputView() {
        scanner = new Scanner(System.in);
    }

    public char[] getUserNumbers(){
        System.out.print("숫자를 입력해 주세요 : ");

        String userInputString = scanner.nextLine();
        return userInputString.toCharArray();
    }
    public String getInputFinishing(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        return scanner.nextLine();
    }
}
