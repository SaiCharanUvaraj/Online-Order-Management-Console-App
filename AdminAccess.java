public class AdminAccess 
{
    public static void addCustomer()
    {
        while(true)
        {
            System.out.println("\nAdd your new Customer");
            System.out.println("Enter the following Customer Details");
            System.out.println("\tUsername:");
            String username = System.console().readLine();
            if(UserDetails.isExist("1",username))
            {
                System.out.println("\nThis username is already exist !!");
                continue;
            }
            System.out.println("\tPassword:");
            String password = System.console().readLine();
            password=Security.encryptPassword(password);
            String line=String.valueOf(UserDetails.getLastId()+1)+","+username+","+password+","+"Customer";
            System.out.println(UserDetails.addDetail(line));
            break;
        }
    }
    public static void updateItem()
    {
        boolean isUpdating=true;
        while (isUpdating)
        {
            try
            {
                System.out.println("\nWhat do you want to update in Items?");
                System.out.println("\tOption 1: Available Quantity");
                System.out.println("\tOption 2: Price per Item");
                System.out.println("Enter 0 to go back");
                String choice= System.console().readLine();
                switch(choice)
                {
                    case "1":
                        while (true) 
                        {
                            System.out.println("\nUpdate the Available Quantity of an Item by Id");
                            System.out.println("\tEnter the Id of the Item:");
                            String id = System.console().readLine();
                            if(ItemDetails.isExist("0",id)==false)
                            {
                                System.out.println("This id does not exist !!");
                                System.out.println("Enter correct Id of the item.");
                                continue;
                            }
                            System.out.println("\tNew Quantity:");
                            String newOne = System.console().readLine();
                            ItemDetails.setAttribute("4", id, newOne);
                            break;
                        }
                        break;
                    case "2":
                        while(true)
                        {
                            System.out.println("\nUpdate the Price per Item of an Item by Id");
                            System.out.println("\tEnter the Id of the item:");
                            String id = System.console().readLine();
                            if(ItemDetails.isExist("0",id)==false)
                            {
                                System.out.println("This id does not exist !!");
                                System.out.println("Enter correct Id of the item.");
                                continue;
                            }
                            System.out.println("\tNew Price per Item:");
                            String newOne = System.console().readLine();
                            ItemDetails.setAttribute("3", id, newOne);
                            break;
                        }
                        break;
                    case "0":
                        System.out.println("Back...");
                        isUpdating=false;
                        break;
                    default:
                        System.out.println("Invalid option!!");
                        break;
                }
            }
            catch (Exception e)
            {
                System.out.println("Error!! Back...");
                System.out.println(e);
                isUpdating = false;
            }
        }
    }
}