package com.lin.warehouse.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.lin.warehouse.dao.Mapper;
import com.lin.warehouse.dao.PersonalCustomMapper;
import com.lin.warehouse.domain.PersonalCustom;
import com.lin.warehouse.service.IPersonalCustomService;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

public class PersonalCustomServiceImpl extends BaseServiceImpl<PersonalCustom>
	implements IPersonalCustomService {
	
	public static final String ACTIVE_LINK = "http://localhost:8080/DDD/customActive";//邮件激活URL
	
	private PersonalCustomMapper personalCustomMapper;
	
	/**
	 * 邮件插件
	 */
	private JavaMailSender sender;

	public PersonalCustomMapper getPersonalCustomMapper() {
		return personalCustomMapper;
	}
	
	public void setPersonalCustomMapper(PersonalCustomMapper personalCustomMapper) {
		this.personalCustomMapper = personalCustomMapper;
	}
	
	public JavaMailSender getSender() {
		return sender;
	}

	public void setSender(JavaMailSender sender) {
		this.sender = sender;
	}

	public PersonalCustomServiceImpl(Mapper<PersonalCustom> mapper) {
		super(mapper);
		this.personalCustomMapper = (PersonalCustomMapper)mapper;
	}

	@Override
	public PersonalCustom login(String email, String password) {
		
		if(email != null && password != null && email.length() != 0 && password.length() != 0)
		{
			return personalCustomMapper.readByEmailAndPassword(email, password);
		}
		return null;
	}

	@Override
	public String register(PersonalCustom personalCustom) {
		
		if(personalCustom != null)
		{
			create(personalCustom);
			
			/**
			 * 向用户发送激活邮件
			 */
			try {
				System.out.println(personalCustom.getEmail());
				return sendMail(personalCustom.getEmail());
				
			} catch (MessagingException e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
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
		   //超链接参数type表示用户类型,1:个人用户	2:企业用户
		   String emailContent = "<html><head></head><body><h1>非常感谢您申请使用我们的仓储服务，您已经完成注册！！</h1>"
			   		+ "<h2>点击以下超链接激活账户以完成注册</h2><a href='"+ ACTIVE_LINK +"?email="+email+"&type=1'>点击该超链接激活您的账户</a><br/>"
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

	@Override
	public PersonalCustom active(String email) {
		System.out.println("active personal custom...");
		PersonalCustom personalCustom = personalCustomMapper.readByEmail(email);
		personalCustom.setActived(1);//激活
		System.out.println(personalCustom.toString());
		personalCustomMapper.update(personalCustom);
		
		return personalCustom;
	}
}
