/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package axisclient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractListModel;

/** Модель данных справочника
 *
 * @author Oleg Beloglazov
 */
public class DataModel extends AbstractListModel {
    
    Client mClient;
    ArrayList<String> mArticles;
    String mFilter = "";
    boolean mIsServiceAvaliable = false;
    
    @Override
    public int getSize() {
        if(mArticles == null) {
            return 0;
        }
        int filteredSize = 0;
        for(int i = 0; i < mArticles.size(); i++) {
            if(mArticles.get(i).startsWith(mFilter)) {
                filteredSize++;
            }
        }
        return filteredSize;
    }

    @Override
    public Object getElementAt(int index) {
        for(int i = 0; i <= index; i++) {
            if(!mArticles.get(i).startsWith(mFilter)) {
                index++;
            }
        }
        return mArticles.get(index);
    }
    
    /** Получить содержимое статьи
     * 
     * @param articleName название статьи
     * @return содержимое статьи, или описание ошибки
     */
    public String getArticleContent(String articleName) {        
        return mClient.getArticleContent(articleName);
    }
    
    /** Добавить статью
     * 
     * @param articleName название статьи
     */
    public void addArticle(String articleName) throws Exception {
        String responce = mClient.addArticle(articleName);
        update();
        if(responce != null) {
            throw new Exception(responce);
        }
    }
    
    /** Удалить статью
     * 
     * @param articleName название статьи
     */
    public void removeArticle(String articleName) throws Exception {
        String responce = mClient.removeArticle(articleName);
        update();
        if(responce != null) {
            throw new Exception(responce);
        }
    }
    
    /** Установить содержимое статьи
     * 
     * @param articleName название статьи
     * @param articleContent содержимое статьи
     */
    public void setArticleContent(String articleName, String articleContent) throws Exception {
        String responce = mClient.setArticleContent(articleName, articleContent);
        if(responce != null) {
            throw new Exception(responce);
        }
    }
    
    /** Установить фильтр
     * Фильтр - набор символов с которых начинается искомое название.
     * @param filter фильтрующее слово
     */
    public void setFilter(String filter) {
        mFilter = filter;
        update();
    }
    
    /** Установить клиент
     *  Клиент должен быть доступен.
     * @param client клиент
     */
    public void setClient(Client client) {
        mClient = client;
        if(mClient != null) {
            update();
        }
    }
    
    /** Проверить доступен ли используемый сервис
     * 
     * @return true, если сервис доступен
     */
    public boolean isServiceAvaliable() {
        return mIsServiceAvaliable;
    }
    
    /** Метод, вызываемый после обновления данных
     * 
     */
    private void update() {
        int articlesNumber = 0;
        if(mClient != null && mArticles != null) {
            articlesNumber = mArticles.size();
        }        
        setArticles(mClient.getArticles());
        if(mArticles.size() > articlesNumber) {
            articlesNumber = mArticles.size();
        }
        fireContentsChanged(this, 0, articlesNumber);
    }
    
    private void setArticles(String[] articlesArray) {
        if(articlesArray != null) {
            mArticles = new ArrayList<String>(Arrays.asList(articlesArray));
            mIsServiceAvaliable = true;
        } else {
            mArticles = new ArrayList<String>();
            mIsServiceAvaliable = false;
        }
    }
}
