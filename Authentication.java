public class Authentication 
{
    public static String currentUser="";
    public static boolean authenticateAdmin()
    {
        System.out.println("\nAdmin Login:");
        System.out.println("\tEnter the Username:");
        String uname = System.console().readLine();
        System.out.println("\tEnter the Password:");
        String pwd = System.console().readLine();
        String[] info=UserDetails.getAdminDetail();
        if(info[1].equals(uname) && Security.decryptPassword(info[2]).equals(pwd))
            return true;
        else
            return false;
    }

    public static boolean authenticateCustomer()
    {
        boolean result=false;
        System.out.println("\nCustomer Login:");
        System.out.println("\tEnter the Username:");
        String uname = System.console().readLine();
        System.out.println("\tEnter the Password:");
        String pwd = System.console().readLine();
        String[] details=UserDetails.getDetails();
        for(int i=0;i<details.length;i++)
        {
            String[] info=details[i].split(",");
            if(info[1].equals(uname) && Security.decryptPassword(info[2]).equals(pwd))
            {
                result=true;
                break;
            }
        }
        if(result==true)
            currentUser=uname;
        return result;
    }
}