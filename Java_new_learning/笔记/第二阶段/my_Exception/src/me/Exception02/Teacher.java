package me.Exception02;

public class Teacher {
    public void checkScore(int score) throws ScoreException {
        if (score < 0 || score > 100) {
//            throw new ScoreException();
            throw new ScoreException("分数有误");
        } else {
            System.out.println("成绩正常");
        }
    }
}
