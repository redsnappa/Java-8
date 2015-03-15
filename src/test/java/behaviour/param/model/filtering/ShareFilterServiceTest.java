package behaviour.param.model.filtering;

import behaviour.param.filtering.ShareFilterService;
import behaviour.param.model.Share;
import behaviour.param.strategy.SharePredicate;
import behaviour.param.strategy.SharePricePredicate;
import behaviour.param.strategy.ShareTicketPredicate;
import org.joda.money.Money;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Dan
 * Date: 15/03/15
 * Time: 14:18
 * To change this template use File | Settings | File Templates.
 */
public class ShareFilterServiceTest {


    private List<Share> shareData = null;

    @Before
    public void setup(){

        shareData = new ArrayList<>();
        shareData.add(new Share("MMM", "NYSE", Money.parse("USD 56.00")));
        shareData.add(new Share("ABT", "NYSE", Money.parse("USD 87.00")));
        shareData.add(new Share("MS", "NYSE", Money.parse("USD 34.00")));
        shareData.add(new Share("AET", "NASDAQ", Money.parse("USD 22.00")));
        shareData.add(new Share("MO", "NYSE", Money.parse("USD 67.00")));
        shareData.add(new Share("AMZN", "NASDAQ", Money.parse("USD 43.00")));
        shareData.add(new Share("V", "NYSE", Money.parse("USD 87.00")));
        shareData.add(new Share("WMT", "NYSE", Money.parse("USD 16.00")));
        shareData.add(new Share("NFLX", "NASDAQ", Money.parse("USD 22.00")));
        shareData.add(new Share("NFX", "NYSE", Money.parse("USD 321.00")));
        shareData.add(new Share("AEP", "NYSE", Money.parse("USD 112.00")));
        shareData.add(new Share("MYL", "NYSE", Money.parse("USD 11.20")));
        shareData.add(new Share("EMR", "NYSE", Money.parse("USD 55.23")));
    }



    @Test
    public void testFilterStocksByTicker(){

    }

    @Test
    public void testFilterStocksByPrice(){

    }

    @Test
    public void testFilterStocks(){

    }

    @Test
    public void testFilterStocksWithPredicatePrice(){

        Assert.assertEquals(13,shareData.size());
        List<Share> filteredList = ShareFilterService.filterStocks(shareData, new SharePricePredicate());
        Assert.assertEquals(9, filteredList.size());
    }

    @Test
    public void testFilterStocksWithPredicateTicker(){

        Assert.assertEquals(13,shareData.size());
        List<Share> filteredList = ShareFilterService.filterStocks(shareData, new ShareTicketPredicate());
        Assert.assertEquals(1, filteredList.size());
    }

    @Test
    public void testFilterStocksWithPredicateAnonymous(){

        Assert.assertEquals(13,shareData.size());

        List<Share> filteredList = ShareFilterService.filterStocks(shareData, new SharePredicate() {
            @Override
            public boolean test(Share s) {
                return s.getTicker().contains("E");
            }
        });

        Assert.assertEquals(3, filteredList.size());
    }

    @Test
    public void testFilterStockWithLambda(){
        Assert.assertEquals(13,shareData.size());

        List<Share> filteredList = ShareFilterService.filterStocks(shareData, (Share s) -> s.getPrice().isLessThan(Money.parse("USD 20.00")));

        Assert.assertEquals(2, filteredList.size());

    }




}
