/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package axisclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.rpc.ServiceException;
import org.apache.axis.AxisFault;
import org.apache.axis.client.Service;
import org.apache.axis.client.Call;

/** Реализация клиента справочника, использующая RPC взаимодействие с сервисом
 *
 * @author Oleg Beloglazov
 */
public class ClientRPC implements Client {
    
    final String ENDPOINT = "http://localhost:8080/axis/AxisService.jws";
    Service mService = new Service();
    Call mCall;
    
    /** Стандартный конструктор
     *
     */
    public ClientRPC() {
        try {
            mCall = (Call) mService.createCall();
            mCall.setTargetEndpointAddress(ENDPOINT);
        } catch (ServiceException ex) {
            log(ex.getMessage());
        }
    }

    @Override
    public String[] getArticles() {  
        log("getArticles()");
        
        String[] articles = null;   
        String responce = invokeCall("getArticlesNumber", new String[0]);
        
        int articlesNumber;
        try {
            articlesNumber = Integer.valueOf(responce);
        }
        catch (NumberFormatException ex) {
            return null;
        }
        
        articles = new String[articlesNumber];            
        for(int i = 0; i < articlesNumber; i++) {
            Object[] params = new Object[]{new Integer(i)};
            articles[i] = invokeCall("getArticleName", params);
        }
        return articles;
    }

    @Override
    public String getArticleContent(String articleName) {
        log("getArticleContent(" + articleName + ")");
        return invokeCall("getArticleContent", new Object[]{articleName});
    }

    @Override
    public String addArticle(String articleName) {
        log("addArticle(" + articleName + ")");
        return invokeCall("addArticle", new Object[]{articleName});
    }

    @Override
    public String removeArticle(String articleName) {
        log("removeArticle(" + articleName + ")");
        return invokeCall("removeArticle", new Object[]{articleName});
    }

    @Override
    public String setArticleContent(String articleName, String articleContent) {
        log("setArticleContent(" + articleName + ", " + articleContent + ")");
        return invokeCall("setArticleContent", new Object[]{articleName, articleContent});
    }
    
    /** Вызов метода сервиса
     * 
     * @param method название метода
     * @param args аргументы
     * @return ответ сервиса или сообщение об ошибке
     */
    private String invokeCall(String method, Object[] args) {
        try {
            return (String) mCall.invoke(method, args);
        } catch (AxisFault ex) {
            log(ex.getMessage());
            return ex.getMessage();
        }
    }
    
    private static void log(String str) {
        System.out.println("ClientRPC: " + str);
    }
    
}
