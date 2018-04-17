package com.fans.farm.service;

import com.fans.farm.model.Account;

/**
 * @author: Ike.Fan
 * @date: 2018/3/30.
 */
public interface AccountService {
    public enum ACCOUNT_TYPE {
        UNKOWN(0), ACCOUNT(1), EMAILE(2), PHONE(3),QQ(4),WECHAT(5);
        private int type = 0;
        private ACCOUNT_TYPE(int type){
            this.type = type;
        }

        public int value(){
            return type;
        }
    }

    boolean registByAccount(String account, String password);
    boolean registByPhone(String phone, String password);
    boolean registByEmail(String email, String password);
    /**
     *
     * @param openId ThirdPart openId
     * @param type 4 QQ, 5 Wechat
     * @return
     */
    boolean registThirdPartAccount(String openId, int type);

    Account findById(int id);
    Account findByAccount(String account);
    Account findByPhone(String phone);
    Account findByEmail(String email);
    Account findByOpenId(String openId);
    boolean accountLogin(String account, String password);
    boolean phoneLogin(String phone, String password);
    boolean emailLogin(String email, String password);

    /**
     *
     * @param openId
     * @param type 4 QQ, 5 Wecaht
     * @return
     */
    boolean thirdPartLogin(String openId, int type);
}
