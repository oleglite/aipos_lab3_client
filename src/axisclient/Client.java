/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package axisclient;

/** Интерфейс для получения данных справочника
 *
 * @author Oleg Beloglazov
 */
public interface Client {
    
    /** Получить названия всех доступных статей
     * 
     * @return названия всех статей, или null если произошла ошибка
     */
    String[] getArticles();

    /** Получить содержимое статьи
     * 
     * @param articleName название статьи
     * @return содержимое статьи, или описание ошибки
     */
    String getArticleContent(String articleName);
    
    /** Добавить статью
     * 
     * @param articleName название статьи
     * @return null если не было ошибок, иначе описание ошибки
     */
    String addArticle(String articleName);

    /** Удалить статью
     * 
     * @param articleName название статьи
     * @return null если не было ошибок, иначе описание ошибки
     */
    String removeArticle(String articleName);

    /** Установить содержимое статьи
     * 
     * @param articleName название статьи
     * @param articleContent содержимое статьи
     * @return null если не было ошибок, иначе описание ошибки
     */
    String setArticleContent(String articleName, String articleContent);
}
