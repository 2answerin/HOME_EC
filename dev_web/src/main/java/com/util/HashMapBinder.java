package com.util;
import java.io.File;
import java.util.Enumeration;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
// Spring 부트에서는 RequestParam 대신 해 줌(gooood) Model, ModelMap
// 사용자가 입력한 값을 Map에 담음
// 담을 Map은 컨트롤 계층에서 bind 메서드 호출 시 파라미터를 이용해 원본 주소 번지 받아옴 -> 그 안에 담는다
public class HashMapBinder {
    Logger logger = Logger.getLogger(HashMapBinder.class);
    // 표준 요청 객체
    HttpServletRequest req = null; // 전변
    // cos.jar에서 제공하는 요청 객체 - 첨부 파일로 post이면서 encType 속성이 적용된 경우 사용
    MultipartRequest multi = null;
    // 첨부 파일의 업로드 물리적인 경로
    String realFolder = null;
    // 첨부 파일 한글 처리
    String encType = "UTF-8";
    // 첨부 파일 최대 크기
    int maxSize = 5 * 1024 * 1024;
    public HashMapBinder() {
    }
    // 생성자 파라미터에 요청 객체가 필요한 이유 ??
    // 뭐죠? 호죠? 포죠? 포뇨?
    public HashMapBinder(HttpServletRequest req) {
        // 생성자의 역할 1 ; 전변의 초기화
        this.req = req;
        realFolder = "D:\\KH_EC\\dev_web\\src\\main\\webapp\\pds";
    }
    public void multiBind(Map<String, Object> pMap) {
        // 컨트롤 게층에서 생성한 맵 객체 초기화
        pMap.clear();
        try {
            multi = new MultipartRequest(req, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
        } catch (Exception e) {
            // 발생한 예외 이름 출력
            logger.info(e.toString());
        }
        Enumeration<String> en = multi.getParameterNames();
        while (en.hasMoreElements()) {
            String key = en.nextElement();
            pMap.put(key, multi.getParameter(key));
        }
        // 첨부 파일에 대한 정보 받아오기
        Enumeration<String> files = multi.getFileNames(); // n개 처리 가능
        if (files != null) {
            // 업로드 대상 파일을 객체로 만듦
            File file = null; // 내용까지 복제되는 것은 아님 - 파일명만 객체화
            while (files.hasMoreElements()) {
                String fname = files.nextElement();
                String filename = multi.getFilesystemName(fname);
                pMap.put("bs_file", filename);
                if (filename != null && filename.length() > 1) {
                    file = new File(realFolder + "\\" + filename);
                }
                logger.info(file);
            } // end while
                // 첨부 파일에 크기를 담을 수 있는 변수 선언
            double size = 0;
            if (files != null) {
                size = file.length(); // 파일 크기를 byte 단위로 담음
                size = size / 1024.0; // byte -> kbyte
                pMap.put("bs_size", size);
            }
        } // end if
    }
    // 어떤 페이지 어떤 상황에서 공통 코드 재사용 가능하게 할 것 ?
    // 업무별 요청 클래스에서 주입 받을 객체를 정해 메서드의 파라미터로 전달 받음
    // 전달 받은 주소 번지 원본에 값을 담음
    public void bind(Map<String, Object> pMap) {
        logger.info("bind 호출");
        pMap.clear();
        Enumeration<String> en = req.getParameterNames();
        while (en.hasMoreElements()) {
            String key = en.nextElement();
            pMap.put(key, req.getParameter(key));
        }
    }
}