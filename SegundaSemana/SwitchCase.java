import java.util.Scanner;

public class SwitchCase {
    
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Ingresa un carácter: ");
		String input = scanner.nextLine();
		char ch;
		if (input.length() > 0) {
			ch = input.charAt(0);
		} else {
			System.out.println("No ingresaste ningún carácter.");
			scanner.close();
			return;
		}
        
		if (Character.isLetter(ch)) {
			char lowerCh = Character.toLowerCase(ch);
            switch (lowerCh) {
                case 'a', 'e', 'i', 'o', 'u':
                    System.out.println("Es una vocal.");
                    break;
                default:
                    System.out.println("Es una consonante.");
            }
			/*if (lowerCh == 'a' || lowerCh == 'e' || lowerCh == 'i' || lowerCh == 'o' || lowerCh == 'u') {
				System.out.println("Es una vocal.");
			} else {
				System.out.println("Es una consonante.");
			}
                */
		} else if (Character.isDigit(ch)) {
			System.out.println("Es un dígito (número).");
		} else {
			System.out.println("Es un carácter especial.");
		}
		scanner.close();
	}
}
