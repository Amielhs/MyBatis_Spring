package com.bdqn.mybatis.servlet;

import com.alibaba.fastjson.JSON;
import com.bdqn.mybatis.pojo.Bill;
import com.bdqn.mybatis.service.BillService;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/bill")
public class BillServlet extends HttpServlet {
    private static final long serialVersionUID = 9109265304619029819L;
    private Logger logger = Logger.getLogger(this.getClass());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ApplicationContext context = null;
        context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");

        BillService billService = (BillService) context.getBean("billService");
        List<Bill> billList = new ArrayList<Bill>();
        Bill bill = new Bill();
        bill.setIsPayment(2);
        bill.setProductName("油");
        bill.setProviderId(7);
        billList = billService.findBillByConditions(bill);

        for (Bill element : billList) {
            logger.debug("testGetBillList id: "
                    + element.getId()
                    + " and BillCode: "
                    + element.getBillCode()
                    + " and ProductName: "
                    + element.getProductName()
                    + " and ProviderName: "
                    + element.getProviderName()
                    + " and TotalPrice: "
                    + element.getTotalPrice()
                    + " and IsPayment: "
                    + element.getIsPayment()
                    + " and CreationDate:"
                    + new SimpleDateFormat("yyyy-MM-dd").format(element.getCreationDate()));
        }

        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("text/html;charset=utf-8");

        String responseStr = JSON.toJSONString(billList);
        Writer writer = response.getWriter();
        writer.write(responseStr);
        writer.flush();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
