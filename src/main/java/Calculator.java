import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите два арабских или два римских числа с оператором выражения (2+3, или II+IV). Для выхода введите exit ");
            String input = scanner.nextLine();

            if (input.equals("exit")) {
                exitCalculator();
                break;
            }

            try {
                String[] digits = input.split(" ");
                if (digits.length != 3) throw new Exception("Неверное количество символов. Введите цифры через пробел");

                Number firsNumber = NumberService.parseAndValidate(digits[0]);
                Number secondNumber = NumberService.parseAndValidate(digits[2], firsNumber.getType());
                String result = ActionService.calculate(firsNumber, secondNumber, digits[1]);
                System.out.println("Результат: " + result);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                exitCalculator();
                break;
            }
        }
    }


    private static void exitCalculator () {
        System.out.println("Выход...");
    }
}
