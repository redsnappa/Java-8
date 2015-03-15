package behaviour.param.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.joda.money.Money;

/**
 * Created with IntelliJ IDEA.
 * User: Dan
 * Date: 12/03/15
 * Time: 20:08
 * To change this template use File | Settings | File Templates.
 */
public class Share {

    private String ticker;

    private String exchange;

    public Money price;

    public Share(String ticker, String exchange, Money price){
        this.ticker = ticker;
        this.exchange = exchange;
        this.price = price;
    }


    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public Money getPrice() {
        return price;
    }

    public void setPrice(Money price) {
        this.price = price;
    }

    @Override
    public int hashCode(){
        return new HashCodeBuilder(17, 37).
                append(ticker).
                append(exchange).
                append(price).
                toHashCode();
    }

    public boolean equals(Object obj) {
        if (obj == null) { return false; }
        if (obj == this) { return true; }
        if (obj instanceof Share ) {
            return false;
        }
        Share rhs = (Share) obj;
        return new EqualsBuilder()
                .appendSuper(super.equals(obj))
                .append(ticker, rhs.ticker)
                .append(exchange, rhs.exchange)
                .append(price, rhs.price)
                .isEquals();
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Ticker: ");
        sb.append(ticker);
        sb.append(" is traded on ");
        sb.append(exchange);
        sb.append(". Price per share is ");
        sb.append(price);
        return sb.toString();
    }


}
