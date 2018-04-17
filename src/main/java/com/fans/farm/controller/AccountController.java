package com.fans.farm.controller;
import com.fans.farm.Global;
import com.fans.farm.common.AppException;
import com.fans.farm.common.ErrorCode;
import com.fans.farm.model.Account;
import com.fans.farm.net.RestResult;
import com.fans.farm.net.RestResultGenerator;
import com.fans.farm.net.requestparam.RequestAccount;
import com.fans.farm.service.AccountService;
import com.fans.farm.utils.EmptyChecker;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: Ike.Fan
 * @date: 2018/4/2.
 */
@Api("帐号相关接口")
@RestController
@RequestMapping(Global.API_URL_ACCOUNT)
public class AccountController {
    @Autowired
    AccountService mAccountService;

    @ApiOperation(value = "根据帐号注册",notes = "根据传入的account 和 password 注册新账户")
    @PostMapping("/register")
    public RestResult<Boolean> accountRegister(@RequestBody RequestAccount requestAccount){
        if(EmptyChecker.isEmpty(requestAccount.account) || EmptyChecker.isEmpty(requestAccount.password)){
            return RestResultGenerator.genErrorResult(ErrorCode.ACCOUNT_OR_PASSWORD_NULL);
        }
        try{
            return RestResultGenerator.genSuccessResult(mAccountService.registByAccount(requestAccount.account, requestAccount.password));
        }catch (Exception e){
            return RestResultGenerator.genErrorResult(new AppException(ErrorCode.EXCEPTION_ERR.getCode(),e.getMessage()));
        }
    }

    @ApiOperation(value = "根据帐号登录",notes = "根据传入的account和password进行的登录")
    @PostMapping("/login")
    public RestResult<Boolean> accountLogin(@RequestBody RequestAccount requestAccount){
        if(EmptyChecker.isEmpty(requestAccount.account) || EmptyChecker.isEmpty(requestAccount.password)){
            return RestResultGenerator.genErrorResult(ErrorCode.ACCOUNT_OR_PASSWORD_NULL);
        }
        if( mAccountService.accountLogin(requestAccount.account, requestAccount.password) ){
            return RestResultGenerator.genSuccessResult(mAccountService.accountLogin(requestAccount.account, requestAccount.password));
        }else{
            return RestResultGenerator.genErrorResult(ErrorCode.ACCOUNT_OR_PASSWORD_ERR);
        }

    }

    @ApiOperation(value = "查询帐号",notes = "返回账户信息 Account")
    @GetMapping("/find")
    public RestResult<Account> findAccount(@RequestParam("account") String account){
        Account accountFound = mAccountService.findByAccount(account);
        boolean accountExist = !EmptyChecker.isEmpty(accountFound);
        return RestResultGenerator.genResult(accountExist, accountFound, accountExist?ErrorCode.RESULT_SUCCESS.getCode():ErrorCode.ACCOUNT_NOT_EXIST.getCode(),
                accountExist?null:ErrorCode.ACCOUNT_NOT_EXIST.getMessage());
    }

}
