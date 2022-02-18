import java.util.*;

/**
 * Copyright (C), Peter GUAN
 * FileName: ReconstructItinerary
 * Author:   Peter
 * Date:     12/02/2022 09:54
 * Description: https://leetcode-cn.com/problems/reconstruct-itinerary/
 * History:
 * Version:
 */
public class ReconstructItinerary  {
    private Deque<String> res;
    private Map<String, Map<String, Integer>> map;

    public List<String> findItinerary(List<List<String>> tickets) {
        map = new HashMap<String, Map<String, Integer>>(); // {start: {end: number of flight}}
        res = new LinkedList<>();

        for (List<String> ticket : tickets) {
            Map<String, Integer> temp;
            if (map.containsKey(ticket.get(0))) {
                temp = map.get(ticket.get(0));
                temp.put(ticket.get(1), temp.getOrDefault(ticket.get(1), 0) + 1);
            } else {
                // todo: Check the document of treemap.
                temp = new TreeMap<>(); // 升序Map
                temp.put(ticket.get(1), 1);
            }
            map.put(ticket.get(0), temp);
        }

        res.add("JFK");
        backTracking(tickets.size());
        return new ArrayList<>(res);
    }

    private boolean backTracking(int ticketNum) {
        if (res.size() == ticketNum + 1) {
            return true;
        }
        String last = res.getLast();
        if (map.containsKey(last)) { // avoid null
            for (Map.Entry<String, Integer> target : map.get(last).entrySet()) {
                int count = target.getValue();
                if (count > 0) {
                    res.add(target.getKey());
                    target.setValue(count - 1);
                    if (backTracking(ticketNum)) {
                        return true;
                    }
                    res.removeLast();
                    target.setValue(count);
                }
            }
        }
        return false;
    }

}





















