
/**
 * AxisServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package axisservice;

    /**
     *  AxisServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class AxisServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public AxisServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public AxisServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for addArticle method
            * override this method for handling normal response from addArticle operation
            */
           public void receiveResultaddArticle(
                    axisservice.AxisServiceStub.AddArticleResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addArticle operation
           */
            public void receiveErroraddArticle(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getArticles method
            * override this method for handling normal response from getArticles operation
            */
           public void receiveResultgetArticles(
                    axisservice.AxisServiceStub.GetArticlesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getArticles operation
           */
            public void receiveErrorgetArticles(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getArticleContent method
            * override this method for handling normal response from getArticleContent operation
            */
           public void receiveResultgetArticleContent(
                    axisservice.AxisServiceStub.GetArticleContentResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getArticleContent operation
           */
            public void receiveErrorgetArticleContent(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for removeArticle method
            * override this method for handling normal response from removeArticle operation
            */
           public void receiveResultremoveArticle(
                    axisservice.AxisServiceStub.RemoveArticleResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from removeArticle operation
           */
            public void receiveErrorremoveArticle(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for setArticleContent method
            * override this method for handling normal response from setArticleContent operation
            */
           public void receiveResultsetArticleContent(
                    axisservice.AxisServiceStub.SetArticleContentResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from setArticleContent operation
           */
            public void receiveErrorsetArticleContent(java.lang.Exception e) {
            }
                


    }
    