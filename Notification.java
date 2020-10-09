import java.time.LocalDateTime;
import java.util.ArrayList;

public class Notification {
    public enum NotificationType{
        EDIT,CANCEL
    }
    public NotificationType notificationType;
    public LocalDateTime date;
    public int campaignID;
    public ArrayList<Voucher> VoucherCodes = new ArrayList<>();

    public Notification(Campaign campaign,LocalDateTime time, int index)
    {
        if(index == 0)
            this.notificationType = NotificationType.EDIT;
        else
            this.notificationType = NotificationType.CANCEL;
        this.campaignID = campaign.ID;
        this.date = time;
        for (Voucher v:campaign.vouchers){
            VoucherCodes.add(v);
        }
    }

    //@Override
    public String toString(String email) {
        return "Notification{" +
                "notificationType=" + notificationType +
                ", date=" + date +
                ", campaignID=" + campaignID +
                ", Voucher Codes =[" + this.userVoucher(email) + "]}";
    }

    public String userVoucher(String email){
        String s = "";
        for (Voucher v:VoucherCodes) {
            if(v.email.equals(email))
            {
                s = s + v.ID + ", ";
            }
        }
        return s.substring(0, s.length() - 2);
    }
}
