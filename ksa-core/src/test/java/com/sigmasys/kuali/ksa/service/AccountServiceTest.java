package com.sigmasys.kuali.ksa.service;


import com.sigmasys.kuali.ksa.model.*;
import com.sigmasys.kuali.ksa.jaxb.Ach;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kuali.rice.kim.api.identity.Person;
import org.kuali.rice.kim.api.identity.PersonService;
import org.kuali.rice.kim.api.services.KimApiServiceLocator;
import org.kuali.rice.ksb.api.KsbApiServiceLocator;
import org.kuali.rice.ksb.api.bus.Endpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import javax.xml.namespace.QName;
import java.math.BigDecimal;
import java.net.URL;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {ServiceTestSuite.TEST_KSA_CONTEXT})
public class AccountServiceTest extends AbstractServiceTest {


    @Autowired
    private AccountService accountService;

    @Before
    public void setUpWithinTransaction() {
        // set up test data within the transaction
        String userId = "admin";
        accountService.getOrCreateAccount(userId);
    }

    @Test
    public void getAccount() throws Exception {

        Account account = accountService.getOrCreateAccount("admin1");

        Assert.notNull(account);
        Assert.notNull(account.getEntityId());

        PersonService personService = KimApiServiceLocator.getPersonService();

        Assert.notNull(personService);

        Person person = personService.getPersonByPrincipalName("admin1");

        Assert.notNull(person);
        Assert.notNull(person.getEntityId());

        Assert.isTrue(account.getEntityId().equals(person.getEntityId()));

        // Add more assertions when we have some test data
    }

    @Test
    public void getFullAccount() throws Exception {

        Account account = accountService.getOrCreateAccount("admin1");

        Assert.notNull(account);
        Assert.notNull(account.getEntityId());

        account = accountService.getFullAccount(account.getId());

        Assert.notNull(account);

        Assert.notNull(account.getPersonNames());
        Assert.notNull(account.getPostalAddresses());
        Assert.notNull(account.getElectronicContacts());

        Assert.notEmpty(account.getPersonNames());
        Assert.notEmpty(account.getPostalAddresses());
        Assert.notEmpty(account.getElectronicContacts());

        Assert.notNull(account.getDefaultPersonName());
        Assert.notNull(account.getDefaultPostalAddress());
        Assert.notNull(account.getDefaultElectronicContact());

        // Add more assertions when we have some test data
    }

    @Test
    public void getFullAccounts() throws Exception {

        List<Account> accounts = accountService.getFullAccounts();

        Assert.notNull(accounts);
        Assert.notEmpty(accounts);

        for (Account account : accounts) {

            Assert.notNull(account);

            Assert.notNull(account.getPersonNames());
            Assert.notNull(account.getPostalAddresses());
            Assert.notNull(account.getElectronicContacts());

            Assert.notEmpty(account.getPersonNames());
            Assert.notEmpty(account.getPostalAddresses());
            Assert.notEmpty(account.getElectronicContacts());

            Assert.notNull(account.getDefaultPersonName());
            Assert.notNull(account.getDefaultPostalAddress());
            Assert.notNull(account.getDefaultElectronicContact());

        }

        // Add more assertions when we have some test data
    }

    @Test
    public void getDueBalance() {

        String userId = "admin";

        BigDecimal balanceDue = accountService.getDueBalance(userId, false);

        Assert.notNull(balanceDue);
        Assert.isTrue(balanceDue.compareTo(BigDecimal.ZERO) >= 0);

        logger.info("Due balance = " + balanceDue);

    }

    @Test
    public void rebalance() {

        String userId = "admin";

        List<Pair<Debit, BigDecimal>> amounts = accountService.rebalance(userId, false);

        Assert.notNull(amounts);

        for (Pair<Debit, BigDecimal> pair : amounts) {
            Assert.notNull(pair.getA());
            Assert.notNull(pair.getB());
            logger.info("Debit date = " + pair.getA().getEffectiveDate() + ", amount = " + pair.getB());
        }

    }

    @Test
    public void ageDebt() {

        String userId = "admin";

        ChargeableAccount account = (ChargeableAccount) accountService.getFullAccount(userId);

        Assert.notNull(account);

        logger.info("Amount Late1 Before = " + account.getAmountLate1());
        logger.info("Amount Late2 Before = " + account.getAmountLate2());
        logger.info("Amount Late3 Before = " + account.getAmountLate3());

        account = accountService.ageDebt(userId, false);

        Assert.notNull(account);
        Assert.notNull(account.getAmountLate1());
        Assert.notNull(account.getAmountLate2());
        Assert.notNull(account.getAmountLate3());

        logger.info("Amount Late1 After = " + account.getAmountLate1());
        logger.info("Amount Late2 After = " + account.getAmountLate2());
        logger.info("Amount Late3 After = " + account.getAmountLate3());

    }

    @Test
    public void ageAllDebts() {

            accountService.getFullAccount("admin");
            accountService.getFullAccount("user1");
            accountService.getFullAccount("dev1");

            accountService.ageDebt(false);

    }

    @Test
    public void getAccountKsb() {

        String userId = "admin";

        QName serviceName = new QName("http://sigmasys.com/ksa", "accountService");

        Endpoint endpoint = KsbApiServiceLocator.getServiceBus().getEndpoint(serviceName);

        Assert.notNull(endpoint);
        Assert.notNull(endpoint.getServiceConfiguration());

        URL endpointUrl = endpoint.getServiceConfiguration().getEndpointUrl();

        Assert.notNull(endpointUrl);

        logger.info("Endpoint URL = " + endpointUrl);

        AccountService service = (AccountService) KsbApiServiceLocator.getServiceBus().getService(serviceName);


        Assert.notNull(service);

        Account account = service.getFullAccount(userId);

        Assert.notNull(account);

    }

    @Test
    public void addPersonName() {

        String userId = "admin";

        PersonName personName = new PersonName();
        personName.setTitle("Mr.");
        personName.setFirstName("AdminFirst");
        personName.setMiddleName("AdminMiddle");
        personName.setLastName("AdminLast");
        personName.setDefault(true);

        personName = accountService.addPersonName(userId, personName);

        Assert.notNull(personName);
        Assert.notNull(personName.getId());

        Assert.isTrue("AdminFirst".equals(personName.getFirstName()));
        Assert.isTrue("AdminMiddle".equals(personName.getMiddleName()));
        Assert.isTrue("AdminLast".equals(personName.getLastName()));

        Assert.notNull(personName.isDefault());
        Assert.isTrue(personName.isDefault());

    }

    @Test
    public void addPostalAddress() {

        String userId = "admin";

        PostalAddress postalAddress = new PostalAddress();
        postalAddress.setCountry("Russia");
        postalAddress.setState("N/A");
        postalAddress.setCity("Saint Petersburg");
        postalAddress.setStreetAddress1("1917 Lenin avenue");
        postalAddress.setPostalCode("198330");
        postalAddress.setDefault(true);

        postalAddress = accountService.addPostalAddress(userId, postalAddress);

        Assert.notNull(postalAddress);
        Assert.notNull(postalAddress.getId());

        Assert.isTrue("Russia".equals(postalAddress.getCountry()));
        Assert.isTrue("N/A".equals(postalAddress.getState()));
        Assert.isTrue("Saint Petersburg".equals(postalAddress.getCity()));
        Assert.isTrue("1917 Lenin avenue".equals(postalAddress.getStreetAddress1()));
        Assert.isTrue("198330".equals(postalAddress.getPostalCode()));

        Assert.notNull(postalAddress.isDefault());
        Assert.isTrue(postalAddress.isDefault());

    }

    @Test
    public void addElectronicContact() {

        String userId = "admin";

        ElectronicContact contact = new ElectronicContact();
        contact.setPhoneCountry("7");
        contact.setPhoneNumber("812-378-56-47");
        contact.setEmailAddress("admin@yahoo.com");
        contact.setDefault(true);

        contact = accountService.addElectronicContact(userId, contact);

        Assert.notNull(contact);
        Assert.notNull(contact.getId());

        Assert.isTrue("7".equals(contact.getPhoneCountry()));
        Assert.isTrue("812-378-56-47".equals(contact.getPhoneNumber()));
        Assert.isTrue("admin@yahoo.com".equals(contact.getEmailAddress()));

        Assert.notNull(contact.isDefault());
        Assert.isTrue(contact.isDefault());

    }

    @Test
    public void getAch() {

        String userId = "user1";
        Ach ach =   accountService.getAch(userId);

        Assert.notNull(ach);

        Assert.isTrue("C".equals(ach.getAccountType()));
        Assert.isTrue("0019921".equals(ach.getRoutingNumber()));
        Assert.isTrue("20100020101".equals(ach.getAccountNumber()));
    }

}
