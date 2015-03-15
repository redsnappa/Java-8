package behaviour.param.strategy;

import behaviour.param.model.Share;
import org.joda.money.Money;

/**
 * Created with IntelliJ IDEA.
 * User: Dan
 * Date: 15/03/15
 * Time: 14:04
 * To change this template use File | Settings | File Templates.
 */
public class SharePricePredicate implements SharePredicate {

    @Override
    public boolean test(Share s) {

        return s.getPrice().isGreaterThan(Money.parse("USD 30.00"));
    }
}
