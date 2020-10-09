import java.time.LocalDateTime;
import java.util.ArrayList;

public class Campaign {

    public int ID;
    public String name;
    public String description;
    public String strategy;

    public LocalDateTime start;
    public LocalDateTime finish;
    public int totalVoucherCount;
    public int CurrentVoucherCount = 0;

    public enum CampaignStatusType{
        NEW,STARTED,EXPIRED,CANCELLED
    }
    public CampaignStatusType campaignStatusType;
    public CampaignVoucherMap voucherMap = new CampaignVoucherMap();
    public ArrayList<User> users = new ArrayList<>();
    public ArrayList<Voucher> vouchers = new ArrayList<>();

    public Campaign(int ID,String name, String description, LocalDateTime start, LocalDateTime finish,
                    String strategy,int totalVoucherCount, LocalDateTime System)
    {
        this.ID =ID;
        this.name = name;
        this.description = description;
        this.start = start;
        this.finish = finish;
        this.totalVoucherCount = totalVoucherCount;
        this.strategy = strategy;

        if(System.isBefore(start))
            this.campaignStatusType = CampaignStatusType.NEW;
        else
            if(System.isAfter(finish))
                this.campaignStatusType = CampaignStatusType.EXPIRED;
            else
                this.campaignStatusType = CampaignStatusType.STARTED;
    }

    public ArrayList<Voucher> getVouchers() {
        return vouchers;
    }

    public Voucher getVoucher(int id)
    {
        for (Voucher v:vouchers) {
            if(v.ID == id)
                return v;
        }
        return null;
    }
    public boolean containsObs(User user)
    {
        for(User u:users)
        {
            if(u.email.equals(user.email))
            {
                return true;
            }
        }
            return false;
    }

    public void generateVoucher(String email, String voucherType, float value)
    {
        if(CurrentVoucherCount == totalVoucherCount)
            return;
        Voucher v;
        if(voucherType.equals("GiftVoucher"))
        {
            v = new GiftVoucher(value);
        }
        else {
            v = new LoyalityVoucher(value);
        }

        v.campaignID = this.ID;
        v.email = email;
        this.CurrentVoucherCount++;
        v.ID = this.CurrentVoucherCount;
        v.voucherStatusType = Voucher.VoucherStatusType.UNUSED;
        CodeGenerator codeGenerator = new CodeGenerator();
        v.code = codeGenerator.generateCode(25) + v.ID + v.campaignID;
        voucherMap.addVoucher(v);
        vouchers.add(v);

        for (User u: users) {
            if(u.email.equals(email))
            {
                u.vouchers.add(v);
                u.voucherMap.addVoucher(v);
            }
        }



    }

    public boolean redeemVoucher(int id, LocalDateTime date)
    {
        if(date.isAfter(this.start) && date.isBefore(this.finish))
        {
            if(this.campaignStatusType == CampaignStatusType.STARTED)
            {
                for (Voucher v:vouchers) {
                    if(v.ID == id)
                    {
                        if(v.voucherStatusType == Voucher.VoucherStatusType.UNUSED)
                        {
                            v.date = date;
                            v.voucherStatusType = Voucher.VoucherStatusType.USED;
                            return true;
                        }
                        return false;
                    }
                }
            }
        }
        return false;
    }
    public ArrayList<User> getObservers(){
        return users;
    }
    public void addObserver(User user)
    {
        if(!users.contains(user))
            users.add(user);
    }
    public void removeObserver(User user)
    {
        if(!users.contains(user))
            users.remove(user);
    }
    public void notifyAllObservers(Notification notification)
    {
        for (User u:users) {
            u.notifications.add(notification);
        }
    }

}
