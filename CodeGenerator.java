public class CodeGenerator {
    public String generateCode(int n)
    {
        String Characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            int index = (int)(Characters.length() * Math.random());
            sb.append(Characters.charAt(index));
        }
        return sb.toString();
    }
}
