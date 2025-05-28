public class Patterns 
{
    //////////////////////////////////////////////////////////////////////////
    public static void RightTriangle()
    {
        int n = 5;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++){
                if (i>=j)
                    System.out.print("* ");
                else 
                    System.out.print("  ");
            }
            System.out.println();           
        }
    }
//////////////////////////////////////////////////////////////////////////
    public static void InvertedRightTriangle()
    {
        int n = 5;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++){
                if (i<=j)
                    System.out.print("* ");
                else 
                    System.out.print("  ");
            }
            System.out.println();           
        }
    }
//////////////////////////////////////////////////////////////////////////
    public static void Square()
    {
        int n = 5;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++){
                if (i==0 || j==0 || i==n-1 || j==n-1)
                    System.out.print("*");
                else 
                    System.out.print(" ");
            }
            System.out.println();           
        }
    }
//////////////////////////////////////////////////////////////////////////
    
}
