package operation;

public class Mainclass {
    public static void main(String[] args) {
        generate_exercise g_e=new generate_exercise();//生成题目类
        answer_result a_r=new answer_result();//回答问题类
        output_result o_r=new output_result();//输出结果到exercise.txt和answer.txt类
        check_result c_r=new check_result(a_r);//检查答案并输出到grade.txt类
        int exercise_num;//生成题目个数
        int limit_num;//界定生成数范围
        String exercise;//一个题目
        String answer;//一个答案


        //输入生成题目个数n

        //输入界定生成数范围

        //进行n次以下操作
        /*for(int i=0;i<exercise_num;i++)
        {
            exercise=g_e.generate(limit_num);//生成一个题目
            answer=a_r.answer(exercise);//生成答案
            if(answer==null)
                continue;//如果返回答案是空（为负数），则跳过这次循环
            o_r.output(exercise,answer);//输出到题目与答案文件
        }*/

        //判断答案是否正确，输出分数到grade.txt
        //c_r.check();
    }
}
