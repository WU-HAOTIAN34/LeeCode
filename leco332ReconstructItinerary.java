

import java.util.*;



public class leco332ReconstructItinerary {
    public static void main(String[] args) {
        Solution332 s = new Solution332();
        List<List<String>> res = new ArrayList<>();
        res.add(Arrays.asList("MUC","LHR"));
        res.add(Arrays.asList("JFK","MUC"));
        res.add(Arrays.asList("SFO","SJC"));
        res.add(Arrays.asList("LHR","SFO"));
        s.findItinerary(res);
    }

}


class Solution332 {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        Collections.sort(tickets, (a, b) -> a.get(1).compareTo(b.get(1)));
        for (int i=0; i<tickets.size(); i++){
            if (!map.containsKey(tickets.get(i).get(0))){
                map.put(tickets.get(i).get(0), new ArrayList<String>());
            }
            map.get(tickets.get(i).get(0)).add(tickets.get(i).get(1));
        }

        res.add("JFK");
        dps(res, map, tickets.size());
        return res;
    }

    public boolean dps(List<String> res, Map<String, List<String>> map, int num){
        if (res.size()-1==num){
            return true;
        }else{
            String depart = res.get(res.size()-1);
            List<String> arrival = new ArrayList<>();
            if (map.get(depart) != null){
                arrival = new ArrayList<>(map.get(depart));
            }
            for (String s : arrival){
                res.add(s);
                map.get(depart).remove(s);
                boolean bool = dps(res, map, num);
                if (bool){
                    return true;
                }
                res.remove(res.size()-1);
                map.get(depart).add(s);
            }
            return false;
        }
    }
}