package com.pojo.step3;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class ActionSupport extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger(ActionSupport.class);
	protected void doService(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		 logger.info("doService 호출");
		    String uri = req.getRequestURI();
		    logger.info(uri); 
		    String context = req.getContextPath();
		    logger.info(context); 
		    String command = uri.substring(context.length() + 1);
		    int end = command.lastIndexOf(".");
		    command = command.substring(0, end);
		    String upmu[] = null;
		    upmu = command.split("/");
		    logger.info(upmu[0] + "," +upmu[1]);
			req.setAttribute("upmu", upmu);
			Object obj = "";
			try {
				obj = HandlerMapping.getController(upmu, req, res);
			} catch (Exception e) {
				logger.info("Exception : " + e.toString());
			}
			if(obj != null) {
				String pageMove[] = null;
				ModelAndView mav = null;
				if(obj instanceof String) {
					if(((String) obj).contains(":")){
						logger.info(": 포함되어 있어요");
						pageMove = obj.toString().split(":");
					}else {
						logger.info(": 포함되어 있지 않아요");
						pageMove = obj.toString().split("/");
					}
					logger.info(pageMove[0]+","+pageMove[1]);
				} else if (obj instanceof ModelAndView) {
					mav = (ModelAndView)obj;
					pageMove = new String[2]; //페이지에 대한 방 두개 생성
					pageMove[0] = "forward";
					pageMove[1] = mav.getViewName();
					
				}
				if(pageMove !=null) {
					String path = pageMove[1];
					if ("redirect".equals(pageMove[0])) {
			            res.sendRedirect(path);
			         } else if("forward".equals(pageMove[0])){
			            RequestDispatcher view = req.getRequestDispatcher("/"+path+".jsp");
			            view.forward(req, res);
			         }else {
			        	 path = pageMove[0]+","+pageMove[1];
			        	 RequestDispatcher view = req.getRequestDispatcher("/WEB-INF/view/"+path+".jsp");
				            view.forward(req, res);
			         }
				}
			}//end of 페이지 이동처리에 대한 공통 코드 부분
		}
		
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			logger.info("doGet호출");
			doService(req,res);

		}

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			logger.info("doPost호출");
			doService(req,res);
		}
	}
