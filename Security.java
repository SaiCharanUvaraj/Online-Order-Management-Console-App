public class Security 
{
    public static String encryptPassword(String password)
    {
        String encrypt="";
        for(int i=0;i<password.length();i++)
        {
            char c=password.charAt(i);
            encrypt=encrypt+(char)(c+1);
        }
        return encrypt;
    }
    public static String decryptPassword(String password)
    {
        String decrypt="";
        for(int i=0;i<password.length();i++)
        {
            char c=password.charAt(i);
            decrypt=decrypt+(char)(c-1);
        }
        return decrypt;
    }
}