import java.util.ArrayList;

public class User {
    public int ID;
    public String name;
    public String email;
    public String password;

    public enum UserType{
        ADMIN,GUEST
    }
    public UserType userType;
    public UserVoucherMap voucherMap = new UserVoucherMap();
    public ArrayList<Notification> notifications = new ArrayList<>();
    public ArrayList<Voucher> vouchers = new ArrayList<>();

    public User(int ID,String name, String password, String email, int Status)
    {
        this.ID = ID;
        this.name = name;
        this.password = password;
        this.email = email;
        if(Status == 0)
        {
            this.userType = UserType.ADMIN;
        }
        else
            this.userType = UserType.GUEST;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", userType=" + userType +
                '}';
    }

    public int countUsedVouchers(int id)
    {
        int count = 0;
        for (Voucher v:vouchers) {
            if(v.voucherStatusType == Voucher.VoucherStatusType.USED
                    && v.campaignID == id)
                count++;
        }
        return count;
    }

    public int countVouchers(int id)
    {
        int count = 0;
        for (Voucher v:vouchers) {
            if(v.campaignID == id)
                count++;
        }
        return count;
    }
}
