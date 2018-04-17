package com.fans.farm.service.impl;

import com.fans.farm.mapper.AccountMapper;
import com.fans.farm.model.Account;
import com.fans.farm.model.AccountExample;
import com.fans.farm.service.AccountService;
import com.fans.farm.utils.CalendarUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Ike.Fan
 * @date: 2018/3/30.
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper mAccountMapper;

    @Override
    public boolean registByAccount(String account, String password) {
        Account newAccount = new Account();
        newAccount.setAccount(account);
        newAccount.setPassword(password);
        newAccount.setLoginType(ACCOUNT_TYPE.ACCOUNT.value());
        newAccount.setCreateDate(CalendarUtil.getCalendar().getTime());
        return mAccountMapper.insert(newAccount) > 0;
    }

    @Override
    public boolean registByPhone(String phone, String password) {
        return false;
    }

    @Override
    public boolean registByEmail(String email, String password) {
        return false;
    }

    @Override
    public boolean registThirdPartAccount(String openId, int type) {
        return false;
    }

    @Override
    public Account findById(int id) {
        return null;
    }

    @Override
    public Account findByAccount(String account) {
        AccountExample example = new AccountExample();
        example.createCriteria().andAccountEqualTo(account);
        List<Account> accounts = mAccountMapper.selectByExample(example);
        return accounts.size()>0?accounts.get(0):null;
    }

    @Override
    public Account findByPhone(String phone) {
        AccountExample example = new AccountExample();
        example.createCriteria().andPhoneEqualTo (phone);
        List<Account> accounts = mAccountMapper.selectByExample(example);
        return accounts.size()>0?accounts.get(0):null;
    }

    @Override
    public Account findByEmail(String email) {
        AccountExample example = new AccountExample();
        example.createCriteria().andEmailEqualTo (email);
        List<Account> accounts = mAccountMapper.selectByExample(example);
        return accounts.size()>0?accounts.get(0):null;
    }

    @Override
    public Account findByOpenId(String openId) {
        return null;
    }

    @Override
    public boolean accountLogin(String account, String password) {
        AccountExample accountExample = new AccountExample();
        accountExample.createCriteria().andAccountEqualTo(account).andPasswordEqualTo(password);
        return mAccountMapper.selectByExample(accountExample).size()>0;
    }

    @Override
    public boolean phoneLogin(String phone, String password) {
        return false;
    }

    @Override
    public boolean emailLogin(String email, String password) {
        return false;
    }

    @Override
    public boolean thirdPartLogin(String openId, int type) {
        return false;
    }
}
