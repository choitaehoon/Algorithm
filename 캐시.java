package 카카오;

public class 캐시
{
    public static String[] move(String[] temp, String insert)
    {
        for(int i=0 ; i<temp.length-1; ++i)
            temp[i] = temp[i+1];
        temp[temp.length-1] = insert;
        return temp;
    }

    public static int lru(int cache, String[] temp)
    {
        int sum = 0; //실행시간 축적 변수
        String [] storage = new String[cache]; //캐시를 집어 넣을 String[] 변수
        boolean check = false;

        if(cache == 0) //캐시 크기가 0이라면
            return sum = 5 * temp.length;
        else
        {
            for(int i=0; i<storage.length; ++i) //캐시 넣는 과정
            {
                storage[i] = temp[i];
                sum += 5; //캐시 크기 까지 실행시간은 5 이므로
            }

            for(int i=storage.length; i<temp.length; ++i) //캐시 다음 부터 검사
            {
                for(int j=0; j<storage.length; ++j)
                    if(temp[i].equalsIgnoreCase(storage[j]))
                    {
                        sum += 1; //같은게 있으면 실행시간 +1
                        check = true;
                        break;
                    }
                 if(!check)
                 {
                     storage = move(storage,temp[i]);
                     sum += 5;
                 }
                 check = false; //초기화
            }
        }
        return sum;
    }

    public static void main(String[] args)
    {

        String [] temp1 = {"Jeju", "Pangyo", "Seoul", "NewYork","LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        String [] temp2 = {"Jeju", "Pangyo", "Seoul", "Jeju","Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
        String [] temp3 = {"Jeju", "Pangyo", "Seoul","NewYork","LA","SanFrancisco","Seoul","Rome","Paris","Jeju","NewYork","Rome"};
        String [] temp4 = {"Jeju", "Pangyo", "Seoul","NewYork","LA"};
        System.out.println(lru(3,temp1));
        System.out.println(lru(3,temp2));
        System.out.println(lru(3,temp3));
        System.out.println(lru(0,temp4));
    }
}
