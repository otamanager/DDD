package com.lin.warehouse.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.lin.warehouse.dao.CompanyCustomMapper;
import com.lin.warehouse.dao.Mapper;
import com.lin.warehouse.domain.CompanyCustom;
import com.lin.warehouse.service.ICompanyCustomService;

public class CompanyCustomServiceImpl extends BaseServiceImpl<CompanyCustom> implements ICompanyCustomService {

	public static final String ACTIVE_LINK = "http://localhost:8080/DDD/customActive";//邮件激活URL
	
	private CompanyCustomMapper companyCustomMapper;
	
	/**
	 * 邮件插件
	 */
	private JavaMailSender sender;
	
	public CompanyCustomServiceImpl(Mapper<CompanyCustom> mapper) {
		super(mapper);
		this.companyCustomMapper = (CompanyCustomMapper)mapper;
	}

	public CompanyCustomMapper getCompanyCustomMapper() {
		return companyCustomMapper;
	}

	public void setCompanyCustomMapper(CompanyCustomMapper companyCustomMapper) {
		this.companyCustomMapper = companyCustomMapper;
	}

	public JavaMailSender getSender() {
		return sender;
	}

	public void setSender(JavaMailSender sender) {
		this.sender = sender;
	}

	@Override
	public CompanyCustom login(String email, String password) {
		
		if(email != null && password != null && email.length() != 0 && password.length() != 0)
		{
			return companyCustomMapper.readByEmailAndPassword(email, password);
		}
		return null;
	}

	@Override
	public String register(CompanyCustom companyCustom) {
		
		if(companyCustom != null)
		{
			create(companyCustom);
			
			/**
			 * 向用户发送激活邮件
			 */
			try {
				System.out.println(companyCustom.getEmail());
				return sendMail(companyCustom.getEmail());
				
			} catch (MessagingException e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}

	@Override
	public CompanyCustom active(String email) {
		
		CompanyCustom companyCustom = companyCustomMapper.readByEmail(email);
		companyCustom.setActived(1);//激活
		companyCustomMapper.update(companyCustom);
		
		return companyCustom;
	}
	
	/**
	 * Spring 代理 Javamail 发送邮件
	 * @param email
	 * @throws MessagingException
	 */
	private String sendMail(String email) throws MessagingException {  

		  JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();  

		  MimeMessage mailMessage = senderImpl.createMimeMessage();  

		   //设置utf-8或GBK编码，否则邮件会有乱码  

		  MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage,true,"utf-8");  

		 try {  

		   messageHelper.setTo(email);//接受者     

		   messageHelper.setFrom("linsfile@163.com");//发送者  

		   messageHelper.setSubject("感谢使用 TOP™ 公司仓储服务");//主题  

		   //邮件内容，注意加参数true，表示启用html格式 
		   String sendTime = (new SimpleDateFormat("yyyy/MM/dd").format(new Date())).toString();
		   String emailContent = "<html><head></head><body><h1>非常感谢您申请使用我们的仓储服务，您已经完成注册！！</h1>"
			   		+ "<h2>点击以下超链接激活账户以完成注册</h2><a href='"+ ACTIVE_LINK +"?email="+email+"&type=2'>点击该超链接激活您的账户</a><br/>"
			   				+ "<span>温馨提示：请勿回复本邮件</span><p align='right'>TOP™ 公司&nbsp;&nbsp;"+sendTime+"</p></body></html>";

		   messageHelper.setText(emailContent,true);  

		   sender.send(mailMessage);  
		   
		   /**
		    * 获取邮箱类型
		    */
		   String emailType = email.substring(email.indexOf("@") + 1, email.indexOf("."));
		   
		   System.out.println("mail type:"+emailType);
		   
		   return emailType;
		   
		  } catch (Exception e) {  

			  e.printStackTrace();  
			  return null;
		  }  
	}
	
}
