package by.itacademy.krysiuknikolay.web;

public class AmazonPage {
    public static final String URL = "https://www.amazon.com/";
    public static final String COPYRIGHT_XPATH = "//span[text()='© 1996-2023, Amazon.com, Inc. or its affiliates']";
    public static final String COPYRIGHT_EXPECTED_TEXT = "© 1996-2023, Amazon.com, Inc. or its affiliates";
    public static final String BTN_CART = "//a[@href='/gp/cart/view.html?ref_=nav_cart']";
    public static final String BTN_SIGN_IN_TO_YOUR_ACCOUNT = "//*[@id='a-autoid-0-announce']/span";
    public static final String BTN_CONTINUE = "//input[@id='continue']";
    public static final String FORM_HEADER_TEXT_CART_IS_EMPTY_XPATH = "//div[@class='a-row sc-your-amazon-cart-is-empty']/h2";
    public static final String FORM_HEADER_TEXT_CART_IS_EMPTY_EXPECTED_TEXT = "Your Amazon Cart is empty";
    public static final String FORM_HEADER_TEXT_SIGN_IN_XPATH = "//h1[@class='a-spacing-small']";
    public static final String FORM_HEADER_TEXT_SIGN_IN_EXPECTED_TEXT = "Sign in";
    public static final String FORM_EMPTY_YOUR_EMAIL_XPATH = "//*[@id='auth-email-missing-alert']/div/div";
    public static final String FORM_EMPTY_YOUR_EMAIL_EXPECTED_TEXT = "Enter your email or mobile phone number";

}
