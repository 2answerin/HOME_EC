package com.pojo.step3;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import com.util.HashMapBinder;
public class Board3Controller implements Controller3 {
   Logger logger = Logger.getLogger(Board3Controller.class);
   Board3Logic boardLogic = new Board3Logic();
   @Override
   public ModelAndView boardList(HttpServletRequest req, HttpServletResponse res) {
      logger.info("boardList호출");
      List<Map<String, Object>> bList = null;
      // 사용자가 조건 검색을 원하는 경우 - 조건 값을 전달할 객체 생성함
      // MyBatis에서는 동적쿼리를 지원하므로 하나로 2가지 경우 사용 가능함
      Map<String, Object> pMap = new HashMap<>(); //값이 담겨있지 않음 생성만 되어있음
      HashMapBinder hmb = new HashMapBinder(req);
      hmb.bind(pMap); //여기서 값이 담김
      bList = boardLogic.boardList(pMap);
      ModelAndView mav = new ModelAndView(req);
      mav.setViewName("board3/boardList");
      mav.addObject("bList", bList);
      return mav;
   }
   @Override
   public Object jsonBoardList(HttpServletRequest req, HttpServletResponse res) {
      logger.info("jsonBoardList호출");
      List<Map<String, Object>> bList = null;
      Map<String, Object> pMap = new HashMap<>();
      bList = boardLogic.boardList(pMap);
      req.setAttribute("bList", bList);
      return "forward:jsonBoardList.jsp";
   }
   @Override
   public Object boardDetail(HttpServletRequest req, HttpServletResponse res) {
      logger.info("boardDetail호출");
      List<Map<String, Object>> bList = null;
      // 전체 조회에 대한 sql문 재사용 가능함 - 1건 조회 경우
      Map<String, Object> pMap = new HashMap<>();
      HashMapBinder hmb = new HashMapBinder(req);
      hmb.bind(pMap);
      bList = boardLogic.boardDetail(pMap);
      logger.info(bList);
      req.setAttribute("bList", bList);
      return "forward:board3/boardDetail";
   }
   /*
    * INSERT INTO board_master_t(bm_no, bm_title, bm_writer, bm_content, bm_reg,
    * bm_hit, bm_group, bm_pos, bm_step) VALUES (seq_board_no.nextval, #{bm_title},
    * #{bm_writer}, to_char(sysdate, 'YYYY-MM-DD'), 0, #{bm_group}, #{bm_pos},
    * #{bm_step}) 화면에서 받아올 값 - bm_title, bm_writer, 그렇지 않은 경우 - bm_group, bm_pos,
    * bm_step, bm_reg
    */
   @Override
   public Object boardInsert(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
      logger.info("boardInsert 호출");
      int result = 0;
      // 폼태그 안에 사용자가 입력한 정보 (bm_wirter, bm_title, bm_content...) 받아옴
      // req.getParameter("bm_writer");
      // req.getParameter("bm_title");
      // req.getParameter("bm_content");
      // req.getParameter("?");
      // req.getParameter("?");
      // req.getParameter("?");
      Map<String, Object> pMap = new HashMap<>();
      logger.info("before : " + pMap);
      HashMapBinder hmb = new HashMapBinder(req);
      hmb.multiBind(pMap);
      logger.info("after : " + pMap);
      result = boardLogic.boardInsert(pMap);
      String path = "";
      if (result == 1) {
         path = "redirect:/board3/boardList.st3";
      } else {
         path = "boardInsertFail.jsp";
         res.sendRedirect(path);
      }
      return path;
   }
   @Override
   public Object boardUpdate(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
      logger.info("boardUpdate 호출");
      int result = 0;
      // insert here
      Map<String, Object> pMap = new HashMap<>();
      HashMapBinder hmb = new HashMapBinder(req);
      hmb.bind(pMap);
      logger.info(pMap); // pMap 뭐가 담기는지
      // result 값 (0 -> 1)의 변화를 주는 코드 추가 = DB연동
      result = boardLogic.boardMUpdate(pMap);
      String path = "";
      if (result == 1) {
         path = "redirect:/board3/boardList.st3";
      } else {
         path = "boardInsertFail.jsp";
         res.sendRedirect(path);
      }
      return "redirect:/board3/boardList.st3";
   }
   @Override
   public Object boardDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
      logger.info("boardDelete 호출");
      int result = 0;
      Map<String, Object> pMap = new HashMap<>();
      HashMapBinder hmb = new HashMapBinder(req);
      hmb.bind(pMap);
      // 삭제 성공 시
      result = boardLogic.boardDelete(pMap);
      String path = "";
      if (result == 1) {
         path = "redirect:/board3/boardList.st3";
      } else { // result가 0인 경우 else 타게 됨
         path = "redirect:/board3/boardInsertFail.jsp";
         res.sendRedirect(path);
      }
      return "redirect:/board3/boardList.st3";
   }
}