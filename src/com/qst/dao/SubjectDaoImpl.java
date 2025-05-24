package com.qst.dao;

import com.qst.pojo.Subject;
import com.qst.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author qst
 *
 * 题目数据访问实现类
 *
 */
public class SubjectDaoImpl implements ISubjectDao{

    @Override
    public List<Subject> listSubject(Integer questionnaireId) {
        List<Subject> subjectList=new ArrayList<>();
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        //加载驱动
        try {
            conn=DBUtil.getConn();
            String sql="SELECT subject_id,subject_title,choice_one,choice_two,choice_three,choice_four,questionnaire_id FROM subject"
                    + " WHERE questionnaire_id=?";
            //3.获取预处理对象
            pstmt=conn.prepareStatement(sql);
            //给参数赋值
            pstmt.setInt(1, questionnaireId);
            //4.执行sql语句.
            rs=pstmt.executeQuery();
            while(rs.next()) { //通过循环遍历所有数据
                Subject subject=new Subject();
                subject.setChoiceFour(rs.getString("choice_four"));
                subject.setChoiceOne(rs.getString("choice_one"));
                subject.setChoiceThree(rs.getString("choice_three"));
                subject.setChoiceTwo(rs.getString("choice_two"));
                subject.setQuestionnaireId(rs.getInt("questionnaire_id"));
                subject.setSubjectId(rs.getInt("subject_id"));
                subject.setSubjectTitle(rs.getString("subject_title"));
                subjectList.add(subject);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {//5.资源得释放
            DBUtil.closeAll(conn, pstmt, rs);
        }
        return subjectList;
    }

    @Override
    public int addSubject(Subject subject) {
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        //加载驱动
        try {
            conn= DBUtil.getConn();
            String sql="INSERT INTO subject(subject_title, choice_one, choice_two, choice_three, choice_four,questionnaire_id) "
                    + "VALUES(?,?,?,?,?,?)";
            //3.获取预处理对象
            pstmt=conn.prepareStatement(sql);
            //给参数赋值
            pstmt.setString(1, subject.getSubjectTitle());
            pstmt.setString(2, subject.getChoiceOne());
            pstmt.setString(3, subject.getChoiceTwo());
            pstmt.setString(4, subject.getChoiceThree());
            pstmt.setString(5, subject.getChoiceFour());
            pstmt.setInt(6, subject.getQuestionnaireId());
            //4.执行sql语句.
            return pstmt.executeUpdate();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {//5.资源得释放
            DBUtil.closeAll(conn, pstmt, rs);
        }
        return 0;
    }

}
