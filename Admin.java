public class Admin
{
    public static void showAdminFunctionalities()
    {
        boolean isLoggedIn=false;
        if(Authentication.authenticateAdmin())
        {
            System.out.println("Successfully logged in :) \n\nWelcome Admin");
            isLoggedIn=true;
        }
        else
            System.out.println("Incorrect username and password combination");

        while (isLoggedIn)
        {
            try
            {
                System.out.println("\n------------------------------------------");
                System.out.println("\nWhat do you want to do?");
                System.out.println("\tOption 1: Update Item");
                System.out.println("\tOption 2: Top Selling Items");
                System.out.println("\tOption 3: Add New Customer");
                System.out.println("\tOption 0: Logout");
                String choice = System.console().readLine();
                switch(choice)
                {
                    case "1":
                        AdminAccess.updateItem();
                        break;
                    case "2":
                        System.out.println("Top Selling Item functionality is not implemented yet.");
                        break;
                    case "3":
                        AdminAccess.addCustomer();
                        break;
                    case "0":
                        System.out.println("Logged out...");
                        isLoggedIn = false;
                        break;
                    default:
                        System.out.println("Invalid option!!");
                        break;
                }
            }
            catch (Exception e)
            {
                System.out.println("Error!! Logged out...");
                System.out.println(e);
                isLoggedIn = false;
            }
        }
    } 
}