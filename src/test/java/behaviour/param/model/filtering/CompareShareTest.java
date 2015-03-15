package behaviour.param.model.filtering;

import behaviour.param.model.Share;
import org.joda.money.Money;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: Dan
 * Date: 15/03/15
 * Time: 17:34
 * To change this template use File | Settings | File Templates.
 */
@RunWith(MockitoJUnitRunner.class)
public class CompareShareTest  {


    Comparator<Share> comparator = (Share s1, Share s2) -> s1.getPrice().compareTo(s2.getPrice());

    @Test
    public void testCompareShareByPriceBefore(){
        Share share1 = mock(Share.class);
        Share share2 = mock(Share.class);

        when(share1.getPrice()).thenReturn(Money.parse("USD 10.00"));
        when(share2.getPrice()).thenReturn(Money.parse("USD 12.00"));


        Assert.assertEquals(-1,comparator.compare(share1, share2));
    }

    @Test
    public void testCompareShareByPriceEqual(){
        Share share1 = mock(Share.class);
        Share share2 = mock(Share.class);

        when(share1.getPrice()).thenReturn(Money.parse("USD 10.00"));
        when(share2.getPrice()).thenReturn(Money.parse("USD 10.00"));

        Assert.assertEquals(0,comparator.compare(share1, share2));
    }

    @Test
    public void testCompareShareByPriceAfter(){
        Share share1 = mock(Share.class);
        Share share2 = mock(Share.class);

        when(share1.getPrice()).thenReturn(Money.parse("USD 12.00"));
        when(share2.getPrice()).thenReturn(Money.parse("USD 10.00"));
        Assert.assertEquals(1,comparator.compare(share1, share2));
    }

}
