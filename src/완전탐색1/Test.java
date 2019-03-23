package 완전탐색1;

import java.util.*;

public class Test
{
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("a",1);
        map.put("b",2);
        map.put("c",3);

        System.out.println("------------sort 전 -------------");
        System.out.println(map);

        Iterator it = Test.sortByValue(map).iterator();


        System.out.println("---------sort 후------------");
        while(it.hasNext()){
            String temp = (String) it.next();
            System.out.println(temp + " = " + map.get(temp));
        }
        //System.out.println(map);
    }

    public static List sortByValue(final Map map){
        List<String> list = new ArrayList();
        list.addAll(map.keySet());
        Collections.sort(list,new Comparator(){

            public int compare(Object o1,Object o2){
                Object v1 = map.get(o1);
                Object v2 = map.get(o2);

                return ((Comparable) v1).compareTo(v2);
            }

        });
        Collections.reverse(list); // 주석시 오름차순
        return list;
    }


}