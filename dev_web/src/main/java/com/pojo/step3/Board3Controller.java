package com.pojo.step3;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
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
      HashMapBinder hmb = new HashMapBinder(req);
      hmb.bind(pMap);
      bList = boardLogic.boardList(pMap);
      //오라클 연동 후에 조회 결과가 bList에 담겨있음
      //forward 할 때 그 주소번지를 저장해둠 - 화면에 접근 - 키값이 중요
      req.setAttribute("bList", bList);
      return "forward:board3/jsonBoardList";
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
      //result = boardLogic.boardInsert(pMap);
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
   //quill editor 에서 이미지 선택하면 업로드처리 - 물리적 위치 - 톰캣서버 - webapp\\pds
   //첨부파일 업로드 API는 cos.jar사용 - maven repo
   //1. 바이너리타입 코드 첨부할 때
   //2. 이미지파일 첨부할 때
   //첨부파일 처리(application[main]/*[sub])
   //파일크기 제한 5MB - 유효성 체크(UI에서 체크 5MB초과시 에러화면 처리 - 빠져나옴)
	@Override
	public Object imageUpload(HttpServletRequest req, HttpServletResponse res) {
		logger.info("imageUpload 호출 성공");
		//첨부파일 처리에 필요한 변수 선언
		//get방식 - header에 담김 - query string
		//post방식 - encType속성 - request.getPrarmeter("")사용자가 입력한 값을 읽을 수 없음
		MultipartRequest multi = null; //post이면서 첨부파일이 들어있는 형태인 경우 이 클래스 반드시 필요
		String realFolder = "D:\\KH_EC\\dev_web\\src\\main\\webapp\\pds";
		//첨부파일의 한글처리
		String encType = "utf-8";
		//첨부파일의 크기
		int maxSize = 50*1024*1024;//5MB
		try {
			//인스턴스화가 성공하자마자마자 pds폴더에 추가됨
			//@param1 - req 요청 - body에 담김
			//@param2 - 실제파일이 있는 물리적인 위치
			//@param3 - 첨부파일의 최대 크기
			//@param4 - 한글 인코딩 설정값
			//@param5 - 옵저버 > 같은 이름이 있을 경우 관찰하고 거기에 대한 대응값을 반환하기
			multi = new MultipartRequest(req, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
		//거의 즉시 업로드 됨 - 파일 크기가 크면 지연상태에 빠짐 - dead lock 상태 이어지지 않도록 조심
		} catch (Exception e) {
			logger.info("Exception : "+e.toString());
		}
		//String filename = boardLogic.imageUpload(multi, realFolder);
		Map<String,Object> rMap = boardLogic.imageUpload(multi, realFolder);
		logger.info(rMap);
		//Gson g = new Gson();
		//String temp = g.toJson(rMap);
		//logger.info(temp);
		//logger.info(g);
		String temp = "";
		temp = rMap.get("bs_file").toString()+","+rMap.get("bs_size").toString();
		logger.info(temp);
		return temp;
	}
	//process.env.REACT_APP_PUBLIC_URL+`board3/imageGet.st3?imageName=${res.data}`;
	//Quill Editor - 위지윜 기능 첨가 <p></p><img../> p태그로 감싸져있음
	//일단 이미지를 선택하면 pds에 먼저 업로드되고 그 이미지 경로를 참조해서 editor에 출력해줌
	//리턴타입이 널인 이유는 이미지 정보를 얻어오기 - 화면적으로 처리할 부분이 없다
	//에디터에서 이미지를 선택하면 bm_content컬럼에 img태그와 함께 이미지 정보에 대한 소스가 텍스트 형태로 저장됨
	//오라클 서버에 저장된 bm_content내용을 읽어서 브라우저에 출력해줌
	@Override
	public Object imageGet(HttpServletRequest req, HttpServletResponse res) {
		//imageName정보는 공통코드로 제공된 QuillEditor.jsx에서 파라미터로 넘어오는 값
		//imageUpload메소드에서 업로드 된 파일정보(파일명, 파일크기)가 리턴됨
		String b_file = req.getParameter("imageName");
		logger.info("imageGet 호출 성공===>"+b_file); //xxx.png가 찍혀야 함
		String filePath = "D:\\KH_EC\\dev_web\\src\\main\\webapp\\pds"; // 절대경로.	
		String fname = b_file;
		logger.info("b_file: 8->euc"+b_file);	
		//File은 내용까지 복제되는 것은 아니고 파일명만 객체화해줌 클래스
		File file = new File(filePath,b_file.trim());
	 	String mimeType = req.getServletContext().getMimeType(file.toString());
	 	logger.info(mimeType); //image, video, text .. 타입 확인
		if(mimeType == null){//마임타입이 널이면
			//아래 속성값으로 마임타입을 설정해줌
			//왜이렇게 하나요? 브라우저는 해석이 가능한 마임타입은 페이지 로딩 처리함
			//강제로 다운로드 처리를 위한 속성값 변경
			//브라우저에서 해석가능한 마임타입의 경우 화면에 그대로 출력이 되는 것을 방지하기 위해서 추가됨
			res.setContentType("application/octet-stream");
		}
		//다운로드 되는 파일 이름 담기
		String downName = null;
		//위 File 객체에서 생성된 객체에 내용을 읽기위한 클래스 선언
		FileInputStream fis = null;
		//응답으로 나갈 정보가 웹서비스에 처리되어야 하기에 사용한 객체
		ServletOutputStream sos = null;
		try{
			if(req.getHeader("user-agent").indexOf("MSIE")==-1){
				downName = new String(b_file.getBytes("UTF-8"),"8859_1");
			}else{
				downName = new String(b_file.getBytes("EUC-KR"),"8859_1");
			}
			//응답 헤더에 다운로드 될 파일명을 매핑하기
		   	res.setHeader("Content-Disposition", "attachment;filename="+downName);
		   	//위에서 생성된 파일 문자열 객체를 가지고 파일생성에 필요한 객체를 파라미터에 넘김
		 	fis = new FileInputStream(file);
			sos = res.getOutputStream();
			//파일 내용을 담을 byte 배열을 생성
			byte b[] = new byte[1024*10];
			int data = 0;
			while((data=(fis.read(b,0,b.length)))!=-1){
				//파일에서 읽은 내용을 가지고 실제 파일에 쓰기 처리함
				//여기서 처리된 브라우저를 통해서 내보내진다
				sos.write(b,0,data);
			}
			//처리한 내용이 버터에 있는데 이것을 모두 처리요청 하기
			//내보내고 버퍼를 비운다 - 버퍼 크기 작음 - 휘발성
			sos.flush();		
		}catch(Exception e){
			logger.info(e.toString());
		}finally{
			try {
				if(sos != null) sos.close();
				if(fis != null) fis.close();				
			} catch (Exception e2) {
			}
		}
		
		//byte[] fileArray = boardLogic.imageDownload(imageName);
		//logger.info(fileArray.length);
		return null;
	}// end of imageGet
	
	//download.jsp페이지의 내용과 같다
	public Object imageDownload(HttpServletRequest req, HttpServletResponse res) {
		logger.info("imageDownload 호출 성공");
		String b_file = req.getParameter("imageName");
		String filePath = "D:\\KH_EC\\dev_web\\src\\main\\webapp\\pds"; // 절대경로.	
		String fname = b_file;
		logger.info("b_file: 8->euc"+b_file);		
		File file = new File(filePath,b_file.trim());
	 	String mimeType = req.getServletContext().getMimeType(file.toString());
		if(mimeType == null){
			res.setContentType("application/octet-stream");
		}
		String downName = null;
		FileInputStream fis = null;
		ServletOutputStream sos = null;
		try{
			if(req.getHeader("user-agent").indexOf("MSIE")==-1){
				downName = new String(b_file.getBytes("UTF-8"),"8859_1");
			}else{
				downName = new String(b_file.getBytes("EUC-KR"),"8859_1");
			}
		   	res.setHeader("Content-Disposition", "attachment;filename="+downName);
		 	fis = new FileInputStream(file);
			sos = res.getOutputStream();
			byte b[] = new byte[1024*10];
			int data = 0;
			while((data=(fis.read(b,0,b.length)))!=-1){
				sos.write(b,0,data);
			}
			sos.flush();		
		}catch(Exception e){
			logger.info(e.toString());
		}finally{
			try {
				if(sos != null) sos.close();
				if(fis != null) fis.close();				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return null;
	}// end of imageDownload
	@Override
	public ModelAndView zipcodeList(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object login(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}
}