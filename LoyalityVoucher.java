public class LoyalityVoucher extends Voucher {
    public float discount;
    public LoyalityVoucher(float discount){
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "LoyalityVoucher{" +
                "discount=" + discount +
                ", ID=" + ID +
                ", code='" + code + '\'' +
                ", voucherStatusType=" + voucherStatusType +
                ", date=" + date +
                ", email='" + email + '\'' +
                ", campaignID=" + campaignID +
                '}';
    }
}
