package topy.project.modules.member;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import topy.project.common.dto.ResultResponse;
import topy.project.modules.member.dto.MemberSignUpRequest;
import topy.project.modules.member.validator.MemberSignUpValidator;

import static topy.project.common.Const.SUCCESS;
import static topy.project.common.Const.SUCCESS_MSG;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final MemberSignUpValidator memberSignUpValidator;

    @InitBinder("memberSignUpRequest")
    public void signUpRequestInitBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(memberSignUpValidator);
    }

    @PostMapping("/member/sign-up")
    public ResultResponse signUp(@RequestBody @Valid MemberSignUpRequest memberSignUpRequest) {
        memberService.createMember(memberSignUpRequest);
        return ResultResponse.result(SUCCESS, SUCCESS_MSG);
    }
}