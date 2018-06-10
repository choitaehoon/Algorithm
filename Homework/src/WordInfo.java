public class WordInfo implements Comparable<WordInfo>{
    String word;
    int count;

    public WordInfo(String word,int count) {
        this.word = word;
        this.count = count;
    }

    @Override
    public boolean equals(Object e) {
        WordInfo obj=(WordInfo)e;
        if(this.word.equals(obj.word)) return true;
        else return false;
    }
    @Override
    public int compareTo(WordInfo value) {
        return this.word.compareTo(value.word);
    }

}
