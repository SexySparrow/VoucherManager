
public class UserVoucherMap<Integer,ArrayList> extends ArrayMap{

    public boolean addVoucher(Voucher v)
    {
        if(this.containsKey(v.campaignID))
        {
            java.util.ArrayList<Voucher> arrayList = (java.util.ArrayList<Voucher>)this.get(v.campaignID);
            arrayList.add(v);
            return true;
        }
        else
        {
            java.util.ArrayList<Voucher> vouchers = new java.util.ArrayList<>();
            vouchers.add(v);
            this.put(v.campaignID,vouchers);
        }
        return false;
    }
}
