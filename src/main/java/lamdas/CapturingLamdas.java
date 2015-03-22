package lamdas;

/**
 * Created with IntelliJ IDEA.
 * User: Dan
 * Date: 22/03/15
 * Time: 16:18
 * To change this template use File | Settings | File Templates.
 */
public class CapturingLamdas {


    public static int instanceVar = 2;

    //stack variables cannot be shared across threads and have to be effectively final to work.
    public static Runnable functionOne(){

        Integer i = 1000;
        Runnable r = () -> System.out.println(i * 1000);
        //i= 20;
        return r;
    }


    //Instance variables are on the heap, and heap can be shared across multiple threads
    public Runnable functionTwo(){

        Runnable r = () ->  {this.instanceVar++; System.out.println(this.instanceVar * 1);};
        //this.instanceVar = 2000;
        return r;
    }


    public static void main(String[] args){

        CapturingLamdas object = new CapturingLamdas();
        Thread thread = new Thread(functionOne());
        Thread thread1 = new Thread(object.functionTwo());
        thread.start();
        thread1.start();

    }

}
