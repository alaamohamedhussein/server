package pojos;
// Generated May 21, 2016 12:50:38 PM by Hibernate Tools 4.3.1



/**
 * Portofolioiamges generated by hbm2java
 */
public class Portofolioiamges  implements java.io.Serializable {


     private Integer imageId;
     private Portofolioforuser portofolioforuser;
     private String portfolioImageUrl;

    public Portofolioiamges() {
    }

    public Portofolioiamges(Portofolioforuser portofolioforuser, String portfolioImageUrl) {
       this.portofolioforuser = portofolioforuser;
       this.portfolioImageUrl = portfolioImageUrl;
    }
   
    public Integer getImageId() {
        return this.imageId;
    }
    
    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }
    public Portofolioforuser getPortofolioforuser() {
        return this.portofolioforuser;
    }
    
    public void setPortofolioforuser(Portofolioforuser portofolioforuser) {
        this.portofolioforuser = portofolioforuser;
    }
    public String getPortfolioImageUrl() {
        return this.portfolioImageUrl;
    }
    
    public void setPortfolioImageUrl(String portfolioImageUrl) {
        this.portfolioImageUrl = portfolioImageUrl;
    }




}


