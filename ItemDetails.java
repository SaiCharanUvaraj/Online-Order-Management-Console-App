import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class ItemDetails
{

    // Displays the available item details
    public static void printDetails()
    {
        try (BufferedReader reader = new BufferedReader(new FileReader("ItemDetails.txt"))) 
        {
            String line = reader.readLine();
            System.out.println("\nAvailable Items:");
            while (line!= null) 
            {
                System.out.println(line);
                line = reader.readLine();
            }
        } 
        catch (Exception e) 
        {
            System.out.println("Error while printing item details...");
            System.out.println(e);
        }
    }

    // get the details of the item of given id 
    public static String getItemDetail(String id)
    {
        String detail="";
        boolean isExist=false;
        try (BufferedReader reader = new BufferedReader(new FileReader("ItemDetails.txt"))) 
        {
            String line = reader.readLine();
            while (line!= null) 
            {
                String[] info = line.split(",");
                if(info[0].equals(id))
                {
                    detail=line;
                    isExist=true;
                    break;
                }
                System.out.println();
                line = reader.readLine();
            }
        } 
        catch (Exception e) 
        {
            System.out.println("Error while getting given item detail...");
            System.out.println(e);
        }
        if(isExist)
            return detail;
        else
            return null;
    }

    // Erase all the details in the Item list
    public static void eraseDetails()
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("ItemDetails.txt"))) 
        {
            writer.write("ItemID,ItemName,Category,Price/unit,AvailableQuantity,DiscountApplicable\n");
        } 
        catch (Exception e) 
        {
            System.out.println("Error while erasing item details...");
            System.out.println(e);
        }
    }

    // Add the given item details
    public static void addDetail(String detail)
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("ItemDetails.txt",true))) 
        {
            writer.write(detail+"\n");
        } 
        catch (Exception e) 
        {
            System.out.println("Error while adding item detail...");
            System.out.println(e);
        }
    }

    //  Check whether the given attribute of an item of given id present in the item list
    public static boolean isExist(String itemAttribute, String toCheck)
    {
        boolean isThere=false;
        try (BufferedReader reader = new BufferedReader(new FileReader("ItemDetails.txt"))) 
        {
            String line = reader.readLine();
            line=reader.readLine();
            while (line!= null) 
            {
                String[] info = line.split(",");
                if(info[Integer.parseInt(itemAttribute)].equals(toCheck))
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

    // Update the give attribute of an item of given id present in the item list
    public static void setAttribute(String itemAttribute,String id,String newOne)
    {
        try (BufferedReader reader = new BufferedReader(new FileReader("ItemDetails.txt"))) 
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
                    info[Integer.parseInt(itemAttribute)]=newOne;
                    String updItem=String.join(",",info);
                    details.set(i,updItem);
                }
                addDetail(details.get(i));
            }
            System.out.println("The update is done successfully\n");
        } 
        catch (Exception e) 
        {
            System.out.println("Error while getting given item detail...");
            System.out.println(e);
        }
    }
}
