package domini;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.*;

public class Ranking {
    Map<String,Integer> map = new HashMap<String,Integer>();



    public void addUsuariGuanyador(String nom){
        if(!map.containsKey(nom)){
            map.put(nom,1);
        }
        else{
            map.get(nom);

        }


    }

}
