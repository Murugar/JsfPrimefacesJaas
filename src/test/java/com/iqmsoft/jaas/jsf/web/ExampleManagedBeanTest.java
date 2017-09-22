package com.iqmsoft.jaas.jsf.web;

import org.junit.Test;

import com.iqmsoft.jaas.jsf.web.ExampleManagedBean;

import java.security.DigestException;
import java.security.MessageDigest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ExampleManagedBeanTest {

    private ExampleManagedBean exampleManagedBean = new ExampleManagedBean();

    @Test
    public void getExampleProperty__should_have_a_default_value() {
        // given
        // initial values
        // when
        String examplePropertyInitialValue = exampleManagedBean.getExampleProperty();
        // then
        assertThat(examplePropertyInitialValue, is("Property Value"));
    }

    @Test
    public void exampleAction__should_change_exampleProperty() {
        // given
        // initial values
        String examplePropertyInitialValue = exampleManagedBean.getExampleProperty();
        // when
        exampleManagedBean.exampleAction();
        // then
        String examplePropertyAfterAction = exampleManagedBean.getExampleProperty();
        assertThat(examplePropertyAfterAction, is(examplePropertyInitialValue+"######0"));
    }

    @Test
    public void testSHA256() throws Exception {
        String password= "123";
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(password.getBytes());

        byte byteData[] = md.digest();

        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }

        System.out.println("Hex format : " + sb.toString());

        //convert the byte to hex format method 2
        StringBuffer hexString = new StringBuffer();
        for (int i=0;i<byteData.length;i++) {
            String hex=Integer.toHexString(0xff & byteData[i]);
            if(hex.length()==1) hexString.append('0');
            hexString.append(hex);
        }
        System.out.println("Hex format : " + hexString.toString());
    }
}
