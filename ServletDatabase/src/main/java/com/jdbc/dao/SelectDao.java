package com.jdbc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.utils.DatabaseConnection;
import com.jdbc.vo.SelectVo;

public class SelectDao {
	
	public static List<SelectVo> getSelect(String databaseName, String userName, String password) {
		List<SelectVo> selectVos = new ArrayList<SelectVo>();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = DatabaseConnection.getConnection(databaseName, userName, password);
			StringBuilder sqlStringBuilder = new StringBuilder();
			sqlStringBuilder.append("select\r\n"
					+ "       score.stu_id,\r\n"
					+ "       s.stu_name,\r\n"
					+ "       s.stu_gender,\r\n"
					+ "       (select t.score from score as t where t.stu_id = score.stu_id and t.subject_id = (select subject.subject_id from subject where subject.subject_name = '�й���ѧ')) as '�й���ѧ',\r\n"
					+ "       (select t.score from score as t where t.stu_id = score.stu_id and t.subject_id = (select subject.subject_id from subject where subject.subject_name = '����')) as '����',\r\n"
					+ "       (select t.score from score as t where t.stu_id = score.stu_id and t.subject_id = (select subject.subject_id from subject where subject.subject_name = '��ѧ')) as '��ѧ',\r\n"
					+ "       (select t.score from score as t where t.stu_id = score.stu_id and t.subject_id = (select subject.subject_id from subject where subject.subject_name = 'java')) as 'java',\r\n"
					+ "       (select t.score from score as t where t.stu_id = score.stu_id and t.subject_id = (select subject.subject_id from subject where subject.subject_name = '����')) as '����'\r\n"
					+ "       from score right join student s on score.stu_id = s.stu_id group by score.stu_id;");
			statement = DatabaseConnection.getStatement(connection);
			resultSet = statement.executeQuery(sqlStringBuilder.toString());
			
			while (resultSet.next()) {
				SelectVo selectVo = new SelectVo();
				
				selectVo.setStuId(resultSet.getInt("stu_id"));
				if (null != resultSet.getString("stu_name")) selectVo.setStuName(resultSet.getString("stu_name"));
				if (null != resultSet.getString("stu_gender")) selectVo.setStuGender(resultSet.getString("stu_gender"));
				selectVo.setChinese(resultSet.getInt("�й���ѧ"));
				selectVo.setForeign(resultSet.getInt("����"));
				selectVo.setHeart(resultSet.getInt("��ѧ"));
				selectVo.setJava(resultSet.getInt("java"));
				selectVo.setPhysics(resultSet.getInt("����"));
				
				selectVos.add(selectVo);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return selectVos;
	}
}