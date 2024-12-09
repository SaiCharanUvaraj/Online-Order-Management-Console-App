public class App 
{
    public static void main(String[] args) 
    {
        System.out.println("\nWelcome to Online Order Management Application :)");
        boolean run = true;
        while (run)
        {
            try
            {
                System.out.println("\n*************************************************************************");
                System.out.println("\nLog in to the app");
                System.out.println("What is Your role?");
                System.out.println("\tOption 1: Customer");
                System.out.println("\tOption 2: Admin");
                System.out.println("Enter 0 to exit the application");
                String choice = System.console().readLine();
                switch(choice)
                {
                    case "1":
                        Customer.showCustomerFunctionalities();
                        break;
                    case "2":
                        Admin.showAdminFunctionalities();
                        break;
                    case "0":
                        System.out.println("Thank you...");
                        run = false;
                        break;
                    default:
                        System.out.println("Invalid Option !!");
                        break;
                }
            }
            catch (Exception e)
            {
                System.out.println("Error!! The app was closed...");
                System.out.println(e);
                run=false;
            }
        }
    }
}