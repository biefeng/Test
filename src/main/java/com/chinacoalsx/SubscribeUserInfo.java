package com.chinacoalsx;

import com.chinacoalsx.xsd.UserInfo;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.JAXBElement;
@WebService(name = "SubscribeUserInfo", targetNamespace = "http://chinacoalsx.com")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public class SubscribeUserInfo implements SubscribeUserInfoPortType {
    public void removeUser(RemoveUser parameters) {
        JAXBElement<String> userCode = parameters.getUsercode();

      /*  Database db = null;
        String sql = "delete from utusrmst where usr_id= ?";
        try {

            db = Tools.getDatabase(false);
            db.execPrepareSqlUpdate(sql, new Object[]{userCode.getValue()});
            db.commit();
        } catch (Exception e) {
          //  Log.error(e);
            db.rollback();
        } finally {
            if (null != db)
                db.cleanup();
        }*/
    }

    public void updateUser(UpdateUser parameters) {
        JAXBElement<UserInfo> userInfo = parameters.getUser();
        UserInfo user = userInfo.getValue();
        String userCode = user.getUserCode().getValue();
        String userName = user.getName().getValue();
        StringBuffer sb = new StringBuffer("update utustmst a set ");

/*

        Database db = null;

        try {
            db = Tools.getDatabase(false);
            if (null != userCode) {
                sb.append("a.usr_id=? ");
                if (null != userName) {
                    sb.append("and usr_nam=?");
                    db.execPrepareSqlUpdate(sb.toString(), new Object[]{userCode, userName});
                } else {
                    db.execPrepareSqlUpdate(sb.toString(), new Object[]{userCode});
                }
            } else {
                if (null != userName) {
                    sb.append("usr_nam=?");
                    db.execPrepareSqlUpdate(sb.toString(), new Object[]{userName});
                }
            }
            db.commit();

        } catch (Exception e) {
           // Log.error(e);
            db.rollback();
        } finally {
            if (null != db)
                db.cleanup();
        }

*/

    }

    public void enableUser(EnableUser parameters) {
        String userCode = parameters.getUserCode().getValue();
        boolean isEnable = parameters.isEnable();

       /* Database db = null;
        String sql = null;

        sql = "update utusrmst a set a.valid_sta = ? where a.usr_id=? ";

        try {
            db = Tools.getDatabase(false);
            if (isEnable)
                db.execPrepareSqlUpdate(sql, new Object[]{"A", userCode});
            else
                db.execPrepareSqlUpdate(sql, new Object[]{"B", userCode});
            db.commit();
        } catch (Exception e) {
          //  Log.error(e);
            db.rollback();
        } finally {
            db.cleanup();
        }*/
    }

    public void addUser(AddUser parameters) {
        JAXBElement<UserInfo> userInfo = parameters.getUser();
        UserInfo user = userInfo.getValue();

        String userCode = user.getUserCode().getValue();
        String userName = user.getName().getValue();
        boolean isEnable = user.isEnabled();

      /*  Database db = null;
        String sql = "";

        try {
            db = Tools.getDatabase(false);
            sql = "insert into utusrmst a where a.usr_id=? and usr_nam = ? and valid_sta =?";

            db.execPrepareSqlUpdate(sql, new Object[]{userCode, userName, isEnable ? "A" : "B"});

            db.commit();
        } catch (Exception e) {
            db.rollback();
          //  Log.error(e);
        } finally {
            if (null != db)
                db.cleanup();
        }*/
    }
}
