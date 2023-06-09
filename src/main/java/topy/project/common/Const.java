package topy.project.common;

public class Const {

    /**
     * 공통
     */
    public static final int SUCCESS = 0;
    public static final String SUCCESS_MSG = "성공";

    /**
     * 명명 규칙
     * Domain을 접두사로 사용
     */
    public static final String MEMBER_USED_ACCOUNT = "사용중인 계정입니다.";
    public static final String MEMBER_USED_CONTACT = "해당 연락처로 가입된 계정이 있습니다.";
    public static final String MEMBER_INVALID_EMAIL_FORMAT = "올바르지 않은 이메일 양식입니다.";
    public static final String MEMBER_NOT_FOUND_ACCOUNT = "계정을 찾을 수 없습니다.";
    public static final String MEMBER_EXPIRED_CODE_OR_INCORRECT_CODE = "만료 되었거나 일치하지 않는 인증 코드입니다.";
    public static final String MEMBER_INCORRECT_PASSWORD = "비밀번호가 일치하지 않습니다.";
    public static final String MEMBER_WITHDRAWAL_ACCOUNT = "탈퇴한 회원입니다.";

    public static final String MEMBER_DTO_NO_USERNAME = "아이디를 입력해주세요.";
    public static final String MEMBER_DTO_NO_PASSWORD = "비밀번호를 입력해주세요.";
    public static final String MEMBER_DTO_NO_CONTACT = "연락처를 입력해주세요.";
    public static final String MEMBER_DTO_WRONG_PASSWORD_RULE = "숫자, 대문자, 소문자, 특수문자를 포함하여 8 ~ 20자리의 비밀번호를 입력해주세요.";
    public static final String MEMBER_DTO_NO_RECEIVER = "수신받을 이메일을 입력해주세요.";
    public static final String MEMBER_DTO_NO_CURRENT_PASSWORD = "현재 비밀번호를 입력해주세요.";
    public static final String MEMBER_DTO_NO_NEW_PASSWORD = "변경할 비밀번호를 입력해주세요.";

    public static final String JWT_UNAUTHENTICATED_USER = "접근 권한이 없습니다.";
    public static final String JWT_WITHOUT_ACCESS = "인증되지 않은 사용자입니다.";
    public static final String JWT_INVALID_TOKEN = "유효하지 않은 토큰입니다.";
}
