package behaviour.param.strategy;

import behaviour.param.model.Share;

/**
 * Created with IntelliJ IDEA.
 * User: Dan
 * Date: 15/03/15
 * Time: 14:07
 * To change this template use File | Settings | File Templates.
 */
public class ShareTicketPredicate implements SharePredicate {
    @Override
    public boolean test(Share s) {
        return s.getTicker().startsWith("MS");
    }
}
