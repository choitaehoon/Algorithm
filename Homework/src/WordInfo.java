public class WordInfo
{
    String word;
    int count;

    public WordInfo(String word, int count) {
        this.word = word;
        this.count = count;
    }

    public String toString()
    {
        return word+" "+count;
    }

}
