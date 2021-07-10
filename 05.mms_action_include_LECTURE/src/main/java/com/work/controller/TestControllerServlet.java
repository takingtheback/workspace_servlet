package com.work.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.work.dao.FactoryDao;

public class TestControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FactoryDao factory = FactoryDao.getInstance();
		System.out.println(factory);
		
		Connection conn = factory.getConnection();
		System.out.println(conn);
		
	}

}
