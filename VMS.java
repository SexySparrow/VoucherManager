import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class VMS {
    public ArrayList<User> users;
    public ArrayList<Campaign> campaigns;
    public static VMS vmsObj;
    public int level;
    public User current;

    public static VMS getInstance()
    {
        if(vmsObj == null)
            vmsObj = new VMS();
        return vmsObj;
    }

    public VMS()
    {
        users = new ArrayList<>();
        campaigns = new ArrayList<>();
    }
    public void addData(String CampData,String UserData)
    {
        LocalDateTime SytemTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String inputCampaign[] = CampData.split("[\\r\\n\\r\\;]");
        String inputUsers[] = UserData.split("[\\r\\n\\r\\;]");

        int CampaignCount = Integer.parseInt(inputCampaign[0]);
        for (int i = 2; i < inputCampaign.length; i++)
        {
            for (int k = 0; k < CampaignCount; k++){
                int ID = Integer.parseInt(inputCampaign[i]);
                i++;
                String name = inputCampaign[i];
                i++;
                String descriptions = inputCampaign[i];
                i++;
                LocalDateTime start = LocalDateTime.parse(inputCampaign[i],formatter);
                i++;
                LocalDateTime finish = LocalDateTime.parse(inputCampaign[i],formatter);
                i++;
                int total = Integer.parseInt(inputCampaign[i]);
                i++;
                String strategy = inputCampaign[i];
                Campaign c = new Campaign(ID,name,descriptions,start,finish,strategy,total,SytemTime);
                this.addCampaign(c);
                i++;
            }
        }

        int UserCount = Integer.parseInt(inputUsers[0]);
        for (int i = 1; i < inputUsers.length; i++)
        {
            for (int k = 0; k < UserCount; k++){
                int ID = Integer.parseInt(inputUsers[i]);
                i++;
                String name = inputUsers[i];
                i++;
                String pass = inputUsers[i];
                i++;
                String mail = inputUsers[i];
                i++;
                String status = inputUsers[i];
                i++;
                int level;
                if(status.contains("ADMIN"))
                    level = 0;
                else level = 1;
                User u = new User(ID,name,pass,mail,level);
                this.addUser(u);
            }
        }
    }

    public ArrayList<Campaign> getCampaigns() {
        return campaigns;
    }

    public Campaign getCampaign(int id){
        for (Campaign c:campaigns) {
            if(c.ID == id)
                return c;
        }
        return null;
    }

    public void addCampaign(Campaign campaign){
        campaigns.add(campaign);
    }
    public void updateCampaign(int id, Campaign campaign, LocalDateTime time){
        Campaign c = getCampaign(id);
        if(c.campaignStatusType == Campaign.CampaignStatusType.NEW)
        {
            if(c.CurrentVoucherCount <= campaign.totalVoucherCount){
                c.totalVoucherCount = campaign.totalVoucherCount;
            }
            else
                c.totalVoucherCount = c.CurrentVoucherCount;
            c.campaignStatusType = campaign.campaignStatusType;
            c.start = campaign.start;
            c.finish = campaign.finish;
            c.name = campaign.name;
            c.description = campaign.description;
            Notification notification = new Notification(c,time,0);
            c.notifyAllObservers(notification);
        }
        else {
            if(c.campaignStatusType == Campaign.CampaignStatusType.STARTED)
            {
                if(c.CurrentVoucherCount <= campaign.totalVoucherCount){
                    c.totalVoucherCount = campaign.totalVoucherCount;
                }
                else
                    c.totalVoucherCount = c.CurrentVoucherCount;
                c.finish = campaign.finish;
                Notification notification = new Notification(c,time,0);
                c.notifyAllObservers(notification);
            }
        }
    }

    public void cancelCampaign(int id,LocalDateTime time){

        Campaign c = this.getCampaign(id);
        if(c.campaignStatusType == Campaign.CampaignStatusType.NEW
            || c.campaignStatusType == Campaign.CampaignStatusType.STARTED)
        {
            c.campaignStatusType = Campaign.CampaignStatusType.CANCELLED;
            Notification notification = new Notification(c,time,1);
            c.notifyAllObservers(notification);
        }
    }

    public ArrayList<User> getUsers(){
        return users;
    }

    public void addUser(User user){
        if(!users.contains(user)){
            users.add(user);
        }
    }
    public User getUser(String email) {
        for (User user:users){
            if(user.email.equals(email))
                return user;
        }
        return null;
    }
    public User getUserbyName(String Name) {
        for (User user:users){
            if(user.name.equals(Name))
                return user;
        }
        return null;
    }

    public User getUser(int id) {
        for (User user:users){
            if(user.ID == id)
                return user;
        }
        return null;
    }

}
