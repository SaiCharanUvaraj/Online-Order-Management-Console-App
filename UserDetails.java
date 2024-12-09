import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class UserDetails
{

    // Displays the available user details
    public static void printDetails()
    {
        try (BufferedReader reader = new BufferedReader(new FileReader("UserDetails.txt"))) 
        {
            String line = reader.readLine();
            System.out.println("\nAvailable user details");
            while (line!= null) 
            {
                System.out.println(line);
                line = reader.readLine();
            }
        } 
        catch (Exception e) 
        {
            System.out.println("Error while printing user details...");
            System.out.println(e);
        }
    }

    // get the details of the admin 
    public static String[] getAdminDetail()
    {
        String[] info={};
        try (BufferedReader reader = new BufferedReader(new FileReader("UserDetails.txt"))) 
        {
            String line = reader.readLine();
            line = reader.readLine();
            info = line.split(",");
        } 
        catch (Exception e) 
        {
            System.out.println("Error while getting admin details...");
            System.out.println(e);
        }
        return info;
    }

    public static String[] getDetails()
    {
        String details = "";
        try (BufferedReader reader = new BufferedReader(new FileReader("UserDetails.txt"))) 
        {
            String line = reader.readLine();
            line=reader.readLine();
            line=reader.readLine();
            while (line!= null) 
            {
                details=details+line+"\n";
                line=reader.readLine();
            }
        } 
        catch (Exception e) 
        {
            System.out.println("Error while reading last id in user details..");
            System.out.println(e);
        }
        String[] info=details.split("\n");
        return info;
    }

    // get the last id used for user
    public static int getLastId()
    {
        int id=0;
        try (BufferedReader reader = new BufferedReader(new FileReader("UserDetails.txt"))) 
        {
            String line = reader.readLine();
            String last="";
            while (line!= null) 
            {
                last=line;
                line=reader.readLine();
            }
            String[] info = last.split(",");
            id=Integer.parseInt(info[0]);
        } 
        catch (Exception e) 
        {
            System.out.println("Error while reading last id in user details..");
            System.out.println(e);
        }
        return id;
    }

    // check whether given user attribute is present or not
    public static boolean isExist(String userAttribute, String toCheck)
    {
        boolean isThere=false;
        try (BufferedReader reader = new BufferedReader(new FileReader("UserDetails.txt"))) 
        {
            String line = reader.readLine();
            line = reader.readLine();
            line=reader.readLine();
            while (line!= null) 
            {
                String[] info = line.split(",");
                if(info[Integer.parseInt(userAttribute)].equals(toCheck))
                {
                    isThere=true;
                    break;
                }
                line=reader.readLine();
            }
        } 
        catch (Exception e) 
        {
            System.out.println("Error while checking for existing passwords...");
            System.out.println(e);
        }
        return isThere;
    }

    // erase the user details
    public static void eraseDetails()
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("UserDetails.txt"))) 
        {
            writer.write("ID,Username,Password,Role\n");
        } 
        catch (Exception e) 
        {
            System.out.println("Error while erasing item details...");
            System.out.println(e);
        }
    }

    // add customer detail to the user details
    public static String addDetail(String line)
    {
        String str="";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("UserDetails.txt", true))) 
        {
            writer.write(line+"\n");
            str="The given customer details have been added successfully...";
        } 
        catch (Exception e) 
        {
            System.out.println("Error while adding new customer details...");
            System.out.println(e);
        }
        return str;
    }

    public static void setAdminDetail(String uname,String password)
    {
        setAttribute("1","100",uname);
        String pwd=Security.encryptPassword(password);
        setAttribute("2","100",pwd);
    }
    
    // update the given user attribute with new one
    public static void setAttribute(String userAttribute,String id,String newOne)
    {
        try (BufferedReader reader = new BufferedReader(new FileReader("UserDetails.txt"))) 
        {
            ArrayList<String> details = new ArrayList<String>();
            String line = reader.readLine();
            line=reader.readLine();
            while (line!= null) 
            {
                details.add(line);
                line = reader.readLine();
            }
            eraseDetails();
            for(int i=0;i<details.size();i++)
            {
                String[] info = details.get(i).split(",");
                if(info[0].equals(id))
                {
                    info[Integer.parseInt(userAttribute)]=newOne;
                    String updItem=String.join(",",info);
                    details.set(i,updItem);
                }
                addDetail(details.get(i));
            }
        } 
        catch (Exception e) 
        {
            System.out.println("Error while getting given item detail...");
            System.out.println(e);
        }
    }
}