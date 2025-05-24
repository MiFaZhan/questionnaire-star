package com.qst.dao;

import com.qst.pojo.Questionnaire;
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
 * 问卷数据访问实现类
 *
 */
public class QuestionnaireDaoImpl implements IQuestionnaireDao{

    @Override
    public List<Questionnaire> listAllQuestionnaire(Integer questionnaireTypeId) {
        List<Questionnaire> questionnaireList=new ArrayList<>();
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        //加载驱动
        try {
            conn=DBUtil.getConn();
            String sql="SELECT questionnaire_id,questionnaire_title,questionnairetype_id FROM questionnaire WHERE questionnairetype_id=?";
            //3.获取预处理对象
            pstmt=conn.prepareStatement(sql);
            //给参数赋值
            pstmt.setInt(1, questionnaireTypeId);
            //4.执行sql语句.
            rs=pstmt.executeQuery();
            while(rs.next()) { //通过循环遍历所有数据
                Questionnaire questionnaire=new Questionnaire();
                questionnaire.setQuestionnaireId(rs.getInt("questionnaire_id"));
                questionnaire.setQuestionnaireTitle(rs.getString("questionnaire_title"));
                questionnaire.setQuestionnaireTypeId(rs.getInt("questionnairetype_id"));
                questionnaireList.add(questionnaire);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {//5.资源得释放
            DBUtil.closeAll(conn, pstmt, rs);
        }
        return questionnaireList;
    }

    @Override
    public int addQuestionnaire(Questionnaire questionnaire) {
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        //加载驱动
        try {
            conn=DBUtil.getConn();
            String sql="INSERT INTO questionnaire(questionnaire_title, questionnairetype_id) VALUES(?,?)";
            //3.获取预处理对象
            pstmt=conn.prepareStatement(sql);
            //给参数赋值
            pstmt.setString(1, questionnaire.getQuestionnaireTitle());
            pstmt.setInt(2, questionnaire.getQuestionnaireTypeId());
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

    @Override
    public List<Integer> queryNumByType() {
        List<Integer> numList=new ArrayList<>();
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        //加载驱动
        try {
            conn=DBUtil.getConn();
            String sql="SELECT count(q.questionnaire_id) num "
                    + "	FROM questionnaire q RIGHT JOIN questionnairetype qt ON q.questionnairetype_id=qt.questionnairetype_id "
                    + "	GROUP BY qt.questionnairetype_desc ORDER BY qt.questionnairetype_desc";
            //3.获取预处理对象
            pstmt=conn.prepareStatement(sql);
            //给参数赋值
            //4.执行sql语句.
            rs=pstmt.executeQuery();
            while(rs.next()) { //通过循环遍历所有数据
                numList.add(rs.getInt("num"));
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {//5.资源得释放
            DBUtil.closeAll(conn, pstmt, rs);
        }
        return numList;
    }

}
