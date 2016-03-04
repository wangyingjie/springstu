package com.jd.jmi.order.canal.servlet;

import com.alibaba.fastjson.JSON;
import com.jd.jmi.order.canal.common.utils.CanalZkStatusUtil;
import com.jd.jmi.order.canal.model.CanalClientNode;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class CanalStatusServlet extends HttpServlet {

    /**
     * 将canal的运行状况输出
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String token = request.getParameter("token");
        if(token ==null || !token.equals(CanalZkStatusUtil.getToken())){
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        response.setContentType("application/json; charset=UTF-8");
        Map<String,CanalClientNode> nodes =  CanalZkStatusUtil.getCanalClientNodes();
        PrintWriter writer = response.getWriter();
        try {
            writer.write(JSON.toJSONString(nodes));
        }catch (Exception e){
        }finally {
            writer.close();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

}
