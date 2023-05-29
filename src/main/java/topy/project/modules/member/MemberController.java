package topy.project.modules.member;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import topy.project.common.dto.ResultResponse;
import topy.project.infra.config.security.jwt.JwtTokenProvider;
import topy.project.modules.member.dto.MemberEmailVerificationRequest;
import topy.project.modules.member.dto.MemberSignInRequest;
import topy.project.modules.member.dto.MemberSignInResponse;
import topy.project.modules.member.dto.MemberSignUpRequest;
import topy.project.modules.member.validator.MemberEmailVerificationValidator;
import topy.project.modules.member.validator.MemberSignUpValidator;

import static topy.project.common.Const.SUCCESS;
import static topy.project.common.Const.SUCCESS_MSG;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final MemberSignUpValidator memberSignUpValidator;
    private final MemberEmailVerificationValidator memberEmailVerificationValidator;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    @InitBinder("memberSignUpRequest")
    public void signUpRequestInitBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(memberSignUpValidator);
    }

    @InitBinder("memberEmailVerificationRequest")
    public void emailVerificationRequestInitBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(memberEmailVerificationValidator);
    }

    @PostMapping("/member/sign-up")
    public ResultResponse signUp(@RequestBody @Valid MemberSignUpRequest memberSignUpRequest) {
        memberService.createMember(memberSignUpRequest);
        return ResultResponse.result(SUCCESS, SUCCESS_MSG);
    }

    @PostMapping("/member/sign-in")
    public ResultResponse signIn(@RequestBody @Valid MemberSignInRequest memberSignInRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        memberSignInRequest.getUsername(),
                        memberSignInRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwtToken = jwtTokenProvider.createToken(authentication);
         MemberSignInResponse memberSignInResponse = MemberSignInResponse.builder()
                .username(memberSignInRequest.getUsername())
                .jwtToken(jwtToken)
                .build();
        return ResultResponse.result(SUCCESS, SUCCESS_MSG, memberSignInResponse);
    }

    @PostMapping("/member/verify/mail")
    public ResultResponse sendSignUpVerification(@RequestBody @Valid MemberEmailVerificationRequest memberEmailVerificationRequest) {
        memberService.sendVerificationCode(memberEmailVerificationRequest);
        return ResultResponse.result(SUCCESS, SUCCESS_MSG);
    }
}
