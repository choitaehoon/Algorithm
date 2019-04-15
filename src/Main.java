import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        int n = 3;
//        int[] v= {0,1,2,2};
//        int[] ex = {2,2,0,1};

//        int n = 2;
//        int[] v= {0,1};
//        int[] ex = {1,0};

        int n = 5;
        int[] v= {};
        int[] ex = {};

        System.out.println(solution(n,v,ex));
    }

    public static int solution(int n, int[] v, int[] ex){
        //길이가 없는 경우 0 리턴
        if (v.length == 0)
            return 0;

        Vote[] votes = new Vote[v.length];
        int[] store = new int[v.length];
        int[] temp = new int[v.length];

        for (int i=0; i<store.length; ++i) {
            store[ex[i]]++;
            temp[v[i]]++;
        }

        for (int i=0; i<votes.length; ++i)
            votes[i] = new Vote(i, temp[i], store[i]);

        Arrays.sort(votes);


        if (votes[0].vote != votes[1].vote)
            return votes[0].vote;
        if (votes[0].voteNumber != votes[1].voteNumber)
            return votes[0].voteNumber;
        else
            return votes[0].number;
    }
}

class Vote implements Comparable<Vote> {
    int number ;
    int vote;
    int voteNumber;

    public Vote(int number, int vote, int voteNumber) {
        this.number = number;
        this.vote = vote;
        this.voteNumber = voteNumber;
    }

    @Override
    public int compareTo(Vote o) {
        int r = o.vote - this.vote;
        if (r != 0) return r;
        int m = o.voteNumber - this.voteNumber;
        if (m != 0) return m;
        return this.number - o.number;
    }
}