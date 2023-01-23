
package com.js.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.js.dao.BookCRUD;

public class DeleteBook extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	BookCRUD bc=new BookCRUD();
	if(bc.DeleteBookBYId(Integer.parseInt(req.getParameter("id")))>0) {
		RequestDispatcher rd=req.getRequestDispatcher("view");
		rd.forward(req, resp);
	}else {
		RequestDispatcher rd=req.getRequestDispatcher("result.jsp");
		req.setAttribute("msg", "THERE IS NO BOOK IN THAT ID");
		rd.forward(req, resp);
	}
}

}

