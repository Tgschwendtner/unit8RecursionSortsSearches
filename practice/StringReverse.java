public class StringReverse
{
    public static String reverse( String text )
    {
        if ( text.length() == 0 )
        {
            return "";
        }
        
        char c = text.charAt( 0 );
        String rest = text.substring( 1 );
        String reverseText = reverse ( rest ) + c;
        return reverseText;
    }
    
    public static String reverseIter( String text )
    {
        String reverseText = "";
        
        for ( int i = text.length() - 1 ; i >= 0; i--)
        {
            char c = text.charAt( i );
            reverseText = reverseText + c;
        }
        return reverseText;
    }
    
    public static void main (String[] args)
    {
        System.out.println( StringReverse.reverse("Hello!"));
        System.out.println( "Expected : !olleh");
        System.out.println( StringReverse.reverse( "Odd"));
        System.out.println( "Expected: ddO");
        
    }
}