package by.itacademy.krysiuknikolay.web;

public class OnlinerPage {

    public static final String URL = "https://www.onliner.by/";
    public static final String COPYRIGHT_XPATH = "//div[@class='footer-style__copy']";
    public static final String COPYRIGHT_EXPECTED_TEXT = "© 2001—2023 Onlíner";
    public static final String BTN_AUTORIZATION_BASIC = "//div[@class='auth-bar__item auth-bar__item--text']";
    public static final String BTN_AUTORIZATION_NEW_PAGE = "//div[@class='auth-form__control auth-form__control_condensed-additional']/button[@type='submit']";
    public static final String FORM_HEADER_XPATH = "//div[@class='auth-form__title auth-form__title_big auth-form__title_condensed-default']";
    public static final String FORM_HEADER_EXPECTED_TEXT = "Вход";
    public static final String EMPTY_EMAIL_ERROR_XPATH = "//*[@id=\"auth-container\"]/div/div[2]/div/form/div[1]/div/div[2]/div/div/div[2]/div";
    public static final String EMPTY_EMAIL_ERROR_EXPECTED_TEXT = "Укажите ник или e-mail";
    public static final String EMPTY_PASWORD_ERROR_XPATH = "//*[@id=\"auth-container\"]/div/div[2]/div/form/div[2]/div/div/div[2]/div";
    public static final String EMPTY_PASWORD_ERROR_EXPECTED_TEXT = "Укажите пароль";

    public static final String LOGIN_ENTRY_WINDOW = "//input[@placeholder='Ник или e-mail']";
    public static final String PASSWORD_ENTRY_WINDOW = "//input[@type='password']";

}
