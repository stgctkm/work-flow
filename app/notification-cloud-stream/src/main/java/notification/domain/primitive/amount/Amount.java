package notification.domain.primitive.amount;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * 金額
 */
public class Amount {
   BigDecimal value;

   public Amount() {
      this(BigDecimal.ZERO);
   }

   public Amount(String value) {
      this(new BigDecimal(value.replaceAll(",", "")));
   }

   public Amount(BigDecimal value) {
      this.value = value;
   }

   public boolean isGreaterThan(Amount other) {
      return value.compareTo(other.value) > 0;
   }

   @Override
   public String toString() {
      DecimalFormat decimalFormat = new DecimalFormat("#,###");
      return decimalFormat.format(value);
   }

   public Amount add(Amount other) {
      return new Amount(value.add(other.value));
   }

}
