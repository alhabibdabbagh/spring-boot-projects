package project7.security7.enumuration;


public enum Currency {
    TRY("Türk lirası", "₺"),
    USD("Amerikan Doları", "$"),
    EUR("Euro", "€");
    private String title;
    private String logo;

    Currency(String title, String logo) {
        this.title = title;
        this.logo = logo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
