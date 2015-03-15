package behaviour.param.comparator;

import behaviour.param.model.Share;

import java.util.Comparator;
import java.util.function.Predicate;

/**
 * Created with IntelliJ IDEA.
 * User: Dan
 * Date: 15/03/15
 * Time: 17:30
 * To change this template use File | Settings | File Templates.
 */
public class CompareShareService {


    private static int compare(Share s1,Share s2,Comparator<Share> comparator){

        return comparator.compare(s1,s2);

    }


}
