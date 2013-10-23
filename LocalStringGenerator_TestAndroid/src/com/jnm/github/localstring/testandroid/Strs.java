package com.jnm.github.localstring.testandroid;

import java.util.Hashtable;

public class Strs { 
	private static final String DefaultLanguageISO = "en";

	private static String sCurLanguageISO = DefaultLanguageISO;
	public static void setCurLanguageISO(String pCurLanguageISO) {
		sCurLanguageISO = pCurLanguageISO;
	}

	public static String u(String pString) {  
		return pString; 
	}

	public static class LocalString {
		private Hashtable<String, String> mStrs = new Hashtable<String, String>();
		public void str(String pLang, String pText) {
			mStrs.put(pLang, pText);
		}
		public String get() {
			return getFromLang(sCurLanguageISO);
		}
		public String get(Object ...args) {
			return getFromLang(sCurLanguageISO, args);
		}
		public String getFromLang(String pLang) {
			String ret = mStrs.get(pLang);
			if(ret == null)
			ret = mStrs.get(sCurLanguageISO);
			if(ret == null)
			ret = mStrs.get(DefaultLanguageISO);
			return ret;
		}
		public String getFromLang(String pLang, Object ... args) {
			return String.format(getFromLang(pLang), args);
		}
		@Override
		public String toString() {
			return get();
		}
	}



	public static class Basic {
		/** 
		 * <font size='3'><b><font color='red'>Basic</font>.<font color='blue'>Service</font></b></font><br/>
		 * <font size='3'><b>Service</b></font>
		 * <font size='2'><b></b></font>
		 */
		public static LocalString Service = new LocalString() {{
			str("en",      "Service");
			str("ko",      "서비스");
			str("th",      "การบริการ");
		}};
		/** 
		 * <font size='3'><b><font color='red'>Basic</font>.<font color='blue'>Delete_Short</font></b></font><br/>
		 * <font size='3'><b>Delete</b></font>
		 * <font size='2'><b></b></font>
		 */
		public static LocalString Delete_Short = new LocalString() {{
			str("en",      "Delete");
			str("ko",      "삭제");
			str("th",      "ลบ");
		}};
		/** 
		 * <font size='3'><b><font color='red'>Basic</font>.<font color='blue'>Male_short</font></b></font><br/>
		 * <font size='3'><b>Male</b></font>
		 * <font size='2'><b></b></font>
		 */
		public static LocalString Male_short = new LocalString() {{
			str("en",      "Male");
			str("ko",      "남");
			str("th",      "ช");
		}};
		/** 
		 * <font size='3'><b><font color='red'>Basic</font>.<font color='blue'>Female_short</font></b></font><br/>
		 * <font size='3'><b>Female</b></font>
		 * <font size='2'><b></b></font>
		 */
		public static LocalString Female_short = new LocalString() {{
			str("en",      "Female");
			str("ko",      "여");
			str("th",      "ญ");
		}};
		/** 
		 * <font size='3'><b><font color='red'>Basic</font>.<font color='blue'>SuccessfullyEdited</font></b></font><br/>
		 * <font size='3'><b>Successfully edited</b></font>
		 * <font size='2'><b></b></font>
		 */
		public static LocalString SuccessfullyEdited = new LocalString() {{
			str("en",      "Successfully edited");
			str("ko",      "성공적으로 수정되었습니다.");
			str("th",      "ถูกแก้ไขเรียบร้อย");
		}};
		/** 
		 * <font size='3'><b><font color='red'>Basic</font>.<font color='blue'>Name</font></b></font><br/>
		 * <font size='3'><b>Name</b></font>
		 * <font size='2'><b></b></font>
		 */
		public static LocalString Name = new LocalString() {{
			str("en",      "Name");
			str("ko",      "이름");
			str("th",      "ชื่อ");
		}};
		/** 
		 * <font size='3'><b><font color='red'>Basic</font>.<font color='blue'>LoginRequiredDoYouWantToLogin</font></b></font><br/>
		 * <font size='3'><b>Login required. Do you want to login?</b></font>
		 * <font size='2'><b></b></font>
		 */
		public static LocalString LoginRequiredDoYouWantToLogin = new LocalString() {{
			str("en",      "Login required. Do you want to login?");
			str("ko",      "로그인이 필요한 서비스입니다. 로그인 하시겠습니까?");
			str("th",      "ต้องการเข้าสู่ระบบเพื่อใช้บริการนี้ ต้องการเข้าสู่ระบบหรือไม่");
		}};
		/** 
		 * <font size='3'><b><font color='red'>Basic</font>.<font color='blue'>OK</font></b></font><br/>
		 * <font size='3'><b>OK</b></font>
		 * <font size='2'><b>For OK Common Button</b></font>
		 */
		public static LocalString OK = new LocalString() {{
			str("en",      "OK");
			str("ko",      "확인");
			str("th",      "ตกลง");
		}};
		/** 
		 * <font size='3'><b><font color='red'>Basic</font>.<font color='blue'>Email</font></b></font><br/>
		 * <font size='3'><b>Email</b></font>
		 * <font size='2'><b></b></font>
		 */
		public static LocalString Email = new LocalString() {{
			str("en",      "Email");
			str("ko",      "이메일");
			str("th",      "อีเมล์");
		}};
		/** 
		 * <font size='3'><b><font color='red'>Basic</font>.<font color='blue'>Ongoing</font></b></font><br/>
		 * <font size='3'><b>Ongoing</b></font>
		 * <font size='2'><b></b></font>
		 */
		public static LocalString Ongoing = new LocalString() {{
			str("en",      "Ongoing");
			str("ko",      "진행 중");
			str("th",      "กำลังดำเนินการ");
		}};
		/** 
		 * <font size='3'><b><font color='red'>Basic</font>.<font color='blue'>Purchase</font></b></font><br/>
		 * <font size='3'><b>Purchase</b></font>
		 * <font size='2'><b></b></font>
		 */
		public static LocalString Purchase = new LocalString() {{
			str("en",      "Purchase");
			str("ko",      "구매");
			str("th",      "วิธีการซื้อ");
		}};
		/** 
		 * <font size='3'><b><font color='red'>Basic</font>.<font color='blue'>Cancel</font></b></font><br/>
		 * <font size='3'><b>Cancel</b></font>
		 * <font size='2'><b></b></font>
		 */
		public static LocalString Cancel = new LocalString() {{
			str("en",      "Cancel");
			str("ko",      "취소");
			str("th",      "ยกเลิก");
		}};
		/** 
		 * <font size='3'><b><font color='red'>Basic</font>.<font color='blue'>RegistrationCompleted</font></b></font><br/>
		 * <font size='3'><b>Registration completed</b></font>
		 * <font size='2'><b></b></font>
		 */
		public static LocalString RegistrationCompleted = new LocalString() {{
			str("en",      "Registration completed");
			str("ko",      "가입이 완료되었습니다.");
			str("th",      "ลงทะเบียนเรียบร้อย");
		}};
		/** 
		 * <font size='3'><b><font color='red'>Basic</font>.<font color='blue'>LoginRequired</font></b></font><br/>
		 * <font size='3'><b>Login required.</b></font>
		 * <font size='2'><b></b></font>
		 */
		public static LocalString LoginRequired = new LocalString() {{
			str("en",      "Login required.");
			str("ko",      "로그인이 필요한 서비스입니다.");
			str("th",      "Login required.");
		}};
		/** 
		 * <font size='3'><b><font color='red'>Basic</font>.<font color='blue'>Delete</font></b></font><br/>
		 * <font size='3'><b>Delete</b></font>
		 * <font size='2'><b></b></font>
		 */
		public static LocalString Delete = new LocalString() {{
			str("en",      "Delete");
			str("ko",      "삭제하기");
			str("th",      "ลบ");
		}};
		/** 
		 * <font size='3'><b><font color='red'>Basic</font>.<font color='blue'>IfYouWishToEndService</font></b></font><br/>
		 * <font size='3'><b>If you wish to end service, tap BACK button </b></font>
		 * <font size='2'><b></b></font>
		 */
		public static LocalString IfYouWishToEndService = new LocalString() {{
			str("en",      "If you wish to end service, tap BACK button ");
			str("ko",      "Back키를 한번 더 누르시면 서비스가 종료됩니다.");
			str("th",      "กดปุ่ม 'ย้อนกลับ' อีกครั้งเพื่อออกจากระบบ");
		}};
		/** 
		 * <font size='3'><b><font color='red'>Basic</font>.<font color='blue'>Female</font></b></font><br/>
		 * <font size='3'><b>Female</b></font>
		 * <font size='2'><b></b></font>
		 */
		public static LocalString Female = new LocalString() {{
			str("en",      "Female");
			str("ko",      "여자");
			str("th",      "ผู้หญิง");
		}};
		/** 
		 * <font size='3'><b><font color='red'>Basic</font>.<font color='blue'>Male</font></b></font><br/>
		 * <font size='3'><b>Male</b></font>
		 * <font size='2'><b></b></font>
		 */
		public static LocalString Male = new LocalString() {{
			str("en",      "Male");
			str("ko",      "남자");
			str("th",      "ผู้ชาย");
		}};
		/** 
		 * <font size='3'><b><font color='red'>Basic</font>.<font color='blue'>Download</font></b></font><br/>
		 * <font size='3'><b>Download</b></font>
		 * <font size='2'><b></b></font>
		 */
		public static LocalString Download = new LocalString() {{
			str("en",      "Download");
			str("ko",      "다운로드");
			str("th",      "ดาวน์โหลด");
		}};
		/** 
		 * <font size='3'><b><font color='red'>Basic</font>.<font color='blue'>InformationMissing</font></b></font><br/>
		 * <font size='3'><b>Information missing</b></font>
		 * <font size='2'><b></b></font>
		 */
		public static LocalString InformationMissing = new LocalString() {{
			str("en",      "Information missing");
			str("ko",      "필수정보 입력");
			str("th",      "กรอกข้อบังคับ");
		}};
	}

	public static class Progressing {
		/** 
		 * <font size='3'><b><font color='red'>Progressing</font>.<font color='blue'>LastRefresh</font></b></font><br/>
		 * <font size='3'><b>Last refresh</b></font>
		 * <font size='2'><b></b></font>
		 */
		public static LocalString LastRefresh = new LocalString() {{
			str("en",      "Last refresh");
			str("ko",      "마지막 새로고침");
			str("th",      "รีเฟรชครั้งสุดท้าย");
		}};
		/** 
		 * <font size='3'><b><font color='red'>Progressing</font>.<font color='blue'>Completed</font></b></font><br/>
		 * <font size='3'><b>Completed</b></font>
		 * <font size='2'><b></b></font>
		 */
		public static LocalString Completed = new LocalString() {{
			str("en",      "Completed");
			str("ko",      "완료되었습니다.");
			str("th",      "ขออภัย บริการนี้จะถูกยกเลิกเนื่องจากข้อผิดพลาดบางประการ");
		}};
		/** 
		 * <font size='3'><b><font color='red'>Progressing</font>.<font color='blue'>RegistrationInProgress</font></b></font><br/>
		 * <font size='3'><b>Registration in progress</b></font>
		 * <font size='2'><b></b></font>
		 */
		public static LocalString RegistrationInProgress = new LocalString() {{
			str("en",      "Registration in progress");
			str("ko",      "가입 중입니다.");
			str("th",      "กำลังลงทะเบียน");
		}};
		/** 
		 * <font size='3'><b><font color='red'>Progressing</font>.<font color='blue'>ReleaseToRefresh</font></b></font><br/>
		 * <font size='3'><b>Release to refresh</b></font>
		 * <font size='2'><b></b></font>
		 */
		public static LocalString ReleaseToRefresh = new LocalString() {{
			str("en",      "Release to refresh");
			str("ko",      "새로고침 하시려면 당겼다 놓으세요.");
			str("th",      "Release to refresh");
		}};
		/** 
		 * <font size='3'><b><font color='red'>Progressing</font>.<font color='blue'>SendingFile</font></b></font><br/>
		 * <font size='3'><b>Sending file</b></font>
		 * <font size='2'><b></b></font>
		 */
		public static LocalString SendingFile = new LocalString() {{
			str("en",      "Sending file");
			str("ko",      "파일 전송중입니다.");
			str("th",      "กำลังส่งไฟล์");
		}};
		/** 
		 * <font size='3'><b><font color='red'>Progressing</font>.<font color='blue'>SendingImage</font></b></font><br/>
		 * <font size='3'><b>Sending image</b></font>
		 * <font size='2'><b></b></font>
		 */
		public static LocalString SendingImage = new LocalString() {{
			str("en",      "Sending image");
			str("ko",      "이미지 전송중입니다.");
			str("th",      "กำลังส่งภาพถ่าย");
		}};
		/** 
		 * <font size='3'><b><font color='red'>Progressing</font>.<font color='blue'>PullDownToRefresh</font></b></font><br/>
		 * <font size='3'><b>Pull down to refresh</b></font>
		 * <font size='2'><b></b></font>
		 */
		public static LocalString PullDownToRefresh = new LocalString() {{
			str("en",      "Pull down to refresh");
			str("ko",      "새로고침 하시려면 아래로 당기세요.");
			str("th",      "Pull down to refresh");
		}};
		/** 
		 * <font size='3'><b><font color='red'>Progressing</font>.<font color='blue'>InProgress</font></b></font><br/>
		 * <font size='3'><b>In Progress</b></font>
		 * <font size='2'><b></b></font>
		 */
		public static LocalString InProgress = new LocalString() {{
			str("en",      "In Progress");
			str("ko",      "진행 중입니다.");
			str("th",      "กำลังดำเนินการอยู่");
		}};
		/** 
		 * <font size='3'><b><font color='red'>Progressing</font>.<font color='blue'>Refreshing</font></b></font><br/>
		 * <font size='3'><b>Refreshing</b></font>
		 * <font size='2'><b></b></font>
		 */
		public static LocalString Refreshing = new LocalString() {{
			str("en",      "Refreshing");
			str("ko",      "새로고침 중입니다.");
			str("th",      "กำลังรีเฟรช");
		}};
		/** 
		 * <font size='3'><b><font color='red'>Progressing</font>.<font color='blue'>ApplyingToServer</font></b></font><br/>
		 * <font size='3'><b>Applying to server</b></font>
		 * <font size='2'><b></b></font>
		 */
		public static LocalString ApplyingToServer = new LocalString() {{
			str("en",      "Applying to server");
			str("ko",      "서버에 적용하는 중입니다.");
			str("th",      "กำลัง ไปยังเซิร์ฟเวอร์");
		}};
	}

	public static class Error {
		/** 
		 * <font size='3'><b><font color='red'>Error</font>.<font color='blue'>PasswordTooLong</font></b></font><br/>
		 * <font size='3'><b>Password too long</b></font>
		 * <font size='2'><b></b></font>
		 */
		public static LocalString PasswordTooLong = new LocalString() {{
			str("en",      "Password too long");
			str("ko",      "비밀번호가 너무 깁니다.");
			str("th",      "รหัสผ่านยาวเกินไป");
		}};
		/** 
		 * <font size='3'><b><font color='red'>Error</font>.<font color='blue'>FailedToRegister</font></b></font><br/>
		 * <font size='3'><b>Failed to register</b></font>
		 * <font size='2'><b></b></font>
		 */
		public static LocalString FailedToRegister = new LocalString() {{
			str("en",      "Failed to register");
			str("ko",      "가입을 실패하였습니다.");
			str("th",      "การลงทะเบียนไม่สำเร็จ");
		}};
		/** 
		 * <font size='3'><b><font color='red'>Error</font>.<font color='blue'>YourPasswordIncludesUnsuitableCharacters</font></b></font><br/>
		 * <font size='3'><b>Your password includes unsuitable characters</b></font>
		 * <font size='2'><b></b></font>
		 */
		public static LocalString YourPasswordIncludesUnsuitableCharacters = new LocalString() {{
			str("en",      "Your password includes unsuitable characters");
			str("ko",      "비밀번호로 이용할 수 없는 문자가 존재합니다.");
			str("th",      "มีตัวอักษรที่ไม่สามารถใช้เป็นรหัสผ่านได้");
		}};
		/** 
		 * <font size='3'><b><font color='red'>Error</font>.<font color='blue'>SelectGender</font></b></font><br/>
		 * <font size='3'><b>Select gender, please.</b></font>
		 * <font size='2'><b></b></font>
		 */
		public static LocalString SelectGender = new LocalString() {{
			str("en",      "Select gender, please.");
			str("ko",      "성별을 입력해 주세요.");
			str("th",      "กรุณากรอกเพศของคุณ");
		}};
		/** 
		 * <font size='3'><b><font color='red'>Error</font>.<font color='blue'>PasswordTooShort</font></b></font><br/>
		 * <font size='3'><b>Password too short</b></font>
		 * <font size='2'><b></b></font>
		 */
		public static LocalString PasswordTooShort = new LocalString() {{
			str("en",      "Password too short");
			str("ko",      "비밀번호가 너무 짧습니다.");
			str("th",      "รหัสผ่านสั้นเกินไป");
		}};
		/** 
		 * <font size='3'><b><font color='red'>Error</font>.<font color='blue'>SuspendedUser</font></b></font><br/>
		 * <font size='3'><b>Suspended user</b></font>
		 * <font size='2'><b></b></font>
		 */
		public static LocalString SuspendedUser = new LocalString() {{
			str("en",      "Suspended user");
			str("ko",      "사용 정지된 회원입니다.");
			str("th",      "คุณเป็นสมาชิกถูกหยุดใช้บริการ");
		}};
		/** 
		 * <font size='3'><b><font color='red'>Error</font>.<font color='blue'>ExistingNickname</font></b></font><br/>
		 * <font size='3'><b>Existing nickname</b></font>
		 * <font size='2'><b></b></font>
		 */
		public static LocalString ExistingNickname = new LocalString() {{
			str("en",      "Existing nickname");
			str("ko",      "입력하신 닉네임은 이미 사용 중입니다.");
			str("th",      "ชื่อเล่นนี้ถูกใช้อยู่");
		}};
		/** 
		 * <font size='3'><b><font color='red'>Error</font>.<font color='blue'>PasswordsDoNotMatch</font></b></font><br/>
		 * <font size='3'><b>Passwords do not match.</b></font>
		 * <font size='2'><b></b></font>
		 */
		public static LocalString PasswordsDoNotMatch = new LocalString() {{
			str("en",      "Passwords do not match.");
			str("ko",      "비밀번호가 일치하지 않습니다.");
			str("th",      "รหัสผ่านไม่ถูกต้อง");
		}};
		/** 
		 * <font size='3'><b><font color='red'>Error</font>.<font color='blue'>NicknameTooShort</font></b></font><br/>
		 * <font size='3'><b>Nickname too short</b></font>
		 * <font size='2'><b></b></font>
		 */
		public static LocalString NicknameTooShort = new LocalString() {{
			str("en",      "Nickname too short");
			str("ko",      "닉네임이 너무 짧습니다.");
			str("th",      "ชื่อเล่นนี้สั้นเกินไป");
		}};
		/** 
		 * <font size='3'><b><font color='red'>Error</font>.<font color='blue'>UnstableConnection</font></b></font><br/>
		 * <font size='3'><b>Unstable connection</b></font>
		 * <font size='2'><b></b></font>
		 */
		public static LocalString UnstableConnection = new LocalString() {{
			str("en",      "Unstable connection");
			str("ko",      "통신이 원활하지 않습니다.");
			str("th",      "มีปัญหาในระบบเครือข่าย");
		}};
		/** 
		 * <font size='3'><b><font color='red'>Error</font>.<font color='blue'>YourIDIncludesUnsuitableCharacters</font></b></font><br/>
		 * <font size='3'><b>Your ID includes unsuitable characters</b></font>
		 * <font size='2'><b></b></font>
		 */
		public static LocalString YourIDIncludesUnsuitableCharacters = new LocalString() {{
			str("en",      "Your ID includes unsuitable characters");
			str("ko",      "아이디로 이용할 수 없는 문자가 존재합니다.");
			str("th",      "มีตัวอักษรที่ไม่สามารถใช้เป็นชื่อบัญชี");
		}};
		/** 
		 * <font size='3'><b><font color='red'>Error</font>.<font color='blue'>NameTooShort</font></b></font><br/>
		 * <font size='3'><b>Name too short</b></font>
		 * <font size='2'><b></b></font>
		 */
		public static LocalString NameTooShort = new LocalString() {{
			str("en",      "Name too short");
			str("ko",      "이름이 너무 짧습니다.");
			str("th",      "ชื่อนี้สั้นเกินไป");
		}};
		/** 
		 * <font size='3'><b><font color='red'>Error</font>.<font color='blue'>PleaseEnterPassword</font></b></font><br/>
		 * <font size='3'><b>Please enter password.</b></font>
		 * <font size='2'><b></b></font>
		 */
		public static LocalString PleaseEnterPassword = new LocalString() {{
			str("en",      "Please enter password.");
			str("ko",      "비밀번호를 입력해 주세요.");
			str("th",      "โปรดพิมพ์รหัสผ่าน");
		}};
		/** 
		 * <font size='3'><b><font color='red'>Error</font>.<font color='blue'>AddProfileImage</font></b></font><br/>
		 * <font size='3'><b>Add profile image</b></font>
		 * <font size='2'><b></b></font>
		 */
		public static LocalString AddProfileImage = new LocalString() {{
			str("en",      "Add profile image");
			str("ko",      "프로필 이미지를 입력해 주세요.");
			str("th",      "กรุณาอัพโหลดรูปภาพโพรไฟล์");
		}};
		/** 
		 * <font size='3'><b><font color='red'>Error</font>.<font color='blue'>UnidentifiedRoute</font></b></font><br/>
		 * <font size='3'><b>Unidentified route</b></font>
		 * <font size='2'><b></b></font>
		 */
		public static LocalString UnidentifiedRoute = new LocalString() {{
			str("en",      "Unidentified route");
			str("ko",      "비정상적인 접근입니다.");
			str("th",      "เป็นวิธีการที่ผิดปกติ");
		}};
		/** 
		 * <font size='3'><b><font color='red'>Error</font>.<font color='blue'>TypeYourName</font></b></font><br/>
		 * <font size='3'><b>Type your name</b></font>
		 * <font size='2'><b></b></font>
		 */
		public static LocalString TypeYourName = new LocalString() {{
			str("en",      "Type your name");
			str("ko",      "이름을 입력해 주세요. ");
			str("th",      "กรุณาเขียนชื่อของคุณ");
		}};
		/** 
		 * <font size='3'><b><font color='red'>Error</font>.<font color='blue'>UploadError</font></b></font><br/>
		 * <font size='3'><b>Upload error</b></font>
		 * <font size='2'><b></b></font>
		 */
		public static LocalString UploadError = new LocalString() {{
			str("en",      "Upload error");
			str("ko",      "업로드 에러 발생");
			str("th",      "มีข้อผิดพลาดบางประการในขณะที่อัพโหลด");
		}};
		/** 
		 * <font size='3'><b><font color='red'>Error</font>.<font color='blue'>EmailWrittenInNotSuitableFormat</font></b></font><br/>
		 * <font size='3'><b>Email written in not suitable format</b></font>
		 * <font size='2'><b></b></font>
		 */
		public static LocalString EmailWrittenInNotSuitableFormat = new LocalString() {{
			str("en",      "Email written in not suitable format");
			str("ko",      "이메일이 너무 짧거나, 형식에 맞지 않습니다.");
			str("th",      "อีเมล์สั้นเกินไปหรือผิดวิธี");
		}};
		/** 
		 * <font size='3'><b><font color='red'>Error</font>.<font color='blue'>PasswordMustBe6to32Letters</font></b></font><br/>
		 * <font size='3'><b>Password must be 6 to 32 letters, including upper case, lower case, numbers and special characters.</b></font>
		 * <font size='2'><b></b></font>
		 */
		public static LocalString PasswordMustBe6to32Letters = new LocalString() {{
			str("en",      "Password must be 6 to 32 letters, including upper case, lower case, numbers and special characters.");
			str("ko",      "비밀번호는  영문 대소문, 숫자, 특수문자 포함하여 6-32 자리 입니다.");
			str("th",      "รหัสผ่านต้องมีตัวอักษร 6 ถึง 32 ตัว รวมตัวพิมพ์ใหญ่ ตัวพิมพ์เล็ก ตัวเลข และอักขระพิเศษ");
		}};
		/** 
		 * <font size='3'><b><font color='red'>Error</font>.<font color='blue'>WithdrawalRequestedUser</font></b></font><br/>
		 * <font size='3'><b>Withdrawal requested user</b></font>
		 * <font size='2'><b></b></font>
		 */
		public static LocalString WithdrawalRequestedUser = new LocalString() {{
			str("en",      "Withdrawal requested user");
			str("ko",      "탈퇴요청 중인 회원입니다.");
			str("th",      "คุณเป็นสมาชิกกำลังขอถอนตัวจากระบบ");
		}};
		/** 
		 * <font size='3'><b><font color='red'>Error</font>.<font color='blue'>PleaseEnterIDEmail</font></b></font><br/>
		 * <font size='3'><b>Please enter ID (email).</b></font>
		 * <font size='2'><b></b></font>
		 */
		public static LocalString PleaseEnterIDEmail = new LocalString() {{
			str("en",      "Please enter ID (email).");
			str("ko",      "아이디(E-mail)를 입력해 주세요.");
			str("th",      "โปรดพิมพ์ ID (อีเมล์)");
		}};
		/** 
		 * <font size='3'><b><font color='red'>Error</font>.<font color='blue'>ServiceWillBeAvailableSoon</font></b></font><br/>
		 * <font size='3'><b>Service will be available soon</b></font>
		 * <font size='2'><b></b></font>
		 */
		public static LocalString ServiceWillBeAvailableSoon = new LocalString() {{
			str("en",      "Service will be available soon");
			str("ko",      "서비스를 제공할 예정입니다.");
			str("th",      "จะให้บริการเร็วฯนี้");
		}};
		/** 
		 * <font size='3'><b><font color='red'>Error</font>.<font color='blue'>AbnormalRequest</font></b></font><br/>
		 * <font size='3'><b>Abnormal request</b></font>
		 * <font size='2'><b></b></font>
		 */
		public static LocalString AbnormalRequest = new LocalString() {{
			str("en",      "Abnormal request");
			str("ko",      "비정상적인 요청입니다. ");
			str("th",      "เป็นพารามิเตอร์ที่ผิดปกติ");
		}};
		/** 
		 * <font size='3'><b><font color='red'>Error</font>.<font color='blue'>FailedByUnknownReason</font></b></font><br/>
		 * <font size='3'><b>Failed by unknown reason</b></font>
		 * <font size='2'><b></b></font>
		 */
		public static LocalString FailedByUnknownReason = new LocalString() {{
			str("en",      "Failed by unknown reason");
			str("ko",      "알 수 없는 이유로 실패하였습니다.");
			str("th",      "ขออภัย บริการนี้จะถูกยกเลิกเนื่องจากข้อผิดพลาดบางประการ");
		}};
		/** 
		 * <font size='3'><b><font color='red'>Error</font>.<font color='blue'>PleaseEnterPhoneNumberToContact</font></b></font><br/>
		 * <font size='3'><b>Please enter phone number to contact.</b></font>
		 * <font size='2'><b></b></font>
		 */
		public static LocalString PleaseEnterPhoneNumberToContact = new LocalString() {{
			str("en",      "Please enter phone number to contact.");
			str("ko",      "핸드폰 번호를 입력하여 주십시오.");
			str("th",      "กรุณากรอกหมายเลขโทรศัพท์ของคุณค่ะ");
		}};
		/** 
		 * <font size='3'><b><font color='red'>Error</font>.<font color='blue'>EnterYourBirthDate</font></b></font><br/>
		 * <font size='3'><b>Enter your birth date, please.</b></font>
		 * <font size='2'><b></b></font>
		 */
		public static LocalString EnterYourBirthDate = new LocalString() {{
			str("en",      "Enter your birth date, please.");
			str("ko",      "생일을 입력해 주세요.");
			str("th",      "กรุณากรอกวันเกิดของคุณ");
		}};
		/** 
		 * <font size='3'><b><font color='red'>Error</font>.<font color='blue'>ErrorOccurredWhileLeaving</font></b></font><br/>
		 * <font size='3'><b>Error occurred while leaving</b></font>
		 * <font size='2'><b></b></font>
		 */
		public static LocalString ErrorOccurredWhileLeaving = new LocalString() {{
			str("en",      "Error occurred while leaving");
			str("ko",      "탈퇴 요청 중 에러가 발생하였습니다.");
			str("th",      "มีข้อผิดพลาดบางประการในขณะขอถอนตัวจากระบบ");
		}};
		/** 
		 * <font size='3'><b><font color='red'>Error</font>.<font color='blue'>ErrorOccurredWhileChangingPassword</font></b></font><br/>
		 * <font size='3'><b>Error occurred while changing password</b></font>
		 * <font size='2'><b></b></font>
		 */
		public static LocalString ErrorOccurredWhileChangingPassword = new LocalString() {{
			str("en",      "Error occurred while changing password");
			str("ko",      "비밀번호 변경 중 에러가 발생하였습니다.");
			str("th",      "มีข้อผิดพลาดบางประการในขณะที่เปลี่ยนรหัสผ่าน");
		}};
		/** 
		 * <font size='3'><b><font color='red'>Error</font>.<font color='blue'>InvalidEmailAccountOrPassword</font></b></font><br/>
		 * <font size='3'><b>Invalid E-mail account or password</b></font>
		 * <font size='2'><b></b></font>
		 */
		public static LocalString InvalidEmailAccountOrPassword = new LocalString() {{
			str("en",      "Invalid E-mail account or password");
			str("ko",      "E-mail 또는 password가 일치하지 않습니다.");
			str("th",      "อีเมล์หรือรหัสผ่านไม่ตรงกัน");
		}};
		/** 
		 * <font size='3'><b><font color='red'>Error</font>.<font color='blue'>TypeNickname</font></b></font><br/>
		 * <font size='3'><b>Type nickname</b></font>
		 * <font size='2'><b></b></font>
		 */
		public static LocalString TypeNickname = new LocalString() {{
			str("en",      "Type nickname");
			str("ko",      "닉네임을 입력해 주세요.");
			str("th",      "กรุณากรอกชื่อเล่นของคุณ");
		}};
		/** 
		 * <font size='3'><b><font color='red'>Error</font>.<font color='blue'>ExistingEmail</font></b></font><br/>
		 * <font size='3'><b>Existing Email</b></font>
		 * <font size='2'><b></b></font>
		 */
		public static LocalString ExistingEmail = new LocalString() {{
			str("en",      "Existing Email");
			str("ko",      "입력하신 이메일(ID)는 이미 사용중인 이메일(ID)입니다.");
			str("th",      "อีเมล์นี้ถูกใช้อยู่");
		}};
	}

}
