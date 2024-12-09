public class Customer 
{
    public static void showCustomerFunctionalities()
    {
        boolean isLoggedIn=false;
        if(Authentication.authenticateCustomer())
        {
            System.out.println("Successfully logged in :) \n\nWelcome "+Authentication.currentUser);
            isLoggedIn=true;
        }
        else
            System.out.println("Incorrect username and password combination");
        System.out.println(isLoggedIn);
    }
}