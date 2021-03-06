package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.jdbc.dao.SelectDao;
import com.jdbc.vo.SelectVo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Index
 */
@WebServlet(urlPatterns = {
	"/select"
})
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Index() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
//		doPost(request, response);
//		
//		response.setContentType("text/html;charset=utf-8");
//		PrintWriter writer = response.getWriter();
//		
//		List<SelectVo> select = SelectDao.getSelect("day_41", "root", "rootroot");
//		
//		for (SelectVo selectVo : select) {
//			System.out.println(selectVo);
//			writer.write(selectVo.toString()+ "<br>");
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		/*
		 * response.setContentType("text/html;charset=utf-8"); PrintWriter writer =
		 * response.getWriter();
		 * 
		 * List<SelectVo> select = SelectDao.getSelect("day_41", "root", "rootroot");
		 * writer.print(select.toString());
		 */
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();
		
		List<SelectVo> select = SelectDao.getSelect("day_41", "root", "rootroot");
		
		for (SelectVo selectVo : select) {
			System.out.println(selectVo);
			writer.write(selectVo.toString()+ "<br>");
		}
	}

}
