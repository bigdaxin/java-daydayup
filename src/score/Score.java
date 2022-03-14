package score;

public class Score<T> {
    String name;
    Integer age;
    T score;

    public Score(String name, Integer age, T score){
        this.name = name;
        this.age = age;
        this.score = score;

    }


    public T getScore() {
        return score;
    }
}
