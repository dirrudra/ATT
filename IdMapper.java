import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class IdMapper {

    public static HashMap<String, String[]> personMapper(String lines[]){
        HashMap<String, String[]> personMap = new HashMap<>();
        for(String line : lines)
        {
            String[] parts = line.split("\\|");
            for (int i = 0; i < parts.length; i++) {
                parts[i] = parts[i].trim();
            }
            String id = parts[0];
            String[] details = new String[]{parts[1], parts[2], parts[3], parts[4]};
            personMap.put(id, details);
        }
        return personMap;
    }

    public static Map<String, int[]> numberMapper (String lines[]){
        
        Map<String, int[]> numbersMap = new HashMap<>();

        for (String line : lines) {
            String[] parts = line.split("\\|");
            for (int i = 0; i < parts.length; i++) {
                parts[i] = parts[i].trim();
            }
            String id = parts[0];
            int number1 = Integer.parseInt(parts[1]);
            int number2 = Integer.parseInt(parts[2]);
            numbersMap.put(id, new int[]{number1, number2});
        }
        return numbersMap;
    }

    
    public static void main(String[] args) {

        System.out.println("Enter the number of lines of users");

        Scanner sc = new Scanner(System.in); 

        int users = sc.nextInt();
        
        String[] lines1 = new String[users];
        
        sc.nextLine();
        for(int i=0; i <users; i++){
            
            lines1[i] = sc.nextLine();
        }
        sc.nextLine();

        System.out.println("enter the phone numbers for each id");

        String[] lines2 = new String[users];

        for(int i=0; i <users; i++){
            lines2[i] = sc.nextLine();
        }

        Map<String, String[]> personMap = new HashMap<>();

        personMap = personMapper(lines1);

        Map<String, int[]> numbersMap = new HashMap<>();

        numbersMap = numberMapper(lines2);
        
        for (String id : numbersMap.keySet()) {
            if (personMap.containsKey(id)) {
                String[] details = personMap.get(id);
                int[] numbers = numbersMap.get(id);
                System.out.println("ID: " + id + ", Details: " + String.join(", ", details) 
                                   + ", Numbers: " + numbers[0] + ", " + numbers[1]);
            } else {
                System.out.println("ID: " + id + " has numbers but no corresponding person details.");
            }
        }
    }
}
