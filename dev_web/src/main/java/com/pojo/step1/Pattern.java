package com.pojo.step1;

public class Pattern {

	public static void main(String[] args) {
		// String url = "/dev_web/업무 이름/페이지 또는 요청 이름";
		String url = "/dev_web/dept/getDeptList.kh";
		String context = "dev_web/";
		// 톰캣 서버에 요청할 때 사용되는 주소값을 가지고 엄무명과 업무에 필요한 이름으로
		// 분리시켜 사용자 요청에 따라 처리를 담당할 XXXController 객체 주입에 사용
		String command = url.substring(context.length() + 1);
		System.out.println(command);
		int end = command.lastIndexOf(".");
		System.out.println(end);
		command = command.substring(0, end);
		System.out.println(command);
		String upmu[] = null;
		upmu = command.split("/");
		// split을 사용하여 / 기준으로 글자 잘라내기
		for (String imsi: upmu) {
			System.out.println(imsi);
			
		}
	}

}
