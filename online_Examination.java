import java.util.Scanner;

public class online_Examination {
    private String username;
    private String password;
    private String profile;

    public online_Examination(String username, String password, String profile) {
        this.username = username;
        this.password = password;
        this.profile = profile;
    }

    public void updateProfile(String newProfile) {
        this.profile = newProfile;
        System.out.println("Profile updated successfully!");
    }

    public void updatePassword(String newPassword) {
        this.password = newPassword;
        System.out.println("Password updated successfully!");
    }

    public void startExam() {
        System.out.println("Exam started. You have 60 minutes to complete the exam.");

        // Simulating the timer
        try {
            Thread.sleep(60000); // Sleep for 60 seconds (60 minutes for actual implementation)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Time's up! Exam submitted automatically.");
        // Perform auto-submit logic here
    }

    public void closeSession() {
        System.out.println("Session closed successfully.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        // Create an instance of the OnlineExaminationSystem with a default profile
        online_Examination examSystem = new online_Examination(username, password, "Default Profile");

        // Perform login authentication
        if (examSystem.username.equals(username) && examSystem.password.equals(password)) {
            System.out.println("Login successful!");

            while (true) {
                System.out.println("Welcome to the Online Examination System!");
                System.out.println("Please select an option:");
                System.out.println("1. Update Profile");
                System.out.println("2. Update Password");
                System.out.println("3. Start Exam");
                System.out.println("4. Close Session and Logout");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        System.out.print("Enter your new profile: ");
                        String newProfile = scanner.nextLine();
                        examSystem.updateProfile(newProfile);
                        break;
                    case 2:
                        System.out.print("Enter your new password: ");
                        String newPassword = scanner.nextLine();
                        examSystem.updatePassword(newPassword);
                        break;
                    case 3:
                        examSystem.startExam();
                        break;
                    case 4:
                        examSystem.closeSession();
                        System.out.println("Logout successful. Goodbye!");
                        System.exit(0);
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        } else {
            System.out.println("Invalid username or password. Login failed.");
        }
    }
}
