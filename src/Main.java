public class Main {
    public static void main(String[] args) {
        String login = "java_skypro_go1";
        String password = "D_1hWiKjjP_9";
        String confirmPassword = "D_1hWiKjjP_9";
        checkData(login,password,confirmPassword);
    }
    public static void check(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (!login.matches("[a-zA-Z0-9_]+") || login.length() > 20 || login.isEmpty() || login.isBlank()) {
            throw new WrongLoginException();
        }

        if (!password.matches("[a-zA-Z0-9_]+") || password.length() > 19 || password.isEmpty() || password.isBlank()) {
            throw new WrongPasswordException();
        }
        if (!confirmPassword.equals(password)) {
            throw new WrongPasswordException();
        }
    }

    public static void checkData(String login, String password, String confirmPassword) {
        try {
            check(login, password, confirmPassword);
        } catch (WrongLoginException e) {
            System.out.println("Введите корректный логин");
        } catch (WrongPasswordException e) {
            System.out.println("Введите корректный пароль. Пароли должны совпадать.");
        } finally {
            System.out.println("Проверка завершена");
        }
    }
}