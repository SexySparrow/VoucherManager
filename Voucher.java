import java.time.LocalDateTime;

public abstract class Voucher {
    public int ID;
    public String code;
    public enum VoucherStatusType {
        USED,UNUSED
    }
    public VoucherStatusType voucherStatusType;
    public LocalDateTime date;
    public String email;
    public int campaignID;
}