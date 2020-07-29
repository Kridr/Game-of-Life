import java.util.Scanner;

class StringProcessor extends Thread {

    final Scanner scanner = new Scanner(System.in); // use it to read string from the standard input

    @Override
    public void run() {
        boolean cont = true;

        while (cont) {
            String line = scanner.nextLine();

            if (line.equals(line.toUpperCase())) {
                System.out.println("FINISHED");
                cont = false;
            } else {
                System.out.println(line.toUpperCase());
            }
        }
    }
}