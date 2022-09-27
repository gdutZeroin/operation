package operation;

import java.io.File;

public class check_result {
    public check_result(answer_result answerResult)//构造函数
    {
        answer_result a_s=answerResult;//传入回答问题类，调用回答问题函数来判断答案是否正确
        File exercise=new File("src\\resourse\\exercise.txt");//题目文件
        File answer=new File("src\\resourse\\answer.txt");//答案文件
        File grade=new File("src\\resourse\\grade.txt");//分数文件
    }

    public void check()//输入题目文件和答案文件，调用回答问题函数判断答案是否正确，输出grade文件
    {

    }
}
