/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package axisclient;

import axisservice.AxisServiceStub;
import java.rmi.RemoteException;

/** Реализация клиента справочника, использующая документо-ориентированное взаимодействие с сервисом
 *  
 * @author Beloglazov Oleg
 */
public class ClientDocOriented implements Client{
    
    AxisServiceStub mService;
    
    AxisServiceStub.GetArticles mGetArticles;
    AxisServiceStub.GetArticleContent mGetArticleContent;
    AxisServiceStub.AddArticle mAddArticle;
    AxisServiceStub.RemoveArticle mRemoveArticle;
    AxisServiceStub.SetArticleContent mSetArticleContent;
    
    AxisServiceStub.GetArticlesResponse mGetArticlesResponse;    
    AxisServiceStub.GetArticleContentResponse mGetArticleContentResponse;    
    AxisServiceStub.AddArticleResponse mAddArticleResponse;    
    AxisServiceStub.RemoveArticleResponse mRemoveArticleResponse;    
    AxisServiceStub.SetArticleContentResponse mSetArticleContentResponse;
    
    /** Стандартынй конструктор
     *  
     */
    public ClientDocOriented() {
        try {
            mService = new AxisServiceStub();
            
            mGetArticles = new AxisServiceStub.GetArticles();
            mGetArticleContent = new AxisServiceStub.GetArticleContent();
            mAddArticle = new AxisServiceStub.AddArticle();
            mRemoveArticle = new AxisServiceStub.RemoveArticle();
            mSetArticleContent = new AxisServiceStub.SetArticleContent();
                        
        } catch (Exception ex) {
            log(ex.getMessage());
        }
    }

    @Override
    public String[] getArticles() {
        log("getArticles()");
        
        try {
            mGetArticlesResponse = mService.getArticles(mGetArticles);
        } catch (RemoteException ex) {
            log(ex.getMessage());
            return null;
        }
        return mGetArticlesResponse.get_return();
    }

    @Override
    public String getArticleContent(String articleName) {
        log("getArticleContent(" + articleName + ")");
        
        mGetArticleContent.setArticleName(articleName);
        try {
            mGetArticleContentResponse = mService.getArticleContent(mGetArticleContent);
        } catch (RemoteException ex) {
            log(ex.getMessage());
            return ex.getMessage();
        }
        return mGetArticleContentResponse.get_return();
    }

    @Override
    public String addArticle(String articleName) {
        log("addArticle(" + articleName + ")");
        
        mAddArticle.setArticleName(articleName);
        try {
            mAddArticleResponse = mService.addArticle(mAddArticle);
        } catch (RemoteException ex) {
            log(ex.getMessage());
            return ex.getMessage();
        }
        return mAddArticleResponse.get_return();
    }

    @Override
    public String removeArticle(String articleName) {
        log("removeArticle(" + articleName + ")");
        
        mRemoveArticle.setArticleName(articleName);
        try {
            mRemoveArticleResponse = mService.removeArticle(mRemoveArticle);
        } catch (RemoteException ex) {
            log(ex.getMessage());
            return ex.getMessage();
        }
        return mRemoveArticleResponse.get_return();
    }

    @Override
    public String setArticleContent(String articleName, String articleContent) {
        log("setArticleContent(" + articleName + ", " + articleContent + ")");
        
        mSetArticleContent.setArticleName(articleName);
        mSetArticleContent.setArticleContent(articleContent);
        try {
            mSetArticleContentResponse = mService.setArticleContent(mSetArticleContent);
        } catch (RemoteException ex) {
            log(ex.getMessage());
            return ex.getMessage();
        }
        return mSetArticleContentResponse.get_return();
    }
    
    private static void log(String str) {
        System.out.println("ClientDocOriented: " + str);
    }
    
}
