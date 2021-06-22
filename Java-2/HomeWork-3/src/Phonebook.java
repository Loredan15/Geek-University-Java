import java.util.*;

public class Phonebook {
    private Map<String, String> data = new HashMap<>();

    public void add(String surname, String phone){
        data.put(phone, surname);
    }
    public void get(String surname){
        Set<String> stringSet = new HashSet<>();
        for (Map.Entry<String, String> entry : data.entrySet()){
            if (Objects.equals(surname, entry.getValue())){
                stringSet.add(entry.getKey());
            }
        }
        System.out.println(stringSet);
    }
}
