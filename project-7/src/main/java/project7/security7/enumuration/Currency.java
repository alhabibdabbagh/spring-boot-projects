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
}
