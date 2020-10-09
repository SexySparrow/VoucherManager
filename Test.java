import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Test {
    public static String readFileAsString(String fileName)
    {
        String data = "";
        try {
            data = new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
    public static void main(String[] args) throws Exception {

        LocalDateTime SytemTime;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String CampaignData = readFileAsString("F:\\Poli\\POO\\VMStests\\test07\\input\\campaigns.txt");
        String UsersData = readFileAsString("F:\\Poli\\POO\\VMStests\\test07\\input\\users.txt");
        String EventData = readFileAsString("F:\\Poli\\POO\\VMStests\\test07\\input\\events.txt");
        String Emails = readFileAsString("F:\\Poli\\POO\\VMStests\\emails.txt");
        String inputCampaign[] = CampaignData.split("[\\r\\n\\r\\;]");
        String inputUsers[] = UsersData.split("[\\r\\n\\r\\;]");
        String inputEvents[] = EventData.split("[\\r\\n\\r\\;]");
        VMS vms = new VMS();


        int CampaignCount = Integer.parseInt(inputCampaign[0]);
        SytemTime = LocalDateTime.parse(inputCampaign[1],formatter);
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
                vms.addCampaign(c);
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
                vms.addUser(u);
            }
        }

        int EventsCount = Integer.parseInt(inputEvents[1]);
        SytemTime = LocalDateTime.parse(inputEvents[0],formatter);
        for (int i = 2; i < inputEvents.length;i++)
        {
            int userID = Integer.parseInt(inputEvents[i]);
            i++;
            switch (inputEvents[i]) {
                case "getVouchers":
                    for (User user :
                            vms.users) {
                        if (user.ID == userID && user.userType == User.UserType.GUEST) {
                            System.out.println(userID + " " + user.vouchers.toString());
                        }
                    }
                    break;
                case "getVoucher": {
                    i++;
                    int id = Integer.parseInt(inputEvents[i]);
                    User u = vms.getUser(userID);
                    Campaign c = vms.getCampaign(id);

                    if (u.userType == User.UserType.ADMIN && c.campaignStatusType != Campaign.CampaignStatusType.CANCELLED
                            && c.campaignStatusType != Campaign.CampaignStatusType.EXPIRED) {

                        switch (c.strategy)
                        {
                            case "A": {
                                int userCount = c.users.size();
                                Random r = new Random();
                                int lucky = r.nextInt(userCount);

                                c.generateVoucher(c.users.get(lucky).email,"GiftVoucher",100);
                                break;
                            }

                            case "B":{
                                int max = 0;
                                int index = 0;
                                int ind  = 0;
                                for (User user:c.users) {
                                    int x = user.countUsedVouchers(id);
                                    if(x >= max)
                                    {
                                        max = x;
                                        index = ind;
                                    }
                                    ind++;
                                }

                                c.generateVoucher(c.users.get(index).email,"LoyalityVoucher",50);
                                break;
                            }

                            case "C": {
                                int min = Integer.MAX_VALUE;
                                int index = 0;
                                int ind  = 0;
                                for (User user:c.users) {
                                    int x = user.countVouchers(id);
                                    if(x <= min)
                                    {
                                        min = x;
                                        index = ind;
                                    }
                                    ind++;
                                }

                                c.generateVoucher(c.users.get(index).email,"GiftVoucher",100);


                                break;
                            }
                        }
                    }

                    break;
                }
                case "redeemVoucher": {
                    i++;
                    int cid = Integer.parseInt(inputEvents[i]);
                    i++;
                    int vid = Integer.parseInt(inputEvents[i]);
                    i++;
                    LocalDateTime finish = LocalDateTime.parse(inputEvents[i], formatter);

                    Campaign c = vms.getCampaign(cid);
                    c.redeemVoucher(vid, finish);
                    break;
                }
                case "generateVoucher": {
                    i++;
                    int cid = Integer.parseInt(inputEvents[i]);
                    i++;
                    String email = inputEvents[i];
                    i++;
                    String voucherType = inputEvents[i];
                    i++;
                    float value = Float.parseFloat(inputEvents[i]);

                    Campaign c = vms.getCampaign(cid);
                    User u = vms.getUser(email);
                    User admin = vms.getUser(userID);
                    if(admin.userType == User.UserType.ADMIN)
                    {
                        if (!c.containsObs(u)) {
                            c.users.add(u);
                        }
                        c.generateVoucher(email, voucherType, value);
                    }
                    break;
                }
                case "getObservers": {
                    i++;
                    int cid = Integer.parseInt(inputEvents[i]);
                    User u = vms.getUser(userID);
                    if (u.userType == User.UserType.ADMIN) {
                        Campaign c = vms.getCampaign(cid);
                        System.out.println(userID + " " + c.users.toString());
                    }
                    break;
                }
                case "getNotifications": {
                    User u = vms.getUser(userID);
                    if (u.userType == User.UserType.GUEST) {
                        System.out.print(userID + " ");
                        for (Notification n:u.notifications) {
                            System.out.print(n.toString(u.email));
                        }
                        System.out.println();
                    }
                    break;
                }
                case "cancelCampaign": {
                    i++;
                    int cid = Integer.parseInt(inputEvents[i]);

                    User u = vms.getUser(userID);
                    if (u.userType == User.UserType.ADMIN) {
                        vms.cancelCampaign(cid,SytemTime);
                    }
                    break;
                }
                case "addCampaign": {
                    i++;
                    int cid = Integer.parseInt(inputEvents[i]);
                    i++;
                    String name = inputEvents[i];
                    i++;
                    String descriptions = inputEvents[i];
                    i++;
                    LocalDateTime start = LocalDateTime.parse(inputEvents[i], formatter);
                    i++;
                    LocalDateTime finish = LocalDateTime.parse(inputEvents[i], formatter);
                    i++;
                    int total = Integer.parseInt(inputEvents[i]);
                    i++;
                    String strategy = inputEvents[i];
                    Campaign c = new Campaign(cid, name, descriptions, start, finish,strategy, total, SytemTime);
                    if (vms.getUser(userID).userType == User.UserType.ADMIN)
                        vms.addCampaign(c);
                    break;
                }
                case "editCampaign": {
                    i++;
                    int cid = Integer.parseInt(inputEvents[i]);
                    i++;
                    String name = inputEvents[i];
                    i++;
                    String descriptions = inputEvents[i];
                    i++;
                    LocalDateTime start = LocalDateTime.parse(inputEvents[i], formatter);
                    i++;
                    LocalDateTime finish = LocalDateTime.parse(inputEvents[i], formatter);
                    i++;
                    int total = Integer.parseInt(inputEvents[i]);
                    Campaign c = new Campaign(cid, name, descriptions, start, finish, "A", total, SytemTime);
                    if (vms.getUser(userID).userType == User.UserType.ADMIN)
                        vms.updateCampaign(cid, c, SytemTime);
                    break;
                }

                case "addVouchers": {
                    i++;
                    int cid = Integer.parseInt(inputEvents[i]);
                    User u = vms.getUser(userID);
                    if(u.userType == User.UserType.ADMIN)
                    {
                        addVouchers(cid,vms,Emails);
                        System.out.println("Muie");
                    }

                    break;
                }
            }
        }
    }

    public static void addVouchers(int Cid, VMS vms, String emails)
    {
        String emailsData[] = emails.split("[\\r\\n\\r\\;]");

        Campaign c = vms.getCampaign(Cid);

        for (int i = 2; i < emailsData.length; i++)
        {
            System.out.println(emailsData[i] + " " + i);
            String email = emailsData[i];
            i++;
            System.out.println(emailsData[i] + " " + i);
            String type = emailsData[i];
            i++;
            System.out.println(emailsData[i] + " " + i);
            int value = Integer.parseInt(emailsData[i]);
            i++;

            if(vms.getUser(email) != null)
                c.generateVoucher(email,type,value);

        }
    }
}
