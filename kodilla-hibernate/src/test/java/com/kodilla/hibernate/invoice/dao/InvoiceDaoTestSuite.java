package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private ItemDao itemDao;
    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    public void testInvoiceDaoSave() {
        // Given
        Product product1 = new Product("Butter");
        Product product2 = new Product("Egg");
        Product product3 = new Product("Bacon");
        Product product4 = new Product("Beer");
        Product product5 = new Product("Milk");

        Invoice invoice1 = new Invoice("2018/01/13/111");
        Invoice invoice = new Invoice("2018/02/28/314");

        Item item1 = new Item(product1, BigDecimal.valueOf(1.12), 1, invoice);
        Item item2 = new Item(product2, BigDecimal.valueOf(0.42), 12, invoice);
        Item item3 = new Item(product3, BigDecimal.valueOf(0.02173), 500, invoice);
        Item item4 = new Item(product4, BigDecimal.valueOf(4.12), 2, invoice);
        Item item5 = new Item(product5, BigDecimal.valueOf(2.87), 10, invoice);

        Item item6 = new Item(product5, BigDecimal.valueOf(2.87), 10, invoice1);
        // When
        productDao.save(product1);
        int productId1 = product1.getId();
        productDao.save(product2);
        int productId2 = product2.getId();
        productDao.save(product3);
        int productId3 = product3.getId();
        productDao.save(product4);
        int productId4 = product4.getId();
        productDao.save(product5);
        int productId5 = product5.getId();

        invoiceDao.save(invoice1);
        int invoiceId1 = invoice1.getId();
        invoiceDao.save(invoice);
        int invoiceId = invoice.getId();

        itemDao.save(item1);
        int itemId1 = item1.getId();
        itemDao.save(item2);
        int itemId2 = item2.getId();
        itemDao.save(item3);
        int itemId3 = item3.getId();
        itemDao.save(item4);
        int itemId4 = item4.getId();
        itemDao.save(item5);
        int itemId5 = item5.getId();
        itemDao.save(item6);
        int itemId6 = item6.getId();
        // Then
        Invoice invoiceFromDB = invoiceDao.findOne(invoiceId);
        Assert.assertEquals(5, itemDao.countByInvoice_Id(invoiceId));
        System.out.println("====> Should be 5 ===>: " + itemDao.countByInvoice_Id(invoiceId));
        Assert.assertEquals(1, itemDao.countByInvoice_Id(invoiceId1));
        System.out.println("====> Should be 1 ===>: " + itemDao.countByInvoice_Id(invoiceId1));
        Assert.assertEquals("2018/02/28/314", invoiceFromDB.getNumber());
        System.out.println("====>2018/02/28/314 =>: " + invoiceFromDB.getNumber());
        // CLeanUp
        try {
            itemDao.delete(itemId1);
            itemDao.delete(itemId2);
            itemDao.delete(itemId3);
            itemDao.delete(itemId4);
            itemDao.delete(itemId5);
            itemDao.delete(itemId6);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        try {
            productDao.delete(productId1);
            productDao.delete(productId2);
            productDao.delete(productId3);
            productDao.delete(productId4);
            productDao.delete(productId5);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        try {
            invoiceDao.delete(invoiceId);
            invoiceDao.delete(invoiceId1);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
