package behaviour.param.filtering;

import behaviour.param.model.Share;
import behaviour.param.strategy.SharePredicate;
import org.joda.money.Money;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Dan
 * Date: 12/03/15
 * Time: 20:36
 * To change this template use File | Settings | File Templates.
 */
public class ShareFilterService {

    /**
     * Filters stocks with a ticker
     */
    public static List<Share> filterStocksByTicker(List<Share> shares, String ticker){
        List<Share> result = new ArrayList<>();
        for(Share share : shares){
            if(ticker.equals(share.getTicker())){
                result.add(share);
            }
        }
        return result;
    }

    public static List<Share> filterStocksByPrice(List<Share> shares, Money threshold){
        List<Share> result = new ArrayList<>();
        for(Share share : shares){
            if(share.getPrice().isGreaterThan(threshold)){
                result.add(share);
            }
        }
        return result;
    }

    public static List<Share> filterStocks(List<Share> shares, String ticker, Money threshold, boolean flag){
        List<Share> result = new ArrayList<>();
        for(Share share : shares){
            if((flag && share.getPrice().isGreaterThan(threshold)) ||
                    (!flag && ticker.equals(share.getTicker()))){
                result.add(share);
            }
        }
        return result;
    }


    public static List<Share> filterStocks(List<Share> shares, SharePredicate predicate){
        List<Share> result = new ArrayList<>();
        for(Share s : shares){
            if(predicate.test(s)){
                result.add(s);
            }
        }
        return result;
    }


}
