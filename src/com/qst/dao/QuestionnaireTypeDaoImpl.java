package com.qst.dao;

import com.qst.pojo.QuestionnaireType;
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
 * 知识胶囊访问实现类
 *
 */
public class QuestionnaireTypeDaoImpl implements IQuestionnaireTypeDao{


    @Override
    public List<QuestionnaireType> listAllQuestionnaireType() {
        List<QuestionnaireType> questionnaireTypeList=new ArrayList<>();
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        //加载驱动
        try {
            conn= DBUtil.getConn();
            String sql="SELECT questionnairetype_id,questionnairetype_desc FROM questionnairetype";
            //3.获取预处理对象
            pstmt=conn.prepareStatement(sql);
            //给参数赋值

            //4.执行sql语句.
            rs=pstmt.executeQuery();
            while(rs.next()) { //通过循环遍历所有数据
                QuestionnaireType questionnaireType=new QuestionnaireType();
                questionnaireType.setQuestionnaireTypeDesc(rs.getString("questionnairetype_desc"));
                questionnaireType.setQuestionnaireTypeId(rs.getInt("questionnairetype_id"));
                questionnaireTypeList.add(questionnaireType);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {//5.资源得释放
            DBUtil.closeAll(conn, pstmt, rs);
        }
        return questionnaireTypeList;
    }
}
