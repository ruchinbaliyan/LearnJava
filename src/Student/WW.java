package Student;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;

class A
{
    public void p() throws NullPointerException{

        System.out.println("h");
        throw new NullPointerException("nullEx");

}
}
class B extends A
{
    public void p() throws ArrayIndexOutOfBoundsException
{
    throw new ArrayIndexOutOfBoundsException("arraEx");

}
}

public class WW {

    public static void main(String[] args) {
        A a =new A();
        A b =new B();
        try
        {
            //b.p();
            a.p();


        }


        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println(e);
        }
        catch(Exception e)
        {
            System.out.println(e);

        }


    }
}
