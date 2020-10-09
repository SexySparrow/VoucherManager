import java.util.ArrayList;

public class CampaignVoucherMap<String,ArrayList> extends ArrayMap{

    public boolean addVoucher(Voucher v)
    {
        if(this.containsKey(v.email))
        {
            java.util.ArrayList<Voucher> arrayList = (java.util.ArrayList<Voucher>)this.get(v.campaignID);
            arrayList.add(v);
            return true;
        }
        else
        {
            java.util.ArrayList<Voucher> vouchers = new java.util.ArrayList<>();
            vouchers.add(v);
            this.put(v.email,vouchers);
        }
        return false;
    }
}
