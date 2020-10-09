public class GiftVoucher extends Voucher {
    public float amount;
    public GiftVoucher(float amount){
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "GiftVoucher{" +
                "amount=" + amount +
                ", ID=" + ID +
                ", code='" + code + '\'' +
                ", voucherStatusType=" + voucherStatusType +
                ", date=" + date +
                ", email='" + email + '\'' +
                ", campaignID=" + campaignID +
                '}';
    }
}
