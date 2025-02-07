import java.util.Objects;
import java.util.Scanner;

public class Thomas {
    public static void main(String[] args) {
        String greet = "Hello! I'm Thomas\n" +
                "What can I do for you?\n";
        String bye = "Bye. Hope to see you again soon!";

        Scanner command = new Scanner(System.in);
        System.out.println(greet);
        String input = command.nextLine();
        while (!Objects.equals(input, "bye")) {
            System.out.println(input);
            input = command.nextLine();
        }

        System.out.println(bye);
    }
}
